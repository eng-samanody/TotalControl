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
4. Review third-party dependency versions and notices.
5. Build the release artifact with `mvn package`.
6. Attach the artifact and release notes to a GitHub Release.
7. Include any firmware version or hardware calibration notes in the release notes.
