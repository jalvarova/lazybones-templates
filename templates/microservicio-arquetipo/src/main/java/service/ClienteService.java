package ${project_package}.service;



import ${project_package}.domain.Cliente;

import java.util.List;

public interface ClienteService {

    Cliente addCliente(Cliente cliente);
     List<Cliente> lstClientes();
     List<Cliente> lstClientesPorProveedor(int id_proveedor);
     List<Cliente> lstClientesPorEmpresa(int id_empresa);

}
