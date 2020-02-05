package top.xiamuyao.fastspringdevelop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.xiamuyao.fastspringdevelop.api.entity.User;
import top.xiamuyao.fastspringdevelop.api.mapper.UserMapper;

import java.util.List;

/**
 * ================================================
 * 作    者：夏沐尧  Github地址：https://github.com/XiaMuYaoDQX
 * 版    本：1.0
 * 创建日期： 2018/12/22
 * 描    述：
 * 修订历史：
 * ================================================
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloApplicationTests {
    @Autowired
    public UserMapper userMapper;

    @Test
    public void insert(){
        User user = new User();
        user.setName("张4丰");
        int insert = userMapper.insert(user);
        System.out.println("受影响行数::" + insert);
    }
    @Test
    public void selectAllList(){
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

}