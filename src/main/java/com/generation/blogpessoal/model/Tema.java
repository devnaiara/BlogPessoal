package com.generation.blogpessoal.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table (name = "tb_temas")
public class Tema {
	
	//anotação para criar um id na tabela e o @GeneratedValue acrescenta valor automaticamente
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//NotNull aceita espaço em branco - NotBlank não aceita espaço em branco
	@NotNull(message = "O atributo Descrição é obrigatório") //pode se colocar uma mensagem
	private String descricao;
	
	//Muitos pra muitos não gera coluna no banco de dados. FK sempre na tabela de postagem.
	@OneToMany(fetch = FetchType.LAZY, mappedBy ="tema", cascade = CascadeType.REMOVE ) //Apagar em cascata "todos"
	@JsonIgnoreProperties("tema")
	private List<Postagens> postagem;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Postagens> getPostagem() {
		return postagem;
	}

	public void setPostagem(List<Postagens> postagem) {
		this.postagem = postagem;
	}
	
	

}
