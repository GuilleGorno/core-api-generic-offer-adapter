package com.wenance.coreapi.dto.offer;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

import java.io.Serializable;
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
public class Offer implements Serializable {

	private static final long serialVersionUID = 6446041206310171529L;

	private boolean allowFullOnboarding;

	private int amount;

	private int commission;

	private int commissionForInstallment;

	private int currentLoanBalance;

	private int currentLoanNextInstallmentAmount;

	private Documentation documentation;

	private String id;

	private int iva;

	private int maxAmount;

	private int minAmount;

	private String offerCloseDate;

	private List<OfferInstallment> offerInstallments;

	private List<String> paymentMethods;

	private int pendingCapital;

	private List<String> policyTags;

	private double previousRate;

	private String productAndVersion;

	private String productId;

	private String productName;

	private String productType;

	private List<Integer> quotas;

	private boolean requestDocumentation;

	private Requirements requirements;

	private String riskScoreId;
}