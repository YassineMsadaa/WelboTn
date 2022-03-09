package tn.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entity.Evaluation;
import tn.esprit.spring.service.EvaluationServiceImpl;

import java.util.List;
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

	


