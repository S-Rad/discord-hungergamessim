package com.SRad.discordbot;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;

import javax.security.auth.login.LoginException;

public class BotMain {
    private final ShardManager shardManager;

    public BotMain() throws LoginException{
        DefaultShardManagerBuilder builder = DefaultShardManagerBuilder.createDefault(BotTokenStorage.BotToken);
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
}
