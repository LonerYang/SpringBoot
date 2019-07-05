package com.ahead.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author Yang
 * @version 1.0
 * @time 2019/4/7
 */
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //定制请求的授权规则
        http.authorizeRequests()
                    .antMatchers("/").permitAll()
                    .antMatchers("/level1/**").hasRole("VIP1")
                    .antMatchers("/level2/**").hasRole("VIP2")
                    .antMatchers("/level3/**").hasRole("VIP3");

        /**
         *  开启自动配置的登录功能，如果没有登录，没有权限就会跳到登录页面
         *         1、/login来到登录页
         *         2、/login?error表示登录失败
         *         3、更多详细规定见官方文档
         *         4、设置权限验证跳转登录页面的路径loginPage
         *               不设置的话默认get方式请求/login就会跳转到登录页面
         *                   post方式请求/login就会来处理登录
         *         5、默认的表单用户名参数名为username，密码为password
         *               可通过usernameParameter，passwordParameter自定义
         *         6、如果自定义登录页面的请求为/userlogin
         *               get方式请求/userlogin就会跳转到登录页面（页面自己写）
         *               post方式请求/userlogin就会被用来处理登录（spring会处理）
         */
        http.formLogin().loginPage("/userlogin")
                .usernameParameter("user").passwordParameter("pwd");
//        http.formLogin();
        //开启自动配置的注销功能；
        // 1、默认访问/logout就会清空session表示用户注销然后跳转到/login?logout（登录页面）
        // 2、自定义注销后跳转的路径（welcome页面）
        http.logout().logoutSuccessUrl("/");

        //开启记住我（自动登录）的功能
        //原理跟Servlet时期使用一样：把用户名和密码存到Cookie中，下次访问该网站时会带上Cookie，
        // 然后拦截到Cookie中的用户名和密码实现自动登录
        //自定义自动登陆通过rememberMeParameter设置参数名(默认是remeber-me)
        http.rememberMe().rememberMeParameter("remeberme");
    }

    /**
     * 定制认证规则
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        //可以设置内存指定的登录的账号密码,指定角色
        //不加.passwordEncoder(new MyPasswordEncoder())
        //就不是以明文的方式进行匹配，会报错
        auth.inMemoryAuthentication()
                //这样，页面提交时候，密码以明文的方式进行匹配。
                .passwordEncoder(new MyPasswordEncoder())
                    .withUser("zhangsan").password("12345").roles("VIP1", "VIP2", "VIP3")
                .and()
                    .withUser("lisi").password("12345").roles("VIP2", "VIP3")
                .and()
                   .withUser("wangwu").password("12345").roles("VIP1", "VIP3");
    }


   public class MyPasswordEncoder implements PasswordEncoder {

       @Override
       public String encode(CharSequence charSequence) {
           return charSequence.toString();
       }

       @Override
       public boolean matches(CharSequence charSequence, String s) {
           return s.equals(charSequence.toString());
       }
   }
}
