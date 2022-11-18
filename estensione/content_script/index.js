var btn = document.getElementById("ssi");

function getConnection(){

window.postMessage({ source: "ssi"}, "*");
}


btn.addEventListener("click", getConnection);
