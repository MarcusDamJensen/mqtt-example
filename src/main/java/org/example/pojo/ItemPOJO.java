package org.example.pojo;

public class ItemPOJO extends POJOBase {

    private String name;
    private String category;
    private int amount;

    public ItemPOJO() {}

    public ItemPOJO(String name, String category, int amount) {
        this.name = name;
        this.category = category;
        this.amount = amount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return this.category;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return this.amount;
    }

    @Override
    public String toString() {
        return String.format("%s %s %d", name, category, amount);
    }
}
