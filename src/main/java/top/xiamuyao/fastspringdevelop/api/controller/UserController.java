package top.xiamuyao.fastspringdevelop.api.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import top.xiamuyao.fastspringdevelop.api.entity.User;
import top.xiamuyao.fastspringdevelop.api.service.IUserService;

import java.util.UUID;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 夏沐尧
 * @since 2018-09-22
 */
@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    IUserService mIUserService;

    @GetMapping
    public Object getData() {
        log.debug("12312312123123");
        return mIUserService.list(null);
    }
}
