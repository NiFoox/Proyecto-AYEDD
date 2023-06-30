
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

public class Siniestros {
    String lugar, descripcion, hora;
    int daño;
    SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
    String fecha = formatoFecha.format(new Date());

    public Siniestros() {

    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setHora(LocalTime hora2) {
    }

    public int getDaño() {
        return daño;
    }

    public void setDaño(int daño) {
        this.daño = daño;
    }

}