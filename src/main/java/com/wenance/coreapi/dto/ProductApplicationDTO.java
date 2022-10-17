package com.wenance.coreapi.dto;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.wenance.coreapi.model.Brand;
import com.wenance.coreapi.model.Product;
import com.wenance.coreapi.model.Status;
import com.wenance.coreapi.util.ProductDeserializer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(NON_NULL)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ProductApplicationDTO {

    private String paId;
    @JsonDeserialize(using = ProductDeserializer.class)
    private Product product;
    private Brand brand;
    private Status status;

    private Map<Product, String> productRelations = new HashMap<>();
    private Map<String, Object> sections;

    private Date created;

    private Date lastModified;

    private int schemaVersion;

    public ProductApplicationDTO withPaId(String paid){
        this.paId = paid;
        return this;
    }

    public ProductApplicationDTO withProduct(Product product) {
        this.product = product;
        return this;
    }

    public ProductApplicationDTO withBrand(Brand brand) {
        this.brand = brand;
        return this;
    }

    public ProductApplicationDTO withCreated(Date created) {
        this.created = created;
        return this;
    }

    public ProductApplicationDTO withLastModified(Date lastModified) {
        this.lastModified = lastModified;
        return this;
    }

    public ProductApplicationDTO withSchemaVersion(int schemaVersion) {
        this.schemaVersion = schemaVersion;
        return this;
    }
}

