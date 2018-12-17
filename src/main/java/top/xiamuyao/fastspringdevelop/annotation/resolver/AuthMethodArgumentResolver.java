package top.xiamuyao.fastspringdevelop.annotation.resolver;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import top.xiamuyao.fastspringdevelop.annotation.Auth;
import top.xiamuyao.fastspringdevelop.annotation.service.TokenService;
import top.xiamuyao.fastspringdevelop.enums.TokenType;
import top.xiamuyao.fastspringdevelop.exception.ServiceException;
import top.xiamuyao.fastspringdevelop.util.ResultCode;

/**
 * ================================================
 * 作    者：夏沐尧  Github地址：https://github.com/XiaMuYaoDQX
 * 版    本：1.0
 * 创建日期： 2018/10/29
 * 描    述：认证注解参数解析器
 * 修订历史：
 * ================================================
 */
public class AuthMethodArgumentResolver implements HandlerMethodArgumentResolver {

    @Autowired
    private TokenService tokenService;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().isAssignableFrom(int.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory) {

        String token = webRequest.getHeader("Access-Token");

        if (token != null) {
            return tokenService.parse(TokenType.ACCESS, token).getBody().get("accountId");
        } else {
            throw new ServiceException("需要签名", ResultCode.TOKEN_FALSE);
        }

        /**
         * MultiPerson annotation = parameter.getParameterAnnotation(MultiPerson.class);
         *         String firstName = webRequest.getParameter(annotation.value() + ".first_name");
         *         String lastName = webRequest.getParameter(annotation.value() + ".last_name");
         *         return new Person(firstName, lastName);
         */
    }

}