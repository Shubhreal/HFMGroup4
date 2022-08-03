package com.hungerfree.app;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class MediatorController {
	@Autowired
	private Userrepo customerRepo;
	@Autowired
	private SignUpRepo userRepo;
	@Autowired
	private MediatorRepo mediatorRepo;
	
	@GetMapping("/mediator")
	public String showForm(Model model) {
		Mediator mediator = new Mediator();
		model.addAttribute("mediator", mediator);
		

		return "mediator";
	}

	@PostMapping("/mediatoraction")
	    public String listAll(@ModelAttribute("mediator") Mediator mediator,Model model) {
		
		

       		 	    	Mediator z=mediatorRepo.save(mediator);     
       		 	    	System.out.println(z);
       		 	    model.addAttribute("success","success");
       		        		return "index";
       		        		//System.out.println("Enter a valid password");
	}
	    	
}
