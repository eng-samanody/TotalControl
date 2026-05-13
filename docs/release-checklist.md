# Release Checklist

1. Confirm the intended release version and supported JDK/OS/hardware matrix.
2. Run `mvn clean verify`.
3. Smoke test with real serial hardware:
   - connect to the expected port
   - start and stop the motor
   - change direction and speed
   - test RC-car commands if included in the release
   - unplug the device while connected and verify recovery behavior
   - enable receive logging and verify log output
4. Complete the hardware test record in `docs/hardware-test-plan.md`.
5. Review third-party dependency versions and notices.
6. Confirm `README.md`, operator docs, protocol docs, and support/security docs still match the release behavior.
7. Build the release artifact with `mvn package`.
8. Attach the artifact and release notes to a GitHub Release.
9. Include any firmware version or hardware calibration notes in the release notes.
