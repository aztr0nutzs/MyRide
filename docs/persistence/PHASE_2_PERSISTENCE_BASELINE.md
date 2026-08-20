# Phase 2 Persistence Baseline

## Scope

This phase establishes the first local persistence boundary for MyRide. The domain remains independent of Room; Room is an infrastructure implementation behind repository contracts.

## Authority

Local persistent storage is authoritative for user-created data.

## Current implementation

- Room 2.8.4 runtime and KTX
- KSP-based Room compilation
- Room schema export enabled
- Database schema version 1
- Vehicle persistence entity and DAO
- Vehicle domain/entity mapping
- Room-backed vehicle repository
- Database factory
- Regression test preserving unknown and unverified vehicle configuration states

## Non-goals

This baseline does not yet persist every domain entity. Maintenance, inspection, diagnostics, procedures, knowledge, attachments, and application settings remain to be mapped and integrated incrementally.

## Migration rule

Schema version changes must add explicit migrations. Destructive fallback, database deletion, and silent data reset are prohibited.

## Validation status

Repository-side implementation is committed. CI/build execution must be treated as authoritative for compilation and test results. No local build result is claimed from the GitHub connector environment.
