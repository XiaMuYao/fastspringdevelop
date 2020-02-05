package com.confluence.fast.exception

import com.confluence.fast.enums.ResultCode
import com.confluence.fast.util.ResultUtil
import com.confluence.fast.util.RetResult
import org.slf4j.LoggerFactory
import org.springframework.validation.BindException
import org.springframework.web.bind.MissingServletRequestParameterException
import org.springframework.web.bind.annotation.ExceptionHandler

/**
 * ================================================
 * 作    者：夏沐尧  Github地址：https://github.com/XiaMuYaoDQX
 * 版    本：1.0
 * 创建日期： 2018/10/29
 * 描    述：全局异常处理
 * 修订历史：
 * ================================================
 */
// TODO: 2018/12/18 需要全局处理一下异常的问题  ServiceException 去判断这个的code 组合业务代码使用
//@RestControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler(value = [Exception::class])
    fun handleBadRequest(e: Exception): RetResult<*>? { /*
         * 绑定参数异常
         */
        return if (e is BindException || e is MissingServletRequestParameterException) { //            BindingResult bindingResult = ((BindException) e).getBindingResult();
//            if (null != bindingResult && bindingResult.hasErrors()) {
//                List<Object> jsonList = new ArrayList<>();
//                bindingResult.getFieldErrors().stream().forEach(fieldError -> {
//                    Map<String, Object> jsonObject = new HashMap<>(2);
//                    jsonObject.put("name", fieldError.getField());
//                    jsonObject.put("msg", fieldError.getDefaultMessage());
//                    jsonList.add(jsonObject);
//                });
//                return ResultUtil.makeRsp(ResultCode.FAIL, "参数校验异常", jsonList);
//            }
            ResultUtil.makeRsp(ResultCode.MISS_PARAMETER, "参数校验异常", e.message)
        } else ResultUtil.makeErrRsp<Any>(null)
    }

    @ExceptionHandler(ServiceException::class)
    fun serviceException(e: ServiceException): RetResult<*>? {
        return ResultUtil.makeRsp<Any>(ResultCode.TOKEN_FALSE, e.message)
    }

    companion object {
        private val logger = LoggerFactory.getLogger(GlobalExceptionHandler::class.java)
    }
}