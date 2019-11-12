package Illumy.Model;

import Illumy.Configuration.ConnectionFactory;
import java.util.List;
import java.util.Map;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

public class OperacoesSql {

    private final JdbcTemplate jdbcTemplate;
    private final ConnectionFactory conexao;
    private Integer fkServidor;

    public OperacoesSql() {
        this.conexao = new ConnectionFactory();
        this.jdbcTemplate = new JdbcTemplate(conexao.getDataSource());
    }

    public Boolean queryLogin(String login, String senha) {

        List<Map<String, Object>> loginValido = jdbcTemplate.queryForList("Select count(*) from usuario where nomeUser=(?) and senha=(?)", login, senha);

        if (loginValido.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public void insertCpu(String usoCPU, String modCPU, String tempCPU) {
        try {
            jdbcTemplate.update(
                    "insert into CPU (utilizacaoAtual, ModProcessador, TempCPU, fkServidor)"
                    + "values(?,?,?,?)", usoCPU, modCPU, tempCPU, fkServidor);

        } catch (DataAccessException e) {
            System.out.println("Erro" + e);
        }
    }

    public void InsertRam(String disponivel, String total) {
        try {
            jdbcTemplate.update(
                    "insert into memoriaRam (espacoLivreGB, memoriaTotalGB, fkServidor)"
                    + "values(?,?,?)", disponivel, total, fkServidor);

        } catch (DataAccessException e) {
            System.out.println("Erro" + e);
        }
    }

    public void InsertDisco(String disponivel, String total) {
        try {
            jdbcTemplate.update(
                    "insert into disco (espacoLivreGB, tamanhoTotalGB, fkServidor)"
                    + "values(?,?,?)", disponivel, total, fkServidor);

        } catch (Exception e) {
            System.out.println("Erro" + e);
        }
    }

}
