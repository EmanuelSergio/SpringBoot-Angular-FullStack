# SpringBoot-Angular-FullStack Client Management System 🧑‍💼📊

Sistema full-stack para gerenciamento de clientes, com backend em Spring Boot e frontend em Angular. Inclui autenticação de usuários via JWT.

---

## Tecnologia Utilizada 🛠️

### Backend ☕
- Spring Boot 3.2.4 🌱
- Java 17 📜
- Banco de Dados: H2 in-memory 🗄️
- Segurança: Spring Security + JWT 🔐
- Build Tool: Maven ⚙️
- Bibliotecas adicionais:
  - Lombok (menos código boilerplate) 🧹
  - Hibernate Validator (validação) ✔️
  - Jackson (JSON) 📦

### Frontend 🖥️
- Angular 17.3.4 🔷
- Bootstrap 4.3.1 (responsividade) 📱💻
- Font Awesome 5.11.2 (ícones) ⭐
- JQuery (extras) 🎯

---

## Estrutura do Projeto 📂

```
project/
├── backend/                     
│   ├── src/main/java/io/github/emanuelSergio/clientes/
│   │   ├── config/              # Configurações
│   │   ├── controller/          # APIs REST
│   │   ├── model/               # Entidades e repositórios
│   │   ├── service/             # Lógica de negócio
│   │   └── ClientesApplication.java
│   └── resources/               # Propriedades, mensagens, chaves
│
├── clientes-app/                # Aplicação Angular
│   ├── src/app/
│   │   ├── layout/              # Componentes de layout
│   │   ├── template/            # Navbar, sidebar etc.
│   │   └── home/                # Página inicial
│   ├── assets/                  # Recursos estáticos
│   └── environments/            # Configurações por ambiente
```

---

## Funcionalidades ⭐

- Autenticação segura com JWT 🔐
- CRUD de clientes (criar, listar, editar, deletar) ✍️📋📝❌
- Validação de campos obrigatórios e CPF ✅
- Gerenciamento de serviços prestados aos clientes 🛠️
- Busca de serviços por nome do cliente e mês 🔎📅
- Interface responsiva com Bootstrap 📱
- Suporte a múltiplos idiomas para mensagens de erro 🌐

---

## Como Rodar ⚡

### Backend
```bash
cd backend
./mvnw clean install
./mvnw spring-boot:run
```
Servidor backend disponível em: `http://localhost:8080`

### Frontend
```bash
cd clientes-app
npm install
ng serve
```
Frontend disponível em: `http://localhost:4200`

---

## Endpoints da API 🔗

### Autenticação
- `POST /authenticate` — gera token JWT

### Clientes
- `GET /api/clientes` — listar clientes
- `GET /api/clientes/{id}` — buscar cliente por ID
- `POST /api/clientes` — criar cliente
- `PUT /api/clientes/{id}` — atualizar cliente
- `DELETE /api/clientes/{id}` — deletar cliente

### Serviços
- `POST /api/servicos-prestados` — cadastrar serviço
- `GET /api/servicos-prestados` — buscar serviços (filtros opcionais: nome, mês)

### Usuários
- `POST /users/register` — registrar novo usuário

---

## Autenticação JWT 🔐

1. Envie usuário e senha para `/authenticate`  
2. Receba e armazene o token JWT  
3. Inclua o token no header `Authorization` nas requisições protegidas

---

## Banco de Dados 🗄️

- H2 in-memory para desenvolvimento  
- Configurações no `application.properties`  
- Console H2 disponível em `/h2-console` durante a execução

---

## Desenvolvimento 🛠️

### Backend
- Maven para dependências e build  
- Spring Boot DevTools para reinício automático  
- Mensagens de erro em `messages.properties`

### Frontend
- Angular CLI para geração de componentes e serviços:  
```bash
ng generate component nome-componente
```
- Configurado para não gerar arquivos de teste automaticamente

---

## Build para Produção 🚀

### Backend
```bash
cd backend
./mvnw clean package
```
Arquivo JAR em `target/`.

### Frontend
```bash
cd clientes-app
ng build --configuration production
```
Build em `dist/clientes-app`.
