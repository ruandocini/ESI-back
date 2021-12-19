package br.com.podcome.api.service;

import br.com.podcome.api.model.Prato;
import br.com.podcome.api.repository.PratoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PratoService {

    @Autowired
    PratoRepository repository;

    public List<Prato> buscarRestaurantesRestricao(String restricao){

        List<Prato> pratosCadastrados = repository.findAll();
        
        List<Prato> PratosRestricao = new ArrayList<>();
        for (Prato restaurante: PratosRestricao
             ) {
            if(restaurante.getNomeDoRestaurante().equals(restricao)){
                PratosRestricao.add(restaurante);
            }

        }

        return PratosRestricao;
    }

    public Prato adicionarRestaurante(Prato restaurante){
        return repository.save(restaurante);
    }

    public List<Prato> buscarTodosPratos() {
        return repository.findAll();
    }
}
