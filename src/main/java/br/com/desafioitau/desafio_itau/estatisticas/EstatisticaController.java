package br.com.desafioitau.desafio_itau.estatisticas;

import java.time.OffsetDateTime;

import br.com.desafioitau.desafio_itau.transacoes.TransacaoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/estatistica", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class EstatisticaController {


    private final Integer intervaloMaximoEmSegundos = 60;


    private TransacaoRepository transacaoRepository;

    public EstatisticaController(TransacaoRepository transacaoRepository) {
        this.transacaoRepository = transacaoRepository;
    }


    @GetMapping
    public ResponseEntity estatistica(){
        log.info("Calcular as estatisticas");
        final var horaInicial = OffsetDateTime.now().minusSeconds(intervaloMaximoEmSegundos);
        return ResponseEntity.ok(transacaoRepository.estatistica(horaInicial));
    }

}
