# Sprint 0: Planning

## 1. Product Vision

**Vision:** A lightweight Java console application that allows users to create, read, update, and delete user records, enabling simple user list management without a database or GUI. The solution will be testable, built via CI/CD, and include basic logging and a health check for operational visibility.

---

## 2. Product Backlog

| ID | User Story | Priority | Story Points | Acceptance Criteria |
|----|------------|----------|--------------|---------------------|
| US-1 | **As a** user, **I want to** create a new user with id, name, and email **so that** I can add people to my list. | High | 2 | Given the app is running, when I choose "Create user" and enter id, name, email, then a new user is stored and I see a success message. Invalid input shows an error. |
| US-2 | **As a** user, **I want to** view all users **so that** I can see who is in the list. | High | 2 | Given users exist, when I choose "List users", I see all users with id, name, email. Empty list shows a clear message. |
| US-3 | **As a** user, **I want to** update an existing user by id **so that** I can correct or change details. | High | 2 | Given a user exists, when I choose "Update user" and enter id and new name/email, the user is updated and I see confirmation. Invalid id shows an error. |
| US-4 | **As a** user, **I want to** delete a user by id **so that** I can remove people from the list. | High | 2 | Given a user exists, when I choose "Delete user" and enter id, the user is removed and I see confirmation. Invalid id shows an error. |
| US-5 | **As a** operator, **I want** a simple health/status check **so that** I can verify the app is running. | Medium | 1 | When I invoke a health check (e.g. option or endpoint), the app returns a clear "healthy" or status response. |
| US-6 | **As a** developer, **I want** basic logging for key actions and errors **so that** I can troubleshoot. | Medium | 1 | Create/Update/Delete and errors are logged (e.g. to console) with enough context to debug. |

**Prioritization:** US-1 through US-4 are Must-have (core CRUD). US-5 and US-6 are Should-have (monitoring/observability).

**Estimation:** Story points use relative sizing (1 = small, 2 = medium). Total backlog: 10 points.

---

## 3. Definition of Done (DoD)

- [ ] Code compiles without errors (`mvn compile`).
- [ ] Unit and/or integration tests exist and pass (`mvn test`).
- [ ] New/changed code is covered by at least one test where practical.
- [ ] No critical or blocking linter/checkstyle issues (if configured).
- [ ] Acceptance criteria for the story are met and demonstrable.
- [ ] Code is committed to a feature branch and merged after review (or self-review).
- [ ] CI pipeline (GitHub Actions) runs and passes for the branch.

---

## 4. Sprint 1 Plan

**Goal:** Deliver first working increment with core CRUD and DevOps pipeline.

**Selected stories:**

| Story | Summary | Commitment |
|-------|---------|------------|
| US-1 | Create user | Yes |
| US-2 | List all users | Yes |
| US-4 | Delete user | Yes (optional 3rd: US-3 in same sprint if time) |

**Sprint 1 deliverables:**

- Working Create, List, and Delete (and optionally Update) in console.
- Git repo with incremental commits (no big-bang).
- GitHub Actions CI: build + tests on push/PR.
- Sprint 1 Review (screenshots/write-up) and Retrospective (≥2 improvements).

---

## 5. Sprint 2 Plan

**Goal:** Complete CRUD, add monitoring/logging, apply Sprint 1 retrospective improvements.

**Selected stories:**

| Story | Summary | Commitment |
|-------|---------|------------|
| US-3 | Update user (if not done in S1) | Yes |
| US-5 | Health/status check | Yes |
| US-6 | Basic logging | Yes |

**Sprint 2 deliverables:**

- Remaining backlog items (Update, health check, logging).
- Monitoring/logging in place (e.g. console logs, health option).
- Sprint 2 Review and Final Retrospective.

---

*Document version: Sprint 0 – Planning complete.*
