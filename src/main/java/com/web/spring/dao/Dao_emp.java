package com.web.spring.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.web.spring.vo.DeptSch;
import com.web.spring.vo.Dept;
import com.web.spring.vo.Emp;
import com.web.spring.vo.EmpInfo;
import com.web.spring.vo.EmpSch;

// pms.dao.Dao_login
@Mapper
public interface Dao_emp {

	// 로그인
	Emp login(Emp sch);

	// 회원가입
	int signUp(Emp ins);

	// 총 사원 건수
	int totEmp(EmpSch sch);

	// 사원 리스트
	List<Emp> empList(EmpSch sch);

	// 사원상세
	Emp getEmp(int empno);

	// 사원정보 수정
	int empUpdate(Emp upt);

	// 부서정보 삭제
	int empDelete(int empno);

	// 마이페이지 회원정보 출력
	EmpInfo getEmpInfo(int empno);

	// 수정처리
	int updateEmpInfo(Emp upt);

	// 부서등록
	int insertDept(Dept ins);

	// 총 부서 건수
	int totDept(DeptSch sch);

	// 부서 리스트
	List<Dept> deptList(DeptSch sch);

	// 부서상세
	Dept getDept(int deptno);

	// 부서정보 수정
	int deptUpdate(Dept upt);

	// 부서정보 삭제
	int deptDelete(int deptno);

	// 부서번호 중복검사
	int checkDupDeptno(int deptno);
	
	// 직책 불러오기
	@Select("SELECT DISTINCT job from fb_emp order by job")
	List<String> getJobs();

	// 사원정보 가져오기
	Emp getEnameAndEmailBygetEmp(Emp emp);
	/*
	 * // 임시비밀번호 저장 int updateTempPw(Emp upt);
	 */
	
	
}
