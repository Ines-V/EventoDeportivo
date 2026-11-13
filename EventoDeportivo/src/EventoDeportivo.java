public class EventoDeportivo {
    private String nombre;
    private String deporte;
    private int participantes;
    private String dia;
    private String mes;
    private String ano;

    public EventoDeportivo(String nombre, String deporte, int participantes, String dia, String mes, String ano) {
        this.nombre = nombre;
        this.deporte = deporte;
        this.participantes = participantes;
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDeporte() { return deporte; }
    public void setDeporte(String deporte) { this.deporte = deporte; }

    public int getParticipantes() { return participantes; }
    public void setParticipantes(int participantes) { this.participantes = participantes; }

    public String getDia() { return dia; }
    public void setDia(String dia) { this.dia = dia; }

    public String getMes() { return mes; }
    public void setMes(String mes) { this.mes = mes; }

    public String getAno() { return ano; }
    public void setAno(String ano) { this.ano = ano; }

    @Override
    public String toString() {
        return "Evento: " + nombre +
                ". Deporte: " + deporte +
                ". Número de participantes: " + participantes +
                ". Fecha: " + dia + "/" + mes + "/" + ano;
    }
}