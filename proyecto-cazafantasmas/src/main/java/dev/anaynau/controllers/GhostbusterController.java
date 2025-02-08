package dev.anaynau.controllers;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import dev.anaynau.enums.FantasmaClase;
import dev.anaynau.models.Fantasma;
import dev.anaynau.models.Ghostbuster;

public class GhostbusterController {
        private Ghostbuster ghostBuster;
    
        public GhostbusterController(Ghostbuster ghostBuster) {
            this.ghostBuster = ghostBuster;
        }
    
        public void capturarFantasma(Fantasma fantasma) {
            ghostBuster.agregarFantasma(fantasma);
        }
    
        public void liberarFantasma(Fantasma fantasma) {
            ghostBuster.eliminarFantasma(fantasma);
        }
    
        public List<Fantasma> verFantasmas() {
            return ghostBuster.getColeccionDeFantasmas();
        }
    
        public List<Fantasma> filtrarFantasmasPorClase(FantasmaClase clase) {
            return ghostBuster.getColeccionDeFantasmas().stream()
                    .filter(f -> f.getClase() == clase)
                    .collect(Collectors.toList());
        }
    
        public List<Fantasma> verFantasmasPorMes(LocalDate fecha) {
            return ghostBuster.getColeccionDeFantasmas().stream()
                    .filter(f -> f.getFechaCaptura().getMonth() == fecha.getMonth() &&
                                f.getFechaCaptura().getYear() == fecha.getYear())
                    .collect(Collectors.toList());
        }

        public Ghostbuster getGhostbuster() {
            return ghostBuster;
        }
    }
