package ${project_package}.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ${project_package}.domain.Login;
import ${project_package}.domain.Usuario;
import ${project_package}.repository.UsuarioRepository;
import ${project_package}.service.UsuarioService;


@Service
public class UsuarioServiceImpl implements UsuarioService {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    @Qualifier("usuarioRepository")
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario validacionUser(String user, String password) {
        logger.info("=== (UsuarioServiceImpl) Login ===");
        Usuario usuario = usuarioRepository.login(user, password);
        return usuario;
    }

    @Override
    public Login login(String user, String password){
        Login login = new Login();
        Usuario objUser = validacionUser(user, password);
        if (objUser!=null){
            login.setUser(objUser.getUser());
            login.setMessage("OK");
        }else {
            login.setMessage("error");
        }
        return login;
    }
}
