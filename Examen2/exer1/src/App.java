import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        HashMap<String, Hotel> registroHoteles = new HashMap<>();
        final DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        boolean menuActivo = true;
        while (menuActivo) {
            System.out.println("a) Dar de alta un hotel");
            System.out.println("b) Dar de alta unha habitación nun hotel");
            System.out.println("c) Buscador de habitacións libres nun hotel");
            System.out.println("d) Reservar unha habitación nun hotel");
            System.out.println("e) Ver porcentaxe de ocupación dun determinado día nun hotel");
            System.out.println("s) Sair");

            String opcion = sc.nextLine();

            // Inicializando variables.
            Hotel hotelNow = null;
            switch (opcion) {

                // a) Dar de alta un hotel
                case "a" -> {
                    System.out.print("Introduzca el nombre del hotel: ");
                    String nombreNewHotel = sc.nextLine();
                    Hotel newHotel = new Hotel(nombreNewHotel);
                    registroHoteles.put(nombreNewHotel, newHotel);
                }

                // b) Dar de alta unha habitación nun hotel
                case "b" -> {
                    // Mostrando nombres de hoteles.
                    int i = 1;
                    for (String nombre : registroHoteles.keySet()) {
                        System.out.println(i + ": " + nombre);
                        i++;
                    }

                    // Recibiendo el hotel que desea.
                    int opcionHotel = 0;
                    while (opcionHotel <= 0 || opcionHotel > registroHoteles.keySet().size()) {
                        System.out.print("Introduzca el hotel en el que desee dar de alta una habitación: ");
                        opcionHotel = sc.nextInt();
                        sc.nextLine();
                    }

                    // Escogiendo dicho hotel.
                    int j = 1;
                    for (String clave : registroHoteles.keySet()) {
                        if (j == opcionHotel) {
                            hotelNow = registroHoteles.get(clave);
                            break;
                        }
                        j++;
                    }

                    // Recibiendo número de habitación.
                    int nuevoNumeroHabitacion = 0;
                    do {
                        System.out.print("Introduzca el número de habitación: ");
                        nuevoNumeroHabitacion = sc.nextInt();
                        sc.nextLine();
                    } while (!hotelNow.comprobarNumeroHabitacion(nuevoNumeroHabitacion));

                    // Recibiendo tipo de habitación.
                    int tipoHabitacion = 0;
                    do {
                        System.out.println("Introduzca el tipo de habitación: ");
                        System.out.println("1) Individual.");
                        System.out.println("2) Doble.");
                        System.out.println("3) Triple.");
                        tipoHabitacion = sc.nextInt();
                        sc.nextLine();
                    } while (tipoHabitacion <= 0 || tipoHabitacion > 3);

                    // Recibiendo precio por noche.
                    double precioPorNoche = 0;
                    do {
                        System.out.print("Introduzca el precio por noche: ");
                        precioPorNoche = sc.nextDouble();
                        sc.nextLine();
                    } while (precioPorNoche <= 0);

                    // Crear y añadir habitación en hotel.
                    hotelNow.añadirHabitacion(nuevoNumeroHabitacion, tipoHabitacion, precioPorNoche);
                }

                // c) Buscador de habitacións libres nun hotel
                case "c" -> {
                    // Mostrando nombres de hoteles.
                    int i = 1;
                    for (String nombre : registroHoteles.keySet()) {
                        System.out.println(i + ": " + nombre);
                        i++;
                    }

                    // Recibiendo el hotel que desea.
                    int opcionHotel = 0;
                    while (opcionHotel <= 0 || opcionHotel > registroHoteles.keySet().size()) {
                        System.out.print("Introduzca el hotel en el que desee ver las habitaciones libres: ");
                        opcionHotel = sc.nextInt();
                        sc.nextLine();
                    }

                    // Escogiendo dicho hotel.
                    int j = 1;
                    for (String clave : registroHoteles.keySet()) {
                        if (j == opcionHotel) {
                            hotelNow = registroHoteles.get(clave);
                            break;
                        }
                        j++;
                    }

                    // Recibiendo tipo de habitación.
                    int tipoHabitacion = 0;
                    do {
                        System.out.println("Introduzca el tipo de habitación: ");
                        System.out.println("1) Individual.");
                        System.out.println("2) Doble.");
                        System.out.println("3) Triple.");
                        tipoHabitacion = sc.nextInt();
                        sc.nextLine();
                    } while (tipoHabitacion <= 0 || tipoHabitacion > 3);

                    // Obteniendo lista con habitaciones según el tipo.
                    //ArrayList<Habitacion> habitacionesSegunTipo = hotelNow.getHabitacionesSegunTipo(tipoHabitacion);

                    // Recibiendo fechas de entrada y salida.
                    String fchEntrada;
                    String fchSalida;
                    do {
                        System.out.print("Introduzca la fecha de entrada (dd/MM/yyyy): ");
                        fchEntrada = sc.nextLine();
                        System.out.print("Introduzca la fecha de salida (dd/MM/yyyy): ");
                        fchSalida = sc.nextLine();
                    } while (!(LocalDate.parse(fchSalida, formato).isAfter(LocalDate.parse(fchEntrada, formato))));

                    // Mostrando habitaciones posibles.
                    /*
                     * if (habitacionesSegunTipo.size() == 0) {
                     * System.out.println("No hay habitaciones disponibles.");
                     * } else {
                     */
                    int k = 1;
                    ArrayList<Habitacion> habitacionesDisponibles = hotelNow.getReservas(tipoHabitacion,fchEntrada,fchSalida);
                    if (habitacionesDisponibles.size() == 0) {
                        System.out.println("No hay habitaciones disponibles.");
                    }
                    else{
                        System.out.println("Habitaciones disponibles: ");
                        for (Habitacion habitacion : habitacionesDisponibles) {
                            System.out.println(k + ": " + habitacion.getNumHabitacion());
                        }
                    }
                    /*int sumando = 0;
                    int k = 1;
                    System.out.println("Habitaciones disponibles: ");
                    for (Habitacion habitacion : habitacionesSegunTipo) {
                        if (habitacion.getReservas().size() == 0) {
                            System.out.println(k + ": " + habitacion.getNumHabitacion());
                            sumando++;
                        } else {
                            for (Reserva reserva : habitacion.getReservas()) {
                                if (reserva.comprobarFechas(fchEntrada, fchSalida)) {
                                    System.out.println(k + ": " + habitacion.getNumHabitacion());
                                    sumando++;
                                }
                            }

                        }
                    }
                    if (sumando == 0) {
                        System.out.println("No hay habitaciones disponibles.");
                    }*/
                    // }

                }

                // d) Reservar unha habitación nun hotel
                case "d" -> {
                    // Mostrando nombres de hoteles.
                    int i = 1;
                    for (String nombre : registroHoteles.keySet()) {
                        System.out.println(i + ": " + nombre);
                        i++;
                    }

                    // Recibiendo el hotel que desea.
                    int opcionHotel = 0;
                    while (opcionHotel <= 0 || opcionHotel > registroHoteles.keySet().size()) {
                        System.out.print("Introduzca el hotel en el que desee hacer una reserva: ");
                        opcionHotel = sc.nextInt();
                        sc.nextLine();
                    }

                    // Escogiendo dicho hotel.
                    int j = 1;
                    for (String clave : registroHoteles.keySet()) {
                        if (j == opcionHotel) {
                            hotelNow = registroHoteles.get(clave);
                            break;
                        }
                        j++;
                    }

                    String nombreReserva = null;
                    int numeroHabitacionReserva = 0;
                    String fechaEntradaReserva = null;
                    String fechaSalidaReserva = null;
                    while (true) {
                        System.out.print("Introduzca a nombre de quien va a ser la reserva: ");
                        nombreReserva = sc.nextLine();
                        System.out.print("Introduzca el número de la habitación que desee reservar: ");
                        numeroHabitacionReserva = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Introduzca la fecha de entrada de la reserva (dd/MM/yyyy): ");
                        fechaEntradaReserva = sc.nextLine();
                        System.out.print("Introduzca la fecha de salida de la reserva (dd/MM/yyyy): ");
                        fechaSalidaReserva = sc.nextLine();
                        if (!hotelNow.comprobarReservaGeneral(numeroHabitacionReserva, fechaEntradaReserva,
                                fechaSalidaReserva)) {
                            System.out.println("No se pudo realizar la reserva.");
                        } else {
                            // Creando y añadiendo reserva de habitación en el hotel indicado.
                            Reserva newReserva = new Reserva(nombreReserva, fechaEntradaReserva, fechaSalidaReserva);
                            hotelNow.añadirReservaEnHotel(numeroHabitacionReserva, newReserva);
                            System.out.println("Reserva realizada con éxito.");
                            break;
                        }
                    }

                    /*
                     * // Recibiendo nombre de persona que reserva y número de habitación a
                     * reservar.
                     * String nombreReserva;
                     * int numeroHabitacionReserva = 0;
                     * do {
                     * System.out.print("Introduzca a nombre de quien va a ser la reserva: ");
                     * nombreReserva = sc.nextLine();
                     * System.out.print("Introduzca el número de la habitación que desee reservar: "
                     * );
                     * numeroHabitacionReserva = sc.nextInt();
                     * sc.nextLine();
                     * } while
                     * (!hotelNow.comprobarNumeroHabitacionReserva(numeroHabitacionReserva));
                     * 
                     * // Recibiendo fechas de entrada y salida de la reserva.
                     * String fechaEntradaReserva;
                     * String fechaSalidaReserva;
                     * do {
                     * System.out.
                     * print("Introduzca la fecha de entrada de la reserva (dd/MM/yyyy): ");
                     * fechaEntradaReserva = sc.nextLine();
                     * System.out.print("Introduzca la fecha de salida de la reserva (dd/MM/yyyy): "
                     * );
                     * fechaSalidaReserva = sc.nextLine();
                     * } while (!hotelNow.comprobarReservasHabitacionHotel(numeroHabitacionReserva,
                     * fechaEntradaReserva,
                     * fechaSalidaReserva));
                     * 
                     * // Creando y añadiendo reserva de habitación en el hotel indicado.
                    Reserva newReserva = new Reserva(nombreReserva, fechaEntradaReserva, fechaSalidaReserva);
                    hotelNow.añadirReservaEnHotel(numeroHabitacionReserva, newReserva);
                     */

                    
                }

                // e) Ver porcentaxe de ocupación dun determinado día nun hotel
                case "e" -> {
                    // Mostrando nombres de hoteles.
                    int i = 1;
                    for (String nombre : registroHoteles.keySet()) {
                        System.out.println(i + ": " + nombre);
                        i++;
                    }

                    // Recibiendo el hotel que desea.
                    int opcionHotel = 0;
                    while (opcionHotel <= 0 || opcionHotel > registroHoteles.keySet().size()) {
                        System.out.print("Introduzca el hotel en el que desee ver el porcentaje de ocupación: ");
                        opcionHotel = sc.nextInt();
                        sc.nextLine();
                    }

                    // Escogiendo dicho hotel.
                    int j = 1;
                    for (String clave : registroHoteles.keySet()) {
                        if (j == opcionHotel) {
                            hotelNow = registroHoteles.get(clave);
                            break;
                        }
                        j++;
                    }
                    System.out.print("Introduce un día para obtener el porcentaje de ocupación: ");
                    String diaPorcentaje = sc.nextLine();

                    // Calculando porcentaje.
                    double porcentajeOcupacion = hotelNow.calcularPorcentajeOcupacionHotel(diaPorcentaje);
                    System.out.println("El porcentaje de ocupación es: " + porcentajeOcupacion + "%.");
                }

                case "s" -> {
                    System.out.println("Saindo");
                    menuActivo = false;
                }

                default -> System.out.println("Opcion inválida");

            }
        }
        sc.close(); // Cerramos o teclado

    }
}
