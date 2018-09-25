package top.xiamuyao.fastspringdevelop;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FastspringdevelopApplicationTests {

    private final Logger mLogger = LoggerFactory.getLogger(FastspringdevelopApplicationTests.class);
//    @Autowired
//    private UserMapper userMapper;
//
    @Test
    public void testSelect() {
        mLogger.debug("123123123");
//        System.out.println(("----- selectAll method test ------"));
//        List<User> userList = userMapper.selectList(null);
//        Assert.assertEquals(5, userList.size());
//        userList.forEach(System.out::println);
    }


}
