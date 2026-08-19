# F-150 Garage Assistant
## Complete Project Documentation and AI Development Governance Package

Version: 1.0.0
Prepared: 2026-08-18

### Purpose

This package is the durable engineering context for F-150 Garage Assistant. It is designed so that development can continue in VS Code, Android Studio, Antigravity, or another capable coding environment without depending on conversational memory.

The product is a mobile-first garage companion for vehicle configuration, maintenance, inspections, procedures, diagnostics, records, history, search, and recovery.

### Critical rule

Documentation describes intended behavior and governance. It does not prove that application code exists. The live repository must always be inspected before an agent claims an implementation is complete.

### Source-of-truth hierarchy

1. `PROJECT_REQUIREMENTS.md`
2. `PROJECT_STATE.md`
3. `ARCHITECTURE.md`
4. `DECISIONS.md`
5. `ROADMAP.md`
6. `docs/requirements/*`
7. `docs/architecture/*`
8. `docs/knowledge/*`
9. `docs/design/*`
10. `docs/testing/*`
11. `docs/ai/*`
12. `.agents/*`
13. `.vscode/*`
14. Application source and tests

### Non-negotiable principles

- Never invent automotive specifications.
- Preserve unknown values as unknown.
- Record provenance for vehicle-specific facts.
- Separate user observations from diagnostic hypotheses.
- Separate UI from authoritative automotive knowledge.
- Protect persisted user data.
- Use explicit database migrations.
- Keep core operation offline-first.
- Safety gates override convenience.
- Never claim a test ran when it did not.
- Never overwrite unrelated user work.
- AI agents are bounded contributors, not project owners.
- Every material change must be recoverable.

### Intended development loop

Inspect -> plan -> checkpoint -> implement -> test -> review diff -> synchronize documentation -> report.

### Included areas

Requirements, product specification, acceptance criteria, architecture, module boundaries, data flow, privacy, roadmap, ADRs, automotive knowledge governance, vehicle configuration model, diagnostic model, persistence, export format, visual design, theme tokens, component catalog, screen inventory, testing, test matrix, release checklist, Git, AI protocol, Antigravity operating model, agent context, rules, skills, workflows, VS Code configuration, prompts, backup/recovery, change control, development setup, incident recovery, traceability, changelog, known issues, and test status.
