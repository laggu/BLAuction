package controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import frame.Biz;
import vo.AuctionVO;

@Controller
public class AuctionController {
	@Resource(name="mbiz")
	Biz<AuctionVO, String> biz;
	
	@RequestMapping("/createAuctionVO.bla")
	public ModelAndView createAuction() {
		return null;
	}

	@RequestMapping("/createAuctionVOimpl.bla")
	public String createAuctionimpl(AuctionVO auction,HttpServletRequest request) {
		return null;
	}
	
	@RequestMapping("/AuctionVOdetail.bla")
	public ModelAndView Auctiondetail(HttpServletRequest request,Map<String, String> map) {
		return null;
	}
	
	@RequestMapping("/lifelist.bla")
	@ResponseBody
	public void lifelist(HttpServletResponse response) {
	}
	
	@RequestMapping("/fashionlist.bla")
	@ResponseBody
	public void fashionlist(HttpServletResponse response) {
	}
	
	@RequestMapping("/sportslist.bla")
	@ResponseBody
	public void sportslist(HttpServletResponse response) {
	}
	
	@RequestMapping("/digitallist.bla")
	@ResponseBody
	public void digitallist(HttpServletResponse response) {
	}
	
	@RequestMapping("/beautylist.bla")
	@ResponseBody
	public void beautylist(HttpServletResponse response) {
	}
	
	@RequestMapping("/etclist.bla")
	@ResponseBody
	public void etclist(HttpServletResponse response) {
	}
	
	@RequestMapping("/deleteAuctionVO.bla")
	public String deleteAuctionVO(AuctionVO auction,HttpServletRequest request,Map<String,String> map) {
		return null;
	}
	
	@RequestMapping("/updateAuctionVO.bla")
	public ModelAndView updateAuctionVO(AuctionVO auction,HttpServletRequest request) {
		return null;
	}
	
	@RequestMapping("/updateAuctionVOimpl.bla")
	public ModelAndView updateAuctionVOimpl(AuctionVO auction,HttpServletRequest request) {
		return null;
	}
	
	@RequestMapping("/bidding.bla")
	public String bidding(Map<String, Object> map,HttpServletRequest request) {
		return null;
	}
	
	@RequestMapping("/biddingimpl.bla")
	public String biddingimpl(Map<String, Object> map,HttpServletRequest request) {
		return null;
	}
	
	@RequestMapping("/successfulbiddingimpl.bla")
	public String successfulbiddingimpl(Map<String, Object> map,HttpServletRequest request) {
		return null;
	}
	
	@RequestMapping("/failbiddingimpl.bla")
	public String failbiddingimpl(Map<String, Object> map,HttpServletRequest request) {
		return null;
	}
	
	@RequestMapping("/sellerinfo.bla")
	public String sellerinfo(HttpServletResponse response) {
		return null;
	}
	
	@RequestMapping("/rateimpl.bla")
	public String rateimpl(Map<String, Object> map,HttpServletRequest request) {
		return null;
	}
	
	@RequestMapping("/searchimpl.bla")
	public String searchimpl(Map<String, Object> map,HttpServletRequest request) {
		return null;
	}
	
	
}