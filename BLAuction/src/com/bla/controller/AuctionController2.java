
package com.bla.controller;

import java.util.ArrayList;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.bla.frame.Biz;
import com.bla.util.FileSave;
import com.bla.vo.AuctionVO;

@Controller
public class AuctionController2 {
	@Resource(name = "abiz")
	Biz<AuctionVO, Integer> biz;

	// 경매 등록 페이지 넘기기
	@RequestMapping("/createAuction2.bla")
	public ModelAndView createAuction() {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		mv.addObject("centerpage", "auction/register");
		return mv;
	}

	// 경매 등록 실시
	@RequestMapping("/createAuctionimpl2.bla")
	@ResponseBody
	public ModelAndView createAuctionimpl(@RequestBody Map<String, Object> params, HttpServletRequest request) {// 원래면 매개변수로 받음
		AuctionVO auction = new AuctionVO();
		HttpSession session = request.getSession();
		
		// 올림경매
		if(((String)params.get("auction_type")).equals("1")) {
			
		}
		
		// 내림경매
		if(((String)params.get("auction_type")).equals("2")) {
			
		}
		
		// 비밀경매
		if(((String)params.get("auction_type")).equals("3")) {
			
		}
		
		// Session에서 member_id 추출
		System.out.println("AUCTION : " + auction);
		
		int member_id = (Integer)session.getAttribute("member_id");
		String seller_account = (String)session.getAttribute("seller_account");
		
		auction.setMember_id(member_id);
		auction.setSeller_account(seller_account);
		
		System.out.println("AUCTION : " + auction);
		
		
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		try {
			//biz.register(auction);
			System.out.println("성공");
			mv.addObject("centerpage", "center");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			mv.addObject("centerpage", "center");
			e.printStackTrace();
		}
		return mv;
	}

	// 옥션 상세 페이지 넘기기
	@RequestMapping("/auctiondetail2.bla")
	public ModelAndView auctiondetail(HttpServletRequest request, Map<String, String> map) {
		String auctionId = request.getParameter("auctionid");// list로 받아온 객체의 auctionid를 저장시켜서 넘겨 받아서 select해온다.

		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		try {

			mv.addObject("centerpage", "auction/detail");
		} catch (Exception e) {
			e.printStackTrace();
			mv.addObject("centerpage", "auction/detail");
		}
		return mv;
	}

	// 각종 카테고리 리스트 뿌려주기/////////////////////////////////
	@RequestMapping("/allCategory2.bla")
	public ModelAndView allCategory(HttpServletRequest request) {
		ArrayList<AuctionVO> list = null;

		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		try {

			mv.addObject("centerpage", "center");
		} catch (Exception e) {
			e.printStackTrace();
			mv.addObject("centerpage", "center");
		}

		return mv;
	}

	@RequestMapping("/clothing2.bla")
	public ModelAndView clothing(HttpServletRequest request) {
		String category = request.getParameter("category");
		ArrayList<AuctionVO> list = null;

		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		try {

			mv.addObject("centerpage", "auction/category/clothing");
		} catch (Exception e) {
			e.printStackTrace();
			mv.addObject("centerpage", "auction/category/clothing");
		}

		return mv;
	}

	@RequestMapping("/beauty2.bla")
	public ModelAndView beauty(HttpServletRequest request) {
		String category = request.getParameter("category");
		ArrayList<AuctionVO> list = null;

		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");

		try {
			mv.addObject("list", list);
			mv.addObject("centerpage", "auction/category/beauty");
		} catch (Exception e) {
			e.printStackTrace();
			mv.addObject("centerpage", "auction/category/beauty");
		}

		return mv;
	}

	@RequestMapping("/sports2.bla")
	public ModelAndView sports(HttpServletRequest request) {
		String category = request.getParameter("category");
		ArrayList<AuctionVO> list = null;

		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");

		try {
			mv.addObject("list", list);
			mv.addObject("centerpage", "auction/category/sports");
		} catch (Exception e) {
			e.printStackTrace();
			mv.addObject("centerpage", "auction/category/sports");
		}

		return mv;
	}

