package com.web.spring.vo;

import java.util.List;

public class InsertProjectRequest {
    private ProjectBasic projectBasic;
    private ProjectTeam projectTeam;
    private List<TeamMate> teamMateList;
    
	public InsertProjectRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public InsertProjectRequest(ProjectBasic projectBasic, ProjectTeam projectTeam, List<TeamMate> teamMateList) {
		super();
		this.projectBasic = projectBasic;
		this.projectTeam = projectTeam;
		this.teamMateList = teamMateList;
	}
	
	public ProjectBasic getProjectBasic() {
		return projectBasic;
	}
	public void setProjectBasic(ProjectBasic projectBasic) {
		this.projectBasic = projectBasic;
	}
	public ProjectTeam getProjectTeam() {
		return projectTeam;
	}
	public void setProjectTeam(ProjectTeam projectTeam) {
		this.projectTeam = projectTeam;
	}
	public List<TeamMate> getTeamMateList() {
		return teamMateList;
	}
	public void setTeamMateList(List<TeamMate> teamMateList) {
		this.teamMateList = teamMateList;
	}
}
