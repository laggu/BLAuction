package com.bla.controller;

import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bla.biz.MemberBiz;
import com.bla.biz.PhotoBiz;
import com.bla.dao.MemberDao;
import com.bla.frame.Biz;
import com.bla.vo.MemberVO;

@Controller
public class MemberController {

	@Resource(name = "mbiz")
	Biz<MemberVO, String> biz;

	@Resource(name = "mbiz")
	MemberBiz mbiz;

	@RequestMapping("/login.bla")
	public String login() {
		return "user/login";
	}

	@RequestMapping("/failMeta.bla")
	public String failMeta() {
		return "user/failMeta";
	}

	@RequestMapping("/loginimpl.bla")
	public ModelAndView loginimpl(HttpServletRequest request) {
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		String member_account = request.getParameter("member_account");
		HttpSession session = request.getSession();
		ModelAndView mv = new ModelAndView();
		ModelAndView mv2 = new ModelAndView();
		MemberVO member = null;

		try {
			member = mbiz.get(email);
			if(member == null)
			{
				//null�϶� ó�����ָ��
				mv.setViewName("main");
				mv.addObject("centerpage", "user/fail");
				mv.addObject("resultt", "asdd");
				return mv;
			}
			if(!(member.getMember_account().equals(member_account)) && !(member.getPw().equals(pw)))
			{
				mv.setViewName("main");
				mv.addObject("centerpage", "user/failAll");
				return mv;
			}
			if (!(member.getMember_account().equals(member_account))) {
				mv.setViewName("main");
				mv.addObject("centerpage", "user/failMeta");
				return mv;
			}
			
			if(!(member.getPw().equals(pw))) {
				//null�϶� ó�����ָ��
				mv.setViewName("main");
				mv.addObject("centerpage", "user/fail");
				mv.addObject("resultt", "asdf");
				return mv;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		mv2.setViewName("main");
		mv2.addObject("centerpage", "center");
		System.out.println("로그인성공");
		session.setAttribute("member_id", member.getMember_id());
		session.setAttribute("name", member.getName());
		session.setAttribute("address", member.getAddress());
		session.setAttribute("member_account", member.getMember_account());
		session.setAttribute("loginStatus", "loginSuccess");
		
		return mv2;

	}

	@RequestMapping("/logout.bla")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();

		if (session != null) {
			session.invalidate();
		}

		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		return "redirect:/main.bla";
	}

	@RequestMapping("/register.bla")
	public String register() {
		return "user/register";
	}

	@RequestMapping("/idcheck.bla")
	@ResponseBody
	public void idCheck(String id, HttpServletResponse response) {
	}

	@RequestMapping("/jusoPopup.bla")
	public String jusoPopup() {
		return "user/jusoPopup";
	}

	@RequestMapping("/registerimpl.bla")
	@ResponseBody
	public ModelAndView registerimpl(HttpServletRequest request, HttpServletResponse response) {

		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		response.setContentType("text/html;charset=UTF-8");

		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		MemberVO member = new MemberVO();

		member.setEmail(request.getParameter("email"));
		member.setPw(request.getParameter("pw"));
		member.setName(request.getParameter("name"));
		member.setAddress(request.getParameter("address"));
		member.setPhone(request.getParameter("phone"));
		System.out.println("date : " + request.getParameter("birth"));
		String bi = request.getParameter("birth").replace("-", "").substring(2, 8);
		System.out.println("bi:" + bi);
		member.setBirth(bi);
		member.setMember_account(request.getParameter("member_account"));

		mv.setViewName("main");
		try {
			biz.register(member);
			mv.addObject("centerpage", "center");
			session.setAttribute("email", member.getEmail());
			session.setAttribute("loginStatus", "loginSuccess");
			return mv;
		} catch (Exception e) {
			mv.setViewName("main");
			mv.addObject("centerpage", "user/register");
			
			mv.addObject("resultt", "asdd");
			e.printStackTrace();
			return mv;
		}

	}

	@RequestMapping("/mypage.bla")
	public ModelAndView mypage(HttpServletRequest request, MemberVO member) {

		HttpSession session = request.getSession();
		int member_id = (Integer) session.getAttribute("member_id");
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");

		try {
			member = mbiz.get(member_id);
			mv.addObject("member", member);
			mv.addObject("centerpage", "user/mypage");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return mv;
	}

	@RequestMapping("/mypageimpl.bla")
	public ModelAndView mypageimpl(HttpServletRequest request, MemberVO member) {
		// memeberid를 가져와서 회원 정보 select한 정보 mv.addObject로 추가
		HttpSession session = request.getSession();
		int member_id = Integer.parseInt((String) session.getAttribute("member_id"));
		System.out.println("meber_id"+member_id);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");

		try {
			member = mbiz.get(member_id);
			mv.addObject("member", member);
			mv.addObject("centerpage", "user/mypage");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return mv;
	}

	@RequestMapping("/pwdupdateimpl.bla")
	public ModelAndView pwdupdateimpl(HttpServletRequest request) {
		HttpSession session = request.getSession();
		int member_id = (Integer) session.getAttribute("member_id");
		String npwd = request.getParameter("changed_Pw");
		MemberVO user = null;
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		try {
			user = mbiz.get(member_id);
			user.setPw(npwd);
			
			mbiz.modify(user);
			mv.addObject("member", user);
			mv.addObject("centerpage", "user/mypage");
		} catch (Exception e) {
			mv.addObject("centerpage", "user/mypage");
			e.printStackTrace();
		}
		return mv;
	}

	@RequestMapping("/phoneupdateimpl.bla")
	public ModelAndView phoneupdateimpl(HttpServletRequest request) {
		HttpSession session = request.getSession();
		int member_id = (Integer) session.getAttribute("member_id");
		String nphone = request.getParameter("changed_phone");
		System.out.println("newphone:" +nphone);
		MemberVO user = null;
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");

		try {
			user = mbiz.get(member_id);
			user.setPhone(nphone);
			
			biz.modify(user);
			mv.addObject("member", user);
			mv.addObject("centerpage", "user/mypage");
		} catch (Exception e) {
			mv.addObject("centerpage", "user/mypage");
			e.printStackTrace();
		}
		return mv;
	}

	@RequestMapping("/addressupdateimpl.bla")
	public ModelAndView addressupdateimpl(HttpServletRequest request) {
		HttpSession session = request.getSession();
		int member_id = (Integer) session.getAttribute("member_id");
		String naddress = request.getParameter("changed_address");
		
		MemberVO user = null;
		
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");

		try {
			user = mbiz.get(member_id);
			user.setAddress(naddress);
			
			
			biz.modify(user);
			mv.addObject("member", user);
			mv.addObject("centerpage", "user/mypage");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}

}
