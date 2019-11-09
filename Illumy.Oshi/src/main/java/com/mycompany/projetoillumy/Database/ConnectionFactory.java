
package com.mycompany.projetoillumy.Database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Aluno
 */
public class ConnectionFactory {
    
   public Connection getConnection() {
        try {
            return DriverManager.getConnection(
         "jdbc:sqlserver://servidor01191072.database.windows.net:1433;database=BancoProjeto"
         + ";user=GF01191072@servidor01191072;password={#brucebi1808};"
         + "encrypt=true;trustServerCertificate=false;"
         + "hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
        } catch (SQLException e) {
            throw new RuntimeException(e);     
        }
    }
 
    
}
