# Screen Inventory

## Home / Garage

Purpose: current vehicle summary, urgent tasks, recent activity, quick actions.

States: no vehicle, vehicle selected, loading, error.

## Vehicle

Purpose: identity and configuration.

States: verified fields, user-entered fields, unknown fields, edit mode.

## Maintenance

Purpose: history and planned work.

States: empty, active plan, completed history, error.

## Inspection

Purpose: launch/review inspections.

States: definitions, active session, paused, completed.

## Diagnose

Purpose: evidence-driven diagnostic sessions.

States: no sessions, active session, paused, completed, blocked by safety gate.

## Procedures / Knowledge

Purpose: searchable governed information.

States: verified, source-required, unknown, superseded.

## History

Purpose: chronological record.

## Backup / Settings

Purpose: export, import, restore, app configuration, about.

## Global states

Every major screen should account for:

- Loading.
- Empty.
- Success.
- Validation error.
- Recoverable infrastructure error.
- Offline.
