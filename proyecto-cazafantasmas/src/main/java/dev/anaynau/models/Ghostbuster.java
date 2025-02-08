package dev.anaynau.models;

import java.util.ArrayList;
import java.util.List;

public class Ghostbuster {
    private static int contadorId = 1;
    private int id;
    private String nombre;
    private List<Fantasma> coleccionDeFantasmas;

    public Ghostbuster(String nombre) {
        this.id = contadorId++;
        this.nombre = nombre;
        this.coleccionDeFantasmas = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Fantasma> getColeccionDeFantasmas() {
        return new ArrayList<>(coleccionDeFantasmas);
    }

    public void agregarFantasma(Fantasma fantasma) {
        coleccionDeFantasmas.add(fantasma);
    }

    public void eliminarFantasma(Fantasma fantasma) {
        coleccionDeFantasmas.remove(fantasma);
    }

    @Override
    public String toString() {
        return "GhostBuster{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", fantasmas=" + coleccionDeFantasmas.size() +
                '}';
    }
}

