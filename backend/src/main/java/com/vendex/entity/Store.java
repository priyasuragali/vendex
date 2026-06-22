package com.vendex.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "stores", indexes = {
    @Index(name = "idx_store_tenant", columnList = "tenant_id"),
    @Index(name = "idx_store_merchant", columnList = "merchant_id")
})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Store {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "tenant_id", nullable = false)
    private Long tenantId;
    
    @Column(name = "merchant_id", nullable = false)
    private Long merchantId;
    
    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false)
    private String location;
    
    @Column(nullable = false)
    private String city;
    
    @Column(nullable = false)
    private String state;
    
    @Column(nullable = false)
    private String zipCode;
    
    @Column(nullable = false)
    private String status; // ACTIVE, INACTIVE
    
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }
    
    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
