/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientetcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/**
 *
 * @author DELL
 */
public class ClienteTCP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         try
        {
        //Mo 1 client socket den server voi so cong va dia chi xac dinh
        SSLSocketFactory factory=(SSLSocketFactory) SSLSocketFactory.getDefault();
        SSLSocket sslsocket=(SSLSocket) factory.createSocket("127.0.0.1",1234);

        //Tao luong nhan va gui du lieu len server
        DataOutputStream os=new DataOutputStream(sslsocket.getOutputStream());
        DataInputStream is=new DataInputStream(sslsocket.getInputStream());

        //Gui du lieu len server
        String str="helloworld";
        os.writeBytes(str);

        //Nhan du lieu da qua xu li tu server ve
        String responseStr;
        if((responseStr=is.readUTF())!=null)
        {
            System.out.println(responseStr);
        }

        os.close();
        is.close();
        sslsocket.close();
        }
        catch(UnknownHostException e)
        {
             System.out.println(e.getMessage());
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }

    }
    
}
