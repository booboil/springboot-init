package com.booboil.springbootinit.model.dto.excel;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("时间范围条件")
@Data
public class TimeConditionRange {

    @ApiModelProperty("左范围")
    private String left;

    @ApiModelProperty("右范围")
    private String right;

}
