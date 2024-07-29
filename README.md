# Expense Sharing Application

## Description

This is a backend service for a daily expenses sharing application. The application allows users to add expenses and split them using different methods: equal amounts, exact amounts, and percentages. It also manages user details and provides downloadable balance sheets.

## Features

- **User Management**:
  - Create and retrieve user details.

- **Expense Management**:
  - Add expenses.
  - Split expenses using:
    - Equal amounts
    - Exact amounts
    - Percentages (ensure they add up to 100%)

- **Balance Sheet**:
  - Show individual and overall expenses.
  - Downloadable balance sheet.

## API Endpoints

### User Endpoints

- **Create User**: `POST /users`
- **Retrieve User Details**: `GET /users/{id}`

### Expense Endpoints

- **Add Expense**: `POST /expenses`
- **Retrieve Individual User Expenses**: `GET /expenses/user/{userId}`
- **Retrieve Overall Expenses**: `GET /expenses/overall`
- **Download Balance Sheet**: (To be implemented)

## Setup and Installation

1. **Clone the Repository**:

    ```bash
    git clone https://github.com/Hari1107/ConVin-Backend-Intern-Assignment.git
    cd ConVin-Backend-Intern-Assignment
    ```

2. **Install Dependencies**:

    Make sure you have [Maven](https://maven.apache.org/install.html) or [Gradle](https://gradle.org/install/) installed. Run:

    ```bash
    mvn install
    ```

    or

    ```bash
    gradle build
    ```

3. **Configure Database**:

    Update `src/main/resources/application.properties` with your database credentials.

4. **Run the Application**:

    ```bash
    mvn spring-boot:run
    ```

    or

    ```bash
    gradle bootRun
    ```

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
