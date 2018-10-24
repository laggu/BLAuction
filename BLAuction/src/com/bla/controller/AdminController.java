package com.bla.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bla.biz.AuctionBiz;
import com.bla.biz.BiddingBiz;
import com.bla.biz.MemberBiz;
import com.bla.biz.PhotoBiz;
import com.bla.biz.SuccessfulBidBiz;
import com.bla.vo.AuctionVO;
import com.bla.vo.BiddingVO;
import com.bla.vo.ListVO;
import com.bla.vo.MemberVO;
import com.bla.vo.PhotoVO;

@Controller
public class AdminController {
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
	
	// 전체리스트
	@RequestMapping("/admin.bla")
	@ResponseBody
	public ModelAndView allList(HttpServletRequest request) {
		ArrayList<ListVO> list = new ArrayList<ListVO>();
		ArrayList<AuctionVO> auction_list = null;

		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin");
		try {
			auction_list = abiz.getRealAll();
			
			Iterator<AuctionVO> itr = auction_list.iterator();
			
			while (itr.hasNext()) {
				AuctionVO auctionVO = (AuctionVO) itr.next();
				
				ListVO newlist = new ListVO();
				String due_date = new SimpleDateFormat("MM월 dd일 HH:mm")
						.format(new Date((Long) auctionVO.getDuedate()));
				newlist.setAuction(auctionVO);
				newlist.setDuedate(due_date);
				newlist.setMax_price(bbiz.selectBidMaxPrice(auctionVO));
				if (newlist.getMax_price() == null) {
					newlist.setMax_price(auctionVO.getStart_price());
				}
				list.add(newlist);
			}

			mv.addObject("list", list);
			mv.addObject("centerpage", "admin/center");
		} catch (Exception e) {
			e.printStackTrace();
			mv.addObject("centerpage", "admin/center");
		}
		
		System.out.println("###################### GET ALL ######################");
		Iterator<ListVO> itr_ = list.iterator();
		while (itr_.hasNext()) {
			ListVO listVO = (ListVO) itr_.next();
			System.out.println(listVO);
		}

		return mv;
	}
	
	// Status
	@RequestMapping("/admin_status.bla")
	@ResponseBody
	public ModelAndView auction_status(HttpServletRequest request) {
		String status = request.getParameter("status");
		ArrayList<ListVO> list = new ArrayList<ListVO>();
		ArrayList<AuctionVO> auction_list = null;

		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin");
		try {
			auction_list = abiz.get();
			
			Iterator<AuctionVO> itr = auction_list.iterator();
			
			while (itr.hasNext()) {
				AuctionVO auctionVO = (AuctionVO) itr.next();
				if(auctionVO.getAuction_status().equals(status)) {
					ListVO newlist = new ListVO();
					String due_date = new SimpleDateFormat("MM월 dd일 HH:mm")
							.format(new Date((Long) auctionVO.getDuedate()));
					newlist.setAuction(auctionVO);
					newlist.setDuedate(due_date);
					newlist.setMax_price(bbiz.selectBidMaxPrice(auctionVO));
					if (newlist.getMax_price() == null) {
						newlist.setMax_price(auctionVO.getStart_price());
					}
					list.add(newlist);
				}
			}

			mv.addObject("list", list);
			mv.addObject("centerpage", "admin/center");
		} catch (Exception e) {
			e.printStackTrace();
			mv.addObject("centerpage", "admin/center");
		}
		
		System.out.println("###################### GET BY STATUS ######################");
		Iterator<ListVO> itr_ = list.iterator();
		while (itr_.hasNext()) {
			ListVO listVO = (ListVO) itr_.next();
			System.out.println(listVO);
		}

		return mv;
	}
	
