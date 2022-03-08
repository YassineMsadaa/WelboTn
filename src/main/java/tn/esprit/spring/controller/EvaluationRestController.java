package tn.esprit.spring.controller;

import java.util.List;
import java.util.UUID;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import tn.esprit.spring.entity.Evaluation;
import tn.esprit.spring.services.EvaluationServiceImpl;
@RestController
@RequestMapping("/evaluation")
public class EvaluationRestController {
	@Autowired
	EvaluationServiceImpl evaluationServiceImpl;
	@PostMapping("/add-evaluation")
	@ResponseBody
	public Evaluation addEvaluation(@RequestBody Evaluation e)
	{
	Evaluation evaluation = evaluationServiceImpl.addEvaluation(e);
	return evaluation;
	}
	@GetMapping("/retrieve-All-Evaluations")
	@ResponseBody
	public List<Evaluation> getEvaluations()
	{
		List<Evaluation> listEvaluations = evaluationServiceImpl.retrieveAllEvaluation();
		return listEvaluations;
	}
	@DeleteMapping("/remove-Evaluation/{id}")
	@ResponseBody
	public void removeEvaluation(@PathVariable("id")Integer Id)
	{
	evaluationServiceImpl.deleteEvaluation(Id);
	}
	//@Controller
	//public class DateController {
	//@GetMapping(path = "/date")
	 // public String afficherDate(Model model) {
	   // model.addAttribute("now", new Date());
	    //return "affichageDate";
	 // }
	//}
	
}

	


