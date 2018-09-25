package top.xiamuyao.fastspringdevelop.util;

import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;

public class ApiResult implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer code;

    private Object data;

    private String message;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ApiResult(Integer code, Object data, String message) {
        super();
        this.code = code;
        this.data = data;
        this.message = message;
    }

    public ApiResult() {
    }

    public static ApiResult successResponse(Object data) {
        return new ApiResult(HttpServletResponse.SC_OK, data, "请求成功");
    }

    public static ApiResult successResponse(Object data, String message) {
        return new ApiResult(HttpServletResponse.SC_OK, data, message);
    }

    public static ApiResult errorResponse(Object data) {
        return new ApiResult(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, data, "系统异常");
    }

    public static ApiResult errorResponse(Object data, String message) {
        return new ApiResult(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, data, message);
    }

    public static ApiResult customizedResponse(Integer code, Object data, String message) {
        return new ApiResult(code, data, message);
    }

    /**
     * 根据数据库操作是否成功，发出响应
     *
     * @param isSuccess
     * @return
     */
    public static ApiResult isSuccessOperate(boolean isSuccess) {
        if (isSuccess) {
            return successResponse(null, "操作成功");
        } else {
            return errorResponse(null, "操作失败");
        }
    }

}
