package ${project_package}.repository;

import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ${project_package}.domain.Usuario;


@Repository("usuarioRepository")
public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {
    @Query(value= "SELECT * FROM usuario WHERE user = :user AND password= :password AND estado='1';", nativeQuery=true)
    public abstract Usuario login(@Param("user") String user,@Param("password") String password);
}
