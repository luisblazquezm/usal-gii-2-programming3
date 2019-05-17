/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.Scanner;
//import static com.coti.tools.Esdia.*;
import java.util.Random;
/**
 *
 * @author pgina27
 */
public class Ficha {
    
    private String apellidos;
    private float calificacion;
    private String comentarios;
    private String curso;
    private String dni;
    private String grupoPracticas;
    private String nombre;
    
    private static final String[] APELLIDOS = {"Smith", "Jones", "García", "Perez", "Schmidt", "Gnahm"};
    private static final String[] COMENTARIOS_POSIBLES = {"Aplicado", "Prudente", "Mendrugo"};
    private static final String[] CURSOS = {"1", "2", "3", "4"};
    private static final String[] DNIS = {"12345678A", "45678123B", "78912345C"};
    private static final String[] GRUPOS = {"A", "B"};
    private static final String[] NOMBRES = {"María", "José", "Jezabel", "Gloria", "Verena", "Ada"};

    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<Alt + Insert --> Constructor y todo
    
    public Ficha(String apellidos, float calificacion, String comentarios, String curso, String dni, String grupoPracticas, String nombre) {
        this.apellidos = apellidos;
        this.calificacion = calificacion;
        this.comentarios = comentarios;
        this.curso = curso;
        this.dni = dni;
        this.grupoPracticas = grupoPracticas;
        this.nombre = nombre;
    }
    
    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< cojo todo los atributos --> Boton Derecho --> Refactor --> Encapsulate Fields
    
    public Ficha instanceWithRandomAttributes(){
        Random r = new Random();
        
        String apellido = APELLIDOS[r.nextInt(APELLIDOS.length)];
        float calificacion = 5 + r.nextInt(10);
        String comentario = COMENTARIOS_POSIBLES[r.nextInt(COMENTARIOS_POSIBLES.length)];
        String curso = CURSOS[r.nextInt(CURSOS.length)];
        String dni = DNIS[r.nextInt(DNIS.length)];
        String grupo = GRUPOS[r.nextInt(GRUPOS.length)];
        String nombre = NOMBRES[r.nextInt(NOMBRES.length)];
        
        return new Ficha(apellido, calificacion, comentario, curso, dni, grupo, nombre);
    }
    
    
    public String exportStateAsColumns() {
        return String.format("| %-8s | %-15s | %-12s | %2s | %2s | %6.1f | %20s |",
                this.dni,
                this.apellidos,
                this.nombre,
                this.curso,
                this.grupoPracticas,
                this.calificacion,
                this.comentarios);
        
       
    }

    /**
     * @return the apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * @param apellidos the apellidos to set
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * @return the calificacion
     */
    public float getCalificacion() {
        return calificacion;
    }

    /**
     * @param calificacion the calificacion to set
     */
    public void setCalificacion(float calificacion) {
        this.calificacion = calificacion;
    }

    /**
     * @return the comentarios
     */
    public String getComentarios() {
        return comentarios;
    }

    /**
     * @param comentarios the comentarios to set
     */
    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    /**
     * @return the curso
     */
    public String getCurso() {
        return curso;
    }

    /**
     * @param curso the curso to set
     */
    public void setCurso(String curso) {
        this.curso = curso;
    }

    /**
     * @return the dni
     */
    public String getDni() {
        return dni;
    }

    /**
     * @param dni the dni to set
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * @return the grupoPracticas
     */
    public String getGrupoPracticas() {
        return grupoPracticas;
    }

    /**
     * @param grupoPracticas the grupoPracticas to set
     */
    public void setGrupoPracticas(String grupoPracticas) {
        this.grupoPracticas = grupoPracticas;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
