package top.oahnus.service;

import com.sun.org.apache.bcel.internal.generic.ICONST;
import org.apache.ibatis.javassist.compiler.ast.IntConst;
import top.oahnus.Bean.Message;
import top.oahnus.Util.Iconst;
import top.oahnus.dao.MessageDAO;

import java.util.List;

/**
 * Created by jackstrom on 2016/5/22.
 */
//列表相关的业务功能
public class QueryService {
    /**
     * 按照指令和描述来查询列表
     * @param command 指令
     * @param description 描述
     * @return 包含符合查询结果的列表
     */
    public List<Message> queryMessageList(String command, String description) {
        MessageDAO messageDAO = new MessageDAO();
        return messageDAO.queryMessageList(command,description);
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
            List<Message> messageList = messageDAO.queryMessageList(null, null);

            StringBuffer sb = new StringBuffer();

            for(int i=0;i<messageList.size();i++){
                sb.append("回复["+messageList.get(i).getCommand()+"]可以查看["+messageList.get(i).getDescription()+"]\n");
            }
            return sb.toString();
        }
        else {
            List<Message> messageList = messageDAO.queryMessageList(command, null);
            if (messageList.size() > 0) {
                return messageList.get(0).getContent();
            }
            return Iconst.NO_MACHINE_CONTENT;
        }
    }
}
