/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionexcel;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/** 
 *
 * @author mac
 */
public class GestionExcel {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        try {
            // TODO code application logic here
            FileInputStream f = new FileInputStream("doc.xlsx");
            
            //libro
            XSSFWorkbook libro = new XSSFWorkbook(f);
            
            //tomar hoja
            XSSFSheet hoja = libro.getSheetAt(0);
            
            //tomar filas
            Iterator<Row> filas = hoja.iterator();
            Iterator<Cell> celdas;
            
            Row fila;
            Cell celda; 
            
            while(filas.hasNext()){
                fila = filas.next();
                celdas  = fila.cellIterator();
                
                while(celdas.hasNext()){
                    celda = celdas.next();
                    
                    switch(celda.getCellType()){
                        case Cell.CELL_TYPE_NUMERIC:
                            System.out.println(celda.getNumericCellValue());
                            break;
                        case Cell.CELL_TYPE_STRING:
                            System.out.println(celda.getStringCellValue());
                            break;
                    }
                }
            }
            
            // se debe cerrar el libro
            libro.close();
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
}
