# Mashreq Assignment Automation Framework

## Installation Steps

1. **Prerequisites**:
   - Install Java Development Kit (JDK) 17 or higher.
   - Install Maven (ensure it is added to your system PATH).
   - Install an IDE (e.g., IntelliJ IDEA or Eclipse) for development.
   - Ensure a compatible browser (Chrome, Firefox, or Edge) is installed.

2. **Clone the Repository**:
   - Clone the project from the repository using:
     ```
     https://github.com/Ritesh351/AutomationCICD_Amazon.git
     ```
   - Alternatively, download the ZIP file and extract it.

3. **Configure Environment**:
   - Navigate to the project directory: `cd <project-folder>`.
   - Update the `config.properties` file in `src/main/resources/` with your Amazon login credentials and preferred browser settings.

4. **Install Dependencies**:
   - Run the following Maven command to download all dependencies:
     ```
     mvn clean install
     ```

5. **Run Tests**:
   - Execute the test suite using Maven:
     ```
     mvn test
     ```
   - This will run all tests and generate an Extent Report in the `Reports` folder.

## Running Specific Tests

- To run a specific test class (e.g., `AddToCartPageTest04`):
  ```
  mvn test -Dtest=AddToCartPageTest04
  ```

- View the generated report (`ExtentReport.html`) in the `Reports` folder to check test results.

## Notes
- Ensure the browser driver (e.g., ChromeDriver) is compatible with your browser version and is in the system PATH or specified in the project configuration.
- Screenshots for failed tests are saved in the `FailedScreenshots` folder.
- Logs are generated in the `logs` folder for debugging purposes.
