package com.vendex.repository;

import com.vendex.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {
    List<Store> findByTenantId(Long tenantId);
    List<Store> findByMerchantId(Long merchantId);
    Optional<Store> findByTenantIdAndId(Long tenantId, Long id);
}
