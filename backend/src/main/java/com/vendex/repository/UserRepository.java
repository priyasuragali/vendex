package com.vendex.repository;

import com.vendex.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByTenantIdAndEmail(Long tenantId, String email);
    List<User> findByTenantId(Long tenantId);
    List<User> findByStoreId(Long storeId);
    Optional<User> findByEmail(String email);
}
