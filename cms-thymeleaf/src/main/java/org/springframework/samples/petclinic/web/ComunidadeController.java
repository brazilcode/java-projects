package org.springframework.samples.petclinic.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Comunidade;
import org.springframework.samples.petclinic.service.ComunidadeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Collection;

@Controller
@SessionAttributes(types = Comunidade.class)
public class ComunidadeController {

	@Autowired
	public ComunidadeService comunidadeService;

	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}

	@RequestMapping(value = "/comunidades/new", method = RequestMethod.GET)
	public String initCreationForm(Model model) {
        Comunidade comunidade = new Comunidade();
		model.addAttribute(comunidade);
		return "comunidades/createOrUpdateComunidadeForm";
	}

	@RequestMapping(value = "/comunidades/new", method = RequestMethod.POST)
	public String processCreationForm(@Valid Comunidade comunidade, BindingResult result,
			SessionStatus status) {
		if (result.hasErrors()) {
			return "comunidades/createOrUpdateComunidadeForm";
		} else {
			status.setComplete();
			return "redirect:/comunidades/" + comunidade.getId();
		}
	}

	@RequestMapping(value = "/comunidades/find", method = RequestMethod.GET)
	public String initFindForm(Model model) {
		model.addAttribute("comunidade", new Comunidade());
		return "comunidades/findComunidades";
	}

	@RequestMapping(value = "/comunidades", method = RequestMethod.GET)
	public String processFindForm(Comunidade comunidade, BindingResult result,
			Model model) {
		if (comunidade.getNome() == null) {
            comunidade.setNome("");		}

		Collection<Comunidade> results = this.comunidadeService.findAllComunidades();

		if (results.size() < 1) {
			result.rejectValue("nome", "notFound", "not found");
			return "comunidade/findComunidades";
		}
		if (results.size() > 1) {
			model.addAttribute("comunidades", results);
			return "comunidades/lista";
		} else {
            comunidade = results.iterator().next();
			return "redirect:/comunidades/" + comunidade.getId();
		}
	}

	@RequestMapping(value = "/comunidades/{comunidadeId}/edit", method = RequestMethod.GET)
	public String initUpdateComunidadeForm(@PathVariable("comunidadeId") int comunidadeId,
			Model model) {
		return "comunidades/createOrUpdateComunidadeForm";
	}

	@RequestMapping(value = "/comunidades/{comunidadeId}/edit", method = RequestMethod.PUT)
	public String processUpdateComunidadeForm(@Valid Comunidade comunidade,
			BindingResult result, SessionStatus status) {
		if (result.hasErrors()) {
			return "comunidades/createOrUpdateComunidadeForm";
		} else {
			status.setComplete();
			return "redirect:/comunidades/{comunidadeId}";
		}
	}

	@RequestMapping("/comunidades/{comunidadeId}")
	public ModelAndView showComunidade(@PathVariable("comunidadeId") int comunidadeId) {
		ModelAndView mav = new ModelAndView("comunidades/comunidadeDetails");
		return mav;
	}

}
