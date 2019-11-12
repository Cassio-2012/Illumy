package Illumy.Model;

import oshi.hardware.GlobalMemory;
import oshi.util.FormatUtil;

public class Memoria extends AtributosOshi {

    private final GlobalMemory memoria;

    public Memoria() {
        this.memoria = systemInfo.getHardware().getMemory();
    }

    public Double getMemoriaTotal() {
        return (double)memoria.getTotal();
    }
    
    //Valores de atualização por tempo
    public Double getMemoriaDisponivel() {
        return (double)memoria.getAvailable();
    }
    //FIM //Valores de atualização por tempo
}
