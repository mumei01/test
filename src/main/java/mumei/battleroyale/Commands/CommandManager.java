package mumei.battleroyale.Commands;

import mumei.battleroyale.Battleroyale;
import mumei.battleroyale.Utils.GameManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CommandManager implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player player = (Player)sender;
        //レングス確認
        if (args.length == 0) {
            return true;
        }
        //パーミッション確認
        if (!player.hasPermission("Battleroyale.command.start")){
            //TODO ここmessage.ymlで変更できるように
            player.sendMessage("あなたには権限はありません");
            return true;
        }

        switch (args[0]){
            case "start":
                GameManager.start();
                break;
            case "stop":
                GameManager.stop();
                break;
            default:
                //TODO ここmessage.ymlで変更できるように
                player.sendMessage("コマンドが存在しません");
                break;
        }



        return true;
    }
}
