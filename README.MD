# Burak Task for Pinsoft

This is a Spring Boot application that implements an RPN (Reverse Polish Notation) Calculator and a Minesweeper hint
generator. The application provides a Restful API for evaluating RPN expressions and generating hints for Minesweeper
grids.

## Table of Contents

## Coding Standards
- PMD
- Checkstyle
- SonarLint
- Unit tests coverage over 80% by supporting jacoco results

## Features

- **RPN Calculator**: Evaluate expressions in Reverse Polish Notation.
- **Minesweeper Hint Generator**: Generate hints based on Minesweeper grid inputs.

## Technologies Used

- Java 17
- Spring Boot 3.5
- Lombok
- SLF4J for logging
- Maven for dependency management

## Prerequisites

- Java 17 or later
- Maven 3.6 or later

## Installation

1. **Clone the repository**:

   ```bash
   git clone https://github.com/yourusername/burakTask.git
   cd burakTask
    ```
2. **Build the project**:
    ```bash
    mvn clean install

3. **Run the application**:

   ```bash
   mvn spring-boot:run
   ```

## Docker Installation

- **Build the Docker image**:
    ```bash
    docker build -t burak-task .
    ```
- **Run the Docker container**:
    ```bash
  docker run -p 8080:8080 --name burak-task-container burak-task
    ```
- **Stop the Docker container**:
    ```bash
  docker stop burak-task-container
    ```
- **Remove the Docker container**:
    ```bash
  docker rm burak-task-container
    ```

## Github Actions
- Github Actions is used for CI/CD. 
- When a push is made to the main branch, the project is built and tested.
- If the tests are successful, It will visualize test results.
- Jacoco results can be found in the link https://bv9306.github.io/burakTask/
## Endpoints

- RPN Calculator: /api/calculate
- Minesweeper Hint Generator: /api/show-hints

