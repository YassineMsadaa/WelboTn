package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Evaluation;

public interface EvaluationServiceImpl {

	List<Evaluation> retrieveAllEvaluation();

	Evaluation addEvaluation(Evaluation e);

	void deleteEvaluation(Integer id);

	Evaluation updateEvaluation(Evaluation e);

	Evaluation retrieveEvaluation(Integer id);

	Evaluation findEvaluationByEmail(String email);

}
