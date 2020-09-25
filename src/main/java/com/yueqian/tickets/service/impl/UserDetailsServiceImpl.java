package com.yueqian.tickets.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.yueqian.tickets.domain.EmployeeVO;
import com.yueqian.tickets.domain.RoleVO;
import com.yueqian.tickets.mapper.EmployeeMapper;
import com.yueqian.tickets.mapper.RoleMapper;
import com.yueqian.tickets.util.StringUtils;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Resource
	private BCryptPasswordEncoder bpe;
	@Resource
	private RoleMapper roleMapper;
	@Resource
	private EmployeeMapper empMapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//非法验证，校验失败
		if(StringUtils.isEmptyStr(username)) {
			return null;
		}
		//校验通过的返回用户
		User user = null;
		
		//根据用户名判断是员工还是旅客
		if(username.matches("1[3458]\\d{9}")) {
			
		}else {
			//员工登录
			EmployeeVO emp = empMapper.getEmployeeByAccName(username);
			List<RoleVO> roleList = roleMapper.getRoleByAccName(username);
			List<GrantedAuthority> grantedList = new ArrayList<>();
			for (RoleVO role : roleList) {
				grantedList.add(new SimpleGrantedAuthority(role.getRoleName()));
			}
			
			user = new User(emp.getAccount(), emp.getPwd(), grantedList);
		}
		return user;
	}
	
	public static void main(String[] args) {
		BCryptPasswordEncoder e = new BCryptPasswordEncoder(12);
		System.out.println(e.encode("123"));
	}

}
