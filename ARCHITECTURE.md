# Architecture

## 1. Architectural goal

Keep automotive knowledge, business behavior, persistence, and presentation independently testable and changeable.

## 2. Layers

### Presentation
Screens, navigation, UI state, accessibility, visual components.

### Application
Use cases, orchestration, validation boundaries, transaction coordination, mapping.

### Domain
Entities, value objects, rules, calculations, safety gates, diagnostic state transitions.

### Knowledge
Vehicle specifications, applicability, procedures, inspection definitions, diagnostic knowledge, safety content, provenance.

### Persistence
Database implementation, repositories, migrations, serialization, import/export.

### Infrastructure
Android APIs, files, clock, UUID provider, logging, optional integrations.

## 3. Dependency rule

Presentation -> Application -> Domain.

Infrastructure implements interfaces needed by inner layers.

Domain must not depend on Android UI classes.

Presentation must not contain authoritative automotive specifications.

## 4. Recommended repository

```text
f150-garage-assistant/
├── README.md
├── PROJECT_REQUIREMENTS.md
├── PROJECT_STATE.md
├── ARCHITECTURE.md
├── ROADMAP.md
├── DECISIONS.md
├── CHANGELOG.md
├── KNOWN_ISSUES.md
├── TEST_STATUS.md
├── .editorconfig
├── .gitignore
├── .vscode/
│   ├── settings.json
│   ├── extensions.json
│   ├── tasks.json
│   └── launch.json
├── .agents/
│   ├── rules/
│   ├── skills/
│   └── workflows/
├── app/
│   ├── src/main/java/<package>/
│   │   ├── presentation/
│   │   ├── application/
│   │   ├── domain/
│   │   ├── knowledge/
│   │   ├── persistence/
│   │   └── infrastructure/
│   ├── src/main/res/
│   └── src/test/
├── data/
│   ├── knowledge/
│   ├── seed/
│   └── schemas/
├── docs/
│   ├── requirements/
│   ├── architecture/
│   ├── adr/
│   ├── knowledge/
│   ├── design/
│   ├── testing/
│   ├── git/
│   ├── ai/
│   ├── operations/
│   └── prompts/
├── tests/
│   ├── domain/
│   ├── knowledge/
│   ├── persistence/
│   ├── integration/
│   └── ui/
└── scripts/
```

## 5. Feature domains

Vehicle, maintenance, inspection, diagnostics, procedures, knowledge, safety, history, search, backup.

## 6. Persistence entities

Vehicle, VehicleConfiguration, MaintenanceEvent, MaintenanceTask, InspectionDefinition, InspectionSession, InspectionResult, DiagnosticSession, DiagnosticObservation, DiagnosticTest, DiagnosticResult, DiagnosticHypothesis, Procedure, ProcedureStep, KnowledgeEntry, KnowledgeSource, Attachment, AppSetting.

## 7. Stable identifiers

Persisted entities use immutable IDs. Names, positions, dates, and array indexes are never identity.

## 8. Time

Persist canonical timestamps. Convert for display only at the presentation boundary.

## 9. Error model

Expected domain failures are typed. Infrastructure failures are translated into user-safe messages and diagnostic logs.

## 10. Offline-first

Local user data is authoritative. Any future synchronization requires a separate conflict-resolution ADR.
