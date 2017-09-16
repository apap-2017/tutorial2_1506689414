package com.example.demo.controller;


import java.util.Optional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController  {
	
	@RequestMapping("/hello") 
	public String index() 
	{
		return "hello";
	}


//localhost:8080/greeting?name=chanek	
	@RequestMapping("/greeting")
	public String greeting(@RequestParam(value="name") String name, Model model) 
	{
		model.addAttribute("name", name);
		return "greeting";
	}
	

//localhost:8080/multiple?a=1&b=2
	@RequestMapping("/multiple")
	public String multiple(@RequestParam(value="a", required = false, defaultValue="0" ) String a, 
			Model modela, @RequestParam(value="b", required = false, defaultValue="0" ) String b, Model modelb)
	{

		int aa = Integer.parseInt(a);
		int bb = Integer.parseInt(b);
		int perkalian = aa*bb;
	
		modela.addAttribute("a", aa);
		modelb.addAttribute("b", bb);
		modela.addAttribute("c", perkalian);
		
		return "multiple";
		
	}

/*
	
//localhost:8080/greeting	
	@RequestMapping("/greeting")
	public String greeting1(@RequestParam(value="name", required = false, defaultValue="dunia" ) String name, Model model) 
	{
		model.addAttribute("name", name);
		return "greeting";
	}
*/

/*	
//localhost:8080/greeting/chanek
	@RequestMapping(value={"/greeting", "greeting/{name}"})
	public String greetingPath (@PathVariable Optional<String> name, Model model) 
	{
		if(name.isPresent()) {
			model.addAttribute("name", name.get());
		} else {
			model.addAttribute("name", "dengklek");
		}
		return "greeting";		
	}
*/	

}