package edu.hnust.util;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;

import edu.hnust.dto.PageBean;
import edu.hnust.dto.ReturnPageData;

public class PageBeanUtil<T> {    
    @SuppressWarnings("unchecked")
    public PageBean<T> wrapPageBean(Object obj, ReturnPageData<T> rpageDate) {
        PageBean<T> pageBean = new PageBean<T>();
        if (null != obj) {
            if (obj instanceof Map) {
                if (MapUtils.isNotEmpty((Map<String, Object>)obj)) {
                    try {
                        BeanUtils.populate(pageBean, (Map<String, Object>)obj);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            } else if (obj instanceof PageBean) {
                pageBean = (PageBean<T>)obj;
            }
        }
        if (null == rpageDate || null != rpageDate && null == rpageDate.getCollectionCount()) {
            return pageBean;
        }
        Long totalRecodes = rpageDate.getCollectionCount().longValue();
        System.out.println(totalRecodes);
        Long localLong = (totalRecodes % pageBean.getPageLimit() > 0L) ? (totalRecodes / pageBean.getPageLimit()) + 1 : totalRecodes / pageBean.getPageLimit();
        pageBean.setTotalPages(localLong);
        pageBean.setTotalRecords(totalRecodes);
        pageBean.setPageList(rpageDate.getCollection());
        if (CollectionUtils.isEmpty(pageBean.getSelects())) {
            pageBean.setSelects(new ArrayList<Integer>());
            pageBean.getSelects().add(10);
            pageBean.getSelects().add(30);
            pageBean.getSelects().add(50);
            pageBean.getSelects().add(100);
            pageBean.getSelects().add(200);
        }
        return pageBean;
    }
}