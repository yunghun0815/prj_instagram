package com.kosa.instagram.log.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.kosa.instagram.log.dto.LogDto;

public interface LogRepository {

	Map<String, BigDecimal> likeCount(String memberId);

	List<LogDto> likeCountDate(@Param("memberId") String memberId, @Param("before") String before, @Param("today") String today);

	List<LogDto> searchKeyword(int year);
	
}
