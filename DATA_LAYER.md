# Data / Knowledge Layer

This package uses JSON Schema Draft 2020-12 for structural validation. The schema dialect is explicitly declared on every schema. JSON Schema 2020-12 is the current published specification. citeturn0search0turn0search11

## Rules

- Stable IDs are never regenerated when prose changes.
- `schemaVersion` tracks the record structure.
- `knowledgeScope` distinguishes generic, vehicle-specific, and configuration-specific data.
- Unknown values are explicit `null` or empty relationship arrays.
- Automotive specifications use a `specification` object with source metadata.
- Unverified facts must not be rendered as verified specifications.
- Safety-critical material uses `SafetyRule` and `Warning`, with explicit severity.
- The existing brake/shimmy guide is represented as a migration source, not as independent factory verification.
- User data is separate from bundled knowledge.

## Persistence boundary

The future application should persist structured user records such as vehicles, notes, photos, inspection results, service records, and repair records in IndexedDB. IndexedDB is intended for significant amounts of structured client-side data and supports indexed, transactional storage, including blobs. It is not a full-text search engine and browsers can remove stored data in some circumstances, so backup/export remains necessary. citeturn0search1turn0search10
