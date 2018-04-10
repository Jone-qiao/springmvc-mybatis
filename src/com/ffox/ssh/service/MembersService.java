package com.ffox.ssh.service;

import com.ffox.ssh.po.MembersCustom;

public interface MembersService {

	public MembersCustom findMemberByLoginName(String loginName) throws Exception;
}
