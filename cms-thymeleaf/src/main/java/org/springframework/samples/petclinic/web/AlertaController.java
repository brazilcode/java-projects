package org.springframework.samples.petclinic.web;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Alerta;
import org.springframework.samples.petclinic.service.AlertaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AlertaController {

	@Autowired
	public AlertaService alertaService;

	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}

	@RequestMapping(value = "/alertas/novo", method = RequestMethod.GET)
	public String initCreationForm(Model model) {
		Alerta alerta = new Alerta();
		model.addAttribute(alerta);
		return "alertas/createUpdateAlertaForm";
	}

	@RequestMapping(value = "/alertas/novo", method = RequestMethod.POST)
	public String processCreationForm(@Valid Alerta alerta, BindingResult result) {
		if (result.hasErrors()) {
			return "alertas/createUpdateAlertaForm";
		} else {
			this.alertaService.saveAlerta(alerta);
			return "redirect:/alertas";
		}
	}

	@RequestMapping(value = "/alertas/procurar", method = RequestMethod.GET)
	public String initFindForm(Model model) {
		model.addAttribute("alerta", new Alerta());
		return "alertas/findAlertas";
	}

	@RequestMapping(value = "/alertas", method = RequestMethod.GET)
	public String processFindForm(Alerta alerta, BindingResult result,
			Model model) {

		if (alerta.getTitulo() == null) {
			alerta.setTitulo("");
		}

		Collection<Alerta> results = this.alertaService
				.findAlertaByTitulo(alerta.getTitulo());

		if (results.size() < 1) {
			result.rejectValue("titulo", "notFound", "not found");
			return "alertas/findAlertas";
		} else {
			model.addAttribute("alertas", results);
			return "alertas/alertasList";
		}
	}

	@RequestMapping(value = "/alertas/{alertaId}/remover", method = RequestMethod.GET)
	public String initRemoveAlertaForm(@PathVariable("alertaId") int alertaId) {
		this.alertaService.removeAlertaById(alertaId);
		return "redirect:/alertas";
	}

	@RequestMapping(value = "/alertas/{alertaId}/editar", method = RequestMethod.GET)
	public String initUpdateAlertaForm(@PathVariable("alertaId") int alertaId,
			Model model) {
		Alerta alerta = this.alertaService.findAlertaById(alertaId);
		model.addAttribute(alerta);
		return "alertas/createUpdateAlertaForm";
	}

	@RequestMapping(value = "/alertas/{alertaId}/editar", method = RequestMethod.PUT)
	public String processUpdateAlertaForm(
			@PathVariable("alertaId") int alertaId, @Valid Alerta alerta,
			BindingResult result) {
		if (result.hasErrors()) {
			return "alertas/createOrUpdateAlertaForm";
		} else {
			alerta.setId(alertaId);
			this.alertaService.saveAlerta(alerta);
			return "redirect:/alertas";
		}
	}

	/**
	 * Custom handler for displaying an alerta.
	 * 
	 * @param alertaId
	 *            the ID of the alerta to display
	 * @return a ModelMap with the model attributes for the view
	 */
	@RequestMapping("/alertas/{alertaId}")
	public ModelAndView showAlerta(@PathVariable("alertaId") int alertaId) {
		ModelAndView mav = new ModelAndView("alertas/alertaDetails");
		mav.addObject(this.alertaService.findAlertaById(alertaId));
		return mav;
	}

}
