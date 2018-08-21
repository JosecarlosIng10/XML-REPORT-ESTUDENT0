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


import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfDocument;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.*; 
import java.io.FileOutputStream;
import javafx.scene.transform.Rotate;

 
public class ListaEstudiantes {
 
    public Estudiante raiz;
   
    public int size;
  
    ListaPonderacion listaponderacion = new ListaPonderacion();
    
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
    
    public void ListaEstudiantes ()
    {
        raiz=null;
       
        size=0;
    }
    public void setlistaponderacion(ListaPonderacion lista)
    {
        listaponderacion=lista;
    }
    public boolean esVacia(){
        return raiz == null;
    }
    
    public int getTamanio(){
        return size;
    }
    
    public void GuardarEstudiante(Estudiante nuevo)
    {
            
        if (esVacia()){
            raiz= nuevo;
          
        
        }
        else
        {
            Estudiante aux = raiz;
            
            
            
            while (aux.siguiente != null){
                aux = aux.siguiente;
            
            }
                aux.siguiente=nuevo;
                
        }
        
        size++;
    
    
    }
    
    public void calcularnotas()
    {
        Estudiante aux = raiz;
         Document document = new Document();
         boolean bandera=true;
         
          try{
            
           
           PdfWriter writer= PdfWriter.getInstance(document, new FileOutputStream("Reporte3.pdf"));
            
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
            
        while (aux!= null)
        {
            String actividades[] =  aux.notas.split(",");
            int tareas=0;
            int totaltareas=0;
            int hojas=0;
            int totalhojas=0;
            int examenes=0;
            int totalexamenes=0;
            int practicas=0;
            int totalpracticas=0;
            int proyecto=0;
            int totalproyecto=0;
            int examenfinal=0;
            int totalexamenfinal=0;
            int notafinal=0;
            String actividadesrealizadas="";
            String notasdeactividades="";
            int n1=1;
            int n2=1;
            int n3=1;
            int n4=1;
            int n5=1;
            int n6=1;
            
            for (int i=0; i<actividades.length;i++)
            {
                String dato[] = actividades[i].split("_");
                
                if (dato[0].equals("tarea"))
                {
                    totaltareas++;
                    String not[] = actividades[i].split("=");
                    actividadesrealizadas+="tarea"+n1+"#";
                    n1++;
                    tareas+= Integer.parseInt(not[1]);
                    notasdeactividades+=not[1]+"#";
                }
                else if  (dato[0].equals("ht"))
                {
                    totalhojas++;
                    String not[] = actividades[i].split("=");
                    actividadesrealizadas+="ht"+n2+"#";
                    n2++;
                    hojas+= Integer.parseInt(not[1]);
                    notasdeactividades+=not[1]+"#";
                }
                else if  (dato[0].equals("ec"))
                {
                    totalexamenes++;
                    String not[] = actividades[i].split("=");
                    actividadesrealizadas+="ec"+n3+"#";
                    n3++;
                    examenes+= Integer.parseInt(not[1]);
                    notasdeactividades+=not[1]+"#";
                }
                else if  (dato[0].equals("pra"))
                {
                    totalpracticas++;
                    String not[] = actividades[i].split("=");
                    actividadesrealizadas+="pra"+n4+"#";
                    n4++;
                    practicas+= Integer.parseInt(not[1]);
                    notasdeactividades+=not[1]+"#";
                }
                else if  (dato[0].equals("pro"))
                {
                    totalproyecto++;
                    String not[] = actividades[i].split("=");
                    actividadesrealizadas+="pro"+n5+"#";
                    n5++;
                    proyecto+= Integer.parseInt(not[1]);
                    notasdeactividades+=not[1]+"#";
                }
                if  ((actividades[i].split("=")[0].equals("ef")) || (actividades[i].split("=")[0].equals("final")))
                {
                    totalexamenfinal++;
                    String not[] = actividades[i].split("=");
                    actividadesrealizadas+="ef"+n6+"#";
                    n6++;
                    examenfinal+= Integer.parseInt(not[1]);
                    notasdeactividades+=not[1]+"#";
                }
            }
            
            
            int valortareas=listaponderacion.getActividad("tareas");
            int valorht=listaponderacion.getActividad("hojas_de_trabajo");
            int valorec=listaponderacion.getActividad("examenes_cortos");
            int valorpracticas=listaponderacion.getActividad("practicas");
            int valorproyectos=listaponderacion.getActividad("proyectos");
            int valoref=listaponderacion.getActividad("examen_final");
            
           
            
            aux.tareas= (float)valortareas/(totaltareas*100)* (tareas);
            aux.ht= (float)valorht/(totalhojas*100)* (hojas);
            aux.ec= (float)valorec/(totalexamenes*100)* (examenes);
            aux.practicas= (float)valorpracticas/(totalpracticas*100)* (practicas);
            aux.proyectos= (float)valorproyectos/(totalproyecto*100)* (proyecto);
            aux.ef= (float)valoref/(totalexamenfinal*100)* (examenfinal);
            
            aux.notafinal= aux.tareas+aux.ht+aux.ec+aux.practicas+aux.proyectos+aux.ef;
                
             String titulos[]= actividadesrealizadas.split("#");
            int cont = 2 + titulos.length;
            PdfPTable table = new PdfPTable(cont);  
            table.setWidthPercentage(110f);
            
            if (bandera == true){
            
                
            color(colort);
             Paragraph columna11 = new Paragraph("Carnet");
             columna11.getFont().setSize(10);
             columna11.getFont().isBold();
             columna11.getFont().setColor(rojo, verde, azul);
             table.addCell(columna11);    
            
            
           
            
            for(int i =0; i<titulos.length;i++)
            {
             Paragraph columna12 = new Paragraph(titulos[i]);
             columna12.getFont().setSize(10);
             columna12.getFont().isBold();
             columna12.getFont().setColor(rojo, verde, azul);
             table.addCell(columna12);  
                
            }
            
            Paragraph columna13 = new Paragraph("Nota Final");
            columna13.getFont().setSize(10);
            columna13.getFont().isBold();
            columna13.getFont().setColor(rojo, verde, azul);
            table.addCell(columna13);  
          
            bandera=false;
            }
            
             color(colorv);
             Paragraph columna1 = new Paragraph(aux.carnet+"");
             columna1.getFont().setSize(7);
             columna1.getFont().setColor(rojo, verde, azul);
             table.addCell(columna1);
            
            String titnotas[] = notasdeactividades.split("#");
            for(int i =0; i<titnotas.length;i++)
            {
             Paragraph columna2 = new Paragraph(titnotas[i]);
             columna2.getFont().setSize(7);
             columna2.getFont().setColor(rojo, verde, azul);
             table.addCell(columna2);
              
            }
            Paragraph columna3 = new Paragraph(aux.notafinal+"");
            columna3.getFont().setSize(7);
            columna3.getFont().setColor(rojo, verde, azul);
            table.addCell(columna3);
            
            aux = aux.siguiente;
             document.add(table);
                    
        }
         document.close();
        
          }
          catch (Exception e)
          {
                System.err.println("Ocurrio un error al crear el archivo " + e);
            System.exit(-1);
          }
    
    }
    
