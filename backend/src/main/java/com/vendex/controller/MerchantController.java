package com.vendex.controller;

import com.vendex.dto.MerchantDto;
import com.vendex.service.MerchantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/merchants")
@RequiredArgsConstructor
public class MerchantController {

    private final MerchantService merchantService;

    @GetMapping
    public ResponseEntity<List<MerchantDto>> getMerchants(
        @RequestHeader("X-Tenant-ID") Long tenantId) {
        List<MerchantDto> merchants = merchantService.getMerchantsByTenant(tenantId);
        return ResponseEntity.ok(merchants);
    }

    @PostMapping
    public ResponseEntity<MerchantDto> createMerchant(
        @RequestHeader("X-Tenant-ID") Long tenantId,
        @RequestBody MerchantDto dto) {
        MerchantDto created = merchantService.createMerchant(tenantId, dto);
        return ResponseEntity.ok(created);
    }
}
