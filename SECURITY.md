# Security Policy

## Reporting A Vulnerability

Do not open a public issue for vulnerabilities that could expose users or systems. Contact the repository owner privately through an agreed private channel, or use GitHub private vulnerability reporting if it is enabled for this repository.

Include:

- affected commit or release
- impact
- reproduction steps
- affected operating system and serial hardware, if relevant
- suggested mitigation, if known

## Security Scope

Relevant reports include:

- unsafe file writes in receive logging
- command injection or unintended process execution
- unsafe serial or network behavior if remote-control features are added
- dependency or packaged native-library vulnerabilities
- behavior that can unexpectedly start or fail to stop connected hardware

## Dependency Handling

The project vendors jSSC 2.8 for serial access. Dependency updates must include updated notices, checksums, build verification, and hardware smoke testing.
