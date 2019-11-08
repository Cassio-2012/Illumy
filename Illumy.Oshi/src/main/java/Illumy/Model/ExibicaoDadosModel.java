package Illumy.Model;

import Illumy.View.DashboardView;

public class ExibicaoDadosModel {
    
    DashboardView view;
    Processador processador;
    Memoria memoria;
    Armazenamento disco;
    Processos processos;

    public ExibicaoDadosModel(DashboardView view) {
        this.view = view;
        processador = new Processador();
        memoria = new Memoria();
        disco = new Armazenamento();
        processos = new Processos();
    }
    
    public void ExibeDados(){
        view.getLbUsoProcessador().setText(processador.getUtilizacaoAtualProcessador());
        view.getLbMemoriaDisponivel().setText(memoria.getMemoriaDisponivel());
        view.getLbArmazenamentoDisponivel().setText(disco.getDiscoDisponivel());
        view.getTxaProcessos().setText(processos.getProcessos());
    }

}
