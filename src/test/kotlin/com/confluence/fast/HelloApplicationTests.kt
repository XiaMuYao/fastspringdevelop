package com.confluence.fast

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper
import com.confluence.fast.api.entity.User
import com.confluence.fast.api.mapper.UserMapper
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

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
    lateinit var userMapper: UserMapper

    @Test
    fun selectAllList() {
        val wrapper = QueryWrapper<User>().apply { this.like("name", "夏") }
        val selectList = userMapper.selectList(wrapper)
        println(selectList.toString())
    }

    /**
     * AR 模式去处理数据
     */
    @Test
    fun selectAllListAR() {
        User().apply {
            val selectAll = this.selectAll()
            selectAll.forEach { println(it.toString()) }
        }

    }
}