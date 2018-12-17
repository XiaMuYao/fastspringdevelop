package top.xiamuyao.fastspringdevelop.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import lombok.NonNull;
import top.xiamuyao.fastspringdevelop.annotation.Auth;
import top.xiamuyao.fastspringdevelop.annotation.service.TokenService;
import top.xiamuyao.fastspringdevelop.enums.TokenType;
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
@RequestMapping("/api/login")
public class LoginController {
    @Autowired
    private TokenService tokenService;

    /**
     * 获取token
     *
     * @param username
     * @param password
     * @return
     */
    @GetMapping("")
    public RetResult getToken(@NonNull @RequestParam(value = "username") String username,
                              @NonNull @RequestParam(value = "password") String password) {
        Map<String, Object> payload = new HashMap<String, Object>();
        payload.put("username", username);
        payload.put("password", password);
        return ResultUtil.makeOkDataRsp(tokenService.generate(TokenType.ACCESS, payload, 1));
    }

    /**
     * 验证token 并且返回解析信息 测试用 一般没有
     *
     * @param token
     * @return
     */
    @PostMapping("/jwt")
    public RetResult getJwt(@RequestParam("token") String token) {
        return ResultUtil.makeOkDataRsp(tokenService.parse(TokenType.ACCESS, token));
        /**
         * {
         *     "code": 200,
         *     "data": {
         *         "body": {
         *             "password": "18945709505",
         *             "username": "xiamuyao",
         *             "sub": "ACCESS",
         *             "exp": 1545109206
         *         },
         *         "header": {
         *             "alg": "HS256"
         *         },
         *         "signature": "ig_3PZvIgcbro6beIYytvvkg3U2iLnhBNLrT5S58Zjw"
         *     },
         *     "msg": "success"
         * }
         * 这里的返回信息在这里
         */
    }

    /**
     * 测试token授权
     *
     * @param accountId
     * @return
     */
    @GetMapping("/auth")
    public RetResult auth(@Auth int accountId) {
        return ResultUtil.makeOkDataRsp(accountId);
        /**
         * Access-Token headers里面
         */
    }
}
