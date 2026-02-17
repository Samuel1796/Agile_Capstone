# Sprint 1 Retrospective

## What went well

- **Clear scope:** Having US-1, US-2, US-4 (and later US-3) defined with acceptance criteria made implementation straightforward.
- **Small steps:** Delivering Create, then List, then Delete in small commits kept the work manageable and reviewable.
- **CI from the start:** Adding the GitHub Actions workflow early meant every push was validated by build and tests.

## What could be improved (for Sprint 2)

1. **Logging from the beginning**  
   We added logging only when we thought about “monitoring” later. In Sprint 2 we will add a simple `AppLogger` and log key actions (create, update, delete) and errors from the start for any new features, so we have visibility and easier debugging without rework.

2. **Branch discipline**  
   Some work was done on a single branch. In Sprint 2 we will use strict branch workflow: one short-lived feature branch per story (e.g. `feature/US-5-health-check`), merge into `dev` after tests pass, then integrate `dev` into `main` only when the sprint increment is accepted. This keeps history clear and aligns with “incremental delivery” and the assessment requirement.

## Action items for Sprint 2

- [ ] Introduce `AppLogger` (or equivalent) and use it for all new and existing CRUD paths and errors.
- [ ] Use feature branches for each backlog item; merge to `dev`, then `main` after review/acceptance.

---

*Sprint 1 Retrospective – 2 specific improvements identified for Sprint 2.*
