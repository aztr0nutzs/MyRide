# Data Export Format

## Purpose

Provide a portable, inspectable representation of user-created records.

## Top-level metadata

```text
formatVersion
schemaVersion
applicationVersion
exportedAt
sourceDevice
records
attachments
```

## Record requirements

Each record retains:

- Type.
- Stable ID.
- Created timestamp.
- Updated timestamp.
- Relationships.
- User data.
- Provenance where applicable.

## Compatibility

Importers must reject unsupported major format versions instead of guessing.

Minor compatible revisions may be migrated through explicit logic.

## Integrity

Exports should be internally self-consistent.

Attachment references must resolve or be explicitly marked missing.

## Privacy

An export is user-controlled private data and should not automatically be uploaded anywhere.
