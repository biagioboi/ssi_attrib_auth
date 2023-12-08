var formSub = document.getElementById("formSubmit");
var addBtn = document.getElementById("add");

var count = 0;

function setItem() {
    console.log("OK");
    window.location.href = 'newInvitation.html';
}

function onError(error) {
    console.log(error)
}


function submitForm() {

    var myHeaders = new Headers();
    myHeaders.append("Content-Type", "application/json");

    var raw = {
        "attributes": []
    };

    //prendo input da form

    var form = document.getElementById("form");

    for (var i = 0; i < form.length - 1; i++) {
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

    var load = document.getElementById("loader");

    load.style.display = 'block';
    form.style.setProperty("display", "none", "important");
    addBtn.style.setProperty("display", "none", "important");
    console.log(requestOptions)
    fetch("http://localhost:8080/createSchema", requestOptions)
        .then(response => response.json())
        .then(result => {
            browser.storage.local.set({schema: result.schema_id})
            let test = {
                schema_id: result.schema_id,
                schema: {
                    ver: result.schema.ver,
                    id: result.schema.id,
                    name: result.schema.name,
                    version: result.schema.version,
                    attrNames: result.schema.attrNames
                },
                seqNo: result.seqNo
            }
            console.log(test)
            requestOptions = {
                method: 'POST',
                headers: myHeaders,
                body: JSON.stringify(test),
                redirect: 'follow'
            };
            console.log(requestOptions);
            return fetch("http://localhost:8080/credentialDefinition", requestOptions)
        })
        .then(results => {
            console.log(results);
            return results.json();
        })
        .then(resultss => {
            console.log(resultss);
            browser.storage.local.set({cred_def_id: resultss.credential_definition_id}).then(setItem, onError);
            var attributes = raw.attributes;
            browser.storage.local.set({attributes}).then(setItem, onError);
        })
        .catch(error => {
            console.log('error', error);
            load.style.display = 'none';
            form.style.setProperty("display", "flex", "important");
            addBtn.style.setProperty("display", "flex", "important");
        })
}

function addField() {
    count++;

    var formDiv = document.getElementById("formDiv");
    var div = document.createElement("div");
    div.classList.add("form-outline", "mb-3");

    var input = document.createElement("input");
    input.classList.add("form-control", "form-control");
    input.setAttribute('placeholder', 'campo ' + count);

    div.appendChild(input);
    formDiv.appendChild(div);

}

function onCleared() {
    console.log("OK");
}


async function addEvents() {

    var value = await browser.storage.local.get("schema");
    if (value.schema === true) {
        /*
        let clearStorage = browser.storage.local.clear();
        clearStorage.then(onCleared, onError);
        */


        window.location.href = 'newInvitation.html';
    }
    formSub.addEventListener("click", submitForm);
    addBtn.addEventListener("click", addField);
}

document.addEventListener("DOMContentLoaded", addEvents);
