# Agile Capstone – User Management Console App

A simple Java console application for user management with CRUD operations, delivered using Agile and DevOps practices across two sprints.

## Product Vision

**A lightweight console tool that lets users create, read, update, and delete user records so they can manage a small user list without a database or UI.** The app will be testable, buildable via CI/CD, and include basic logging and a health check for operational visibility.

## Quick Start

```bash
# Build
mvn clean compile

# Run tests
mvn test

# Run application
mvn exec:java -Dexec.mainClass="com.agilecapstone.UserManagementApp"
```

## Project Structure

- `docs/` – Sprint 0 planning, backlog, DoD, sprint plans, reviews, retrospectives
- `src/` – Java source and tests
- `.github/workflows/` – CI/CD pipeline (GitHub Actions)

## Sprints

- **Sprint 0**: Planning (backlog, DoD, Sprint 1 & 2 plans)
- **Sprint 1**: First increment (CRUD core, CI, tests)
- **Sprint 2**: Second increment (monitoring, logging, health endpoint, process improvements)

## License

MIT
