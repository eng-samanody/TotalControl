# Operator Guide

## Before Starting

Confirm:

- The motor controller or RC-car firmware matches `docs/command-protocol.md`.
- The device is connected over serial.
- The operator knows the required baud rate, data bits, stop bits, and parity for the firmware.
- The motor or vehicle is in a safe test area before enabling motion.

## Connecting

1. Start TotalControl.
2. Select the serial port.
3. Select the firmware-required serial settings.
4. Click `Connect`.
5. Confirm the status changes to connected before sending commands.

If the port list is empty, check cable connection, OS permissions, and whether another program already has the port open.

## Motor Controls

- Select direction before starting the motor.
- Use the speed slider to set the desired speed.
- Click start to send the speed and direction commands.
- Click stop before changing direction or disconnecting.

The displayed RPM is `sliderValue * 24`. Treat this as the current calibration unless firmware documentation says otherwise.

## RC-Car Controls

The RC-car controls send movement and accessory commands directly to the connected firmware. Use these only when the firmware is known to support the RC-car command set.

## Receive Logging

1. Click `Browse` in the Receive panel.
2. Choose the destination log file.
3. Select `Date` and/or `Time` if timestamps are needed.
4. Enable `Start Log`.
5. Disable `Start Log` before moving or deleting the log file.

If log writing fails, the app disables logging and reports the failure.

## Disconnecting

Click `Disconnect` before unplugging hardware. If the serial device is unplugged unexpectedly, the app resets connection state and prompts for reconnect.

## Troubleshooting

| Symptom | Checks |
| --- | --- |
| No serial ports listed | Cable, device power, OS permissions, driver installation. |
| Cannot open port | Another process may be using the port; verify serial settings and permissions. |
| Commands have no effect | Confirm firmware protocol, baud rate, and wiring. |
| Incoming data is missing | Verify firmware output rate and cable quality; retry with logging disabled to isolate file I/O. |
| App cannot access port on Linux | Add the user to the serial device group, commonly `dialout`, then sign out and back in. |
