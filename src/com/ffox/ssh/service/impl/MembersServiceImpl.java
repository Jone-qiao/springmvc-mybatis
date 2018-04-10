package com.ffox.ssh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.ffox.ssh.mapper.MembersMapperCustom;
import com.ffox.ssh.po.MembersCustom;
import com.ffox.ssh.service.MembersService;

public class MembersServiceImpl implements MembersService {
	
	@Autowired
	private MembersMapperCustom membersMapperCustom;

	@Override
	public MembersCustom findMemberByLoginName(String loginName) throws Exception {
		return membersMapperCustom.findMemberByLoginName(loginName);
	}

}
