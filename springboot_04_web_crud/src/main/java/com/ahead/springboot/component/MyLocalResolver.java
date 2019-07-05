package com.ahead.springboot.component;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @author Yang
 * @version 1.0
 * @time 2019/2/12
 */
public class MyLocalResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        Locale locale = null;

        //从请求头中获取浏览器的语言
        String header = request.getHeader("Accept-Language");
        String[] languages = header.split(",");
        //这里我只判断了中英文
        if(languages[0].contains("en")) {
            locale = new Locale("en", "US");
        }
        if(languages[0].contains("zh")) {
            locale = new Locale("zh", "CH");
        }

        //只要手动选择了语言优先使用自己选择的语言
        String l = request.getParameter("l");
        if(!StringUtils.isEmpty(l)) {
            String[] split = l.split("_");
            //param1:语言代码  param2：国家代码
            locale = new Locale(split[0], split[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
