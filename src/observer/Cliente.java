package observer;

import java.util.Observable;
import java.util.Observer;

public class Cliente implements Observer {

  private String nome;
  private String ultimoPreco;

  public Cliente(String nome) {
    this.nome = nome;
  }

  public String getUltimoPreco() {
    return this.ultimoPreco;
  }

  public void assinarPlano(Plano plano) {
    plano.addObserver(this);
  }

  public void update(Observable plano, Object arg1) {
    this.ultimoPreco = this.nome + ", seu plano " + plano.toString();
    // System.out.println(this.ultimaNotificacao);
  }
}
