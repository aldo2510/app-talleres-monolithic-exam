package pe.edu.galaxy.training.java.spring.boot.apptalleres.controller;

import lombok.Data;
import pe.edu.galaxy.training.java.spring.boot.apptalleres.controller.common.CodeResponse;

@Data
public class GenericController {
	
	protected CodeResponse codeResponse;

	public GenericController() {
		codeResponse= new CodeResponse();
	}

}
