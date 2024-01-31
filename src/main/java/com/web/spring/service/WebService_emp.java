package com.web.spring.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.spring.dao.Dao_emp;
import com.web.spring.vo.Dept;
import com.web.spring.vo.DeptSch;
import com.web.spring.vo.Emp;
import com.web.spring.vo.EmpInfo;

@Service
public class WebService_emp {
	@Autowired(required = false)
	private Dao_emp dao;

	public Emp login(Emp sch) {
		return dao.login(sch); // null, 객체가 할당.
	}

	public String signUp(Emp ins) {
		return dao.signUp(ins) > 0 ? "등록성공" : "등록실패";
	}

	public EmpInfo getEmpInfo(int empno) {
		return dao.getEmpInfo(empno);
	}

	public String updateEmpInfo(Emp upt) {
		return dao.updateEmpInfo(upt) > 0 ? "수정성공" : "수정실패";
	}

	public String insertDept(Dept ins) {
		return dao.insertDept(ins) > 0 ? "등록성공" : "등록실패";
	}

	// 부서번호 리스트 불러오기
	public List<Dept> deptList(DeptSch sch) {
		if (sch.getDname() == null)
			sch.setDname("");

		// 페이징 처리
		sch.setCount(dao.totDept(sch));
		if (sch.getPageCount() == 0)
			sch.setPageSize(10);

		sch.setPageCount((int) Math.ceil(sch.getCount() / (double) sch.getPageSize()));

		if (sch.getCurPage() > sch.getPageCount())
			sch.setCurPage(sch.getPageCount());

		if (sch.getCurPage() == 0)
			sch.setCurPage(1);

		sch.setEnd(sch.getCurPage() * sch.getPageSize());

		if (sch.getEnd() > sch.getCount()) {
			sch.setEnd(sch.getCount());
		}

		sch.setStart((sch.getCurPage() - 1) * sch.getPageSize() + 1);

		sch.setBlockSize(5);

		System.out.println("현재 페이지 번호");
		System.out.println(sch.getCurPage());
		System.out.println("블럭의 크기");
		System.out.println(sch.getBlockSize());
		int blockNum = (int) Math.ceil(sch.getCurPage() / (double) sch.getBlockSize());

		sch.setEndBlock(blockNum * sch.getBlockSize());

		if (sch.getEndBlock() > sch.getPageCount()) {
			sch.setEndBlock(sch.getPageCount());
		}

		sch.setStartBlock((blockNum - 1) * sch.getBlockSize() + 1);
		System.out.println(blockNum);
		System.out.println(sch.getBlockSize());

		System.out.println("## 시작 블럭 크기 #");
		System.out.println(sch.getStartBlock());

		return dao.deptList(sch);
	}

	public Dept getDept(@Param("deptno") int deptno) {
		return dao.getDept(deptno);
	}

	public String deptUpdate(Dept upt) {
		return dao.deptUpdate(upt) > 0 ? "수정성공" : "수정실패";
	}

	public String deptDelete(int deptno) {
		return dao.deptDelete(deptno) > 0 ? "삭제성공" : "삭제실패";
	}

	// 부서번호 중복 검사
	public int checkDupDeptno(int deptno) {
		return dao.checkDupDeptno(deptno);
	}

}
