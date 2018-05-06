    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Marc
 */
public class Operaris {


    public boolean ifExists(String sSQL, int nId) {
    PreparedStatement ps = dbConn.prepareStatement(sSQL);
    ps.setString(1, id);
    ResultSet rs = ps.executeQuery();
    return rs.next();
}
    
}
