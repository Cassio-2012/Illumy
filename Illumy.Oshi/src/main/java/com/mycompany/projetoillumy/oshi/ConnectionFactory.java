
package com.mycompany.projetoillumy.oshi;

import org.apache.commons.dbcp2.BasicDataSource;

public class ConnectionFactory {
    
    private BasicDataSource dataSource; 
   
    public ConnectionFactory(){
        dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        dataSource.setUrl("jdbc:sqlserver://servidorlucas.database.windows.net:1433;database=Banco projeto;");
        dataSource.setUsername("Aluno01191094@servidorlucas");
        dataSource.setPassword("#Gf46849632841");
    }

    public BasicDataSource getDataSource() {
        return dataSource; 
    }
    

    
}