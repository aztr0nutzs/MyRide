# Incident Recovery

## Incident classes

- Build/toolchain failure.
- Accidental source modification.
- Data migration failure.
- Knowledge integrity issue.
- UI regression.
- Safety regression.
- Backup corruption.

## Immediate response

1. Stop changes.
2. Preserve current state.
3. Record Git status and commit.
4. Identify affected scope.
5. Determine whether user data is affected.
6. Restore from checkpoint if required.
7. Validate.
8. Document root cause.
9. Add regression protection.

## Safety incident

If incorrect automotive information or unsafe workflow behavior is discovered, treat it as higher priority than cosmetic or feature work.
