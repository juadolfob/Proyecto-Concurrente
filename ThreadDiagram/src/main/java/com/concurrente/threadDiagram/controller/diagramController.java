package com.concurrente.threadDiagram.controller;

import java.net.URI;
import java.net.URISyntaxException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import control.State;

@RestController
public class diagramController {

	private Object[] test;
	private ArrayList<State>[] matrix;
	private int[] errors;
	private Selection selection;
	
	public diagramController() {
	}
	
	@GetMapping("/data")
	public ArrayList<State>[] sendResults() {
		System.out.println(matrix.toString());
		return matrix;
	}

	@RequestMapping(value = "/selection", method = RequestMethod.POST)
	public ResponseEntity<String> getSelection(@RequestBody Selection currSelection) throws URISyntaxException {
		selection = currSelection;
		matrix = selection.runSelected();
		URI location = new URI("http://localhost:8080/selection");
		return ResponseEntity.created(location).header("ResponseHeader", "Value").body("Hello");
	}
	
	@GetMapping("/errors")
	public int[] sendErrors() {
		errors = selection.getErrors();
		if(errors == null) {
			return null;
		}
		return errors;
	}
}