	@RequestMapping("/digital2.bla")
	@ResponseBody
	public ModelAndView digital(HttpServletRequest request) {
		String category = request.getParameter("category");
		ArrayList<AuctionVO> list = null;

		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");

		try {
			mv.addObject("list", list);
			mv.addObject("centerpage", "auction/category/digital");
		} catch (Exception e) {
			e.printStackTrace();
			mv.addObject("centerpage", "auction/category/digital");
		}

		return mv;
	}

	@RequestMapping("/furniture2.bla")
	public ModelAndView furniture(HttpServletRequest request) {
		String category = request.getParameter("category");
		ArrayList<AuctionVO> list = null;

		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");

		try {
			mv.addObject("list", list);
			mv.addObject("centerpage", "auction/category/furniture");
		} catch (Exception e) {
			e.printStackTrace();
			mv.addObject("centerpage", "auction/category/furniture");
		}

		return mv;
	}

	@RequestMapping("/etc2.bla")
	public ModelAndView etc(HttpServletRequest request) {
		String category = request.getParameter("category");
		ArrayList<AuctionVO> list = null;

		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");

		try {
			mv.addObject("list", list);
			mv.addObject("centerpage", "auction/category/etc");
		} catch (Exception e) {
			e.printStackTrace();
			mv.addObject("centerpage", "auction/category/etc");
		}

		return mv;
	}

	// 옥션 정보 수정하기 단, auction_status가 입찰 전일 경우에만!
	@RequestMapping("/updateAuctionimpl2.bla")
	public ModelAndView updateAuctionimpl(AuctionVO auction, HttpServletRequest request) {
		return null;
	}

	// 입찰할 때 Bidding 정보 INSERT
	@RequestMapping("/biddingimpl2.bla")
	public String biddingimpl(HttpServletRequest request) {
		return null;
	}

	// 내가 입찰한 list SELECT
	@RequestMapping("/mybiddinglist2.bla")
	public String mybiddinglist() {
		return null;
	}

	// 내가 올린 경매 리스트 SELECT
	@RequestMapping("/myauctionlist2.bla")
	public String myauctionlist() {
		return null;
	}

	// 내가 낙찰한 물품 리스트 SELECT
	@RequestMapping("/mysuccessbidlist2.bla")
	public String mysuccessbidlist() {
		return null;
	}

	// 낙찰 됬을 때 실행하는 함수
	@RequestMapping("/successfulbiddingimpl2.bla")
	public String successfulbiddingimpl(HttpServletRequest request) {
		return null;
	}

	// 낙찰이 완료되고 물품을 보냈을 때 택배 운송장 번호를 입력.
	@RequestMapping("/deliveryimpl2.bla")
	public String deliveryimpl() {
		return null;
	}

	// 최고 입찰자가 바꼈을 때 환불해 주기 위함
	@RequestMapping("/failbiddingimpl2.bla")
	public String failbiddingimpl(HttpServletRequest request) {
		return null;
	}

	// 판매자 정보의 페이지 넘기기
	@RequestMapping("/sellerinfo2.bla")
	public String sellerinfo(HttpServletResponse response) {
		return null;
	}

	// 회원 등급?
	@RequestMapping("/rateimpl2.bla")
	public String rateimpl(HttpServletRequest request) {
		return null;
	}

	// 검색창에서 검색한 결과를 내보내는 함수
	@RequestMapping("/searchimpl2.bla")
	public String searchimpl(HttpServletRequest request) {
		return null;
	}

	// 마지막에 낙찰 되었을 때 점검하는 함수
	@RequestMapping("/crosscheck2.bla")
	public String crosscheck() {// db의 정보와 smartcontract log를 비교
		return null;
	}

	// 사진 업로드 하는 함수(Photo)
	@RequestMapping("/photoupload2.bla")
	public String photoUpload(@RequestParam("file") MultipartFile file,HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		// 회원id+timestamp => 이름 설정
		String imgName = file.getOriginalFilename();
		System.out.println(imgName);
		//String seller_id = (String) session.getAttribute("id");
		String seller_id = "1";
		String newImgName = seller_id + System.currentTimeMillis();
		
		newImgName += imgName.substring(imgName.indexOf("."));
		
		// 상대경로로 가져오기
		String path = session.getServletContext().getRealPath("/");
		path += "SummernoteImg";
		System.out.println(path);
		//파일 저장
		FileSave.save(path, file, newImgName);
		//디비 insert, select(photo_id, photo_name, photo_path)
		
		return null;
	}
}