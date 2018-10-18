
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

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.bla.biz.AuctionBiz;
import com.bla.biz.BiddingBiz;
import com.bla.biz.PhotoBiz;
import com.bla.biz.SuccessfulBidBiz;
import com.bla.util.FileSave;
import com.bla.vo.AuctionVO;
import com.bla.vo.BiddingVO;
import com.bla.vo.MemberVO;
import com.bla.vo.PhotoVO;
import com.bla.vo.SuccessfulBidVO;

@Controller
public class AuctionController {
	@Resource(name = "abiz")
	AuctionBiz abiz;

	@Resource(name = "pbiz")
	PhotoBiz pbiz;

	@Resource(name = "bbiz")
	BiddingBiz bbiz;

	@Resource(name = "sbiz")
	SuccessfulBidBiz sbiz;
	
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
			// 상세 뿌려주기

			// mv.addObject("auct_id",auct_id);로 다시 넘겨준다.
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
		// session에 저장시킨 member_id와 bidder_account를 받는다.

		// int member_id = Integer.parseInt((String)session.getAttribute("member_id"));
		// String bidder_account = (String) session.getAttribute("member_account");

		// request로 price, time, auct_id를 넘겨받는다.
		// long price = Long.parseLong(request.getParameter("price"));
		long time = System.currentTimeMillis();
		// int auct_id = Integer.parseInt(request.getParameter("auct_id"));

		// BiddingVO bid = new BiddingVO(member_id,auct_id,price,time,bidder_account);
		BiddingVO bid = new BiddingVO(3, 1, 2000000l, time, "0x9671652cf6fba11f7576b341b95bff03ad27d581");

		// DB insert
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
	public void mybiddinglist(HttpServletRequest request,HttpServletResponse response) {
		// 먼저 bidding 테이블에서 member_id로 auct_id를 찾고,
		// auct_id로 경매가 무엇이 있는 지 select 후 title과 사진 가져오기,
		// 가져온 auct_id로 bidding의 최고가, member_id로의 최고가를 구하시오..
		HttpSession session = request.getSession();

		// int member_id = (Integer)session.getAttribute("member_id");

		int member_id = 2;

		ArrayList<Integer> auct_ids = null;
		AuctionVO auct = null;
		ArrayList<PhotoVO> photos = null;
		ArrayList<Long> bidMaxPrice = new ArrayList<>();
		ArrayList<Long> memberBidMaxPrice = new ArrayList<>();
		
		
		Map<String, Integer> map = new HashMap<>();
		map.put("member_id", member_id);
		
		//json 배열과 객체 선언
		JSONObject jo = null;
		JSONArray ja = null;
		
		response.setContentType("text/json;charset=utf-8");
		PrintWriter out = null;

		try {
			// 회원이 입찰한 경매 id들(중복제거)
			auct_ids = bbiz.selectAuctIdByMemberId(2);

			// 회원이 입찰한 경매의 최고가와 그 경매에서 내가 입찰한 최고가 가져오기.
			for (Integer auct_id : auct_ids) {
				// json 객체 및 배열화 해서 AJAX로 내보내야할듯!
				auct = abiz.get(auct_id);
				jo.put("auct_id", auct_id);
				jo.put("title", auct.getAuct_title());
				jo.put("auction_status", auct.getAuction_status());
				jo.put("auction_address", auct.getAuction_address());
				//사진도 Photo테이블에서 경로랑 이름 들고와야함..
				photos = pbiz.getAll(auct_id);	
				for(PhotoVO photoVO : photos) {
					int i=0;
					String pathKey = "photoPath"+i;
					String nameKey = "photoName"+i;
					jo.put(pathKey,photoVO.getPhoto_path());
					jo.put(nameKey, photoVO.getPhoto_name());
					i++;
				}
				map.put("auct_id", auct_id);
				// 비딩의 최고가와 멤버 비딩의 최고가를 가져와야함.
				jo.put("bidMaxPrice", bbiz.selectBidMaxPrice(auct_id));
				jo.put("memberBidMaxPrice", bbiz.selectMemberMaxPrice(map));
				
				ja.add(jo);
			}
			
			out = response.getWriter();
			out.print(ja.toJSONString());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// 내가 올린 경매 리스트 SELECT, AJAX 써야함
	@RequestMapping("/myauctionlist.bla")
	public void myauctionlist(HttpServletRequest request) {
		// Auction테이블에서 member_id로 select (ArrayList<AuctionVO>)
		HttpSession session = request.getSession();

		// int member_id = Integer.parseInt((String)session.getAttribute("member_id"));
		
		int member_id =1;
		ArrayList<AuctionVO> auctions = null;
		try {
			//Auction 테이블에서 member_id로 내가 올린경매를 가져온다.
			//auct_id로 사진을 가져온다. 
			//경매 중-입찰전, 입찰 중, 낙찰, 취소 => 쿼리문 조건으로 날려서 따로 가지고와서 json화 한다.
			auctions = abiz.selectAuctionByMember(member_id);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	// 내가 낙찰한 물품 리스트 SELECT
	@RequestMapping("/mysuccessbidlist.bla")
	public void mysuccessbidlist(HttpServletRequest request) {
		HttpSession session = request.getSession();

		// int member_id = Integer.parseInt((String)session.getAttribute("member_id"));
		int member_id = 1;
		ArrayList<SuccessfulBidVO> successfulBids = null;
		
		try {
			// 처음 한 쿼리로
			// Bidding 테이블에서 member_id가 가지고 있는 bid_id를 가져와서 
			// SUCCESSFUL_BID 테이블에서 bid_id가 포함되어있는 것에서 successfulbid 가져오기
			
			successfulBids = sbiz.selectMySuccessfulBid(member_id);
			
			// successfulbidvo에서 bid_id로 Bidding table에서 price 가져오기
			Long price = 0l;
			// 다른 쿼리로 auct_id 로 Photo 테이블에서 사진 가져오고
			ArrayList<PhotoVO> photos = null;
			// 다른 쿼리로 auct_id 로 member_id를 가져오고
			int auct_member_id = 0;
			// 다른 쿼리로 member_id로 판매자 이름, 판매자 전화번호 
			MemberVO sellerInfo = null;
			
			for(SuccessfulBidVO successfulBid : successfulBids) {
				price = bbiz.get(successfulBid.getBid_id()).getPrice();
				photos = pbiz.getAll(successfulBid.getAuct_id());
				auct_member_id = abiz.selectMemberIdByAuct(successfulBid.getAuct_id());
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	// 옥션 비딩 리스트 SELECT
	@RequestMapping("/auctionbidlist.bla")
	public String auctionbidlist() {
		//입찰 해당 auct_id를 받아서 Bidding 객체를 가져온다.
		//해당하는 입찰자의 정보를 가져온다.
		int auct_id = 0;
		
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
		} finally {
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
		System.out.println("파일 이름 " + imgName);

	}
}