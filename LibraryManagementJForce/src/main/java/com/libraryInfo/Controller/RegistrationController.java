package com.libraryInfo.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.libraryInfo.Entity.Registration;
import com.libraryInfo.services.RegistrationService;

import jakarta.servlet.http.HttpSession;

@Controller
public class RegistrationController 
{	
	@Autowired
	private RegistrationService regiservice;
	
	
	@GetMapping("/")
	public String login(Model model)
	{	
		Registration registration1 = new Registration();
		model.addAttribute("registration",registration1);
		return "Login";
	}
	
	@GetMapping("/validate")
	public String registration(@ModelAttribute("registration") Registration regi,Model model,HttpSession session)
	{	
		String pass = regi.getPassword();
		String user = regi.getUsername();
		String f_pass = regiservice.getPassword(regi.getUsername());
		String f_user = regiservice.getemail(regi.getUsername());
		if(f_pass==null)
		{
			f_pass=" ";
		}
		if(f_user==null)
		{
			f_user=" ";
		}
		if(f_pass.equals(pass) && f_user.equals(user) && regiservice.getRole(f_user).equals("Admin"))
		{	
			session.setAttribute("uid",regiservice.getId(regi.getUsername()));
			return"Dashboard";
		}
		else if(f_pass.equals(pass) && f_user.equals(user) && regiservice.getRole(f_user).equals("User"))
		{
			session.setAttribute("uid",regiservice.getId(regi.getUsername()));
			return"UserDashboard";
		}
		else
		{
			return "InvalidCred";
		}
		
	}
	
	@GetMapping("/register")
	public String register(Model model)
	{	
		Registration regi = new Registration();
		model.addAttribute("register",regi);
		return "Registration";
	}
	
	@GetMapping("/save")
	public String registered(@ModelAttribute("register") Registration re , Model model)
	{	try
		{
		regiservice.saveUser(re);
		return "redirect:/";
		}
		catch(Exception e)
		{
			model.addAttribute("error","Username already exist");
			return "Registration";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session)
	{	
		session.invalidate();
		return "redirect:/";
	}
}
