# Command Protocol

TotalControl writes single-character commands to the connected serial device. Firmware must interpret these commands consistently.

| Command | Meaning |
| --- | --- |
| `P` | Speed prefix. The app sends this before writing the numeric speed value. |
| `C` | Set motor direction clockwise. |
| `N` | Set motor direction anticlockwise. |
| `S` | Stop motor or RC car. |
| `F` | Move RC car forward. |
| `B` | Move RC car backward. |
| `L` | Turn RC car left. |
| `R` | Turn RC car right. |
| `H` | Toggle or activate head light. |
| `Z` | Toggle or activate red light. |
| `O` | Activate horn. |

The motor speed slider range is `0` to `100`. The UI displays RPM as `sliderValue * 24`, so firmware and operators should treat `100` as `2400 rpm` in the current calibration.

Serial settings are selected by the operator in the UI. Production deployments should document the firmware-required baud rate, data bits, stop bits, and parity alongside the device.
