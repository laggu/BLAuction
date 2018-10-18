
package com.bla.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.bla.biz.BiddingBiz;
import com.bla.biz.PhotoBiz;
import com.bla.frame.Biz;
import com.bla.util.FileSave;
import com.bla.vo.AuctionVO;
import com.bla.vo.BiddingVO;
import com.bla.vo.PhotoVO;

@Controller
public class AuctionController {
	@Resource(name = "abiz")
	Biz<AuctionVO, Integer> abiz;

	@Resource(name = "pbiz")
	PhotoBiz pbiz;
	
	@Resource(name = "bbiz")
	BiddingBiz bbiz;

	// 경매 등록 페이지 넘기기
	@RequestMapping("/createAuction.bla")
	public ModelAndView createAuction() {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		mv.addObject("centerpage", "auction/register");
		return mv;
	}

	// 경매 등록 실시
	@RequestMapping("/createAuctionimpl.bla")
	public ModelAndView createAuctionimpl(@RequestParam("upload1") MultipartFile img1,
			@RequestParam("upload2") MultipartFile img2, HttpServletRequest request) {// 원래면 매개변수로 받음
		// test 용 데이터
		AuctionVO auction = new AuctionVO(1, new Date().getTime(), 7, "iphone", 1000000l,
				"0x9671652cf6fba11f7576b341b95bff03ad27d581", 1, "좋은 아이폰", "before",
				"0x9671652cf6fba11f7578d341b95bff03ad27d581", "#패션", 151231212l);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		try {
			// abiz.register(auction);
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
	@RequestMapping("/auctiondetail.bla")
	public ModelAndView auctiondetail(HttpServletRequest request, Map<String, String> map) {
		String auctionId = request.getParameter("auctionid");// list로 받아온 객체의 auctionid를 저장시켜서 넘겨 받아서 select해온다.

		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		try {
			//상세 뿌려주기
			
			//mv.addObject("auct_id",auct_id);로 다시 넘겨준다.
			mv.addObject("centerpage", "auction/detail");
		} catch (Exception e) {
			e.printStackTrace();
			mv.addObject("centerpage", "auction/detail");
		}
		return mv;
	}

	// 각종 카테고리 리스트 뿌려주기/////////////////////////////////
	@RequestMapping("/allCategory.bla")
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

	@RequestMapping("/clothing.bla")
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

	// 옥션 정보 수정하기 단, auction_status가 입찰 전일 경우에만!
	@RequestMapping("/updateAuctionimpl.bla")
	public ModelAndView updateAuctionimpl(AuctionVO auction, HttpServletRequest request) {
		return null;
	}

	// 입찰할 때 Bidding 정보 INSERT
	@RequestMapping("/biddingimpl.bla")
	public void biddingimpl(HttpServletRequest request) {
		HttpSession session = request.getSession();
		//session에 저장시킨 member_id와 bidder_account를 받는다.
		
		//int member_id = Integer.parseInt((String)session.getAttribute("member_id"));
		//String bidder_account = (String) session.getAttribute("member_account");
		
		//request로 price, time, auct_id를 넘겨받는다.
		//long price = Long.parseLong(request.getParameter("price"));
		long time = System.currentTimeMillis();
		//int auct_id = Integer.parseInt(request.getParameter("auct_id"));
		
		//BiddingVO bid = new BiddingVO(member_id,auct_id,price,time,bidder_account);
		BiddingVO bid = new BiddingVO(3,1,2000000l,time,"0x9671652cf6fba11f7576b341b95bff03ad27d581");
		
		//DB insert
		try {
			bbiz.register(bid);
			System.out.println("bid 성공");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
	}

	// 내가 입찰한 list SELECT
	@RequestMapping("/mybiddinglist.bla")
	public String mybiddinglist(HttpServletRequest request) {
		//먼저 bidding 테이블에서 member_id로 auct_id를 찾고,
		//auct_id로 경매가 무엇이 있는 지 select 후 title과 사진 가져오기,
		//가져온 auct_id로 bidding의 최고가, member_id로의 최고가를 구하시오..
		HttpSession session = request.getSession();
		
		//int member_id = Integer.parseInt((String)session.getAttribute("member_id"));
		
		int member_id = 2;
		
		ArrayList<Integer> auct_ids = null;
		ArrayList<AuctionVO> aucts = new ArrayList<>();
		ArrayList<Long> bidMaxPrice = new ArrayList<>();
		ArrayList<Long> memberBidMaxPrice = new ArrayList<>();
		
		Map<String,Integer> map = new HashMap<>();
		map.put("member_id", member_id);
		
		try {
			//회원이 입찰한 경매 id들(중복제거)
			auct_ids = bbiz.selectAuctIdByMemberId(2);
			
			//회원이 입찰한 경매의 최고가와 그 경매에서 내가 입찰한 최고가 가져오기.
			for(Integer auct_id : auct_ids) {
				aucts.add(abiz.get(auct_id));
				map.put("auct_id", auct_id);
				//비딩의 최고가와 멤버 비딩의 최고가를 가져와야함.
//				bidMaxPrice.add(bbiz.selectBidMaxPrice(auct_id));
//				memberBidMaxPrice.add(bbiz.selectMemberMaxPrice(map));
				//json 객체 및 배열화 해서 AJAX로 내보내야할듯!
				
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}

	// 내가 올린 경매 리스트 SELECT
	@RequestMapping("/myauctionlist.bla")
	public String myauctionlist() {
		//Auction테이블에서 member_id로 select (ArrayList<AuctionVO>)
		
		return null;
	}

	// 내가 낙찰한 물품 리스트 SELECT
	@RequestMapping("/mysuccessbidlist.bla")
	public String mysuccessbidlist() {
		return null;
	}
	
	// 옥션 비딩 리스트 SELECT
	@RequestMapping("/auctionbidlist.bla")
	public String auctionbidlist() {
		return null;
	}

	// 낙찰 됬을 때 실행하는 함수
	@RequestMapping("/successfulbiddingimpl.bla")
	public String successfulbiddingimpl(HttpServletRequest request) {
		return null;
	}

	// 낙찰이 완료되고 물품을 보냈을 때 택배 운송장 번호를 입력.
	@RequestMapping("/deliveryimpl.bla")
	public String deliveryimpl() {
		return null;
	}

	// 최고 입찰자가 바꼈을 때 환불해 주기 위함
	@RequestMapping("/failbiddingimpl.bla")
	public String failbiddingimpl(HttpServletRequest request) {
		return null;
	}

	// 판매자 정보의 페이지 넘기기
	@RequestMapping("/sellerinfo.bla")
	public String sellerinfo(HttpServletResponse response) {
		return null;
	}

	// 회원 등급?
	@RequestMapping("/rateimpl.bla")
	public String rateimpl(HttpServletRequest request) {
		return null;
	}

	// 검색창에서 검색한 결과를 내보내는 함수
	@RequestMapping("/searchimpl.bla")
	public String searchimpl(HttpServletRequest request) {
		return null;
	}

	// 마지막에 낙찰 되었을 때 점검하는 함수
	@RequestMapping("/crosscheck.bla")
	public String crosscheck() {// db의 정보와 smartcontract log를 비교
		return null;
	}

	// 사진 업로드 하는 함수(Photo)
	@RequestMapping("/photoupload.bla")
	public void photoUpload(@RequestParam("file") MultipartFile file, HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();

		// 회원id+timestamp => 이름 설정
		String imgName = file.getOriginalFilename();
		System.out.println(imgName);
		// String seller_id = (String) session.getAttribute("id");
		String seller_id = "1";
		String newImgName = seller_id + "_" + System.currentTimeMillis();

		newImgName += imgName.substring(imgName.indexOf("."));

		// 상대경로로 가져오기
		String path = session.getServletContext().getRealPath("/");
		path += "SummernoteImg";
		System.out.println(path);
		// 파일 저장
		FileSave.save(path, file, newImgName);
		// 디비 insert, select(photo_id, photo_name, photo_path)
		path = "SummernoteImg\\";
		PhotoVO photo = new PhotoVO(newImgName, path, 0);

		// photo_id, name, path JSON화 해서 AJAX로 보내기
		response.setContentType("text/json;charset=utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();

			JSONObject jo = new JSONObject();

			jo.put("photo_name", photo.getPhoto_name());
			jo.put("photo_path", path);

			System.out.println(jo.toJSONString());
			out.print(jo.toJSONString());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			out.close();
		}

	}

	// 사진 삭제하는 함수(Photo)
	@RequestMapping("/photoDelete.bla")
	public void photoDelete(@RequestParam("deletefile") MultipartFile file, HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		
		// 파일 이름 가져오기
		String imgName = file.getOriginalFilename();
		System.out.println("파일 이름 " +imgName);
		
		
	}
}