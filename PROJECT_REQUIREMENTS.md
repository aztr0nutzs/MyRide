# MyRide Project Requirements

## 1. Product definition

MyRide is an offline-first, mobile-first automotive garage application focused on helping a user understand, maintain, inspect, diagnose, document, and recover information about an F-150.

The system must support uncertainty instead of forcing users into false precision.

## 2. Functional requirements

### FR-001 Vehicle profiles
Create, edit, select, archive, and inspect vehicle profiles.

### FR-002 Stable identity
Every persisted vehicle has an immutable internal identifier.

### FR-003 Exact configuration
Represent year, make, model, trim, engine, transmission, drivetrain, body/cab, market, production applicability, mileage, and optional equipment. Unknown values remain unknown.

### FR-004 Maintenance records
Record date, mileage, category, work, parts/materials, cost when supplied, notes, and evidence.

### FR-005 Maintenance planning
Represent planned, due, completed, skipped, and deferred work.

### FR-006 Inspections
Support reusable inspection definitions and completed inspection sessions.

### FR-007 Diagnostic sessions
Preserve complaint, observations, tests, results, hypotheses, actions, and outcome.

### FR-008 Procedures
Support prerequisites, tools, parts, warnings, ordered steps, observations, completion, and follow-up.

### FR-009 Automotive knowledge
Store specifications, general guidance, procedures, diagnostics, and safety information independently of presentation code.

### FR-010 Provenance
Vehicle-specific factual claims expose source/provenance and applicability.

### FR-011 Safety
Safety-critical workflows can block progression until prerequisites are satisfied.

### FR-012 Search
Search vehicles, records, procedures, knowledge, observations, and notes.

### FR-013 History
Display chronological vehicle activity.

### FR-014 Export
Export user-created records to a documented portable format.

### FR-015 Import
Validate an import completely before mutating local state.

### FR-016 Data preservation
Updates and migrations must preserve existing user data.

### FR-017 Attachments
Permit photos and supporting documents through an attachment abstraction.

### FR-018 Accessibility
Provide semantic labels, usable touch targets, readable contrast, scalable text, and non-color status communication.

### FR-019 Error handling
Failures must be understandable and recoverable.

### FR-020 Offline operation
Core records and workflows must work without network access.

### FR-021 Recovery
A verified backup must be sufficient to reconstruct user records.

### FR-022 Auditability
Meaningful changes to application logic, data schema, and knowledge are traceable.

## 3. Non-functional requirements

### NFR-001 Reliability
Ordinary restart/process death must not lose committed data.

### NFR-002 Performance
Database and file operations must not unnecessarily block UI execution.

### NFR-003 Maintainability
Domain logic must be independently testable.

### NFR-004 Determinism
Identical inputs produce identical calculated outputs.

### NFR-005 Privacy
User data remains local unless an explicit future feature says otherwise.

### NFR-006 Recoverability
Backup and restore are release-level concerns.

### NFR-007 Compatibility
Toolchain versions must be verified against the actual repository/toolchain rather than treated as verified merely because versions were selected in configuration.

### NFR-008 Usability
The UI must remain practical in garage conditions.

## 4. Explicit exclusions unless approved by ADR

- Mandatory account.
- Mandatory cloud backend.
- Mandatory internet.
- Advertising.
- Analytics.
- Remote AI dependency.
- Automatic destructive cleanup.
- Google Play dependency.

## 5. Definition of done

A feature is not complete until behavior, tests, persistence impact, error states, accessibility, knowledge provenance, documentation, and Git diff have been reviewed.
