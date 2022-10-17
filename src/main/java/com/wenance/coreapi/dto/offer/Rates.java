package com.wenance.coreapi.dto.offer;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter; 

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(NON_NULL)
public class Rates implements Serializable {

	private static final long serialVersionUID = -6352933906274216474L;

	@JsonProperty("CFTEA") 
    private Rate cftea;

    @JsonProperty("CFTNA") 
    private Rate cftna;

    @JsonProperty("TEA") 
    private Rate tea;

    @JsonProperty("TEM") 
    private Rate tem;

    @JsonProperty("TNA") 
    private Rate tna;

    @JsonProperty("TPD") 
    private Rate tpd;
}