package com.plugin;

import com.google.common.collect.Iterables;
import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import com.plugin.Constants.defaultValues;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.messaging.PluginMessageListener;

import java.util.ArrayList;
import java.util.List;

public class PluginMessage implements PluginMessageListener {

    private static MainPlugin plugin = MainPlugin.getInstance();

    @Override
    public void onPluginMessageReceived(String channel, Player player, byte[] message) {
        if (!channel.equals("BungeeCord")) {
            return;
        }
        ByteArrayDataInput in = ByteStreams.newDataInput(message);
        String subchannel = in.readUTF();

        if (subchannel.equals("PlayerList")) {
            String server = in.readUTF();
            String[] playerList = in.readUTF().split(", ");
            List<String> playerLists = new ArrayList<>();

            for(String plr : playerList) {
                playerLists.add(plr);
            }


            defaultValues.serverPlayers.put(server, playerLists);

            return;
        }
    }

    public static void connect(Player player, String server) {
        ByteArrayDataOutput output = ByteStreams.newDataOutput();
        output.writeUTF("Connect");
        output.writeUTF(server);


        player.sendPluginMessage(plugin, "BunrgeeCord", output.toByteArray());

        defaultValues.reloadServerPlayers(server);
    }

    public static void getPlayers(String server) {
        ByteArrayDataOutput output = ByteStreams.newDataOutput();
        output.writeUTF("PlayerList");
        output.writeUTF(server);

        Player player = Iterables.getFirst(Bukkit.getOnlinePlayers(), null);

        player.sendPluginMessage(plugin, "BungeeCord", output.toByteArray());
    }

}
