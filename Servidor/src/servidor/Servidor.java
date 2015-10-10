/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

/**
 *
 * @author DELL
 */
public class Servidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       try{
        //Creaet a SSLServersocket
        SSLServerSocketFactory factory=(SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        SSLServerSocket sslserversocket=(SSLServerSocket) factory.createServerSocket(1234);
        //Tạo 1 đối tượng Socket từ serversocket để lắng nghe và chấp nhận kết nối từ client
        SSLSocket sslsocket=(SSLSocket) sslserversocket.accept();
        //Tao cac luong de nhan va gui du lieu cua client
        DataInputStream is=new DataInputStream(sslsocket.getInputStream());
        PrintStream os=new PrintStream(sslsocket.getOutputStream());
        while(true)  //khi dang ket noi voi client
        {
            //Doc du lieu den
            String input=is.readUTF();
            String ketqua=input.toUpperCase();
            //Du lieu tra ve
            os.println(ketqua);
        }
        }
        catch(IOException e)
        {
           System.out.print(e);
        }

    }
    
}
