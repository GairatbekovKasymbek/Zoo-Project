package org.example.Model;




public class Animal {
    private int id;
    private String name;
    private String species;
    private String description;
    private int quantity;

    public Animal(int id, String name, String species, String description, int quantity) {
        this.id = id;
        this.name = name;
        this.species = species;
        this.description = description;
        this.quantity = quantity;
    }

    // Геттеры и сеттеры
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSpecies() { return species; }
    public void setSpecies(String species) { this.species = species; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    @Override
    public String toString() {
        return id + " | " + name + " (" + species + ") - " + quantity + " шт. | " + description;
    }
}
