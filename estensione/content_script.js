window.addEventListener("message", (event) => { // Only accept messages from the same frame 

  if (event.source !== window) { 

    return; 

  }


  var message = event.data;

  console.log(message.source);


  // Only accept messages that we know are ours 

  if (typeof message !== "object" || message === null || !!message.source && message.source !== "ssi") { 

    return; 

  } 
	let myPort = browser.runtime.connect({name:"port-from-cs"});
	console.log(myPort);
	myPort.postMessage(message.source);
  //browser.runtime.sendMessage(message); 

});
