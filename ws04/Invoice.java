/**********************************************
 Workshop 4
 Course: JAC444 - Semester 4
 Last Name: Tse
 First Name: Chungon
 ID: 154928188
 Section: NAA
 This assignment represents my own work in accordance with Seneca Academic Policy.
 CHUNGON
 Date: 22 Feb 2023
 **********************************************/
package WS04;

/**
 * Invoice module
 */
public class Invoice implements Payable {
    private String partNumber;
    private String partDescription;
    private int quantity;
    private double PricePerItem;

    /**
     * Custom constructor
     * @param partNumber        part number
     * @param partDescription   part desc
     * @param quantity          qty
     * @param pricePerItem      price per item
     */
    public Invoice(String partNumber, String partDescription, int quantity, double pricePerItem) {
        setPartNumber(partNumber);
        setPartDescription(partDescription);
        setQuantity(quantity);
        setPricePerItem(pricePerItem);
    }
    @Override
    public double getPaymentAmount() {
        return (getQuantity() * getPricePerItem() *10.0/10.0);
    }

    @Override
    public String toString() {
        return "Item: " + getPartNumber() +
                "\nDescription: " + getPartDescription() +
                "\nQty: " + getQuantity() + "\nPrice: " + getPricePerItem();
    }
    /**
     * getter
     * @return  part number
     */
    public String getPartNumber() {
        return partNumber;
    }

    /**
     * setter
     * @param partNumber    part number
     */
    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    /**
     * getter
     * @return  part desc
     */
    public String getPartDescription() {
        return partDescription;
    }

    /**
     * setter
     * @param partDescription   part desc
     */
    public void setPartDescription(String partDescription) {
        this.partDescription = partDescription;
    }

    /**
     * getter
     * @return  qty
     */
    public int getQuantity() {
        return quantity;
    }
    /**
     * setter
     * @param quantity  qty
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * getter
     * @return  price per item
     */
    public double getPricePerItem() {
        return PricePerItem;
    }

    /**
     * setter
     * @param pricePerItem  price per item
     */
    public void setPricePerItem(double pricePerItem) {
        PricePerItem = pricePerItem;
    }
}
