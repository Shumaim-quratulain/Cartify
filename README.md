<div align="center">

# 🛍️ Spring Boot E-Commerce REST API
### Enterprise-Grade Backend Architecture

[![Java](https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=java)](#)
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-brightgreen?style=for-the-badge&logo=spring-boot)](#)
[![Spring Security](https://img.shields.io/badge/Spring_Security-JWT-blue?style=for-the-badge&logo=spring-security)](#)
[![Hibernate](https://img.shields.io/badge/Hibernate-ORM-59666C?style=for-the-badge&logo=hibernate)](#)
[![MySQL](https://img.shields.io/badge/MySQL-Database-blue?style=for-the-badge&logo=mysql)](#)
[![AWS Elastic Beanstalk](https://img.shields.io/badge/AWS-Elastic_Beanstalk-FF9900?style=for-the-badge&logo=amazonaws)](#)
[![Postman](https://img.shields.io/badge/Postman-API_Testing-FF6C37?style=for-the-badge&logo=postman)](#)

*A comprehensive, fully-featured RESTful API designed to power modern digital storefronts. Engineered with security, scalability, and clean code principles at its core, and successfully deployed to the AWS Cloud.*

</div>

---

## 💻 Local Installation & Setup

### 1. Prerequisites
Ensure you have the following installed on your local machine:
* **Java Development Kit (JDK) 21**
* **Maven 3.x**
* **MySQL Server** (Running on default port `3306`)

### 2. Initialization

**Clone the repository:**
```bash
git clone [https://github.com/Shumaim-quratulain/sb-ecom.git](https://github.com/Shumaim-quratulain/sb-ecom.git)
cd sb-ecom
```

**Configure the Database:**
This project utilizes environment variables to protect sensitive credentials. You must provide these variables to your IDE's Run Configuration or terminal environment before starting the application:

```text
DB_URL=jdbc:mysql://localhost:3306/ecommerce_db?createDatabaseIfNotExist=true
DB_USERNAME=your_local_mysql_user
DB_PASSWORD=your_local_mysql_password
JWT_SECRET=your_generated_secret_key
```

**Build and Run (via Terminal):**
```bash
mvn clean install
mvn spring-boot:run
```
---

## ✨ Key Features & Capabilities

*   **🔒 Robust Authentication:** Stateless JSON Web Token (JWT) implementation with strictly enforced Role-Based Access Control (RBAC). Differentiates between `ROLE_USER` and `ROLE_ADMIN` privileges.
*   **🛒 Intelligent Shopping Cart:** Dynamic state management calculating totals, validating inventory, updating item quantities, and ensuring data consistency upon checkout.
*   **📦 Comprehensive Catalog Management:** Full CRUD operations for multi-tiered categories and products, featuring keyword search and pagination.
*   **📍 Multi-Address Profiles:** Users can manage multiple shipping addresses, allowing for seamless order routing.
*   **💳 Order Processing:** Transforms active cart sessions into permanent order snapshots, capturing historical pricing and shipping details.

---

## 🏗️ Technical Architecture

This application is built on a highly modular **N-Tier Architecture**, guaranteeing separation of concerns and maintainable code:

1.  **Presentation Layer (Controllers):** Handles incoming HTTP requests, validates input using `@Valid`, and returns standardized `ApiResponse` wrappers.
2.  **Business Logic Layer (Services):** Contains all core e-commerce logic, completely decoupled from the web layer.
3.  **Data Access Layer (Repositories):** Leverages **Spring Data JPA** and **Hibernate** to execute optimized SQL queries against the MySQL database.
4.  **Data Transfer Object (DTO) Pattern:** Uses **ModelMapper** to enforce a strict boundary between internal database entities and external JSON payloads.

### 🛑 Global Exception Handling
A centralized `@RestControllerAdvice` intercepts all application exceptions (e.g., `ResourceNotFoundException`, `APIException`) and formats them into clean, predictable JSON responses, preventing stack traces from leaking to the client.

---

## 🗄️ Database Schema Design

The relational database is meticulously structured to ensure data integrity across the e-commerce lifecycle.

| Entity Relationship | Type | Architectural Purpose |
| :--- | :--- | :--- |
| **User ↔ Role** | `Many-to-Many` | Establishes authorization tiers for endpoint protection. |
| **User ↔ Address** | `One-to-Many` | Maps multiple delivery locations to a single authenticated user. |
| **Category ↔ Product** | `One-to-Many` | Organizes the inventory into a logical, hierarchical structure. |
| **User ↔ Cart** | `One-to-One` | Binds a unique, active shopping session to a registered user. |
| **Cart ↔ CartItem** | `One-to-Many` | Tracks individual SKUs and aggregate quantities before checkout. |
| **Order ↔ OrderItem** | `One-to-Many` | Immutable snapshot of cart contents generated at the time of purchase. |

---

## 📸 Live API Showcases (Postman Proofs)

All endpoints have been rigorously tested against the live **AWS Elastic Beanstalk** environment. Below is the visual proof of successful interactions across all major API domains.

### 1. 🔐 Security & Authentication
> **Endpoint:** `POST /api/auth/signin`
> 
> *Successfully authenticates credentials and returns the JWT required for protected routes.*
> 
> ![Sign In](Images/API%20Request/Authentication/signin.png)

### 2. 📁 Category Management (Admin Operations)
> **Endpoint:** `POST /api/public/categories`
> 
> *Admin successfully creates a new product category in the system.*
> 
> ![Create Category](Images/API%20Request/Category/Create%20new%20Category.png)

### 3. 📦 Product Inventory
> **Endpoint:** `POST /api/admin/categories/{id}/product`
> 
> *Admin injects a new product entity mapped specifically to an existing category.*
> 
> ![Add Product](Images/API%20Request/Product/Add%20Product.png)
> 
> **Endpoint:** `PUT /api/admin/products/{id}`
> 
> *Demonstrates successful mutation of product details.*
> 
> ![Update Product](Images/API%20Request/Product/Update%20Product.png)

### 4. 🛒 Dynamic Shopping Cart
> **Endpoint:** `POST /api/carts/products/{id}/quantity/{qty}`
> 
> *Successfully adds a product to the authenticated user's active cart.*
> 
> ![Add to Cart](Images/API%20Request/Cart/Add%20Product%20To%20Cart.png)
> 
> **Endpoint:** `GET /api/carts/users/cart`
> 
> *Retrieves the aggregated cart data, including calculated totals and itemized lists.*
> 
> ![Get User Cart](Images/API%20Request/Cart/Get%20User%20Cart.png)

### 5. 📍 Address Profiles
> *Complete CRUD lifecycle for user shipping addresses.*
> 
> ![Create Address](Images/API%20Request/Addresses/create%20address.png)
> ![Get Address By ID](Images/API%20Request/Addresses/Get%20address%20By%20Id.png)
> ![Update Address](Images/API%20Request/Addresses/update%20address.png)
> ![Delete Address](Images/API%20Request/Addresses/delete%20address.png)

### 6. 💳 Order Processing
> **Endpoint:** `POST /api/order/users/payments/{method}`
> 
> *Successfully clears the active cart and generates an immutable Order record.*
> 
> ![Place Order](Images/API%20Request/Order/Place%20Order.png)

---

## 🌐 Complete API Reference

| Domain | HTTP Method | Route | Description | Access Required |
| :--- | :--- | :--- | :--- | :--- |
| **Auth** | `POST` | `/api/auth/signup` | Register a new user | Public |
| **Auth** | `POST` | `/api/auth/signin` | Authenticate user & generate JWT | Public |
| **Categories** | `GET` | `/api/public/categories` | Retrieve paginated categories | Public |
| **Categories** | `POST` | `/api/public/categories` | Create a new category | 🔒 Admin |
| **Products** | `GET` | `/api/public/products` | Retrieve all products (paginated) | Public |
| **Products** | `POST` | `/api/admin/categories/{id}/product` | Add product to category | 🔒 Admin |
| **Products** | `PUT` | `/api/admin/products/{id}` | Update product details | 🔒 Admin |
| **Cart** | `GET` | `/api/carts/users/cart` | Get active user's cart | 🔒 User |
| **Cart** | `POST` | `/api/carts/products/{id}/quantity/{qty}`| Add item to cart | 🔒 User |
| **Addresses** | `POST` | `/api/addresses` | Add a shipping address | 🔒 User |
| **Addresses** | `GET` | `/api/addresses/{id}` | Retrieve specific address | 🔒 User |
| **Orders** | `POST` | `/api/order/users/payments/{method}` | Place order from cart | 🔒 User |

---

## ☁️ Cloud Deployment (AWS Elastic Beanstalk)

This API was containerized and deployed to **AWS Elastic Beanstalk** using a Corretto 21 environment running on Amazon Linux 2023. 

**Security & Environment Configuration:**
*   Connected to a highly available **Amazon RDS MySQL** database.
*   Sensitive data (Database URLs, Passwords, and JWT Secrets) are strictly isolated from the source code. They are injected at runtime via Elastic Beanstalk **Environment Properties**.
*   Configured with `SERVER_PORT=5000` to properly map the EC2 Nginx reverse proxy to the internal Spring Boot Tomcat server.


---
<div align="center">
  <b>Architected and Developed by Shumaim Quratulain</b><br>
  <a href="https://github.com/Shumaim-quratulain">View GitHub Profile</a>
</div>


