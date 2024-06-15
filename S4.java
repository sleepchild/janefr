//package senile.rateLimit;

import java.net.ServerSocket;
import java.io.IOException;
import java.net.Socket;
import java.io.OutputStream;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.net.InetAddress;

public class S4{

    public static void main(String[] args){
        new S4(args);
    }
    public S4(String[] args){
        ServerSocket ss=null;
        try
        {
            log("starting server..");
            ss = new ServerSocket(8808);
            int xp = ss.getLocalPort();
            log("running on "+xp);
            getIpAddr();
            //ss.setSoTimeout(9000);
            Socket cl = ss.accept();
            log("client: "+cl.getInetAddress().getHostAddress());
            OutputStream o = cl.getOutputStream();
            o.write("<h2>hello</h2>".getBytes());
            o.flush();
            o.close();
            //
            cl.close();
            ss.close();

        }
        catch (IOException e){
            if(ss!=null){
                try{
                ss.close();
                }catch(IOException e1){}

            }
        }
    }
    
    void getIpAddr(){
        try{
            Enumeration<NetworkInterface> nis = NetworkInterface.getNetworkInterfaces();
            while(nis.hasMoreElements()){
                log("\n\n");
                NetworkInterface ni = nis.nextElement();
                log(ni.getDisplayName()+"");
                Enumeration<InetAddress> iads = ni.getInetAddresses();
                while(iads.hasMoreElements()){
                    InetAddress ia = iads.nextElement();
                    String ss = ia.getHostName()+";;"+ia.getHostAddress();
                    log(ss);
                    log("\n");
                }
                
                
            }
            
        }
        catch (SocketException e)
        {}
    }
    
    void log(String msg){
        System.out.println(msg);
    }
}
