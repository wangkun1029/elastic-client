package com.elastic.elastic.client.service;

import com.elastic.elastic.client.dao.ElasticSearchArticleDao;
import com.elastic.elastic.client.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 2019, 天地汇有限公司
 * FileName: ElasticSearchArticleServiceImpl
 *
 * @Author: wangkun
 * Date:     2020/12/14 13:54
 * Description: 文章的实现类
 */
@Service
public class ElasticSearchArticleServiceImpl implements ElasticSearchArticleService {

    @Autowired
    private ElasticSearchArticleDao elasticSearchArticleDao;
    /**
     * 文章的添加
     * @param article
     * @return
     */
    @Override
    public Article save(Article article) {
        return elasticSearchArticleDao.save(article);
    }

    /**
     * 获取所有的文章
     * @return
     */
    @Override
    public Iterable<Article> findAll() {

        return elasticSearchArticleDao.findAll();
    }
}
