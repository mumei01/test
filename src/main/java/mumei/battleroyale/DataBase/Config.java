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

    //TODO 以下 border値によって返す値を変更できるように
    //borderは first second third のどれかがはいってます
    public Location get_border_loc(String border){
        // border = firest or second or third
        return new Location(
                Bukkit.getWorld(config.getString("game.world_border.first_border.first_border_loc.world"))
                , config.getDouble("game.world_border.first_border.first_border_loc.x")
                , config.getDouble("game.world_border.first_border.first_border_loc.y")
                , config.getDouble("game.world_border.first_border.first_border_loc.z")
                , config.getInt("game.world_border.first_border.first_border_loc.yaw")
                , config.getInt("game.world_border.first_border.first_border_loc.pitch")
        );
    }
    public int get_border_seconds(String border){
        return config.getInt("game.world_border.first_border.seconds");
    }
    public int get_border_second_size(String border){
        return config.getInt("game.world_border.first_border.second_size");
    }
    public int get_border_wait_seconds(String border){
        // border = first or secondのみ thirdはない
        return config.getInt("game.world_border.first_border.wait_seconds");
    }


}
