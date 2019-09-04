package config;

import beans.User;
import util.FileUtil;

public class Initialization {
    public static Config config = null;

    public static void initializeConfig(User user){
        config = new Config();
        try{
            Object configObj = FileUtil.readObject("config.dat");
            if(configObj != null)
                config = (Config) configObj;
            else
                config.setUser(user);
        }catch(Exception ex){
//            ex.printStackTrace();
            config.setUser(user);
        }
    }

    public static void refreshConfig(){
        FileUtil.writeObject(config, "config.dat");
    }
}
