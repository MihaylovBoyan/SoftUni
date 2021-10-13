package bg.softuni.mobilelele.user;

import bg.softuni.mobilelele.model.entity.UserRoleEnum;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.HashSet;
import java.util.Set;

@Component
@SessionScope
public class CurrentUser {

    private boolean isLoggedIn;
    private String username;
    private String firstName;
    private String lastName;
    private Set<UserRoleEnum> roles = new HashSet<>();

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public CurrentUser setLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public CurrentUser setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public CurrentUser setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public CurrentUser setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public CurrentUser addRole(UserRoleEnum role) {
        roles.add(role);
        return this;
    }

    public CurrentUser clearRoles() {
        roles.clear();
        return this;
    }

    public boolean isAdmin() {
        return roles.contains(UserRoleEnum.ADMIN);
    }

    public void clean() {
        setLoggedIn(false).setUsername(null).setFirstName(null).setLastName(null).clearRoles();
    }

}
