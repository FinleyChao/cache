package com.foolish.springcache.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import lombok.experimental.Tolerate;

/**
 * <p>
 * 
 * </p>
 *
 * @author cxf
 * @since 2020-01-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Builder
public class Department implements Serializable {

    private static final long serialVersionUID = 1L;

    @Tolerate
    public Department() {

    }

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String departmentName;


}
