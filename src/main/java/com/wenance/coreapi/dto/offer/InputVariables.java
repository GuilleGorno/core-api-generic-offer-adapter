package com.wenance.coreapi.dto.offer;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

import java.io.Serializable;

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
public class InputVariables implements Serializable {

	private static final long serialVersionUID = -2443569245573909074L;

	private String inputBirthdate;

	private String inputBrand;

	private String inputChannel;

	private String inputDocNumber;

	private String inputDocType;

	private String inputExecutionId;

	private String inputIban;

	private String inputJobType;

	private String inputLoanReason;

	private String inputMaritalStatus;

	private String inputMonthlyExpenses;

	private String inputName;

	private boolean inputNoBankreaderFlow;

	private String inputPaymentDate;

	private String inputSalary;

	private String inputSalaryValidated;

	private String inputSeniority;

	private String inputTypeOfHousing;

	private String inputUserAgent;

	private String inputZipcode;

	private String inputCorrelationId;
}