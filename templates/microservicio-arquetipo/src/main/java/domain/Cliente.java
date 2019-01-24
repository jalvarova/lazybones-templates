package ${project_package}.domain;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue
    @Column(name="id")
    private Integer id;
    @Column(name="fecha_registro", nullable = false, updatable = false)
    @CreationTimestamp
    private Date fecha_registro;
    @Column(name="nombres")
    private String nombres;
    @Column(name="sexo")
    private String sexo;
    @Column(name="apeMaterno")
    private String apeMaterno;
    @Column(name="apePaterno")
    private String apePaterno;
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
    @Column(name = "check_recibir",nullable = false, columnDefinition = "bit default 0")
    private boolean check_recibir;

    public Cliente() {
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getApeMaterno() {
        return apeMaterno;
    }

    public void setApeMaterno(String apeMaterno) {
        this.apeMaterno = apeMaterno;
    }

    public String getApePaterno() {
        return apePaterno;
    }

    public void setApePaterno(String apePaterno) {
        this.apePaterno = apePaterno;
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

	public boolean isCheck_recibir() {
		return check_recibir;
	}

	public void setCheck_recibir(boolean check_recibir) {
		this.check_recibir = check_recibir;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", fecha_registro=" + fecha_registro + ", nombres=" + nombres + ", sexo=" + sexo
				+ ", apeMaterno=" + apeMaterno + ", apePaterno=" + apePaterno + ", dni=" + dni + ", celular=" + celular
				+ ", correo=" + correo + ", comprobante=" + comprobante + ", id_proveedor=" + id_proveedor
				+ ", id_empresa=" + id_empresa + ", check_recibir=" + check_recibir + "]";
	}
   

}
