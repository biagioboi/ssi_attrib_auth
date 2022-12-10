let portFromCS;

function setItem() {
  console.log("OK");

  
}

function onError(error) {
  console.log(error);
}

function connected(p) { 


  portFromCS = p;
  portFromCS.postMessage({greeting: "hi there content script!"});
  portFromCS.onMessage.addListener((m) => {
    
    var ssi = m;

    console.log(ssi);

	browser.storage.local.set({ssi})
  		.then(setItem, onError);
  });
}




browser.runtime.onConnect.addListener(connected);
