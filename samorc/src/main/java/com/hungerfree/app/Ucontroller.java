package com.hungerfree.app;

import java.util.List;


import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Ucontroller {
	 @Autowired
	    private Userrepo customerRepo;
	@Autowired
	private SignUpRepo userRepo;
	 @GetMapping("/login")
	  public String showForm(Model model) {
	       Signin user = new Signin();
	        
	        
	        model.addAttribute("user", user);
	       // b.savedet(user);
	         
	        return "login_form";
	    }
	    
	    @PostMapping("/login")
	    public String listAll(@ModelAttribute("user") SignUp signup,Model model,HttpSession session) {
	    	try {
	      // List<SignUp> listCustomers = customerRepo.findAll();
	       List<SignUp> listCustomers=userRepo.findAll();   	  
	   Signin signin=new Signin();
	    model.addAttribute("signin",signin);
	       model.addAttribute("listCustomers", listCustomers);
	        
	       listCustomers.forEach(System.out :: println);
	       BCryptPasswordEncoder pc=new BCryptPasswordEncoder();
	       
	        for(SignUp k: listCustomers) 
	        {
	        	
       		 if(k.getEmail().equals(signup.getEmail())) 
       		    {
       			 if(BCrypt.checkpw(signup.getPassword(), k.getPassword())){
       			
       			 signin.setEmail(k.getEmail()) ;
       			 signin.setPassword(k.getPassword());
       			 signin.setId(k.getId());
       			Signin z=customerRepo.save(signin);
       			System.out.println(z);
       			session.setAttribute("email", k.getEmail());
	        		return "index";
       		        		//model.addAttribute("obj",k);
       		        	}
       		    }
       		 else 
       		        	{

       		        		System.out.println("User does not Exist... Register First");
       		        	}
       		 
       		        }
	    	
	    	return "login_form";
       		       
	    	}catch(Exception e)
	    	{
	    		model.addAttribute("Validated","User doesnot exist");
	    		//System.out.println("User already Exists");
	    		return "login_form";
	    	}
	    }
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
}
