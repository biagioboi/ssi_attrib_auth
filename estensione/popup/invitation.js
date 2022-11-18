var form = document.getElementById("formSubmit");

function setItem() {
  console.log("OK");
 window.location.href = 'schema.html';
}

function onError(error) {
  console.log(error)
}


function getInvitation(){
	var requestOptions = {
  method: 'GET',
  redirect: 'follow'
};

fetch("http://localhost:8080/invitation", requestOptions)
  .then(response => {
  	response.json();
  	if(!response.ok){
  		throw `error with status ${response.status}`;
    }
  })
  .then(result => {
  	console.log(result);
  	let invitation = true;
	browser.storage.local.set({invitation})
  		.then(setItem, onError);
  	
  })
  .catch(error => console.log('error', error));
	
	
}


async function addEvents(){
	var value = await browser.storage.local.get("invitation");
	if(value.invitation === true){
		window.location.href = 'schema.html';
	}
	
}


addEvents();
form.addEventListener("click", getInvitation); 
