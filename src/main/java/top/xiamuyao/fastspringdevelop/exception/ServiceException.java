package top.xiamuyao.fastspringdevelop.exception;

import lombok.Getter;
import top.xiamuyao.fastspringdevelop.enums.ResultCode;

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
public class ServiceException extends Exception {
    private ResultCode code;
    private String message;

    public ServiceException( String message) {
        this.code = ResultCode.INTERNAL_SERVER_ERROR;
        this.message = message;
    }

    public ServiceException( String message, ResultCode code) {
        this.code = code;
        this.message = message;
    }

}