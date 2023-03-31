package com.unisa;

import com.google.gson.Gson;
import com.unisa.connection.*;
import com.unisa.issue.*;
import com.unisa.schema.*;
import com.unisa.schema.CreatedSchemaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Random;
import java.util.concurrent.TimeUnit;


@RestController
public class ConsumeWebService {

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    private PasswordEncoder bcryptEncoder;

    private String serverAgent = "http://localhost:11000";

    private String userAgent;



    public String getConnectionId(String url) {
        ConnectionsResponse connectionsResponse = restTemplate
                .getForEntity(url + "/connections", ConnectionsResponse.class)
                .getBody();

        assert connectionsResponse != null;
        String connId = connectionsResponse
                .getResults()
                .get(connectionsResponse.
                        getResults().
                        size() - 1).
                getConnection_id();
        return connId;
    }

    private String getPublicDid(String agent_endpoint) {
        TemplateForPublicDidResponse did_response = restTemplate
                .getForEntity(agent_endpoint + "/wallet/did/public", TemplateForPublicDidResponse.class)
                .getBody();
        return did_response.getResult().getDid();
    }

    @RequestMapping("/invitation")
    @PostMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public InvitationDetails invitationTango(@RequestBody Addr addr) throws InterruptedException {
        userAgent="http://"+addr.getAddr();


        ArrayList<String> handshakeProtocols = new ArrayList<>();
        handshakeProtocols.add("did:sov:BzCbsNYhMrjHiqZDTUASHg;spec/didexchange/1.0");
        InvitationRequest req = new InvitationRequest(handshakeProtocols, false);
        ResponseEntity<InvitationResponse> responseEntity = restTemplate.
                postForEntity(serverAgent
                        + "/out-of-band/create-invitation", req, InvitationResponse.class);

        String url = responseEntity
                .getBody()
                .getInvitation_url()
                .split("=")[1];
        String decodedInvitationString = new String(Base64.getDecoder().decode(url), StandardCharsets.UTF_8);

        Gson g = new Gson();
        DecodedInvitation decodedInvitation = g.fromJson(decodedInvitationString, DecodedInvitation.class);
        System.out.println(decodedInvitation);
        ResponseEntity<InvitationDetails> responseEntity1 = restTemplate.
                postForEntity(userAgent
                        + "/out-of-band/receive-invitation", decodedInvitation, InvitationDetails.class);


        return responseEntity1.getBody();

        /* Removed since it's been enabled the auto-connection, no need to exchange the did manually, it's done in automatic flavor */
        /*
        String connBobId = responseEntity1.getBody().getConnection_id();
        ResponseEntity<InvitationDetails> responseEntity2 = restTemplate
                .postForEntity(userAgent
                        + "/didexchange/" + connBobId + "/accept-invitation", null, InvitationDetails.class);


        String connAliceId = getConnectionId(serverAgent);

        long time = 100;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        timeUnit.sleep(time);

        // Alice accept the connection and close the dance
        ResponseEntity<InvitationDetails> responseEntity3 = restTemplate.postForEntity(serverAgent
                + "/didexchange/" + connAliceId + "/accept-request", null, InvitationDetails.class);
        return responseEntity3.getBody();*/

    }


    /** This end-point is needed for the schema creation, needed only when new schema is needed, maybe we can pass the
     * value of schema name and schema version from the Issuer plugin */
    @PostMapping("/createSchema")
    @ResponseStatus(HttpStatus.OK)
    public SchemaResponse createSchema(@RequestBody SchemaRequest schemaReq) {
        ArrayList<String> attributi = schemaReq.getAttributes();


        SchemaRequest req = new SchemaRequest(attributi, "my-schema", "15.6");
        ResponseEntity<SchemaResponse> responseEntity = restTemplate.postForEntity(serverAgent
                + "/schemas", req, SchemaResponse.class);


        return responseEntity.getBody();
    }

    @PostMapping("/credentialDefinition")
    @ResponseStatus(HttpStatus.OK)
    public CredentialDefinitionResonse credentialDefinition(@RequestBody SchemaResponse schema_res) {
        String schemaId = schema_res.getSchema_id();

        CredentialDefinitionRequest credReq = new CredentialDefinitionRequest(schemaId, "default");

        CredentialDefinitionResonse cred = restTemplate.postForEntity(serverAgent
                        + "/credential-definitions", credReq, CredentialDefinitionResonse.class)
                .getBody();

        return cred;
    }

    @RequestMapping("/schemas/usable")
    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public CreatedSchemaResponse usableSchema() {

        CreatedSchemaResponse created_schema_response = restTemplate.getForEntity(serverAgent
                        + "/schemas/created", CreatedSchemaResponse.class)
                .getBody();

        return created_schema_response;
    }
    @PostMapping("/schema/attributesOfSchema")
    @ResponseStatus(HttpStatus.OK)
    public SchemaResponseForAttributes usableSchemaWithAttributes(@RequestBody SchemaRequestForAttributes req_schema_id) {
        String schema_id = req_schema_id.getSchema_id();
        SchemaResponseForAttributes created_schema_response = restTemplate.getForEntity(serverAgent
                        + "/schemas/" + schema_id, SchemaResponseForAttributes.class)
                .getBody();

       return created_schema_response;
    }

