# Workshare

Workshare is a website where people can share their project ideas. We built Workshare during the **Hack Your Portfolio Hackathon** by **MLH**.

![Home](./src/main/resources/readme/home_preview.png)

## Authors

- [@guettafa](https://www.github.com/guettafa)
- [@AchrafGroiez](https://github.com/AchrafGroiez)
- [@QuocDungTran380](https://github.com/QuocDungTran380)

## Important links

- [Devpost Submission](https://devpost.com/software/workshare-eyut9d)
- [Frontend](https://github.com/2GTM/workshare-frontend)

## Features

- Find projects by content and tags.
- Create a project idea.
- Login and register.

## Technologies

### Frontend

- Typescript
- React
- Next.js
- Axios
- MUI

### Backend

- Java
- Spring Boot
- Maven
- Lombok

## Installation
<!-- Dependencies -->
<details open><summary><b>External dependencies</b></summary>
<br />

- [nodejs](https://nodejs.org/en/download/prebuilt-installer)
- [MariaDB](https://mariadb.org/download/)
- [JDK 17](https://www.oracle.com/ca-en/java/technologies/downloads/#java17)

</details>

<!-- Frontend section -->
<details open><summary><b>Frontend</b></summary>
<br />

Setup :

```sh
git clone https://github.com/2GTM/workshare-frontend
cd workshare-frontend/
npm install
```

Create a file named `config.json` in the root directory with the following content :

```json
{
  "backendUrl" : "$BACKEND_URL"
}
```

</details>

<!-- Backend section -->
<details open><summary><b>Backend</b></summary>
<br />

Setup :

```sh
git clone https://github.com/2GTM/workshare-backend
cd workshare-backend
mvn install
```

Create a file named `env.properties` in the root directory with the following content :

```properties
# Server port
PORT=

# Database information
URL=jdbc:mariadb://localhost:3306/workshare
DB_USERNAME=
DB_PASSWORD=

# Frontend URL
ALLOWED_URL=

# Secret key for JWT.
SECRET_JWT_KEY=
```

</details>

## Run the project

```sh
# Frontend
npm run dev

# Backend
mvn spring-boot:run
```

## Preview

### Home

![Home](./src/main/resources/readme/home.png)

### Login

![Login](./src/main/resources/readme/login.png)

### Search project

![Search Project](./src/main/resources/readme/find_a_project.png)

### Create project

![Create Project](./src/main/resources/readme/create_project.png)

### Project view

![Project View](./src/main/resources/readme/project_[id].png)

### Trending

![Trending](./src/main/resources/readme/trending.png)

### User profile

![User Profile](./src/main/resources/readme/user_profil.png)
