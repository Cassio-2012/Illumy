
package com.mycompany.projetoillumy.oshi.data;


public class IntCpu extends ToInteger {
    
    public Double getUsoCpuInt() {
        
    String discoTotal = String.valueOf(processador.getUtilizacaoAtualProcessador(systemInfo.getHardware().getProcessor()));
   
    String m = discoTotal.replace("%", "").replaceAll(",", ".");
        
    Double discoTotalInt = Double.parseDouble(m);
        
        return discoTotalInt;
        
    }
    
}
