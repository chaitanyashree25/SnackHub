package com.example.SnackHub.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "restaurants")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotBlank
    private String name;
    @NotBlank
    private String location;
    @NotBlank
    private String cuisineType;
    @Min(1)
    @Max(5)
    private double rating;

    public int getId() {
        return id;
    }

    public Restaurant() {
    }

    public Restaurant(int id, String name, String location, String cuisineType, double rating) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.cuisineType = cuisineType;
        this.rating = rating;
    }

    public @NotBlank String getName() {
        return name;
    }

    public void setName(@NotBlank String name) {
        this.name = name;
    }

    public @NotBlank String getLocation() {
        return location;
    }

    public void setLocation(@NotBlank String location) {
        this.location = location;
    }

    public @NotBlank String getCuisineType() {
        return cuisineType;
    }

    public void setCuisineType(@NotBlank String cuisineType) {
        this.cuisineType = cuisineType;
    }

    @Min(1)
    @Max(5)
    public double getRating() {
        return rating;
    }

    public void setRating(@Min(1) @Max(5) double rating) {
        this.rating = rating;
    }
}
