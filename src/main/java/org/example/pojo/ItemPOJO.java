package org.example.pojo;

import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbPropertyOrder;

import javax.annotation.Generated;

@JsonbPropertyOrder({
        "Name",
        "Category",
        "Amount",
})
public class ItemPOJO implements JsonDomainObject {

    @JsonbProperty("Name")
    private String name;

    @JsonbProperty("Category")
    private String category;
    @JsonbProperty("Amount")
    private int amount;

    public ItemPOJO() {}

    public ItemPOJO(String name, String category, int amount) {
        this.name = name;
        this.category = category;
        this.amount = amount;
    }

    @JsonbProperty("Name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonbProperty("Name")
    public String getName() {
        return this.name;
    }

    @JsonbProperty("Category")
    public void setCategory(String category) {
        this.category = category;
    }

    @JsonbProperty("Category")
    public String getCategory() {
        return this.category;
    }

    @JsonbProperty("Amount")
    public void setAmount(int amount) {
        this.amount = amount;
    }

    @JsonbProperty("Amount")
    public int getAmount() {
        return this.amount;
    }

    @Override
    public String toString() {
        return String.format("%s %s %d", name, category, amount);
    }
}
