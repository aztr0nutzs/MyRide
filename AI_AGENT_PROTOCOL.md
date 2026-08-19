# AI Agent Protocol

## Role

The AI agent is an implementation assistant.

It is not authorized to redefine requirements or invent missing facts.

## Mandatory preflight

Read:

- README.
- Requirements.
- State.
- Architecture.
- Roadmap.
- ADRs.
- Relevant knowledge/design/testing docs.
- Relevant agent rules.
- Relevant skill.
- Actual repository.
- Git status.

## Scope contract

Before editing identify:

- Objective.
- Files.
- Requirements.
- Architecture layer.
- Tests.
- Risks.
- Stop conditions.

## Stop conditions

Stop when:

- A requirement conflicts.
- A safety-critical fact is unverified.
- A destructive migration appears necessary.
- Existing user changes would be overwritten.
- Required tooling is unavailable.
- Scope expands.
- An ADR would be violated.

## Editing

Use the smallest coherent change.

Do not perform unrelated cleanup.

Do not disable tests to make a build green.

Do not add speculative dependencies.

## Validation

Only report checks actually executed.

## Final report

Include changed files, behavior, tests, build result, documentation, limitations, blockers, and commit if applicable.
