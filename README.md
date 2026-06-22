# Vendex - Enterprise Spend Management Platform

Vendex is a **multi-tenant enterprise spend management platform** designed to eliminate traditional employee reimbursement processes by enabling direct business expense payments through company-controlled virtual accounts.

## 🎯 Vision

To become India's most trusted enterprise spend management platform for multi-location businesses by enabling secure, real-time, policy-driven operational spending through banking-integrated digital infrastructure.

## 🚀 Key Features

- **Multi-Tenant Architecture** - Isolated data for multiple organizations
- **Merchant Onboarding** - Seamless business onboarding workflow
- **Store Management** - Multi-location store operations
- **User & Department Management** - Hierarchical user structure
- **Payment Intent Framework** - Smart payment processing
- **Vendor Management** - Vendor registry and compliance
- **UPI Payments** - Direct UPI-based transactions
- **Approval Engine** - Policy-driven approval workflows
- **Risk Framework** - Fraud detection and risk management
- **Real-Time Notifications** - Event-driven communication
- **Advanced Reporting** - Business intelligence dashboards
- **Audit Framework** - Complete audit trails
- **Security Framework** - Enterprise-grade security
- **Offline Capabilities** - Draft payments for offline scenarios

## 📋 Tech Stack

| Component | Technology |
|-----------|------------|
| **Frontend** | React 18 + TypeScript + Redux |
| **Backend** | Java 17 + Spring Boot 3 + Spring Cloud |
| **Database** | PostgreSQL 15 |
| **Authentication** | JWT + OAuth 2.0 |
| **API** | REST + WebSocket |
| **Infrastructure** | Azure (App Service, PostgreSQL, Key Vault) |
| **Container** | Docker + Kubernetes |
| **CI/CD** | GitHub Actions |
| **Monitoring** | Azure Monitor + Application Insights |

## 🏗️ Project Structure

```
vendex/
├── backend/                    # Java Spring Boot Application
│   ├── src/main/java/com/vendex/
│   ├── src/main/resources/
│   ├── pom.xml
│   └── Dockerfile
│
├── frontend/                   # React Application
│   ├── src/
│   ├── package.json
│   ├── tsconfig.json
│   └── Dockerfile
│
├── docker-compose.yml
├── .github/workflows/          # CI/CD pipelines
├── docs/                       # Documentation
└── scripts/                    # Deployment scripts
```

## 📚 Documentation

- [Architecture Overview](./ARCHITECTURE.md)
- [Database Schema](./docs/DATABASE.md)
- [Deployment Guide](./docs/DEPLOYMENT.md)

## 🔐 Security Features

- JWT-based authentication
- Role-Based Access Control (RBAC)
- End-to-end encryption for sensitive data
- Request signing for UPI transactions
- Comprehensive audit logging

## 🚀 Quick Start

**Using Docker:**
```bash
docker-compose up -d
```

Backend: `http://localhost:8080/api/v1`
Frontend: `http://localhost:3000`

---

**Built with ❤️ for Enterprise Spend Management**
