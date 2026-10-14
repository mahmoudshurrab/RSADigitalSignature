import java.nio.charset.StandardCharsets;
import java.security.*;
import java.util.Base64;

public class Main {
    public static void main(String[] args) throws Exception {


        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048);

        KeyPair keyPair = keyPairGenerator.generateKeyPair();

        PrivateKey privateKey = keyPair.getPrivate();
        PublicKey publicKey = keyPair.getPublic();


        String message = "Transfer $1000 to Mark";


        Signature signer = Signature.getInstance("SHA256withRSA");

        signer.initSign(privateKey);
        signer.update(message.getBytes(StandardCharsets.UTF_8));

        byte[] digitalSignature = signer.sign();


        Signature verifier = Signature.getInstance("SHA256withRSA");

        verifier.initVerify(publicKey);
        verifier.update(message.getBytes(StandardCharsets.UTF_8));

        boolean isValid = verifier.verify(digitalSignature);

        String modifiedMessage = "Transfer $1000 to Oscar";

        Signature modifiedVerifier = Signature.getInstance("SHA256withRSA");

        modifiedVerifier.initVerify(publicKey);
        modifiedVerifier.update(modifiedMessage.getBytes(StandardCharsets.UTF_8));

        boolean modifiedIsValid = modifiedVerifier.verify(digitalSignature);


        System.out.println("===== RSA Digital Signature =====");
        System.out.println("Original Message: " + message);
        System.out.println("Digital Signature (Base64):");
        System.out.println(Base64.getEncoder().encodeToString(digitalSignature));

        System.out.println("\nOriginal Message Verification: " + isValid);
        System.out.println("Modified Message: " + modifiedMessage);
        System.out.println("Modified Message Verification: " + modifiedIsValid);
    }
}