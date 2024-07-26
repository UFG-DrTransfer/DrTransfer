package br.ufg.inf.backend.drtransfer.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Autowired
@PostMapping
@RestController
@RequestMapping("/documentotransferencia")

public class DocumentoTransferenciaController {


    public ResponseEntity<DocumentoTransferencia> criarDocumento(@RequestBody DocumentoTransferencia documento) {
        DocumentoTransferencia novoDocumento = documentoTransferenciaService.criarDocumento(documento);
        return ResponseEntity.ok(novoDocumento);
    }

    @GetMapping
    public ResponseEntity<List<DocumentoTransferencia>> obterTodosDocumentos() {
        List<DocumentoTransferencia> documentos = documentoTransferenciaService.obterTodosDocumentos();
        return ResponseEntity.ok(documentos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DocumentoTransferencia> obterDocumentoPorId(@PathVariable Long id) {
        DocumentoTransferencia documento = documentoTransferenciaService.obterDocumentoPorId(id);
        if (documento != null) {
            return ResponseEntity.ok(documento);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<DocumentoTransferencia> atualizarDocumento(@PathVariable Long id, @RequestBody DocumentoTransferencia documento) {
        DocumentoTransferencia documentoAtualizado = documentoTransferenciaService.atualizarDocumento(id, documento);
        if (documentoAtualizado != null) {
            return ResponseEntity.ok(documentoAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarDocumento(@PathVariable Long id) {
        boolean deletado = documentoTransferenciaService.deletarDocumento(id);
        if (deletado) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}










}
