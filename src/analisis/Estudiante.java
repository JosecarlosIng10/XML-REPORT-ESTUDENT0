/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisis;

/**
 *
 * @author Jose-PC
 */
public class Estudiante {
    
    public int carnet;
    public String nombre;
    public String apellidos;
    public String notas;
    public float tareas;
    public float ht;
    public float ec;
    public float practicas;
    public float proyectos;
    public float ef;
    public float notafinal;
    public Estudiante siguiente;
    public Estudiante anterior;
    
    public void Estudiante (int carnet, String nombre, String apellidos, String notas,float tareas,float ht,float ec,float practicas,float proyectos,float ef,float notafinal
    ){
            this.carnet = carnet;
            this.nombre = nombre;
            this.apellidos = apellidos;
            this.notas = notas;
            this.tareas=tareas;
            this.ht=ht;
            this.ec=ec;
            this.practicas=practicas;
            this.proyectos=proyectos;
            this.ef=ef;
            this.notafinal=notafinal;

       }
    
}
