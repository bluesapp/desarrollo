/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.medplus.Medico.wrapper;

/**
 *
 * @author MarioF
 */
public class WUserLdap {

    private String username;
    private String displayName;
    private String email;
    private String phone;
    private String token;
    private String roles;

    public WUserLdap() {
    }

    public WUserLdap(String username, String displayName, String email, String phone, String token, String roles) {
        super();
        this.username = username;
        this.displayName = displayName;
        this.email = email;
        this.phone = phone;
        this.token = token;
        this.roles = roles;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "WUserLdap [username=" + username + ", displayName=" + displayName + ", email=" + email + ", phone="
                + phone + ", token=" + token + ", roles=" + roles +"]";
    }

}
