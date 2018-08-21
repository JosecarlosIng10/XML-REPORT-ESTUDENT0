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
public class Ponderacion {
    
    public String actividad;
    public int valor;
    public Ponderacion siguiente;
    
    public void Ponderacion(String actividad, int valor)
    {
        this.actividad = actividad;
        this.valor=valor;
        
    
    }
    
}
