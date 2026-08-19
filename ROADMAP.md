# Roadmap

## Phase 0 - Governance baseline
Status: VERIFIED.

Deliver requirements, architecture, state, ADRs, knowledge governance, persistence strategy, design system, testing strategy, agent controls, workspace configuration, and recovery documentation.

## Phase 1 - Repository/build baseline
Verify actual project tree, Gradle wrapper, JDK, Android SDK, modules, tests, and clean debug build.

Exit: reproducible build and executable test baseline.

## Phase 2 - Domain
Implement vehicle, configuration, maintenance, inspections, diagnostics, procedures, knowledge, and safety models.

Exit: domain tests pass and unknown/provenance states are supported.

## Phase 3 - Persistence
Implement local storage, repositories, migrations, export/import, attachments.

Exit: CRUD, restart, migrations, round-trip export/import, invalid-import protection.

## Phase 4 - Knowledge
Implement governed knowledge schema, applicability, provenance, verification state, procedures, inspections, diagnostics, safety.

Exit: automated knowledge validation and reviewable source records.

## Phase 5 - Core UI
Dashboard, vehicle, maintenance, inspections, diagnostics, procedures/knowledge, history, settings, backup/restore.

Exit: navigation complete, no dead controls, accessibility reviewed.

## Phase 6 - Garage workflows
End-to-end safety, inspection, procedure, observation, completion, follow-up workflows.

## Phase 7 - Hardening
Offline, process death, migrations, large histories, invalid input, accessibility, performance, recovery.

## Phase 8 - Release candidate
Full traceability, release checklist, backup/restore drill, known-issue review, and no unresolved safety-critical defects.
