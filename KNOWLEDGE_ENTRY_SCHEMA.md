# Knowledge Entry Schema

## Conceptual fields

```text
id
knowledgeClass
title
content
vehicleApplicability
source
verificationStatus
confidence
safetyLevel
createdAt
updatedAt
supersedes
notes
```

## Verification states

UNVERIFIED
SOURCE_REQUIRED
SOURCED
REVIEWED
VERIFIED
SUPERSEDED

## Confidence

LOW, MEDIUM, HIGH.

Confidence is not provenance.

## Applicability

Must be structured enough to filter an entry against a vehicle configuration.

## Safety level

NORMAL, CAUTION, SAFETY_CRITICAL.

Safety-critical entries require stronger review.

## Example

The schema may represent a torque specification, but this documentation deliberately does not supply a fabricated torque value.
