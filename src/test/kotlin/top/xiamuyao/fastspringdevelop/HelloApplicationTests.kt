package top.xiamuyao.fastspringdevelop

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import top.xiamuyao.fastspringdevelop.api.entity.User
import top.xiamuyao.fastspringdevelop.api.mapper.UserMapper
import java.util.function.Consumer

/**
 * ================================================
 * 作    者：夏沐尧  Github地址：https://github.com/XiaMuYaoDQX
 * 版    本：1.0
 * 创建日期： 2018/12/22
 * 描    述：
 * 修订历史：
 * ================================================
 */
@RunWith(SpringRunner::class)
@SpringBootTest
class HelloApplicationTests {
    @Autowired
    var userMapper: UserMapper? = null

    @Test
    fun insert() {
        val user = User()
        user.name = "张4丰"
        val insert = userMapper!!.insert(user)
        println("受影响行数::$insert")
    }

    @Test
    fun insertAR() {
        val user = User()
        user.name = "张5丰"
        val insert = user.insert()
        println("是否插入成功::$insert")
    }

    @Test
    fun selectListAR() {
        val user = User()
        val selectAll = user.selectAll()
        println("${selectAll.forEach { println("数据::${it.name}") }}")
    }

    @Test
    fun selectAllList() {
        val users = userMapper!!.selectList(null)
        users.forEach(Consumer { x: User? -> println(x) })
    }

}