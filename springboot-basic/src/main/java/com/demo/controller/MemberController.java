package com.demo.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.model.mapper.MemberMapper;
import com.demo.model.vo.MemberVO;

@Controller
public class MemberController {

	@Resource
	private MemberMapper memberMapper;
	
	/**
	 * 로그인 컨트롤러
	 * @param memberVO
	 * @param request
	 * @return
	 */
	@PostMapping("login.do")
	public String login(MemberVO memberVO, HttpServletRequest request) {
		MemberVO mvo=memberMapper.login(memberVO);
		if(mvo==null) {
			return "loginFail";
		}else {
			request.getSession().setAttribute("mvo", mvo);
			return "redirect:/";
		}
	}
	
	/**
	 * 로그아웃 컨트롤러
	 * @param request
	 * @return
	 */
	@RequestMapping("logout.do")
	public String logout(HttpServletRequest request) {
		HttpSession session=request.getSession(false);
		if(session!=null)
			session.invalidate();
		return "redirect:/";
	}
}
