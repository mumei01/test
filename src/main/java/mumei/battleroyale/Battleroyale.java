package mumei.battleroyale;

import mumei.battleroyale.Commands.CommandManager;
import mumei.battleroyale.Commands.TabCompleteListener;
import mumei.battleroyale.DataBase.Config;
import mumei.battleroyale.Listeners.PlayerDeadListener;
import mumei.battleroyale.Listeners.PlayerJoinListener;
import mumei.battleroyale.Utils.GameManager;
import mumei.battleroyale.Utils.GameStatus;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;


public final class Battleroyale extends JavaPlugin {
    public static Config config;
    public static GameStatus gameStatus;
    public static JavaPlugin instance;


    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        saveDefaultConfig();

        config = new Config(this);

        gameStatus.setgame(false);

        GameManager.check(this);

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


    //イベントリスナーの登録
    private void registerListener(JavaPlugin plugin){
        plugin.getServer().getPluginManager().registerEvents(new PlayerJoinListener(),plugin);
        plugin.getServer().getPluginManager().registerEvents(new PlayerDeadListener(),plugin);
    }

}
