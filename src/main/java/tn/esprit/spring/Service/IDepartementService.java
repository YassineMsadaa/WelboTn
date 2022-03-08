package tn.esprit.spring.Service;

import tn.esprit.spring.Entity.Departement;

import java.util.List;

public interface IDepartementService {
    public Departement addDepartement(Departement departement);
    public void deleteDepartement(Long id);
    public List<Departement> getDepartements();
    public Departement updateDepartement(Departement departement);
    public Departement getDepartement(Long id);
}
