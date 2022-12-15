package test;

import observer.Cliente;
import observer.Plano;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlanoTest {

  @Test
  void deveNotificarUmCliente() {
    Plano plano = new Plano("Básico", 10);
    Cliente cliente = new Cliente("Pedro Bonorino");
    cliente.assinarPlano(plano);
    plano.mudarPrecoPlano(20);
    assertEquals("Pedro Bonorino, seu plano Plano Básico terá um novo preço de R$20,00 a partir do próximo mês.", cliente.getUltimoPreco());
  }

  @Test
  void deveNotificarClientes() {
    Plano plano = new Plano("Básico", 10);
    Cliente cliente1 = new Cliente("Pedro Bonorino");
    Cliente cliente2 = new Cliente("Gilberto Braga");
    cliente1.assinarPlano(plano);
    cliente2.assinarPlano(plano);
    plano.mudarPrecoPlano(20);
    assertEquals("Pedro Bonorino, seu plano Plano Básico terá um novo preço de R$20,00 a partir do próximo mês.", cliente1.getUltimoPreco());
    assertEquals("Gilberto Braga, seu plano Plano Básico terá um novo preço de R$20,00 a partir do próximo mês.", cliente2.getUltimoPreco());
  }

  @Test
  void naoDeveNotificarCliente() {
    Plano plano = new Plano("Básico", 10);
    Cliente cliente = new Cliente("Pedro Bonorino");
    plano.mudarPrecoPlano(20);
    assertEquals(null, cliente.getUltimoPreco());
  }

  @Test
  void deveNotificarClientePlanoBasico() {
    Plano plano1 = new Plano("Básico", 10);
    Cliente cliente1 = new Cliente("Pedro Bonorino");
    Plano plano2 = new Plano("Premium", 30);
    Cliente cliente2 = new Cliente("Gilberto Braga");
    cliente1.assinarPlano(plano1);
    cliente2.assinarPlano(plano2);
    plano1.mudarPrecoPlano(20);
    assertEquals("Pedro Bonorino, seu plano Plano Básico terá um novo preço de R$20,00 a partir do próximo mês.", cliente1.getUltimoPreco());
    assertEquals(null, cliente2.getUltimoPreco());
  }
}