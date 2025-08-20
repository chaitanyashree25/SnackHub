# SnackHub — Online Food Ordering (Spring Boot)

SnackHub is a backend service for browsing menus, managing carts, placing orders, and tracking order status. It’s built with **Java + Spring Boot**, uses **RESTful APIs**, and is organized with a clean layered architecture suitable for interviews and real projects.

> Status: Initial scaffolding present; endpoints and docs are being added incrementally.

## ✨ Features (Planned / Implemented)
- Menu: categories, items, availability, pricing
- Cart: add/remove/update items, compute totals, promo hooks
- Orders: create order from cart, status flow (PLACED → CONFIRMED → OUT_FOR_DELIVERY → DELIVERED/CANCELLED)
- Users: customer accounts (JWT-ready), addresses
- Payments (mock): initiate, verify callbacks, idempotency keys
- Observability: centralized error format, request logging
- Profiles: `dev` (H2), `prod` (MySQL/Postgres)

## 🧱 Tech Stack
- **Java 17+**, **Spring Boot 3.x** (Web, Validation, Data JPA)
- **Database:** H2 (dev) / MySQL or PostgreSQL (prod)
- **Build:** Maven (`mvnw` wrapper included)
- **Tests:** JUnit 5, Mockito, Spring Boot Test
- (Optional) **Swagger/OpenAPI**, **Testcontainers**, **Lombok**
  
> The repository currently contains the standard Spring Boot Maven layout with `src/` and `pom.xml`. :contentReference[oaicite:1]{index=1}

## 📁 Suggested Project Structure
src/
├─ main/java/com/snackhub/
│ ├─ controller/
│ ├─ service/
│ ├─ repository/
│ ├─ model/ # Entities
│ ├─ dto/ # Request/Response models
│ ├─ mapper/ # (optional) MapStruct or manual mappers
│ └─ exception/ # GlobalExceptionHandler, ApiError
└─ main/resources/
├─ application.yml
├─ data.sql # (optional) seed data
└─ schema.sql # (optional)


## 🔌 API Design (Examples)
> Replace with the exact endpoints once your controllers are committed.

### Menu
- `GET /api/menu` — list items (filters: category, vegOnly, inStock)
- `POST /api/menu` — add item (admin)
- `PUT /api/menu/{id}` — update item
- `DELETE /api/menu/{id}` — delete/disable item

### Cart
- `GET /api/carts/{userId}` — get active cart
- `POST /api/carts/{userId}/items` — add item `{ itemId, qty }`
- `PATCH /api/carts/{userId}/items/{itemId}` — update qty
- `DELETE /api/carts/{userId}/items/{itemId}` — remove item

### Orders
- `POST /api/orders` — place order from cart `{ userId, addressId, paymentMode }`
- `GET /api/orders/{orderId}` — order details
- `PATCH /api/orders/{orderId}/status` — update status (admin/ops)

**Validation examples**
- `@NotNull`, `@Positive` for IDs and quantities  
- Price calculation done server-side; totals are not trusted from clients

## ⚙️ Getting Started

### Prerequisites
- Java 17+
- Maven 3.8+ (or use the included wrapper)

### Run (Dev: H2)
```bash
./mvnw spring-boot:run
