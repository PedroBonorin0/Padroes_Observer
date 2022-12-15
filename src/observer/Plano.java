package observer;

import java.util.Observable;

public class Plano extends Observable {

  private float preco;
  private String nomePlano;

  public Plano(String nomePlano, float preco) {
    this.nomePlano = nomePlano;
    this.preco = preco;
  }

  public void mudarPrecoPlano(float novoPreco) {
    this.preco = novoPreco;
    setChanged();
    notifyObservers();
  }

  @Override
  public String toString() {
    return "Plano " + nomePlano + " terá um novo preço de R$" +  String.format("%.2f", preco) + " a partir do próximo mês.";
  }
}

