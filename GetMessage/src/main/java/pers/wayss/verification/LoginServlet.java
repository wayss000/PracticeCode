package pers.wayss.verification;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
/**
 * 登录验证Servlet
 */
public class LoginServlet extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String piccode=(String)request.getSession().getAttribute("piccode");
        String checkcode=request.getParameter("checkcode");
        response.setContentType("text/html;charset=gbk");
        PrintWriter out=response.getWriter();
        if(checkcode.equalsIgnoreCase(piccode)){
            out.println("正确");
        }else{
            out.println("错误");
        }
        out.flush();
        out.close();
    }
}