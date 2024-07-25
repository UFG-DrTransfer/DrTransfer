package br.ufg.inf.backend.drtransfer.repository;

import br.ufg.inf.backend.drtransfer.model.Cargo;
import br.ufg.inf.backend.drtransfer.model.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Long> {
    @Query("SELECT obj FROM Cargo obj " +
            "WHERE obj.nome = :nome " +
            "AND (:id IS NULL OR obj.id <> :id)")
    Optional<Cargo> findByNomeAndIdNot(@Param("nome") String nome, @Param("id") Long id);}


/*
         Atualizar um cargo cujo nome exista.
         findByNomeAndNotId -> pra procurar pelo nome
           id = null -> 1
           nome = Administrador
           select Obj
           from Cargo
           Where nome = Administrador and id != null

           id = null -> 2
           nome = Contador
           select Obj
           from Cargo
           Where nome = Contador and id != null

           if ((entidade.isNovo() && nomeCargo.isPresent()) ||
                (!entidade.isNovo() && nomeCargo.isPresent() && nomeCargo.get().getId().equals(entidade.getId()))) {


           UPDATE pra um nome que existe:
           id = 1
           nome = Contador
           select Obj
           from Cargo
           Where nome = Contador AND id != 1  -> retorna (então entra na exceção).

           id = 1
           nome = Administrador
           select Obj
           from Cargo
           Where nome = Administrador AND id != 1 -> não retorna (não entra na exceção).
 */