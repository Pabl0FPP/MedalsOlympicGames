package model;

public class Medal {

    private String medalType;
    private int quantity;

    public Medal(String medalType, int quantity) {
        this.medalType = medalType;
        this.quantity = quantity;
    }

    public String getMedalType() {
        return medalType;
    }

    public void setMedalType(String medalType) {
        this.medalType = medalType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
