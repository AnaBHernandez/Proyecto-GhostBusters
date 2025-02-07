package dev.anaynau.models;

import java.time.LocalDate;
import java.util.Random;

import dev.anaynau.enums.FantasmaClase;
import dev.anaynau.enums.NivelPeligrosidad;

public class Fantasma {
    private static int contadorId = 1;
    private int id;
    private String nombre;
    private FantasmaClase clase;
    private NivelPeligrosidad peligrosidad;
    private LocalDate fechaCaptura;
    private String habilidadEspecial;
    private int afinidadEctoplasmica;

    public Fantasma(String nombre, FantasmaClase clase, NivelPeligrosidad peligrosidad, String habilidadEspecial) {
        this.id = contadorId ++;
        this.nombre = nombre;
        this.clase = clase;
        this.peligrosidad = peligrosidad;
        this.habilidadEspecial = habilidadEspecial;
        this.fechaCaptura = LocalDate.now();
        this.afinidadEctoplasmica = new Random().nextInt(10) + 1;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public FantasmaClase getClase() {
        return clase;
    }

    public NivelPeligrosidad getPeligrosidad() {
        return peligrosidad;
    }

    public String getHabilidadEspecial() {
        return habilidadEspecial;
    }

    public LocalDate getFechaCaptura() {
        return fechaCaptura;
    }

    public int getAfinidadEctoplasmica() {
        return afinidadEctoplasmica;
    }

    @Override
    public String toString() {
        return "Fantasma{" +
                "id=" + id +
                "nombre='" + nombre + '\'' +
                ", clase=" + clase +
                ", peligrosidad=" + peligrosidad +
                ", habilidadEspecial='" + habilidadEspecial + '\'' +
                ", fechaCaptura=" + fechaCaptura +
                ", afinidadEctoplasmica=" + afinidadEctoplasmica +
                '}';
    }
}