package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Evaluation;
import tn.esprit.spring.services.EvaluationService;
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
	public List<Evaluation> getEvaluations() {
		List<Evaluation> listEvaluations = evaluationServiceImpl.retrieveAllEvaluation();
		return listEvaluations;
		}
	@DeleteMapping("/remove-Evaluation/{id}")
	@ResponseBody
	public void removeEvaluation(@PathVariable("id")Integer Id) {
	evaluationServiceImpl.deleteEvaluation(Id);
	}
}
	


