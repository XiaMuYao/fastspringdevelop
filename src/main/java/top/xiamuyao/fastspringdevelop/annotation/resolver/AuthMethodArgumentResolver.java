package top.xiamuyao.fastspringdevelop.annotation.resolver;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import top.xiamuyao.fastspringdevelop.annotation.service.TokenService;
import top.xiamuyao.fastspringdevelop.enums.TokenType;
import top.xiamuyao.fastspringdevelop.exception.ServiceException;

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
                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        String token = webRequest.getHeader("Access-Token");
        if(token!=null) {
            return tokenService.parse(TokenType.ACCESS, token).getBody().get("accountId");
        } else {
            throw new ServiceException("Sign required", 401);
        }
    }

}