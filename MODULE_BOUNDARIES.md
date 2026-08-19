# Module Boundaries

## Presentation

May know how to render and collect input.

Must not decide authoritative automotive specifications.

## Application

Coordinates use cases and transaction boundaries.

Must not own persistent storage implementation details.

## Domain

Owns business rules.

Must remain Android-independent where practical.

## Knowledge

Owns governed factual and procedural content.

Must carry provenance and applicability.

## Persistence

Owns storage mechanics and migrations.

Must not invent domain behavior.

## Infrastructure

Owns platform integration.

Must not bypass domain validation.

## Boundary violation examples

Bad:
- A Compose screen contains a torque specification.
- A repository silently converts unknown engine to a default engine.
- A migration deletes records to simplify schema changes.
- A diagnostic UI labels a hypothesis as "confirmed."

Good:
- UI requests a domain use case.
- Domain evaluates a governed knowledge entry.
- Repository persists validated state.
- UI renders verification state supplied by the application.
