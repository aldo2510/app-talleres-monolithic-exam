package pe.edu.galaxy.training.java.spring.boot.apptalleres.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.galaxy.training.java.spring.boot.apptalleres.entity.InstructorEntity;

@Repository
public interface InstructorRepository extends JpaRepository<InstructorEntity, Long>{
	
	@Query("Select p from InstructorEntity p where nombre like :nombre")
	List<InstructorEntity> findByLike(@Param("nombre") String nombre);
}
