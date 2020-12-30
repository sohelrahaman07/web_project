package javacourses.boundary;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javacourses.entity.Greeting;

@Named
@RequestScoped
public class GreetingBoundary {
    @PersistenceContext
    private EntityManager em;
    private String lang;
    private Greeting greeting;

    public void loadGreeting() {
        if (lang == null) {
            lang = "en";
        }
        greeting = em.find(Greeting.class, lang);
    }

    public Greeting getGreeting() {
        return greeting;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }
}
