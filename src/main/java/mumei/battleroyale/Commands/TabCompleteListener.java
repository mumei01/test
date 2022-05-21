package mumei.battleroyale.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.util.StringUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TabCompleteListener implements TabCompleter {
    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
        final List<String> completeions = new ArrayList<>();

        StringUtil.copyPartialMatches(args[0], Collections.singleton("stop"),completeions);
        StringUtil.copyPartialMatches(args[0], Collections.singleton("start"),completeions);
        Collections.sort(completeions);
        return completeions;
    }
}
