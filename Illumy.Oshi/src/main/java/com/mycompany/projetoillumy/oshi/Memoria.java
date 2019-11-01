package com.mycompany.projetoillumy.oshi;

import oshi.SystemInfo;
import oshi.hardware.GlobalMemory;
import oshi.util.FormatUtil;

public class Memoria {

    private final SystemInfo systemInfo;

    public Memoria() {
        systemInfo = new SystemInfo();
    }

    //Valores de atualização por tempo
    public String getMemoriaDisponivel(GlobalMemory memoria) {
        return FormatUtil.formatBytes(memoria.getAvailable());
    }

    public String getMemoriaTotal(GlobalMemory memoria) {
        return FormatUtil.formatBytes(memoria.getTotal());
    }
    //FIM //Valores de atualização por tempo
}
