package top.xiamuyao.fastspringdevelop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import top.xiamuyao.fastspringdevelop.aaaaaaaaaaaaa.Sender;

/**
 * ================================================
 * 作    者：夏沐尧  Github地址：https://github.com/XiaMuYaoDQX
 * 版    本：1.0
 * 创建日期： 2018/12/22
 * 描    述：
 * 修订历史：
 * ================================================
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class HelloApplicationTests {

    @Autowired
    private Sender sender;

    @Test
    public void hello() throws Exception {
//        sender.send(message);
    }

}