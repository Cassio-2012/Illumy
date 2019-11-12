package Illumy.Model;

import oshi.hardware.CentralProcessor;
import oshi.util.Util;

public class Processador extends AtributosOshi {

    private final CentralProcessor processador;

    public Processador() {
        processador = systemInfo.getHardware().getProcessor();
    }

    //Valores de atualização por tempo
    public Integer getUtilizacaoAtualProcessador() {
        long[] ticks = processador.getSystemCpuLoadTicks();
        Util.sleep(1000);
        return (int)processador.getSystemCpuLoadBetweenTicks(ticks) * 100;
        //return String.format("%.1f%%", hardware.getProcessor().getSystemCpuLoad() * 100);
    }
    //FIM Valores de atualização por tempo
}
