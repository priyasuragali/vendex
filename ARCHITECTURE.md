# Vendex Architecture Overview

## System Architecture

Multi-tenant enterprise platform with the following components:

```
Client Layer (React, Mobile)
        ↓
API Gateway (Azure App Gateway)
        ↓
Backend Services (Spring Boot)
        ↓
Data Layer (PostgreSQL)
        ↓
External Services (UPI, Email, SMS)
```

## Multi-Tenant Architecture

**Database Level:**
- Single PostgreSQL database
- All tables include `tenant_id` column
- Row-level security ensures data isolation
- Row-level policies filter by `tenant_id`

**Application Level:**
- TenantContext (ThreadLocal) stores current tenant_id
- All services access context for automatic filtering
- JWT tokens include tenant information

## Authentication & Authorization Flow

```
1. Login → JWT Token (includes tenant_id)
2. Request → AuthFilter validates JWT
3. Extract tenant_id → Set TenantContext
4. Service → Auto-filters data by tenant_id
5. Response → Tenant-specific data only
```

## Payment Processing Flow

```
Create Draft → Request Approval → Risk Check → 
Approve/Reject → UPI Payment → Audit Log
```

## Service Layer

- AuthService - User authentication
- MerchantService - Business management
- StoreService - Location management
- UserService - Employee management
- PaymentService - Payment processing
- ApprovalService - Workflow management
- VendorService - Vendor registry
- NotificationService - Communications
- AuditService - Compliance logging
- ReportingService - Analytics

## Data Security

- AES-256 encryption for sensitive data at rest
- TLS 1.3 for data in transit
- Encryption keys in Azure Key Vault
- PII masking in logs
