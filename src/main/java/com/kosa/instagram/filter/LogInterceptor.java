
package com.kosa.instagram.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.kosa.instagram.LogVo;
import com.kosa.instagram.feed.dao.IFeedRepository;
import com.kosa.instagram.feed.service.IFeedService;

public class LogInterceptor implements HandlerInterceptor {

	LogVo log;

	@Autowired
	IFeedRepository feedRepository;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		HttpSession session = request.getSession();
		String uri = request.getRequestURI();
		log = new LogVo();
		log.setLogURI(uri);
		log.setMemberId((String)session.getAttribute("memberId"));
		uri = uri.substring(1);	//remove first slash
		String[] splitUri = uri.split("/");
		if(splitUri[0].equals("increaselike") || splitUri[0].equals("decreaselike")) {	// [0]���� [1]feedno

			log.setFeedNo(Integer.parseInt(splitUri[1]));
			if(splitUri[0].equals("increaselike")) {
				log.setLogLikeCheck(1);
			} else {
				log.setLogLikeCheck(0);
			}
		} else if(splitUri[0].equals("getmemberlist")) {
			String keyword = (String)request.getParameter("keyword");
			log.setLogURI("/search");
			log.setLogKeyword(keyword);
			log.setFeedNo(0);
		}
		System.out.println(log.toString());
		feedRepository.makeLog(log);

	}
}