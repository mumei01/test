package mumei.battleroyale.Listeners;

import mumei.battleroyale.Battleroyale;
import mumei.battleroyale.Utils.GameStatus;
import org.bukkit.GameMode;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeadListener implements Listener {
    @EventHandler
    public void onDeadPlayer(PlayerDeathEvent e){

        if (!e.getEntityType().equals(EntityType.PLAYER)){
            return;
        }
        e.setCancelled(true);
        e.getEntity().teleport(Battleroyale.config.get_dead_loc());
        if (!GameStatus.getgame()){
            return;
        }
        Player player = e.getPlayer();
        if (Battleroyale.config.get_dead_spec()){
            player.setGameMode(GameMode.SPECTATOR);
            player.teleport(Battleroyale.config.get_dead_loc());
        }


    }
}
