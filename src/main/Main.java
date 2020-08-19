package main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/**
 * @author: Thorn
 * @Date: 2020/8/19 00:04
 * @Description:主程序
 */
public class Main extends AirTicket{
    private static Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args) {
        //将返回的map集合保存到Arraylist中
        ArrayList<Map> list = new ArrayList<>();
        //解析配置文件
        Ticket ticket = ParseConfiguration("configuration.xml");
        //循环解析界面
        for (int i = 0; i < ticket.getDates().length; i++) {
            //访问并解析网页
           list.add(ParHtml(GetHtml(ticket.getKey(), ticket.getFromcitycode(), ticket.getTocitycode(), ticket.getDates()[i], ticket.getFromcityname(), ticket.getTocityname())));
        }
        //设置Server酱提醒消息头(Markdown格式)
        String Message = "| 日期 | 价格 |\n" +
                "| :------ | ------: |\n";
        //循环取出日期和时间
        for (Map value:list
             ) {
            Iterator it = value.entrySet().iterator();
            while (it.hasNext())
            {
                Map.Entry entry = (Map.Entry) it.next();
                Message = Message + "| "+entry.getKey()+"&nbsp; &nbsp;"+" | "+entry.getValue()+" |  \n";
            }
        }
        //将提示信息发送到微信客户端
        SendMessage(ticket.getKey(),"今日"+ticket.getFromcityname()+"-"+ ticket.getTocityname()+"机票价格",Message);
        logger.info("program run successful!");
    }
}
