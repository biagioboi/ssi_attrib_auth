browser.runtime.sendMessage({popupOpen: true});

var form = document.getElementById("formSubmit");

function setItem() {
  console.log("OK");
  window.location.href = 'invitation.html';
  
}

function onError(error) {
  console.log(error)
}

function getConnection(){

	var requestOptions = {
  method: 'POST',
  redirect: 'follow'
};

fetch("http://localhost:8080/init", requestOptions)
  .then(response => {
  	response.json();
  	console.log(response);
  	if(!response.ok){
  		throw `error with status ${response.status}`;
    }
  })
  .then(result => {
  	console.log(result);
  	let connetti = true;
			browser.storage.local.set({connetti})
  			.then(setItem, onError);
  
  })
  .catch(error => console.log('error', error));
}


browser.storage.local.get("connetti").then((value)=>{
	if(value.connetti === true){
		window.location.href = 'invitation.html';
	}});
	
		
form.addEventListener("click", getConnection);