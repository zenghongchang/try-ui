package edu.hnust.application.orm.order;

import java.io.Serializable;

@SuppressWarnings("serial")
public class OrderProduct implements Serializable {
    private Integer id;
    private Integer orderListId;// 订单ID
    private Integer productId;// 商品ID
    private Integer num;// 数量
    private Integer status = 0; // 商品支付状态,1:已支付,0:未支付
    private String addCartDate;// 添加购物车时间
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getOrderListId() {
        return orderListId;
    }
    
    public void setOrderListId(Integer orderListId) {
        this.orderListId = orderListId;
    }
    
    public Integer getProductId() {
        return productId;
    }
    
    public void setProductId(Integer productId) {
        this.productId = productId;
    }
    
    public Integer getNum() {
        return num;
    }
    
    public void setNum(Integer num) {
        this.num = num;
    }
    
    public Integer getStatus() {
        return status;
    }
    
    public void setStatus(Integer status) {
        this.status = status;
    }
    
    public String getAddCartDate() {
        return addCartDate;
    }
    
    public void setAddCartDate(String addCartDate) {
        this.addCartDate = addCartDate;
    }
    
    @Override
    public String toString() {
        return "OrderProduct [id=" + id + ", orderListId=" + orderListId + ", productId=" + productId + ", num=" + num + ", status=" + status + ", addCartDate=" + addCartDate + "]";
    }
}
