package com.unisa.issue;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CredeExRecord {
/*"auto_issue": false,
  "auto_offer": false,
  "auto_remove": false,
  "conn_id": "3fa85f64-5717-4562-b3fc-2c963f66afa6",
  "created_at": "2022-08-19 20:55:17Z",
  "cred_ex_id": "3fa85f64-5717-4562-b3fc-2c963f66afa6",
  "cred_id_stored": "3fa85f64-5717-4562-b3fc-2c963f66afa6",
  "cred_issue": {},
  "cred_offer": {},
  "cred_preview": {},
  "cred_proposal": {},
  "cred_request": {},
  "cred_request_metadata": {},
  "error_msg": "The front fell off",
  "initiator": "self",
  "parent_thread_id": "3fa85f64-5717-4562-b3fc-2c963f66afa6",
  "role": "issuer",
  "state": "done",
  "thread_id": "3fa85f64-5717-4562-b3fc-2c963f66afa6",
  "trace": true,
  "updated_at": "2022-08-19 20:55:17Z"*/
    @JsonProperty
    private String cred_ex_id;

    public CredeExRecord() {
    }

    public CredeExRecord(String cred_ex_id) {
        this.cred_ex_id = cred_ex_id;
    }

    public String getCred_ex_id() {
        return cred_ex_id;
    }

    public void setCred_ex_id(String cred_ex_id) {
        this.cred_ex_id = cred_ex_id;
    }

    @Override
    public String toString() {
        return "CredeExRecord{" +
                "cred_ex_id='" + cred_ex_id + '\'' +
                '}';
    }
}
