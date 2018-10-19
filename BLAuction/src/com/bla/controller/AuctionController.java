
package com.bla.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.bla.biz.AuctionBiz;
import com.bla.biz.BiddingBiz;
import com.bla.biz.MemberBiz;
import com.bla.biz.PhotoBiz;
import com.bla.biz.SuccessfulBidBiz;
import com.bla.util.FileSave;
import com.bla.vo.AuctionVO;
import com.bla.vo.BiddingVO;
import com.bla.vo.ListVO;
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

	@Resource(name = "mbiz")
	MemberBiz mbiz;

	// 경매 등록 페이지 넘기기
	@RequestMapping("/createAuction.bla")
	public ModelAndView createAuction() {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		mv.addObject("centerpage", "auction/register");
		return mv;
	}

	// 경매 등록 성공 페이지 넘기기
	@RequestMapping("/createAuction_success.bla")
	public ModelAndView createAuction_success() {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		mv.addObject("centerpage", "auction/success");
		return mv;
	}

	// 경매 등록 실시
	@RequestMapping("/createAuctionimpl.bla")
	@ResponseBody
	public JSONObject createAuctionimpl(MultipartHttpServletRequest multi, HttpServletResponse response) {// 원래면 매개변수로
																											// 받음

		System.out.println("###################### CREATING AUCTION !!! ######################");
		String date = multi.getParameter("due_date");
		String time = multi.getParameter("due_time");

		// Get time
		SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-ddhh:mm");
		Date newdate = null;
		Long duedate = 0l;
		try {
			newdate = form.parse(date + time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		duedate = newdate.getTime();

		// Session에서 정보 추출
		HttpSession session = multi.getSession();
		int member_id = (Integer) session.getAttribute("member_id");
		System.out.println(member_id);
		String seller_account = (String) session.getAttribute("member_account");

//			// Auction 객체 생성 [공통]
		AuctionVO auction = new AuctionVO();
		Long register_date = System.currentTimeMillis();
		auction.setDuedate(duedate);
		Long start_price = Long.parseLong(multi.getParameter("start_price"));
		int auction_type = Integer.parseInt(multi.getParameter("type"));
		auction.setMember_id(member_id);
		auction.setType(auction_type);
		auction.setAuct_title(multi.getParameter("auct_title"));
		auction.setStart_price(start_price);
		auction.setSeller_account(seller_account);
		auction.setCategory_id(Integer.parseInt(multi.getParameter("category_id")));
		System.out.println("DESCRIPTION : " + multi.getParameter("description"));
		auction.setDescription(multi.getParameter("description"));
		auction.setRegister_date(register_date);
		auction.setTag(multi.getParameter("registerTags"));
		auction.setAuction_address("tmp");

		// DB 저장 및 DB select로 auction_id 추출
		Long down_price = 0L;
		int down_term = 0;
		int auct_id = 0;

		try {
			// 내림경매
			if ((multi.getParameter("type")).equals("2")) {
				System.out.println("AUCTION : " + auction);
				down_price = Long.parseLong(multi.getParameter("down_price"));
				down_term = Integer.parseInt(multi.getParameter("down_term"));
				auction.setDown_price(down_price);
				auction.setDown_term(down_term);
				abiz.registerDown(auction);
				System.out.println("AUCTION UPLOADED");
				auct_id = abiz.get(register_date);
				System.out.println("AUCT_ID : " + auct_id);
			} else {
				System.out.println("AUCTION : " + auction);
				abiz.register(auction);
				System.out.println("AUCTION UPLOADED");
				auct_id = abiz.get(register_date);
				System.out.println("AUCT_ID : " + auct_id);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 사진 저장 경로 설정
		String root = multi.getSession().getServletContext().getRealPath("/");
		String path = root + "resources/thumbnail/";
		String newFileName = ""; // 업로드 되는 파일명

		// 경로 폴더 없을 시 폴더 생성
		File dir = new File(path);
		if (!dir.isDirectory()) {
			dir.mkdir();
		}

		// 넘어온 데이터에서 파일추출 후 저장
		Iterator<String> files = multi.getFileNames();
		int i = 0;
		while (files.hasNext()) {
			String uploadFile = files.next();
			if (uploadFile.equals("files"))
				break;
			MultipartFile mFile = multi.getFile(uploadFile);
			String fileName = mFile.getOriginalFilename();
			if (fileName.length() == 0) {
				break;
			}
			String typeName = fileName.substring(fileName.indexOf("."));
			newFileName = auct_id + "_" + i + typeName;
			try {
				FileSave.save(path, mFile, newFileName);
			} catch (Exception e) {
				e.printStackTrace();
			}
			i++;

			// 사진 DB 저장
			PhotoVO photo = new PhotoVO();
			photo.setAuct_id(auct_id);
			photo.setPhoto_name(newFileName);
			photo.setPhoto_path("resources/thumbnail/");
			System.out.println("PHOTO : " + photo);

			try {
				pbiz.register(photo);
				System.out.println("PHOTO UPLOADED");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// JSON 값으로 Client에 return
		JSONObject json = new JSONObject();
		try {
			json.put("auction_id", auct_id);
			json.put("seller_id", 9484);
			json.put("due_date", register_date);
			json.put("start_price", start_price);
			json.put("auction_type", auction_type);
			json.put("down_price", down_price);
			json.put("down_term", down_term);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return json;
	}

	// 옥션 상세 페이지 넘기기
	@RequestMapping("/auctiondetail.bla")
	public ModelAndView auctiondetail(HttpServletRequest request, Map<String, String> map) {

		Integer auct_id = Integer.parseInt(request.getParameter("auctionid"));
		AuctionVO auction = null;
		ArrayList<PhotoVO> photos = null;

		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		try {
			auction = abiz.get(auct_id);
			photos = pbiz.getAll(auct_id);
			System.out.println(photos);
			Long cur_priceL = bbiz.selectBidMaxPrice(auction);
			if (cur_priceL == null) {
				cur_priceL = auction.getStart_price();
			}
			System.out.println(cur_priceL);
			
			Double cur_price = cur_priceL.doubleValue() * 0.001;

			// 카테고리 구하기
			String category = "";
			switch (auction.getCategory_id()) {
			case 1:
				category = "의류 / 잡화";
				break;
			case 2:
				category = "뷰티 / 미용";
				break;
			case 3:
				category = "스포츠 / 레저";
				break;
			case 4:
				category = "디지털 / 가전";
				break;
			case 5:
				category = "생활 / 가구";
				break;
			case 6:
				category = "기타";
				break;
			}

			// 옥션타입 구하기
			String auction_type = "";
			switch (auction.getType()) {
			case 1:
				auction_type = "올림경매";
				break;
			case 2:
				auction_type = "내림경매";
				break;
			case 3:
				auction_type = "비밀경매";
				break;
			}

			// 마감일자 구하기
			String due_date = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분")
					.format(new Date((Long) auction.getDuedate()));

			mv.addObject("auction", auction);
			mv.addObject("cur_price", cur_price);
			mv.addObject("category", category);
			mv.addObject("auction_type", auction_type);
			mv.addObject("due_date", due_date);
			mv.addObject("timestamp", (Long) auction.getDuedate());
			try {
				mv.addObject("photo1", photos.get(0).getPhoto_path() + photos.get(0).getPhoto_name());
				mv.addObject("photo2", photos.get(1).getPhoto_path() + photos.get(1).getPhoto_name());
			} catch (Exception e) {

			}
			mv.addObject("centerpage", "auction/detail");
		} catch (Exception e) {
			e.printStackTrace();
			mv.addObject("centerpage", "auction/detail");
		}
		return mv;
	}

	// 각종 카테고리 리스트 뿌려주기/////////////////////////////////
	@RequestMapping("/main.bla")
	public ModelAndView allCategory(HttpServletRequest request) {
		ArrayList<ListVO> list = new ArrayList<ListVO>();
		ArrayList<AuctionVO> auction_list = null;

		System.out.println("###################### GET ALL ######################");

		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		try {
			auction_list = abiz.get();

			for (int i = 0; i < auction_list.size(); i++) {
				ListVO newlist = new ListVO();
				String due_date = new SimpleDateFormat("MM월 dd일 hh:mm")
						.format(new Date((Long) auction_list.get(i).getDuedate()));
				PhotoVO photo1 = pbiz.getAll(auction_list.get(i).getAuct_id()).get(0);
				PhotoVO photo2 = pbiz.getAll(auction_list.get(i).getAuct_id()).get(1);
				newlist.setAuction(auction_list.get(i));
				newlist.setDuedate(due_date);
				newlist.setPhoto_path_1(photo1.getPhoto_path() + photo1.getPhoto_name());
				newlist.setPhoto_path_2(photo2.getPhoto_path() + photo2.getPhoto_name());
				newlist.setMax_price(bbiz.selectBidMaxPrice(auction_list.get(i)));
				if (newlist.getMax_price() == null) {
					newlist.setMax_price(auction_list.get(i).getStart_price());
				}
				list.add(newlist);
			}

			mv.addObject("list", list);
			mv.addObject("centerpage", "center");
		} catch (Exception e) {
			e.printStackTrace();
			mv.addObject("centerpage", "center");
		}

		Iterator<ListVO> itr = list.iterator();
		while (itr.hasNext()) {
			ListVO listVO = (ListVO) itr.next();
			System.out.println(listVO);
		}

		return mv;
	}

	@RequestMapping("/category.bla")
	public ModelAndView category(HttpServletRequest request) {
		int category_id = Integer.parseInt(request.getParameter("category"));
		ArrayList<ListVO> list = new ArrayList<ListVO>();
		ArrayList<AuctionVO> auction_list = null;

		System.out.println("###################### GET BY CATEGORY ######################");
		System.out.println("CAETGORY ID : " + category_id);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		try {
			auction_list = abiz.getByCategory(category_id);

			for (int i = 0; i < auction_list.size(); i++) {
				ListVO newlist = new ListVO();
				String due_date = new SimpleDateFormat("MM월 dd일 hh:mm")
						.format(new Date((Long) auction_list.get(i).getDuedate()));
				PhotoVO photo1 = pbiz.getAll(auction_list.get(i).getAuct_id()).get(0);
				PhotoVO photo2 = pbiz.getAll(auction_list.get(i).getAuct_id()).get(1);
				newlist.setAuction(auction_list.get(i));
				newlist.setDuedate(due_date);
				newlist.setPhoto_path_1(photo1.getPhoto_path() + photo1.getPhoto_name());
				newlist.setPhoto_path_2(photo2.getPhoto_path() + photo2.getPhoto_name());
				newlist.setMax_price(bbiz.selectBidMaxPrice(auction_list.get(i)));
				if (newlist.getMax_price() == null) {
					newlist.setMax_price(auction_list.get(i).getStart_price());
				}
				list.add(newlist);
			}

			mv.addObject("list", list);
			mv.addObject("category_id", category_id);
			mv.addObject("centerpage", "auction/category");
		} catch (Exception e) {
			e.printStackTrace();
			mv.addObject("centerpage", "auction/category");
		}

		Iterator<ListVO> itr = list.iterator();
		while (itr.hasNext()) {
			ListVO listVO = (ListVO) itr.next();
			System.out.println(listVO);
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
	public void biddingimpl(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		// session에 저장시킨 member_id와 bidder_account를 받는다.

		int member_id = Integer.parseInt((String) session.getAttribute("member_id"));
		String bidder_account = (String) session.getAttribute("member_account");

		// request로 price, time, auct_id를 넘겨받는다.
		long price = Long.parseLong(request.getParameter("price"));
		long time = Long.parseLong(request.getParameter("time"));
		int auct_id = Integer.parseInt(request.getParameter("auction_id"));

		// BiddingVO bid = new BiddingVO(member_id,auct_id,price,time,bidder_account);
		// BiddingVO bid = new BiddingVO(3, 1, 2l, time,
		// "0x9671652cf6fba11f7576b341b95bff03ad27d581");
		BiddingVO bid = new BiddingVO(member_id, auct_id, price, time, bidder_account);

		// json 배열과 객체 선언
		JSONObject jo = new JSONObject();

		response.setContentType("text/json;charset=utf-8");
		PrintWriter out = null;
		// DB insert

		try {
			bbiz.register(bid);
			System.out.println("bid 성공");
			
			out = response.getWriter();
			jo.put("isBid", true);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			jo.put("isBid",false);
		}finally {
			out.print(jo.toJSONString());
			out.close();
		}
		
	}

	// 내가 입찰한 list SELECT
	@RequestMapping("/mybiddinglist.bla")
	public void mybiddinglist(HttpServletRequest request, HttpServletResponse response) {
		// 먼저 bidding 테이블에서 member_id로 auct_id를 찾고,
		// auct_id로 경매가 무엇이 있는 지 select 후 title과 사진 가져오기,
		// 가져온 auct_id로 bidding의 최고가, member_id로의 최고가를 구하시오..
		HttpSession session = request.getSession();

		// int member_id = (Integer)session.getAttribute("member_id");

		int member_id = 2;

		ArrayList<Integer> auct_ids = null;
		AuctionVO auct = null;
		ArrayList<PhotoVO> photos = null;

		Map<String, Integer> map = new HashMap<>();
		map.put("member_id", member_id);

		// json 배열과 객체 선언
		JSONObject jo = null;
		JSONArray ja = null;

		response.setContentType("text/json;charset=utf-8");
		PrintWriter out = null;

		try {
			// 회원이 입찰한 경매 id들(중복제거)
			auct_ids = bbiz.selectAuctIdByMemberId(2);
			ja = new JSONArray();
			// 회원이 입찰한 경매의 최고가와 그 경매에서 내가 입찰한 최고가 가져오기.
			for (Integer auct_id : auct_ids) {
				// json 객체 및 배열화 해서 AJAX로 내보내야할듯!
				auct = abiz.get(auct_id);
				jo = new JSONObject();
				jo.put("auct_id", auct_id);
				jo.put("title", auct.getAuct_title());
				jo.put("auction_status", auct.getAuction_status());
				jo.put("auction_address", auct.getAuction_address());
				// 사진도 Photo테이블에서 경로랑 이름 들고와야함..
				photos = pbiz.getAll(auct_id);
				for (PhotoVO photoVO : photos) {
					int i = 0;
					String pathKey = "photoPath" + i;
					String nameKey = "photoName" + i;
					jo.put(pathKey, photoVO.getPhoto_path());
					jo.put(nameKey, photoVO.getPhoto_name());
					i++;
				}
				map.put("auct_id", auct_id);
				jo.put("bidMaxPrice", bbiz.selectBidMaxPrice(auct));
				jo.put("memberMaxPrice", bbiz.selectMemberMaxPrice(map));

				// json 객체 및 배열화 해서 AJAX로 내보내야할듯!
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
	public void myauctionlist(HttpServletRequest request, HttpServletResponse response) {
		// Auction테이블에서 member_id로 select (ArrayList<AuctionVO>)
		HttpSession session = request.getSession();

		// int member_id = Integer.parseInt((String)session.getAttribute("member_id"));

		int member_id = 1;

		Map<String, Integer> map = new HashMap<>();
		map.put("member_id", member_id);

		ArrayList<AuctionVO> auctions = null;

		// json 객체 배열 선언
		JSONObject jo = new JSONObject();

		JSONArray beforeJa = new JSONArray();
		JSONArray proceedingJa = new JSONArray();
		JSONArray endJa = new JSONArray();
		JSONArray cancelJa = new JSONArray();

		JSONObject beforeJo = null;
		JSONObject proceedingJo = null;
		JSONObject endJo = null;
		JSONObject cancelJo = null;

		response.setContentType("text/json;charset=utf-8");
		PrintWriter out = null;

		try {
			// Auction 테이블에서 member_id로 내가 올린경매를 가져온다.
			// auct_id로 사진을 가져온다.
			// 경매 중-입찰전, 입찰 중, 낙찰, 취소 => 쿼리문 조건으로 날려서 따로 가지고와서 json화 한다.
			auctions = abiz.selectAuctionByMember(member_id);

			for (AuctionVO auction : auctions) {
				int auct_id = auction.getAuct_id();
				if (auction.getAuction_status().equals("before")) {
					beforeJo = new JSONObject();
					// 입찰전 => 취소하기 버튼
					// 경매 사진과 타이틀도 가져와야함
					// before이라는 key로 JSON 배열에 JSON 객체를 넣는다.(status도)

					beforeJo.put("auction_status", auction.getAuction_status());
					ArrayList<PhotoVO> photos = pbiz.getAll(auct_id);
					for (PhotoVO photoVO : photos) {
						int i = 0;
						String pathKey = "photoPath" + i;
						String nameKey = "photoName" + i;
						beforeJo.put(pathKey, photoVO.getPhoto_path());
						beforeJo.put(nameKey, photoVO.getPhoto_name());
						i++;
					}
					beforeJo.put("auct_title", auction.getAuct_title());

					beforeJa.add(beforeJo);

				} else if (auction.getAuction_status().equals("proceeding")) {
					proceedingJo = new JSONObject();
					// 입찰중 => 재입찰하기 또는 내가 최고가일때 입찰 ㄴㄴ

					// 내가 입찰한 최고 가격과 비딩의 최고 가격을 가져온다.
					long bidMaxPrice = bbiz.selectBidMaxPrice(auction);
					long memberMaxPrice = bbiz.selectMemberMaxPrice(map);
					proceedingJo.put("bidMaxPrice", bidMaxPrice);
					proceedingJo.put("memberMaxPrice", memberMaxPrice);

					// 경매 사진과 타이틀도 가져와야함
					ArrayList<PhotoVO> photos = pbiz.getAll(auct_id);
					for (PhotoVO photoVO : photos) {
						int i = 0;
						String pathKey = "photoPath" + i;
						String nameKey = "photoName" + i;
						proceedingJo.put(pathKey, photoVO.getPhoto_path());
						proceedingJo.put(nameKey, photoVO.getPhoto_name());
						i++;
					}
					proceedingJo.put("auct_title", auction.getAuct_title());
					// 그래서 비교하여 최고가격이 같을 경우에는 버튼이 눌러지면 안된다.
					if (bidMaxPrice == memberMaxPrice) {
						proceedingJo.put("isReBid", false);
					} else {
						proceedingJo.put("isReBid", true);
					}
					// proceeding이라는 key로 JSON 배열에 JSON 객체를 넣는다.(status도)
					proceedingJa.add(proceedingJo);
				} else if (auction.getAuction_status().equals("end")) {
					endJo = new JSONObject();
					// 낙찰 => 경매 완료

					// 경매 사진과 타이틀도 가져와야함
					ArrayList<PhotoVO> photos = pbiz.getAll(auct_id);
					for (PhotoVO photoVO : photos) {
						int i = 0;
						String pathKey = "photoPath" + i;
						String nameKey = "photoName" + i;
						endJo.put(pathKey, photoVO.getPhoto_path());
						endJo.put(nameKey, photoVO.getPhoto_name());
						i++;
					}
					endJo.put("auct_title", auction.getAuct_title());

					// 낙찰가, 낙찰된 회원의 이름, 전화번호, 주소 가져오기
					SuccessfulBidVO successfulBid = sbiz.oneSelectMySuccessfulBid(auct_id);
					BiddingVO bidding = bbiz.get(successfulBid.getBid_id());
					MemberVO successfulBidMember = mbiz.get(bidding.getMember_id());
					endJo.put("successfulBidPrice", bidding.getPrice());
					endJo.put("successfulBidMember_name", successfulBidMember.getName());
					endJo.put("successfulBidMemberPhone", successfulBidMember.getPhone());
					endJo.put("successfulBidAddress", successfulBidMember.getAddress());

					// 택배 운송장 번호를 SUCCESSFULBID에서 가져오기 auct_id로
					endJo.put("delivery_code", successfulBid.getDelivery_code());
					endJo.put("delivery_status", successfulBid.getDelivery_status());
					endJo.put("company_code", successfulBid.getCompany_code());

					// end이라는 key로 JSON 배열에 JSON 객체를 넣는다.(status도)

					endJa.add(endJo);
				} else if (auction.getAuction_status().equals("cancel")) {
					cancelJo = new JSONObject();
					// 취소 => 취소된 경매
					// 경매 사진과 타이틀도 가져와야함
					ArrayList<PhotoVO> photos = pbiz.getAll(auct_id);
					for (PhotoVO photoVO : photos) {
						int i = 0;
						String pathKey = "photoPath" + i;
						String nameKey = "photoName" + i;
						cancelJo.put(pathKey, photoVO.getPhoto_path());
						cancelJo.put(nameKey, photoVO.getPhoto_name());
						i++;
					}
					cancelJo.put("auct_title", auction.getAuct_title());

					// cancel이라는 key로 JSON 배열에 JSON 객체를 넣는다.(status도)
					cancelJa.add(cancelJo);
				}
			}

			jo.put("before", beforeJa.toJSONString());
			jo.put("proceeding", proceedingJa.toJSONString());
			jo.put("end", endJa.toJSONString());
			jo.put("cancel", cancelJa.toJSONString());

			out = response.getWriter();
			out.print(jo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// 내가 낙찰한 물품 리스트 SELECT
	@RequestMapping("/mysuccessbidlist.bla")
	public void mysuccessbidlist(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();

		// int member_id = Integer.parseInt((String)session.getAttribute("member_id"));
		int member_id = 1;
		ArrayList<SuccessfulBidVO> successfulBids = null;

		// json 배열과 객체 선언
		JSONObject jo = null;
		JSONArray ja = null;

		// json 넘겨주기위함
		PrintWriter out = null;

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

			ja = new JSONArray();
			for (SuccessfulBidVO successfulBid : successfulBids) {
				jo = new JSONObject();
				price = bbiz.get(successfulBid.getBid_id()).getPrice();
				photos = pbiz.getAll(successfulBid.getAuct_id());
				auct_member_id = abiz.selectMemberIdByAuct(successfulBid.getAuct_id());
				sellerInfo = mbiz.get(auct_member_id);
				jo.put("price", price);
				for (PhotoVO photoVO : photos) {
					int i = 0;
					String pathKey = "photoPath" + i;
					String nameKey = "photoName" + i;
					jo.put(pathKey, photoVO.getPhoto_path());
					jo.put(nameKey, photoVO.getPhoto_name());
					i++;
				}
				jo.put("seller-name", sellerInfo.getName());
				jo.put("seller_phone", sellerInfo.getPhone());
				jo.put("delivery_code", successfulBid.getDelivery_code());
				jo.put("delivery_status", successfulBid.getDelivery_status());
				jo.put("company_code", successfulBid.getCompany_code());

				ja.add(jo);
			}

			out = response.getWriter();
			out.print(ja.toJSONString());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// 옥션 비딩 리스트 SELECT AJAX로 보냄
	@RequestMapping("/auctionbidlist.bla")
	public void auctionbidlist(HttpServletRequest request, HttpServletResponse response) {
		// view에서 auct_id를 받아온다.
		int auct_id = 0;

		// 입찰 해당 auct_id를 받아서 Bidding 객체를 가져온다.
		ArrayList<BiddingVO> biddings = null;
		// 해당하는 입찰자의 정보를 가져온다.
		MemberVO bid_member = null;

		// json 배열과 객체 선언
		JSONObject jo = null;
		JSONArray ja = null;

		// json 넘겨주기위함
		PrintWriter out = null;

		try {
			biddings = bbiz.selectAuctionBiddingList(auct_id);
			ja = new JSONArray();
			for (BiddingVO bid : biddings) {
				System.out.println("옥션 비딩 리스트" + bid);
				jo = new JSONObject();
				// 입찰가, 입찰시간, 컨펌 상태를 get으로 꺼내와서 json 저장
				jo.put("bid_price", bid.getPrice());
				jo.put("bid_time", bid.getTime());
				jo.put("bid_conf_status", bid.getBid_conf_status());
				// 입찰자 정보 가져오기, 입찰자 이름만 가져와서 json 객체화
				bid_member = mbiz.get(bid.getMember_id());
				jo.put("bid_member_name", bid_member.getName());

				ja.add(jo);
			}
			out = response.getWriter();
			out.print(ja.toJSONString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// 판매자 페이지
	@RequestMapping("/sellerpage.bla")
	public ModelAndView sellerpage() {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("main");
		mv.addObject("centerpage", "user/sellerPage");
		return mv;
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

	@RequestMapping("/timestamp.bla")
	public void timeStamp(HttpServletRequest request, HttpServletResponse response) {
		JSONObject jo = new JSONObject();
		// json 넘겨주기위함
		PrintWriter out = null;

		jo.put("success", "success");

		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.print(jo);
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