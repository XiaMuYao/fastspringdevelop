package top.xiamuyao.fastspringdevelop.api.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import lombok.NonNull;
import top.xiamuyao.fastspringdevelop.api.entity.User;
import top.xiamuyao.fastspringdevelop.api.mapper.UserMapper;
import top.xiamuyao.fastspringdevelop.api.service.IUserService;
import top.xiamuyao.fastspringdevelop.util.ResultUtil;
import top.xiamuyao.fastspringdevelop.util.RetResult;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 夏沐尧
 * @since 2018-12-16
 */
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    IUserService userService;

    /**
     * 增加一定数量的注册码
     *
     * @param num       多少个
     * @param startTime 开始时间 13位时间戳
     * @param stopTime  停止时间 13位时间戳
     * @return
     */
    @PostMapping("/addnum")
    public RetResult addRegisterList(@RequestParam("num") int num,
                                     @RequestParam("startTime") String startTime,
                                     @RequestParam("stopTime") String stopTime) {

        Date startTimeDate = new Date(Long.parseLong(startTime));
        Date stopTimeDate = new Date(Long.parseLong(stopTime));
        List<User> tempUser = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            User user = new User();
            user.setStartTime(startTimeDate);
            user.setStopTime(stopTimeDate);

            user.setRegisterCode(UUID.randomUUID().toString());

            tempUser.add(user);
        }

        userService.saveBatch(tempUser);
        return ResultUtil.makeOkRsp();
    }


    /**
     * 分页返回数据
     *
     * @param pageNumber 页数 默认第一页
     * @param pageSize   返回条数 默认20条
     * @return
     */
    @GetMapping("/list")
    public RetResult getList(@NonNull @RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber, @RequestParam(value = "pagesize", defaultValue = "20") Integer pageSize) {
        Page<User> objectPage = new Page<>(pageNumber, pageSize);
        return ResultUtil.makeOkDataRsp(userService.page(objectPage, null));
    }

    /**
     * 更新其中一条数据 也就是用户使用了注册码
     *
     * @return
     */
    // TODO: 2018/12/16 如果已经被激活 则不能再次激活
    // TODO: 2018/12/16 定时任务 如果注册码已经过期 那就逻辑删除
    @PostMapping("/update")
    public RetResult update(@RequestParam("equipmentID") String equipmentID,
                            @RequestParam("registerCode") String registerCode) {
        User user = userService.selectOneByRegisterCode(registerCode);
        if (user == null) {
            return ResultUtil.makeErrRsp("激活失败");
        } else {
            user.setEquipmentID(equipmentID);
        }
        return ResultUtil.makeOkDataRsp(userService.saveOrUpdate(user));

    }
}
