//package top.xiamuyao.fastspringdevelop.util;
//
//
//import javax.servlet.http.HttpServletResponse;
//
///**
// * ================================================
// * 作    者：夏沐尧  Github地址：https://github.com/XiaMuYaoDQX
// * 版    本：1.0
// * 创建日期： 2018/5/29
// * 描    述：
// * 修订历史：
// * ================================================
// */
//public class ResultUtil<T> {
//    /**
//     * 错误码
//     */
//    public int code;
//    /**
//     * 提示信息
//     */
//    private String msg;
//    /**
//     * 具体内容
//     */
//    private T data;
//    /**
//     * 成功
//     */
//    private final static String SUCCESS = "请求成功";
//    /**
//     * 失败
//     */
//    private final static String FAILURE = "请求失败";
//
//    /**
//     * 成功返回 没有数据
//     *
//     * @param <T>
//     * @return
//     */
//    public static <T> ResultUtil<T> makeOkRsp() {
//        return new ResultUtil<T>().setCode(HttpServletResponse.SC_OK).setMsg(SUCCESS);
//    }
//
//    /**
//     * 成功返回 有数据
//     *
//     * @param data
//     * @param <T>
//     * @return
//     */
//    public static <T> ResultUtil<T> makeOkDataRsp(T data) {
//        return new ResultUtil<T>().setCode(ResultCode.SUCCESS).setMsg(SUCCESS).setData(data);
//    }
//
//    /**
//     * 失败返回
//     *
//     * @param message
//     * @param <T>
//     * @return
//     */
//    public static <T> ResultUtil<T> makeErrRsp(String message) {
//        return new ResultUtil<T>().setCode(ResultCode.FAIL).setMsg(SUCCESS);
//    }
//
//    /**
//     * 自定义返回-没数据
//     *
//     * @param code 状态码
//     * @param msg  数据
//     * @return
//     */
//    public static <T> ResultUtil<T> makeRsp(int code, String msg) {
//        return new ResultUtil<T>().setCode(code).setMsg(msg);
//    }
//
//    /**
//     * 自定义返回-有数据
//     *
//     * @param code 状态码
//     * @param msg  提示信息
//     * @param data 数据
//     * @return
//     */
//    public static <T> ResultUtil<T> makeRsp(int code, String msg, T data) {
//        return new ResultUtil<T>().setCode(code).setMsg(msg).setData(data);
//    }
//
//
//}