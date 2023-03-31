var form = document.getElementById("formSubmit");

async function setItem() {
  console.log("OK");

  var schema = await browser.storage.local.get("schema");
  console.log(schema);
	console.log(await browser.storage.local.get("cred_def_id"));
  if(schema.schema === undefined){
  	window.location.href = 'schema.html';
  }else{
  	window.location.href = 'issueCredential.html';
  }
 	
}

function onError(error) {
  console.log(error)
}

function getInvitation(){
	var input = document.getElementById("form");


	var myHeaders = new Headers();
	myHeaders.append("Content-Type", "application/json");

	var raw = JSON.stringify({
	  "addr": input[0].value
	});

	console.log(raw);

	var requestOptions = {
	  method: 'POST',
	  headers: myHeaders,
	  body: raw,
	  redirect: 'follow'
	};

	fetch("http://localhost:8080/invitation", requestOptions)
  .then(response => {
  	response.json();
	  console.log(response);
  	if(!response.ok){
  		throw `error with status ${response.status}`;
    } else {

		let invitation = true;
		browser.storage.local.set({invitation})
			.then(setItem, onError);
	}
  })
  .catch(error => console.log('error', error));
}




async function addEvents(){
	var value = await browser.storage.local.get("invitation");
	var value1 = await browser.storage.local.get("schema");
	if(value.invitation === true && value1.schema === false){
		window.location.href = 'schema.html';
	}
	
}


addEvents();
form.addEventListener("click", getInvitation); 
