package com.kosa.instagram.feed.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.kosa.instagram.feed.model.FeedVo;


public interface IFeedRepository { 

	List<FeedVo> searchListByKeyword(@Param("keyword") String keyword);
}
