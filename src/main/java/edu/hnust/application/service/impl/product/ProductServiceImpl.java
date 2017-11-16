package edu.hnust.application.service.impl.product;

import java.util.List;
import java.util.Map;

import org.codehaus.jackson.type.TypeReference;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import edu.hnust.application.common.page.ReturnPageData;
import edu.hnust.application.common.util.JsonConverter;
import edu.hnust.application.orm.product.Product;
import edu.hnust.application.service.base.BaseService;
import edu.hnust.application.service.product.IProductService;

/**
 * 商品接口实现
 * 
 * @author Henry(fba02)
 * @version [版本号, 2017年11月16日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */

@Scope("prototype")
@Service("productService")
public class ProductServiceImpl extends BaseService implements IProductService {    
    private final String  QUERY_PRODUCT_BY_ID   = "/product/queryProductById";
    private final String  QUERY_PRODUCT_BY_KEY  = "/product/queryProductByKey";
    private final String  QUERY_PRODUCTS_BY_KEY = "/product/queryProductsByKey";
    private final String  PAGE_QUERY_PRODUCTS   = "/product/pageQueryProducts";
    private final String  SAVE_PRODUCT          = "/product/saveProduct";
    private final String  UPDATE_PRODUCT        = "/product/updateProduct";
    private final String  UPDATE_PRODUCT_BY_KEY = "/product/updateProductByKey";
    private final String  DELETE_PRODUCT_BY_ID  = "/product/deleteProductById";  
    
    @Override
    public Product queryProductById(Integer id) {
        setServiceEntry(QUERY_PRODUCT_BY_ID);
        setServiceRequestId(id);
        return returnBack(new TypeReference<Product>() {
        }, QUERY_PRODUCT_BY_ID);
    }
    
    @Override
    public Product queryProductByKey(Map<String, Object> requestArgs) {
        setServiceEntry(QUERY_PRODUCT_BY_KEY);
        setServiceRequest(JsonConverter.format(requestArgs));
        return returnBack(new TypeReference<Product>() {
        }, QUERY_PRODUCT_BY_KEY);
    }
    
    @Override
    public List<Product> queryProductsByKey(Map<String, Object> requestArgs) {
        setServiceEntry(QUERY_PRODUCTS_BY_KEY);
        setServiceRequest(JsonConverter.format(requestArgs));
        return returnBack(new TypeReference<List<Product>>() {
        }, QUERY_PRODUCTS_BY_KEY);
    }
    
    @Override
    public ReturnPageData<Product> pageQueryProducts(Map<String, Object> requestArgs) {
        setServiceEntry(PAGE_QUERY_PRODUCTS);
        setServiceRequest(JsonConverter.format(requestArgs));
        return returnBack(new TypeReference<ReturnPageData<Product>>() {
        }, PAGE_QUERY_PRODUCTS);
    }
    
    @Override
    public Integer saveProduct(Product product) {
        setServiceEntry(SAVE_PRODUCT);
        setServiceRequest(JsonConverter.format(product));
        return returnBack(new TypeReference<Integer>() {
        }, SAVE_PRODUCT);
    }
    
    @Override
    public boolean updateProduct(Product product) {
        setServiceEntry(UPDATE_PRODUCT);
        setServiceRequest(JsonConverter.format(product));
        return returnBack(new TypeReference<Boolean>() {
        }, UPDATE_PRODUCT);
    }
    
    @Override
    public boolean updateProductByKey(Map<String, Object> requestArs) {
        setServiceEntry(UPDATE_PRODUCT_BY_KEY);
        setServiceRequest(JsonConverter.format(requestArs));
        return returnBack(new TypeReference<Boolean>() {
        }, UPDATE_PRODUCT_BY_KEY);
    }
    
    @Override
    public boolean deleteProductById(Integer id) {
        setServiceEntry(DELETE_PRODUCT_BY_ID);
        setServiceRequestId(id);
        return returnBack(new TypeReference<Boolean>() {
        }, DELETE_PRODUCT_BY_ID);
    }
}