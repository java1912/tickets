package com.yueqian.tickets;

import javax.annotation.Resource;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Resource
	private BCryptPasswordEncoder bcryptEncoder;
	@Resource
	private UserDetailsService udService;
	

	/**
	 * 配置校验信息
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//使用自定义的service配置自定义的验证信息
		auth.userDetailsService(udService).passwordEncoder(bcryptEncoder);
	}

	/**
	 *  设置全局忽略
	 * 
	 */
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers(
				"/**/*.js",
				"/**/*.css",
				"/static/**",
				"/public/**",
				"/**/bootstrap/**",
				"/img/**");
	}

	/**
	 * 全局权限校验配置； 安全校验参数配置
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//关闭默认的仿冒用户请求的拦截
		http.csrf().disable();
		http.rememberMe().disable();
		
		//配置指定路径的权限
//		http.authorizeRequests().antMatchers("/emp/**").hasAnyRole("manager","admin","common");
//		http.authorizeRequests().antMatchers("/user/list").hasAnyAuthority("user:list");
//		http.authorizeRequests().antMatchers("/user/add").access("hasRole('manager') and hasAuthority('user:add')");
		
		//设定所有请求需要认证
		http.authorizeRequests().anyRequest().authenticated();
		
		//设定自定义登录页面
		http.formLogin().loginPage("/loginPage")
			.loginProcessingUrl("/loginProc")
			.usernameParameter("account")
			.passwordParameter("pwd")
			.defaultSuccessUrl("/index")
			.failureForwardUrl("/loginPage")
			.permitAll();
		
		//配置注销登录
		http.logout().logoutUrl("/exit").logoutSuccessUrl("/loginPage").deleteCookies("JSESSIONID");
		
		//配置权限失败的页面
		http.exceptionHandling().accessDeniedPage("/accessDeniedPage");
	}

}
