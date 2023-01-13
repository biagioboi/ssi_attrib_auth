var form = document.getElementById("formSubmit");

function setItem() {
  console.log("OK");
  window.location.href = 'issueCredential.html';
}

function onError(error) {
  console.log(error)
}

function submitForm(){

	var form = document.getElementById("form");

	var addr = form[0].value;

	console.log(addr);

	browser.storage.local.set({addr})
	.then(setItem, onError);
	
}

async function getAddr(){
	var addr = await browser.storage.local.get("addr");
	console.log(addr.addr);
	if(addr.addr !== undefined){
		window.location.href = 'issueCredential.html';
	}
}

form.addEventListener("click", submitForm);

browser.storage.local.get("ssi").then((value)=>{

	if(value.ssi === "ssi"){
		window.location.href = 'ssi.html';
	}else{
		getAddr();
	}
});