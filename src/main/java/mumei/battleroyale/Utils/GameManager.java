package mumei.battleroyale.Utils;

import mumei.battleroyale.DataBase.Config;

public class GameManager {
    public static GameStatus gamestatus;
    public static Config config;
    public static void start(){
        //ゲーム中なら返す
        if (gamestatus.getgame()){return;}
        //gamestatusをゲーム中に変更
        gamestatus.setgame(true);

        config.get_start_loc().getWorld().getWorldBorder().setSize(config.);

    }

}
