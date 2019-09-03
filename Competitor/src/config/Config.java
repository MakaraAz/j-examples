package config;

import beans.Competitor;
import beans.User;

import java.io.Serializable;

public class Config implements Serializable {

    private User user = null;
    private Competitor[] competitors = null;


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Competitor[] getCompetitors() {
        return competitors;
    }

    public void setCompetitors(Competitor[] competitors) {
        this.competitors = competitors;
    }
}
