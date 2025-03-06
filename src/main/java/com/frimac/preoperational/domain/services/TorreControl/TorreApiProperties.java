package com.frimac.preoperational.domain.services.TorreControl;



import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Component
@ConfigurationProperties(prefix = "torre.api")
public class TorreApiProperties {
    private String username;
    private String password;
    private String authurl;
    private String userurl;
    private String clientid;

    // Getters y Setters
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getAuthurl() { return authurl; }
    public void setAuthurl(String authurl) { this.authurl = authurl; }
    
    public String getUserurl() { return userurl; }
    public void setUserurl(String userurl) { this.userurl = userurl; }

    public String getClientid() { return clientid; }
    public void setClientid(String clientid) { this.clientid = clientid; }
}

