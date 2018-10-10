package top.xiamuyao.fastspringdevelop.api.controller;


import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import top.xiamuyao.fastspringdevelop.JpushUtil;
import top.xiamuyao.fastspringdevelop.api.service.IAddressService;
import top.xiamuyao.fastspringdevelop.util.ResultUtil;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 夏沐尧
 * @since 2018-09-25
 */
@Slf4j
@RestController
@RequestMapping("/api/address")
public class AddressController {
    @Autowired
    IAddressService mIAddressService;

    @GetMapping
    public Object getData() {
//        JpushUtil.jpushAndroid();
//        return ResultUtil.makeOkDataRsp(mIAddressService.list(null));
//        return ResultUtil.makeErrRsp("错误信息");
        return ResultUtil.makeOkRsp();

    }

    @ApiOperation(value = "获取用户列表", notes = "")
    @GetMapping("/install")
    public Object InstallData() {
        return ResultUtil.makeOkDataRsp(mIAddressService.list(null));
    }
}