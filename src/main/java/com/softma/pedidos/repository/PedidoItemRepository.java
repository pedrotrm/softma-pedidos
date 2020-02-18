package com.softma.pedidos.repository;

import com.softma.pedidos.entities.PedidoItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoItemRepository extends JpaRepository<PedidoItem, Long > {


}
