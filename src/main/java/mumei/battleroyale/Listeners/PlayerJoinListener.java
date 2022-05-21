package mumei.battleroyale.Listeners;

import mumei.battleroyale.Battleroyale;
import mumei.battleroyale.Utils.GameStatus;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player player = e.getPlayer();
        //ロビーに飛ばす
        player.teleport(Battleroyale.config.get_lobby_spawn_loc());

        if (GameStatus.getgame()){
            player.setGameMode(GameMode.SPECTATOR);
        }else {
            player.setGameMode(GameMode.SURVIVAL);
        }
        if (!player.isOp()){
            return;
        }
        player.sendMessage(ChatColor.GREEN + "§l[BattleAssist] このプラグインを利用していただきありがとうございます");
        player.sendMessage(ChatColor.YELLOW + "§l[BattleAssist] バグや不具合等がありましたらTwitterでの@riyaya1528又は@mumei_whileに連絡をください");

    }
}
