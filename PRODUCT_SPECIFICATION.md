# Product Specification

## Product concept

A digital garage workbench that keeps a persistent record of one or more vehicles and turns automotive information into practical, structured workflows.

## Primary user jobs

1. Identify the vehicle configuration.
2. Record maintenance.
3. Perform inspections.
4. Follow procedures.
5. Capture diagnostic evidence.
6. Research verified vehicle information.
7. Review vehicle history.
8. Recover data after failure.

## Core navigation model

Recommended top-level destinations:

- Garage/Home.
- Vehicle.
- Maintenance.
- Inspect.
- Diagnose.
- Procedures/Knowledge.
- History.
- Backup/Settings.

The exact navigation implementation may differ, but every destination must correspond to real functionality.

## Product behavior

The application should favor explicit evidence over hidden automation. If the system cannot determine something safely, it should show what is unknown and why.

## Data ownership

User-entered observations, maintenance records, diagnostic history, and vehicle metadata belong to the user and must remain durable.
