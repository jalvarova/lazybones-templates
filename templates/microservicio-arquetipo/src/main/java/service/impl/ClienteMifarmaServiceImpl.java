package ${project_package}.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ${project_package}.domain.ClienteMifarma;
import ${project_package}.repository.ClienteMifarmaRepository;
import ${project_package}.service.ClienteMifarmaService;


import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteMifarmaServiceImpl implements ClienteMifarmaService {
    @Autowired
    @Qualifier("clienteMifarmaRepository")
    private ClienteMifarmaRepository clienteMifarmaRepository;

    @Override
    public ClienteMifarma addCliente(ClienteMifarma cliente_mifarma) {
        ClienteMifarma objCliente = clienteMifarmaRepository.save(cliente_mifarma);
        return objCliente;
    }

    @Override
    public List<ClienteMifarma> lstClientes() {
        List<ClienteMifarma> clientes_mifarma = (List<ClienteMifarma>) clienteMifarmaRepository.findAll();
        List<ClienteMifarma> lstCliente = new ArrayList<ClienteMifarma>();

        for(ClienteMifarma cliente_mifarma : clientes_mifarma){
            lstCliente.add(cliente_mifarma);
        }
        return lstCliente;
    }

    @Override
    public List<ClienteMifarma> lstClientesPorProveedor(int id_proveedor) {
        List<ClienteMifarma> clientes_mifarma = clienteMifarmaRepository.findById_proveedor(id_proveedor);
        List<ClienteMifarma> lstCliente = new ArrayList<ClienteMifarma>();

        for (ClienteMifarma cliente: clientes_mifarma){
            lstCliente.add(cliente);
        }
        return lstCliente;
    }

    @Override
    public List<ClienteMifarma> lstClientesPorEmpresa(int id_empresa) {
        List<ClienteMifarma> clientes_mifarma = clienteMifarmaRepository.findById_empresa(id_empresa);
        List<ClienteMifarma> lstCliente = new ArrayList<ClienteMifarma>();

        for (ClienteMifarma cliente: clientes_mifarma){
            lstCliente.add(cliente);
        }
        return lstCliente;
    }
}
