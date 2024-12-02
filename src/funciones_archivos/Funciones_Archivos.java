/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package funciones_archivos;

import funciones_TXT.FileTXT;

import java.util.List;

/**
 *
 * @author luisd
 */
public class Funciones_Archivos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FileTXT file = new FileTXT("miArchivo.txt");
        List<String[]> lineas = file.ReadFileTXT();
    }
    
}
