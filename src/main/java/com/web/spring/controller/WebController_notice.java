package com.web.spring.controller;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.spring.service.WebService_notice;
import com.web.spring.vo.Notice;
import com.web.spring.vo.NoticeSch;

@Controller
public class WebController_notice {
	@Autowired(required = false)
	private WebService_notice service;
	
	// http://211.63.89.67:2222/pms/notice.do
	// http://localhost:2222/notice.do
	@RequestMapping("notice.do")
	public String notice(@ModelAttribute("sch") NoticeSch sch, Model d) {
		d.addAttribute("noticeList", service.noticeList(sch));
		Date now = new Date(); // 현재시간 객체
		d.addAttribute("now", now);
		return "notice";
	}
	
	// 공지사항 작성
	@RequestMapping("insertNoticeFrm.do")
	public String insertNoticeFrm() {
		return "notice_insert";
	}
	@RequestMapping("insertNotice.do")
	public String insertNotice(Notice ins, Model d) {
		d.addAttribute("msg", service.insertNotice(ins));		
		return "notice_insert";
	}

	// 상세화면 조회
	@RequestMapping("detailNotice.do")
	public String getBoard(@RequestParam("no") int no, Model d) {
		d.addAttribute("notice", service.getDetailNotice(no));
		return "notice_detail";
	}
	// 수정 페이지로 이동
	@RequestMapping("updateNoticeFrm.do")
	public String updateNoticeFrm(@RequestParam("no") int no, Model d) {
		d.addAttribute("notice", service.getDetailNotice(no));
		return "notice_update";		
	}
	// 수정 처리
	@RequestMapping("updateNotice.do")
	public String updateNotice(Notice upt, Model d) {
		// 수정 처리 내용
		d.addAttribute("proc","upt");
		d.addAttribute("msg", service.updateNotice(upt));
		System.out.println("수정처리끝");
		// 수정이후, 데이터
		d.addAttribute("board", service.getNotice(upt.getNo()));
		return "notice_detail";
	}	
	// 삭제 처리
	@RequestMapping("deleteNotice.do")
	public String deleteNotice(@RequestParam("no") int no, Model d) {
		d.addAttribute("proc","del");
		
		d.addAttribute("msg", service.deleteNotice(no));
		return "notice_detail";
	}
	// 다운로드
	@RequestMapping("download.do")
	public String download(@RequestParam("fname") String fname,
				Model d) {
		d.addAttribute("downloadFile", fname);
		return "downloadViewer";
	}
}
