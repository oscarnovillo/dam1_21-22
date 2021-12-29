package personas.dao.modelo;

// POJO

public class Persona {

    private String nombre;
    private String dni;
    private String apellido;
    private boolean vivo;
    private int asesinados;

    private Persona()
    {
        asesinados = 0;
        vivo =true;
    }

    public Persona(String nombre, String dni, String apellido) {
        this();
        this.nombre = nombre;
        this.dni = dni;
        this.apellido = apellido;

    }

    public Persona(String nombre, String apellido) {
        this(nombre,"hj",apellido);
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public boolean isVivo() {
        return vivo;
    }

    public void setVivo(boolean vivo) {
        this.vivo = vivo;
    }

    @Override
    public String toString() {
        return "{" +
                "nombre='" + nombre + "'" +
                ", dni='" + dni + '\'' +
                ", apellido='" + apellido + '\'' +
                ", vivo='" + vivo + '\'' +
                '}';
    }
}
