package Illumy.Model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import oshi.hardware.CentralProcessor;
import oshi.util.Util;

public class Processador extends AtributosOshi {
    
    private static final Logger logger = LoggerFactory.getLogger(Processador.class);
    private final CentralProcessor processador;
    
    public Processador() {
        //logger = LoggerFactory.getLogger(Processador.class);
        processador = systemInfo.getHardware().getProcessor();
    }

    //Valores de atualização por tempo
    public Integer getUtilizacaoAtualProcessador() {
        logger.info("Recebendo registro de porcentagem de cpu para Servidor: [{}]", idServidor);
        long[] ticks = processador.getSystemCpuLoadTicks();
        Util.sleep(1000);
        return (int)(processador.getSystemCpuLoadBetweenTicks(ticks) * 100);
    }
    //FIM Valores de atualização por tempo
}
