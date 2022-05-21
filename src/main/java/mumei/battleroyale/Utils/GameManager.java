package mumei.battleroyale.Utils;

import mumei.battleroyale.Battleroyale;
import mumei.battleroyale.DataBase.Config;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;

public class GameManager {
    public static GameStatus gamestatus;
    public static Config config = Battleroyale.config;
    public static void start(){
        //ゲーム中なら返す
        if (gamestatus.getgame()){return;}
        //gamestatusをゲーム中に変更
        gamestatus.setgame(true);

        //デフォルトワールドボーダーセット
        config.get_start_loc().getWorld().getWorldBorder().setSize(config.get_world_border_defalut());
        //宝箱再配置　別プラグイン
        Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(),"lc respawnall");

        for (int i = 3;i<=0;i--) {


            try {
                for(Player player : Bukkit.getOnlinePlayers()) {
                    if(!player.getGameMode().equals(GameMode.CREATIVE)) {
                        player.sendTitle(ChatColor.YELLOW + "ゲーム開始まで "+i+"...", "");
                        player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_PLACE, 10, 1);
                    }
                }

                Thread.sleep(1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        Bukkit.getScheduler().runTaskLater(Battleroyale.getInstance(), () -> {
            for (Player player : Bukkit.getOnlinePlayers()) {
                if (!player.getGameMode().equals(GameMode.CREATIVE) || !player.getGameMode().equals(GameMode.SPECTATOR)) {
                    GameStatus.setgame(true);
                    //GameStatus.resetTime();
                    player.sendTitle(ChatColor.YELLOW + "スタート!!", "");
                    player.playSound(player.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 10, 0);
                    player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 10, 0);
                    player.setGameMode(GameMode.SURVIVAL);
                    player.teleport(config.get_start_loc());
                    player.getInventory().clear();
                    player.getInventory().setChestplate(new ItemStack(Material.ELYTRA));

                }
            }
            Bukkit.broadcastMessage(ChatColor.YELLOW + "§l[注意!] のこり" + config.get_remove_elytra_seconds() + "でエリトラが削除されます。");
        }, 20L);

    }

    public static void stop(){
        GameStatus.setgame(false);
        // Gamestatus.setTime(0);
        Battleroyale.config.get_start_loc().getWorld().getWorldBorder().setSize(config.get_world_border_defalut());
        ArrayList<Player> PLAYING = new ArrayList<>();

        //プレイ中の人を取得
        for (Player player1 : Bukkit.getOnlinePlayers()){
            if (player1.getGameMode().equals(GameMode.SURVIVAL)){
                PLAYING.add(player1);
            }
        }
        for (Player player : Bukkit.getOnlinePlayers()){
            if (config.get_endgame_tp_lobby()){
                player.teleport(config.get_lobby_spawn_loc());
            }
            player.setGameMode(GameMode.SURVIVAL);
            player.getInventory().clear();
            player.playSound(player.getLocation(),Sound.ENTITY_ENDER_DRAGON_DEATH,10,2);

        }

    }
    public static void check(JavaPlugin plugin){
        new BukkitRunnable(){
            @Override
            public void run(){
                //常時ゲーム中じゃなければぱす
                if (!GameStatus.getgame()){return;}

                //生き残りのプレイヤーを取得
                ArrayList<Player> players = new ArrayList<>();
                for (Player player : Bukkit.getOnlinePlayers()){
                    if (player.getGameMode().equals(GameMode.SURVIVAL)){
                        players.add(player);
                    }
                }

                //アクションバーに以下の情報を表示
                for(Player player : Bukkit.getOnlinePlayers()) {
                    player.sendActionBar(ChatColor.YELLOW + "§l残り人数" + ChatColor.WHITE + ": " + ChatColor.YELLOW + "§l" + players.size() + ChatColor.GREEN + "§l 残り時間" + ChatColor.WHITE + ": " + ChatColor.GREEN + "§l" + GameStatus.getTime());
                }

                //生き残りが一人なら終わり
                if(players.size() <= 1 || GameStatus.getTime() == 0) {
                    stop();
                }

                //残り時間を減らしていく
                GameStatus.setTime(GameStatus.getTime() - 1);

                if(Battleroyale.config.get_GAME_TIME() - Battleroyale.config.get_remove_elytra_seconds() == Battleroyale.gameStatus.getTime()) {
                    for(Player player : Bukkit.getOnlinePlayers()) {
                        if(player.getInventory().getChestplate().getType().equals(Material.ELYTRA)) {
                            player.getInventory().getChestplate().setAmount(0);
                        }
                    }
                }



            }
        }.runTaskTimer(plugin,20,20);

    }

}
