package com.example.money_tracker;

public class Transaction {
    String amount,note,type,category;
    int image,ID;
    String history;
    String newCat;

    public Transaction() {
    }

    public Transaction(String amount, String note, String type, String category,int image, String history ) {
        this.amount = amount;
        this.note = note;
        this.type = type;
        this.category = category;
        this.image = image;
        this.history = history;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String toString() {
        return "Transaction{" +
                "amount='" + amount + '\'' +
                ", note='" + note + '\'' +
                ", type='" + type + '\'' +
                ", category='" + category + '\'' +
                ", image=" + image +
                ", ID=" + ID +
                '}';
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public String getNewCat() {
        return newCat;
    }

    public void setNewCat(String newCat) {
        this.newCat = newCat;
    }
}
