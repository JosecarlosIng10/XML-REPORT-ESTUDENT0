/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisis;

import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;

/**
 *
 * @author Jose-PC
 */
public class ListaOrdenada {
      public Estudiante raiz;
   
    public int size;
    public String izqprimero="";
    public String izqsegundo="";
    public String izqtercero="";
    
    public String derprimero="";
    public String dersegundo="";
    public String dertercero="";
    
    public int rojo=0;
    public int verde=0;
    public int azul=0;
    
    public String colort="";
    public String colorv="";
    
    
    public void setColort(String nombre)
    {
        colort=nombre;
    }
    public void setColorv(String nombre)
    {
        colorv=nombre;
    }
   
    public void color(String color)
    {
       if (color.equals("blanco"))
       {
           rojo=255;
           verde=255;
           azul=255;
       }
       else if (color.equals("azul"))
       {
           rojo=0;
           verde=0;
           azul=255;
       }
       else if (color.equals("rojo"))
       {
           rojo=255;
           verde=0;
           azul=0;
       }
       else if (color.equals("verde"))
       {
           rojo=0;
           verde=255;
           azul=0;
       }
       else if (color.equals("anaranjado"))
       {
           rojo=255;
           verde=200;
           azul=0;
       }
       else if (color.equals("rosado"))
       {
           rojo=255;
           verde=175;
           azul=175;
       }
       else if (color.equals("nedro"))
       {
           rojo=0;
           verde=0;
           azul=0;
       }
       
    }
   
    
    public void encabezado(String i1,String i2,String i3,String d1,String d2,String d3)
    
    {
        izqprimero=i1;
        izqsegundo=i2;
        izqtercero=i3;
        
        derprimero=d1;
        dersegundo=d2;
        dertercero=d3;
    }
    public void ListaOrdenada()
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
    
    public void GuardarEstudiante(Estudiante nuevo)
    {
            
      
 float x;
        x=nuevo.notafinal ;
        if (raiz==null) {
            raiz=nuevo;
        } else {
            if (x >  raiz.notafinal) {
                nuevo.siguiente=raiz;
                raiz=nuevo;
            } else {
                Estudiante recorre=raiz;
                Estudiante atras=raiz;
                while ((x <= recorre.notafinal) && (recorre.siguiente!=null)) {
                    atras=recorre;
                    recorre=recorre.siguiente;
                }
                if (x <= recorre.notafinal) {
                    recorre.siguiente=nuevo;
                } else {
                    nuevo.siguiente=recorre;
                    atras.siguiente=nuevo;
                }
            }
        
        size++;
    
    
    }
    }
    
    
    public void imprimir ()
    {
        Estudiante aux = raiz;
        
        while (aux != null)
        {
            System.out.println( aux.carnet + "--" + aux.nombre + "--" + aux.apellidos + "--"+aux.tareas +"--"+aux.ht+"--"+aux.ec+"--"+aux.practicas+"--"+aux.proyectos+"--"+aux.ef+"--"+aux.notafinal+"\n");
            
            aux= aux.siguiente;
        
        
        }
    
    
    }
    
