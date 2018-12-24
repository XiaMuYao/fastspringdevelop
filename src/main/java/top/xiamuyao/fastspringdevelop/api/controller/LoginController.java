package top.xiamuyao.fastspringdevelop.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import lombok.NonNull;
import top.xiamuyao.fastspringdevelop.enums.TokenType;
import top.xiamuyao.fastspringdevelop.exception.ServiceException;
import top.xiamuyao.fastspringdevelop.util.JwtUtil;
import top.xiamuyao.fastspringdevelop.util.ResultUtil;
import top.xiamuyao.fastspringdevelop.util.RetResult;

/**
 * ================================================
 * 作    者：夏沐尧  Github地址：https://github.com/XiaMuYaoDQX
 * 版    本：1.0
 * 创建日期： 2018/12/18
 * 描    述：
 * 修订历史：
 * ================================================
 */
@RestController
public class LoginController {

    @Autowired
    protected StringRedisTemplate redisTemplate;

    /**
     * 获取token
     *
     * @param accountname
     * @param password
     * @return
     */
    @GetMapping("/login")
    public RetResult getToken(@NonNull @RequestParam(value = "accountId") String accountname,
                              @NonNull @RequestParam(value = "password") String password) {

//        if (用户名和密码正确) {
        if (redisTemplate.hasKey(accountname)) {
            return ResultUtil.makeOkDataRsp(redisTemplate.opsForValue().get(accountname));
        } else {
            String s = JwtUtil.generateToken(accountname);
            redisTemplate.opsForValue().set(accountname, s, JwtUtil.EXPIRATION_TIME, TimeUnit.MILLISECONDS);
            return ResultUtil.makeOkDataRsp(s);
        }
//        } else {
//        return ResultUtil.makeErrRsp("用户名或者密码错误");
//        }

    }
    /**
     * 验证token 并且返回解析信息 测试用 一般没有
     *
     * @param token
     * @return
     */
    @PostMapping("/api/jwt")
    public RetResult getJwt(@RequestParam("token") String token) {
        return ResultUtil.makeOkDataRsp(JwtUtil.parse(token));
    }

    /**
     * 测试token授权
     *
     * @param accountId
     * @return
     */
    @GetMapping("/api/auth")
    public RetResult auth(@RequestHeader(value = JwtUtil.USER_NAME) String accountId) {
        return ResultUtil.makeOkDataRsp(accountId);
        /**
         * Access-Token headers里面
         */
    }
}
