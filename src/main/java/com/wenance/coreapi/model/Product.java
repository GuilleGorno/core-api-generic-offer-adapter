package com.wenance.coreapi.model;

import com.wenance.coreapi.v2.exception.UnknownProductException;

import java.util.Arrays;
import java.util.List;

public enum Product {

    LOAN,
    CELLPHONE_LOAN,
    MOTORBIKE_LOAN,
    ELECTRO,
    CREDIT_CARD
    ;

    public static Product of(String value) {
        return Arrays.stream(values())
                .filter(v -> v.name().equalsIgnoreCase(value))
                .findFirst()
                .orElseThrow(() -> new UnknownProductException(value));
    }

    public static List<Product> allNoLoans() {
        return Arrays.asList(
                CELLPHONE_LOAN,
                MOTORBIKE_LOAN,
                ELECTRO
//                CREDIT_CARD
        );
    }

    public static List<Product> all() {
        return Arrays.asList(
                LOAN,
                CELLPHONE_LOAN,
                MOTORBIKE_LOAN,
                ELECTRO,
                CREDIT_CARD
        );
    }

}
