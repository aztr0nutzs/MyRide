# Architecture Decision Records

## ADR-0001 - Repository documentation is source of truth
Status: Accepted.

AI-assisted development can lose conversational context. Durable project requirements, decisions, state, and workflows must therefore live in the repository.

## ADR-0002 - Offline-first core
Status: Accepted.

Core user records and core workflows must not depend on internet availability.

## ADR-0003 - Provenance-aware automotive knowledge
Status: Accepted.

Vehicle-specific facts require applicability and provenance. Unknown is preferable to an unsupported guess.

## ADR-0004 - Stable identifiers
Status: Accepted.

Persisted records receive immutable identifiers independent of display values or collection order.

## ADR-0005 - Versioned persistence
Status: Accepted.

Schema changes require explicit migrations and migration tests.

## ADR-0006 - Safety gates override convenience
Status: Accepted.

A workflow may be blocked when a safety prerequisite is missing or a hazard is detected.

## ADR-0007 - UI is not the authoritative knowledge layer
Status: Accepted.

Automotive facts live in governed knowledge/domain structures rather than presentation code.

## ADR-0008 - AI agents are bounded contributors
Status: Accepted.

Agents inspect, plan, implement, validate, and document within explicit scope. They do not redefine product requirements.

## ADR-0009 - User data is never a disposable development artifact
Status: Accepted.

Deleting/resetting the database is not an acceptable routine fix.
