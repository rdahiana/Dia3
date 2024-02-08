
public class Reloj {
    int horas;
    int minutos;
    int segundos;
    //CONSTRUCTORES

    public Reloj() {
        this.horas = 12;
        this.minutos = 00;
        this.segundos = 00;
    }

    public Reloj(int horas, int minutos, int segundos) {
        this.horas = horas;
        this.minutos = minutos ;
        this.segundos = segundos;
    }

    public Reloj(int segundosDesdeMedianoche) {
        this.horas = segundosDesdeMedianoche / 3600;
        this.minutos = (segundosDesdeMedianoche % 3600) / 60;
        this.segundos = segundosDesdeMedianoche % 60;

    }

    //VALIDAMOS LOS RANGOS
    public boolean validarHoras(int horas) {
        // Validar el rango (por ejemplo, de 0 a 100)
        if (horas >= 0 && horas <= 23) {
            this.horas = horas;
            return true;
        } else {
            return false;
        }
    }

    public boolean validarMinutos(int minutos) {
        // Validar el rango (por ejemplo, de 0 a 100)
        if (horas >= 0 && horas <= 59) {
            this.minutos = minutos;
            return true;
        } else {
            return false;
        }
    }

    public boolean validarSegundos(int segundos) {
        // Validar el rango (por ejemplo, de 0 a 100)
        if (horas >= 0 && horas <= 59) {
            this.segundos = segundos;
            return true;
        } else {
            return false;
        }
    }

    //METODOS

    //GETTERS Y SETTERS


    public int getHoras() {
        return horas;
    }

    public int getMinutos() {
        return minutos;
    }

    public int getSegundos() {
        return segundos;
    }

    public void setSegundos(int segundos) {
        this.segundos = segundos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }
    public void tick() {
        if (this.segundos == 59) {
            this.segundos = 00;
        } else {
            this.segundos += 1;
        }
    }
    public void addReloj(Reloj otroReloj) {
        this.segundos += otroReloj.segundos;
        this.minutos += otroReloj.minutos;
        this.horas += otroReloj.horas;

        if (this.segundos >= 60) {
            this.minutos += this.segundos / 60;
            this.segundos %= 60;
        }

        // Ajuste si los minutos superan 59
        if (this.minutos >= 60) {
            this.horas += this.minutos / 60;
            this.minutos %= 60;
        }

        // Ajuste si las horas superan 23
        if (this.horas >= 24) {
            this.horas %= 24;
        }
    }
    @Override
    public java.lang.String toString() {
        return "[" +
                + this.horas +
                ":" + this.minutos +
                ":" + this.segundos +
                "]";
    }
    public void tickDecrement() {
        if (this.segundos == 00) {
            this.segundos = 59;
        } else {
            this.segundos += 1;
        }
    }

    public void restaReloj(Reloj otroReloj) {
        int diferenciaHoras;
        int diferenciaMinutos;
        int diferenciaSegundos;


        if (this.horas > otroReloj.horas){
            diferenciaHoras = this.horas - otroReloj.horas;
            diferenciaMinutos = this.minutos - otroReloj.minutos;
            diferenciaSegundos = this.segundos - otroReloj.segundos;
        }else {
            diferenciaHoras = otroReloj.horas - this.horas;
            diferenciaMinutos = otroReloj.minutos - this.minutos;
            diferenciaSegundos = otroReloj.segundos - this.segundos;
        }

        if (diferenciaSegundos<0){
            diferenciaSegundos += 60;
            diferenciaMinutos -=1;
        }
        if (diferenciaMinutos<0){
            diferenciaMinutos += 60;
            diferenciaHoras -= 1;
        }

        // Asignar la nueva diferencia de tiempo al objeto de reloj actual
        this.horas = diferenciaHoras;
        this.minutos = diferenciaMinutos;
        this.segundos = diferenciaSegundos;

        // Mostrar la diferencia de tiempo
        System.out.println("La diferencia del tiempo es de " + diferenciaHoras + ":" + diferenciaMinutos + ":" + diferenciaSegundos);
    }
}
