# Authix

Egyszerű Spring Boot REST API JWT alapú hitelesítéssel.

## ✨ Funkciók
- Regisztráció (`/api/v1/auth/register`)
- Bejelentkezés (`/api/v1/auth/login`)
- Token alapú védelem
- Védett végpont: `/api/v1/users/me`
- Swagger UI dokumentáció

## 🔧 Technológiák
- Java 17  
- Spring Boot 3 (Web, Data JPA, Security, Validation)  
- MySQL  
- JWT (io.jsonwebtoken)  
- Lombok, Swagger/OpenAPI  

## 🚀 Futtatás
1. Hozz létre egy `authix` nevű MySQL adatbázist.  
2. Állítsd be a `src/main/resources/application.properties` fájlt (DB jelszó, JWT secret).  
3. Indítás:  
   ```bash
   mvn spring-boot:run

