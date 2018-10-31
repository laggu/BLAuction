package com.bla.controller;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.annotation.Resource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
	
	@RequestMapping("/email.bla")
	public String email(HttpServletRequest request) {
		
		System.out.println("email In");
		return "user/email";
		
	}
	
	@RequestMapping("/emailimpl.bla")
	public ModelAndView emailimpl(HttpServletRequest request, ModelMap mo) throws AddressException, MessagingException{
		String name	 = request.getParameter("names");
		String email = request.getParameter("email");
		ModelAndView mv = new ModelAndView();
		MemberVO member = null;
		
		String host = "smtp.naver.com";
		
		final String username = "hny4813@naver.com";
		final String password = "rnjs20110821!!"; 
		int port=587; 

		
		
		try {
			member = mbiz.get(email);
			
			if(member == null || !(member.getEmail().equals(email))) {
				mv.setViewName("user/email");
				mv.addObject("resultt", "asdf");
				
				return mv; 
			}
			else if(member != null && member.getEmail().equals(email))
			{
				String recipient = email; 
				String subject = "[BLAuction 회원정보] "+member.getName()+"님, password를 전달해 드립니다."; 
				System.out.println("user.getName():"+ member.getName());
				String body = member.getName()+"님, "+ member.getEmail()+" 계정의 비밀번호는 "
						+ member.getPw()+"입니다."; 
				Properties props = System.getProperties(); 

				props.put("mail.smtp.starttls.enable", "true");
				props.put("mail.smtp.host", host); 
				props.put("mail.smtp.auth", "true"); 
				props.put("mail.smtp.port", port); 
				
				Session session = Session.getDefaultInstance(
						props, new javax.mail.Authenticator() { 
							String un=username; 
							String pw=password; 
							protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
								
								return new javax.mail.PasswordAuthentication(un, pw); 
								} 
							}); 
				session.setDebug(true); //for debug 
				Message mimeMessage = new MimeMessage(session); 
				mimeMessage.setFrom(new InternetAddress("hny4813@naver.com")); 
				mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient)); 
		
				mimeMessage.setSubject(MimeUtility.encodeText(subject,"UTF-8", "B")); 
				mimeMessage.setContent(body, "text/html; charset=UTF-8");

				mimeMessage.setText(body); 

				Transport.send(mimeMessage); 

				
				mv.setViewName("user/email");
				mv.addObject("resultt", "asdd");
				
				return mv;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping("/loginimpl.bla")
	public ModelAndView loginimpl(HttpServletRequest request) {
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		String member_account = request.getParameter("member_account");
		HttpSession session = request.getSession();
		ModelAndView mv = new ModelAndView();
		ModelAndView mv2 = new ModelAndView("redirect:/main.bla");
		MemberVO member = null;
		try {
			member = mbiz.get(email);
//			System.out.println(member.getMember_account());
			if(member == null)
			{
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
		
		
		mv2.addObject("centerpage", "center");
		int member_score = member.getScore();
		String member_rate = "0";
		if(member_score >= 300) {
			member_rate = "3";
		}else if(member_score >= 200) {
			member_rate = "2";
		}else if(member_score >= 100) {
			member_rate = "1";
		}else {
			member_rate = "0";
		}
		
		session.setAttribute("member_rate",member_rate);
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

		ModelAndView mv = new ModelAndView("redirect:/main.bla");
		HttpSession session = request.getSession();
		MemberVO member = new MemberVO();

		member.setEmail(request.getParameter("email"));
		member.setPw(request.getParameter("pw"));
		member.setName(request.getParameter("name"));
		member.setAddress(request.getParameter("address"));
		member.setPhone(request.getParameter("phone"));
		String bi = request.getParameter("birth").replace("-", "").substring(2, 8);
		member.setBirth(bi);
		member.setMember_account(request.getParameter("member_account"));

		try {
			biz.register(member);
			member = mbiz.get(member.getEmail());
			mv.addObject("centerpage", "center");
			session.setAttribute("member_id", member.getMember_id());
			session.setAttribute("member_account", member.getMember_account());
			session.setAttribute("loginStatus", "loginSuccess");
			session.setAttribute("name", member.getName());
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
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		HttpSession session = request.getSession();
		if(session.getAttribute("member_id") == null) {
			mv.setViewName("redirect:/login.bla");
			return mv;
		}
		int member_id = (Integer) session.getAttribute("member_id");
		
		try {
			member = mbiz.get(member_id);
			mv.addObject("member", member);
			mv.addObject("centerpage", "user/mypage");
		} catch (Exception e) {
			mv.setViewName("redirect:/login.bla");
		}

		return mv;
	}

	@RequestMapping("/mypageimpl.bla")
	public ModelAndView mypageimpl(HttpServletRequest request, MemberVO member) {
		// memeberid를 가져와서 회원 정보 select한 정보 mv.addObject로 추가
		HttpSession session = request.getSession();
		int member_id = Integer.parseInt((String) session.getAttribute("member_id"));
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");

		try {
			member = mbiz.get(member_id);
			mv.addObject("member", member);
			mv.addObject("centerpage", "user/mypage");
		} catch (Exception e) {
			mv.setViewName("redirect:/login.bla");
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
			mv.setViewName("redirect:/login.bla");
		}
		return mv;
	}

}
