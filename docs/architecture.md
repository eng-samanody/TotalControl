# Architecture Notes

TotalControl is a Java Swing desktop application. The main UI class is `motorcontrol.MotorControlMainFrame`.

## Runtime Components

| Component | Responsibility |
| --- | --- |
| `MotorControlMainFrame` | Swing UI, serial connection state, serial receive handling, logging, and command dispatch. |
| `CommandProtocol` | Constants and small helpers for firmware command behavior. |
| jSSC 2.8 | Native serial-port access. Vendored under `third_party/maven/`. |

## Threading Model

Swing components must be read or mutated on the Event Dispatch Thread. Serial callbacks from jSSC are not assumed to run on the EDT, so incoming data is read once in the serial callback and UI updates are scheduled with Swing utilities.

Background workers use cooperative cancellation:

- the port monitor uses an `AtomicBoolean` and bounded sleep interval
- repeat sending uses an `AtomicBoolean` and thread interruption
- disconnect stops workers before closing serial resources

## Packaging

Maven is the reproducible production build path. The build packages application classes and image resources into `target/total-control-1.0.0-SNAPSHOT.jar`, then copies runtime dependencies to `target/lib/`.

The NetBeans project files remain for compatibility with the historical form editor. They are not the source of truth for CI.

## Deferred Features

Remote/network and Bluetooth controls existed as prototype UI elements in the historical form. They are hidden from the production UI until implemented with non-blocking I/O, connection state, validation, tests, and operator documentation.
