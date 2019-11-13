package Illumy.Model;

import oshi.software.os.OSFileStore;
import oshi.util.FormatUtil;

public class Armazenamento extends AtributosOshi {

    public Double getDiscoDisponivel() {
        long disponivel = 0;
        for (OSFileStore fs : fileStoreArray) {
            disponivel += fs.getUsableSpace();
        }
        return (double)disponivel;
    }

    public Double getDiscoTotal() {
        long total = 0;
        for (OSFileStore fs : fileStoreArray) {
            total += fs.getTotalSpace();
        }
        return (double)total;
    }

}
