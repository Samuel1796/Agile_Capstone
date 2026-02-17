# Agile Capstone – User Management Console App

A Java console application for user management with full CRUD operations, delivered using Agile and DevOps practices across two sprints.

[![CI](https://github.com/Samuel1796/Agile_Capstone/actions/workflows/ci.yml/badge.svg)](https://github.com/Samuel1796/Agile_Capstone/actions/workflows/ci.yml)

---

## Product Vision

A lightweight console tool that lets users **create, read, update, and delete** user records so they can manage a small user list without a database or GUI. The app is testable, built via CI/CD, and includes basic logging and a health check for operational visibility.

---

## Features

| Feature | Description |
|--------|-------------|
| **Create user** | Add a user with id, name, and email (with validation) |
| **List users** | View all users (id, name, email) |
| **Update user** | Change name or email by id |
| **Delete user** | Remove a user by id |
| **Health check** | Simple status check (menu option 5) |
| **Logging** | Console logging for key actions and errors |

---

## Requirements

- **JDK 17** or later  
- **Maven 3.6+**

---

## Quick Start

```bash
# Clone the repository
git clone https://github.com/Samuel1796/Agile_Capstone.git
cd Agile_Capstone

# Build
mvn clean compile

# Run all tests
mvn test

# Generate test coverage report (JaCoCo)
mvn verify
# Open target/site/jacoco/index.html for the report

# Run the application
mvn exec:java -Dexec.mainClass="com.agilecapstone.UserManagementApp"
```

In the console, use **1** (Create), **2** (List), **3** (Update), **4** (Delete), **5** (Health check), or **0** to quit.

---

## Project Structure

```
├── .github/workflows/
│   └── ci.yml                 # CI: build, test, coverage & report
├── docs/
│   ├── SPRINT0_PLANNING.md    # Vision, backlog, DoD, sprint plans
│   ├── BACKLOG_AND_SPRINT_PLANS.md
│   ├── SPRINT1_REVIEW.md      # Sprint 1 review & retrospective
│   ├── SPRINT2_REVIEW.md      # Sprint 2 review & final retro
│   ├── GIT_WORKFLOW.md        # Branch & commit strategy
│   └── SUBMISSION_CHECKLIST.md
├── src/main/java/com/agilecapstone/
│   ├── UserManagementApp.java # Console entry point
│   ├── User.java              # Domain model
│   ├── UserRepository.java    # In-memory CRUD store
│   ├── Validation.java        # Input validation
│   └── AppLogger.java         # Logging (Sprint 2)
├── src/test/java/com/agilecapstone/
│   ├── UserTest.java
│   ├── UserRepositoryTest.java
│   └── ValidationTest.java
├── pom.xml
└── README.md
```

---

## CI/CD (GitHub Actions)

The pipeline runs on every push and pull request to `main` and `dev`:

| Step | Description |
|------|-------------|
| **Build** | Compiles the project (`mvn compile`) |
| **Test** | Runs all unit tests (`mvn test`) |
| **Report** | Generates test coverage (JaCoCo) and results summary |
| **Artifacts** | Uploads `test-results` and `coverage-report` for each run |

- **Workflow file:** [.github/workflows/ci.yml](.github/workflows/ci.yml)  
- **Actions:** [Agile_Capstone – Actions](https://github.com/Samuel1796/Agile_Capstone/actions)

---

## Testing & Coverage

- **Unit tests:** JUnit 5 (`UserTest`, `UserRepositoryTest`, `ValidationTest`)  
- **Coverage:** JaCoCo; run `mvn verify` and open `target/site/jacoco/index.html`  
- In CI, the coverage report is available as the **coverage-report** artifact.

---

## Documentation

| Document | Purpose |
|----------|---------|
| [SPRINT0_PLANNING.md](docs/SPRINT0_PLANNING.md) | Product vision, backlog, Definition of Done, Sprint 1 & 2 plans |
| [SPRINT1_REVIEW.md](docs/SPRINT1_REVIEW.md) | Sprint 1 deliverables and review |
| [SPRINT1_RETROSPECTIVE.md](docs/SPRINT1_RETROSPECTIVE.md) | Sprint 1 retrospective |
| [SPRINT2_REVIEW.md](docs/SPRINT2_REVIEW.md) | Sprint 2 deliverables and review |
| [SPRINT2_FINAL_RETROSPECTIVE.md](docs/SPRINT2_FINAL_RETROSPECTIVE.md) | Final retrospective |
| [GIT_WORKFLOW.md](docs/GIT_WORKFLOW.md) | Branch strategy and incremental commits |
| [SUBMISSION_CHECKLIST.md](docs/SUBMISSION_CHECKLIST.md) | Capstone submission checklist |

---

## Sprints Summary

| Sprint | Focus |
|--------|--------|
| **Sprint 0** | Planning – vision, backlog, DoD, sprint plans |
| **Sprint 1** | First increment – CRUD core, CI, unit tests, review & retro |
| **Sprint 2** | Second increment – logging, health check, monitoring, review & final retro |

---

## License

MIT
