package med.voll.api.domain.medico;

import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.endereco.DadosEndereco;

public record DadosAtualizacaoMedico (
        @NotNull // Como dependemos do valor para identificar o médico a ser cadastrado é necessário o not null
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {
}
