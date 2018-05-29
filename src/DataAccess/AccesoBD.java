
package DataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Clase que maneja el acceso a la base de datos. Se debe hacer una instancia de
 * la clase para poder utilizar sus servicios
 *
 * @author ROLANDO
 * @version 3.0
 */
public class AccesoBD {

    private Connection conn = null;
    private Statement st;

    /**
     * Constructor Vacio.
     *
     * @param driver
     * @param conexion
     * @param usuario
     * @param clave
     * @throws SQLException
     * @throws Exception
     */
    public AccesoBD() {

    }

    public AccesoBD(String driver, String conexion, String usuario, String clave) throws SQLException, Exception {
        Class.forName(driver);
        this.conn = DriverManager.getConnection(conexion, usuario, clave);
        st = conn.createStatement();
    }

    /**
     * Ejecuta estatuto DML
     *
     * @param query
     * @throws SQLException
     * @throws Exception
     */
    public void ejecutarSQL(String query) throws SQLException, Exception {
        st.execute(query);

    }

    /**
     * Ejecuta comando SELECT y retorna un ResultSet que el resultado de la
     * ejecucion de dicha sentencia.
     *
     * @param query
     * @return
     * @throws SQLException
     * @throws Exception
     */
    public ResultSet ejecutarSQL(String query, boolean retorno) throws SQLException, Exception {
        ResultSet rs;
        rs = st.executeQuery(query);
        return rs;

    }

    /**
     * Permite controlar el inicio una transacción desde afuera. A partir de
     * este momento todas las sentencias esperarán la orden para ser aceptadas
     * en la base de datos
     *
     */
    public void iniciarTransaccion()
            throws java.sql.SQLException {
        conn.setAutoCommit(false);
    }

    /**
     * Permite controlar el término una transacción desde afuera. A partir de
     * este momento todas las sentencias se ejecturán de forma individual en la
     * base de datos
     *
     */
    public void terminarTransaccion()
            throws java.sql.SQLException {
        conn.setAutoCommit(true);
    }

    /**
     * Indica que la transacción ha sido aceptada
     *
     */
    public void aceptarTransaccion()
            throws java.sql.SQLException {
        conn.commit();
    }

    /**
     * Indica que la transacción debe ser deshecha porque no se realizó de forma
     * exitosa
     *
     */
    public void deshacerTransaccion()
            throws java.sql.SQLException {
        conn.rollback();
    }

    /**
     * Cierra conexion
     * 
     * @throws SQLException 
     */
    public void cerrarConexion() throws SQLException {
        conn.close();
    }
    
    /**
     * Método sobreescrito de la clase Object que es invocado por el Garbage
     * Collector cuando es invocado libera la conexión abierta durante la
     * creación del objeto
     *
     */
    protected void finalize() {
        try {
            conn.close();
        } catch (Exception e) {
            /*este método es llamado por el
			 *garbage collector, por lo tanto
			 *se atrapa la excepción pero no se
			 *reporta*/
        }
    }

}