    public void imprimirestudiantes ()
    {
        Estudiante aux = raiz;
        
        while (aux != null)
        {
            System.out.println( aux.carnet + "--" + aux.nombre + "--" + aux.apellidos + "--"+aux.tareas +"--"+aux.ht+"--"+aux.ec+"--"+aux.practicas+"--"+aux.proyectos+"--"+aux.ef+"--"+aux.notafinal+"\n");
            
            aux= aux.siguiente;
        
        
        }
    
    
    }
    
    public void reporteaprobados()
    {
    Document document = new Document();
         
        try{
            
           
            PdfWriter writer =PdfWriter.getInstance(document, new FileOutputStream("Reporte1.pdf"));
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
             
            Font fuente= new Font();
            fuente.setSize(10);
            
             
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
          
           
            
            Estudiante aux = raiz;
            
            while (aux!= null)
            {
                if (aux.notafinal >=61)
                {
                    color(colorv);
                    Paragraph columna1 = new Paragraph(aux.carnet+"");
                    columna1.getFont().setSize(7);
                    columna1.getFont().setColor(rojo, verde, azul);
                    table.addCell(columna1);
                    
                     Paragraph columna2 = new Paragraph(aux.nombre);
                    columna2.getFont().setSize(7);
                    columna2.getFont().setColor(rojo, verde, azul);
                    table.addCell(columna2);
                    
                     Paragraph columna3 = new Paragraph(aux.apellidos);
                    columna3.getFont().setSize(7);
                    columna3.getFont().setColor(rojo, verde, azul);
                    table.addCell(columna3);
                    
                     Paragraph columna4 = new Paragraph(aux.tareas+"");
                     columna4.getFont().setColor(rojo, verde, azul);
                    columna4.getFont().setSize(7);
                    table.addCell(columna4);
                    
                     Paragraph columna5 = new Paragraph(aux.ht+"");
                    columna5.getFont().setSize(7);
                    columna5.getFont().setColor(rojo, verde, azul);
                    table.addCell(columna5);
                    
                     Paragraph columna6 = new Paragraph(aux.ec+"");
                    columna6.getFont().setSize(7);
                    columna6.getFont().setColor(rojo, verde, azul);
                    table.addCell(columna6);
                    
                     Paragraph columna7 = new Paragraph(aux.practicas+"");
                    columna7.getFont().setSize(7);
                    columna7.getFont().setColor(rojo, verde, azul);
                    table.addCell(columna7);
                    
                     Paragraph columna8 = new Paragraph(aux.proyectos+"");
                    columna8.getFont().setSize(7);
                    columna8.getFont().setColor(rojo, verde, azul);
                    table.addCell(columna8);
                    
                     Paragraph columna9 = new Paragraph(aux.ef+"");
                    columna9.getFont().setSize(7);
                    columna9.getFont().setColor(rojo, verde, azul);
                    table.addCell(columna9);
                    
                     Paragraph columna10 = new Paragraph(aux.notafinal+"");
                    columna10.getFont().setSize(7);
                    columna10.getFont().setColor(rojo, verde, azul);
                    table.addCell(columna10);
                   
               
                    
                   
                }
                
                aux = aux.siguiente;
            
            }
            
            document.add(table);
            
            //document.add(table);
        
             
            document.close();
    }
        catch(Exception e){
            
            System.err.println("Ocurrio un error al crear el archivo " + e);
            System.exit(-1);
        }}
            
    
     public void reportereprobados()
    {
    Document document = new Document();
         
        try{
            
           
           PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("Reporte2.pdf"));
            
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
          
            
            Estudiante aux = raiz;
            
            while (aux!= null)
            {
                if (aux.notafinal <61)
                {
                    color(colorv);
                    Paragraph columna1 = new Paragraph(aux.carnet+"");
                    columna1.getFont().setSize(7);
                    columna1.getFont().setColor(rojo, verde, azul);
                    table.addCell(columna1);
                    
                     Paragraph columna2 = new Paragraph(aux.nombre);
                    columna2.getFont().setSize(7);
                    columna2.getFont().setColor(rojo, verde, azul);
                    table.addCell(columna2);
                    
                     Paragraph columna3 = new Paragraph(aux.apellidos);
                    columna3.getFont().setSize(7);
                    columna3.getFont().setColor(rojo, verde, azul);
                    table.addCell(columna3);
                    
                     Paragraph columna4 = new Paragraph(aux.tareas+"");
                     columna4.getFont().setColor(rojo, verde, azul);
                    columna4.getFont().setSize(7);
                    table.addCell(columna4);
                    
                     Paragraph columna5 = new Paragraph(aux.ht+"");
                    columna5.getFont().setSize(7);
                    columna5.getFont().setColor(rojo, verde, azul);
                    table.addCell(columna5);
                    
                     Paragraph columna6 = new Paragraph(aux.ec+"");
                    columna6.getFont().setSize(7);
                    columna6.getFont().setColor(rojo, verde, azul);
                    table.addCell(columna6);
                    
                     Paragraph columna7 = new Paragraph(aux.practicas+"");
                    columna7.getFont().setSize(7);
                    columna7.getFont().setColor(rojo, verde, azul);
                    table.addCell(columna7);
                    
                     Paragraph columna8 = new Paragraph(aux.proyectos+"");
                    columna8.getFont().setSize(7);
                    columna8.getFont().setColor(rojo, verde, azul);
                    table.addCell(columna8);
                    
                     Paragraph columna9 = new Paragraph(aux.ef+"");
                    columna9.getFont().setSize(7);
                    columna9.getFont().setColor(rojo, verde, azul);
                    table.addCell(columna9);
                    
                     Paragraph columna10 = new Paragraph(aux.notafinal+"");
                    columna10.getFont().setSize(7);
                    columna10.getFont().setColor(rojo, verde, azul);
                    table.addCell(columna10);
                   
               
                    
                   
                }
                
                aux = aux.siguiente;
            
            }
            
            document.add(table);
        
             
            document.close();
    }
        catch(Exception e){
            
            System.err.println("Ocurrio un error al crear el archivo " + e);
            System.exit(-1);
        }}
     
     
     public void ordenar()
     {
         ListaOrdenada lista = new ListaOrdenada();
         
         lista.setColort(colort);
         lista.setColorv(colorv);
        
         lista.encabezado(izqprimero, izqsegundo, izqtercero, derprimero, dersegundo, dertercero);
         Estudiante aux = raiz;
         
         while (aux!=null)
         {
         Estudiante nuevo = new Estudiante();
         
         nuevo.carnet = aux.carnet;
         nuevo.nombre = aux.nombre;
         nuevo.apellidos = aux.apellidos;
         nuevo.tareas=aux.tareas;
         nuevo.ht=aux.ht;
         nuevo.ec=aux.ec;
         nuevo.practicas = aux.practicas;
         nuevo.proyectos = aux.proyectos;
         nuevo.ef =aux.ef;
         nuevo.notafinal = aux.notafinal;
         nuevo.notas=aux.notas;
         
         lista.GuardarEstudiante(nuevo);
         
         aux = aux.siguiente;
         
         
         }
         
         lista.reportemejores();
     
     }
     
     public void reportemejores()
    {
       ordenar();
        
        
        
    }
    
}
     