    public void reportemejores()
    {
     Document document = new Document();
         
        try{
            
           
           PdfWriter writer= PdfWriter.getInstance(document, new FileOutputStream("Reporte4.pdf"));
            
            Font fuente= new Font();
            fuente.setSize(10);
            document.open();
            
              MembreteHeaderiText header = new MembreteHeaderiText();
             
             Paragraph iz1 = new Paragraph(izqprimero);
             iz1.getFont().setSize(7);
             Paragraph de1 = new Paragraph(derprimero);
             de1.getFont().setSize(7);
             header.onStartPage(writer, document, iz1, de1,0);
             Paragraph iz2 = new Paragraph(izqsegundo);
             iz2.getFont().setSize(7);
             Paragraph de2 = new Paragraph(dersegundo);
             de2.getFont().setSize(7);
             header.onStartPage(writer, document, iz2, de2,7);
             Paragraph iz3 = new Paragraph(izqtercero);
             iz3.getFont().setSize(7);
             Paragraph de3 = new Paragraph(dertercero);
             de3.getFont().setSize(7);
             header.onStartPage(writer, document, iz3, de3,14);
            
             writer.setPageEvent(header);
            // Este codigo genera una tabla de 3 columnas
            PdfPTable table = new PdfPTable(10);  
         
            table.setWidthPercentage(110f);
            color(colort);
            Paragraph columna11 = new Paragraph("Carnet");
             columna11.getFont().setSize(10);
             columna11.getFont().isBold();
             columna11.getFont().setColor(rojo, verde, azul);
             table.addCell(columna11);
            
             Paragraph columna112 = new Paragraph("Nombre");
             columna112.getFont().setSize(10);
             columna112.getFont().isBold();
             columna112.getFont().setColor(rojo, verde, azul);
             table.addCell(columna112);
             
             Paragraph columna113 = new Paragraph("Apellidos");
             columna113.getFont().setSize(10);
             columna113.getFont().isBold();
             columna113.getFont().setColor(rojo, verde, azul);
             table.addCell(columna113);
             
             Paragraph columna114 = new Paragraph("Tareas");
             columna114.getFont().setSize(10);
             columna114.getFont().isBold();
             columna114.getFont().setColor(rojo, verde, azul);
             table.addCell(columna114);
             
             Paragraph columna115 = new Paragraph("HT");
             columna115.getFont().setSize(10);
             columna115.getFont().isBold();
             columna115.getFont().setColor(rojo, verde, azul);
             table.addCell(columna115);
             
             Paragraph columna116 = new Paragraph("EC");
             columna116.getFont().setSize(10);
             columna116.getFont().isBold();
             columna116.getFont().setColor(rojo, verde, azul);
             table.addCell(columna116);
             
             Paragraph columna117 = new Paragraph("Practica");
             columna117.getFont().setSize(10);
             columna117.getFont().isBold();
             columna117.getFont().setColor(rojo, verde, azul);
             table.addCell(columna117);
             
             Paragraph columna118 = new Paragraph("Proyecto");
             columna118.getFont().setSize(10);
             columna118.getFont().isBold();
             columna118.getFont().setColor(rojo, verde, azul);
             table.addCell(columna118);
             
             Paragraph columna119 = new Paragraph("Final");
             columna119.getFont().setSize(10);
             columna119.getFont().isBold();
             columna119.getFont().setColor(rojo, verde, azul);
             table.addCell(columna119);
             
             Paragraph columna120 = new Paragraph("Nota");
             columna120.getFont().setSize(10);
             columna120.getFont().isBold();
             columna120.getFont().setColor(rojo, verde, azul);
             table.addCell(columna120);
            
            
            int a=0;
            Estudiante aux4 = raiz;
            while ((a< 10) && (aux4!=null))
            {
               color(colorv);
                    Paragraph columna1 = new Paragraph(aux4.carnet+"");
                    columna1.getFont().setSize(7);
                    columna1.getFont().setColor(rojo, verde, azul);
                    table.addCell(columna1);
                    
                     Paragraph columna2 = new Paragraph(aux4.nombre);
                    columna2.getFont().setSize(7);
                    columna2.getFont().setColor(rojo, verde, azul);
                    table.addCell(columna2);
                    
                     Paragraph columna3 = new Paragraph(aux4.apellidos);
                    columna3.getFont().setSize(7);
                    columna3.getFont().setColor(rojo, verde, azul);
                    table.addCell(columna3);
                    
                     Paragraph columna4 = new Paragraph(aux4.tareas+"");
                     columna4.getFont().setColor(rojo, verde, azul);
                    columna4.getFont().setSize(7);
                    table.addCell(columna4);
                    
                     Paragraph columna5 = new Paragraph(aux4.ht+"");
                    columna5.getFont().setSize(7);
                    columna5.getFont().setColor(rojo, verde, azul);
                    table.addCell(columna5);
                    
                     Paragraph columna6 = new Paragraph(aux4.ec+"");
                    columna6.getFont().setSize(7);
                    columna6.getFont().setColor(rojo, verde, azul);
                    table.addCell(columna6);
                    
                     Paragraph columna7 = new Paragraph(aux4.practicas+"");
                    columna7.getFont().setSize(7);
                    columna7.getFont().setColor(rojo, verde, azul);
                    table.addCell(columna7);
                    
                     Paragraph columna8 = new Paragraph(aux4.proyectos+"");
                    columna8.getFont().setSize(7);
                    columna8.getFont().setColor(rojo, verde, azul);
                    table.addCell(columna8);
                    
                     Paragraph columna9 = new Paragraph(aux4.ef+"");
                    columna9.getFont().setSize(7);
                    columna9.getFont().setColor(rojo, verde, azul);
                    table.addCell(columna9);
                    
                     Paragraph columna10 = new Paragraph(aux4.notafinal+"");
                    columna10.getFont().setSize(7);
                    columna10.getFont().setColor(rojo, verde, azul);
                    table.addCell(columna10);
                   
               
                    
                   
                
                
                aux4 = aux4.siguiente;
                a++;
            
            }
            
            document.add(table);
        
             
            document.close();
    }
        catch(Exception e){
            
            System.err.println("Ocurrio un error al crear el archivo " + e);
            System.exit(-1);
        }}
    
    }

