package com.hungerfree.app;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class SignUpcontroller {
	@Autowired
	private Userrepo customerRepo;
	@Autowired
	private SignUpRepo userRepo;
	BCryptPasswordEncoder pp=new BCryptPasswordEncoder();
	
	@GetMapping("/register")
	public String showForm(Model model) {
		SignUp user = new SignUp();
		model.addAttribute("user", user);
		// b.savedet(user);

		return "register";
	}

	@PostMapping("/registeraction")
	    public String listAll(@ModelAttribute("user") SignUp signup,Model model) {
		
		
	    	try {
	       List<SignUp> listCustomers = userRepo.findAll();
	       
	    	  
	    Signin signin=new Signin();
	    model.addAttribute("signin",signin);
	       model.addAttribute("listCustomers", listCustomers);
	        
	       listCustomers.forEach(System.out :: println);
	        if(listCustomers==null)
	        {
	        	return "register_success";
	        }
	        for(SignUp k: listCustomers) {
       		 if(k.getName().equalsIgnoreCase(signup.getName())==true)
       		        	{
       		        		System.out.println("user already exists");
       		        		//model.addAttribute("obj",k);
       		        	}
       		         else 
       		        	{
                       
                       signup.setPassword(pp.encode(signup.getPassword()));
                       signup.setRepeatPassword(pp.encode(signup.getRepeatPassword()));
       		 	    	SignUp z=userRepo.save(signup);     
       		 	    	System.out.println(z);
       		        		return "login_form";
       		        		//System.out.println("Enter a valid password");
       		        	}
       		 
       		        }
	    	
	    	return "login_form";
       		       
	    	}catch(Exception e)
	    	{
	    		model.addAttribute("Validated","User aleady Exists");
	    		//System.out.println("User already Exists");
	    		return "register";
	    	}
	}
}
