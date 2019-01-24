package ${project_package}.domain;

import java.util.Date;

public class ClienteMifarmaMin {

    private Integer id;
    private Date fecha_registro;
    private String nombre_completo;
    private String direccion;
    private String provincia;
    private String dni;
    private String celular;
    private String correo;
    private String comprobante;
    private String proveedor;
    private String empresa;

    public ClienteMifarmaMin() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public String getNombre_completo() {
        return nombre_completo;
    }

    public void setNombre_completo(String nombre_completo) {
        this.nombre_completo = nombre_completo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getComprobante() {
        return comprobante;
    }

    public void setComprobante(String comprobante) {
        this.comprobante = comprobante;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    @Override
    public String toString() {
        return "ClienteMifarmaMin{" +
                "id=" + id +
                ", fecha_registro=" + fecha_registro +
                ", nombre_completo='" + nombre_completo + '\'' +
                ", direccion='" + direccion + '\'' +
                ", provincia='" + provincia + '\'' +
                ", dni='" + dni + '\'' +
                ", celular='" + celular + '\'' +
                ", correo='" + correo + '\'' +
                ", comprobante='" + comprobante + '\'' +
                ", proveedor='" + proveedor + '\'' +
                ", empresa='" + empresa + '\'' +
                '}';
    }
}
