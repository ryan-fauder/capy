package br.com.core.capy.estoque.repository;

import br.com.core.capy.estoque.entity.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstoqueRepository extends JpaRepository<Estoque,Long> {

}
