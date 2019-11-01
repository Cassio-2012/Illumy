package com.mycompany.projetoillumy.oshi;

import oshi.software.os.FileSystem;
import oshi.software.os.OSFileStore;
import oshi.util.FormatUtil;

public class Armazenamento {

    private final OSFileStore[] fsArray;
    private long disponivel;
    private long total;

    public Armazenamento(FileSystem fileSystem) {
        fsArray = fileSystem.getFileStores();
        disponivel = 0;
        total = 0;
    }

    public String getDiscoDisponivel() {
        disponivel = 0;
        for (OSFileStore fs : fsArray) {
            disponivel += fs.getUsableSpace();
        }
        return FormatUtil.formatBytes(disponivel);
    }

    public String getDiscoTotal() {
        total = 0;
        for (OSFileStore fs : fsArray) {
            total += fs.getTotalSpace();
        }
        return FormatUtil.formatBytes(total);
    }

}
