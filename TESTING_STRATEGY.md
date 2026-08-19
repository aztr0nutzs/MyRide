# Testing Strategy

## Two independent correctness questions

1. Does the software behave correctly?
2. Is the automotive information itself correct and applicable?

Neither proves the other.

## Unit

Domain entities, validators, calculations, safety gates, diagnostic state transitions, knowledge filters.

## Knowledge validation

Verify provenance, applicability, statuses, IDs, duplicate detection, supersession, safety metadata.

## Persistence

Test CRUD, restart, migration, export/import, invalid input, relationships, attachments, large datasets.

## UI

Test navigation, critical workflows, accessibility, loading/empty/error/success states, large text, small screens.

## Integration

Test complete flows across presentation, application, domain, persistence.

## Regression

Every meaningful fixed defect should receive a regression test where practical.

## Safety

Test that safety warnings appear, prerequisites block unsafe progression, and unknown required values can prevent unsafe action.

## Release

Build, unit tests, persistence, knowledge validation, critical UI/integration, backup/restore, accessibility, and known-issue review are required.
