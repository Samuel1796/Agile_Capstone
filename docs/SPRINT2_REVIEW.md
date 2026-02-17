# Sprint 2 Review

## What Was Delivered

Sprint 2 applied the Sprint 1 retrospective improvements and delivered the remaining backlog items plus monitoring/logging.

### Process Improvements Applied

- **Logging from the start:** `AppLogger` was added and used for create, update, delete, and error paths (aligned with Sprint 1 retro).
- **Branch discipline:** Features were developed on branches and merged to `dev`, then to `main` (see `docs/GIT_WORKFLOW.md`).

### Backlog Items Completed

| Story   | Description           | Status |
|---------|-----------------------|--------|
| **US-3** | Update user by id     | Done   |
| **US-5** | Health/status check   | Done   |
| **US-6** | Basic logging         | Done   |

### Working Software

- **Update user (US-3):** Menu option 3 – user enters id; can change name and/or email; confirmation or “not found” error.
- **Health check (US-5):** Menu option 5 – prints “Status: healthy” (simple health indicator).
- **Logging (US-6):** All create/update/delete actions and validation/not-found errors are logged via `AppLogger` with timestamp and level (INFO/ERROR).

### Monitoring / Logging

- **Console logging:** `AppLogger` writes timestamped INFO/ERROR lines to the console for key actions and failures.
- **Health check:** Option 5 in the menu serves as a basic “health endpoint” for operator verification.

### How to Verify

```bash
mvn clean test
mvn exec:java -Dexec.mainClass="com.agilecapstone.UserManagementApp"
```

- Create a user (1), update it (3), list (2), delete (4), and use health (5). Check console for `[timestamp] INFO/ERROR` log lines.

### Evidence

- Code: `AppLogger.java`, and `UserManagementApp` calling it; menu options 3 and 5.
- CI: Same GitHub Actions workflow; all tests still pass.
- Optional: Screenshots of console with menu, CRUD flow, and log output can be added here or in `screenshots/`.

---

*Sprint 2 Review – second increment and monitoring delivered.*
