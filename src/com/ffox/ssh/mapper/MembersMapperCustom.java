package com.ffox.ssh.mapper;

import com.ffox.ssh.po.MembersCustom;

public interface MembersMapperCustom {
	
	public MembersCustom findMemberByLoginName(String loginName) throws Exception;
}
