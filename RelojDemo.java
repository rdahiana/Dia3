import java.util.Scanner;

public class RelojDemo {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        System.out.println("Ingrese el valor del tiempo en segundos desde la medianoche: ");
        int segMediaNoche = read.nextInt();

        // Crear un objeto Reloj con el tiempo proporcionado por el usuario
        Reloj miReloj = new Reloj(segMediaNoche);

        // Validar el tiempo ingresado
        if (miReloj.validarHoras(miReloj.horas) && miReloj.validarMinutos(miReloj.minutos) && miReloj.validarSegundos(miReloj.segundos)) {
            // Mostrar la hora actual
            System.out.println("Hora actual: " + miReloj.toString());

            // Simular el paso del tiempo durante 10 segundos
            for (int i = 0; i < 10; i++) {
                miReloj.tick();
            }

            // Mostrar la hora después de simular el paso del tiempo
            System.out.println("Hora después de simular el paso del tiempo: " + miReloj.toString());

            // Crear otro objeto Reloj con un tiempo específico
            Reloj otroReloj = new Reloj(17, 14, 28);

            // Calcular y mostrar la diferencia de tiempo
            miReloj.restaReloj(otroReloj);
        } else {
            System.out.println("El horario ingresado no es válido");
        }

    }
}
