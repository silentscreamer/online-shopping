package com.saquib.onlineshopping.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handlerforNoHandlerFoundException(){
		ModelAndView mv = new ModelAndView("error");
		
		mv.addObject("errorTitle","The page is not constructed");
		mv.addObject("errorDesc","The page you are looking for is not available!");
		mv.addObject("title","404 error page");
		
		
		return mv;
	}

	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handlerforProductNotFoundException(){
		ModelAndView mv = new ModelAndView("error");
		
		mv.addObject("errorTitle","Product not available!");
		mv.addObject("errorDesc","The Product you are looking for is not available!");
		mv.addObject("title","500 error page");
		
		
		return mv;
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handlerforException( Exception ex){
		ModelAndView mv = new ModelAndView("error");
		
		mv.addObject("errorTitle","Contact your admin!");
		mv.addObject("errorDesc",ex.toString());
		mv.addObject("title","Error!");
		
		
		return mv;
	}
}
