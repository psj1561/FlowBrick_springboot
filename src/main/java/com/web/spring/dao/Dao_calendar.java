package com.web.spring.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.web.spring.vo.Calendar;


@Mapper
public interface Dao_calendar {

	List<Calendar> getCalList();
	int insertCalendar(Calendar ins);
	int updateCalendar(Calendar upt);
	int deleteBoard(@Param("id") int id);
}



