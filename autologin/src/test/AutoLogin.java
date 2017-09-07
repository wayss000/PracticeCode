package test;

import java.awt.AWTException;
import java.awt.Desktop;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class AutoLogin {
    private static Desktop desktop = Desktop.getDesktop();
    
    public static void main(String [] args) throws IOException, AWTException{
        System.err.println("run...");
        Properties pro = new Properties();
        Resource res = new Resource();
        pro.load(res.getStream());
        String path = pro.getProperty("path");
        
        Robot robot = new Robot();
        
        //open VNC
        long time = System.currentTimeMillis();
        desktop.open(new File(path));
        long time2 = System.currentTimeMillis();
        System.out.println(time2-time);
        robot.delay(500);
        //login
        InputTool.keyPress(robot, KeyEvent.VK_ENTER);
        InputTool.keyPress(robot, KeyEvent.VK_ENTER);
    }
    
}
