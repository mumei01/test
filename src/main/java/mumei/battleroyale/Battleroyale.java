package mumei.battleroyale;

import mumei.battleroyale.Commands.CommandManager;
import mumei.battleroyale.Commands.TabCompleteListener;
import mumei.battleroyale.Listeners.PlayerDeadListener;
import mumei.battleroyale.Listeners.PlayerJoinListener;
import mumei.battleroyale.Utils.GameStatus;
import org.bukkit.plugin.java.JavaPlugin;
import sun.security.krb5.Config;


public final class Battleroyale extends JavaPlugin {
    public static Config config;
    public static GameStatus gameStatus;
    private static JavaPlugin instance;


    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        saveDefaultConfig();
        config = new Config(getConfig(););

        gameStatus.setgame(false);

        //startCounting(this);

        registerListener(this);

        getCommand("battle").setExecutor(new CommandManager());
        getCommand("battle").setTabCompleter(new TabCompleteListener());

        getLogger().info("プラグインが有効になりました。");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("プラグインが無効になりました。");
    }
    //インスタンスを返す
    public static JavaPlugin getInstance(){return instance;}
    public void getConfig(){
        return config;
    }
    //イベントリスナーの登録
    private void registerListener(JavaPlugin plugin){
        plugin.getServer().getPluginManager().registerEvents(new PlayerJoinListener(),plugin);
        plugin.getServer().getPluginManager().registerEvents(new PlayerDeadListener(),plugin);
    }

}
