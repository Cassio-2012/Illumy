package com.mycompany.projetoillumy.oshi;

import Illumy.Configuration.ConnectionFactory;
import org.springframework.jdbc.core.JdbcTemplate;

public class InsertDisco {

    protected String disponivel;
    protected String total;
    protected Integer fkServidor;

    public InsertDisco(String disponivel, String total) {
        this.disponivel = disponivel;
        this.total = total;
        this.fkServidor = 1;
    }

    public void InsertDisco() {

        ConnectionFactory dadosConexao = new ConnectionFactory();

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dadosConexao.getDataSource());

        try {
            jdbcTemplate.update(
                    "insert into disco (espacoLivreGB, tamanhoTotalGB, fkServidor)"
                    + "values(?,?,?)", disponivel, total, fkServidor);

        } catch (Exception e) {
            System.out.println("Erro" + e);
        }
    }

}
