package com.ginf.cms.resolvers;

import com.ginf.cms.annotations.ActiveUser;
import com.ginf.cms.entities.AuthUser;
import com.ginf.cms.entities.User;
import com.ginf.cms.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.support.WebArgumentResolver;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.security.Principal;

public class ActiveUserWebArgumentResolver implements HandlerMethodArgumentResolver {
    @Autowired
    private IUserService userService;

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return
                methodParameter.getParameterAnnotation(ActiveUser.class) != null
                        && methodParameter.getParameterType().equals(User.class);
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter,
                                  ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest,
                                  WebDataBinderFactory binderFactory) throws Exception {

        if (this.supportsParameter(methodParameter)) {
            Principal principal = webRequest.getUserPrincipal();
            try {
                org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) ((Authentication) principal).getPrincipal();
                AuthUser authUser = new AuthUser(user);
                return userService.findOne(authUser);
            } catch (Exception exception) {
                return null;
            }
        } else {
            return WebArgumentResolver.UNRESOLVED;
        }
    }
}