# Vehicle Configuration Model

## Principle

A vehicle is not adequately identified by year and model alone.

## Identity fields

- Internal stable ID.
- VIN when the user intentionally supplies it.
- Year.
- Make.
- Model.
- Trim.
- Engine.
- Transmission.
- Drivetrain.
- Cab.
- Bed/body configuration.
- Market.
- Production applicability.
- Optional equipment.

## Value states

Every configuration field should conceptually support:

- Verified.
- User-provided/unverified.
- Inferred.
- Unknown.

Inference must never masquerade as verification.

## Configuration history

If a user corrects a configuration value that affects past records, the system must avoid silently rewriting historical evidence.

## Practical 1997 F-150 rule

For the primary project context, do not infer engine, transmission, drivetrain, or trim merely from the model year. Exact configuration must be established before displaying configuration-sensitive specifications.
