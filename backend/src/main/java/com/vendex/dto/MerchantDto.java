package com.vendex.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MerchantDto {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String status;
}
