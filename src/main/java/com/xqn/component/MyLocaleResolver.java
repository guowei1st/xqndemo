package com.xqn.component;

import jdk.nashorn.internal.ir.RuntimeNode;
import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.rmi.registry.LocateRegistry;
import java.util.Locale;

/*

 */
public class MyLocaleResolver implements LocaleResolver {


    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        String l= httpServletRequest.getParameter("l");
         Locale locale=Locale.getDefault();
         if(!StringUtils.isEmpty(l)) {
             String[] s = l.split("_");
             locale = new Locale(s[0], s[1]);
         }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
