# Final Deliverables – Submission Checklist

Use this to confirm you have everything for the Agile Capstone submission.

## 1. Backlog & Sprint Plans

- [ ] **Product backlog** – `docs/SPRINT0_PLANNING.md` (and summary in `docs/BACKLOG_AND_SPRINT_PLANS.md`)
- [ ] **User stories** – At least 5, with acceptance criteria, prioritization, and estimates (story points)
- [ ] **Definition of Done** – In `docs/SPRINT0_PLANNING.md`
- [ ] **Sprint 1 & 2 plans** – Scope and selected stories in `docs/SPRINT0_PLANNING.md`

## 2. Codebase

- [ ] **Repository link** – e.g. `https://github.com/Samuel1796/Agile_Capstone`
- [ ] **Commit history** – Incremental commits (no single big-bang at the end); use `docs/GIT_WORKFLOW.md` for branch/commit order

## 3. CI/CD Evidence

- [ ] **Pipeline config** – `.github/workflows/ci.yml` (build + test on push/PR to `main` and `dev`)
- [ ] **Successful run** – Screenshot or link to a green GitHub Actions run
- [ ] **Failed run (optional)** – Screenshot of a red run (e.g. after breaking a test) to show pipeline reacts to failures

## 4. Testing Evidence

- [ ] **Test files** – `src/test/java/com/agilecapstone/` (UserTest, UserRepositoryTest, ValidationTest)
- [ ] **Tests in pipeline** – CI runs `mvn test`
- [ ] **Screenshot** – Optional: `mvn test` output or Actions test summary

## 5. Sprint Review Documents

- [ ] **Sprint 1** – `docs/SPRINT1_REVIEW.md` (what was delivered, how to run, evidence)
- [ ] **Sprint 2** – `docs/SPRINT2_REVIEW.md` (same for second increment)
- [ ] **Demos/screenshots** – Optional: add screenshots to the docs or a `screenshots/` folder

## 6. Retrospectives

- [ ] **Sprint 1** – `docs/SPRINT1_RETROSPECTIVE.md` (at least 2 specific improvements for Sprint 2)
- [ ] **Sprint 2 (Final)** – `docs/SPRINT2_FINAL_RETROSPECTIVE.md` (process reflection and lessons learned)

## 7. Prototype

- [ ] **Working app** – Java console CRUD (Create, List, Update, Delete) + health check (menu option 5)
- [ ] **Monitoring/logging** – `AppLogger` used for key actions and errors; health check available
- [ ] **Run locally** – `mvn compile exec:java -Dexec.mainClass="com.agilecapstone.UserManagementApp"` (requires JDK 17 and Maven)

---

**Grading dimensions:** Agile practice (25%), DevOps practice (25%), Delivery discipline (20%), Prototype quality (20%), Reflection (10%).
