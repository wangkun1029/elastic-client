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

@ApiModel(value = "ProductSearchCriteria",description = "产品")
@Data
public class ProductSearchCriteria {

    @ApiModelProperty(value = "标题")
    private String title;

}
