package br.ufg.inf.backend.drtransfer.service;

import br.ufg.inf.backend.drtransfer.exception.DrTransferException;
import br.ufg.inf.backend.drtransfer.model.Drogas;
import br.ufg.inf.backend.drtransfer.repository.DocumentoTransferenciaRepository;
import br.ufg.inf.backend.drtransfer.repository.DrogasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DrogasService {


        @Autowired
        private DrogasRepository repository;

        public List<Drogas> findAll(){
                return repository.findAll();
        }

        public Drogas save(Drogas droga) {
               try{ return repository.save(droga);
               } catch (Exception e) {
                   throw new DrTransferException("Falha ao salvar no BD");
               }
        }

        public Drogas update(Drogas droga) {
            Optional<Drogas> optional = repository.findById(droga.getId());
            if(optional.isPresent()){
                    return save(droga);

            }else {
                    throw new DrTransferException("Droga com ID %d não encontrada", droga.getId());
            }
        }

        public void deleteById(Long id) {
                Optional<Drogas> optional = repository.findById(id);
                if(optional.isPresent()){
                        repository.deleteById(id);

                }else {
                        throw new DrTransferException("Droga com ID %d não encontrada", id);
                }
        }
}
