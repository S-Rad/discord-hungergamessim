package com.SRad.discordbot;

import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;

import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class BotMain {
    private final ShardManager shardManager;

    public BotMain() throws LoginException{
        DefaultShardManagerBuilder builder = DefaultShardManagerBuilder.createDefault(getBotToken());
        builder.setStatus(OnlineStatus.ONLINE);
        builder.setActivity(Activity.watching("you"));
        shardManager = builder.build();

    }

    public ShardManager getShardManager() {
        return shardManager;
    }

    public static void main(String[] arguments)
    {
        try{
            BotMain bot = new BotMain();
        }catch(LoginException e){
            System.out.println("Login Failed!");
        }

    }

    public String getBotToken(){
        Properties properties = new Properties();
        try (InputStream input = Files.newInputStream(Paths.get("src/config.properties"))){
            properties.load(input);

        }catch(IOException e){
            System.err.println("fehlgeschlagen: " + e.getMessage());
        }
        return properties.getProperty("bot.token");
    }
}
