# Project State

Baseline: 2026-08-18

## State labels

PLANNED, IN_PROGRESS, IMPLEMENTED, VERIFIED, BLOCKED, DEFERRED, RETIRED.

## Current baseline

The project governance/documentation baseline is established.

Application implementation status must be determined from the live repository. This document intentionally does not pretend that planned features are already coded.

## Product direction

- F-150 Garage Assistant.
- Mobile-first garage companion.
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

## Current risks

1. Vehicle-specific misinformation.
2. AI inference replacing missing facts.
3. Persistence migrations damaging records.
4. UI changes accidentally changing behavior.
5. Documentation drifting from implementation.
6. Build success being mistaken for automotive correctness.

## Required next implementation sequence

1. Inspect actual repository/build baseline.
2. Establish domain models.
3. Establish persistence.
4. Establish governed knowledge data.
5. Establish core UI.
6. Implement maintenance/inspection workflows.
7. Implement diagnostic workflows.
8. Implement search/history/export/import.
9. Harden recovery/accessibility/offline behavior.
10. Release validation.
