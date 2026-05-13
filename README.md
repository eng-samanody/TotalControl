# TotalControl

TotalControl is a Java Swing desktop application for controlling serial-connected motor and RC-car firmware.

## Status

This project is a desktop serial-control app. The production UI supports local serial control and receive logging. Prototype remote/network controls are hidden from the production UI until they are implemented end to end.

## Requirements

- JDK 8 or newer
- Maven 3.8 or newer
- A serial device whose firmware implements the command protocol in [docs/command-protocol.md](docs/command-protocol.md)
- A supported operating system/architecture for jSSC 2.8 native serial libraries

The repository vendors jSSC 2.8 under `third_party/maven/` because the app uses jSSC native serial support. The jar includes native libraries for Linux, macOS, Solaris, and Windows architectures supported by jSSC 2.8.

## Build And Test

```sh
mvn clean verify
```

The CI workflow runs the same command on every push and pull request.

For development workflow details, see [docs/development.md](docs/development.md).

## Run

```sh
mvn package
java -cp target/classes:target/lib/jssc-2.8.jar motorcontrol.MotorControlMainFrame
```

Packaged releases copy the serial runtime jar to `target/lib/`, so the built jar can also be run from `target`:

```sh
cd target
java -jar total-control-1.0.0-SNAPSHOT.jar
```

On Windows, use `;` instead of `:` in the classpath:

```bat
java -cp target\classes;target\lib\jssc-2.8.jar motorcontrol.MotorControlMainFrame
```

## Operation

1. Connect the motor controller or RC-car firmware over serial.
2. Start the app.
3. Select the serial port and serial settings.
4. Click `Connect`.
5. Use the motor or RC-car controls.
6. Click `Disconnect` before unplugging hardware when possible.

If the connected port disappears, the app stops the monitor loop, resets connection state, and prompts for reconnection.

For a fuller operator checklist and safety notes, see [docs/operator-guide.md](docs/operator-guide.md).

## Receive Logging

Use `Browse` in the Receive panel to choose a log file, then enable `Start Log`. Incoming serial data is appended to the selected file. Date and time prefixes follow the `Date` and `Time` checkboxes.

## Troubleshooting

- If no ports appear, check OS permissions and whether another process has the serial device open.
- If connect fails, verify baud rate, data bits, stop bits, parity, and native jSSC support for the platform.
- If the app starts but cannot access serial ports on Linux, add the user to the relevant serial device group such as `dialout`, then sign out and back in.

## Release

See [docs/release-checklist.md](docs/release-checklist.md).

Hardware smoke-test steps are documented in [docs/hardware-test-plan.md](docs/hardware-test-plan.md).

## Support And Security

For maintenance expectations, see [SUPPORT.md](SUPPORT.md). For responsible vulnerability reporting, see [SECURITY.md](SECURITY.md).

## License And Notices

Project source is all rights reserved unless the repository owner adds an explicit open-source license. Third-party dependency notices are documented in [THIRD_PARTY_NOTICES.md](THIRD_PARTY_NOTICES.md).
