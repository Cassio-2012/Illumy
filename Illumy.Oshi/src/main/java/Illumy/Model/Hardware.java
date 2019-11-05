package Illumy.Model;

public class Hardware extends AtributosOshi {

    public String getMarcaComputador() {
        return hardware.getComputerSystem().getManufacturer();
    }

    public String getModeloCPU() {
        return hardware.getProcessor().getName();
    }

    public String getModeloPlacaMae() {
        return hardware.getComputerSystem().getBaseboard().getModel();
    }

}
