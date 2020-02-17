package com.softma.pedidos.repository;

import com.softma.pedidos.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long > {


}
