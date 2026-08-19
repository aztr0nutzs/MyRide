# Diagnostic Knowledge Model

## Evidence hierarchy

1. User complaint.
2. Direct observation.
3. Measurement.
4. Controlled test result.
5. Known-good comparison.
6. Hypothesis.
7. Confirmation.

## Diagnostic record

A diagnostic session should support:

- Complaint.
- Context.
- Vehicle configuration.
- Symptoms.
- Observations.
- Measurements.
- Tests.
- Results.
- Hypotheses.
- Confidence.
- Next action.
- Outcome.
- Follow-up.

## Hypothesis rules

A hypothesis is a proposed explanation.

The UI should distinguish:

- Possible.
- Likely.
- Supported.
- Confirmed.

"Confirmed" requires defined evidence.

## Branching

A diagnostic workflow may have multiple branches. Preserve failed tests and rejected hypotheses instead of deleting them.

## Safety

A diagnostic action involving movement, heat, electricity, fuel, rotating components, lifting, or pressurized systems can require a safety gate.
