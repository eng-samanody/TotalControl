# Hardware Test Plan

Run this checklist before a production release or after changing serial, command, packaging, or dependency behavior.

## Test Matrix

Record the following for each run:

- OS and architecture
- JDK version
- TotalControl commit SHA
- Firmware version or commit SHA
- Serial device name
- Baud rate, data bits, stop bits, and parity

## Smoke Tests

1. Start the app from the packaged jar.
2. Verify the expected serial port appears.
3. Connect with the firmware-required serial settings.
4. Confirm the status displays the selected port and baud rate.
5. Start the motor clockwise at a low speed.
6. Change speed and confirm the firmware responds.
7. Stop the motor.
8. Start the motor anticlockwise at a low speed.
9. Stop the motor.
10. If RC-car firmware is connected, test forward, backward, left, right, stop, lights, and horn.
11. Enable receive logging and confirm incoming data is appended to the chosen file.
12. Disconnect and confirm controls return to the disconnected state.

## Fault Tests

1. Try to connect to an unavailable or busy port and confirm the app reports the failure.
2. Unplug the serial device while connected and confirm the app prompts for reconnect.
3. Start repeated sending, then disable it and confirm it stops without freezing the UI.
4. Enable logging to a location that becomes unavailable and confirm the app reports the write failure.

## Pass Criteria

- No UI freeze during connect, receive, repeat-send, disconnect, or unplug handling.
- No stale connected status after a failed connection or unplug event.
- Stop commands are sent before disconnect when the motor is running.
- Logging can be enabled, writes expected data, and closes cleanly.
- `mvn clean verify` passes for the same commit.
