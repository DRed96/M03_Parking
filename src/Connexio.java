import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Connexio {
    private final String DB_nom;                            // Nom base de dades.
    private final String DB_usuari;                         // Usuari per connectar-se a la base de dades.
    private final String DB_contrasenya;                    // Contrasenya per connectar-se a la base de dades.
    //private final String DB_url;                            // URL base de dades.
    //final String DB_taula       = "usuaris";              // Taula sobre la que realitzarem les sentències.
    public Connection DB_connexio;
    
    private PreparedStatement PS_afegirAssignatura;
     
    
    
    public Connexio(String nom, String usu, String contra){
        DB_nom = nom;
        DB_usuari = usu;
        DB_contrasenya = contra;
        /*  Per aquesta applicació no farem servir la URL així que
            la comentem i no la demanem per el constructor*/
        //DB_url = ""; 
        connectaBBDD();
    }
    
    private boolean connectaBBDD(){
        boolean resultat = DBConnecta_ModeModern();
        if (resultat){
            try {
            // Preparem les consultes a la base de dades.
            // Cada interrogant representa un valor que haurà de ser concretat
            // abans de l'execució.
            PS_afegirAssignatura     = DB_connexio.prepareStatement ("SELECT * FROM estudiant");
//            PS_afegirEstudiants     = conn.DB_connexio.prepareStatement ("INSERT INTO estudiant (nom,dni,adreca) VALUES (?, ?, ?)");
//            PS_afegirProfessor     = conn.DB_connexio.prepareStatement ("INSERT INTO profesor (nom,departament) VALUES (?, ?)");
//            PS_assignarProfessor    = conn.DB_connexio.prepareStatement ("INSERT INTO curs (any,nom_assignatura,nom_professor) VALUES (?, ?, ?)");
//            PS_mostraEstudiants = conn.DB_connexio.prepareStatement ("SELECT * FROM estudiant");
//            PS_mostraAsignaturesProf = conn.DB_connexio.prepareStatement ("SELECT nom_assignatura FROM curs WHERE nom_professor=?");
//            PS_afegirAvaluacio = conn.DB_connexio.prepareStatement("INSERT INTO avaluacio (any,nota,dni_estudiant,nom_assignatura) VALUES (?, ?, ?, ?)");
            }
            catch (SQLException e)
            {
                informa_error_sql (e);
            }
        }
        return resultat;
    }
    //---------------------------------------------------------------------------
    // FUNCIONS Consultes ---------------------------------------------------
    //---------------------------------------------------------------------------
    private void preparaConsultes(){
        
    }
    
    public void consultaVehicle(){
        
    }
    //---------------------------------------------------------------------------
    // FUNCIONS Base de Dades ---------------------------------------------------
    //---------------------------------------------------------------------------
    public boolean DBConnecta_ModeModern ()
    {
        boolean resultat = false;
        MysqlDataSource ds = new MysqlDataSource();
        try
        {
           ds.setUser (DB_usuari);
           ds.setPassword (DB_contrasenya);
           //d.setUrl (DB_url);
           ds.setDatabaseName (DB_nom);
           DB_connexio = (Connection)ds.getConnection();
           resultat = true;
        }
        catch (SQLException e)
        {
           informa_error_sql (e);
        }
        
        return resultat;
    }
    
    
    //---------------------------------------------------------------------------
    // Tancament de la connexió.
    public void DBDesconnecta()
    {
        try{
           if (DB_connexio!=null)   // Si existeix la connexió...
             DB_connexio.close (); // ...la tanquem. 
        }
        catch (SQLException e){
            informa_error_sql(e);
        }
    }
    
    public void afegirPreparedStatement(String query){
        try{
            DB_connexio.prepareStatement(query);
        }
        catch(SQLException e){
            informa_error_sql(e);
        }
    }
    
//    public static void main(String [] args){
//        Connexio n = new Connexio("prova","root","","");
//        n.DBDesconnecta();
//    }
   
    //---------------------------------------------------------------------------
    // FUNCIONS GENÈRIQUES ------------------------------------------------------
    //---------------------------------------------------------------------------
    private static void informa_error (String s)
    {
       System.err.println (">>> ERROR: " + s);
    }

    //---------------------------------------------------------------------------
    private static void informa_error_sql (SQLException e) 
    {
       System.err.println (">>> ERROR SQL: " + e.getMessage());
    }
}