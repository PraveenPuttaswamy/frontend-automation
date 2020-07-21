# Test Automation

Boilerplate Project for Test automation with Maven and Extent report

**Features**
 - Multi module Maven Project Structure
 - Abstracted core WebDriver libraries
 - Selenium 4.0 and TestNG runner
 - Report Generation Extent Report 3.0
 - Multiple Soft Assertions in a test for more coverage
 - Capture Screenshots of failed assertions
 - Rest API Integration


## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

 - Install Java
 - Install Maven

 Note: This project is tested on Java v1.8.0_231 and Maven v10.15.4

### Running Tests

Clone Project and run the following command

```
mvn clean install -DskipTests && mvn clean install verify -Dtest=<tests> -Dbrowser=<browser> -Denv=<environment> -pl <moduleName>
```
**Example:**

*Run tests on Chrome*
```
 mvn clean install -DskipTests && mvn clean install verify -Dtest=com.app.smoketest.*Test -Dbrowser=chrome -Denv=QA -pl example-project
```
*Run tests headless on Chrome*
```
 mvn clean install -DskipTests && mvn clean install verify -Dtest=com.app.smoketest.*Test -Dbrowser=chrome -Denv=QA -Dheadless -pl example-project
```
*Run tests on Firefox*
```
 mvn clean install -DskipTests && mvn clean install verify -Dtest=com.app.smoketest.*Test -Dbrowser=firefox -Denv=QA -pl example-project
```
*Run tests headless on Firefox*
```
 mvn clean install -DskipTests && mvn clean install verify -Dtest=com.app.smoketest.*Test -Dbrowser=firefox -Denv=QA -Dheadless -pl example-project
```
Note:  Browser and Environment are case insensitive

### Test Report
Once the build is successful, test execution reports can be found at,
```
<module>/target/report/report.html
```
 **Example:**
 ```
example-project/target/report/report.html
```

### Break down on Project Structure and tests

This is a Multi Module Maven Project. The core module is shared by all other Modules/Projects as they are added.
Core module houses functionalities common to all other modules/projects
This Project is independent of the tests tagged in TestNG.xml. But you can do so by linking it in parent pom.xml

Every test development should end with asserting all assertion errors if thrown
```
instance.assertAll(errors);
```
Refer module *example-project* to find out more about adding new modules

### Debugging
For script development, I would recommend using IntelliJ.
Place a breakpoint and debug test!
While debugging, default environment is QA and browser is Chrome.

## Deployment

*Jenkins job command*
```
mvn clean install -DskipTests && mvn clean install verify -Dtest=<tests> -Dbrowser=<browser> -Denv=<environment> -pl <moduleName>
```
*Report Path*
```
<module>/target/report/report.html
```
