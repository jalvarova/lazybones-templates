package ${project_package}.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import ${project_package}.constant.ViewConstant;
import ${project_package}.controller.assembler.ClienteAssembler;
import ${project_package}.domain.Cliente;
import ${project_package}.domain.ClienteMin;
import ${project_package}.domain.ExcelClientesListReportInkafarma;
import ${project_package}.service.ClienteService;

import java.util.List;


@RestController
@RequestMapping("/cliente")
public class ClienteController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    @Qualifier("clienteServiceImpl")
    private ClienteService clienteService;

    @GetMapping("/cancel")
    public String cancel() {
        return "redirect:/clientes";
    }
    
    @GetMapping("/hi")
    public String hi() {
        return "hi";
    }

    @GetMapping("/")
    public String redirectToLogin(){
        logger.info("METHOD: redirectToLogin()");
        return "redirect:/clientes";
    }

    @GetMapping("/clienteform")
    public String redirectContactForm(@RequestParam(name="id", required=false) int id,
                                      Model model) {
        Cliente cliente = new Cliente();
        model.addAttribute("cliente", cliente);
        return ViewConstant.CLIENTE_FORM;
    }

    @PostMapping(path = "/addcliente", consumes = "application/json", produces = "application/json")
    public void addCliente(@RequestBody Cliente cliente){
        logger.info("METHOD: addCliente() -- PARAMS: "+ cliente.toString());
        clienteService.addCliente(cliente);
    }

    @GetMapping(path = "/clientes")
    public List<ClienteMin> showClientes(){
    	ClienteAssembler clienteAssembler = new ClienteAssembler();
        return clienteAssembler.toDTO(clienteService.lstClientes());
    }

    @GetMapping(path = "/proveedor/{id_proveedor}")
    public List<ClienteMin> showClientesProveedor(@PathVariable int id_proveedor){
    	ClienteAssembler clienteAssembler = new ClienteAssembler();
        return clienteAssembler.toDTO(clienteService.lstClientesPorProveedor(id_proveedor));
    }

    @GetMapping(path = "/empresa/{id_empresa}")
    public List<Cliente> showClientesEmpresa(@PathVariable int id_empresa){
        return clienteService.lstClientesPorEmpresa(id_empresa);
    }

    @GetMapping(path = "report_proveedor/{id_proveedor}")
    public ModelAndView descargarReporte(@PathVariable int id_proveedor){
        logger.info("=== (GET) /descargar Reporte START ===");
        logger.info("[descargarReporte] filtroEmpresaProveedor: ");
        logger.info("[descargarReporte] filtroEmpresaProveedor: Inkafarma "+ id_proveedor);

        List<Cliente> lstClientesInkafarma= clienteService.lstClientesPorProveedor(id_proveedor);

        ModelAndView modelInkafarma = new ModelAndView(new ExcelClientesListReportInkafarma(), "clientsList", lstClientesInkafarma);

        return modelInkafarma;
    }

    @GetMapping(path = "/report_inkafarma")
    public ModelAndView descargarReporte(){
        logger.info("=== (GET) /descargar Reporte START ===");
        logger.info("[descargarReporte] Clientes Inkafarma: ");
        logger.info("[descargarReporte] Todos los clientes Inkafarma:");

        List<Cliente> lstClientesInkafarma= clienteService.lstClientes();

        ModelAndView modelInkafarma = new ModelAndView(new ExcelClientesListReportInkafarma(), "clientsList", lstClientesInkafarma);

        return modelInkafarma;
    }

}
