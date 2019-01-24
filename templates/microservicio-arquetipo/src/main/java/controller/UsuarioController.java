package ${project_package}.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import ${project_package}.domain.Login;
import ${project_package}.service.UsuarioService;


@RestController
@RequestMapping("/")
public class UsuarioController {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    @Qualifier("usuarioServiceImpl")
    private UsuarioService usuarioService;

    @GetMapping(path = "login/{user}/{password}")
    public Login login(@PathVariable("user") String user, @PathVariable("password") String password){
        logger.info("METHOD: login(): ");
        System.out.println("usuario: " + usuarioService.login(user, password));
        return usuarioService.login(user, password);
    }
}
