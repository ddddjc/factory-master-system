package com.djc.util;

import com.djc.entity.Employee;
import com.djc.entity.EmployeeDuty;
import com.djc.entity.Information;
import com.djc.entity.InformationReceiver;
import com.djc.service.InformationReceiverService;
import com.djc.service.InformationService;
import com.djc.service.impl.WebSocket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author: djc
 * @Date: 2023-05-16-19:26
 * @Description:消息管理工具类
 */
@Component
public class InformationUtils {
    @Autowired
    private InformationService informationService;

    @Autowired
    private InformationReceiverService informationReceiverService;
    @Autowired
    private WebSocket webSocket;
    /**
     * 插入消息
     * @param senderId
     * @param informationTitle
     * @param informationContent
     * @return
     */
    public Information insert(Integer senderId,String informationTitle,String informationContent){
        Information information=new Information(null,senderId,informationTitle,informationContent);
        return informationService.insert(information);
    }
    public void send(Integer employeeId, Integer InformationId,String priority) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String Time=df.format(new Date());// new Date()为获取当前系统时间
        Date date = df.parse(Time);
        InformationReceiver send=new InformationReceiver(null,employeeId,InformationId,date,"未读",priority);
        InformationReceiver insert = informationReceiverService.insert(send);
        webSocket.sendOneMessage(employeeId,"有人向你发送了消息");
    }
    public void sendInformation(Integer senderId,Integer receiverId,String informationTitle,String informationContent,String priority) throws ParseException {
        Information insert = insert(senderId, informationTitle, informationContent);
        send(receiverId,insert.getInformationId(),priority);
    }
    public void sendInformation(Integer senderId, List<Employee> employeeList, String informationTitle, String informationContent, String priority) throws ParseException {
        Information insert = insert(senderId, informationTitle, informationContent);
        for (Employee e:employeeList) {
            send(e.getEmployeeId(),insert.getInformationId(),priority);
        }
    }
}
