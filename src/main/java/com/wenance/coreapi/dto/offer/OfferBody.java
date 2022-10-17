package com.wenance.coreapi.dto.offer;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

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
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class OfferBody implements Serializable {

	private static final long serialVersionUID = -1214418627583511295L;

	private String brand;

	private Date createdAt;

	private List<String> cross;

	private String dictamen;

	private boolean dictumNovelty;

	private String executionId;

	private String explanation;

	private String fiscalId;

	private InputVariables inputVariables;

	private Offer offer;

	private String reason;
}