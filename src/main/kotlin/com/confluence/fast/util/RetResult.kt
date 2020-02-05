package com.confluence.fast.util

import com.confluence.fast.enums.ResultCode

/**
 * ================================================
 * 作    者：夏沐尧  Github地址：https://github.com/XiaMuYaoDQX
 * 版    本：1.0
 * 创建日期： 2018/9/26
 * 描    述：
 * 修订历史：
 * ================================================
 */
class RetResult<T> {
    /**
     * 错误码
     */
    var code = 0
    /**
     * 提示信息
     */
    var msg: String? = null
        private set
    /**
     * 具体内容
     */
    var data: T? = null
        private set

    fun setCode(retCode: ResultCode): RetResult<T> {
        code = retCode.code
        return this
    }

    fun setCode(code: Int): RetResult<T> {
        this.code = code
        return this
    }

    fun setMsg(msg: String?): RetResult<T> {
        this.msg = msg
        return this
    }

    fun setData(data: T): RetResult<T> {
        this.data = data
        return this
    }
}