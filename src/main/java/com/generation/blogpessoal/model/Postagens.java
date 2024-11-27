package com.generation.blogpessoal.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity; //Esse jakarta é sobre as bibliotecas que lidam com o banco de dados.
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size; 

//Mapear que essa classe pertence as tabelas do banco de dados. @Entity
@Entity
@Table(name= "tb_postagens") //Vai chegar no banco de dados e pedir para criar as tabelas, create table.
public class Postagens {
	
	//Classe modelo, depois cria um objeto dessa classe. 
	//Classe que cria o modelo de banco de dados.
	
	//Cria modelo conforme queremos o banco de dados.
	
	//	Metódos que precisamos criar ara ter acesso as variváveis. Gets e Sters.
	// Source > Gets e Setrs> Seleciona todos.
	//Importante para o front end conseguir upar os dados.
	
	@Id
	@ GeneratedValue(strategy = GenerationType.IDENTITY) //Tipo da estratégia incrementada, auto incremente.
	private Long id;
	
	@NotBlank //Coloca anotação que é obrigatório preencher o titulo. Mesmo que NotNull (aceita caracter vazio) NotBlank não aceita anotação vazia.
	@Size(min = 10, max = 100) //Minim e máximo que você aceita de caracteres no titulo.
	private String titulo;
	
	@NotBlank
	@Size(min = 10, max = 1000) //Se colocar só o máximo não precisa por  minimo.
	private String texto;
	
	@UpdateTimestamp //O front não vai preencher, vai ser preenchido automaticamente.
	private LocalDateTime data; //Importa-se.
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public LocalDateTime getData() {
		return data;
	}
	public void setData(LocalDateTime data) {
		this.data = data;
	}
	
	//Fazer anotações, conseguir criar regras das dependências.
	//"Essa anotação vai seguir essas anotações.
	
}
