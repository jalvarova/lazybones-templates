package ${project_package}.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ${project_package}.domain.Cliente;
import ${project_package}.repository.ClienteRepository;
import ${project_package}.service.ClienteService;



import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    @Qualifier("clienteRepository")
    private ClienteRepository clienteRepository;

    @Override
    public Cliente addCliente(Cliente cliente) {
        Cliente objCliente = clienteRepository.save(cliente);
        return objCliente;
    }

    @Override
    public List<Cliente> lstClientes() {
        List<Cliente> clientes = (List<Cliente>) clienteRepository.findAll();
        List<Cliente> lstCliente = new ArrayList<Cliente>();

        for(Cliente cliente : clientes){
            lstCliente.add(cliente);
        }
        return lstCliente;
    }

    @Override
    public List<Cliente> lstClientesPorProveedor(int id_proveedor) {
        List<Cliente> clientes = clienteRepository.findById_proveedor(id_proveedor);
        List<Cliente> lstCliente = new ArrayList<Cliente>();

        for (Cliente cliente: clientes){
            lstCliente.add(cliente);
        }
        return lstCliente;
    }

    @Override
    public List<Cliente> lstClientesPorEmpresa(int id_empresa) {
        List<Cliente> clientes = clienteRepository.findById_empresa(id_empresa);
        List<Cliente> lstCliente = new ArrayList<Cliente>();

        for (Cliente cliente: clientes){
            lstCliente.add(cliente);
        }
        return lstCliente;
    }
}
