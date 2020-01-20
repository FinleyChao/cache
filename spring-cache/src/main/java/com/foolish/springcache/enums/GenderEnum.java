package com.foolish.springcache.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.core.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author chaoxianfei
 * @date 2020/01/11
 * @describe
 **/
@Getter
@AllArgsConstructor
public enum GenderEnum implements IEnum<Integer> {

    /**
     * 男枚举
     */
    MAN(0, "男"),
    /**
     * 女枚举
     */
    WOMAN(1, "女");

    private Integer value;

    @JsonValue
    private String desc;


}
