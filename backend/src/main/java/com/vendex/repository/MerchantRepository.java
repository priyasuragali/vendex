package com.vendex.repository;

import com.vendex.entity.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface MerchantRepository extends JpaRepository<Merchant, Long> {
    List<Merchant> findByTenantId(Long tenantId);
    Optional<Merchant> findByTenantIdAndId(Long tenantId, Long id);
    Optional<Merchant> findByEmail(String email);
}
