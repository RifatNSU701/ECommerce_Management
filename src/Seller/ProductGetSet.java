
package Seller;

import java.io.Serializable;

/**
 *
 * @author Nafis
 */
public class ProductGetSet implements Serializable {
    
    private String username;
    private String productId;
    private String productName;
    private double unitPrice;
    private int numberOfUnits;
    private String imagePath;
    
    public ProductGetSet(String username, String productId, String productName, double unitPrice, int numberOfUnits, String imagePath) {
        this.username = username;
        this.productId = productId;
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.numberOfUnits = numberOfUnits;
        this.imagePath = imagePath;
    }

    public ProductGetSet(String part, String part2){
        imagePath = part;
        productName = part2;
        
       
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    
    
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getNumberOfUnits() {
        return numberOfUnits;
    }

    public void setNumberOfUnits(int numberOfUnits) {
        this.numberOfUnits = numberOfUnits;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
    
    
    
}
