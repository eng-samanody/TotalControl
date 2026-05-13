# Contributing

## Workflow

1. Create a branch from `master`.
2. Make a focused change.
3. Run `mvn clean verify`.
4. Update documentation when behavior, operation, dependencies, or release steps change.
5. Open a pull request with a summary and validation notes.

## Pull Request Checklist

- `mvn clean verify` passes.
- Hardware-dependent changes include results from `docs/hardware-test-plan.md`.
- Serial UI changes keep Swing mutations on the Event Dispatch Thread.
- New dependencies are documented in `THIRD_PARTY_NOTICES.md`.
- Generated files, build output, and machine-local IDE metadata are not committed.

## Documentation Expectations

- User-facing behavior belongs in `README.md` or `docs/operator-guide.md`.
- Firmware command changes belong in `docs/command-protocol.md`.
- Release process changes belong in `docs/release-checklist.md`.
- Architecture or threading decisions belong in `docs/architecture.md`.
