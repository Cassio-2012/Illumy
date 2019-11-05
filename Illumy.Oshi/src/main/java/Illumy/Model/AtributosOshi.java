package Illumy.Model;

import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.FileSystem;
import oshi.software.os.OSFileStore;
import oshi.software.os.OperatingSystem;

public abstract class AtributosOshi {

    protected final SystemInfo systemInfo;
    protected final HardwareAbstractionLayer hardware;
    protected final OperatingSystem sistemaOperacional;
    protected final FileSystem fileSystem;
    protected final OSFileStore[] fileStoreArray;

    public AtributosOshi() {
        this.systemInfo = new SystemInfo();
        this.hardware = systemInfo.getHardware();
        this.sistemaOperacional = systemInfo.getOperatingSystem();
        this.fileSystem = systemInfo.getOperatingSystem().getFileSystem();
        fileStoreArray = fileSystem.getFileStores();
    }

}
