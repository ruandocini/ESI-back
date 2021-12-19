package br.com.podcome.api.controller;

import br.com.podcome.api.model.Prato;
import br.com.podcome.api.service.PratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/api/v1/prato")
public class PratoController {

    @Autowired
    PratoService service;

    @PostMapping(value="/adicionar")
    public ResponseEntity<Prato> adicionarRestaurante(@RequestBody Prato prato){
        try{
            service.adicionarRestaurante(prato);
            return new ResponseEntity("Restaurante " + prato.getNomeDoPrato() + " adicionado com sucesso.", HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity("Ocorreu um problema com a criação desse prato no nosso banco de dados, favor entrar em contato com os administradores do sistema. Erro: " + e.getMessage(), HttpStatus.SERVICE_UNAVAILABLE);
        }
    }

    @GetMapping(value="/prato")
    public ResponseEntity<List<Prato>> buscarPratosRestricao(@PathParam("restricao") String restricao){
        try{
            List<Prato> pratosComRestricao = service.buscarRestaurantesRestricao(restricao);
            if(pratosComRestricao.isEmpty()){
                return new ResponseEntity("Nenhum prato encontrado que atenda à restrição", HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity("pratos que atendem à restrição: " + pratosComRestricao, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity("Ocorreu um problema com a busca de pratos no nosso banco de dados, favor entrar em contato com os administradores do sistema. Erro: " + e.getMessage(), HttpStatus.SERVICE_UNAVAILABLE);
        }
    }

    @GetMapping(value = "/pratos")
    public ResponseEntity<List<Prato>> buscarTodosPratos(){
        try{
            List<Prato> pratos = service.buscarTodosPratos();
            if (pratos.isEmpty()){
                return new ResponseEntity("Não foi possível encontrar pratos", HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity(pratos, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity("Ocorreu um erro: " + e.getMessage(), HttpStatus.SERVICE_UNAVAILABLE);
        }
    }
}
