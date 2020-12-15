package com.elastic.elastic.client.common.dto.criteria;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 2019, 天地汇有限公司
 * FileName: product
 *
 * @Author: wangkun
 * Date:     2020/12/9 17:57
 * Description: 产品
 */

@ApiModel(value = "ProductCriteria",description = "产品")
@Data
public class ProductCriteria {
    @ApiModelProperty(value = "id")
    private Long id;
    @ApiModelProperty(value = "标题")
    private String title;
    @ApiModelProperty(value = "种类")
    private String category;
    @ApiModelProperty(value = "品牌")
    private String brand;
    @ApiModelProperty(value = "价格")
    private Double price;
    @ApiModelProperty(value = "图片")
    private String images;

}
