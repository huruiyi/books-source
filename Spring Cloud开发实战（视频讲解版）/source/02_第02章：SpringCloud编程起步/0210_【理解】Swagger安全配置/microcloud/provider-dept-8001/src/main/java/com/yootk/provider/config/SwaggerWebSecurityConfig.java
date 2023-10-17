package com.yootk.provider.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SwaggerWebSecurityConfig extends WebSecurityConfigurerAdapter { // Swagger安全配置
    // 如果有其他的需要，你可以继续进行数据库的连接配置，具体的讲解已经提供过了
    private static final String DEFAULT_PASSWORD =
            "{bcrypt}$2a$10$bvOY6ixvY5DmgiNW.Z79qeV9abQM9a6NbM1n9sejeUnB98C0kKAMu";
    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("swagger") // 默认用户名
                .password(DEFAULT_PASSWORD) // 默认密码
                .roles("USER", "ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/swagger-ui/**", "/v2/api-docs").hasRole("ADMIN")
                .and().httpBasic().and().formLogin()
                .permitAll().and().csrf().disable();
    }
}
