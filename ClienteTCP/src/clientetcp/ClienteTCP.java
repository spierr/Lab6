/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientetcp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.UnknownHostException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLServerSocketFactory;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Map;
import java.util.Properties;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import org.apache.commons.ssl.HostnameVerifier;
import org.apache.commons.ssl.KeyMaterial;
import org.apache.commons.ssl.SSL;
import org.apache.commons.ssl.SSLClient;
import org.apache.commons.ssl.SSLWrapperFactory;
import org.apache.commons.ssl.TomcatServerXML;
import org.apache.commons.ssl.TrustChain;
import org.apache.commons.ssl.TrustMaterial;

/**
 *
 * @author DELL
 */
public class ClienteTCP {

    public static void main(String[] args) {
        
         try {
            SSLClient client = new SSLClient();
            // Let's trust usual "cacerts" that come with Java.  Plus, let's also trust a self-signed cert
            // we know of.  We have some additional certs to trust inside a java keystore file.
            client.addTrustMaterial( TrustMaterial.DEFAULT );
            client.addTrustMaterial( new TrustMaterial( "/path/to/self-signed.pem" ) );
            client.addTrustMaterial( new KeyMaterial( "/path/to/keystore.jks", "changeit".toCharArray() ) );

            // To be different, let's allow for expired certificates (not recommended).
            client.setCheckHostname( true );  // default setting is "true" for SSLClient
            client.setCheckExpiry( false );   // default setting is "true" for SSLClient
            client.setCheckCRL( true );       // default setting is "true" for SSLClient

            // Let's load a client certificate (max: 1 per SSLClient instance).
            client.setKeyMaterial( new KeyMaterial( "/path/to/client.pfx", "secret".toCharArray() ) );
            SSLSocket s = (SSLSocket) client.createSocket( "www.cucbc.com", 443 );
        } catch (Exception exception) {
            
        }

    }
    
}
