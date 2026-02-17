# Sprint 2 – Final Retrospective

## Process reflection

- **Agile:** Backlog with acceptance criteria and DoD helped us know when each story was “done.” Sprint 1 and 2 plans kept scope clear and allowed us to deliver in two increments.
- **DevOps:** CI (GitHub Actions) ran on every push; tests were part of the pipeline. Adding logging and a health check gave basic observability without extra infrastructure.
- **Delivery discipline:** Using feature branches and merging to `dev` then `main` produced a commit history that shows incremental delivery rather than a single big-bang commit.

## Improvements and lessons learned

1. **Logging and health early**  
   Adding logging and a health check in Sprint 2 improved supportability. Doing this from Sprint 1 for any new feature would have saved a small pass of rework and is a practice to keep.

2. **Strict branch workflow**  
   Using one feature branch per story and merging only after tests pass kept `main` and `dev` stable and made it easy to trace which commit delivered which story.

3. **Small commits**  
   Commits like “Add User model,” “Add Create user,” “Add tests for UserRepository” make history readable and align with the requirement for iterative, incremental delivery.

4. **DoD and tests**  
   Having “tests pass in CI” in the Definition of Done caught regressions and gave confidence before merging.

## Summary

The prototype is a working Java console CRUD app with tests, CI, logging, and a health check. The main takeaway is that combining a clear backlog, DoD, feature branches, small commits, and CI from the start makes it possible to deliver in two short sprints without last-minute integration or “big-bang” commits.

---

*Final Retrospective – Agile Capstone.*
