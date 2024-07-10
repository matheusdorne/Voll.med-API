package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api.domain.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMedicoComMesmaConsultaNaHora implements  ValidadorAgendamentoDeConsulta{

    @Autowired
    private MedicoRepository medicoRepository;

    public void validar(DadosAgendamentoConsulta dados) {

        var dataConsulta = dados.data();
        var mesmaHora = medicoRepository.existsByMedicoIdAndData(dados.idMedico(), dataConsulta);

        if (mesmaHora) {
            throw new ValidacaoException("Médico já possui uma consulta na mesma data/hora!");
        }
    }
}
