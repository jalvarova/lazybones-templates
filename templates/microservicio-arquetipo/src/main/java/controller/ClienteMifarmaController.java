package ${project_package}.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;

import ${project_package}.controller.assembler.ClienteAssembler;
import ${project_package}.domain.ClienteMifarma;
import ${project_package}.domain.ClienteMin;
import ${project_package}.domain.ExcelClientesListReportMifarma;
import ${project_package}.service.ClienteMifarmaService;

import java.util.List;


@RestController
@RequestMapping("/cliente_mifarma")
public class ClienteMifarmaController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    @Qualifier("clienteMifarmaServiceImpl")
    private ClienteMifarmaService clienteMifarmaService;

    @GetMapping("/hi")
    public String hi() {
        return "hi";
    }

    @PostMapping(path = "/addcliente", consumes = "application/json", produces = "application/json")
    public void addClienteMifarma(@RequestBody ClienteMifarma cliente){
        logger.info("METHOD: addClienteMifarma() -- PARAMS: "+ cliente.toString());
        clienteMifarmaService.addCliente(cliente);
    }

    @GetMapping("/clientes")
    public List<ClienteMin> showClientes(){
    	ClienteAssembler clienteAssembler = new ClienteAssembler();
        return clienteAssembler.toDTOMiFarma(clienteMifarmaService.lstClientes());
    }


    @GetMapping(path = "/proveedor/{id_proveedor}")
    public List<ClienteMin> showClientesProveedor(@PathVariable int id_proveedor){
    	ClienteAssembler clienteAssembler = new ClienteAssembler();
        return clienteAssembler.toDTOMiFarma(clienteMifarmaService.lstClientesPorProveedor(id_proveedor));
    }

    @GetMapping(path = "/empresa/{id_empresa}")
    public List<ClienteMifarma> showClientesEmpresa(@PathVariable int id_empresa){
        return clienteMifarmaService.lstClientesPorEmpresa(id_empresa);
    }

    @GetMapping(path = "report_proveedor/{id_proveedor}")
    public ModelAndView descargarReporte(@PathVariable int id_proveedor){
        logger.info("=== (GET) /descargar Reporte START ===");
        logger.info("[descargarReporte] filtroEmpresaProveedor: ");
        logger.info("[descargarReporte] filtroEmpresaProveedor: Inkafarma "+ id_proveedor);

        List<ClienteMifarma> lstClientesMifarma= clienteMifarmaService.lstClientesPorProveedor(id_proveedor);

        ModelAndView modelMifarma = new ModelAndView(new ExcelClientesListReportMifarma(), "clientsList", lstClientesMifarma);

        return modelMifarma;
    }

    @GetMapping(path = "report_mifarma")
    public ModelAndView descargarReporte(){
        logger.info("=== (GET) /descargar Reporte START ===");
        logger.info("[descargarReporte] Cliente Mifarma ");
        logger.info("[descargarReporte] Todos los clientes Mifarma ");

        List<ClienteMifarma> lstClientesMifarma= clienteMifarmaService.lstClientes();

        ModelAndView modelMifarma = new ModelAndView(new ExcelClientesListReportMifarma(), "clientsList", lstClientesMifarma);

        return modelMifarma;
    }
}
