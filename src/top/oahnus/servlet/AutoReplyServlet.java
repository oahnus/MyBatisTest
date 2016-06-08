package top.oahnus.servlet;

import top.oahnus.service.QueryService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by jackstrom on 2016/5/30.
 */
public class AutoReplyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置页面编码
        resp.setContentType("text/html;charset=utf-8");
        //获取页面的printWriter
        PrintWriter out = resp.getWriter();

        //创建服务
        QueryService queryService = new QueryService();

        //将回复内容写到resp中
        out.write(queryService.queryByCommand(req.getParameter("content")));
        //关闭printWriter
        out.flush();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
