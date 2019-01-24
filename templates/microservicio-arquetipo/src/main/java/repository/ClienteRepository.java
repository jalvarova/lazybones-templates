package ${project_package}.repository;

import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ${project_package}.domain.Cliente;

import java.util.List;


@Repository("clienteRepository")
public interface ClienteRepository extends CrudRepository<Cliente, Integer> {
    public abstract Cliente findById(int id);
    public abstract Cliente findByNombres(String nombres);
    @Query(value= "SELECT * FROM cliente WHERE id_proveedor = :id_proveedor GROUP BY comprobante ORDER BY id;", nativeQuery=true)
    public abstract List<Cliente> findById_proveedor(@Param("id_proveedor") int id_proveedor);
    @Query(value= "select * from cliente where id_empresa= :id_empresa", nativeQuery=true)
    public abstract List<Cliente> findById_empresa(@Param("id_empresa") int id_empresa);
}
