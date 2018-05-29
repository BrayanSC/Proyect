package DataAccess;

import java.io.File;
import java.io.FileInputStream;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Clase que inicializa la conexión con los valores correctos y
 * permite manejar una única conexión para todo el proyecto.
 *
 * @version 1.0
 * @author Brayan 
 */
public class Conector {

    //atributo de la clase	
    private static AccesoBD conectorBD = null;

    /**
     * Método estático que devuelve el objeto AccesoBD para que sea utilizado
     * por las clases
     *
     * @return objeto del tipo AccesoBD del paquete CapaAccesoDatos
     */
    public static AccesoBD getConector() throws SQLException, Exception {
        String driver, connection, user, password;
        FileInputStream fis = null;
        File persisFile = null;

        try {
            persisFile = new File("conexion.txt");
            fis = new FileInputStream(persisFile);
            Properties propConfig = new Properties();
            propConfig.load(fis);

            //Get the properties
            driver = propConfig.getProperty("driver");
            connection = propConfig.getProperty("connection");
            user = propConfig.getProperty("user");
            password = propConfig.getProperty("password");

        } catch (Exception e) {
            e.printStackTrace();
            driver="";
            connection="";
            user="";
            password="";
        }

        if (conectorBD == null) {
            conectorBD = new AccesoBD(driver, connection, user, password);
        }
        return conectorBD;
    }

}
