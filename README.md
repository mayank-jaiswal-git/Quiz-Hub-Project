# QuizHub Project

QuizHub is a full-stack web application designed to provide interactive quizzes and comprehensive study resources for learners. The project is built using Spring Boot for the backend and a custom HTML/CSS/JS frontend.

---

## Table of Contents

- [Features](#features)
- [Project Structure](#project-structure)
- [Frontend](#frontend)
- [Backend](#backend)
- [Database](#database)
- [Setup Instructions](#setup-instructions)
- [Configuration](#configuration)
- [Contributing](#contributing)
- [License](#license)

---
## Screenshots

Below are some screenshots of the QuizHub frontend:

### Home Page

![Home Page](https://github.com/user-attachments/assets/ecd35e4b-2385-43af-a52f-06ff487cd720)


---
### Quizzes Page

![Quizzes Page](https://github.com/user-attachments/assets/49eb6d4d-2b9e-4d4e-a9bf-2ecfc60ccf14)

---

### Quiz Page

![Quiz Page](https://github.com/user-attachments/assets/2a658193-5e3c-4397-8bbd-3a8d3b65a6c2)


---

### Result Page

![Result Page](https://github.com/user-attachments/assets/dc961de9-2262-466c-8392-423d15c68707)

---

### Notes Page

![Notes Page](https://github.com/user-attachments/assets/30c29fff-eddd-4f76-a35f-2fd762aaa1a8)

---

## Features

- User registration and login
- Interactive quizzes for Java, Python, JavaScript, .Net, and more
- Well-curated downloadable notes for each subject
- Contact form for user feedback and queries
- Responsive and user-friendly interface
- Admin functionality for quiz management (planned/optional)

---

## Project Structure

```
QuizHub/
│
├── README.md
├── QuizHub Frontend/
│   ├── QuizHub.Html/      # HTML files (Home, About Us, Contact Us, etc.)
│   ├── QuizHub.Css/       # CSS stylesheets
│   ├── QuizHub.Js/        # JavaScript files
│   ├── QuizHub-Images/    # Images and icons
│   └── QuizHub-Notes/     # Downloadable PDF notes
│
└── QuizHub_Project/       # Spring Boot backend
    ├── src/
    │   ├── main/
    │   │   ├── java/in/QuizHub/         # Java source code (controllers, entities, services, repositories)
    │   │   └── resources/               # application.properties, static files
    │   └── test/
    ├── pom.xml            # Maven configuration
    ├── .gitignore
    ├── .classpath
    ├── .project
    └── ...
```

---

## Frontend

- Built with HTML, CSS, and JavaScript (no framework)
- Located in the [`QuizHub Frontend`](QuizHub%20Frontend) folder
- Main pages:
  - `Home.html`: Landing page, quiz list, notes section
  - `About-UsQuiz.html`: About the platform
  - `Contct-UsQuiz.html`: Contact form
  - `RegisterQuiz.html`, `LoginQuiz.html`: Authentication
  - `ResultQuiz.html`: Quiz results
- Uses images from `QuizHub-Images` and notes from `QuizHub-Notes`
- JavaScript files handle quiz logic, authentication, and API calls

---

## Backend

- Spring Boot application in [`QuizHub_Project`](QuizHub_Project)
- RESTful APIs for quizzes, authentication, contact requests, etc.
- Main packages:
  - `Controllers`: API endpoints (e.g., [`JavaQuizQuestionsController`](QuizHub_Project/src/main/java/in/QuizHub/Controllers/JavaQuizQuestionsController.java))
  - `Entities`: JPA entities for quizzes, users, contact requests
  - `Repositories`: Spring Data JPA repositories
  - `Services`: Business logic
- Uses MySQL for data persistence (see [Database](#database))

---

## Database

- MySQL database named `quizhub_db`
- Connection details configured in [`application.properties`](QuizHub_Project/src/main/resources/application.properties)
- JPA/Hibernate handles schema creation and updates

---

## Setup Instructions

### Prerequisites

- Java 21+
- Maven
- MySQL

### Backend

1. Configure your MySQL database and update credentials in [`application.properties`](QuizHub_Project/src/main/resources/application.properties).
2. Navigate to `QuizHub_Project` and run:
   ```sh
   ./mvnw spring-boot:run
   ```
   or
   ```sh
   mvn spring-boot:run
   ```

### Frontend

1. Open `QuizHub Frontend` in your preferred web server or use Live Server in VS Code.
2. Access `QuizHub.Html/Home.html` in your browser.

---

## Configuration

- **Database:**  
  Edit `spring.datasource.*` properties in [`application.properties`](QuizHub_Project/src/main/resources/application.properties).
- **Mail:**  
  SMTP settings for contact form responses are also in `application.properties`.
- **CORS:**  
  Controllers use `@CrossOrigin(origins = "http://127.0.0.1:5501")` for local frontend-backend communication.

---

## Contributing

Pull requests are welcome! For major changes, please open an issue first to discuss what you would like to change.

---

## License

This project is for educational purposes.

---