    public String getCredExId(String url) {
        CredExIdResponse credExIdResponse = restTemplate
                .getForEntity(url + "/issue-credential-2.0/records", CredExIdResponse.class)
                .getBody();


        assert credExIdResponse != null;
        String credExId = credExIdResponse
                .getResults()
                .get(0).
                getCredential_exchange_id()
                .getCred_ex_id();
        return credExId;

    }


    @PostMapping("/issueCredential")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<CredeExRecord> issueCredential(@RequestBody IssueRequest issueReq) throws InterruptedException {

        /** Approach based on manual releasing of credentials, changed with automated flow **/
        /*
        userAgent="http://"+issueReq.getAddr();
        System.out.println(userAgent);


        ProposalRequest propReq = issueReq.getProposalRequest();

        //Bob richiede ad alice le credenziali
        long time = 500;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;



        //timeUnit.sleep(time);
        String connId = getConnectionId(userAgent);
        propReq.setConnection_id(connId);
        propReq.getCredential_preview().setType("issue-credential/2.0/credential-preview");

        System.out.println(propReq);

        String password = "";
        for(AttributeRequest a : propReq.getCredential_preview().getAttributes()){
            if (a.getName().equals("password")){
                password = a.getValue();
            }
        }
        //String password = propReq.getCredential_preview().getAttributes().get(1).getValue();
        //cript
        String passwordHashed = bcryptEncoder.encode(password);
        //propReq.getCredential_preview().getAttributes().get(2).setValue(passwordHashed);
        for(AttributeRequest a : propReq.getCredential_preview().getAttributes()){
            if (a.getName().equals("password")){
                a.setValue(passwordHashed);
            }
        }
//        timeUnit.sleep(time);
        ProposalResponse propResp = restTemplate.postForEntity(userAgent
                        + "/issue-credential-2.0/send-proposal", propReq, ProposalResponse.class)
                .getBody();
        System.out.println(propReq);
        System.out.println(propResp);

        String bobCredExId = propResp.getCred_ex_id();
        timeUnit.sleep(time);
        String aliceCredExId = getCredExId(serverAgent);
        System.out.println("aliceCredExId " + aliceCredExId);

        //Alice risponde con un offer
        restTemplate.postForEntity(serverAgent
                + "/issue-credential-2.0/records/" + aliceCredExId + "/send-offer", null, CredeExRecord.class);


        timeUnit.sleep(time);
        //Bob richiede le credenziali
        System.out.println(restTemplate.postForEntity(userAgent
                + "/issue-credential-2.0/records/" + bobCredExId + "/send-request", null, CredeExRecord.class));

        timeUnit.sleep(time);
        ProposalRequest request = new ProposalRequest();
        request.setComment("Prova");
        //Alice rilascia le credenziali
        System.out.println(restTemplate.postForEntity(serverAgent
                + "/issue-credential-2.0/records/" + aliceCredExId + "/issue", request, CredeExRecord.class));


        timeUnit.sleep(time);
        //Bob conserva le credenziali
//        System.out.println(restTemplate.postForEntity(bobAgent
//                + "/issue-credential-2.0/records/" + bobCredExId + "/store", null, CredeExRecord.class));
        return restTemplate.postForEntity(userAgent
                + "/issue-credential-2.0/records/" + bobCredExId + "/store", null, CredeExRecord.class);*/



        String connId = getConnectionId(serverAgent);
        issueReq.setConnection_id(connId);
        issueReq.getCredential_preview().setType("issue-credential/2.0/credential-preview");
        issueReq.setAuto_issue(true);
        issueReq.setAuto_remove(true);

        // Create the indy filter
        Indy i = issueReq.getFilter().getIndy();
        // We need to fill the field reserved to indy filter in order to validate the credentials
        // Cred def and Schema id are already defined into the request
        String public_did_server = getPublicDid(serverAgent);
        SchemaResponseForAttributes sel_schema = usableSchemaWithAttributes(new SchemaRequestForAttributes(i.getSchema_id()));
        i.setissuer_did(public_did_server);
        i.setSchema_issuer_did(public_did_server); // Valid only if the issuer of the schema is the same of the issuer of credentials, Since we're considering us as only issuer of the system it's ok
        i.setSchema_name(sel_schema.getSchema().getName());
        i.setSchema_version(sel_schema.getSchema().getVersion());

        // Now it's possible to proceed with the request, since it is an automated flow, the request will directly arrive to the user agent
       // restTemplate.postForEntity(userAgent
         //       + "/issue-credential-2.0/send", issueReq, CredeExRecord.class)
        System.out.println(issueReq);
return null;
    }

    @RequestMapping("/retCredential")
    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Credential funzione() {
        Credential credential = restTemplate.getForEntity(userAgent + "/credentials", CredentialList.class)
                .getBody()
                .getResults()
                .get(0);
        return credential;
    }



    @RequestMapping(value ="/admin")
    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @RolesAllowed("ROLE_ADMIN")
    public ModelAndView getAdminPage() throws Exception{

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin.html");
        return modelAndView;

    }




    @RequestMapping("/user")
    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @RolesAllowed("ROLE_USER")
    public ModelAndView getUserPage() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user.html");
        return modelAndView;
    }

}
