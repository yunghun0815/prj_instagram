package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosa.instagram.feed.dao.IFeedRepository;
import com.kosa.instagram.feed.model.FeedVo;

@Service
public class FeedService implements IFeedService {
	@Autowired
	IFeedRepository feedRepository;
	
	@Override  
	public List<FeedVo> searchListByKeyword(String keyword, int page) {
		return feedRepository.searchListByKeyword("%"+ keyword+"%");
		
	}
	

}
