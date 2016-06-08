package top.oahnus.servlet;

import top.oahnus.Bean.Message;
import top.oahnus.service.MaintainService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jackstrom on 2016/6/6.
 */
public class UpdateDataServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        String description = req.getParameter("description");
        String content = req.getParameter("content");
        String id = req.getParameter("id");

        if(id!=null||!id.equals("")){
            //创建新的message对象
            Message message = new Message();
            message.setId(Integer.parseInt(id));
            message.setDescription(description);
            message.setContent(content);

            //创建服务实例
            MaintainService maintainService = new MaintainService();
            maintainService.updateOne(message);

            //刷新列表
            req.getRequestDispatcher("/servlet/list").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
