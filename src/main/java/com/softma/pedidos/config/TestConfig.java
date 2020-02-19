package com.softma.pedidos.config;


import com.softma.pedidos.entities.*;
import com.softma.pedidos.entities.enums.StatusPedido;
import com.softma.pedidos.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private PedidoItemRepository pedidoItemRepository;

    @Override
    public void run(String... args) throws Exception {


        Categoria cat1 = new Categoria(null, "Eletronicos");
        Categoria cat2 = new Categoria(null, "Livros");
        Categoria cat3 = new Categoria(null, "Computadores");

        Produto po1 = new Produto(null, "Senhor dos Aneis", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Produto po2 = new Produto(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Produto po3 = new Produto(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Produto po4 = new Produto(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Produto po5 = new Produto(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

        categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        produtoRepository.saveAll(Arrays.asList(po1, po2,po3,po4,po5));

        po1.getCategorias().add(cat2);
        po2.getCategorias().add(cat1);
        po2.getCategorias().add(cat3);
        po3.getCategorias().add(cat3);
        po4.getCategorias().add(cat3);
        po5.getCategorias().add(cat2);

        produtoRepository.saveAll(Arrays.asList(po1,po2,po3,po4,po5));

        Usuario u1 = new Usuario(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        Usuario u2 = new Usuario(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        Pedido p1 = new Pedido(null, Instant.parse("2019-06-20T19:53:07Z"), StatusPedido.PAGO, u1);
        Pedido p2 = new Pedido(null, Instant.parse("2019-07-21T03:42:10Z"), StatusPedido.AGUARDANDO_PAGAMENTO,u2 );
        Pedido p3 = new Pedido(null, Instant.parse("2019-07-22T15:21:22Z"),StatusPedido.AGUARDANDO_PAGAMENTO,u1);

        usuarioRepository.saveAll(Arrays.asList(u1, u2));
        pedidoRepository.saveAll(Arrays.asList(p1, p2, p3));

        PedidoItem pi1 = new PedidoItem(p1, po1, 2, po1.getPreco());
        PedidoItem pi2 = new PedidoItem(p1, po3, 1, po3.getPreco());
        PedidoItem pi3 = new PedidoItem(p2, po3, 2, po3.getPreco());
        PedidoItem pi4 = new PedidoItem(p3, po5, 2, po5.getPreco());

        pedidoItemRepository.saveAll(Arrays.asList(pi1,pi2,pi3,pi4));

        Pagamento pag1 = new Pagamento(null,Instant.parse("2019-06-20T21:53:07Z"),p1);

        p1.setPagamento(pag1);

        pedidoRepository.save(p1);


    }
}
