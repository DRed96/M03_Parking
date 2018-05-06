import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseDades {
    private final String DB_nom;                            // Nom base de dades.
    private final String DB_usuari;                         // Usuari per connectar-se a la base de dades.
    private final String DB_contrasenya;                    // Contrasenya per connectar-se a la base de dades.
    //private final String DB_url;                          // URL base de dades.
    //final String DB_taula       = "usuaris";              // Taula sobre la que realitzarem les sentències.
    public Connection DB_connexio;
    
    
    public BaseDades(String nom, String usu, String contra){
        DB_nom = nom;
        DB_usuari = usu;
        DB_contrasenya = contra;
        /*  Per aquesta applicació no farem servir la URL així que
            la comentem i no la demanem per el constructor*/
        //DB_url = ""; 
    }

    //---------------------------------------------------------------------------
    // FUNCIONS Consultes ---------------------------------------------------
    //---------------------------------------------------------------------------
    public PreparedStatement preparaEnunciat(String statement) throws SQLException{
        return DB_connexio.prepareStatement(statement);
    }
    /*
     * Permet fer consultes que retornin files a la BBDD
     */
    public ResultSet consultaSQL(String consulta) throws SQLException{
        Statement st = DB_connexio.createStatement();
        return st.executeQuery(consulta);
    }
    /*
     * Permet modificar una BBDD
     */
    public int updateSQL(String expressio) throws SQLException{
        Statement st = DB_connexio.createStatement();
        return st.executeUpdate(expressio);
    }

    //---------------------------------------------------------------------------
    // FUNCIONS Base de Dades ---------------------------------------------------
    //---------------------------------------------------------------------------
    public void DBConnecta_ModeModern () throws SQLException
    {
        MysqlDataSource ds = new MysqlDataSource();
        
        ds.setUser (DB_usuari);
        ds.setPassword (DB_contrasenya);
        //d.setUrl (DB_url);
        ds.setDatabaseName (DB_nom);
        DB_connexio = (Connection)ds.getConnection();
    }
    
    // Tancament de la connexió.
    public void DBDesconnecta() throws SQLException
    {
        if (DB_connexio!=null)   // Si existeix la connexió...
            DB_connexio.close (); // ...la tanquem. 
    }
}