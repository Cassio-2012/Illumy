package Illumy.Model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import oshi.software.os.OSFileStore;

public class Armazenamento extends AtributosOshi {

    private static final Logger logger = LoggerFactory.getLogger(Armazenamento.class);
    private long discoTotal;

    public Integer getDiscoUtilizado() {
        logger.info("Recebendo registro de disco usado para Sevidor: [{}]", idServidor);
        long disponivel = 0;
        for (OSFileStore fs : fileStoreArray) {
            disponivel += fs.getUsableSpace();
        }
        logger.info("Captura de disco usado: [{}%] para o Servidor: [{}]", disponivel, idServidor);
        return (int)((disponivel * 100) / discoTotal);
    }

    public long getDiscoTotal() {
        logger.info("Recebendo registro de disco total para Sevidor: [{}]", idServidor);
        discoTotal = 0;
        for (OSFileStore fs : fileStoreArray) {
            discoTotal += fs.getTotalSpace();
        }
        logger.info("Captura de disco total: [{}] para o Servidor: [{}]", discoTotal, idServidor);
        return discoTotal;
    }

}
