package config;

import beans.User;
import util.FileUtil;

public class Initialization {
    public static Config config = null;

    public static void initializeConfig(User user){
        config = new Config(user);
        try{
            Object configObj = FileUtil.readObject("config.dat");
            config = (Config) configObj;
        }catch(Exception ex){
//            ex.printStackTrace();
        }
    }

    public static void refreshConfig(){
        FileUtil.writeObject(config, "config.dat");
    }
}
