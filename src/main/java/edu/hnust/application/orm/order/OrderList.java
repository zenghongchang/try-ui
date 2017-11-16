package edu.hnust.application.orm.order;

import java.io.Serializable;
import java.util.Set;

/**
 * 订单信息表
 * 
 * @author Henry(fba02)
 * @version [版本号, 2017年11月16日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@SuppressWarnings("serial")
public class OrderList implements Serializable {
    private Integer id;
    private Set<OrderProduct> orderProducts;// 订单商品
    private String orderRemark;// 下单备注
    private Integer creator;// 下单人即创建人
    private String createDate;// 下单时间
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Set<OrderProduct> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(Set<OrderProduct> orderProducts) {
        this.orderProducts = orderProducts;
    }
    
    public String getOrderRemark() {
        return orderRemark;
    }

    public void setOrderRemark(String orderRemark) {
        this.orderRemark = orderRemark;
    }

    public Integer getCreator() {
        return creator;
    }
    
    public void setCreator(Integer creator) {
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
        return "OrderList [id=" + id + ", creator=" + creator + ", createDate=" + createDate + "]";
    }
}