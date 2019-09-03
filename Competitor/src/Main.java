import beans.User;
import util.MenuUtil;
import util.UserUtil;

public class Main {

    public static void main(String[] args) {
        User user = UserUtil.requireInputsAndLogin(3,true);
        System.out.println("Hello "+user.getUsername());
        MenuUtil.showMenuInfinite();
    }
}
