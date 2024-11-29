package com.generation.blogpessoal.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.generation.blogpessoal.model.Postagens;
import com.generation.blogpessoal.repository.PostagemRepository;

import jakarta.validation.Valid;

//Controle acesso de requisisões, caminho de get e post.

@RestController
@RequestMapping("/postagens")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PostagemController {

	@Autowired
	private PostagemRepository postagemRepository;
	
	//Autowired atualiza e injeta dependência.
	//Injetando que vai ser dependência do JPA ao banco de dados.
	//O objeto vai receber o postagem repository.
	//Dar um nome e o tipo que erá usado nessa classe.
	
	@GetMapping
	public ResponseEntity<List<Postagens>> getAll(){
		return ResponseEntity.ok(postagemRepository.findAll()); //Entra com a requisição que entra aqui.
	}
	
	//Get Mapping Metodo da requisição. Quando acessar a requisição getall - select de todas as informações.
	//Get mais simples só traz informações.
	//Objeto metodo postagem (id, titulo, data)
	//Quando chama ela e dá um ponto dá uma injeção de dependência.
	//Anotação tá fazendo a injeção de dependência.
	//Lista sempre volta, independente de vazia ou não.
	//postagens é o caminho para chegar no controlle.
	
	@GetMapping("/{id}")
	public ResponseEntity<Postagens> getById(@PathVariable Long Id){
		return postagemRepository.findById(Id).map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
	//Criou um parametro do metodo long que pediu requisisão, que vai no banco de dados, se tiver resposta ele traz resposta do json ou traz notfound (nao foi encontrado). 
	//PathVariable garante o que tá vindo no caminho e guardar o ID.
	//metodo findbyid acessa o banco de dados.
	//map mapeia resposta se for ok retorna ok com as informações do objeto e devolve em formato json.
	//or else trata tratativa de erro, gerando informação ao front end.
	//agora acesso é feito através de biblioteca e metodos.
	
	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<Postagens>> getByTitulo(@PathVariable String titulo){
		return ResponseEntity.ok(postagemRepository.findAllByTituloContainingIgnoreCase(titulo));
	}
	
	//Pega pelo documento json.
	
	@PostMapping
	public ResponseEntity<Postagens> post(@Valid @RequestBody Postagens postagem){
		return ResponseEntity.status(HttpStatus.CREATED).body(postagemRepository.save(postagem));
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping(	"/{id}")
	public void delete(@PathVariable Long id) {
		Optional<Postagens> postagem = postagemRepository.findById(id);
		
		if(postagem.isEmpty()) 
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
			
		postagemRepository.deleteById(id);
					
	}
	
	@PutMapping
	public ResponseEntity<Postagens>put(@Valid @RequestBody Postagens postagem){
		return postagemRepository.findById(postagem.getId())
				.map(resposta -> ResponseEntity.status(HttpStatus.OK).body(postagemRepository.save(postagem)))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
		}
	}
	
