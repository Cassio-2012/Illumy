package Illumy.Model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import oshi.hardware.GlobalMemory;

public class Memoria extends AtributosOshi {

    private static final Logger logger = LoggerFactory.getLogger(Memoria.class);
    private final GlobalMemory memoria;

    public Memoria() {
        this.memoria = systemInfo.getHardware().getMemory();
    }

    public Double getMemoriaTotal() {
        logger.info("Recebendo registro de memória total para Sevidor: [{}]", idServidor);
        Double memoriaTotal = (double) memoria.getTotal();
        logger.info("Captura de Memória total: [{}] para o Servidor: [{}]", memoriaTotal, idServidor);
        return memoriaTotal;
    }

    //Valores de atualização por tempo
    public Double getMemoriaDisponivel() {
        logger.info("Recebendo registro de memória disponivel para Sevidor: [{}]", idServidor);
        Double memoriaDisponivel = (double) memoria.getAvailable();
        logger.info("Captura de Memória disponivel: [{}] para o Servidor: [{}]", memoriaDisponivel, idServidor);
        return memoriaDisponivel;
    }
    //FIM //Valores de atualização por tempo
}
