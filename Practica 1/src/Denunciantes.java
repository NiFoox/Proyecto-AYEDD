
public class Denunciantes {
    String nombre, apellido, correo, numtel;
    int dni;

    public static void main(String[] args) {

    }

    public Denunciantes() {

    }

    public Denunciantes(String nombre, String apellido, String correo, int dni, String numtel) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.dni = dni;
        this.numtel = numtel;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public void setNumtel(String numtel) {
        this.numtel = numtel;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public int getDni() {
        return dni;
    }

    public String getNumtel() {
        return numtel;
    }

}
