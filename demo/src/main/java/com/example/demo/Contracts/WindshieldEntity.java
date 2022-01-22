package com.example.demo.Contracts;

import javax.persistence.*;

@Entity
@Table(name = "windshield", schema = "jazprojectdb", catalog = "")
public class WindshieldEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "eurocode")
    private Integer eurocode;
    @Basic
    @Column(name = "brand")
    private String brand;
    @Basic
    @Column(name = "model")
    private String model;
    @Basic
    @Column(name = "belt_color")
    private String beltColor;
    @Basic
    @Column(name = "price")
    private Double price;

    public WindshieldEntity(int id, Integer eurocode, String brand, String model, String beltColor, Double price) {
        this.id = id;
        this.eurocode = eurocode;
        this.brand = brand;
        this.model = model;
        this.beltColor = beltColor;
        this.price = price;
    }

    public WindshieldEntity() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getEurocode() {
        return eurocode;
    }

    public void setEurocode(Integer eurocode) {
        this.eurocode = eurocode;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBeltColor() {
        return beltColor;
    }

    public void setBeltColor(String beltColor) {
        this.beltColor = beltColor;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WindshieldEntity that = (WindshieldEntity) o;

        if (id != that.id) return false;
        if (eurocode != null ? !eurocode.equals(that.eurocode) : that.eurocode != null) return false;
        if (brand != null ? !brand.equals(that.brand) : that.brand != null) return false;
        if (model != null ? !model.equals(that.model) : that.model != null) return false;
        if (beltColor != null ? !beltColor.equals(that.beltColor) : that.beltColor != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (eurocode != null ? eurocode.hashCode() : 0);
        result = 31 * result + (brand != null ? brand.hashCode() : 0);
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + (beltColor != null ? beltColor.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "WindshieldEntity{" +
                "id=" + id +
                ", eurocode=" + eurocode +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", beltColor='" + beltColor + '\'' +
                ", price=" + price +
                '}';
    }
}
