# Self-Sorveign Identity (SSI) attribute based authentication

This repo contains the implementation of a SSI-compliant web server plus two firefox
extensions that simulate possible interactions with the server.
It's necessary that endpoint of Issuer extension is fixed into the configuration file; it's possible to do this
by changing the line on file config.env
```
    ISSUER_ENDPOINT = http://localhost:11000
```

Structure of the repo
```
    - Holder (Contains the Firefox extension that must be run by who wants to receive credentials)
    - Issuer (Contains the Firefox extension that must be run by who wants to issue credentials)
    - ssi_attrib_auth (Contains the code for the SSI-compliant web server)
```
The current work aims at show the basic interaction, only research experiment are possible and there is no guarantee on production.
Limitation of current implementation that will be addressed are:
- :x: Support for just one schema - there is no possibility to reuse a schema defined by some one else or to use a schema different from the first one retrieved. Work in progress...
- :x: Support for just one Holder - there is no possibility to manage multiple connections, the server handle just one connection per time. Work in progress...

As described in doc, the technology behind the SSI is the Hyperledger Aries, which is based on Hyperledger Indy. A valid solution for Indy is the <a href="https://github.com/bcgov/von-network">VON Network</a>, which is a portable development Indy Node network, offering an environment which contains a web-based interface containing the nodes and the public ledger; moreover it allows a user to see the status of the nodes of a network and browse/search/filter the Ledger Transactions.
Details on how to run this network can be found below.

A valid implementation, instead, for Hyperledger Aries, which communicate with the VON Network is implemented in Python, namely <a href="https://github.com/hyperledger/aries-cloudagent-python">Aca-Py</a>. In assumed that the agents run on the user machine and on the server machine reps.; SSI-compliant server is responsible for the communication with such agents and extensions using the parameters passed through the extension.
## Von Network


It's possible to install the Von Network for Hyperledger Aries using Docker
container or directly on local machine.
### Steps to follow to install Hyperledger Aries on Local Machine
1. Install Python and PIP manager -> https://www.python.org/downloads/
2. Clone the VON Network and navigate inside the directory.
    
    ```
    git clone https://github.com/bcgov/von-network.git
    cd von-network
    ```

3. Configure a virtual environment.
    ```
    virtualenv --python=python3.6 venv
    source venv/bin/activate
    ```
4. Install Python requirements.
    ```
    pip install -r server/requirements.txt
    ```

### Steps to follow to install Hyperledger Aries using Docker container
1. Execute Docker build
    ```
    ./manage build
    ```

2. Start VON Network
    ```
    ./manage start --logs
    ```

#### Once completed
To stop the Docker container ```./manage stop```, to clean the ledger ```./manage down```

# ACA-py
In order to test communication with Indy Ledger inside 
the Docker container and create instances we will use a Python 
script able to create a communication with the Ledger.

First of all it's important to remember that Indy Ledger 
is Permissioned ledger, so not everyone can create new DIDs.
Only Trust Anchors or Trustees can do this. So, if you want to add
a new DID (NYM transaction), you need to do it being a Trust Anchor 
or Trustee.

Indy Ledger Platform offers the possibility to authenticate a new DID
using web interface:

<img src="./screen/newdid_registration.png" alt="New DID Registration" style="width: 50%"/>

In our case, we proceed to register the seed `Alice000000000000000000076744495`

Once a DID is added to the Ledger, only the owner can modify it (for example rotate keys). 
The Trust Anchor that created this DID can not modify it anymore. 
This is one of the principles of Self Sovereign Identity (SSI).

So, we create a new "Entity" Alice, able to create new Verifiable Credentials, to do so after we registered a Seed using the interface of Hyperledger Aries; it's possible to execute the command.

```
docker run -p 8000:8000 -p 11000:11000 bcgovimages/aries-cloudagent:py36-1.16-1_0.8.0 start \
--label Alice \
-it http 0.0.0.0 8000 \
-ot http --admin 0.0.0.0 11000 \
--admin-insecure-mode \
--auto-accept-invites \
--auto-accept-requests \
--genesis-url http://host.docker.internal:9000/genesis \
--seed Alice000000000000000000076744495 \
--endpoint http://host.docker.internal:8000/ \
--debug-connections \
--auto-provision \
--wallet-type indy \
--wallet-name Alice1 \
--wallet-key secret
```

This will be our Issuer, namely Alice, able to emit VC for all the requesting Holder.
Let's do a request for new VC from the new user Bob.

First of all, we need to declare a new user, which will be able to connect to the Ledger.

```
docker run -p 8001:8001 -p 11001:11001 bcgovimages/aries-cloudagent:py36-1.16-1_0.8.0 start \
--label Bob \
-it http 0.0.0.0 8001 \
-ot http --admin 0.0.0.0 11001 \
--admin-insecure-mode \
--auto-accept-invites \
--auto-accept-requests \
--genesis-url http://host.docker.internal:9000/genesis \
--endpoint http://host.docker.internal:8001/ \
--debug-connections \
--auto-provision \
--wallet-local-did \
--wallet-type indy \
--wallet-name Bob1 \
--wallet-key secret
```

Notice that in this case, we do not defined the seed because we do not need to attach to any existing DID,
but, instead, we will ask to Alice to issue new VC.
Short recap: only Authorities need to attach them to new DID, since they need to be authorized.

It's possible to execute ACA-Py directly on local machine, but we discourage this approach.
More information are available https://github.com/hyperledger/aries-cloudagent-python

## Installazione estensione Firefox
1. Scaricare questa repo come Zip file
2. Estrarre il file 
3. Dalla pagina about:debugging cliccare su Questo firefox dal menu a sinistra
4. Cliccare componente aggiuntivo
5. Caricare il file manifest.json in estensione/manifest.json
