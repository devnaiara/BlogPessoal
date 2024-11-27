package com.generation.blogpessoal.repository;

import com.generation.blogpessoal.model.Postagens;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostagemRepository extends JpaRepository<Postagens, Long>  {
	
	//extends Palavra reservada para herança
	//<> Dentro fica o parametro, nome da classe que fez o banco de dados.
	//Descreve os metodos da JPA.
	
	//Interface JPA
	//Usar as interfaces do JPA para utilizar e acessar o banco de dados.
	//Por de trás do hibernate tem o acesso ao banco de dados.
	//Herda a interface JPA - Interface Repository.
	
	
	//Palavra reservada para herança.
	
}
