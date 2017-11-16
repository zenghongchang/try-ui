package edu.hnust.application.orm.product;

import java.io.Serializable;

/**
 * 商品信息表
 * 
 * @author Henry(fba02)
 * @version [版本号, 2017年11月16日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@SuppressWarnings("serial")
public class Product implements Serializable {
    
    private Integer id;//
    private String productName;// 商品名
    private String productCode;// 商品编码
    private Double productPrice;// 商品价格
    private Double productSize;// 商品图片大小
    private String productDesc;// 商品描述    
    private String productImgUrl;// 商品图片地址    
    private Integer soldOutProduct;// 是否下架商品,1:下架,0:未下架
    private String productRemark;// 商品备注
    private String sysRemark;// 系统备注    
    private String creator;// 创建人    
    private String createDate;// 创建时间
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getProductName() {
        return productName;
    }
    
    public void setProductName(String productName) {
        this.productName = productName;
    }
    
    public String getProductCode() {
        return productCode;
    }
    
    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }
    
    public Double getProductPrice() {
        return productPrice;
    }
    
    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }
    
    public Double getProductSize() {
        return productSize;
    }

    public void setProductSize(Double productSize) {
        this.productSize = productSize;
    }

    public String getProductDesc() {
        return productDesc;
    }
    
    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }
    
    public String getProductImgUrl() {
        return productImgUrl;
    }
    
    public void setProductImgUrl(String productImgUrl) {
        this.productImgUrl = productImgUrl;
    }
    
    public Integer getSoldOutProduct() {
        return soldOutProduct;
    }
    
    public void setSoldOutProduct(Integer soldOutProduct) {
        this.soldOutProduct = soldOutProduct;
    }
    
    public String getProductRemark() {
        return productRemark;
    }
    
    public void setProductRemark(String productRemark) {
        this.productRemark = productRemark;
    }
    
    public String getSysRemark() {
        return sysRemark;
    }
    
    public void setSysRemark(String sysRemark) {
        this.sysRemark = sysRemark;
    }
    
    public String getCreator() {
        return creator;
    }
    
    public void setCreator(String creator) {
        this.creator = creator;
    }
    
    public String getCreateDate() {
        return createDate;
    }
    
    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", productName=" + productName + ", productCode=" + productCode + ", productPrice=" + productPrice + ", productSize=" + productSize + ", productDesc=" + productDesc + ", productImgUrl=" + productImgUrl + ", soldOutProduct=" + soldOutProduct + ", productRemark=" + productRemark + ", sysRemark=" + sysRemark + ", creator=" + creator + ", createDate=" + createDate + "]";
    }
}