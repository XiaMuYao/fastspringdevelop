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
object ResultUtil {
    /**
     * 成功
     */
    private const val SUCCESS = "success"
    /**
     * 失败
     */
    private const val FAILURE = "failure"

    /**
     * 成功返回 没有数据
     *
     * @param <T>
     * @return
    </T> */
    fun <T> makeOkRsp(): RetResult<T?>? {
        return RetResult<T?>().setCode(ResultCode.SUCCESS).setMsg(SUCCESS)
    }

    /**
     * 成功返回 有数据
     *
     * @param data
     * @param <T>
     * @return
    </T> */
    fun <T> makeOkDataRsp(data: T): RetResult<T?>? {
        return RetResult<T?>().setCode(ResultCode.SUCCESS).setMsg(SUCCESS).setData(data)
    }

    /**
     * 失败返回
     *
     * @param message
     * @param <T>
     * @return
    </T> */
    fun <T> makeErrRsp(message: String?): RetResult<T?>? {
        return RetResult<T?>().setCode(ResultCode.FAIL).setMsg(message)
    }

    /**
     * 自定义返回-没数据
     *
     * @param code 状态码
     * @param msg  数据
     * @return
     */
    fun <T> makeRsp(code: ResultCode?, msg: String?): RetResult<T?>? {
        return RetResult<T?>().setCode(code!!).setMsg(msg)
    }

    /**
     * 自定义返回-有数据
     *
     * @param code 状态码
     * @param msg  提示信息
     * @param data 数据
     * @return
     */
    fun <T> makeRsp(code: ResultCode?, msg: String?, data: T): RetResult<T?>? {
        return RetResult<T?>().setCode(code!!).setMsg(msg).setData(data)
    }
}