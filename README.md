# 🛠️ Project Manager API

Este é um projeto backend completo para gerenciamento de projetos, desenvolvido **do zero** durante o curso [Java Backend 360°: Web Services API com Spring Boot e JPA](https://www.udemy.com/course/java-backend-360-web-services-api-com-spring-boot-e-jpa/), ministrado por **Carlos Tosin** na plataforma **Udemy**.

A aplicação foi construída utilizando **Spring Boot**, **JPA** e banco de dados **PostgreSQL**, com autenticação via **API Key** usando **Spring Security**.

---

## 📌 Funcionalidades Implementadas

- 📁 CRUD completo para **Projetos**
- ✅ CRUD de **Tarefas** vinculadas a projetos e responsáveis
- 👥 Gestão de **Membros** com associação a projetos
- 🔐 **Segurança com API Key** via Spring Security
- 🔄 Relacionamentos muitos-para-muitos e um-para-muitos com JPA
- 📦 Camadas bem definidas: Controller, Service, Repository, Domain
- 🚫 Validação, tratamento de erros e boas práticas REST

---

## 🧱 Modelo de Domínio

O sistema é composto por três entidades principais e dois enums que definem o status de projetos e tarefas.

![image](https://github.com/user-attachments/assets/110267de-c455-4380-8962-b6d8a7cbb98a)

### 🔸 `Project`
- `id`, `name`, `description`, `initialDate`, `finalDate`
- `status`: `PENDING`, `IN_PROGRESS`, `FINISHED`
- Relacionamentos:
  - `members`: muitos-para-muitos com `Member`
  - `tasks`: um-para-muitos com `Task`

### 🔸 `Member`
- `id`, `name`, `email`, `secret`, `deleted`
- Relacionamento: muitos-para-muitos com `Project`

### 🔸 `Task`
- `id`, `title`, `description`, `numberOfDays`
- `status`: `PENDING`, `IN_PROGRESS`, `FINISHED`
- Relacionamentos:
  - pertence a um `Project`
  - é atribuída a um `Member`

---

## 🔐 Segurança com API Key

A aplicação exige uma API Key para autenticação nas rotas protegidas.

### 📥 Envio da chave:

```http
Authorization: Api-Key SUACHAVEAQUI123
