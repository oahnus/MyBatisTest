package top.oahnus.servlet;

import top.oahnus.service.MaintainService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by jackstrom on 2016/5/24.
 */
public class DeleteOneServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置request的编码方式
        req.setCharacterEncoding("utf-8");

        //获取request中的参数id
        int id = Integer.parseInt(req.getParameter("id"));

        //实例化一个service
        MaintainService maintainService = new MaintainService();
        maintainService.deleteOne(id);

        //页面跳转到展示页面
        req.getRequestDispatcher("/servlet/list").forward(req,resp);
    }
}
