package com.BRYANFront.CONTROLADOR;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.BRYANFront.ENTIDAD.Alumno;
import com.BRYANFront.SERVICE.AlumnoService;

@RestController
public class AlumnoController {

	 private final AlumnoService alumnoService;

	    public AlumnoController(AlumnoService alumnoService) {
	        this.alumnoService = alumnoService;
	    }

	    @GetMapping("/buscar")
	    public ResponseEntity<Alumno> buscarAlumno(@RequestParam String codigo) throws InterruptedException {
	        Alumno alumno = alumnoService.buscarAlumno(codigo);
	        if (alumno != null) {
	            return ResponseEntity.ok(alumno);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
	}