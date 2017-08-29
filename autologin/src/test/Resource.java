package test;
import java.io.InputStream;

public class Resource {
    
    public InputStream getStream(){
        InputStream inputStream = this.getClass().getResourceAsStream("/resource/info.txt");
        return inputStream;
    }
}
