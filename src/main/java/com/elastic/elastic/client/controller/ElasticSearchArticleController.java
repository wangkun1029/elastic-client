package com.elastic.elastic.client.controller;


import com.elastic.elastic.client.common.dto.criteria.ArticleCriteria;
import com.elastic.elastic.client.model.Article;
import com.elastic.elastic.client.service.ElasticSearchArticleService;
import com.elastic.elastic.client.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 2019, 天地汇有限公司
 * FileName: ElasticSearchController
 *
 * @Author: wangkun
 * Date:     2020/12/10 15:07
 * Description: elastic测试
 */
@Api(tags = "article")
@RestController
@Slf4j
public class ElasticSearchArticleController {


    @Autowired
    private ElasticSearchArticleService elasticSearchArticleService;

    @ApiOperation(value = "文章的添加", notes = "文章的添加")
    @RequestMapping(value = "addArticle",method = RequestMethod.POST)
    public R addArticle(@RequestBody @Validated ArticleCriteria criteria){
        Article article = new Article();
        BeanUtils.copyProperties(criteria, article);
        article = elasticSearchArticleService.save(article);
        return R.ok(article,"添加成功");
    }

    @ApiOperation(value = "获取所有文章", notes = "获取所有文章")
    @RequestMapping(value = "getArticle",method = RequestMethod.POST)
    public R getArticle(){
        Iterable<Article> iterable = elasticSearchArticleService.findAll();
        List<Article> articles = new ArrayList<>();
        if(!iterable.iterator().hasNext()){
            return R.ok(null,"查询成功");
        }
        iterable.forEach(articles::add);
        return R.ok(articles,"查询成功");
    }


}
