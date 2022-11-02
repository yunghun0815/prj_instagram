package com.kosa.instagram;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
<<<<<<< HEAD
 * Handles requests for the application home page.,amsnx,asnfdfd gggggggg
=======
<<<<<<< HEAD
 * Handles requests for the application home page.,amsnx,asnxgfdfdf ihi
=======
 * Handles requests for the application home page.,amsnx,asnasdasd
>>>>>>> refs/remotes/origin/master
>>>>>>> branch 'master' of https://github.com/yunghun0815/prj_instagram.git
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.,,
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	 
}
