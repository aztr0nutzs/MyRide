# Backup and Recovery

## Objective

The project must recover both source code and user-created vehicle data.

## Backup targets

### Repository
Source, docs, tests, knowledge, configuration, and required Git history.

### User data
Database/export, attachments, and metadata needed to interpret them.

### Environment record
Application version, schema version, commit hash, export format, timestamp.

## Backup tiers

B1 Working backup.
B2 Known-good verified backup.
B3 Independent archive.

## Recovery

1. Stop writes.
2. Preserve the failed state.
3. Identify last known-good checkpoint.
4. Restore source.
5. Restore compatible data backup.
6. Verify schema.
7. Run migrations.
8. Verify entity counts and relationships.
9. Launch.
10. Exercise critical workflows.
11. Create new known-good backup.

## Corruption

Never overwrite the only copy of a corrupted database.

Work from a copy.

## Agent recovery

If an agent causes unexpected changes, stop, inspect Git, preserve user work, compare with checkpoint, restore only affected scope, test, and document.
