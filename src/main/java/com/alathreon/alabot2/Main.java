package com.alathreon.alabot2;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.EnumSet;

public class Main {

    private static Config parseConfig(String[] args) {
        String filename = args.length > 0 ? args[0] : "config.json";
        return new ObjectMapper().readValue(Path.of(filename), Config.class);
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        Config config = parseConfig(args);
        JDA jda = JDABuilder.createLight(config.token(), EnumSet.of(GatewayIntent.GUILD_MESSAGES, GatewayIntent.MESSAGE_CONTENT))
                .addEventListeners(new SlashCommandListener())
                .build()
                .awaitReady();
        System.out.println("JDA Ready!");
        jda.getTextChannelById(config.statusUpdateChannel()).sendMessage("[%s] Alabot2 en marche !".formatted(config.shortDateTimeFormat().format(LocalDateTime.now()))).queue();
        System.in.read();
        System.out.println("JDA Down...");
        jda.getTextChannelById(config.statusUpdateChannel()).sendMessage("[%s] Alabot2 s'arrète...".formatted(config.shortDateTimeFormat().format(LocalDateTime.now()))).queue();
        jda.shutdown();
    }

}
