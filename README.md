# NMovie 🎬
Egyszerű, de folyamatosan bővülő **REST API** filmek kezelésére Spring Boot alapokon.  
A projekt célja a modern backend technológiák gyakorlása és bemutatása.

---

## 🚀 Funkciók
- Új film létrehozása
- Filmek lekérdezése (összes, cím, év alapján)
- Film lekérdezése azonosító alapján
- Film soft delete funkcióval történő törlése
- Validáció és hibatűrő működés
- Swagger UI dokumentáció

---

## 🛠️ Technológiák
- **Java 17**
- **Spring Boot 3**
  - Spring Web
  - Spring Data JPA
  - Spring Validation
- **Hibernate** (ORM)
- **MySQL** (adatbázis)
- **Lombok** (boilerplate kód csökkentésére)
- **Swagger / OpenAPI** (API dokumentációhoz)
- **JUnit 5 & Mockito** (egységteszteléshez)

---

## 📂 Projekt szerkezet
- `controller` – REST végpontok
- `service` – üzleti logika
- `repository` – adatbázis elérés (JPA)
- `model` – entitások
- `dto` – adatátviteli objektumok (Request/Response)
- `mapper` – entitások és DTO-k közötti átalakítás
- `exception` – hibakezelés (globális handler)
- `resources` – konfiguráció (`application.properties`)

---
