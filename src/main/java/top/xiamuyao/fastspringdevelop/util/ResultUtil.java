package top.xiamuyao.fastspringdevelop.util;

import top.xiamuyao.fastspringdevelop.enums.ResultCode;

/**
 * ================================================
 * 作    者：夏沐尧  Github地址：https://github.com/XiaMuYaoDQX
 * 版    本：1.0
 * 创建日期： 2018/9/26
 * 描    述：
 * 修订历史：
 * ================================================
 */
public class ResultUtil {
    /**
     * 成功
     */
    private final static String SUCCESS = "success";
    /**
     * 失败
     */
    private final static String FAILURE = "failure";

    /**
     * 成功返回 没有数据
     *
     * @param <T>
     * @return
     */
    public static <T> RetResult<T> makeOkRsp() {
        return new RetResult<T>().setCode(ResultCode.SUCCESS).setMsg(SUCCESS);
    }

    /**
     * 成功返回 有数据
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> RetResult<T> makeOkDataRsp(T data) {
        return new RetResult<T>().setCode(ResultCode.SUCCESS).setMsg(SUCCESS).setData(data);
    }

    /**
     * 失败返回
     *
     * @param message
     * @param <T>
     * @return
     */
    public static <T> RetResult<T> makeErrRsp(String message) {
        return new RetResult<T>().setCode(ResultCode.FAIL).setMsg(message);
    }

    /**
     * 自定义返回-没数据
     *
     * @param code 状态码
     * @param msg  数据
     * @return
     */
    public static <T> RetResult<T> makeRsp(ResultCode code, String msg) {
        return new RetResult<T>().setCode(code).setMsg(msg);
    }

    /**
     * 自定义返回-有数据
     *
     * @param code 状态码
     * @param msg  提示信息
     * @param data 数据
     * @return
     */
    public static <T> RetResult<T> makeRsp(ResultCode code, String msg, T data) {
        return new RetResult<T>().setCode(code).setMsg(msg).setData(data);
    }


}