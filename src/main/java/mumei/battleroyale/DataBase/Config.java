package mumei.battleroyale.DataBase;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;

public class Config {
    private FileConfiguration config;

    //initialize
    public Config(FileConfiguration config){
        this.config = config;
    }

    //configの endgame_tp_lobbyを返します
    public boolean get_endgame_tp_lobby(){return config.getBoolean("lobby.endgame_tp_lobby");}

    //configの lobby.spawn_locを返します
    public Location get_lobby_spawn_loc(){
        return new Location(
                Bukkit.getWorld(config.getString("lobby.spawn_loc.world"))
                , config.getDouble("lobby.spawn_loc.x")
                , config.getDouble("lobby.spawn_loc.y")
                , config.getDouble("lobby.spawn_loc.z")
                , config.getInt("lobby.spawn_loc.yaw")
                , config.getInt("lobby.spawn_loc.pitch")

        );
    }
    //configの　game.dead_specを返します
    public boolean get_dead_spec(){return config.getBoolean("game.dead_spec");}

    //congigの　game.start_locを返します
    public Location get_start_loc(){
        return new Location(
                Bukkit.getWorld(config.getString("game.start_loc.world"))
                , config.getDouble("game.start_loc.x")
                , config.getDouble("game.start_loc.y")
                , config.getDouble("game.start_loc.z")
                , config.getInt("game.start_loc.yaw")
                , config.getInt("game.start_loc.pitch")
        );
    }
    //configの game.dead_locを返します
    public Location get_dead_loc(){
        return new Location(
                Bukkit.getWorld(config.getString("game.dead_loc.world"))
                , config.getDouble("game.dead_loc.x")
                , config.getDouble("game.dead_loc.y")
                , config.getDouble("game.dead_loc.z")
                , config.getInt("game.dead_loc.yaw")
                , config.getInt("game.dead_loc.poitch")
        );
    }
    //configの game.remove_elytra_secondsを返します
    public int get_remove_elytra_seconds(){return config.getInt("game.remove_elytra_seconds");}
    //configの game.world_borderを返します
    public int get_world_border_defalut(){return config.getInt("game.world_border.defalut");}
    //configの game.world_border.border_start_seconds
    public int get_world_border_start_seconds(){return config.getInt("game.world_border.border_start_seconds");}
    //configの first-border関係　以下コメント略します

    public

}
