package com.example.helloworld.core;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "players")
@NamedQueries(
    {
        @NamedQuery(
            name = "com.example.helloworld.core.Player.findAll",
            query = "SELECT p FROM Player p"
        )
    })

public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "number")
    private long number;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "pos", nullable = false)
    private String pos;
    

    @Column(name = "nat", nullable = false)
    private String nat;


    @Column(name = "height", nullable = false)
    private String height;


    @Column(name = "weight", nullable = false)
    private String weight;


    @Column(name = "dob", nullable = false)
    private String dob;


    @Column(name = "birthplace", nullable = false)
    private String birthplace;



    public Player() {
    }

    public Player(long number, String name, String pos,String nat,String height, String weight, String birthplace) {
        this.number = number;
        this.name = name;
        this.pos = pos;
        this.nat = nat;
        this.weight = weight;
        this.height = height;
        this.birthplace = birthplace;
    }

    @JsonProperty
    public long getId() {
        return number;
    }

    public void setId(long number) {
        this.number = number;
    }

    @JsonProperty
    public String getName() {
        return name;
    }

    public void setlName(String name) {
        this.name = name;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    @JsonProperty
    public String getNat() {
        return nat;
    }

    public void setNat(String nat) {
        this.nat = nat;
    }

     @JsonProperty
    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    @JsonProperty
    public String getHeight() {
        return weight;
    }

    public void setHeight(String weight) {
        this.height = height;
    }

    @JsonProperty
    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Player)) {
            return false;
        }

        final Player that = (Player) o;

        return Objects.equals(this.number, that.number) &&
                Objects.equals(this.name, that.name) &&
                Objects.equals(this.pos, that.pos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, name, pos);
    }
}
