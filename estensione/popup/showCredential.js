async function createTable(){

var requestOptions = {
  method: 'GET',
  redirect: 'follow'
};

fetch("http://localhost:11001/credentials", requestOptions)
  .then(response => response.json())
  .then(result => {
  	console.log(result);
  	var table = document.getElementById("table");
	for(var i=0; i<result.results.length; i++){
	
		for (let key in result.results[i].attrs) {
		  let value = result.results[i].attrs[key];
		  

	
		
		
		var tr = document.createElement("tr");
	
		table.appendChild(tr);
		
		var td = document.createElement("td");
		tr.appendChild(td);
		
		
		
		var div = document.createElement("div");
		div.classList.add("d-flex","align-items-center");
		
		var div1 = document.createElement("div1");
		div1.classList.add("ms-3");
		
		
		td.appendChild(div);
		td.appendChild(div1);
		
		var p = document.createElement("p");
		p.classList.add("fw-bold","mb-0");
		
		p.innerText = key;
		
		div1.appendChild(p);
		div.appendChild(div1);
		
		var td1 = document.createElement("td");
	
	
		var p = document.createElement("p");
		p.classList.add("text-muted","mb-0");
		
		p.innerText = value;
		td1.appendChild(p);
		tr.appendChild(td1);
	}
	}
  
  
  
  })
  .catch(error => console.log('error', error));
	

	
	/*var array = await browser.storage.local.get("array");
	console.log(array);
	*/
	

}


createTable();
