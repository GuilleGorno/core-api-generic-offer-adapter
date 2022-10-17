package com.wenance.coreapi.model;

import com.wenance.coreapi.v2.exception.UnknownBrandException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum Brand {

    WELP_AR,
    MANGO_AR,
    POSTA_AR,
    LUQUITAS_AR,
    WELP_ES,
    SNIP_ES,
    NAMO_ES,
    WELP_UY,
    WELP_AR_DIRIGIDOS,
    WELP_AR_OFFLINE,
    WELP_MX,
    ROBLES_AR,
    RESIMPLE_AR,
    WELP_PE,
    FINTYA_ES,
    WELP_UY_COMMERCE,
    WEN_AR,  // Credit Card
    WELP_ES_DIRIGIDOS,

    ;

    public static Brand of(String value) {
        return Arrays.stream(values())
                .filter(v -> v.name().equalsIgnoreCase(value))
                .findFirst()
                .orElseThrow(() -> new UnknownBrandException(value));
    }

    public static List<Brand> ofAr() {
        return Arrays.asList(WELP_AR, MANGO_AR, POSTA_AR, RESIMPLE_AR);
    }

    public static List<Brand> ofEs() {
        return Arrays.asList(FINTYA_ES, WELP_ES, NAMO_ES, SNIP_ES, WELP_ES_DIRIGIDOS);
    }

    public static List<Brand> ofMx() {
        return Collections.singletonList(WELP_MX);
    }

    public static List<Brand> ofPe() {
        return Collections.singletonList(WELP_PE);
    }

    public static List<Brand> ofUy() {
        return Collections.singletonList(WELP_UY);
    }

    public static List<Brand> all() {
        List<Brand> all = new ArrayList<>();
        all.addAll(allLoans());
        all.addAll(Arrays.asList(WELP_AR_DIRIGIDOS, WELP_AR_OFFLINE, WELP_UY_COMMERCE));

        return all;
    }

    public static List<Brand> allLoans() {
        List<Brand> all = new ArrayList<>();
        all.addAll(Brand.ofAr());
        all.addAll(Brand.ofEs());
        all.addAll(Brand.ofMx());
        all.addAll(Brand.ofPe());
        all.addAll(Brand.ofUy());

        return all;
    }

}
