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
public class ReceiverController {
	@Autowired
	private Userrepo customerRepo;
	@Autowired
	private SignUpRepo userRepo;
	@Autowired
	private DonorRepo donorRepo;
	@Autowired
	private ReceiverRepo receiverRepo;

	@GetMapping("/receiver")
	public String showForm(Model model) {
		Receiver receiver = new Receiver();

		model.addAttribute("receiver", receiver);
		

		return "receiver";
	}

	 @PostMapping("/receiveraction")
	    public String listAll(@ModelAttribute("receiver") Receiver signup,Model model,HttpSession session) {
	    	
	     
	       List<SignUp> listCustomers=userRepo.findAll();   	  
	     Receiver receiver=new Receiver();
	    model.addAttribute("receiver",receiver);
	       model.addAttribute("listCustomers", listCustomers);
	        
	       listCustomers.forEach(System.out :: println);
	       
	        for(SignUp k: listCustomers) {
    		 if(k.getEmail().equalsIgnoreCase(signup.getEmail()) ==true) 
    		        	{
    			 receiver.setEmail(k.getEmail()) ;
    			
    			 receiver.setId(k.getId());
    			Receiver z=receiverRepo.save(signup);
    			System.out.println(z);
    			session.setAttribute("email", k.getEmail());
    			model.addAttribute("receiver",z);
	        		return "checkout";
    		        		
    		        	}else 
    		        	{

    		        		System.out.println("User does not Exist... Register First");
    		        	}
    		 
    		        }
	    	
	    	return "receiver";
    		       
	    	
	 }
}