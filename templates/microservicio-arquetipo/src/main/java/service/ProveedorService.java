package ${project_package}.service;



import ${project_package}.domain.Proveedor;

import java.util.List;

public interface ProveedorService {

    List<Proveedor> lstProveedor();
    public abstract Proveedor findProveedorById(Integer id);
}

