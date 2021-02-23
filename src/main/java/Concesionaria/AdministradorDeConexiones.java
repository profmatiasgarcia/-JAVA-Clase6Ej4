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
import java.sql.DriverManager;

public abstract class AdministradorDeConexiones {

    public AdministradorDeConexiones() {
    }

    public static Connection getConnection() throws Exception {

        // Establece el nombre del driver a utilizar
        //String dbDriver = "com.mysql.cj.jdbc.Driver";
        String dbDriver = "org.mariadb.jdbc.Driver";
        // Establece la conexion a utilizar contra la base de datos
        //String dbConnString = "jdbc:mysql://localhost/concesionario";
        String dbConnString = "jdbc:mariadb://localhost/concesionario";
        // Establece el usuario de la base de datos
        String dbUser = "root";

        // Establece la contrase�a de la base de datos
        String dbPassword = "";

        // Establece el driver de conexion
        Class.forName(dbDriver).newInstance();

        // Retorna la conexion
        return DriverManager.getConnection(dbConnString, dbUser, dbPassword);
    }

}
