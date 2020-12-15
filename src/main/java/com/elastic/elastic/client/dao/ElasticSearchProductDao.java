package com.elastic.elastic.client.dao;

import com.elastic.elastic.client.model.product;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * 2019, 天地汇有限公司
 * FileName: ElasticSearchProductService
 *
 * @Author: wangkun
 * Date:     2020/12/10 15:08
 * Description: elastic接口
 */
public interface ElasticSearchProductDao extends ElasticsearchRepository<product, Long> {


    @Query("{\"match_phrase\":{\"title\":\"?0\"}}")
    List<product> getProductByTitle(String title);
}
