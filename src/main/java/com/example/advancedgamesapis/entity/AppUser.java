package com.example.advancedgamesapis.entity;

import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
@Entity
@Table(name = "player")
public class AppUser implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
    private String email;
    private String password;
    private boolean locked=false;
    private boolean enabled=false;
    private int greedDiceGameScore=0;
    private int towerHanoiScore=0;
    private int rockPaperSicssors=0;
    private double calcDamageGame=0.0;

    public AppUser(String email, String password, boolean locked, boolean enabled, int greedDiceGameScore, int towerHanoiScore, int rockPaperSicssors, double calcDamageGame) {
        this.email = email;
        this.password = password;
        this.locked = locked;
        this.enabled = enabled;
        this.greedDiceGameScore = greedDiceGameScore;
        this.towerHanoiScore = towerHanoiScore;
        this.rockPaperSicssors = rockPaperSicssors;
        this.calcDamageGame = calcDamageGame;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGreedDiceGameScore() {
        return greedDiceGameScore;
    }

    public void setGreedDiceGameScore(int greedDiceGameScore) {
        this.greedDiceGameScore = greedDiceGameScore;
    }

    public int getTowerHanoiScore() {
        return towerHanoiScore;
    }

    public void setTowerHanoiScore(int towerHanoiScore) {
        this.towerHanoiScore = towerHanoiScore;
    }

    public int getRockPaperSicssors() {
        return rockPaperSicssors;
    }

    public void setRockPaperSicssors(int rockPaperSicssors) {
        this.rockPaperSicssors = rockPaperSicssors;
    }

    public double getCalcDamageGame() {
        return calcDamageGame;
    }

    public void setCalcDamageGame(double calcDamageGame) {
        this.calcDamageGame = calcDamageGame;
    }

    public AppUser() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public AppUser(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
