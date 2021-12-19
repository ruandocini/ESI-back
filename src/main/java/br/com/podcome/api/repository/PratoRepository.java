package br.com.podcome.api.repository;

import br.com.podcome.api.model.Prato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PratoRepository extends JpaRepository<Prato, Long> {

    List<Prato> findAll();
}
