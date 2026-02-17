# Sprint 1 Review

## What Was Delivered

Sprint 1 delivered the first increment of the User Management console application and the DevOps pipeline.

### Backlog Items Completed

| Story   | Description        | Status   |
|---------|--------------------|----------|
| **US-1** | Create user        | Done     |
| **US-2** | List all users     | Done     |
| **US-4** | Delete user        | Done     |

(US-3 Update was planned for Sprint 2; it was implemented in the codebase for the full CRUD experience and is part of the same console app.)

### Working Software

- **Create user:** Menu option 1 – user enters id, name, email; validation applies; success or error message is shown.
- **List users:** Menu option 2 – all users are displayed (id, name, email) or a message when the list is empty.
- **Delete user:** Menu option 4 – user enters id; user is removed and confirmation is shown, or an error if not found.

### DevOps

- **Version control:** Git used with incremental commits (see `docs/GIT_WORKFLOW.md` and repository history).
- **CI/CD:** GitHub Actions workflow (`.github/workflows/ci.yml`) runs on push/PR to `main` and `dev`: compile and tests.
- **Testing:** Unit tests for `User`, `UserRepository`, and `Validation`; all run in the CI pipeline.

### How to Run / Verify

```bash
# Build and test
mvn clean test

# Run the app
mvn exec:java -Dexec.mainClass="com.agilecapstone.UserManagementApp"
```

Then: 1 = Create, 2 = List, 4 = Delete. Create a few users, list them, delete one, list again to confirm.

### Evidence

- Pipeline: See GitHub Actions “CI” workflow runs (green for passing build + tests).
- Tests: `mvn test` passes; test classes in `src/test/java/com/agilecapstone/`.
- Screenshots: Optional – capture of console menu and a create/list/delete flow can be added to this doc or a `screenshots/` folder.

---

*Sprint 1 Review – first increment delivered.*
