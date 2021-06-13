package com.msdassign.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransferPointsDTO {
    private String winnerUserId;
    private  String looserUserId;
    private Integer points2Transfer;
}
