package Illumy.Model;

import oshi.hardware.GlobalMemory;
import oshi.util.FormatUtil;

public class Memoria extends AtributosOshi {

    private final GlobalMemory memoria;

    public Memoria() {
        this.memoria = systemInfo.getHardware().getMemory();
    }

    public String getMemoriaTotal() {
        return FormatUtil.formatBytes(memoria.getTotal());
    }
    
    //Valores de atualização por tempo
    public String getMemoriaDisponivel() {
        return FormatUtil.formatBytes(memoria.getAvailable());
    }
    //FIM //Valores de atualização por tempo
}
