package com.frimac.preoperational.persistence.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "user")
public class User {


    @Id
    @Column(name = "id_user")
    private String id;

    private String password;


    @NotBlank
    @Size(min = 4, max = 50)
    @Column(name = "user_name")
    private String name;
    
    @NotBlank
    @Size(min = 4, max = 10)
    @Column(name = "user_state")
    private String state;

    @NotBlank
    @Size(min = 4, max = 15)
    @Column(name = "user_type")
    private String type;


    @ManyToOne
    @JoinColumn(name = "idf_role", referencedColumnName = "id_role")
    private Role role;

    @ManyToOne
    @JoinColumn(name = "idf_area", referencedColumnName = "id_area")
    private Area area;


    @ManyToOne
    @JoinColumn(name = "idf_position", referencedColumnName = "id_position")
    private Position position;


    private String username;
    private boolean enable;

    
    public User() {
    }


    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getState() {
        return state;
    }


    public void setState(String state) {
        this.state = state;
    }


    public String getType() {
        return type;
    }


    public void setType(String type) {
        this.type = type;
    }


    public Role getRole() {
        return role;
    }


    public void setRole(Role role) {
        this.role = role;
    }


    public Area getArea() {
        return area;
    }


    public boolean isEnable() {
        return enable;
    }


    public void setEnable(boolean enable) {
        this.enable = enable;
    }


    public void setArea(Area area) {
        this.area = area;
    }


    public Position getPosition() {
        return position;
    }


    public void setPosition(Position position) {
        this.position = position;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }


    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }


    
}


