package pe.edu.galaxy.training.java.spring.boot.apptalleres.service.service.impl;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.Data;
import lombok.EqualsAndHashCode;
import pe.edu.galaxy.training.java.spring.boot.apptalleres.entity.InstructorEntity;
import pe.edu.galaxy.training.java.spring.boot.apptalleres.repository.InstructorRepository;
import pe.edu.galaxy.training.java.spring.boot.apptalleres.service.exception.ServiceException;
import pe.edu.galaxy.training.java.spring.boot.apptalleres.service.service.inf.InstructorService;

@Service
@Transactional
@Data
@EqualsAndHashCode(callSuper=false)
public class 	InstructorServiceImpl 
				extends GenericServiceImpl
				implements InstructorService{
	
	@Autowired
	private InstructorRepository instructorRepository;

	@Override
	public List<InstructorEntity> findByLike(InstructorEntity instructorEntity) throws ServiceException {
		//return this.getInstructorRepository().findAll();
		try {
			String nombre =instructorEntity.getNombre();
			nombre= (nombre==null)?"":nombre;
			List<InstructorEntity> instructores= this.instructorRepository.findByLike("%"+nombre+"%");
			return instructores;
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public InstructorEntity findById(Long id) throws ServiceException {
		try {
			
			Optional<InstructorEntity> opt=this.getInstructorRepository().findById(id);
			if (opt!=null) {
				if(opt.isPresent()) {
					return opt.get();
				}	
			}
			return null;
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public InstructorEntity insert(InstructorEntity instructorEntity) throws ServiceException {
		try {
			return this.getInstructorRepository().save(instructorEntity);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public InstructorEntity update(InstructorEntity instructorEntity) throws ServiceException {
		try {
			return this.getInstructorRepository().save(instructorEntity);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public InstructorEntity delete(InstructorEntity instructorEntity) throws ServiceException {
		InstructorEntity ret= this.findById(instructorEntity.getId());
		if (ret!=null) {
			ret.setEstado("0");
			return this.update(ret);
		}
		return null;
	}

	public InstructorRepository getInstructorRepository() {
		return instructorRepository;
	}

	public void setInstructorRepository(InstructorRepository instructorRepository) {
		this.instructorRepository = instructorRepository;
	}
	
	
}
