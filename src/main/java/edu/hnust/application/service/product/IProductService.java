package edu.hnust.application.service.product;

import java.util.List;
import java.util.Map;

import edu.hnust.application.common.page.ReturnPageData;
import edu.hnust.application.orm.product.Product;

/**
 * 操作商品接口
 * 
 * @author Henry(fba02)
 * @version [版本号, 2017年11月16日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public interface IProductService {
    /**
     * 根据商品ID查找
     * @param id
     * @return
     */
    public Product queryProductById(Integer id);
    
    /**
     * 根据商品属性查找商品,只取一条记录
     * @param requestArgs
     * @return
     */
    public Product queryProductByKey(Map<String, Object> requestArgs);
    
    /**
     * 根据商品属性查找满足条件的所有商品
     * @param requestArgs
     * @return
     */
    public List<Product> queryProductsByKey(Map<String, Object> requestArgs);
    
    /**
     * 分页查找商品
     * @param requestArgs
     * @return
     */
    public ReturnPageData<Product> pageQueryProducts(Map<String, Object> requestArgs);
    
    /**
     * 保存商品,返回订单ID
     * @param product
     * @return
     */
    public Integer saveProduct(Product product);
    
    /**
     * 更新商品
     * @param product
     * @return
     */
    public boolean updateProduct(Product product);
    
    /**
     * 更新商品部分属性
     * @param requestArs
     * @return
     */
    public boolean updateProductByKey(Map<String, Object> requestArs);
    
    /**
     * 删除商品
     * @param id
     * @return
     */
    public boolean deleteProductById(Integer id);
}