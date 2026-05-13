# Development Guide

## Local Setup

Install:

- JDK 8 or newer
- Maven 3.8 or newer
- Git

Clone the repository and verify the checkout:

```sh
mvn clean verify
```

The project vendors jSSC 2.8 as a file-based Maven repository under `third_party/maven/`, so a fresh checkout does not require NetBeans library configuration.

## Project Layout

| Path | Purpose |
| --- | --- |
| `src/motorcontrol/` | Swing application source and serial command protocol. |
| `src/motorcontrol/img/` | UI image resources packaged into the application jar. |
| `test/motorcontrol/` | Unit tests that do not require serial hardware. |
| `docs/` | Operator, developer, release, and hardware test documentation. |
| `third_party/maven/` | Vendored Maven artifacts required for reproducible builds. |
| `.github/workflows/ci.yml` | CI build and test workflow. |

## Build Commands

Run tests and package checks:

```sh
mvn clean verify
```

Build the runnable jar and runtime dependency folder:

```sh
mvn package
```

Run from compiled classes:

```sh
java -cp target/classes:target/lib/jssc-2.8.jar motorcontrol.MotorControlMainFrame
```

Run the packaged jar:

```sh
cd target
java -jar total-control-1.0.0-SNAPSHOT.jar
```

## NetBeans Compatibility

The historical NetBeans Ant project files remain so the UI form can still be opened in NetBeans. Maven is the production build path. If NetBeans regenerates `MotorControlMainFrame.java` or `.form`, review the diff carefully because generated code can overwrite manual fixes.

## Dependency Updates

When updating vendored dependencies:

1. Replace the artifact under `third_party/maven/`.
2. Update the artifact POM if coordinates or version change.
3. Regenerate `.sha1` and `.md5` checksum files.
4. Update `THIRD_PARTY_NOTICES.md`.
5. Run `mvn clean verify`.
6. Run the hardware smoke tests in `docs/hardware-test-plan.md`.

## Coding Notes

- Keep serial I/O and Swing UI updates thread-safe. Swing component mutations must run on the Event Dispatch Thread.
- Do not use `Thread.stop()` or unbounded polling loops.
- Keep generated build output, packaged jars, and machine-local IDE files out of version control.
- Add unit tests for logic that can run without hardware, and document manual tests for hardware-dependent behavior.
