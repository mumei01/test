package mumei.battleroyale.Listeners;

import mumei.battleroyale.Battleroyale;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player player = e.getPlayer();
        //ロビーに飛ばす
        player.teleport(Battleroyale.config.getSpanLocation());
    }
}
