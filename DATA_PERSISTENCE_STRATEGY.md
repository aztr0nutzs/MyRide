# Data Persistence Strategy

## Authority

Local persistent storage is authoritative for user-created data.

## Core entities

Vehicle
VehicleConfiguration
MaintenanceEvent
MaintenanceTask
InspectionDefinition
InspectionSession
InspectionItemResult
DiagnosticSession
DiagnosticObservation
DiagnosticTest
DiagnosticResult
DiagnosticHypothesis
Procedure
ProcedureStep
KnowledgeEntry
KnowledgeSource
Attachment
AppSetting

## Stable identity

Each record has an immutable application ID.

## Schema versioning

Every schema revision increments a version and supplies an explicit migration.

## Migration requirements

- Non-destructive.
- Deterministic.
- Tested.
- Backward-aware where supported.
- Stable-ID preserving.
- Relationship preserving.

## Import safety

Import must be staged and validated before commit.

Validation includes:

- Format.
- Version.
- Required fields.
- IDs.
- References.
- Duplicates.
- Data types.
- File integrity.

## Backup

At least one known-good backup must exist before a destructive recovery operation.

## Deletion

Deletion must be explicit and must not be used as migration logic.

## Attachments

Attachment metadata belongs in the database. Binary files belong in managed storage. Records must never depend on a fragile temporary path.

## Transaction principle

A logical operation that changes related records should succeed as a coherent transaction or fail without leaving an invalid intermediate state.
