package pers.wayss.verification;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
/**
 * 验证码生成Servlet
 */
public class ImageServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        BufferedImage bi=new BufferedImage(68,22,BufferedImage.TYPE_INT_BGR);
        Graphics g=bi.getGraphics();
        Color c=new Color(250,150,255);
        g.setColor(c);
        g.fillRect(0,0,68,22);
        //验证码字符集合
        char[] ch="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
        Random r=new Random();
        int len=ch.length;
        int index;
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<4;++i){
            index=r.nextInt(len);
            //设置验证码字符随机颜色
            g.setColor(new Color(r.nextInt(88),r.nextInt(188),r.nextInt(255)));
            //画出对应随机的验证码字符
            g.drawString(ch[index]+"",(i*15)+3,18);
            sb.append(ch[index]);
        }
        //把验证码字符串放入Session
        request.getSession().setAttribute("piccode", sb.toString());
        //在HttpServletResponse中写入验证码图片信息
        ImageIO.write(bi, "JPG", response.getOutputStream());
    }
}