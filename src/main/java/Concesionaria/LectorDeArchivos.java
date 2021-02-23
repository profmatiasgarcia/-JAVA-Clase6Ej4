package Concesionaria;
/**
 * @author Prof Matias Garcia.
 * <p> Copyright (C) 2017 para <a href = "https://www.profmatiasgarcia.com.ar/"> www.profmatiasgarcia.com.ar </a>
 * - con licencia GNU GPL3.
 * <p> Este programa es software libre. Puede redistribuirlo y/o modificarlo bajo los términos de la
 * Licencia Pública General de GNU según es publicada por la Free Software Foundation, 
 * bien con la versión 3 de dicha Licencia o bien (según su elección) con cualquier versión posterior. 
 * Este programa se distribuye con la esperanza de que sea útil, pero SIN NINGUNA GARANTÍA, 
 * incluso sin la garantía MERCANTIL implícita o sin garantizar la CONVENIENCIA PARA UN PROPÓSITO
 * PARTICULAR. Véase la Licencia Pública General de GNU para más detalles.
 * Debería haber recibido una copia de la Licencia Pública General junto con este programa. 
 * Si no ha sido así ingrese a <a href = "http://www.gnu.org/licenses/"> GNU org </a>
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class LectorDeArchivos {

    public LectorDeArchivos() {
    }

    public static ArrayList obtenerContenidoDeArchivoComoVector(String archivoALeer) throws Exception {

        File file = new File(archivoALeer);

        // Obtiene un stream al archivo a leer
        InputStreamReader isr = new InputStreamReader(new FileInputStream(file));

        // Construye un BufferedReader
        BufferedReader readerMejorado = new BufferedReader(isr);

        // Define variables
        boolean eof = false;
        String lineaLeida = "";
        ArrayList items = new ArrayList();

        // Lee el archivo de forma eficiente y guarda la informacion leida
        while (!eof) {
            // Lee una linea entera
            lineaLeida = readerMejorado.readLine();

            // Guarda la linea
            if (lineaLeida != null) {
                items.add(lineaLeida);
            } // Si llega al final del archivo, termina la ejecuci�n
            else {
                eof = true;
            }
        }

        // Cierra el BufferedReader
        readerMejorado.close();

        // Retorna la coleccion
        return items;

    }

}
