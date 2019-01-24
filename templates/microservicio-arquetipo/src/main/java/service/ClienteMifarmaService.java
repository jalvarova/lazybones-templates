package ${project_package}.service;



import ${project_package}.domain.ClienteMifarma;

import java.util.List;

public interface ClienteMifarmaService {

    public abstract ClienteMifarma addCliente(ClienteMifarma cliente_mifarma);
    public abstract List<ClienteMifarma> lstClientes();
    public abstract List<ClienteMifarma> lstClientesPorProveedor(int id_proveedor);
    public abstract List<ClienteMifarma> lstClientesPorEmpresa(int id_empresa);

}
