import javax.swing.filechooser.FileSystemView;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Wayss.
 * @date 2018/10/11.
 */
public class CreateFile {

    public static void main(String[] args) {
        String fileName = "newFile";
        String suff = "csv";
        File file = getFile(fileName, suff);
        try {
            file.createNewFile();
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            for (int i = 0; i < 10; i++){
                writer.write("这是一行文字");
                //换行
                writer.write("\n");
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 获取桌面路径
     * @return
     */
    private static String getHomeDir(){
        FileSystemView fsv = FileSystemView.getFileSystemView();
        File com=fsv.getHomeDirectory();
        return com.getPath();
    }

    /**
     * 生成文件，入参为要生成的文件名，若输入的文件名已存在则文件名后+1
     * @param fileName 要生成的文件名
     * @param suff 要生成的文件后缀
     * @return
     */
    private static File getFile(String fileName, String suff){

        File file = null;

        String path = getHomeDir();
        String absolutePath = path + "\\" + fileName + "." + suff;
        int i = 1;
        while (true){
            file = new File(absolutePath);
            boolean isExist = file.exists();
            if (!isExist){
                break;
            }
            //文件存在时，修改文件名
            absolutePath = path + "\\" + fileName + i + "." + suff;
            i++;
        }

        return file;
    }

}
