
package com.mycompany.projetoillumy.oshi.data;


public class IntRam extends ToInteger {
    
    public Double getMemoriaDispInteger() {
        
    String memoriaDisponivel = memoria.getMemoriaDisponivel(systemInfo.getHardware().getMemory());
   
    String m = memoriaDisponivel.replace(" MiB", "").replaceAll(",", ".");
        
    Double memoriaDispInteger = Double.parseDouble(m);
        
        return memoriaDispInteger;
        
    }
    public Double getMemoriaTotalInteger() {
        
    String memoriaDisponivel = memoria.getMemoriaTotal(systemInfo.getHardware().getMemory());
   
    String m = memoriaDisponivel.replace(" GiB", "").replaceAll(",", ".");
        
    Double memoriaDispInteger = Double.parseDouble(m);
        
        return memoriaDispInteger;
        
    }
    
     public Double getTamanhoUsadoRam() {
      
     Double total = getMemoriaTotalInteger();
     Double livre = getMemoriaDispInteger();
         
 //     #tamanho total em GB   
     Double usado = (total *1024) - livre;
     
        return usado;
    }
     
     public long getPorcentagemLivreRam() {
      
        Double total = getMemoriaTotalInteger();
        Double livre = getMemoriaDispInteger();
        
        Double porcentagem = ((livre / (total *1024)) *100);
        
        return Math.round(porcentagem);
    }
     
     public long getPorcentagemUsadaRam() {
      
        Double total = getMemoriaTotalInteger();
        Double usado = getTamanhoUsadoRam();
        
        
        Double porcentagem = ((usado / (total *1024)) *100);
             
        
        return Math.round(porcentagem);
    }
    
}
