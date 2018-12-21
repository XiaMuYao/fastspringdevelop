package top.xiamuyao.fastspringdevelop.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

import top.xiamuyao.fastspringdevelop.util.ResultUtil;
import top.xiamuyao.fastspringdevelop.util.RetResult;

/**
 * ================================================
 * 作    者：夏沐尧  Github地址：https://github.com/XiaMuYaoDQX
 * 版    本：1.0
 * 创建日期： 2018/12/18
 * 描    述：测试用
 * 修订历史：
 * ================================================
 */
@RestController
public class MobileController {

    @Autowired
    protected StringRedisTemplate  redisTemplate;


    @GetMapping("/get")
    public RetResult getToken() {

        String xiamuyao =  redisTemplate.opsForValue().get("xiamuyao");

        return ResultUtil.makeOkDataRsp(xiamuyao);
    }

    @GetMapping("/set")
    public RetResult setToken(@RequestParam(value = "accountId") String accountname) {

        redisTemplate.opsForValue().set("xiamuyao", accountname);


        return ResultUtil.makeOkDataRsp("");
    }

}
