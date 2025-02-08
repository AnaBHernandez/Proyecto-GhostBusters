package dev.anaynau;

import java.util.Scanner;

import dev.anaynau.controllers.GhostbusterController;
import dev.anaynau.enums.FantasmaClase;
import dev.anaynau.enums.NivelPeligrosidad;
import dev.anaynau.models.Fantasma;
import dev.anaynau.models.Ghostbuster;

import java.util.List;
import java.time.LocalDate;

public class GhostBustersApp {
    private static final Scanner scanner = new Scanner(System.in);
    private static GhostbusterController controller;

    public static void main(String[] args) {
        inicializarAplicacion();
        mostrarMenuPrincipal();
    }

    private static void inicializarAplicacion() {
        System.out.println("¡Bienvenido a GhostBusters Asturias!");
        System.out.print("Por favor, ingresa tu nombre: ");
        String nombreUsuario = scanner.nextLine();

        Ghostbuster ghostBuster = new Ghostbuster(nombreUsuario);
        controller = new GhostbusterController(ghostBuster);

        System.out.println("¡Hola, " + nombreUsuario + "! Estás listo para cazar fantasmas en Asturias.");
    }

    private static void mostrarMenuPrincipal() {
        while (true) {
            System.out.println("\n--- Menú Principal ---");
            System.out.println("1. Capturar un nuevo fantasma");
            System.out.println("2. Ver lista de fantasmas capturados");
            System.out.println("3. Liberar un fantasma");
            System.out.println("4. Filtrar fantasmas por clase");
            System.out.println("5. Ver fantasmas capturados en un mes");
            System.out.println("6. Ver mi perfil de GhostBuster");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    capturarFantasma();
                    break;
                case 2:
                    verListaDeFantasmas();
                    break;
                case 3:
                    liberarFantasma();
                    break;
                case 4:
                    filtrarFantasmasPorClase();
                    break;
                case 5:
                    verFantasmasPorMes();
                    break;
                case 6:
                    verPerfilGhostBuster();
                    break;
                case 7:
                    System.out.println("¡Gracias por usar GhostBusters Asturias!");
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    private static void capturarFantasma() {
        System.out.println("\n--- Capturar Nuevo Fantasma ---");
        System.out.print("Nombre del fantasma: ");
        String nombre = scanner.nextLine();

        System.out.println("Seleccione la clase del fantasma:");
        for (FantasmaClase clase : FantasmaClase.values()) {
            System.out.println(clase.ordinal() + 1 + ". " + clase.getDescripcion());
        }
        int claseSeleccionada = scanner.nextInt() - 1;
        scanner.nextLine(); // Consumir el salto de línea

        System.out.print("Nivel de peligro (BAJO, MEDIO, ALTO, CRITICO): ");
        NivelPeligrosidad nivel = NivelPeligrosidad.valueOf(scanner.nextLine().toUpperCase());

        System.out.print("Habilidad especial: ");
        String habilidad = scanner.nextLine();

        Fantasma nuevoFantasma = new Fantasma(nombre, FantasmaClase.values()[claseSeleccionada], nivel, habilidad);
        controller.capturarFantasma(nuevoFantasma);

        System.out.println("¡Fantasma capturado con éxito!");
    }

    private static void verListaDeFantasmas() {
        System.out.println("\n--- Lista de Fantasmas Capturados ---");
        List<Fantasma> fantasmas = controller.verFantasmas();
        if (fantasmas.isEmpty()) {
            System.out.println("Aún no has capturado ningún fantasma.");
        } else {
            fantasmas.forEach(System.out::println);
        }
    }

    private static void liberarFantasma() {
        System.out.println("\n--- Liberar Fantasma ---");
        List<Fantasma> fantasmas = controller.verFantasmas();
        if (fantasmas.isEmpty()) {
            System.out.println("No hay fantasmas para liberar.");
            return;
        }

        for (int i = 0; i < fantasmas.size(); i++) {
            System.out.println((i + 1) + ". " + fantasmas.get(i).getNombre());
        }

        System.out.print("Seleccione el número del fantasma a liberar: ");
        int seleccion = scanner.nextInt() - 1;
        scanner.nextLine(); // Consumir el salto de línea

        if (seleccion >= 0 && seleccion < fantasmas.size()) {
            Fantasma fantasmaLiberado = fantasmas.get(seleccion);
            controller.liberarFantasma(fantasmaLiberado);
            System.out.println("Has liberado a " + fantasmaLiberado.getNombre());
        } else {
            System.out.println("Selección no válida.");
        }
    }

    private static void filtrarFantasmasPorClase() {
        System.out.println("\n--- Filtrar Fantasmas por Clase ---");
        System.out.println("Seleccione la clase de fantasma:");
        for (FantasmaClase clase : FantasmaClase.values()) {
            System.out.println(clase.ordinal() + 1 + ". " + clase.getDescripcion());
        }
        int claseSeleccionada = scanner.nextInt() - 1;
        scanner.nextLine(); // Consumir el salto de línea

        List<Fantasma> fantasmasFiltrados = controller.filtrarFantasmasPorClase(FantasmaClase.values()[claseSeleccionada]);
        if (fantasmasFiltrados.isEmpty()) {
            System.out.println("No hay fantasmas de esta clase.");
        } else {
            fantasmasFiltrados.forEach(System.out::println);
        }
    }

    private static void verFantasmasPorMes() {
        System.out.println("\n--- Ver Fantasmas Capturados en un Mes ---");
        System.out.print("Ingrese el mes (1-12): ");
        int mes = scanner.nextInt();
        System.out.print("Ingrese el año: ");
        int anio = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        LocalDate fecha = LocalDate.of(anio, mes, 1);
        List<Fantasma> fantasmasDelMes = controller.verFantasmasPorMes(fecha);
        if (fantasmasDelMes.isEmpty()) {
            System.out.println("No se capturaron fantasmas en ese mes.");
        } else {
            fantasmasDelMes.forEach(System.out::println);
        }
    }

    private static void verPerfilGhostBuster() {
        System.out.println("\n--- Mi Perfil de GhostBuster ---");
        Ghostbuster ghostBuster = controller.getGhostbuster();
        System.out.println("Nombre: " + ghostBuster.getNombre());
        System.out.println("ID: " + ghostBuster.getId());
        System.out.println("Fantasmas capturados: " + ghostBuster.getColeccionDeFantasmas().size());
    }
}