package top.xiamuyao.fastspringdevelop.aaaaaaaaaaaaa;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * ================================================
 * 作    者：夏沐尧  Github地址：https://github.com/XiaMuYaoDQX
 * 版    本：1.0
 * 创建日期： 2018/12/22
 * 描    述：消息生产者
 * 修订历史：
 * ================================================
 */
@Component
public class Sender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(String message) {
//        String context = "hello " + new Date();
//        System.out.println("消息生产者 生产的消息  : " + message);
        this.rabbitTemplate.convertAndSend("hello", message);
    }


}
