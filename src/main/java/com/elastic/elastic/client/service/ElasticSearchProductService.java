package com.elastic.elastic.client.service;

import com.elastic.elastic.client.model.product;

import java.util.List;
import java.util.Optional;

/**
 * 2019, 天地汇有限公司
 * FileName: ElasticSearchProductService
 *
 * @Author: wangkun
 * Date:     2020/12/10 15:08
 * Description: elastic接口
 */
public interface ElasticSearchProductService {


    /**
     * 产品的添加
     * @param product
     * @return
     */
    product save(product product);

    /**
     * 获取所有的产品
     * @return
     */
    Iterable<product> getProduct();

    /**
     * 根据id获取产品信息
     * @param id
     * @return
     */
    Optional<product> findById(Long id);

    /**
     * 删除产品
     * @param id
     */
    void deleteProduct(Long id);

    /**
     * 根据标题模糊查询
     * @param title
     * @return
     */
    List<product> getProductByTitle(String title);


}
