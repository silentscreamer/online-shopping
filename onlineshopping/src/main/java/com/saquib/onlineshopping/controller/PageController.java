package com.saquib.onlineshopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

	@RequestMapping(value={"/","/home","/index"})
	public ModelAndView index(){
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("Greeting", "Hello spring");
		return mv;
	}
	
//	@RequestMapping(value={"/test"})
//	public ModelAndView test(@RequestParam("greet")String greet){
//		ModelAndView mv = new ModelAndView("page");
//		mv.addObject("Greeting", greet);
//		return mv;
//	}
//	@RequestMapping(value={"/test2/{greet}"})
//	public ModelAndView test2(@PathVariable("greet")String greet){
//		ModelAndView mv = new ModelAndView("page");
//		mv.addObject("Greeting", greet);
//		return mv;
//	}
	
}
