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

import com.web.spring.service.WebService_project;
import com.web.spring.vo.Emp;
import com.web.spring.vo.ProjectBasic;
import com.web.spring.vo.ProjectSch;
import com.web.spring.vo.ProjectTeam;
import com.web.spring.vo.TeamEmp;
import com.web.spring.vo.TeamMate;

@Controller
public class WebController_project {
	@Autowired(required = false)
	private WebService_project service;
	
	// http://localhost:2222/projectList
	@GetMapping("projectList")
	public String projectList() {
		return "project_list";
	}
	/*
	// http://localhost:2222/projectListJson
	@RequestMapping("projectListJson")
	public ResponseEntity<List<ProjectBasic>> projectListJson(ProjectSch sch){
		List<ProjectBasic> projectList = service.projectList(sch);
		return ResponseEntity.ok(projectList);
	}
	*/
	
	// http://localhost:2222/projectListJson
	@GetMapping("projectListJson")
	public String projectListJson(ProjectSch sch, Model d) {
		d.addAttribute("projectList", service.projectList(sch));
		return "pageJsonReport";
	}
	
	@ModelAttribute("empList")
	public List<TeamEmp> empList(){
		return service.empList();
	}
	
	// http://localhost:2222/insertProjectBasic
	@PostMapping("insertProjectBasic")
	public String insertProjectBasic(ProjectBasic ins, Model d, ProjectSch sch) {
		d.addAttribute("msg", service.insertProjectBasic(ins));
		d.addAttribute("projectlist", service.projectList(sch));
		return "pageJsonReport";
	}
	
	@PostMapping("insertProjectTeam")
	public String insertProjectTeam(ProjectTeam ins, Model d) {
		d.addAttribute("msg", service.insertProjectTeam(ins));
		return "pageJsonReport";
	}
	
	@PostMapping("insertTeamMate")
	public String insertTeamMate(TeamMate ins, Model d) {
		d.addAttribute("msg", service.insertTeamMate(ins));
		return "pageJsonReport";
	}

	@PostMapping("insertProject")
	public String insertProject(ProjectBasic pb, ProjectTeam pt, TeamMate tm, Model d) {
		d.addAttribute("msg", service.insertProject(pb, pt, tm));
		return "pageJsonReport";
	}

}
