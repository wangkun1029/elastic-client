package com.elastic.elastic.client.dao;

import com.elastic.elastic.client.model.Article;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * 2019, 天地汇有限公司
 * FileName: ElasticSearchProductService
 *
 * @Author: wangkun
 * Date:     2020/12/10 15:08
 * Description: elastic接口
 */
public interface ElasticSearchArticleDao extends ElasticsearchRepository<Article, Long> {


}