	// Category
	@RequestMapping("/admin_category.bla")
	@ResponseBody
	public ModelAndView auction_category(HttpServletRequest request) {
		int category = Integer.parseInt(request.getParameter("id"));
		ArrayList<ListVO> list = new ArrayList<ListVO>();
		ArrayList<AuctionVO> auction_list = null;

		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin");
		try {
			auction_list = abiz.getByCategory(category);
			
			Iterator<AuctionVO> itr = auction_list.iterator();
			
			while (itr.hasNext()) {
				AuctionVO auctionVO = (AuctionVO) itr.next();
				ListVO newlist = new ListVO();
				String due_date = new SimpleDateFormat("MM월 dd일 HH:mm")
						.format(new Date((Long) auctionVO.getDuedate()));
				newlist.setAuction(auctionVO);
				newlist.setDuedate(due_date);
				newlist.setMax_price(bbiz.selectBidMaxPrice(auctionVO));
				if (newlist.getMax_price() == null) {
					newlist.setMax_price(auctionVO.getStart_price());
				}
				list.add(newlist);
			}

			mv.addObject("list", list);
			mv.addObject("centerpage", "admin/center");
		} catch (Exception e) {
			e.printStackTrace();
			mv.addObject("centerpage", "admin/center");
		}
		
		System.out.println("###################### GET BY CATEGORY ######################");
		Iterator<ListVO> itr_ = list.iterator();
		while (itr_.hasNext()) {
			ListVO listVO = (ListVO) itr_.next();
			System.out.println(listVO);
		}

		return mv;
	}
	
	// Type
	@RequestMapping("/admin_type.bla")
	@ResponseBody
	public ModelAndView auction_type(HttpServletRequest request) {
		int type = Integer.parseInt(request.getParameter("id"));
		ArrayList<ListVO> list = new ArrayList<ListVO>();
		ArrayList<AuctionVO> auction_list = null;

		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin");
		try {
			auction_list = abiz.getByType(type);
			
			Iterator<AuctionVO> itr = auction_list.iterator();
			
			while (itr.hasNext()) {
				AuctionVO auctionVO = (AuctionVO) itr.next();
				ListVO newlist = new ListVO();
				String due_date = new SimpleDateFormat("MM월 dd일 HH:mm")
						.format(new Date((Long) auctionVO.getDuedate()));
				newlist.setAuction(auctionVO);
				newlist.setDuedate(due_date);
				newlist.setMax_price(bbiz.selectBidMaxPrice(auctionVO));
				if (newlist.getMax_price() == null) {
					newlist.setMax_price(auctionVO.getStart_price());
				}
				list.add(newlist);
			}

			mv.addObject("list", list);
			mv.addObject("centerpage", "admin/center");
		} catch (Exception e) {
			e.printStackTrace();
			mv.addObject("centerpage", "admin/center");
		}
		
		System.out.println("###################### GET BY TYPE ######################");
		Iterator<ListVO> itr_ = list.iterator();
		while (itr_.hasNext()) {
			ListVO listVO = (ListVO) itr_.next();
			System.out.println(listVO);
		}

		return mv;
	}
	
	// Unconfirmed Auction
	@RequestMapping("/admin_unconfirmed_auction.bla")
	@ResponseBody
	public ModelAndView auction_unconfirmed(HttpServletRequest request) {
		ArrayList<ListVO> list = new ArrayList<ListVO>();
		ArrayList<AuctionVO> auction_list = null;

		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin");
		try {
			auction_list = abiz.getNull();
			
			Iterator<AuctionVO> itr = auction_list.iterator();
			
			while (itr.hasNext()) {
				AuctionVO auctionVO = (AuctionVO) itr.next();
				ListVO newlist = new ListVO();
				String due_date = new SimpleDateFormat("MM월 dd일 HH:mm")
						.format(new Date((Long) auctionVO.getDuedate()));
				newlist.setAuction(auctionVO);
				newlist.setDuedate(due_date);
				newlist.setMax_price(bbiz.selectBidMaxPrice(auctionVO));
				if (newlist.getMax_price() == null) {
					newlist.setMax_price(auctionVO.getStart_price());
				}
				list.add(newlist);
			}

			mv.addObject("list", list);
			mv.addObject("unconfirmed", "unconfirmed");
			mv.addObject("centerpage", "admin/center");
		} catch (Exception e) {
			e.printStackTrace();
			mv.addObject("centerpage", "admin/center");
		}
		
		System.out.println("###################### GET UNCONFIRMED AUCTIONS ######################");
		Iterator<ListVO> itr_ = list.iterator();
		while (itr_.hasNext()) {
			ListVO listVO = (ListVO) itr_.next();
			System.out.println(listVO);
		}

		return mv;
	}
	
