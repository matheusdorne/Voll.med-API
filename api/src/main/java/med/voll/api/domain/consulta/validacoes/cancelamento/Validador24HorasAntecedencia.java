package med.voll.api.domain.consulta.validacoes.cancelamento;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.Consulta;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DadosCancelamentoConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class Validador24HorasAntecedencia implements ValidadorCancelamentoDeConsulta{

    @Autowired
    private ConsultaRepository consultaRepository;

    public void validar(DadosCancelamentoConsulta dados) {

        var dataConsulta = consultaRepository.getReferenceById(dados.id());
        var agora = LocalDateTime.now();
        var diferencaHoras = Duration.between(agora, dataConsulta.getData()).toHours();

        if (diferencaHoras < 24) {
            throw new ValidacaoException("Consultas só podem ser canceladas com até 24 horas de antecedência!");
        }


    }
}
