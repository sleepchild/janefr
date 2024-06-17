
import java.io.IOException;
import java.io.File;

public class fmpg{
    
    public static void main(String[] args){
        
        //find mp4
        File d = new File("out1");
        File m4 = d.listFiles()[0];
        
        // change name
        
        String m3 = m4.getAbsolutePath()+".mp3";
        try{
            Process pr = Runtime.getRuntime().exec("ffmpeg -i "+m4.getAbsolutePath()+" "+m3);
            try{
                pr.waitFor();
                int v = pr.exitValue();
                log("exit code: "+v);
                
                log("done!");
            }
            catch (InterruptedException e){
                log("error");
                e.printStackTrace();
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    
    static void log(String msg){
        System.out.println(msg);
    }
}
