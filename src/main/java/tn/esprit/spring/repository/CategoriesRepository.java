package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.entity.Categories;

@Repository
public interface CategoriesRepository extends CrudRepository <Categories,Long>{
	/*@Query("SELECT c FROM Client c WHERE c.profession= ?1")
	List<Client> retrieveClientsByProfession(Profession profession);
	
	@Modifying
	@Query("update Client c set c.categorieClient = ?1 where c.profession =?2")
	int updateClientCategorieByProfession( CategorieClient categorieClient, Profession profession);
	
	@Modifying
	@Query("DELETE FROM Client c WHERE c.categorieClient= ?1 AND c.profession = ?2")
	int deleteClientByCategorieClientAndProfession(CategorieClient categorieClient, Profession profession);
	
	@Modifying
	@Query(value = "INSERT INTO Categories (categ_name) VALUES (:categ_name)",nativeQuery = true)
	void insertApprenant(@Param("categ_name") String CategName);*/
}