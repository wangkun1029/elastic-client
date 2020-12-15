package com.elastic.elastic.client.service;

import com.elastic.elastic.client.dao.ElasticSearchProductDao;
import com.elastic.elastic.client.model.product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * 2019, 天地汇有限公司
 * FileName: ElasticSearchProductServiceImpl
 *
 * @Author: wangkun
 * Date:     2020/12/14 13:47
 * Description: 产品的实现类
 */
@Service
public class ElasticSearchProductServiceImpl implements ElasticSearchProductService{

    @Autowired
    private ElasticSearchProductDao elasticSearchProductDao;


    @Override
    public product save(product product) {
        return elasticSearchProductDao.save(product);
    }

    @Override
    public Iterable<product> getProduct() {
        return elasticSearchProductDao.findAll();
    }

    @Override
    public Optional<product> findById(Long id) {
        return elasticSearchProductDao.findById(id);
    }

    @Override
    public void deleteProduct(Long id) {
        elasticSearchProductDao.deleteById(id);
    }

    @Override
    public List<product> getProductByTitle(String title) {
        return elasticSearchProductDao.getProductByTitle(title);
    }


}
