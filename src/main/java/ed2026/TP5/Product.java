package ed2026.TP5;

//
// Created by Julio Tentor <jtentor@fi.unju.edu.ar>
//

import java.text.SimpleDateFormat;
import java.util.Date;

public class Product {

    //region Attributes
    private Integer code;
    private String description;
    private Date expirationDate;
    private Float salePrice;
    //endregion

    //region Getters and Setters
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Float getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Float salePrice) {
        this.salePrice = salePrice;
    }
    //endregion

    //region Constructors
    public Product() {
        this(0, "", new Date(), 0f);
    }

    public Product(Integer code, String description, Float salePrice) {
        this(code, description, new Date(), salePrice);
    }

    public Product(Integer code, String description, Date expirationDate, Float salePrice) {
        setCode(code);
        setDescription(description);
        setExpirationDate(expirationDate);
        setSalePrice(salePrice);
    }
    //endregion

    private final static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/YYYY");

    @Override
    public String toString() {
        return "Product{" +
                "code=" + getCode() +
                ", description='" + getDescription() + '\'' +
                ", expirationDate=" + simpleDateFormat.format(getExpirationDate()) +
                ", salePrice=" + getSalePrice() +
                '}';
    }
}
