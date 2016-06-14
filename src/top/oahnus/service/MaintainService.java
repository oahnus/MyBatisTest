package top.oahnus.service;

import top.oahnus.Bean.Message;
import top.oahnus.dao.MessageDAO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jackstrom on 2016/5/24.
 */
public class MaintainService {

    public void add(List<String> params){
        MessageDAO messageDAO = new MessageDAO();
        messageDAO.addData(params);
    }

    public void deleteOne(int id){

//        System.out.println(id);
        MessageDAO messageDAO = new MessageDAO();
        //执行删除
        messageDAO.deleteOne(id);

    }

    public void deleteBatch(String[] ids){
        List<Integer> idList = new ArrayList<>();
        //将传进的id数组转换成id集合
        for(String id:ids){
            idList.add(Integer.valueOf(id));
        }

        MessageDAO messageDAO = new MessageDAO();
        messageDAO.deleteBatch(idList);
    }


    //修改后台数据
    public void updateOne(Message message){
        MessageDAO messageDAO = new MessageDAO();
        messageDAO.updateOne(message);
    }
}
