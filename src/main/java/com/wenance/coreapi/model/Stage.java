package com.wenance.coreapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Stage {
    @JsonProperty("DATA_COLLECTION") DATA_COLLECTION,
    @JsonProperty("DATA_VALIDATION") DATA_VALIDATION,
    @JsonProperty("SIGNATURE") SIGNATURE,
    @JsonProperty("APPROVAL") APPROVAL,
    @JsonProperty("DISBURSEMENT") DISBURSEMENT,
    @JsonProperty("AMORTIZATION") AMORTIZATION,
    @JsonProperty("CLOSURE") CLOSURE
}
