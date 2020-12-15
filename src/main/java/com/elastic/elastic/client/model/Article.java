package com.elastic.elastic.client.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;

/**
 * 2019, 天地汇有限公司
 * FileName: Article
 *
 * @Author: wangkun
 * Date:     2020/12/11 15:45
 * Description: Article
 */
// indexName为索引名称,type为该索引下的类型
@Data
@Document(indexName = "blog",indexStoreType = "article")
public class Article implements Serializable {
    @Id
    private Long id;

    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String title;

    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String content;

}
