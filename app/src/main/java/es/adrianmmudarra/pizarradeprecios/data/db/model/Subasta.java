package es.adrianmmudarra.pizarradeprecios.data.db.model;

public class Subasta {
    String fecha_subasta;
    String cooperativa;
    String producto;
    String precios;

    public String getFecha_subasta() {
        return fecha_subasta;
    }

    public void setFecha_subasta(String fecha_subasta) {
        this.fecha_subasta = fecha_subasta;
    }

    public String getCooperativa() {
        return cooperativa;
    }

    public void setCooperativa(String cooperativa) {
        this.cooperativa = cooperativa;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getPrecios() {
        return precios;
    }

    public void setPrecios(String precios) {
        this.precios = precios;
    }

    public Subasta(String fecha_subasta, String cooperativa, String producto, String precios) {
        this.fecha_subasta = fecha_subasta;
        this.cooperativa = cooperativa;
        this.producto = producto;
        this.precios = precios;
    }
}
