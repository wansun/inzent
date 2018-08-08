package com.demo.model.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.demo.model.vo.MemberVO;

@Mapper
public interface MemberMapper {
	public MemberVO login(MemberVO memberVO);
}
