# Data Flow

## Read flow

UI -> ViewModel/presentation state -> application use case -> repository/knowledge service -> domain model -> presentation state.

## Write flow

UI input -> application validation -> domain command -> persistence transaction -> saved result -> updated presentation state.

## Diagnostic flow

Complaint -> observation capture -> test selection -> test execution by user -> result capture -> hypothesis generation/evaluation -> next action -> outcome -> history.

## Knowledge flow

Source -> provenance record -> review -> verification -> published knowledge -> domain/application query -> UI.

## Backup flow

Local persistence -> validated export -> user-controlled storage.

## Restore flow

Backup -> parse -> schema validation -> relationship validation -> staging -> atomic apply -> integrity check.

## Failure principle

Failures must stop at the correct layer rather than being silently converted into plausible values.
