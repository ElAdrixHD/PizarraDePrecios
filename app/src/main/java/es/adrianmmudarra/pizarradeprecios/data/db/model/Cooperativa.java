package es.adrianmmudarra.pizarradeprecios.data.db.model;

public class Cooperativa {
    String nombre_cooperativa;
    String dirección;
    String num_telefono;
    String email;
    String foto;


    public Cooperativa(String nombre_cooperativa, String dirección, String num_telefono, String email, String foto) {
        this.nombre_cooperativa = nombre_cooperativa;
        this.dirección = dirección;
        this.num_telefono = num_telefono;
        this.email = email;
        this.foto = foto;
    }

    public String getNombre_cooperativa() {
        return nombre_cooperativa;
    }

    public void setNombre_cooperativa(String nombre_cooperativa) {
        this.nombre_cooperativa = nombre_cooperativa;
    }

    public String getDirección() {
        return dirección;
    }

    public void setDirección(String dirección) {
        this.dirección = dirección;
    }

    public String getNum_telefono() {
        return num_telefono;
    }

    public void setNum_telefono(String num_telefono) {
        this.num_telefono = num_telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
