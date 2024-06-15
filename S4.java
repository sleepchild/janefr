import java.net.ServerSocket;
import java.io.IOException;
import java.net.Socket;
import java.io.OutputStream;

public class S4{
    
    public static void main(String[] args){
        new S4(args);
    }
    public S4(String[] args){
        try
        {
            ServerSocket ss = new ServerSocket(8808);
            Socket cl = ss.accept();
            OutputStream o = cl.getOutputStream();
            o.write("<h2>hello</h2>".getBytes());
            o.flush();
            o.close();
            //
            cl.close();
            ss.close();
            
        }
        catch (IOException e){}
    }
}
