package mumei.battleroyale.Listeners;

import mumei.battleroyale.Battleroyale;
import org.bukkit.entity.EntityType;
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
        e.getEntity().teleport()






    }
}
