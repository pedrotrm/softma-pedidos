package com.softma.pedidos.resources;

import com.softma.pedidos.entities.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {
    @RequestMapping
    public ResponseEntity<Usuario> findAll(){
        Usuario u = new Usuario(1, "Pedro", "pedrotrm@outlook.com.br", "98988003545","100923");

        return  ResponseEntity.ok().body(u);
    }


}
