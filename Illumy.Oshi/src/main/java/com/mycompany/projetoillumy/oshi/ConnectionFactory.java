
package com.mycompany.projetoillumy.oshi;

import org.apache.commons.dbcp2.BasicDataSource;

public class ConnectionFactory {
    
    private BasicDataSource dataSource; 
   
    public ConnectionFactory(){
        dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        dataSource.setUrl("jdbc:sqlserver://srvillumy.database.windows.net:1433;database=Projeto illumy");
        dataSource.setUsername("userillumy@srvillumy");
        dataSource.setPassword("#Gfgrupo4");
    }

    public BasicDataSource getDataSource() {
        return dataSource; 
    }
    
 
    
}