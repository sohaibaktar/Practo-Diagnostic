# Practo-Diagnostic

<p align="center" width="80%">
<img src="https://github.com/sohaibaktar/Practo-Diagnostic/assets/65004690/161e79bf-975d-4241-a8e3-0e0478ae2a8d" style="width: 40%; min-width: 300px; display: block; margin: auto;">
</p>

Practo-Diagnostic is a Full Stack Web Application designed for placing diagnostic test orders based on doctor prescriptions. This project emphasizes seamless communication between patients, and diagnostic centers.

## Table of Contents

- [Introduction](#practo-diagnostic)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Getting Started](#getting-started)
- [Configuration](#configuration)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)
- [Acknowledgments](#acknowledgments)

## Features

- **Patient Management:**
  - Users can register as patients, providing necessary information.
  - Patient profiles are managed through CRUD operations.

- **Order Placement:**
  - Diagnostic tests can be ordered based on uploaded doctor prescriptions.
  - CRUD operations ensure efficient management of orders.

## Technologies Used

- **SpringBoot:** The backbone of the application, facilitating rapid development of robust and scalable RESTful APIs.
- **Database:** Utilizing a *PosrGreSQl* for persistent storage of patient and order information.
- **Authentication and Authorization:** Implementing secure access controls to protect sensitive patient data.
- **Testing:** Rigorous unit and integration testing to ensure reliability.

## Getting Started

Follow these steps to set up and run Practo-Diagnostic on your local machine.

1. **Clone the Repository:**
   ```bash
   git clone https://github.com/sohaibaktar/Practo-Diagnostic.git
2. **Build the Project:**
   ```bash
   cd Practo-Diagnostic
   ./mvnw clean install
3. **Run the Application:**
   ```bash
   ./mvnw spring-boot:run

4. **Access the Application:**
Open a web browser and go to http://localhost:8080

## Configuration

To customize the Practo-Diagnostic application, you can modify the configuration files in the `src/main/resources` directory. These files contain settings for the database connection, security, and other parameters.

To configure the database connection, edit the `application.properties` file. You will need to specify the following information:

* `spring.datasource.url`: The URL of the database server.
* `spring.datasource.username`: The username for the database.
* `spring.datasource.password`: The password for the database.

To configure security, edit the `security.properties` file. You can enable or disable authentication and authorization, and configure the roles and permissions for different users.

You can also configure other parameters in the `application.properties` file, such as the logging level and the maximum file size for uploads.

## Contributing

We welcome contributions to Practo-Diagnostic! To contribute, please follow these steps:

1. Fork the repository.
2. Create a new branch for your feature or bug fix.
3. Make changes and commit them.
4. Push the changes to your fork.
5. Submit a pull request.

Please review the Contribution Guidelines before contributing.
