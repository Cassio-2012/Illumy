
package com.mycompany.projetoillumy.oshi.data;


public class IntDisco extends ToInteger {
    
    public Double getArmazenamentoLivreInt() {
        
    String discoLivre = String.valueOf(armazenamento.getDiscoDisponivel());
   
    String m = discoLivre.replace(" GiB", "").replaceAll(",", ".");
        
    Double discoLivreInt = Double.parseDouble(m);
        
        return discoLivreInt;
        
    }
    
    public Double getArmazenamentoTotalInt() {
        
    String discoTotal = String.valueOf(armazenamento.getDiscoTotal());
   
    String m = discoTotal.replace(" GiB", "").replaceAll(",", ".");
        
    Double discoTotalInt = Double.parseDouble(m);
        
        return discoTotalInt;
        
    }
    
   
    public Double getTamanhoUsadoDisco() {
      
     Double total = getArmazenamentoTotalInt();
     Double livre = getArmazenamentoLivreInt();
     
     
     Double usado = total - livre; 
     
        return usado;
    }    
    
    public long getPorcentagemUsadaDisco() {
      
        Double total = getArmazenamentoTotalInt();
        Double usado = getTamanhoUsadoDisco();
        
        Double porcentagem = ((usado / total) *100);
        
        return Math.round(porcentagem);
    }
    
    public long getPorcentagemLivreDisco() {
      
        Double total = getArmazenamentoTotalInt();
        Double livre = getArmazenamentoLivreInt();
        
        Double porcentagem = ((livre / total) *100);
        
        return Math.round(porcentagem);
    }
    
}
