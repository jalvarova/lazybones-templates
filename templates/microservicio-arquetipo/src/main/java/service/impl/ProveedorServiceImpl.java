package ${project_package}.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ${project_package}.domain.Proveedor;
import ${project_package}.repository.ProveedorRepository;
import ${project_package}.service.ProveedorService;


import java.util.ArrayList;
import java.util.List;


@Service("proveedorServiceImpl")
public class ProveedorServiceImpl implements ProveedorService {

    @Autowired
    @Qualifier("proveedorRepository")
    private ProveedorRepository proveedorRepository;

    @Override
    public List<Proveedor> lstProveedor() {
        List<Proveedor> proveedores = (List<Proveedor>) proveedorRepository.findAll();
        List<Proveedor> lstProveedor = new ArrayList<Proveedor>();

        for(Proveedor proveedor : proveedores){
            lstProveedor.add(proveedor);
        }
        return lstProveedor;
    }

    @Override
    public Proveedor findProveedorById(Integer id) {
        return proveedorRepository.findById(id);
    }
}
