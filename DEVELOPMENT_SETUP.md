# Development Setup

## Principle

The repository's actual toolchain is authoritative.

## Initial inspection

Record:

- OS.
- JDK version.
- Gradle wrapper version.
- Android Gradle Plugin version.
- Kotlin version.
- Compile SDK.
- Target SDK.
- Minimum SDK.
- Android SDK location.
- Connected device/emulator state.

## Baseline

Run:

```text
git status --short --branch
./gradlew --version
./gradlew test
./gradlew assembleDebug
```

On Windows use `gradlew.bat`.

Do not change toolchain versions simply because the local machine prefers a different version. First determine the project's declared baseline.

## Environment files

Machine-specific SDK paths should remain local and should not be committed unless the project explicitly requires them.

## First development checkpoint

Once the repository builds and tests, create a Git checkpoint before feature work.
