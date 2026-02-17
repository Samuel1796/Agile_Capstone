# Git Workflow – Incremental Commits & Branches

This guide gives you a **step-by-step order** of branches and commits so your history shows iterative, incremental delivery (no big-bang). Use it after you have run `git init`, added `README.md`, committed, and set `origin` as below.

## One-time setup (if not done)

```powershell
git init
git add README.md
git commit -m "first commit"
git branch -M main
git remote add origin https://github.com/Samuel1796/Agile_Capstone.git
git push -u origin main
```

Create and push `dev`:

```powershell
git checkout -b dev
git push -u origin dev
git checkout main
```

---

## Incremental commit strategy (recommended order)

Do these in order. Each bullet is one commit; push after every 1–2 commits so CI runs and history is incremental.

### 1) Sprint 0 – Planning (on `main` or a short-lived branch)

```powershell
git checkout main
git add docs/SPRINT0_PLANNING.md docs/BACKLOG_AND_SPRINT_PLANS.md
git commit -m "Sprint 0: Add product vision, backlog, DoD, sprint plans"
git push origin main
```

### 2) Sprint 1 – Project skeleton and model (feature branch → dev → main)

```powershell
git checkout main
git pull
git checkout -b feature/project-skeleton
git add pom.xml
git commit -m "Add Maven project and dependencies"
git add src/main/java/com/agilecapstone/User.java
git commit -m "Add User domain model"
git push -u origin feature/project-skeleton
# Open PR: feature/project-skeleton -> dev (or merge locally)
git checkout dev
git merge feature/project-skeleton
git push origin dev
# After CI passes on dev, merge to main
git checkout main
git merge dev
git push origin main
```

### 3) Sprint 1 – Repository and Create/List/Delete (feature branches)

```powershell
git checkout dev
git pull
git checkout -b feature/user-repository
git add src/main/java/com/agilecapstone/UserRepository.java
git commit -m "Add UserRepository for in-memory CRUD"
git push -u origin feature/user-repository
# Merge to dev
git checkout dev
git merge feature/user-repository
git push origin dev

git checkout -b feature/validation
git add src/main/java/com/agilecapstone/Validation.java
git commit -m "Add input validation for id, name, email"
git push -u origin feature/validation
git checkout dev
git merge feature/validation
git push origin dev

git checkout -b feature/console-crud
git add src/main/java/com/agilecapstone/UserManagementApp.java
git commit -m "Add console app with Create, List, Update, Delete menu"
git push -u origin feature/console-crud
git checkout dev
git merge feature/console-crud
git push origin dev
```

### 4) Sprint 1 – Tests and CI

```powershell
git checkout dev
git checkout -b feature/unit-tests
git add src/test/java/com/agilecapstone/UserTest.java src/test/java/com/agilecapstone/UserRepositoryTest.java src/test/java/com/agilecapstone/ValidationTest.java
git commit -m "Add unit tests for User, UserRepository, Validation"
git push -u origin feature/unit-tests
git checkout dev
git merge feature/unit-tests
git push origin dev

git checkout -b feature/ci
git add .github/workflows/ci.yml
git commit -m "Add GitHub Actions CI: compile and test on push/PR"
git push -u origin feature/ci
git checkout dev
git merge feature/ci
git push origin dev
```

### 5) Sprint 1 – Review and retro

```powershell
git checkout dev
git add docs/SPRINT1_REVIEW.md docs/SPRINT1_RETROSPECTIVE.md
git commit -m "Sprint 1: Add review and retrospective"
git push origin dev
git checkout main
git merge dev
git push origin main
```

### 6) Sprint 2 – Logging and health (monitoring)

```powershell
git checkout dev
git checkout -b feature/logging
git add src/main/java/com/agilecapstone/AppLogger.java
git commit -m "Add AppLogger for key actions and errors (US-6)"
# Update UserManagementApp to use AppLogger (if not already staged)
git add src/main/java/com/agilecapstone/UserManagementApp.java
git commit -m "Integrate logging in CRUD and health check (US-5, US-6)"
git push -u origin feature/logging
git checkout dev
git merge feature/logging
git push origin dev
```

### 7) Sprint 2 – Review and final retro

```powershell
git checkout dev
git add docs/SPRINT2_REVIEW.md docs/SPRINT2_FINAL_RETROSPECTIVE.md docs/GIT_WORKFLOW.md
git commit -m "Sprint 2: Add review, final retrospective, and Git workflow doc"
git push origin dev
git checkout main
git merge dev
git push origin main
```

---

## Short version (if repo is already full)

If you already have all files in the repo and only need to **fix history**, you can do a series of small commits on `dev` and push often:

1. Commit only `docs/` first (planning).
2. Commit `pom.xml`, then `User.java`, then `UserRepository.java`, then `Validation.java`, then `UserManagementApp.java`.
3. Commit test classes.
4. Commit `.github/workflows/ci.yml`.
5. Commit `AppLogger.java` and any logging changes.
6. Commit remaining docs (reviews, retros, this workflow).

Then merge `dev` into `main` and push. Prefer the branch-per-feature flow above for a cleaner, assessment-friendly history.

---

## Branch summary

| Branch | Purpose |
|--------|---------|
| `main` | Production-ready; only updated via merge from `dev`. |
| `dev` | Integration branch; feature branches merge here first. |
| `feature/*` | One story or one logical change; merge into `dev` when tests pass. |

**Rule:** New work in a `feature/...` branch → merge to `dev` → after acceptance, merge `dev` to `main`.
