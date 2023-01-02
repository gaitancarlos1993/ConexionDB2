/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package conexiondb2;
import java.sql.*;

/**
 *
 * @author diego.molina
 */
public class ConexionDB2 {

    public ConexionDB2() {
        
    }

    public Connection getConexion(){
        Connection conexion =  null;
        String url = "";
        try{
            //instanciar driver base de datos
            Class.forName("com.ibm.as400.access.AS400JDBCDriver");
            //realizar conexion con DB
            url = "jdbc:as400://PUB400.com;naming=sql;errors=full";
            conexion = DriverManager.getConnection(url, "SOPRA07", "CArl59057");
            
            //Crear Statement
            Statement stmt = conexion.createStatement();
            ResultSet resSet = stmt.executeQuery("SELECT * FROM ANUNEZM12.CURSO");
            System.out.println("Conexion con base de datos: " + url + " ---> Ok ");
            while(resSet.next()){
                System.out.println("Nombre: " + resSet.getString("NOMBRE") + 
                                   " Cedula: " + resSet.getString("CEDULA") +
                                   " Hora: " + resSet.getString("HORA"));
            }
        }catch(Exception e){
            System.out.println("Error en los datos de conexion");
        }
        return conexion;
    }
    public static void main(String[] args) {
        ConexionDB2 conexionDB2 =  new ConexionDB2();
        if(conexionDB2.getConexion() != null){
            System.out.println("Conexion exitosa");
        }else{
            System.out.println("Conexion fallida");
        }
    }
    
}
