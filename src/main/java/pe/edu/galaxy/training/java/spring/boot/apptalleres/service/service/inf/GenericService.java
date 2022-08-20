package pe.edu.galaxy.training.java.spring.boot.apptalleres.service.service.inf;

import java.util.List;
import pe.edu.galaxy.training.java.spring.boot.apptalleres.service.exception.ServiceException;

public interface GenericService<T> {
	
		List<T> findByLike(T t) throws ServiceException;
		
		T findById(Long id) throws ServiceException;
		
		T insert(T t) throws ServiceException;
		
		T update(T t) throws ServiceException;
		
		T delete(T t) throws ServiceException;
}
