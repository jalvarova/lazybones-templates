package ${project_package}.repository;

import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ${project_package}.domain.ClienteMifarma;


import java.util.List;

@Repository("clienteMifarmaRepository")
public interface ClienteMifarmaRepository extends CrudRepository<ClienteMifarma, Integer> {
    public abstract ClienteMifarma findById(int id);

    public abstract ClienteMifarma findByNombres(String nombres);

    @Query(value= "SELECT * FROM cliente_mifarma WHERE id_proveedor = :id_proveedor GROUP BY comprobante ORDER BY id;", nativeQuery=true)
    public abstract List<ClienteMifarma> findById_proveedor(@Param("id_proveedor") int id_proveedor);

    @Query(value= "select * from cliente_mifarma where id_empresa= :id_empresa", nativeQuery=true)
    public abstract List<ClienteMifarma> findById_empresa(@Param("id_empresa") int id_empresa);


}
