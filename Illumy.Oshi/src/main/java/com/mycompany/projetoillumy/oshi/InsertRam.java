
package com.mycompany.projetoillumy.oshi;

import org.springframework.jdbc.core.JdbcTemplate;


public class InsertRam {
    
    protected Double disponivel;
    protected Double total;
    protected Integer fkServidor;
    protected Double usada;
    protected long usadaPorcentagem;
    protected long livrePorcentagem;

    public InsertRam(Double disponivel, Double total, Double usada,
            long usadaPorcentagem, long livrePorcentagem) {
        
    this.disponivel = disponivel;                
    this.total = total;                              
    this.usada = usada;                              
    this.usadaPorcentagem = usadaPorcentagem;                              
    this.livrePorcentagem = livrePorcentagem;                              
    this.fkServidor = 1;                              
    }

    

   

    public void InsertRam() {
        
        ConnectionFactory dadosConexao = new ConnectionFactory();
        
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dadosConexao.getDataSource());
   
        try {
           jdbcTemplate.update(
                "insert into memoriaRam (espacoLivreMB, memoriaTotalGB, memoriaUsadaMB"
                        + ", memoriaUsadaPorcentagem, espacoLivrePorcentagem, fkServidor)"
                + "values(?,?,?,?,?,?)", disponivel, total, usada, usadaPorcentagem, livrePorcentagem, fkServidor);
             
        } catch (Exception e) {
            System.out.println("Erro"+e);
        }
    }  
    
}
