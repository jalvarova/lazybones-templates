package ${project_package}.service;

import ${project_package}.domain.Login;
import ${project_package}.domain.Usuario;


public interface UsuarioService {

    public abstract Usuario validacionUser(String user, String password);

    public abstract Login login(String user, String passwor);
}
