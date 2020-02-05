package com.confluence.fast.exception

import com.confluence.fast.enums.ResultCode
import lombok.Getter

/**
 * ================================================
 * 作    者：夏沐尧  Github地址：https://github.com/XiaMuYaoDQX
 * 版    本：1.0
 * 创建日期： 2018/10/29
 * 描    述：服务异常类
 * 修订历史：
 * ================================================
 */
@Getter
class ServiceException : Exception {
    private var code: ResultCode
    override var message: String?

    constructor(message: String?) {
        code = ResultCode.INTERNAL_SERVER_ERROR
        this.message = message
    }

    constructor(message: String?, code: ResultCode) {
        this.code = code
        this.message = message
    }
}