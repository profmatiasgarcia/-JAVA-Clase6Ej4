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
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Auto extends Vehiculo {

    // Atributos
    private int id;
    private String marca;
    private String modelo;
    private String color;
    private double precio;
    private String equipamiento;
    
    public Auto() {
    }

    public Auto(String marca, String modelo, String color, double precio, int largo, int ancho, int altura, String equipamiento) {
        super(ancho, largo, altura);
        setMarca(marca);
        setModelo(modelo);
        setColor(color);
        setPrecio(precio);
        setEquipamiento(equipamiento);
    }

    public static ArrayList obtenerTodos(Connection conn) throws Exception {
        // Arma la consulta y la ejecuta
        String laConsulta = "SELECT * FROM autos";
        Statement stmtConsulta = conn.createStatement();
        ResultSet rs = stmtConsulta.executeQuery(laConsulta);

        // Informa la insercion a realizar
        System.out.println(">>SQL: " + laConsulta);

        // Construye la coleccion de autos
        ArrayList autos = new ArrayList();

        // Muestra los datos
        while (rs.next()) {
            // Arma el objeto auto con los datos de la consulta
            Auto a = new Auto();
            a.setId(rs.getInt("au_id"));
            a.setMarca(rs.getString("au_marca"));
            a.setModelo(rs.getString("au_modelo"));
            a.setPrecio(rs.getDouble("au_precio"));
            a.setColor(rs.getString("au_color"));
            a.setLargo(rs.getInt("au_largo"));
            a.setAncho(rs.getInt("au_ancho"));
            a.setAltura(rs.getInt("au_altura"));
            a.setEquipamiento(rs.getString("au_equipamiento"));

            // Agrega el auto a la coleccion
            autos.add(a);
        }

        // Cierra el Statement
        stmtConsulta.close();

        // Retorna la coleccion
        return autos;
    }

    public void insertar(Connection conn) throws Exception {
        // Arma la sentencia de inserci�n
        String laInsercion = "INSERT INTO autos (au_marca, au_modelo, au_precio, au_color, au_largo, au_ancho, au_altura, au_equipamiento) "
                + "VALUES ('" + getMarca() + "', '" + getModelo() + "', " + getPrecio() + ", '"
                + getColor() + "', " + getLargo() + ", " + getAncho() + ", " + getAltura() + ", '"
                + getEquipamiento() + "')";

        // Informa la insercion a realizar
        System.out.println(">>SQL: " + laInsercion);

        // Ejecuta la insercion
        Statement stmtInsercion = conn.createStatement();
        stmtInsercion.execute(laInsercion);

        // Cierra el Statement
        stmtInsercion.close();
    }

    public void actualizar(Connection conn) throws Exception {
        // Arma la sentencia de actualizacion
        String laActualizacion = "UPDATE autos "
                + "SET au_marca = '" + getMarca() + "', au_modelo = '" + getModelo() + "', "
                + "au_precio = " + getPrecio() + ", " + "au_color = '" + getColor() + "', "
                + "au_largo = " + getLargo() + ", " + "au_ancho = " + getAncho() + ", "
                + "au_altura = " + getAltura() + ", "
                + "au_equipamiento = '" + getEquipamiento() + "' "
                + "WHERE au_id = " + getId();

        // Informa la actualizacion a realizar
        System.out.println(">>SQL: " + laActualizacion);

        // Ejecuta la actualizacion
        Statement stmtActualizacion = conn.createStatement();
        stmtActualizacion.execute(laActualizacion);

        // Cierra el Statement
        stmtActualizacion.close();
    }

    public void eliminar(Connection conn) throws Exception {
        // Arma la sentencia de eliminacion
        String laEliminacion = "DELETE FROM autos WHERE au_id = " + getId();

        // Informa la eliminacion a realizar
        System.out.println(">>SQL: " + laEliminacion);

        // Ejecuta la eliminacion
        Statement stmtEliminacion = conn.createStatement();
        stmtEliminacion.execute(laEliminacion);

        // Cierra el Statement
        stmtEliminacion.close();
    }

    public String toString() {
        return marca + " " + color + " " + modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getEquipamiento() {
        return equipamiento;
    }

    public void setEquipamiento(String equipamiento) {
        this.equipamiento = equipamiento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
