# Git Workflow

## Before work

```text
git status --short --branch
git branch --show-current
git log -n 10 --oneline
```

## Checkpoint

Before risky work create a recoverable checkpoint.

Risky work includes:

- Large refactor.
- Database migration.
- Major UI rewrite.
- Large AI-agent task.
- Knowledge migration.

## Commit style

Examples:

```text
feat: add vehicle persistence model
fix: preserve inspection records during migration
test: cover diagnostic safety gate
docs: define knowledge provenance
```

## Diff review

Inspect every changed file.

Check:

- Accidental files.
- Dependencies.
- Secrets.
- Generated output.
- Automotive values.
- Tests.
- Documentation.

## Agent rule

An agent must not overwrite unrelated user changes.

## Recovery

Stop, inspect status/diff, preserve user work, restore only affected scope, validate, document.
