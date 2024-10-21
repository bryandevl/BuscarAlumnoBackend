package com.BRYANFront.SERVICE;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.stereotype.Service;

import com.BRYANFront.ENTIDAD.Alumno;

@Service
public class AlumnoService {
	
	 // Método que busca un alumno por su código
    public Alumno buscarAlumno(String codigo) throws InterruptedException {
        // Simula un tiempo de respuesta de 5 segundos (p. ej., para pruebas de rendimiento)
        Thread.sleep(5000);

        // Intenta leer el archivo "alumnos.txt"
        try (BufferedReader br = new BufferedReader(new FileReader("alumnos.txt"))) {
            String line;
            // Lee el archivo línea por línea
            while ((line = br.readLine()) != null) {
                // Divide la línea en partes utilizando el carácter ';' como separador
                String[] data = line.split(";");
                // Compara el primer elemento (código) con el código buscado
                if (data[0].equals(codigo)) {
                    // Si se encuentra el código, crea un nuevo objeto Alumno
                    Alumno alumno = new Alumno();
                    // Asigna los datos correspondientes al objeto Alumno
                    alumno.setCodigo(data[0]);
                    alumno.setNombres(data[1]);
                    alumno.setApellidos(data[2]);
                    alumno.setCarrera(data[3]);
                    alumno.setCiclo(data[4]);
                    // Devuelve el objeto Alumno encontrado
                    return alumno;
                }
            }
        } catch (IOException e) {
            // Maneja excepciones de entrada/salida
            e.printStackTrace();
        }
        // Si no se encuentra el alumno, devuelve null
        return null;
    }

}
