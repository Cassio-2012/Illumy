package Illumy.Model;

import oshi.software.os.OSFileStore;
import oshi.util.FormatUtil;

public class Armazenamento extends AtributosOshi {

    public String getDiscoDisponivel() {
        long disponivel = 0;
        for (OSFileStore fs : fileStoreArray) {
            disponivel += fs.getUsableSpace();
        }
        return FormatUtil.formatBytes(disponivel);
    }

    public String getDiscoTotal() {
        long total = 0;
        for (OSFileStore fs : fileStoreArray) {
            total += fs.getTotalSpace();
        }
        return FormatUtil.formatBytes(total);
    }

}
