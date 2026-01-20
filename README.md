# Cars Automation Framework

This repository contains the **API and UI automation framework** for the Cars project. The framework is built using **Java, Maven, Selenium, Rest Assured, and Cucumber**, following **OOP principles** and **clean architecture**.

---

## Table of Contents

* [Setup Instructions](#setup-instructions)
* [How to Run Tests Locally](#how-to-run-tests-locally)
* [Framework/Design Explanation](#frameworkdesign-explanation)
* [Shift-Left Observations](#shift-left-observations)
* [Test Strategy and Notes](#test-strategy-and-notes)

---

## Setup Instructions

1. **Prerequisites**

  * Java 17 JDK installed
  * Maven 3.9+ installed
  * Chrome browser installed (for UI tests)
  * Git installed
  * IDE (IntelliJ recommended)

2. **Clone the repository**

```bash
git clone https://github.com/<your-username>/cars-automation-framework.git
cd cars-automation-framework
```

3. **Install dependencies**

```bash
mvn clean install
```

4. **Configure environment properties**

* All configurable values are in `src/test/resources/config.properties`:

  * `web.url` → URL of the application
  * `web.browser` → Browser type (chrome, firefox)
  * API base URLs, timeouts, credentials, etc.

---

## How to Run Tests Locally

1. **Run API tests only**

```bash
mvn clean test -Papi-tests
```

2. **Run UI tests only (headless)**

```bash
mvn test -Pui-tests -Dheadless=true
```

3. **Run both profiles sequentially**

```bash
mvn clean test -Papi-tests,ui-tests
```

4. **Run a specific runner class**

```bash
mvn clean test -Dtest=ApiTestRunner
mvn clean test -Dtest=UiTestRunner
```

5. **Reports**

* Surefire reports: `target/surefire-reports/`
* Cucumber reports: `target/cucumber-reports/api` and `target/cucumber-reports/ui`

---

## Framework/Design Explanation

* **Language & Framework:** Java + Maven + Selenium + Rest Assured + Cucumber
* **Folder Structure:**

```
car-automation-framework/
 ├─ .github/workflows/   # CI pipeline (CI.yml)
 ├─ .idea/               # IDE configuration
 ├─ src/
 │   ├─ main/            # main classes
 │   └─ test/
 │       ├─ java/
 │       │   ├─ api/     # API test classes
 │       │   ├─ runner/  # Test runners
 │       │   ├─ ui/      # UI test classes
 │       │   └─ utils/   # Utility classes/helpers
 │       └─ resources/
 │           ├─ features/
 │           │   ├─ api/  # API feature files
 │           │   └─ ui/   # UI feature files
 │           └─ config.properties
 ├─ target/              # Test execution results
 ├─ .gitignore
 └─ Cars_Automation_README.md
```

* **Design principles:**

  * Page Object Model for UI
  * Clean separation of API and UI tests
  * Configurations externalized
  * Profiles in Maven to separate API/UI test execution
* **CI/CD integration:** GitHub Actions runs tests on `push` and `pull_request` events on `main` and `develop`.

---

## Shift-Left Observations

* Automated tests allow **early detection of defects** in both UI and API layers
* Helps developers **validate changes before code review**
* API tests act as **smoke tests** before UI tests, reducing manual regression
* CI pipeline ensures **tests run on every commit**, supporting shift-left quality practices

---

## Test Strategy and Notes

* **API Testing**

  * REST Assured used for HTTP requests
  * Validations include status codes, JSON schema, response content, and negative scenarios
  * Profiles used for selective execution

* **UI Testing**

  * Selenium WebDriver with Page Object Model
  * Tests are designed to be **headless** for CI
  * Includes positive, negative, and edge-case validations

* **Cucumber BDD**

  * Feature files separate positive and negative scenarios
  * Step definitions modularized for reusability

* **Reporting**

  * Surefire reports for Maven test results
  * Cucumber reports for human-readable HTML and JSON results
  * Artifacts uploaded in CI pipeline for traceability

* **Notes**

  * Tests designed to be **robust and maintainable**
  * Profiles and configuration make the framework **flexible for different environments**
  * Framework supports **easy addition of new test scenarios**

---

### Author

**Msizi Wiseman Mbeje** – QA Automation Engineer
