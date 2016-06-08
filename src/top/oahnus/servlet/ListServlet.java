package top.oahnus.servlet;

import top.oahnus.Bean.Message;
import top.oahnus.service.QueryService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by jackstrom on 2016/5/20.
 */

/**
 * 列表页面初始化
 */
public class ListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置request的编码方式
        req.setCharacterEncoding("utf-8");

        //获取request中的参数command和description
        String command = req.getParameter("command");
        String description = req.getParameter("description");

        //将command和description添加到request属性中
        req.setAttribute("command",command);
        req.setAttribute("description",description);

        //实例化一个service
        QueryService queryService = new QueryService();
        List<Message> messages = queryService.queryMessageList(command,description);
        //将保存有查询结果的list保存到request中
        req.setAttribute("messages",messages);

        //页面跳转到展示页面
        req.getRequestDispatcher("/WEB-INF/jsp/back/list.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
