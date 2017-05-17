import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

class FileOperate{
	public String readFile(String pathName){
	    StringBuffer context = new StringBuffer();
	    FileReader fileR = null;
	    BufferedReader br = null;
        try {
            fileR = new FileReader(new File(pathName));
            br = new BufferedReader(fileR);
            String line = "";
            while((line = br.readLine()) != null){
                context.append(line);
                context.append(' ');
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            if(br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fileR != null){
                try {
                    fileR.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        
	    return context.toString();
	}
	
	public void outFile(String pathName,String result){
		FileWriter fw = null;
		try {
		    File file = new File(pathName);
		    if(!file.exists()){
		        file.createNewFile();
		    }
             fw = new FileWriter(file);
             fw.write(result);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fw != null){
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
	}
}
