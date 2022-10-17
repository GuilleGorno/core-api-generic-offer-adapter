package com.wenance.coreapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wenance.coreapi.v2.exception.UnknownSectionException;

import java.util.Arrays;

public enum Section {
    @JsonProperty("contact_info") CONTACT_INFO,
    @JsonProperty("personal_info") PERSONAL_INFO,
    @JsonProperty("operations") OPERATIONS,
    @JsonProperty("payment_method") PAYMENT_METHOD,
    @JsonProperty("offer") OFFER,
    @JsonProperty("bank_info") BANK_INFO,
    @JsonProperty("risk_scoring") RISK_SCORING,
    @JsonProperty("origination") ORIGINATION,
    @JsonProperty("audit") AUDIT,
    @JsonProperty("control") CONTROL,
    @JsonProperty("application_form") APPLICATION_FORM,
    @JsonProperty("contract") CONTRACT,
    @JsonProperty("signature") SIGNATURE,
    @JsonProperty("attachments") ATTACHMENTS,
    @JsonProperty("business_step") BUSINESS_STEP,
    @JsonProperty("salesforce") SALESFORCE,
    @JsonProperty("mambu") MAMBU,
    @JsonProperty("disbursement") DISBURSEMENT,
    @JsonProperty("identity_validation") IDENTITY_VALIDATION,
    @JsonProperty("prefilter") PREFILTER,
    @JsonProperty("card_info") CARD_INFO,
    @JsonProperty("flow") FLOW,
    @JsonProperty("redirect_data") REDIRECT_DATA,
    @JsonProperty(value = "fraud_control") FRAUD_CONTROL;

    public static Section of(String value) {
        return Arrays.stream(values())
                .filter(v -> v.name().equalsIgnoreCase(value))
                .findFirst()
                .orElseThrow(() -> new UnknownSectionException(value));
    }

}
