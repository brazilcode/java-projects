package org.springframework.samples.petclinic.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	@RequestMapping(value = "/cms", method = RequestMethod.GET)
	public String showHomeCms() {
		return "home/homeCms";
	}

	@RequestMapping(value = "/monitoracao", method = RequestMethod.GET)
	public String showHomeMonitoracao() {
		return "home/homeMonitoracao";
	}
}
