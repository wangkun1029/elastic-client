package com.elastic.elastic.client.controller;


import com.elastic.elastic.client.common.dto.criteria.ProductCriteria;
import com.elastic.elastic.client.dao.ElasticSearchProductDao;
import com.elastic.elastic.client.model.product;
import com.elastic.elastic.client.service.ElasticSearchProductService;
import com.elastic.elastic.client.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.common.Strings;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * 2019, 天地汇有限公司
 * FileName: ElasticSearchController
 *
 * @Author: wangkun
 * Date:     2020/12/10 15:07
 * Description: elastic测试
 */
@Api(tags = "product")
@RestController
@Slf4j
public class ElasticSearchProductController {

    @Autowired
    private ElasticSearchProductService elasticSearchProductService;

    @Autowired
    private ElasticSearchProductDao elasticSearchProductDao;

    @ApiOperation(value = "产品添加", notes = "产品添加")
    @RequestMapping(value = "addProduct",method = RequestMethod.POST)
    public R addProduct(@RequestBody @Validated ProductCriteria criteria){
        product product = new product();
        BeanUtils.copyProperties(criteria, product);
        product = elasticSearchProductService.save(product);
        return R.ok(product,"添加成功");
    }

    @ApiOperation(value = "获取所有产品", notes = "获取所有产品")
    @RequestMapping(value = "getProduct",method = RequestMethod.POST)
    public R getProduct(){
        Iterable<product> iterable = elasticSearchProductService.getProduct();
        List<product> products = new ArrayList<>();
        if(!iterable.iterator().hasNext()){
            return R.ok(null,"查询成功");
        }
        iterable.forEach(products::add);
        return R.ok(products,"查询成功");
    }

    @ApiOperation(value = "根据id获取产品", notes = "根据id获取产品")
    @RequestMapping(value = "getProductById",method = RequestMethod.POST)
    public R getProductById(@RequestParam Long id){
        Optional<product> optionalProduct = elasticSearchProductService.findById(id);
        product product = new product();
        if(optionalProduct.isPresent()){
            product = optionalProduct.get();
        }else{
            return R.ok(null,"查询成功");
        }
        return R.ok(product,"查询成功");
    }


    @ApiOperation(value = "根据id删除产品", notes = "根据id删除产品")
    @RequestMapping(value = "deleteProduct",method = RequestMethod.POST)
    public R deleteProduct(@RequestParam Long id){
       elasticSearchProductService.deleteProduct(id);
        return R.ok(null,"删除成功");
    }


    @ApiOperation(value = "根据标题获取产品(模糊查询)", notes = "根据标题获取产品(模糊查询)")
    @RequestMapping(value = "getProductByTitle",method = RequestMethod.POST)
    public R getProductByTitle(@RequestParam String title){
        List<product> list = elasticSearchProductService.getProductByTitle(title);
        List<product> products = new ArrayList<>();
        if(CollectionUtils.isEmpty(list)){
            return R.ok(null,"查询成功");
        }
        list.forEach(products::add);
        return R.ok(products,"查询成功");
    }

    @ApiOperation(value = "根据标题获取产品(分页)", notes = "根据标题获取产品(分页)")
    @ResponseBody
    @RequestMapping(value = "/getProductPage",method = RequestMethod.GET)
    public R<Page<product>> getProductPage(String title, @RequestParam int pageindex, @RequestParam int pageSize) {
        //检索条件
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        if (!Strings.isEmpty(title)){
            boolQueryBuilder.must(QueryBuilders.matchPhraseQuery("title", title));
        }
        //排序条件
        FieldSortBuilder fsb = SortBuilders.fieldSort("price").order(SortOrder.DESC);
        pageindex = pageindex == 0 ? 1 : pageindex;
        pageSize = pageSize == 0 ? 10 : pageSize;
        Pageable pageable = PageRequest.of(pageindex - 1, pageSize);
        //构建查询
        NativeSearchQuery query = new NativeSearchQueryBuilder()
                .withQuery(boolQueryBuilder)
                .withSort(fsb)
                .withPageable(pageable)
                .build();
        Page<product> searchResponse = elasticSearchProductDao.search(query);

        return R.ok(searchResponse,"查询成功");
    }


}
