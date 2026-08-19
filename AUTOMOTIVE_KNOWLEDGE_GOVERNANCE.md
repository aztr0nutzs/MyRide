# Automotive Knowledge Governance

## Why this is special

An incorrect software fact can be annoying. An incorrect torque, fluid, wiring, support point, pressure, or diagnostic instruction can damage a vehicle or injure someone.

## Knowledge classes

### K1 - Verified specification
Exact vehicle-specific fact supported by authoritative source.

### K2 - General guidance
Broad automotive guidance that does not claim exact applicability.

### K3 - User observation
What the user actually saw, measured, heard, smelled, or experienced.

### K4 - Diagnostic hypothesis
Possible cause supported by evidence but not confirmed.

### K5 - Derived value
Calculated from verified inputs and a documented formula.

### K6 - Unknown
Insufficient evidence.

## Source hierarchy

1. Factory service documentation.
2. Manufacturer technical documentation.
3. Official service publications.
4. Manufacturer parts/service information.
5. Reputable technical databases with traceable sources.
6. High-quality secondary references.
7. Community reports only as observations/leads.

## Required provenance

A vehicle-specific fact should record:

- Source title.
- Publisher.
- Publication/version if known.
- Vehicle applicability.
- Section/page/table/reference.
- Retrieval date.
- Reviewer.
- Verification state.
- Notes about ambiguity.

## Applicability dimensions

At minimum evaluate:

- Model year.
- Engine.
- Transmission.
- Drivetrain.
- Trim.
- Cab/body.
- Production range.
- Market.
- Optional equipment.

## Conflicts

Never silently merge conflicting values.

Record each source and explain why one applies or why the result remains unresolved.

## AI restriction

AI may organize evidence but may not turn a plausible answer into a verified specification.

## Lifecycle

Draft -> Sourced -> Reviewed -> Verified -> Published -> Superseded.

Superseded entries remain auditable.

## Safety-critical data

Requires stronger verification and explicit safety metadata.
