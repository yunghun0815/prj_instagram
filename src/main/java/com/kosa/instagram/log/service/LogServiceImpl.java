package com.kosa.instagram.log.service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosa.instagram.log.dao.LogRepository;
import com.kosa.instagram.log.dto.LogDto;

@Service
public class LogServiceImpl implements LogService {

	@Autowired
	LogRepository logRepository;
	
	@Override
	public Map<String, BigDecimal> likeCount(String memberId) {
		return logRepository.likeCount(memberId);
	}

	@Override
	public List<LogDto> likeCountDate(String memberId) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Calendar calBefore = Calendar.getInstance();
		Calendar calToday = Calendar.getInstance();
		
		calBefore.add(Calendar.DATE, -6);
		calToday.add(Calendar.DATE, +1); //오라클 연산때문에 1일 더해줌
		
		Date dateBefore = new Date(calBefore.getTimeInMillis());
		Date dateToday = new Date(calToday.getTimeInMillis());
		
		String before = sdf.format(dateBefore); 
		String today = sdf.format(dateToday);
		
		return logRepository.likeCountDate(memberId, before, today);
	}

	@Override
	public List<LogDto> searchKeyword() {
		
		Calendar today = Calendar.getInstance();
		
		return logRepository.searchKeyword(today.get(Calendar.YEAR));
	}

}
