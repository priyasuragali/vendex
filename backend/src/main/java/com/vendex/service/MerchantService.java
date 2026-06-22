package com.vendex.service;

import com.vendex.dto.MerchantDto;
import com.vendex.entity.Merchant;
import com.vendex.repository.MerchantRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class MerchantService {

    private final MerchantRepository merchantRepository;

    public List<MerchantDto> getMerchantsByTenant(Long tenantId) {
        log.info("Fetching merchants for tenant: {}", tenantId);
        return merchantRepository.findByTenantId(tenantId)
            .stream()
            .map(this::convertToDto)
            .collect(Collectors.toList());
    }

    public MerchantDto createMerchant(Long tenantId, MerchantDto dto) {
        log.info("Creating merchant for tenant: {}", tenantId);
        
        Merchant merchant = new Merchant();
        merchant.setTenantId(tenantId);
        merchant.setName(dto.getName());
        merchant.setEmail(dto.getEmail());
        merchant.setPhone(dto.getPhone());
        merchant.setStatus("ACTIVE");

        Merchant saved = merchantRepository.save(merchant);
        log.info("Merchant created: {}", saved.getId());

        return convertToDto(saved);
    }

    private MerchantDto convertToDto(Merchant merchant) {
        return new MerchantDto(
            merchant.getId(),
            merchant.getName(),
            merchant.getEmail(),
            merchant.getPhone(),
            merchant.getStatus()
        );
    }
}
