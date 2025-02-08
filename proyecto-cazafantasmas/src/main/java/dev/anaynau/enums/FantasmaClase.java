package dev.anaynau.enums;

public enum FantasmaClase {
    CLASE_I("Manifestación menor"),
    CLASE_II("Aparición móvil"),
    CLASE_III("Entidad inteligente"),
    CLASE_IV("Fantasma histórico"),
    CLASE_V("Espíritu antropomorfo"),
    CLASE_VI("Espíritu demoníaco"),
    CLASE_VII("Entidad ultraterrena");

    private final String descripcion;
    FantasmaClase(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

}
