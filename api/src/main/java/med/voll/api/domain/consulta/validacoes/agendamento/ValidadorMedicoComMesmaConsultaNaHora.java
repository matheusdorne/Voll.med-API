package med.voll.api.domain.consulta.validacoes.agendamento;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMedicoComMesmaConsultaNaHora implements  ValidadorAgendamentoDeConsulta{

    @Autowired
    private ConsultaRepository consultaRepository;

    public void validar(DadosAgendamentoConsulta dados) {

        var dataConsulta = dados.data();
        var mesmaHora = consultaRepository.existsByMedicoIdAndData(dados.idMedico(), dataConsulta);

        if (mesmaHora) {
            throw new ValidacaoException("Médico já possui uma consulta na mesma data/hora!");
        }
    }
}
