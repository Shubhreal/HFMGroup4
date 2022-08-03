package com.hungerfree.app;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CheckOutController {
	@Autowired
	private Userrepo customerRepo;
	@Autowired
	private SignUpRepo userRepo;
	@Autowired
	private DonorRepo donorRepo;
	@Autowired
	private CheckOutRepo checkoutRepo;

	@GetMapping("/checkout")
	public String showForm(Model model) {
		CheckOut checkout = new CheckOut();

		model.addAttribute("checkout", checkout);
		// b.savedet(user);

		return "checkout";
	}

	@PostMapping("/checkoutaction")
	public String listAll(@ModelAttribute("checkout") CheckOut checkout, Model model) {

      model.addAttribute("success","success");
		return "index";
	}

}