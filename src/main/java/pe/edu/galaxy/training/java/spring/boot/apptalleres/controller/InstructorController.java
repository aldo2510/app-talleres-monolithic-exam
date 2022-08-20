package pe.edu.galaxy.training.java.spring.boot.apptalleres.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import lombok.Data;
import lombok.EqualsAndHashCode;
import pe.edu.galaxy.training.java.spring.boot.apptalleres.controller.common.CodeResponse;
import pe.edu.galaxy.training.java.spring.boot.apptalleres.controller.enums.CodeEnum;
import pe.edu.galaxy.training.java.spring.boot.apptalleres.entity.InstructorEntity;
import pe.edu.galaxy.training.java.spring.boot.apptalleres.service.exception.ServiceException;
import pe.edu.galaxy.training.java.spring.boot.apptalleres.service.service.inf.InstructorService;

@Controller
@Data
@EqualsAndHashCode(callSuper = false)
public class InstructorController extends GenericController {

	@Autowired
	private InstructorService instructorService;

	@GetMapping("/")
	public String index(InstructorEntity instructorEntity, Model model) {

		List<InstructorEntity> instructores;
		try {
			instructores = this.getInstructorService().findByLike(new InstructorEntity());
			model.addAttribute("instructores", instructores);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return "index";
	}

	@PostMapping("/buscar")
	public String buscar(InstructorEntity instructor, Model model) {

		List<InstructorEntity> instructores;
		try {
			instructores = this.getInstructorService().findByLike(instructor);
			model.addAttribute("instructores", instructores);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return "index";
	}

	@PostMapping("/limpiar")
	public String limpiar(Model model) {
		List<InstructorEntity> instructores;
		try {
			instructores = this.getInstructorService().findByLike(new InstructorEntity());
			model.addAttribute("instructorEntity", new InstructorEntity());
			model.addAttribute("instructores", instructores);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return "index";
	}

	@PostMapping("/grabar")
	public String grabar(InstructorEntity instructorEntity, Model model) {
		try {
			InstructorEntity ret;
			if (instructorEntity.getId() > 0) {
				ret = this.getInstructorService().update(instructorEntity);
			} else {
				ret = this.getInstructorService().insert(instructorEntity);
			}

			model.addAttribute("codeExito", CodeEnum.EXITO);

			if (ret != null) {

				model.addAttribute("codeResponse", codeResponse.get(CodeEnum.EXITO));
			} else {
				model.addAttribute("codeResponse", codeResponse.get(CodeEnum.ERROR));
			}
		} catch (ServiceException e) {
			model.addAttribute("codeResponse", codeResponse.get(CodeEnum.ERROR));
			e.printStackTrace();
		}
		return "instructor-registro";
	}

	@GetMapping("/nuevo")
	public String nuevo(InstructorEntity instructorEntity, Model model) {
		model.addAttribute("instructorEntity", new InstructorEntity());
		model.addAttribute("codeResponse", new CodeResponse());
		return "instructor-registro";
	}

	@GetMapping("/modificar/{id}")
	public String modificar(@PathVariable("id") Long id, Model model) {
		model.addAttribute("codeResponse", new CodeResponse());
		try {
			InstructorEntity instructorEntity = this.getInstructorService().findById(id);
			model.addAttribute("instructorEntity", instructorEntity);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return "instructor-registro";
	}

	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") Long id, Model model) {
		try {

			InstructorEntity prmInstructorEntity = new InstructorEntity();
			prmInstructorEntity.setId(id);

			InstructorEntity instructorEntity = this.getInstructorService().delete(prmInstructorEntity);
			if (instructorEntity != null) {
				model.addAttribute("instructorEntity", new InstructorEntity());
				List<InstructorEntity> instructores = this.getInstructorService().findByLike(new InstructorEntity());
				model.addAttribute("instructores", instructores);
			}

		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return "index";
	}

	@GetMapping("/cancelar")
	public String cancelar(Model model) {
		model.addAttribute("instructorEntity", new InstructorEntity());
		try {
			List<InstructorEntity> instructores = this.getInstructorService().findByLike(new InstructorEntity());
			model.addAttribute("instructores", instructores);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		return "index";
	}

	public InstructorService getInstructorService() {
		return instructorService;
	}

	public void setInstructorService(InstructorService instructorService) {
		this.instructorService = instructorService;
	}

}
