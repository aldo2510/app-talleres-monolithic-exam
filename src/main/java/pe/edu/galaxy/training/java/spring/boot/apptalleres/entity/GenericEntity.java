package pe.edu.galaxy.training.java.spring.boot.apptalleres.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import lombok.Data;

@Data
@MappedSuperclass
public abstract class GenericEntity {

	@Column(name = "estado")
	private String estado = "";

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
