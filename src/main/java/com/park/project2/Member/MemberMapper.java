package com.park.project2.Member;

import java.util.List;

public interface MemberMapper {

	public abstract List<Member> getMemberById(Member m);
	public abstract int join(Member m);
	public abstract int update(Member m);
	public abstract int signOut(Member m);
	
}
