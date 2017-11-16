package edu.hnust.application.service.product;

import java.util.List;
import java.util.Map;

import edu.hnust.application.common.page.ReturnPageData;
import edu.hnust.application.orm.product.Product;

public interface IProductService {
    /**
     * 
     * @param uuid
     * @return
     */
    public Product queryProductById(Integer id);
    
    /**
     * 
     * @param uuid
     * @return
     */
    public Product queryProductByKey(Map<String, Object> requestArgs);
    
    /**
     * 
     * @param uuid
     * @return
     */
    public List<Product> queryProductsByKey(Map<String, Object> requestArgs);
    
    /**
     * 
     * @param uuid
     * @return
     */
    public ReturnPageData<Product> pageQueryProducts(Map<String, Object> requestArgs);
    
    /**
     * 
     * @param uuid
     * @return
     */
    public Integer saveProduct(Product product);
    
    /**
     * 
     * @param uuid
     * @return
     */
    public boolean updateProduct(Product product);
    
    /**
     * 
     * @param uuid
     * @return
     */
    public boolean updateProductByKey(Map<String, Object> requestArs);
    
    /**
     * 
     * @param uuid
     * @return
     */
    public boolean deleteProductById(Integer id);
}