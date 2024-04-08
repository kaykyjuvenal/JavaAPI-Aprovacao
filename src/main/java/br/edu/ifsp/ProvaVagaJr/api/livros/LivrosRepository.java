package br.edu.ifsp.ProvaVagaJr.api.livros;

import org.springframework.boot.availability.LivenessState;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivrosRepository extends JpaRepository<Livro,Long> {

}
