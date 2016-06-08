package top.oahnus.servlet;

import top.oahnus.service.MaintainService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jackstrom on 2016/5/25.
 */
public class AddDataServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        //保存参数
        List<String> params = new ArrayList<>();

        String command = req.getParameter("command");
        String description = req.getParameter("description");
        String content = req.getParameter("content");

        params.add(command);
        params.add(description);
        params.add(content);

        //将参数传递给服务
        MaintainService maintainService = new MaintainService();
        maintainService.add(params);

        //跳转到列表
        req.getRequestDispatcher("/servlet/list").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
