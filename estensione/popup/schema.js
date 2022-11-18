	var formSub = document.getElementById("formSubmit");
	var addBtn = document.getElementById("add");

	var count = 0;

	function setItem() {
	  console.log("OK");
	  window.location.href = 'issueCredential.html';
	}

	function onError(error) {
	  console.log(error)
	}


	function submitForm(){

		var myHeaders = new Headers();
		myHeaders.append("Content-Type", "application/json");

		var raw = {
			"attributes":[]
		};

		//prendo input da form
		
		var form = document.getElementById("form");
		
		for(var i = 0; i<form.length-1; i++){
		//costruisco il json form[i].value
			console.log(raw);
			raw.attributes.push(form[i].value);
		}
		//console.log(json.array);
		
		var requestOptions = {
		  method: 'POST',
		  headers: myHeaders,
		  body: JSON.stringify(raw),
		  redirect: 'follow'
		};
		console.log(raw.attributes);
		
		var load = document.getElementById("loader");
		
		load.style.display='block';
		form.style.setProperty("display", "none", "important");
		addBtn.style.setProperty("display", "none", "important");
		
		fetch("http://localhost:8080/createSchema", requestOptions)
		  .then(response => {
		  	response.json();
		  	if(!response.ok){
	  			throw `error with status ${response.status}`;
	    	}
		  })
		  .then(result => {
		  	console.log(result);
		  	
		  	var schema = true;
		
			browser.storage.local.set({schema})
		  		.then(setItem, onError);
		  	var attributes = raw.attributes;
		  	browser.storage.local.set({attributes})
	  			.then(setItem, onError);
		  })
		  .catch(error => {
		  	console.log('error', error);
		  	load.style.display='none';
			form.style.setProperty("display", "flex", "important");
			addBtn.style.setProperty("display", "flex", "important");
		  });
	}

	function addField(){
		count++;
		
		var formDiv = document.getElementById("formDiv");
		var div = document.createElement("div");
		div.classList.add("form-outline","mb-3");

		var input = document.createElement("input");
		input.classList.add("form-control","form-control");
		input.setAttribute('placeholder', 'campo '+count);
		
		div.appendChild(input);
		formDiv.appendChild(div);
		
	}

	async function addEvents(){

		var value = await browser.storage.local.get("schema");
		if(value.schema === true){
			window.location.href = 'issueCredential.html';
		}
		formSub.addEventListener("click", submitForm); 
		addBtn.addEventListener("click", addField); 
	}

	document.addEventListener("DOMContentLoaded",addEvents);
