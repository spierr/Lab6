/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.io.BufferedReader;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLServerSocketFactory;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
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
import org.apache.commons.ssl.SSLServer;
import org.apache.commons.ssl.SSLWrapperFactory;
import org.apache.commons.ssl.TomcatServerXML;
import org.apache.commons.ssl.TrustChain;
import org.apache.commons.ssl.TrustMaterial;

/**
 *
 * @author DELL
 */
public class Servidor  {
     

     public  static  void      main(String[] arstring) {
         try {
            SSLServer server = new SSLServer();
            // Server needs some key material.  We'll use an OpenSSL/PKCS8 style key (possibly encrypted).
            String certificateChain = "/lib/server.crt";
            String privateKey = "/lib/server.key";
            char[] password = "clave".toCharArray();
            KeyMaterial km = new KeyMaterial( certificateChain, privateKey, password ); 

            server.setKeyMaterial( km );

            // These settings have to do with how we'll treat client certificates that are presented
            // to us.  If the client doesn't present any client certificate, then these are ignored.
            server.setCheckHostname( false ); // default setting is "false" for SSLServer
            server.setCheckExpiry( true );    // default setting is "true" for SSLServer
            server.setCheckCRL( true );       // default setting is "true" for SSLServer

            // This server trusts all client certificates presented (usually people won't present
            // client certs, but if they do, we'll give them a socket at the very least).
            server.addTrustMaterial( TrustMaterial.TRUST_ALL );
            SSLServerSocket ss = (SSLServerSocket) server.createServerSocket( 7443 );
            SSLSocket s = (SSLSocket) ss.accept();
            PrintWriter writer= new PrintWriter(s.getOutputStream());
            BufferedReader reader= new BufferedReader(new InputStreamReader(s.getInputStream()));
            System.out.println(reader.readLine());
         } catch (Exception e) {
         }
 
         
    }

}
