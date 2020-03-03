package game;

import materials.Coin;
import materials.CoinState;
import player.Player;
import utils.Statistics;

import java.util.*;

public class Game {

    private Rules rules;
    private Coin coin;
    private Map<Player, List<CoinState>> history;

    public Game() {
        history = new HashMap<>();
    }

    /**
     * Ajouter un nouveau joueur au jeu
     *
     * @param player le nouveau joueur
     */
    public void addPlayer(Player player) {
      history.put(player, new ArrayList<CoinState>());
    }

    /**
     * Faire joueur tous les joueurs et stocker chaque partie dans history
     */
    public void play() {
      for (Player p : history.keySet())
      {
          while (!Rules.getInstance().checkWin(history.get(p)))
          {
              p.play(Coin.getInstance());
              history.get(p).add(Coin.getInstance().getState());
          }
      }
    }

    /**
     * Calculer des statistiques de la partie précédente
     *
     * @return Statistics
     */
    public Statistics getStatistics() {

        float total = 0;
        List<Integer> lstTotaux = new ArrayList<>();

        for (Player p : history.keySet())
        {
            int size = history.get(p).size();
            total += size;
            lstTotaux.add(size);
        }

        Collections.sort(lstTotaux);

        return new Statistics(total / history.size(), lstTotaux.get(0), lstTotaux.get(lstTotaux.size() - 1), Math.round(total));
    }

    /**
     * Obtenir l'historique de tous les joueurs de la partie précédente
     *
     * @return Map contenant chaque joueur et la liste des ses lancers
     */
    public Map<Player, List<CoinState>> getHistory() {
        return history;
    }


    /**
     * Obtenir l'historique d'un joueur spécifique
     *
     * @param player instance du joueur pour lequel on veut avoir l'historique
     * @return la liste des lancers d'un joueur
     */
    public List<CoinState> getSpecificHistory(Player player) {
      return history.get(player);
    }

}
