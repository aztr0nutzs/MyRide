# MyRide Persistence Target Schema v2

## Status

Schema v2 is the current persistence target for the Phase 2 persistence change.

## Version history

- **v1**: `vehicles` only. This is the existing baseline schema.
- **v2**: Adds the remaining persistence tables without altering or deleting existing vehicle rows.

## Tables

- `vehicles`: stable vehicle identity and configuration values/states.
- `maintenance_events`: maintenance history tied to a vehicle.
- `maintenance_tasks`: planned/due/deferred maintenance tied to a vehicle.
- `inspection_definitions`: reusable inspection definitions and item metadata.
- `inspection_sessions`: inspection execution state tied to a vehicle and definition.
- `diagnostic_sessions`: diagnostic evidence, tests, results, hypotheses, and outcomes tied to a vehicle.
- `procedures`: governed procedures and ordered steps.
- `knowledge_entries`: knowledge content, verification state, applicability, and source provenance.
- `attachments`: attachment metadata and ownership references. Binary content remains outside the database.
- `app_settings`: application settings keyed by stable setting key.

## ID and relationship rules

- Existing vehicle IDs are preserved exactly during v1-to-v2 migration.
- Vehicle-dependent records retain their `vehicleId` values.
- Migration does not regenerate identifiers.
- Migration does not delete or recreate the database.
- Foreign-key relationships use `NO ACTION` for destructive deletes so accidental vehicle deletion cannot silently cascade through user records.

## Migration rule

`DatabaseMigrations.V1_TO_V2` creates only the missing v2 tables and indexes. It does not rewrite the existing `vehicles` table or delete any rows.

## Import/export rule

Database backup uses a versioned document containing `formatVersion`, `schemaVersion`, `applicationVersion`, `exportedAt`, `sourceDevice`, `records`, and `attachments`.

Import is explicitly different from schema migration. The complete document is parsed and structurally validated before a transaction begins. Invalid documents are rejected without mutation. A valid restore is performed transactionally so an insertion failure rolls the restore back.

## Known boundary

This schema establishes persistence for the current domain baseline. Future domain changes require an explicit schema version increment and a concrete non-destructive migration. No destructive fallback or destructive automatic reset is permitted.
