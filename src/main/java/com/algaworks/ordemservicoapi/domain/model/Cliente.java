package com.algaworks.ordemservicoapi.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Size(max = 60)
    private String nome;
    @NotBlank
    @Email
    @Size(max = 255)
    private String email;
    @NotBlank
    @Size(max = 20)
    private String telefone;

    public Cliente() {}

    public Long getId() {
        return this.id;
    }

    public void setId(Long valor) {
        this.id = valor;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String valor) {
        this.nome = valor;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String valor) {
        this.email = valor;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String valor) {
        this.telefone = valor;
    }

    @Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Cliente other = (Cliente) obj;
	if (id != other.id)
		return false;
	if (id == null) {
		if (other.id != null)
			return false;
	} else if (!id.equals(other.id))
		return false;
	return true;
}

}