package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entities.Evaluation;
import tn.esprit.spring.reposi.EvaluationRepository;
@Service
@Slf4j
public class EvaluationService implements EvaluationServiceImpl {
	@Autowired
	EvaluationRepository evaluationRepository;

	@Override
	public List<Evaluation> retrieveAllEvaluation() {
		List<Evaluation>evaluation=(List<Evaluation>)evaluationRepository.findAll();
		for (Evaluation evaluations :evaluation)
		{
							log.info("evaluation :" + evaluation);
		}
return evaluation;
	}

	@Override
	public Evaluation addEvaluation(Evaluation e) {
		return evaluationRepository.save(e);
	}

	@Override
	public void deleteEvaluation(Integer id) {
		evaluationRepository.deleteById(id);
		
	}

	@Override
	public Evaluation updateEvaluation(Evaluation e) {
		return evaluationRepository.save(e);
	}

	@Override
	public Evaluation retrieveEvaluation(Integer id) {
		Evaluation evaluation = evaluationRepository.findById(id).orElse(null);
		System.out.println("Evaluation :" + evaluation);
		return evaluation;
	}
	



	

}
