package com.softma.pedidos.services;

import com.softma.pedidos.entities.Usuario;
import com.softma.pedidos.repository.UsuarioRepository;
import com.softma.pedidos.services.exception.DatabaseException;
import com.softma.pedidos.services.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Usuario inserir(Usuario obj){
        return repository.save(obj);
    }

    public void deletar(Long id ) {
        try {
            repository.deleteById(id);
        }   catch (EmptyResultDataAccessException e){
                throw new ResourceNotFoundException(id);
        }   catch (DataIntegrityViolationException e){
                throw new DatabaseException(e.getMessage());
        }
    }

    public Usuario atualizar(Long id, Usuario obj){
        Usuario entidade = repository.getOne(id);
        atualizarDado(entidade, obj);
        return repository.save(entidade);
    }

    private void atualizarDado(Usuario entidade, Usuario obj){
        entidade.setNome(obj.getNome());
        entidade.setEmail(obj.getEmail());
        entidade.setTelefone(obj.getTelefone());

    }

}
