# Safety Governance

## Safety priority

Safety overrides convenience, visual simplicity, and workflow completion.

## Hazard classes

- Vehicle movement.
- Jacking/support.
- Electrical.
- Battery.
- Fuel.
- Heat.
- Rotating components.
- Pressurized systems.
- Chemicals/fluids.
- Road testing.

## Safety gate structure

A safety gate should contain:

- Hazard.
- Required condition.
- Required equipment.
- Required user action.
- Stop condition.
- Confirmation state.

## Stop conditions

The workflow must stop or require explicit review when:

- Vehicle support is uncertain.
- Required safety equipment is missing.
- A hazardous condition is observed.
- A required configuration-sensitive value is unverified.
- A procedure prerequisite is not met.

## UI

Warnings should appear before the hazardous step and remain discoverable.

Color alone is never sufficient.

## AI

Agents must not weaken, delete, or hide safety instructions merely to make a flow shorter.
