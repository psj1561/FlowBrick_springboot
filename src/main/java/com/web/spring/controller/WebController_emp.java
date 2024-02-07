package com.web.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.spring.service.WebService_emp;
import com.web.spring.vo.Dept;
import com.web.spring.vo.DeptPaging;
import com.web.spring.vo.DeptSch;
import com.web.spring.vo.Emp;
import com.web.spring.vo.EmpInfo;
import com.web.spring.vo.EmpPaging;
import com.web.spring.vo.EmpSch;
import jakarta.servlet.http.HttpSession;

@Controller
public class WebController_emp {
	@Autowired(required = false)
	private WebService_emp service;

	// http://211.63.89.67:2222/pms/login.do
	// http://localhost:8088/pms/login.do
	// http://localhost:7080/pms/login.do
	@GetMapping("login.do")
	public String loginFrm() {
		return "login";
	}

	@RequestMapping("login.do")
	public String login(Emp emp, HttpSession session) {
		Emp empResult = service.login(emp);
		if (empResult != null) {
			session.setAttribute("empResult", empResult);
		}
		return "login";
	}

	@GetMapping("logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:login.do";
	}

	@GetMapping("forgot.do")
	public String forgot() {
		return "forgot";
	}

	@GetMapping("signUp.do")
	public String signUpFrm() {
		return "signUp";
	}

	@PostMapping("signUp.do")
	public String signUp(Emp emp, Model d) {
		// 1. 회원 등록
		String signUpResult = service.signUp(emp);
		d.addAttribute("msg", signUpResult);
	
		// 2. 회원 등록이 성공했을 경우에만 이메일 발송
		if ("등록성공".equals(signUpResult)) {
			d.addAttribute("emailMsg", service.sendMail(emp));
		}

		return "signUp";
	}

	@GetMapping("mypage.do")
	public String mypageFrm(HttpSession session, Model d) {
		Emp emp = (Emp) session.getAttribute("empResult");
		int empno = emp.getEmpno();
		// 회원정보 조회
		EmpInfo empInfo = service.getEmpInfo(empno);
		d.addAttribute("empInfo", empInfo);
		/* session.setAttribute("empInfo", empInfo); */
		return "mypage";
	}

	@PostMapping("mypage.do")
	public String updateEmpInfo(HttpSession session, Emp upt, Model d) {
		d.addAttribute("msg", service.updateEmpInfo(upt));
		// 다시 세션에서 로그인한 사용자 정보를 가져와 회원정보 조회
		Emp emp = (Emp) session.getAttribute("empResult");
		int empno = emp.getEmpno();
		d.addAttribute("empInfo", service.getEmpInfo(empno));
		return "mypage";
	}

	// 부서등록 페이지
	@GetMapping("deptReg.do")
	public String deptRegFrm() {
		return "deptReg";
	}

	// 부서등록
	@PostMapping("deptReg.do")
	public String deptReg(Dept ins, Model d) {
		d.addAttribute("msg", service.insertDept(ins));
		return "deptReg";
	}

	// 부서목룍
	@GetMapping("deptList.do")
	public String deptListFrm() {
		return "deptList";
	}

	// http://localhost:2222/deptListJson
	@PostMapping("deptListJson")
	public ResponseEntity<?> deptListJson(DeptSch sch) {
		return ResponseEntity.ok(new DeptPaging(sch, service.deptList(sch)));
	}

	// http://localhost:2222/deptDetail?deptno=10000
	@GetMapping("deptDetail")
	public String deptDetail(@RequestParam("deptno") int deptno, Model d) {
		d.addAttribute("dept", service.getDept(deptno));
		return "dept_detail";
	}

	@PostMapping("deptUpdate")
	public String deptUpdate(Dept upt, Model d) {
		d.addAttribute("proc", "upt");
		d.addAttribute("msg", service.deptUpdate(upt));
		d.addAttribute("dept", service.getDept(upt.getDeptno()));
		return "dept_detail";
	}

	@GetMapping("deptDelete")
	public String deptDelete(@RequestParam("deptno") int deptno, Model d) {
		d.addAttribute("proc", "del");
		d.addAttribute("msg", service.deptDelete(deptno));
		return "dept_detail";
	}

	// http://localhost:2222/checkDupDetpnoJson
	@GetMapping("checkDupDetpnoJson")
	public ResponseEntity<?> checkDupDetpnoJson(@RequestParam("deptno") int deptno) {
		return ResponseEntity.ok(service.checkDupDeptno(deptno));
	}

	// 사원목록
	@GetMapping("empList.do")
	public String empListFrm() {
		return "empList";
	}

	// http://localhost:2222/empListJson
	@PostMapping("empListJson")
	public ResponseEntity<?> empListJson(EmpSch sch) {
		return ResponseEntity.ok(new EmpPaging(sch, service.empList(sch)));
	}

	// http://localhost:2222/deptDetail?deptno=10000
	@GetMapping("empDetail")
	public String empDetail(@RequestParam("empno") int empno, Model d) {
		d.addAttribute("emp", service.getEmp(empno));
		return "emp_detail";
	}

	@PostMapping("empUpdate")
	public String empUpdate(Emp upt, Model d) {
		d.addAttribute("proc", "upt");
		d.addAttribute("msg", service.empUpdate(upt));
		d.addAttribute("emp", service.getEmp(upt.getEmpno()));
		return "emp_detail";
	}

	@GetMapping("empDelete")
	public String empDelete(@RequestParam("empno") int empno, Model d) {
		d.addAttribute("proc", "del");
		d.addAttribute("msg", service.empDelete(empno));
		return "emp_detail";
	}

	@ModelAttribute("dlist")
	public List<Dept> deptList() {
		return service.deptList(new DeptSch());
	}

	@ModelAttribute("jobs") // job, mgrInfos
	public List<String> getJobs() {
		return service.getJobs();
	}

}
