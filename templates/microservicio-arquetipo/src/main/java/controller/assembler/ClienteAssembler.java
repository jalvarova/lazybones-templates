package ${project_package}.controller.assembler;

import ${project_package}.domain.Cliente;
import ${project_package}.domain.ClienteMifarma;
import ${project_package}.domain.ClienteMin;

import java.util.ArrayList;
import java.util.List;


public class ClienteAssembler {

	public static List<ClienteMin> toDTO (List<Cliente> lstCliente) {
		
		List<ClienteMin> lstClienteMin = new ArrayList<>();
		
		for(Cliente cliente: lstCliente) {
			ClienteMin clienteMin = new ClienteMin();
			clienteMin.setCelular(cliente.getCelular());
			clienteMin.setCheck_recibir(cliente.isCheck_recibir()==true?"SI":"NO");
			clienteMin.setComprobante(cliente.getComprobante());
			clienteMin.setCorreo(cliente.getCorreo());
			clienteMin.setDni(cliente.getDni());
			clienteMin.setEmpresa(cliente.getId_empresa()==1?"INKAFARMA":"MIFARMA");
			clienteMin.setFecha_registro(cliente.getFecha_registro());
			clienteMin.setId(cliente.getId());
			clienteMin.setNombre_completo(cliente.getNombres()+" "+cliente.getApePaterno()+" "+cliente.getApeMaterno());
			
			if(cliente.getId_proveedor()==1) {
				clienteMin.setProveedor("ROCHEPOSAY");
			}else if(cliente.getId_proveedor()==2) {
				clienteMin.setProveedor("ABBOTT");
			}else clienteMin.setProveedor("INKAFARMA");

			clienteMin.setSexo(cliente.getSexo());
			lstClienteMin.add(clienteMin);
		}
		
		
		
		return lstClienteMin;
		
	}
	
	public static List<ClienteMin> toDTOMiFarma(List<ClienteMifarma> lstCliente) {
		
		List<ClienteMin> lstClienteMin = new ArrayList<>();
		
		for(ClienteMifarma cliente: lstCliente) {
			ClienteMin clienteMin = new ClienteMin();
			clienteMin.setCelular(cliente.getCelular());
			clienteMin.setComprobante(cliente.getComprobante());
			clienteMin.setCorreo(cliente.getCorreo());
			clienteMin.setDni(cliente.getDni());
			clienteMin.setEmpresa(cliente.getId_empresa()==1?"INKAFARMA":"MIFARMA");
			clienteMin.setFecha_registro(cliente.getFecha_registro());
			clienteMin.setId(cliente.getId());
			clienteMin.setNombre_completo(cliente.getNombres()+" "+cliente.getApellidos());
			if(cliente.getId_proveedor()==1) {
				clienteMin.setProveedor("ROCHEPOSAY");
			}else if(cliente.getId_proveedor()==2) {
				clienteMin.setProveedor("ABBOTT");
			}else clienteMin.setProveedor("INKAFARMA");
			
			lstClienteMin.add(clienteMin);
		}
		
		return lstClienteMin;
		
	}
	
}
