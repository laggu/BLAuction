
package com.bla.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.bla.biz.AuctionBiz;
import com.bla.biz.PhotoBiz;
import com.bla.util.FileSave;
import com.bla.vo.AuctionVO;
import com.bla.vo.PhotoVO;

@Controller
public class AuctionController2 {
	@Resource(name = "abiz")
	AuctionBiz biz;
	
	@Resource(name = "pbiz")
	PhotoBiz p_biz;
	

	// 경매 등록 페이지 넘기기
	@RequestMapping("/createAuction2.bla")
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
	@RequestMapping("/createAuctionimpl2.bla")
	@ResponseBody
	public int createAuctionimpl(MultipartHttpServletRequest multi, HttpServletResponse response) {// 원래면 매개변수로 받음
		
		System.out.println("###################### CREATING AUCTION !!! ######################");
		
		// Session에서 정보 추출
		HttpSession session = multi.getSession();
//		int member_id = (Integer)session.getAttribute("member_id");
//		String seller_account = (String)session.getAttribute("seller_account");
		
//		// Auction 객체 생성 [공통]
		AuctionVO auction = new AuctionVO();
		Long register_date = Long.parseLong(multi.getParameter("register_date"));
		auction.setMember_id(1);
//		auction.setDuedate((Long)multi.getParameter(2)); 페이지 구현 필요
		auction.setDuedate(2);
		auction.setType(Integer.parseInt(multi.getParameter("type")));
		auction.setAuct_title(multi.getParameter("auct_title"));
		auction.setStart_price(Long.parseLong(multi.getParameter("start_price")));
		auction.setSeller_account("seller_account");
		auction.setCategory_id(Integer.parseInt(multi.getParameter("category_id")));
		System.out.println("DESCRIPTION : " + multi.getParameter("description"));
		auction.setDescription(multi.getParameter("description"));
		auction.setRegister_date(register_date);
		auction.setTag(multi.getParameter("registerTags"));
		auction.setAuction_address("tmp");
		
		// 내림경매
		if((multi.getParameter("type")).equals("2")) {
			auction.setDown_price(Long.parseLong(multi.getParameter("down_price")));
			auction.setDown_term(Integer.parseInt(multi.getParameter("down_term")));;
		}
		
		// DB 저장 및 DB select로 auction_id 추출
		int auct_id = 0;
		try {
			System.out.println("AUCTION : " + auction);
			biz.register(auction);
			System.out.println("AUCTION UPLOADED");
			auct_id = biz.get(register_date);
			System.out.println("AUCT_ID : " + auct_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 사진 저장 경로 설정
        String root = multi.getSession().getServletContext().getRealPath("/");
        String path = root+"resources/thumbnail/";
		String newFileName = ""; // 업로드 되는 파일명
		
		// 경로 폴더 없을 시 폴더 생성
		File dir = new File(path);
        if(!dir.isDirectory()){
            dir.mkdir();
        }

        // 넘어온 데이터에서 파일추출 후 저장
		Iterator<String> files = multi.getFileNames();
		int i = 0;
        while(files.hasNext()){
            String uploadFile = files.next();
            if(uploadFile.equals("files")) break;
            MultipartFile mFile = multi.getFile(uploadFile);
            String fileName = mFile.getOriginalFilename();
            String typeName = fileName.substring(fileName.indexOf("."));
            newFileName = auct_id +"_"+ i
                    +typeName;
            try {
                FileSave.save(path, mFile, newFileName);
            } catch (Exception e) {
                e.printStackTrace();
            }
            i++;
        }
        
        // 사진 DB 저장
        PhotoVO photo = new PhotoVO();
        photo.setAuct_id(auct_id);
        photo.setPhoto_name(newFileName);
        photo.setPhoto_path("resources/thumbnail/");
        System.out.println("PHOTO : " + photo);
        
        try {
			p_biz.register(photo);
			System.out.println("PHOTO UPLOADED");
		} catch (Exception e) {
			e.printStackTrace();
		}
        
		return auct_id;
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