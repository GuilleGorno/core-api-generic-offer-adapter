package com.wenance.coreapi.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.wenance.coreapi.v1.exception.InvalidArgumentException;
import com.wenance.coreapi.model.Product;

import java.io.IOException;

public class ProductDeserializer extends JsonDeserializer<Product> {

    @Override
    public Product deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        Product product = null;

        try {
            switch (node.asText("").trim().toUpperCase()) {
                case "CELULARES":
                    product = Product.CELLPHONE_LOAN;
                    break;
                case "MOTOS":
                    product = Product.MOTORBIKE_LOAN;
                    break;
                case "PERSONALES":
                    product = Product.LOAN;
                    break;
                default:
                    product = Product.valueOf(node.asText().trim().toUpperCase());
                    break;
            }
        } catch (IllegalArgumentException e) {
            throw new InvalidArgumentException("Invalid Product type " + node.asText(""));
        }

        return product;
    }

}