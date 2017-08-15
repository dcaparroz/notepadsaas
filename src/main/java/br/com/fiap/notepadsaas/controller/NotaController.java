package br.com.fiap.notepadsaas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.fiap.notepadsaas.model.Nota;
import br.com.fiap.notepadsaas.repository.NotaRepository;

@RestController
@CrossOrigin
@RequestMapping(value = "/nota")
public class NotaController {

	@Autowired
	private NotaRepository notaRepository;

	
	@GetMapping
	public List<Nota> findall(){
		return notaRepository.findAll();
	}

	@GetMapping(value = "/titulo/{titulo}")
	private List<Nota> findByTitulo(@PathVariable(value = "titulo") String q){
		return notaRepository.findByTitulo(q);
	}

	@PostMapping
	public void save(@RequestBody Nota nota){
	notaRepository.save(nota);
	
	}
}
