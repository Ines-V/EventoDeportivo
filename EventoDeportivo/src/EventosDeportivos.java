import java.util.Scanner;

public class EventosDeportivos {

    int registrados = 0;
    String[] deportes = new String[0];
    String[] eventos = new String[0];
    String[] dias = new String[0];
    String[] meses = new String[0];
    String[] anos = new String[0];
    int[] numerosAsistentes = new int[0];
    int cantidad=0;

    public static void main(String[] args) {
        EventosDeportivos eventos = new EventosDeportivos();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            menu();
            System.out.print("Introduce la opción deseada: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    eventos.registroEvento(scanner);
                    break;
                case 2:
                    eventos.mostrarEventos();
                    break;
                case 3:
                    eventos.buscarEventos();
                    break;
                case 4:
                    eventos.eventosPersonas();
                    break;
                case 5:
                    eventos.eliminarEvento();
                    break;
                case 6:
                    eventos.salir();
                    break;
                default:
                    System.out.println("Opción incorrecta.");
            }
        } while (opcion != 6);

        scanner.close();
    }

    public static void menu() {
        System.out.println("Menú:");
        System.out.println("1. Registrar evento deportivo.");
        System.out.println("2. Mostrar todos los eventos registrados.");
        System.out.println("3. Buscar eventos por deporte o por día.");
        System.out.println("4. Consultar el total de eventos y participantes.");
        System.out.println("5. Eliminar un evento registrado.");
        System.out.println("6. Salir.");
    }

    public void registroEvento(Scanner scanner) {
        System.out.println("¿Cuántos eventos deportivos deseas registrar?");
        int cantidad = scanner.nextInt();
        scanner.nextLine();

        if (cantidad <= 0) {
            System.out.println("La cantidad debe ser mayor que cero.");
            return;
        }

        int newCantidad = registrados + cantidad;

        String[] nuevosDeportes = new String[newCantidad];
        String[] nuevosEventos = new String[newCantidad];
        String[] nuevosDias = new String[newCantidad];
        String[] nuevosMeses = new String[newCantidad];
        String[] nuevosAnos = new String[newCantidad];
        int[] nuevosNumerosAsistentes = new int[newCantidad];

        for (int i=0; i<registrados; i++) {
            nuevosDeportes[i] = deportes[i];
            nuevosEventos[i] = eventos[i];
            nuevosDias[i] = dias[i];
            nuevosMeses[i] = meses[i];
            nuevosAnos[i] = anos[i];
            nuevosNumerosAsistentes[i] = numerosAsistentes[i];
        }
        deportes = nuevosDeportes;
        eventos = nuevosEventos;
        dias = nuevosDias;
        meses = nuevosMeses;
        anos = nuevosAnos;
        numerosAsistentes = nuevosNumerosAsistentes;

        for (int i = registrados; i < newCantidad; i++) {
            System.out.println("Introduce el nombre del evento:");
            eventos[i] = scanner.nextLine();

            System.out.println("Introduce el deporte:");
            deportes[i] = scanner.nextLine();

            System.out.println("Introduce el número de participantes:");
            numerosAsistentes[i] = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Introduce la fecha del evento:");

            System.out.println("Mes:");
            int mes = scanner.nextInt();
            while (mes < 1 || mes > 12) {
                System.out.println("Mes inválido. Introduce un número del 1 al 12:");
                mes = scanner.nextInt();
            }
            meses[i] = String.valueOf(mes);

            int maxDia=31;
            switch (mes) {
                case 1:
                    maxDia=31;
                    break;

                case 2:
                    maxDia=28;
                    break;

                case 3:
                    maxDia=31;
                    break;

                case 4:
                    maxDia=30;
                    break;

                case 5:
                    maxDia=31;
                    break;

                case 6:
                    maxDia=30;
                    break;

                case 7:
                    maxDia=31;
                    break;

                case 8:
                    maxDia=31;
                    break;

                case 9:
                    maxDia=30;
                    break;

                case 10:
                    maxDia=31;
                    break;

                case 11:
                    maxDia=30;
                    break;

                case 12:
                    maxDia=31;
                    break;
            }
            meses[i] = String.valueOf(mes);

            System.out.println("Día:");
            int dia = scanner.nextInt();
            while (dia < 1 || dia > maxDia) {
                System.out.println("Día incorrecto. Introduce un día:");
                dia = scanner.nextInt();
            }
            dias[i] = String.valueOf(dia);
            scanner.nextLine();

            System.out.println("Año:");
            anos[i] = scanner.nextLine();

            registrados++;
        }

        System.out.println(cantidad + " eventos registrados.");
    }

    public void mostrarEventos() {
        if (registrados == 0) {
            System.out.println("No hay eventos registrados.");
            return;
        }

        System.out.println("Eventos registrados: " + registrados);
        for (int i = 0; i < registrados; i++) {
            System.out.println("Evento: " + eventos[i]+ ". Deporte: " + deportes[i]+ ". Número de participantes: " + numerosAsistentes[i]+ ". Fecha: " + dias[i] + "/" + meses[i] + "/" + anos[i]);
        }
    }

    public void buscarEventos() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Buscar por 1.deporte o 2.día:");
        int opcion = scanner.nextInt();
        boolean encontrado = false;
        scanner.nextLine();

        switch (opcion) {
            case 1:
                System.out.println("Introduce el deporte:");
                String deporteBuscado = scanner.nextLine();

                for (int i = 0; i < registrados; i++) {
                    if (deporteBuscado.equals(deportes[i])) {
                        System.out.println("Evento: " + eventos[i] + ". Deporte: " + deportes[i]+ ". Número de participantes: " + numerosAsistentes[i]+ ". Fecha: " + dias[i] + "/" + meses[i] + "/" + anos[i]);
                        encontrado = true;
                        break;
                    }
                }
                if (!encontrado) {
                    System.out.println("No se encontraron eventos para el deporte: " + deporteBuscado);
                }
                break;
            case 2:
                System.out.println("Introduce el día:");
                String diaBuscado = scanner.nextLine();

                System.out.println("Introduce el mes:");
                String mesBuscado = scanner.nextLine();

                System.out.println("Introduce el año:");
                String anoBuscado = scanner.nextLine();

                for (int i = 0; i < registrados; i++) {
                    if (dias[i].equals(diaBuscado) && meses[i].equals(mesBuscado) && anos[i].equals(anoBuscado)) {
                        System.out.println("Evento: " +eventos[i]+ ". Deporte: " +deportes[i]+ ". Participantes: " +numerosAsistentes[i]+ ". Fecha: " +dias[i]+ "/"+meses[i]+ "/" + anos[i]);
                        encontrado = true;
                    }
                }
                if (!encontrado) {
                    System.out.println("No se encontraron eventos en esa fecha.");
                }
                break;
            default:
                System.out.println("Opción incorrecta.");
        }
    }

    public void eventosPersonas() {
        System.out.println("El número de eventos registrados es: " + registrados);

        int totalParticipantes = 0;
        for (int i = 0; i < registrados; i++) {
            totalParticipantes += numerosAsistentes[i];
        }

        System.out.println("El número de personas inscritas es: " + totalParticipantes);
    }

    public void eliminarEvento() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("¿Desea eliminar algún evento? ");
        System.out.println("1. Sí");
        System.out.println("2. No");
        int opcion=scanner.nextInt();

        switch(opcion) {
            case 1:
                System.out.println("Eventos registrados: " + registrados);

                if (registrados==0) {
                    System.out.println("No hay eventos registrados.");
                    return;
                }

                System.out.println("Introduce el nombre del evento que desea eliminar: ");
                String eliminarEvento=scanner.next();

                int encontrarEvento=-1;

                for (int i = 0; i < registrados; i++) {
                    if (eliminarEvento.equals(eventos[i])) {
                        System.out.println("Se eliminó: Evento: " + eventos[i]+ ". Deporte: " + deportes[i]+ ". Número de participantes: " + numerosAsistentes[i]+ ". Fecha: " + dias[i] + "/" + meses[i] + "/" + anos[i]);
                        encontrarEvento=i;
                        break;
                    }
                }

                for (int i=encontrarEvento; i<registrados-1; i++){
                    eventos[i]=eventos[i-1];
                    deportes[i] = deportes[i-1];
                    numerosAsistentes[i] = numerosAsistentes[i-1];
                    dias[i] = dias[i-1];
                    meses[i] = meses[i-1];
                    anos[i] = anos[i-1];
                }

                registrados--;
                System.out.println("Evento eliminado.");

            case 2:
                System.out.println("No se ha eliminado nigun elemento.");
                break;
            default:
        }
    }
    public void salir(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("¿Deseas salir del progrma?");
        System.out.println("1. Si");
        System.out.println("2. No");

        int caso = scanner.nextInt();

        switch (caso) {
            case 1:
                System.out.println("Fin del programa.");
                break;
            case 2:
                EventosDeportivos.main(new String[0]);
                break;
            default:
                System.out.println("Opcion incorrecta.");
                caso=scanner.nextInt();
        }
    }
}
