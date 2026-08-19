# Security and Privacy

## Default posture

Keep vehicle records local.

## Sensitive local information

The app may contain:

- Vehicle identifiers.
- Maintenance history.
- Photos.
- Notes.
- Location-like information embedded in photos or notes.

Therefore exports should be treated as user-controlled private files.

## Secrets

Never commit:

- API keys.
- Signing credentials.
- Tokens.
- Passwords.
- Private certificates.

## Logs

Do not log complete user notes or private attachments by default.

## Future network features

Any network feature requires an explicit architecture decision covering:

- Data sent.
- Data retained.
- Encryption.
- Authentication.
- Failure behavior.
- Offline behavior.
- User consent.
