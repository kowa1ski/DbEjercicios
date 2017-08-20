package BSHELPER;

/**
 * Created by Usuario on 20/08/2017.
 */

public class usuarios {


    // creamos las variables de las que consta la clase.
    private int usuario, edad;
    private String nombre, apellidos;

    // generamos el constructor automáticamente con clic derecho y generate constructor.
    public usuarios(int usuario, int edad, String nombre, String apellidos) {

        /* Esto lo dejo comentado porque lo ha generado sólo pero no le veo sentido y
        de hecho, parece que es totalmente innecesario porque se van a tratar
        las variables en métodos fuera de este así que se mandan así tal cual
        en crudo.

        this.usuario = usuario;
        this.edad = edad;
        this.nombre = nombre;
        this.apellidos = apellidos;
        */

        setApellidos(apellidos);
        setEdad(edad);
        setNombre(nombre);
        setUsuario(usuario);

    }

    // generamos los getters y setters de manera automática
    // con generate.


    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
}
