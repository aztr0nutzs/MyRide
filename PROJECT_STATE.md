# Project State

Baseline: 2026-08-20

## State labels

PLANNED, IN_PROGRESS, IMPLEMENTED, VERIFIED, BLOCKED, DEFERRED, RETIRED.

## Current baseline

The governance baseline, Android foundation, initial domain models, repository contracts, and first persistence implementation are established on `phase-2/android-foundation`. The persistence change is implemented as an open draft PR against `main` pending CI validation.

The repository is the authoritative source for implementation state. Tests and build status must be based on executed checks, never documentation claims.

## Product direction

- MyRide.
- Mobile-first automotive garage companion.
- Offline-first core.
- Dark industrial diagnostic UI.
- Near-black surfaces.
- Neon cyan primary accent.
- Neon purple, mint, neon pink, and neon yellow-green secondary accents.
- Provenance-aware automotive knowledge.
- Persistent local records.
- Structured inspection and diagnostic workflows.
- Recoverable user data.

## Vehicle context

The project is intended to support a 1997 Ford F-150 context, but the exact configuration must be treated as unverified until confirmed. Year alone is insufficient to establish engine, transmission, drivetrain, trim, body, production differences, or optional equipment.

## Current implementation state

### Implemented

- Correct GitHub repository: `aztr0nutzs/MyRide`.
- Phase 2 development branch: `phase-2/android-foundation`.
- Initial Android Gradle project structure and minimal launch activity.
- Vehicle, maintenance, inspection, diagnostic, procedure, knowledge/provenance, and safety domain models.
- Repository contracts.
- Room persistence foundation.
- Target schema v2 covering vehicle, maintenance, inspection, diagnostics, procedures, knowledge, attachments, and settings.
- Explicit non-destructive v1-to-v2 migration.
- Migration registration in database construction.
- Versioned database export and transaction-safe restore with validation before mutation.
- Persistence instrumentation tests for empty databases, populated data, stable IDs/relationships, invalid imports, and duplicate-primary-key edge cases.
- Migration registry contract test.
- Target schema documentation.

### Not yet verified

- Actual Gradle build execution.
- Android SDK/JDK availability in the connected execution environment.
- Instrumented Android test execution.
- Generated Room schema artifact inspection.
- Runtime launch verification.
- APK generation.
- Governed automotive knowledge population.
- Core UI implementation.
- Maintenance/inspection/diagnostic application workflows.
- Final backup/restore release validation.

## Current risks

1. Vehicle-specific misinformation.
2. AI inference replacing missing facts.
3. Persistence migrations damaging records.
4. UI changes accidentally changing behavior.
5. Documentation drifting from implementation.
6. Build success being mistaken for automotive correctness.
7. Toolchain versions being treated as verified without execution.

## Required next implementation sequence

1. Verify the persistence change through CI and fix only reproducible failures.
2. Synchronize documentation after verified implementation state.
3. Complete governed knowledge data.
4. Establish application/use-case layer as required by architecture.
5. Establish core UI.
6. Implement maintenance/inspection workflows.
7. Implement diagnostic workflows.
8. Harden search/history/export/import and recovery/accessibility/offline behavior.
9. Release validation.
