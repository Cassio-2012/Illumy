package Illumy.Model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import oshi.hardware.GlobalMemory;

public class Memoria extends AtributosOshi {

    private static final Logger logger = LoggerFactory.getLogger(Memoria.class);
    private final GlobalMemory memoria;
    private long memoriaTotal;

    public Memoria() {
        this.memoria = systemInfo.getHardware().getMemory();
    }

    public long getMemoriaTotal() {
        logger.info("Recebendo registro de memória total para Sevidor: [{}]", idServidor);
        memoriaTotal = memoria.getTotal();
        logger.info("Captura de Memória total: [{}] para o Servidor: [{}]", memoriaTotal, idServidor);
        return memoriaTotal;
    }

    //Valores de atualização por tempo
    public Integer getMemoriaUtilizada() {
        logger.info("Recebendo registro de memória utilizada para Sevidor: [{}]", idServidor);
        long memoriaUtilizada = memoriaTotal - memoria.getAvailable();
        Integer porcentagemUsada = (int)((memoriaUtilizada * 100) / memoriaTotal);
        logger.info("Captura de Memória utilizada: [{}%] para o Servidor: [{}]", porcentagemUsada, idServidor);
        return porcentagemUsada;
    }
    //FIM //Valores de atualização por tempo
}
