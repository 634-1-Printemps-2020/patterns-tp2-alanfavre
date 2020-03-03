package game;

import materials.CoinState;

import java.util.List;

public class Rules {

  private static Rules rules;

  private Rules()
  {

  }

  public static Rules getInstance()
  {
    if(rules == null)
    {
      rules = new Rules();
    }

    return rules;
  }

  /**
   * Cette méthode permet de déterminer si une suite d'états de pièce permet de gagner à une partie
   * @param states liste d'états pour un joueur
   * @return true si un joueur a gagné, false sinon
   */
  public boolean checkWin(List<CoinState> states) {
    if(states.size() >= 3)
    {
      int size = states.size();
      CoinState val = CoinState.TAILS;
      if(states.get(size - 1) == val && states.get(size -2) == val && states.get(size - 3) == val)
      {
        return true;
      }
    }
    return false;
  }
}
