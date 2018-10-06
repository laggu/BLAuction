package com.bla.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bla.frame.Biz;
import com.bla.vo.UserVO;

@Controller
public class UserController {

	@Resource(name = "ubiz")
	Biz<UserVO, String> biz;

	@RequestMapping("/main.bla")
	public ModelAndView main() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		mv.addObject("centerpage", "main");
		return mv;
	}

	@RequestMapping("/login.bla")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		mv.addObject("centerpage", "user/login");
		return mv;
	}

	@RequestMapping("/loginimpl.bla")
	public String loginimpl(HttpServletRequest request) {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String loginState = "0";

		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		UserVO user = null;
		try {
			/*user = service.get(id);
			if (pwd.equals(user.getPwd())) {
				HttpSession session = request.getSession();
				session.setAttribute("userId", id);
				System.out.println("login success!");
				System.out.println("ID:" + id + "Pwd:" + pwd);
				return "redirect:/main.bla"; 
			} else {
				request.setAttribute("loginState", loginState);
				mv.addObject("centerpage", "user/login");
				System.out.println("login failed...");
				System.out.println("ID:" + id + "Pwd:" + pwd + "loginState:" + loginState);
				return "redirect:/main.bla"; 
			}*/
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("loginState", loginState);
			return "redirect:/main.bla"; 
		}
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
	public ModelAndView register() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		mv.addObject("centerpage", "user/register");
		return mv;
	}

	@RequestMapping("/idcheck.bla")
	@ResponseBody
	public void idCheck(String id,HttpServletResponse response) {
	}

	@RequestMapping("/registerimpl.bla")
	public ModelAndView registerimpl(HttpServletRequest request, UserVO user) {
		return null;
	}

	@RequestMapping("/mypage.bla")
	public ModelAndView mypage(HttpServletRequest request) {
		return null;
	}
	
	@RequestMapping("/pwdupdateimpl.bla")
	public ModelAndView pwdupdateimpl(HttpServletRequest request,UserVO user) {
		return null;
	}
	
	@RequestMapping("/userupdateimpl.bla")
	public ModelAndView userupdateimpl() {
		return null;
	}

}