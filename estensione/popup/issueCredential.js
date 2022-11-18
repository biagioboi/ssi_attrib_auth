	var form = document.getElementById("formSubmit");


	function setItem() {
	  console.log("OK");
	  window.location.href = 'showCredential.html';
	}

	function onError(error) {
	  console.log(error)
	}


	function issueCredential(json){

	}

	function submitForm(){
		//codice da postman
		
		var myHeaders = new Headers();
			myHeaders.append("Content-Type", "application/json");

		var raw = {
		  "comment": "I want this",
		  "credential_preview": {
		    "attributes": []
		  },
		  "filter": {
		    "dif": {},
		    "indy": {}
		  }
		};

		
		var form = document.getElementById("form");
		
		for(var i = 0; i<form.length-1; i++){
		//costruisco il json form[i].value
			var el = {
				"mime-type":"plain/text",
				"name":form[i].placeholder,
				"value":form[i].value
			};
			//console.log(el);
			raw.credential_preview.attributes.push(el);
		}
		
		var requestOptions = {
		  method: 'POST',
		  headers: myHeaders,
		  body: JSON.stringify(raw),
		  redirect: 'follow'
		};
		console.log(raw.credential_preview.attributes);
		
		var formDiv = document.getElementById("form");
		
		var load = document.getElementById("loader");
		load.style.display='block';
		formDiv.style.setProperty("display", "none", "important");
		
		fetch("http://localhost:8080/issueCredential", requestOptions)
		  .then(response =>{ 
		  	response.json();
		  	if(!response.ok){
		  		load.style.display='none';
					formDiv.style.setProperty("display", "block");
		  		throw `error with status ${response.status}`;
		    }

		  })
		  .then(result => {
		  	var issueCred = true;
		browser.storage.local.set({issueCred})
	  		.then(setItem, onError);
		  	
		  })
		  .catch(error => {
		  	console.log('error', error);
		  	load.style.display='none';
			formDiv.style.setProperty("display", "block");
		  
		  });
		
	}

	async function createForm(){

	//recupero lo schema dal local storage	
		
		var array = await browser.storage.local.get("attributes");
		console.log(array);
		for(var i=0; i<array.attributes.length; i++){
			
			var formDiv = document.getElementById("formDiv");
			var div = document.createElement("div");
			div.classList.add("form-outline","mb-3");

			var input = document.createElement("input");
			input.classList.add("form-control","form-control");
			if(array.attributes[i] === "password"){
				input.setAttribute('type', "password");
			}
			input.setAttribute('placeholder', array.attributes[i]);
			
			div.appendChild(input);
			formDiv.appendChild(div);
		}

	}

	async function addEvents(){
		
		var value = await browser.storage.local.get("issueCred");
		if(value.issueCred === true){
			window.location.href = 'showCredential.html';
		}

		form.addEventListener("click", submitForm);
		createForm();
	}

	addEvents();
