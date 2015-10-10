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
import java.io.PrintWriter;
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
                SSLSocket s = (SSLSocket) client.createSocket( "localhost", 7443 );
                PrintWriter writer= new PrintWriter(s.getOutputStream());
                InputStream reader= s.getInputStream();
                writer.println("Hola");
        } catch (Exception exception) {
            
        }

    }
    
}
