package pers.wayss.getMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Message {

    volatile private static Message msg;
    
    private static List<String> lst;
    
    private Message(){
        lst = new ArrayList<String>();
        StringBuffer sb1 = new StringBuffer("撸起袖子加油干，一张蓝图绘到底");
        lst.add(sb1.toString());
        lst.add("不忘初心，继续前进");
        lst.add("好久没有人把牛皮吹得这么清新脱俗了");
        lst.add("自从得了神经病，整个人都精神多了");
        lst.add("我想早恋，但是已经晚了……");
        lst.add("没人牵手，我就揣兜");
        lst.add("既宅又腐，前途未卜");
        lst.add("https://github.com/wayss000/PracticeCode/tree/master/GetMessage");
        //TODO 这里的中文输出全是乱码
        for(int i = 0; i < msg.lst.size(); i++){
            System.out.println(msg.lst.get(i));
        }
    }
    
    /**
     * 随机的返回一条信息
     * @return
     */
    public static String message(){
        //使用DCL创建一个单例
        if(msg == null){
            synchronized(Message.class){
                if(msg == null){
                    msg = new Message();
                }
            }
        }

        int length = msg.lst.size();
        Random rd = new Random();
        int indexRam = rd.nextInt(length);
        return msg.lst.get(indexRam);
    }

}
