# Persistence Layer

The persistence layer is an infrastructure implementation of the domain repository contracts.

Rules:

- Local storage is authoritative for user-created data.
- Domain models must not depend on Room annotations.
- Stable application IDs are preserved across persistence.
- Unknown and unverified configuration states are persisted explicitly.
- Schema versions require explicit, non-destructive migrations.
- Deleting and recreating the database is never an accepted migration strategy.
- Related changes must use transactions where atomicity is required.
- Attachment binaries are stored outside the database; metadata belongs in persistence.
