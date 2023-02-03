package com.unisa;

import com.google.gson.Gson;
import com.unisa.connection.*;
import com.unisa.issue.*;
import com.unisa.schema.*;
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

    private String vonNetwork = "http://localhost:9000";
    private String aliceagent = "http://localhost:11000";
    //private String holderAgent = "http://localhost:11002";
    private String holderAgent = "";


    @PostMapping("/init")
    @ResponseStatus(HttpStatus.OK)
    public DidResponse registerDid() throws InterruptedException {
        Random r = new Random();
        String seed = "seed0000000000000000000";

        int max = 99999999;
        int min = 10000000;

        int randomValue = r.nextInt((max - min) + 1) + min;

        seed = seed + randomValue;

        DidRequest req = new DidRequest(seed, "TRUST_ANCHOR", null);
        ResponseEntity<DidResponse> responseEntity = restTemplate.postForEntity(vonNetwork
                + "/register", req, DidResponse.class);
        System.out.println(responseEntity);
//        Process p = null;
//        try {
//            p = Runtime.getRuntime().exec(new String[]{"/bin/sh", "-c", "/home/marco/Project/spring-boot-jwt-master/command.sh " + seed});
//
//            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
//            String line = null;
//            while ((line = reader.readLine()) != null) {
//                System.out.println(line);
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
////        p.wait();

        return responseEntity.getBody();

    }

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

    @RequestMapping("/invitation")
    @PostMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public InvitationDetails invitationTango(@RequestBody Addr addr) throws InterruptedException {
        System.out.println(holderAgent="http://"+addr.getAddr());

        ArrayList<String> handshakeProtocols = new ArrayList<>();
        handshakeProtocols.add("did:sov:BzCbsNYhMrjHiqZDTUASHg;spec/didexchange/1.0");
        InvitationRequest req = new InvitationRequest(handshakeProtocols, false);
        ResponseEntity<InvitationResponse> responseEntity = restTemplate.
                postForEntity(aliceagent
                        + "/out-of-band/create-invitation", req, InvitationResponse.class);

        System.out.println(responseEntity.getBody());

        String url = responseEntity
                .getBody()
                .getInvitation_url()
                .split("=")[1];
        String decodedInvitationString = new String(Base64.getDecoder().decode(url), StandardCharsets.UTF_8);

        Gson g = new Gson();
        DecodedInvitation decodedInvitation = g.fromJson(decodedInvitationString, DecodedInvitation.class);
        System.out.println(decodedInvitation);
        ResponseEntity<InvitationDetails> responseEntity1 = restTemplate.
                postForEntity(holderAgent
                        + "/out-of-band/receive-invitation", decodedInvitation, InvitationDetails.class);

        System.out.println(responseEntity1.getBody());


        String connBobId = responseEntity1.getBody().getConnection_id();
        ResponseEntity<InvitationDetails> responseEntity2 = restTemplate
                .postForEntity(holderAgent
                        + "/didexchange/" + connBobId + "/accept-invitation", null, InvitationDetails.class);

        System.out.println(responseEntity2);

        //Alice connId lo recupera effettuando una query a /credential

        String connAliceId = getConnectionId(aliceagent);
        System.out.println("Alice id " + connAliceId);

        long time = 100;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        timeUnit.sleep(time);

        //Alice accetta la connesione è conclude la "danza"
        ResponseEntity<InvitationDetails> responseEntity3 = restTemplate.postForEntity(aliceagent
                + "/didexchange/" + connAliceId + "/accept-request", null, InvitationDetails.class);

        return responseEntity3.getBody();

    }


    @PostMapping("/createSchema")
    @ResponseStatus(HttpStatus.OK)
    public CredentialDefinitionResonse createSchema(@RequestBody SchemaRequest schemaReq) {
        ArrayList<String> attributi = schemaReq.getAttributes();


        SchemaRequest req = new SchemaRequest(attributi, "my-schema", "1.0");
        ResponseEntity<SchemaResponse> responseEntity = restTemplate.postForEntity(aliceagent
                + "/schemas", req, SchemaResponse.class);

        String schemaId = responseEntity.getBody().getSchema_id();

        CredentialDefinitionRequest credReq = new CredentialDefinitionRequest(schemaId, "default");

        CredentialDefinitionResonse CredentialDefinitionResonse = restTemplate.postForEntity(aliceagent
                        + "/credential-definitions", credReq, CredentialDefinitionResonse.class)
                .getBody();

        return CredentialDefinitionResonse;
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
        holderAgent="http://"+issueReq.getAddr();
        System.out.println(holderAgent);

        ProposalRequest propReq = issueReq.getProposalRequest();

        //Bob richiede ad alice le credenziali
        long time = 500;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;



//        timeUnit.sleep(time);
        String connId = getConnectionId(holderAgent);
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
        ProposalResponse propResp = restTemplate.postForEntity(holderAgent
                        + "/issue-credential-2.0/send-proposal", propReq, ProposalResponse.class)
                .getBody();
        System.out.println(propReq);
        System.out.println(propResp);

        String bobCredExId = propResp.getCred_ex_id();
        timeUnit.sleep(time);
        String aliceCredExId = getCredExId(aliceagent);
        System.out.println("aliceCredExId " + aliceCredExId);

        //Alice risponde con un offer
        restTemplate.postForEntity(aliceagent
                + "/issue-credential-2.0/records/" + aliceCredExId + "/send-offer", null, CredeExRecord.class);


        timeUnit.sleep(time);
        //Bob richiede le credenziali
        System.out.println(restTemplate.postForEntity(holderAgent
                + "/issue-credential-2.0/records/" + bobCredExId + "/send-request", null, CredeExRecord.class));

        timeUnit.sleep(time);
        ProposalRequest request = new ProposalRequest();
        request.setComment("Prova");
        //Alice rilascia le credenziali
        System.out.println(restTemplate.postForEntity(aliceagent
                + "/issue-credential-2.0/records/" + aliceCredExId + "/issue", request, CredeExRecord.class));


        timeUnit.sleep(time);
        //Bob conserva le credenziali
//        System.out.println(restTemplate.postForEntity(bobAgent
//                + "/issue-credential-2.0/records/" + bobCredExId + "/store", null, CredeExRecord.class));
        return restTemplate.postForEntity(holderAgent
                + "/issue-credential-2.0/records/" + bobCredExId + "/store", null, CredeExRecord.class);
    }

    @RequestMapping("/retCredential")
    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Credential funzione() {
        Credential credential = restTemplate.getForEntity(holderAgent + "/credentials", CredentialList.class)
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
