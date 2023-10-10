package com.web.automotriz.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.automotriz.dto.ConsultaMercancia;
import com.web.automotriz.model.Mercancia;
import com.web.automotriz.service.MercanciaService;

@RestController
@RequestMapping("/api/mercancia/")
public class MercanciaController {

	@Autowired
	MercanciaService mercanciaService;
	
	@PostMapping("/guardarMercancia")
	public ResponseEntity<?> registrarMercancia(@RequestBody Mercancia mercancia){
		
		return new ResponseEntity(mercanciaService.insertMercancia(mercancia), HttpStatus.OK);
		
	}
	
	@PostMapping("/actualizarMercancia")
	public ResponseEntity<?> actualizarMercancia(@RequestBody Mercancia mercancia){
		
		return new ResponseEntity(mercanciaService.updateMercancia(mercancia), HttpStatus.OK);
		
	}
	
	@PostMapping("/eliminarMercancia")
	public ResponseEntity<?> eliminarMercancia(@RequestBody Mercancia mercancia){
		
		return new ResponseEntity(mercanciaService.deleteMercancia(mercancia), HttpStatus.OK);
		
	}
	
	@PostMapping("/consultaMercancia")
	public ResponseEntity<?> registroMercancia(@RequestBody ConsultaMercancia consultaMercancia){
		
		return new ResponseEntity(mercanciaService.selectRegistroMercancia(consultaMercancia), HttpStatus.OK);
		
	}
	
}
