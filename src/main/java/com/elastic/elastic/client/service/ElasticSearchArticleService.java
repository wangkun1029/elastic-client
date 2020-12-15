package com.elastic.elastic.client.service;

import com.elastic.elastic.client.model.Article;

/**
 * 2019, 天地汇有限公司
 * FileName: ElasticSearchProductService
 *
 * @Author: wangkun
 * Date:     2020/12/10 15:08
 * Description: elastic接口
 */
public interface ElasticSearchArticleService {


    /**
     * 文章的添加
     * @param article
     * @return
     */
    Article save(Article article);

    /**
     * 查询所有的文章
     * @return
     */
    Iterable<Article> findAll();
}
