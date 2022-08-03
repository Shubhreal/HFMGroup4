package com.hungerfree.app;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class DonorController {
	 @Autowired
	 private Userrepo customerRepo;
	 @Autowired
	    private SignUpRepo userRepo;
	    @Autowired
	    private DonorRepo donorRepo;
	    
	 @GetMapping("/donor")
	  public String showDonorForm(Model model) {
	       Donor donor = new Donor();
	        model.addAttribute("donor", donor);
	       // b.savedet(user);
	         
	        return "donor";
	    }
	 
	 @PostMapping("/donoraction")
	    public String listAll(@ModelAttribute("donor") Donor signup,Model model,HttpSession session) {
	    	
	      // List<SignUp> listCustomers = customerRepo.findAll();
	       List<SignUp> listCustomers=userRepo.findAll();   	  
	     Donor donor=new Donor();
	    model.addAttribute("donor",donor);
	       model.addAttribute("listCustomers", listCustomers);
	        
	       listCustomers.forEach(System.out :: println);
	       
	        for(SignUp k: listCustomers) {
 		 if(k.getEmail().equalsIgnoreCase(signup.getEmail()) ==true) 
 		        	{
 			 donor.setEmail(k.getEmail()) ;
 			
 			 donor.setId(k.getId());
 			Donor z=donorRepo.save(signup);
 			System.out.println(z);
 			session.setAttribute("email", k.getEmail());
 			model.addAttribute("donor",z);
	        		return "checkout";
 		        		//model.addAttribute("obj",k);
 		        	}else 
 		        	{

 		        		System.out.println("User does not Exist... Register First");
 		        	}
 		 
 		        }
	    	
	    	return "donor";
 		       
	    }
}