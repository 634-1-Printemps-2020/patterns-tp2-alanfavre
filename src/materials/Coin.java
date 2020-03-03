package materials;
import java.util.*;

public class Coin {

  private CoinState coinState;
  private static Coin coin;
  private final Random random = new Random();

  private Coin()
  {

  }

  /**
   * Récupérer l'instance de Coin
   * @return Instance de Coin
   */
  public static Coin getInstance()
  {
    if (coin == null)
    {
      coin = new Coin();
    }

    return coin;
  }

  /**
   * Change l'état de la pièce.
   * 50% de probabilité d'obtenir HEADS, 50% de probabilité d'obtenir TAILS
   */
  public void throwCoin()
  {
    if (random.nextBoolean())
    {
      coinState = CoinState.HEADS;
    }
    else
    {
      coinState = CoinState.TAILS;
    }
  }

  public CoinState getState() {
    return coinState;
  }


}
