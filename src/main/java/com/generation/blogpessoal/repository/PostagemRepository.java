package com.generation.blogpessoal.repository;

import com.generation.blogpessoal.model.Postagens;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface PostagemRepository extends JpaRepository<Postagens, Long>  {
	
	public List<Postagens> findAllByTituloContainingIgnoreCase(@Param("titulo") String titulo);
	
	//herda a jpa que é a interface responsavel pelo metodo de acesso ao banco de dados, e tambem personaliza metodos especificos.
	//repository o metodo de acessar o JPA.
	
	//extends Palavra reservada para herança
	//<> Dentro fica o parametro, nome da classe que fez o banco de dados.
	//Descreve os metodos da JPA.
	
	//Interface JPA
	//Usar as interfaces do JPA para utilizar e acessar o banco de dados.
	//Por de trás do hibernate tem o acesso ao banco de dados.
	//Herda a interface JPA - Interface Repository.
	
	//JPA chamando para ter acesso ao banco de dados.
	//Toda vez que usa postagem tem acesso ao banco de dados.
	
	//Palavra reservada para herança.
	
}
