package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;

public class ValidadorConsultaNoMesmoDia {

    private ConsultaRepository consultaRepository;

    public void validar(DadosAgendamentoConsulta dados){

        var dataConsulta = dados.data();
        var primeiroHorario = dados.data().withHour(7);
        var ultimoHorario = dados.data().withHour(18);
        var mesmoDia = consultaRepository.existsByPacienteIdAndDataBetween(dados.idPaciente(),primeiroHorario, ultimoHorario);

        if (mesmoDia) {
            throw new ValidacaoException("Paciente já possui uma consulta na mesma data!");
        }
    }
}
