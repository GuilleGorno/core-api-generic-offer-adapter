package com.wenance.coreapi.model;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.wenance.coreapi.util.ProductDeserializer;
import com.wenance.coreapi.v1.exception.SectionNotFoundException;

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
public class ProductApplication {

    private String id;
    @JsonDeserialize(using = ProductDeserializer.class)
    private Product product;
    private Brand brand;
    private Stage stage;
    private Status status;

    private Map<Product, String> productRelations = new HashMap<>();
    private Map<Section, JsonNode> sections;

    public ProductApplication withSection(Section section, JsonNode data) {
        this.sections.put(section, data);
        return this;
    }

    public ProductApplication withSections(Map<Section, JsonNode> sections) {
        this.sections.putAll(sections);
        return this;
    }

    public ProductApplication withStage(Stage stage){
        this.stage = stage;
        return this;
    }

    public ProductApplication withId(String id){
        this.id = id;
        return this;
    }

    public ProductApplication withProduct(Product product) {
        this.product = product;
        return this;
    }

    public ProductApplication withBrand(Brand brand) {
        this.brand = brand;
        return this;
    }

    public ProductApplication withStatus(Status status) {
        this.status = status;
        return this;
    }

    public JsonNode getSection(Section section) {
        return Optional
                .ofNullable(this.sections.get(section))
                .orElseThrow(SectionNotFoundException::new);
    }

 }

