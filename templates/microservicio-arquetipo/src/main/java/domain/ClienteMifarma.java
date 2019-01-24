package ${project_package}.domain;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "cliente_mifarma")
public class ClienteMifarma {
    @Id
    @GeneratedValue
    @Column(name="id")
    private Integer id;
    @Column(name="fecha_registro", nullable = false, updatable = false)
    @CreationTimestamp
    private Date fecha_registro;
    @Column(name="nombres")
    private String nombres;
    @Column(name="apellidos")
    private String apellidos;
    @Column(name="direccion")
    private String direccion;
    @Column(name="provincia")
    private String provincia;
    @Column(name="dni")
    @Size(min=8, max=8)
    private String dni;
    @Column(name="celular")
    private String celular;
    @Column(name="correo")
    private String correo;
    @Column(name="comprobante", unique=true,nullable = false)
    private String comprobante;
    @Column(name="id_proveedor")
    private Integer id_proveedor;
    @Column(name="id_empresa")
    private Integer id_empresa;

    public ClienteMifarma() {
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

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
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

    public Integer getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(Integer id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public Integer getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(Integer id_empresa) {
        this.id_empresa = id_empresa;
    }

	@Override
	public String toString() {
		return "ClienteMifarma [id=" + id + ", fecha_registro=" + fecha_registro + ", nombres=" + nombres
				+ ", apellidos=" + apellidos + ", direccion=" + direccion + ", provincia=" + provincia + ", dni=" + dni
				+ ", celular=" + celular + ", correo=" + correo + ", comprobante=" + comprobante + ", id_proveedor="
				+ id_proveedor + ", id_empresa=" + id_empresa + "]";
	}
    
    
}
