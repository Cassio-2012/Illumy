package com.mycompany.projetoillumy.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public Connection getConnection() {
        try {
            return DriverManager.getConnection(
                    "jdbc:sqlserver://servidorlucas.database.windows.net:1433;"
                    + "database=Banco projeto;user=Aluno01191094@servidorlucas;"
                    + "password={#Gf46849632841};encrypt=true;trustServerCertificate=false;"
                    + "hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
