package com.dans.test.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TransactionDto {

    private String transactionFromAccount;
    private String transactionAmount;
    private String transactionDate;
    private String transactionType;
}
