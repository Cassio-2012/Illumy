
package com.mycompany.projetoillumy.oshi;

import org.springframework.jdbc.core.JdbcTemplate;



public class InsertCPU {
    
    protected Double usoCPU;   
    protected String tempCPU;
    protected Integer fkServidor;

    public InsertCPU(Double usoCPU,String tempCPU) {
    this.usoCPU = usoCPU;                                  
    this.tempCPU = tempCPU;                
    this.fkServidor = 1;                
    }

    public void insertCPU() {
        
        ConnectionFactory dadosConexao = new ConnectionFactory();
        
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dadosConexao.getDataSource());
   
        try {
           jdbcTemplate.update(
                "insert into CPU (utilizacaoAtual, TempCPU, fkServidor)"
                + "values(?,?,?)", usoCPU, tempCPU,fkServidor);
             
        } catch (Exception e) {
            System.out.println("Erro"+e);
        }
    }
}
            

