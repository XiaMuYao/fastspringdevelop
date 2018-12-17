package top.xiamuyao.fastspringdevelop.exception;

import lombok.Getter;
import top.xiamuyao.fastspringdevelop.util.ResultCode;

/**
 * 服务异常类
 *
 * @author Li Jinhui
 * @since 2018/12/6
 */
@Getter
public class ServiceException extends RuntimeException {
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