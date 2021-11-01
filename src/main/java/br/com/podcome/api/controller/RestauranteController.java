package br.com.podcome.api.controller;

import br.com.podcome.api.model.Restaurante;
import br.com.podcome.api.service.RestaurantesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/api/v1/restaurantes")
public class RestauranteController {

    @Autowired
    RestaurantesService service;

    @PostMapping(value="/adicionar")
    public ResponseEntity<Restaurante> adicionarRestaurante(@RequestBody Restaurante restaurante){
        try{
            service.adicionarRestaurante(restaurante);
            return new ResponseEntity("Restaurante " + restaurante.getNome() + " adicionado com sucesso.", HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity("Ocorreu um problema com a criação desse restaurante no nosso banco de dados, favor entrar em contato com os administradores do sistema. Erro: " + e.getMessage(), HttpStatus.SERVICE_UNAVAILABLE);
        }
    }

    @GetMapping(value="/restaurante")
    public ResponseEntity<List<Restaurante>> buscarRestaurantesRestricao(@PathParam("restricao") String restricao){
        try{
            List<Restaurante> restaurantesComRestricao = service.buscarRestaurantesRestricao(restricao);
            if(restaurantesComRestricao.isEmpty()){
                return new ResponseEntity("Nenhum restaurante encontrado que atenda à restrição", HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity("Restaurantes que atendem à restrição: " + restaurantesComRestricao, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity("Ocorreu um problema com a busca de restaurante no nosso banco de dados, favor entrar em contato com os administradores do sistema. Erro: " + e.getMessage(), HttpStatus.SERVICE_UNAVAILABLE);
        }
    }

    @GetMapping(value = "/restaurantes")
    public ResponseEntity<List<Restaurante>> buscarTodosRestaurantes(){
        try{
            List<Restaurante> restaurantes = service.buscarTodosRestaurantes();
            if (restaurantes.isEmpty()){
                return new ResponseEntity("Não foi possível encontrar restaurantes", HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity(restaurantes, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity("Ocorreu um erro: " + e.getMessage(), HttpStatus.SERVICE_UNAVAILABLE);
        }
    }
}
