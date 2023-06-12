import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Denunciante denunciante = obtenerInformacionDenunciante();
        Vehiculo vehiculo = obtenerInformacionVehiculo();
        Siniestro siniestro = obtenerInformacionSiniestro();

        TipoDanio tipoDanio = obtenerTipoDanio();
        procesarDocumentacion(denunciante, vehiculo, siniestro, tipoDanio);
    }

    private static Denunciante obtenerInformacionDenunciante() {
        System.out.println("Ingrese la informacion del denunciante:");
        String nombre = obtenerEntrada("Nombre");
        String apellido = obtenerEntrada("Apellido");
        String documento = obtenerEntrada("Numero de documento");
        String telefono = obtenerEntrada("Telefono de contacto");
        String correo = obtenerEntrada("Correo electronico");

        return new Denunciante(nombre, apellido, documento, telefono, correo);
    }

    private static Vehiculo obtenerInformacionVehiculo() {
        System.out.println("Ingrese la informacion del vehiculo asegurado involucrado:");
        String marca = obtenerEntrada("Marca");
        String modelo = obtenerEntrada("Modelo");
        int anio = obtenerEntero("Año");
        String patente = obtenerEntrada("Patente");

        return new Vehiculo(marca, modelo, anio, patente);
    }

    private static Siniestro obtenerInformacionSiniestro() {
        System.out.println("Ingrese la informacion del siniestro:");
        String fechaHora = obtenerEntrada("Fecha y hora del accidente");
        String lugar = obtenerEntrada("Lugar donde ocurrio");
        String descripcion = obtenerEntrada("Descripcion del siniestro");
        String danos = obtenerEntrada("Descripcion de los daños sufridos");

        return new Siniestro(fechaHora, lugar, descripcion, danos);
    }

    private static TipoDanio obtenerTipoDanio() {
        System.out.println("Ingrese el tipo de daño:");
        System.out.println("1. Daños a vehiculos");
        System.out.println("2. Daños materiales");
        System.out.println("3. Lesiones");

        int opcion = obtenerEntero("Opcion");

        switch (opcion) {
            case 1:
                return TipoDanio.VEHICULO;
            case 2:
                return TipoDanio.DANIOS_MATERIALES;
            case 3:
                return TipoDanio.LESIONES;
            default:
                System.out.println("Opcion invalida. Seleccionando por defecto: Daños a vehiculos");
                return TipoDanio.VEHICULO;
        }
    }

    private static void procesarDocumentacion(Denunciante denunciante, Vehiculo vehiculo, Siniestro siniestro, TipoDanio tipoDanio) {
        System.out.println("Documentos requeridos:");

        switch (tipoDanio) {
            case VEHICULO:
                procesarDocumentacionVehiculos(denunciante, vehiculo);
                break;
            case DANIOS_MATERIALES:
                procesarDocumentacionDaniosMateriales(denunciante, vehiculo, tipoDanio);
                break;
            case LESIONES:
                procesarDocumentacionLesiones(denunciante, vehiculo, tipoDanio);
                break;
        }
    }

    private static void procesarDocumentacionVehiculos(Denunciante denunciante, Vehiculo vehiculo) {
        System.out.println("Documentación para siniestros de autos o motos:");

        boolean poseeCobertura = obtenerBoolean("¿Posee cobertura de seguro? (s/n)");

        if (poseeCobertura) {
            System.out.println("Documentos requeridos para siniestros con cobertura de seguro:");
            System.out.println("- Denuncia interna");
            System.out.println("- Certificado de cobertura");
        } else {
            System.out.println("Documentos requeridos para siniestros sin cobertura de seguro:");
            System.out.println("- Nota de franquicia emitida por su aseguradora");
        }

        System.out.println("Documentos requeridos para todos los casos:");
        System.out.println("- Licencia de conducir");
        System.out.println("- Tarjeta verde (en caso de no poseer, boleto de compra-venta de la unidad)");
        System.out.println("- Fotos del vehiculo");
        System.out.println("- Presupuestos de reparacion (mano de obra y repuestos)");
    }

    private static void procesarDocumentacionDaniosMateriales(Denunciante denunciante, Vehiculo vehiculo, TipoDanio tipoDanio) {
        System.out.println("Documentacion para siniestros de daños materiales:");

        boolean poseeCobertura = obtenerBoolean("¿Posee cobertura de seguro? (s/n)");

        if (poseeCobertura) {
            System.out.println("Documentos requeridos para siniestros con cobertura de seguro:");
            System.out.println("- Denuncia interna");
            System.out.println("- Certificado de cobertura");
        }

        System.out.println("Documentos requeridos para todos los casos:");
        System.out.println("- Impuesto donde se describa el domicilio del bien dañado y el nombre de su propietario");
        System.out.println("- DNI del propietario del bien dañado");
        System.out.println("- Fotos");
        System.out.println("- Presupuestos de reparacion");
    }

    private static void procesarDocumentacionLesiones(Denunciante denunciante, Vehiculo vehiculo, TipoDanio tipoDanio) {
        System.out.println("Documentación para siniestros de lesiones:");

        boolean poseeCobertura = obtenerBoolean("¿Posee cobertura de seguro? (s/n)");

        if (poseeCobertura) {
            System.out.println("Documentos requeridos para siniestros con cobertura de seguro:");
            System.out.println("- Denuncia interna");
            System.out.println("- Certificado de cobertura");
        }

        System.out.println("Documentos requeridos para todos los casos:");
        System.out.println("- DNI del lesionado");
        System.out.println("- Informe / certificado de centro de salud que realizó la atención");
    }

    private static String obtenerEntrada(String mensaje) {
        System.out.print(mensaje + ": ");
        return scanner.nextLine();
    }

    private static int obtenerEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje + ": ");
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un numero entero valido.");
            }
        }
    }

    private static boolean obtenerBoolean(String mensaje) {
        while (true) {
            String entrada = obtenerEntrada(mensaje);
            if (entrada.equalsIgnoreCase("s")) {
                return true;
            } else if (entrada.equalsIgnoreCase("n")) {
                return false;
            } else {
                System.out.println("Debe ingresar 's' para si o 'n' para no.");
            }
        }
    }
}

class Denunciante {
    private String nombre;
    private String apellido;
    private String documento;
    private String telefono;
    private String correo;

    public Denunciante(String nombre, String apellido, String documento, String telefono, String correo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.telefono = telefono;
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDocumento() {
        return documento;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }
}

class Vehiculo {
    private String marca;
    private String modelo;
    private int anio;
    private String patente;

    public Vehiculo(String marca, String modelo, int anio, String patente) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.patente = patente;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAnio() {
        return anio;
    }

    public String getPatente() {
        return patente;
    }
}

class Siniestro {
    private String fechaHora;
    private String lugar;
    private String descripcion;
    private String danos;

    public Siniestro(String fechaHora, String lugar, String descripcion, String danos) {
        this.fechaHora = fechaHora;
        this.lugar = lugar;
        this.descripcion = descripcion;
        this.danos = danos;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public String getLugar() {
        return lugar;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getDanos() {
        return danos;
    }
}

enum TipoDanio {
    VEHICULO,
    DANIOS_MATERIALES,
    LESIONES
}
