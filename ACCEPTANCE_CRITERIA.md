# Acceptance Criteria

## Vehicle

- Can create and select a vehicle.
- Stable identity survives rename/edit.
- Unknown configuration fields remain explicitly unknown.
- Configuration changes are historically auditable where required.

## Maintenance

- Can create a maintenance event.
- Event survives restart.
- Event appears in history.
- Invalid required fields are rejected clearly.

## Inspection

- Can start an inspection.
- Can record each result.
- Can pause/resume.
- Completion is persisted.
- Safety warnings cannot be silently bypassed.

## Diagnostics

- Complaint is preserved.
- Observations are distinct from hypotheses.
- Tests/results are timestamped.
- Outcome is recorded.
- A hypothesis cannot be displayed as a confirmed diagnosis without evidence.

## Knowledge

- Entries carry verification status.
- Vehicle-specific facts carry applicability.
- Sources are traceable.
- Unknown values are supported.

## Persistence

- Migration preserves records.
- Export/import round trip preserves stable IDs and relationships.
- Invalid imports leave existing data unchanged.

## UI

- No dead navigation.
- No required content is cropped.
- Critical controls are accessible.
- Status is not communicated by color alone.

## Release

- Required tests pass.
- Backup restore succeeds.
- No unresolved safety-critical issue exists.
- Documentation matches implementation status.
