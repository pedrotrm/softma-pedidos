package com.softma.pedidos.services;

import com.softma.pedidos.entities.Pedido;
import com.softma.pedidos.entities.Usuario;
import com.softma.pedidos.repository.PedidoRepository;
import com.softma.pedidos.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public List<Usuario> findAll(){
        return repository.findAll();
    }

    public Usuario findById(Long id){
        Optional <Usuario> obj = repository.findById(id);
        return obj.get();
    }

    public Usuario inserir(Usuario obj){
        return repository.save(obj);
    }

    public void deletar(Long id ){
        repository.deleteById(id);
    }

    public Usuario atualizar(Long id, Usuario obj){
        Usuario entidade = repository.getOne(id);
        atualizarDado(entidade, obj);
        return repository.save(entidade);
    }

    private void atualizarDado(Usuario entidade, Usuario obj){
        entidade.setName(obj.getName());
        entidade.setEmail(obj.getEmail());
        entidade.setTelefone(obj.getTelefone());

    }

}
