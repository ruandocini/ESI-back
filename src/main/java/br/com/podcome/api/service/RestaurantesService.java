package br.com.podcome.api.service;

import br.com.podcome.api.model.Restaurante;
import br.com.podcome.api.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RestaurantesService {

    @Autowired
    RestauranteRepository repository;

    public List<Restaurante> buscarRestaurantesRestricao(String restricao){

        List<Restaurante> restaurantesCadastrados = repository.findAll();
        
        List<Restaurante> restaurantesRestricao = new ArrayList<>();
        for (Restaurante restaurante: restaurantesCadastrados
             ) {
            if(restaurante.getRestricao().equals(restricao)){
                restaurantesRestricao.add(restaurante);
            }

        }

        return restaurantesRestricao;
    }

    public Restaurante adicionarRestaurante(Restaurante restaurante){
        return repository.save(restaurante);
    }

    public List<Restaurante> buscarTodosRestaurantes() {
        return repository.findAll();
    }
}
