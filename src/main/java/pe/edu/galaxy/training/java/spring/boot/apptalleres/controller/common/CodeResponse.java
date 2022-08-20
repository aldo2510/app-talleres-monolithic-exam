package pe.edu.galaxy.training.java.spring.boot.apptalleres.controller.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import pe.edu.galaxy.training.java.spring.boot.apptalleres.controller.constantes.ConstMessage;
import pe.edu.galaxy.training.java.spring.boot.apptalleres.controller.enums.CodeEnum;

@Data
@AllArgsConstructor
public class CodeResponse {

	private CodeEnum codigo;
	private String mensaje;

	public CodeResponse() {
		
	}
	
//	public CodeResponse(CodeEnum exito, String msgRegExito) {
//		this.setCodigo(exito);
//		this.setMensaje(msgRegExito);
//	}

	public CodeResponse get(CodeEnum codeEnum) {

		switch (codeEnum) {
		case EXITO: {

//			return new CodeResponse(CodeEnum.EXITO, ConstMessage.MSG_REG_EXITO);
			CodeResponse codeResponse = new CodeResponse();
			codeResponse.setCodigo(CodeEnum.EXITO);
			codeResponse.setMensaje(ConstMessage.MSG_REG_EXITO);			
			return codeResponse;
		}
		case ERROR: {

//			return new CodeResponse(CodeEnum.ERROR, ConstMessage.MSG_REG_ERROR);
			CodeResponse codeResponse = new CodeResponse();
			codeResponse.setCodigo(CodeEnum.ERROR);
			codeResponse.setMensaje(ConstMessage.MSG_REG_EXITO);			
			return codeResponse;

		}
		default:
			return null;
		}

	}

	public CodeEnum getCodigo() {
		return codigo;
	}

	public void setCodigo(CodeEnum codigo) {
		this.codigo = codigo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

}
