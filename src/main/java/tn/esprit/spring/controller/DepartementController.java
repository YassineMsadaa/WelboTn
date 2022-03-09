package tn.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.spring.repository.IDepratmentRepository;

@RestController
@RequestMapping("/departement")
public class DepartementController {
    @Autowired
    IDepratmentRepository depratmentRepository;


}
