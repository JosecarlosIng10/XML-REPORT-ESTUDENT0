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
public class ListaPonderacion {
    
    public Ponderacion raiz;
    public int size;
    
    public void ListaPonderacion()
    {
        raiz=null;
        size=0;
    }
    
    
    public boolean esVacia(){
        return raiz == null;
    }
    
    public int getTamanio(){
        return size;
    }
    
    public int getActividad(String nombre)
    {
        int val=0;
        Ponderacion aux = raiz;
        
        while (aux != null)
        {
            if (aux.actividad.equals(nombre)){
                val= aux.valor; 
            }
            aux= aux.siguiente;
        }
        
      return val;
    }
    public void GuardarPonderacion(Ponderacion nuevo)
    {
            
        if (esVacia()){
            raiz= nuevo;
        
        }
        else
        {
            Ponderacion aux = raiz;
            
            while (aux.siguiente != null){
                aux = aux.siguiente;
            
            }
                aux.siguiente=nuevo;
                
        }
        
        size++;
    
    
    }
    
      public void imprimirponderacion ()
    {
        Ponderacion aux = raiz;
        
        while (aux != null)
        {
            System.out.println( aux.actividad + "--" + aux.valor  + "\n");
            
            aux= aux.siguiente;
        
        
        }
    
    
    }
    
}