	// Unconfirmed Bidding
	@RequestMapping("/bidding_unconfirmed_auction.bla")
	@ResponseBody
	public ModelAndView bidding_unconfirmed(HttpServletRequest request) {
		ArrayList<BiddingVO> bidding_list = null;
		ArrayList<ListVO> list = new ArrayList<ListVO>();

		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin");
		try {
			bidding_list = bbiz.getNull();
			System.out.println(bidding_list);
			Iterator<BiddingVO> itr = bidding_list.iterator();
			while (itr.hasNext()) {
				BiddingVO biddingVO = (BiddingVO) itr.next();
				ListVO listVO = new ListVO();
				String due_date = new SimpleDateFormat("MM월 dd일 HH:mm")
						.format(new Date((Long) biddingVO.getTime()));
				listVO.setDuedate(due_date);
				listVO.setBidding(biddingVO);
				list.add(listVO);
			}

			mv.addObject("list", list);
			mv.addObject("centerpage", "admin/bidding");
		} catch (Exception e) {
			e.printStackTrace();
			mv.addObject("centerpage", "admin/bidding");
		}
		
		System.out.println("###################### GET UNCONFIRMED BIDDING ######################");
		Iterator<ListVO> itr_ = list.iterator();
		while (itr_.hasNext()) {
			ListVO listVO = (ListVO) itr_.next();
			System.out.println(listVO);
		}

		return mv;
	}
	
	// Members
		@RequestMapping("/admin_member.bla")
		@ResponseBody
		public ModelAndView member(HttpServletRequest request) {
			ArrayList<MemberVO> list = new ArrayList<MemberVO>();

			ModelAndView mv = new ModelAndView();
			mv.setViewName("admin");
			try {
				list = mbiz.get();
				mv.addObject("list", list);
				mv.addObject("centerpage", "admin/member");
			} catch (Exception e) {
				e.printStackTrace();
				mv.addObject("centerpage", "admin/member");
			}
			
			System.out.println("###################### GET MEMBERS ######################");
			Iterator<MemberVO> itr_ = list.iterator();
			while (itr_.hasNext()) {
				MemberVO member = (MemberVO) itr_.next();
				System.out.println(member);
			}

			return mv;
		}
		
	// Auction Detail
	@RequestMapping("/admin_auction_detail.bla")
	@ResponseBody
	public ModelAndView auction_details(HttpServletRequest request) {
		int auction_id = Integer.parseInt(request.getParameter("id"));
		ArrayList<BiddingVO> bidding_list = null;
		ArrayList<ListVO> list = new ArrayList<ListVO>();
		ArrayList<PhotoVO> photos = null;
		AuctionVO auction = null;

		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin");
		try {
			auction = abiz.get(auction_id);
			
			// Getting Due Date
			String auction_due_date = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분")
					.format(new Date((Long) auction.getDuedate()));
			
			// Getting Register Date
			String auction_register_date = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분")
					.format(new Date((Long) auction.getRegister_date()));
			
			// Calculate Current Price 
			Long cur_priceL = bbiz.selectBidMaxPrice(auction);
			if (cur_priceL == null) {
				cur_priceL = auction.getStart_price();
			}
			Double cur_price = cur_priceL.doubleValue();
			cur_price = Math.round(cur_price * 1000) / 1000.0;
			
			// Getting Bidding List 
			bidding_list = bbiz.selectAuctionBiddingList(auction_id);
			Iterator<BiddingVO> itr = bidding_list.iterator();
			while (itr.hasNext()) {
				BiddingVO biddingVO = (BiddingVO) itr.next();
				ListVO listVO = new ListVO();
				String due_date = new SimpleDateFormat("MM월 dd일 HH:mm")
						.format(new Date((Long) biddingVO.getTime()));
				listVO.setDuedate(due_date);
				listVO.setBidding(biddingVO);
				list.add(listVO);
			}
			
			photos = pbiz.getAll(auction_id);
			if(!photos.isEmpty()) {
				mv.addObject("photo1", photos.get(0).getPhoto_path() + photos.get(0).getPhoto_name());
				if(photos.size() == 2)
				mv.addObject("photo2", photos.get(1).getPhoto_path() + photos.get(1).getPhoto_name());
			}
			
			mv.addObject("due_date", auction_due_date);
			mv.addObject("register_date", auction_register_date);
			mv.addObject("cur_price", cur_price);
			mv.addObject("auction", auction);
			mv.addObject("list", list);
			mv.addObject("centerpage", "admin/auction_detail");
		} catch (Exception e) {
			e.printStackTrace();
			mv.addObject("centerpage", "admin/auction_detail");
		}
		
		System.out.println("###################### Auction Detail ######################");
		Iterator<ListVO> itr_ = list.iterator();
		while (itr_.hasNext()) {
			ListVO listVO = (ListVO) itr_.next();
			System.out.println(listVO);
		}

		return mv;
	}
	
