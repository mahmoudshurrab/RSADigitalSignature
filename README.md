# RSA Digital Signature in Java

## Project Overview

This project implements a digital signature using the RSA algorithm in Java. It demonstrates how to generate RSA keys, sign a message using a private key, and verify the signature using a public key.

The project also demonstrates how modifying a signed message causes signature verification to fail.

## Features

- Generate an RSA key pair with a 2048-bit key size.
- Create a digital signature using `SHA256withRSA`.
- Verify the signature using the public key.
- Detect message modification by testing the signature against an altered message.
- Display the digital signature in Base64 format.

## Technologies Used

- **Programming Language:** Java
- **Cryptographic Algorithm:** RSA
- **Hash Algorithm:** SHA-256
- **Development Environment:** IntelliJ IDEA
- **JDK:** Java 21
- **Libraries:** Java standard security libraries

## How to Run

1. Open the project in IntelliJ IDEA.
2. Make sure a compatible JDK is configured.
3. Open `Main.java`.
4. Run the `main()` method.
5. Observe the signature and verification results in the console.

No external cryptographic libraries are required.

## Expected Results

The program displays the original message, its digital signature, and the verification results.

- **Original Message Verification:** `true`
- **Modified Message Verification:** `false`

The first result confirms that the signature is valid for the original message. The second result demonstrates that the signature does not verify against the modified message.

The Base64 signature may differ between executions because a new RSA key pair is generated each time the program runs.

## Project Structure

```text
RSADigitalSignature/
├── Main.java
└── README.md
```

## Academic Context

This project was developed as part of the Software Security course (SDEV 4303) to demonstrate RSA digital signatures and message integrity.
