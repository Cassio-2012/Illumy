package Illumy.Model;

import Illumy.View.DashboardView;
import oshi.util.FormatUtil;

public class ExibicaoDadosModel {

    private final DashboardView view;
    private final Processador processador;
    private final Memoria memoria;
    private final Armazenamento disco;
    private final Processos processos;
    private Double memoriaTotal;
    private Integer porcentagemCpu;
    private Double memoriaDisponivel;
    private Double discoTotal;
    private Double discoDisponivel;

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
        memoriaDisponivel = memoria.getMemoriaDisponivel();
        discoTotal = disco.getDiscoTotal();
        discoDisponivel = disco.getDiscoDisponivel();
    }

    public void exibeDados() {
        view.getLbMemoriaTotal().setText(FormatUtil.formatBytes(memoriaTotal.longValue()));
        view.getLbUsoProcessador().setText(String.format("%1d%%", porcentagemCpu));
        view.getLbMemoriaDisponivel().setText(FormatUtil.formatBytes(memoriaDisponivel.longValue()));
        view.getLbArmazenamentoDisponivel().setText(FormatUtil.formatBytes(discoTotal.longValue()));
        view.getLbArmazenamentoTotal().setText(FormatUtil.formatBytes(discoTotal.longValue()));
        view.getTxaProcessos().setText(processos.getProcessos());
    }

}
