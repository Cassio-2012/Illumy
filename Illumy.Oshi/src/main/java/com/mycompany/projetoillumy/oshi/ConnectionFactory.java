
package com.mycompany.projetoillumy.oshi;

import org.apache.commons.dbcp2.BasicDataSource;

public class ConnectionFactory {
    
    private BasicDataSource dataSource; 
   
    public ConnectionFactory(){
        dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        dataSource.setUrl("jdbc:sqlserver://servidor01191072.database.windows.net:1433;database=BancoProjeto;");
        dataSource.setUsername("GF01191072@servidor01191072");
        dataSource.setPassword("#brucebi1808");
    }

    public BasicDataSource getDataSource() {
        return dataSource; 
    }
    

    
}


