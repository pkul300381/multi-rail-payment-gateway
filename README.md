
# Multi-Rail Payment Gateway

This is a Spring Boot application that provides a multi-trail payment gateway.

## Generating Security Files

To run this application with HTTPS and mTLS, you will need to generate the following security files:

1.  **Server Keystore:**
    ```bash
    keytool -genkeypair -alias server -keyalg RSA -keysize 2048 -storetype PKCS12 -keystore src/main/resources/server.p12 -validity 365 -dname "CN=localhost, OU=Engineering, O=Example, L=Mountain View, ST=CA, C=US" -storepass password -keypass password
    ```

2.  **Client Keystore:**
    ```bash
    keytool -genkeypair -alias client -keyalg RSA -keysize 2048 -storetype PKCS12 -keystore src/main/resources/client.p12 -validity 365 -dname "CN=client, OU=Engineering, O=Example, L=Mountain View, ST=CA, C=US" -storepass password -keypass password
    ```

3.  **Client Certificate:**
    ```bash
    keytool -exportcert -alias client -keystore src/main/resources/client.p12 -rfc -file src/main/resources/client.cer -storepass password
    ```

4.  **Server Truststore:**
    ```bash
    keytool -importcert -alias client -file src/main/resources/client.cer -keystore src/main/resources/server.truststore -storepass password -noprompt
    ```