	// Member Detail
	@RequestMapping("/admin_member_detail.bla")
	@ResponseBody
	public ModelAndView member_detail(HttpServletRequest request) {
		int member_id = Integer.parseInt(request.getParameter("id"));
		
		ArrayList<ListVO> created_list = new ArrayList<ListVO>();
		ArrayList<ListVO> bid_list = new ArrayList<ListVO>();
		ArrayList<AuctionVO> all_list = new ArrayList<AuctionVO>();
		ArrayList<Integer> biddings = new ArrayList<Integer>();
	
		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin");
		try {
			
			// get member
			MemberVO member = mbiz.get(member_id);
			
			// get created_list
			all_list = abiz.get();
			Iterator<AuctionVO> itr = all_list.iterator();
			while (itr.hasNext()) {
				AuctionVO auctionVO = (AuctionVO) itr.next();
				if(auctionVO.getMember_id() == member_id) {
					ListVO listVO = new ListVO();
					listVO.setAuction(auctionVO);
					String due_date = new SimpleDateFormat("MM월 dd일 HH:mm")
							.format(new Date((Long) auctionVO.getDuedate()));
					listVO.setAuction(auctionVO);
					listVO.setDuedate(due_date);
					listVO.setMax_price(bbiz.selectBidMaxPrice(auctionVO));
					if (listVO.getMax_price() == null) {
						listVO.setMax_price(auctionVO.getStart_price());
					}
					created_list.add(listVO);
				}
			}
			
			// get bid_list
			biddings = bbiz.selectAuctIdByMemberId(member_id);
			Iterator<Integer> itr2 = biddings.iterator();
			itr2 = biddings.iterator();
			while (itr2.hasNext()) {
				Integer integer = (Integer) itr2.next();
				AuctionVO auctionVO = abiz.get(integer);
				ListVO listVO = new ListVO();
				listVO.setAuction(auctionVO);
				String due_date = new SimpleDateFormat("MM월 dd일 HH:mm")
						.format(new Date((Long) auctionVO.getDuedate()));
				listVO.setAuction(auctionVO);
				listVO.setDuedate(due_date);
				listVO.setMax_price(bbiz.selectBidMaxPrice(auctionVO));
				if (listVO.getMax_price() == null) {
					listVO.setMax_price(auctionVO.getStart_price());
				}
				bid_list.add(listVO);
			}
			
			mv.addObject("member", member);
			mv.addObject("created_list", created_list);
			mv.addObject("bid_list", bid_list);
			mv.addObject("centerpage", "admin/member_detail");
			
		} catch (Exception e) {
			e.printStackTrace();
			mv.addObject("centerpage", "admin/member_detail");
		}
		
		System.out.println("###################### GET MEMBER_DETAIL ######################");
	
		return mv;
	}
	
	// Delete_null_auction
	@RequestMapping("/admin_delete_null_auction.bla")
	@ResponseBody
	public void delete_null_auction(HttpServletRequest request) {
		Long aday= 86400000L;
		Long aday_before = System.currentTimeMillis() - aday;
		System.out.println("###################### Delete Null Auction ######################");
		System.out.println("A Day Before : " + aday_before);
	
		try {
			pbiz.removeNull(aday_before);
			abiz.removeNull(aday_before);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// Delete_null_bidding
	@RequestMapping("/admin_delete_null_bidding.bla")
	@ResponseBody
	public void delete_null_bidding(HttpServletRequest request) {
		Long aday= 86400000L;
		Long aday_before = System.currentTimeMillis() - aday;
		System.out.println("###################### Delete Null Auction ######################");
		System.out.println("A Day Before : " + aday_before);
	
		try {
			bbiz.removeNull(aday_before);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
