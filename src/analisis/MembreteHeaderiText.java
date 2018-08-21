/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisis;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;
/**
 *
 * @author Jose-PC
 */
public class MembreteHeaderiText extends  PdfPageEventHelper {
 
 public void onStartPage(PdfWriter writer, Document document,Paragraph izquierdo,Paragraph derecho,int bajar) {
  ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_LEFT, new Phrase(izquierdo), 50,830-bajar,0);
   ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_RIGHT, new Phrase(derecho), 500,830-bajar,0);
 }
}