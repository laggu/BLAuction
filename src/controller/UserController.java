package controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import frame.Biz;
import vo.UserVO;

@Controller
public class UserController {

	@Resource(name = "ubiz")
	Biz<UserVO, String> biz;

	@RequestMapping("/main.bla")
	public ModelAndView main() {
		return null;
	}

	@RequestMapping("/login.bla")
	public ModelAndView login() {
		return null;
	}

	@RequestMapping("/loginimpl.bla")
	public String loginimpl(HttpServletRequest request) {
		return null;
	}

	@RequestMapping("/logout.bla")
	public String logout(HttpServletRequest request) {
		return null;
	}

	@RequestMapping("/register.bla")
	public ModelAndView register() {
		return null;
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

}