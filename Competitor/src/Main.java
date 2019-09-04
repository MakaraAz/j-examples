import beans.User;
import config.Initialization;
import util.MenuUtil;
import util.UserUtil;

public class Main {

    public static void main(String[] args) {
        User user = UserUtil.requireInputsAndLogin(3,true);
//        System.out.println(user);
//        System.exit(1);
        Initialization.initializeConfig(user);
        System.out.println("hi "+user.getUsername());
        MenuUtil.showMenuInfinite();
    }
}
