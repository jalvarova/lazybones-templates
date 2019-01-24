package ${project_package}.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ${project_package}.domain.Proveedor;


@Repository("proveedorRepository")
public interface ProveedorRepository extends CrudRepository<Proveedor, Integer> {
    public abstract Proveedor findById(Integer id);
}
