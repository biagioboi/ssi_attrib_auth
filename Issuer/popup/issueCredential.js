var form = document.getElementById("formSubmit");


function setItem() {
    console.log("OK");
    window.location.href = 'showCredential.html';
}

function onError(error) {
    console.log(error)
}

async function getAttributes(schema_id) {

    var myHeaders = new Headers();
    myHeaders.append("Content-Type", "application/json");

    var requestOptions = {
        method: 'POST',
        redirect: 'follow',
        body: JSON.stringify({
            "schema_id": schema_id
        }),
        headers: myHeaders
    };

    fetch("http://localhost:8080/schema/attributesOfSchema", requestOptions)
        .then(response => response.json())
        .then(async result => {
            attributes = result.schema.attrNames;
            await browser.storage.local.set({attributes})
                .then(console.log("attributi settati"), onError);
        })
        .catch(error => console.log('error', error));

    return;
}

async function getSchemaId() {

    var myHeaders = new Headers();
    myHeaders.append("Content-Type", "application/json");

    var requestOptions = {
        method: 'POST',
        headers: myHeaders,
        redirect: 'follow'
    };

    fetch("http://localhost:8080/schemas/usable", requestOptions)
        .then(response => response.json())
        .then(async result => {
            /* Here we may use a <option> to shows all the available schemas, but for the moment we get the first since
            we do not support multiple schema definition we use only one schema */
            var schema_id = result.schema_ids[0];
            await getAttributes(schema_id);
        })
        .catch(error => console.log('error', error));

}

async function submitForm() {

    var addr = await browser.storage.local.get("addr");
    var myHeaders = new Headers();
    myHeaders.append("Content-Type", "application/json");
    var schema = await browser.storage.local.get("schema")

    let cred_def_id = (await browser.storage.local.get("cred_def_id")).cred_def_id;
    let schema_id = (await browser.storage.local.get("schema")).schema;
    var raw = {
        "comment": "I want this",
        "credential_preview": {
            "attributes": []
        },
        "filter": {
            "indy": {
                "cred_def_id": cred_def_id,
                "issuer_did": "",
                "schema_id": schema_id,
                "schema_issuer_did": "",
                "schema_name": "",
                "schema_version": ""
            }
        }
    };


    var form = document.getElementById("form");


    for (var i = 0; i < form.length - 1; i++) {
        var el = {
            "mime-type": "plain/text",
            "name": form[i].placeholder,
            "value": form[i].value
        };
        //console.log(el);
        raw.credential_preview.attributes.push(el);
    }

    console.log("miadueo");

    var requestOptions = {
        method: 'POST',
        headers: myHeaders,
        body: JSON.stringify(raw),
        redirect: 'follow'
    };

    console.log(requestOptions.body);
    console.log(raw.credential_preview.attributes);

    var formDiv = document.getElementById("form");

    var load = document.getElementById("loader");
    load.style.display = 'block';
    formDiv.style.setProperty("display", "none", "important");

    console.log("testcds");
    fetch("http://localhost:8080/issueCredential", requestOptions)
        .then(response => {
            response.json();
            if (!response.ok) {
                load.style.display = 'none';
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
            load.style.display = 'none';
            formDiv.style.setProperty("display", "block");

        });

}

async function createForm() {
    await getSchemaId();
    var array = await browser.storage.local.get("attributes");
    for (var i = 0; i < array.attributes.length; i++) {

        var formDiv = document.getElementById("formDiv");
        var div = document.createElement("div");
        div.classList.add("form-outline", "mb-3");

        var input = document.createElement("input");
        input.classList.add("form-control", "form-control");
        if (array.attributes[i] === "password") {
            input.setAttribute('type', "password");
        }
        input.setAttribute('placeholder', array.attributes[i]);

        div.appendChild(input);
        formDiv.appendChild(div);
    }

}

async function addEvents() {

    form.addEventListener("click", submitForm);
    createForm();

}

addEvents();
