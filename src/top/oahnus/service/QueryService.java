package top.oahnus.service;

import com.sun.org.apache.bcel.internal.generic.ICONST;
import org.apache.ibatis.javassist.compiler.ast.IntConst;
import top.oahnus.Bean.Message;
import top.oahnus.Util.Iconst;
import top.oahnus.dao.MessageDAO;
import top.oahnus.extra.Page;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jackstrom on 2016/5/22.
 */
//列表相关的业务功能
public class QueryService {
    /**
     * 按照指令和描述来查询列表
     * @param command 指令
     * @param description 描述
     * @param page 当前页面的信息
     * @return 包含符合查询结果的列表
     */
    public List<Message> queryMessageList(String command, String description, Page page) {
        MessageDAO messageDAO = new MessageDAO();
        //将参数封装在Message中
        Message message = new Message();
        message.setCommand(command);
        message.setDescription(description);

        //根据条件查询总条数
        int totalNumber = messageDAO.count(message);
        //将获取的总条数设置到page中
        page.setTotalNumber(totalNumber);

        //将message和page放在Map中，传入service中
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("message",message);
        parameter.put("page",page);

        //
        return messageDAO.queryMessageList(parameter);
    }

    /**
     * 通过指令查询自动回复的内容
     * @param command 指令
     * @return 返回 指令对应的自动回复内容
     */
    public String queryByCommand(String command){
        MessageDAO messageDAO = new MessageDAO();

        //如果用户输入帮助，显示所有指令
        if(Iconst.HELP.equals(command)){
            //如果指令数少，并设置了一对多的关系，可使用此方法
//            List<Message> messageList = messageDAO.queryMessageList(null);
//
//            StringBuffer sb = new StringBuffer();
//
//            for(int i=0;i<messageList.size();i++){
//                sb.append("回复["+messageList.get(i).getCommand()+"]可以查看["+messageList.get(i).getDescription()+"]\n");
//            }
//            return sb.toString();

            //指令数较多，取消掉回显所有指令的功能
            return "更多内容";
        }
        else {
            Message param = new Message();
            param.setCommand(command);
            Message message = messageDAO.findMessage(param);
            if (message!=null) {
                return message.getContent();
            }
            return Iconst.NO_MACHINE_CONTENT;
        }
    }
}
