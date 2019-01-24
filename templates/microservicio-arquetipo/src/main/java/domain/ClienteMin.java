package ${project_package}.domain;

import java.util.Date;

public class ClienteMin {

    private Integer id;
    private Date fecha_registro;
    private String nombre_completo;
    private String sexo;
    private String dni;
    private String celular;
    private String correo;
    private String comprobante;
    private String proveedor;
    private String empresa;
    private String check_recibir;

    public ClienteMin() {
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
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

    public String getCheck_recibir() {
        return check_recibir;
    }

    public void setCheck_recibir(String check_recibir) {
        this.check_recibir = check_recibir;
    }

    @Override
    public String toString() {
        return "ClienteMin{" +
                "id=" + id +
                ", fecha_registro=" + fecha_registro +
                ", nombre_completo='" + nombre_completo + '\'' +
                ", sexo='" + sexo + '\'' +
                ", dni='" + dni + '\'' +
                ", celular='" + celular + '\'' +
                ", correo='" + correo + '\'' +
                ", comprobante='" + comprobante + '\'' +
                ", proveedor='" + proveedor + '\'' +
                ", empresa='" + empresa + '\'' +
                ", check_recibir='" + check_recibir + '\'' +
                '}';
    }
}
