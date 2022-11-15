package com.kosa.instagram.log.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.kosa.instagram.log.dto.LogDto;

public interface LogService {

	Map<String, BigDecimal> likeCount(String memberId);

	List<LogDto> likeCountDate(String memberId);

}
