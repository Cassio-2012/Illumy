package Illumy.Model;

import Illumy.View.DashboardView;
import oshi.util.FormatUtil;

public class ExibicaoDadosModel {

    private final DashboardView view;
    private final Processador processador;
    private final Memoria memoria;
    private final Armazenamento disco;
    private final Processos processos;
    private long memoriaTotal;
    private Integer porcentagemCpu;
    private Integer memoriaUtilizada;
    private long discoTotal;
    private Integer discoUsado;

    public ExibicaoDadosModel(DashboardView view) {
        this.view = view;
        processador = new Processador();
        memoria = new Memoria();
        disco = new Armazenamento();
        processos = new Processos();
    }

    public void getDados() {
        memoriaTotal = memoria.getMemoriaTotal();
        porcentagemCpu = processador.getUtilizacaoAtualProcessador();
        memoriaUtilizada = memoria.getMemoriaUtilizada();
        discoTotal = disco.getDiscoTotal();
        discoUsado = disco.getDiscoUtilizado();
    }

    public void exibeDados() {
        try{
        view.getLbMemoriaTotal().setText(FormatUtil.formatBytes(memoriaTotal));
        view.getLbUsoProcessador().setText(String.format("%1d%%", porcentagemCpu));
        view.getLbMemoriaUtilizada().setText(String.format("%1d%%", memoriaUtilizada));
        view.getLbArmazenamentoUtilizado().setText(String.format("%1d%%", discoUsado));
        view.getLbArmazenamentoTotal().setText(FormatUtil.formatBytes(discoTotal));
        view.getTxaProcessos().setText(processos.getProcessos());
        }
        catch(Exception ex){
            System.out.println(ex);
        }
    }

}
