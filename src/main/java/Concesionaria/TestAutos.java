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
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;

public class TestAutos {

    public TestAutos() {
    }

    public static void main(String[] args) throws Exception {

        // Obtiene la conexion
        Connection conn = AdministradorDeConexiones.getConnection();

        // Caso #1 -- Obtener autos, e informarlos /////////////////////////////////////
        ArrayList autos = Auto.obtenerTodos(conn);
        Iterator it = autos.iterator();
        while (it.hasNext()) {
            Auto a = (Auto) it.next();
            System.out.println(a);
        }

        // Caso #2 -- Obtiene un auto, y lo informa /////////////////////////////////////
        /*
        Auto a = Auto.obtenerSegunId(conn, 1);
        System.out.println(a);
         */
        
        // Caso #3 -- Inserta un auto /////////////////////////////////////
        /*
        Auto a = new Auto();
        a.setMarca("Citroen");
        a.setModelo("2007");
        a.setColor("Rojo");
        a.setPrecio(18000.0);
        a.setAltura(150);
        a.setAncho(180);
        a.setLargo(345);
        a.setEquipamiento("aqui va el equipamiento");
        a.insertar(conn);
         */
       
        // Caso #4 -- Obtiene un auto, y lo modifica /////////////////////////////////////
        /*
        Auto a = Auto.obtenerSegunId(conn, 3);
        if(a != null)
        {
            a.setPrecio(15000.0);  // Modifica el precio
            a.setColor("Negro");  // Modifica el color
            a.actualizar(conn);
        }
         */
        // Caso #5 -- Obtiene un auto, y lo elimina /////////////////////////////////////
        /*
        Auto a = Auto.obtenerSegunId(conn, 2);
        if(a != null)
        {
            a.eliminar(conn);
        }
         */
        System.out.println("-------------------------------------------");
        String ubicacion = "src/main/resources/marcas.txt";

        try {
            // Obtiene las marcas como un vector
            ArrayList <String> marcas = LectorDeArchivos.obtenerContenidoDeArchivoComoVector(ubicacion);
            for (String elemento : marcas)
            System.out.println(elemento + "-");
            } catch (Exception e) {
            System.out.println("no abrio");}
         
    }

}
