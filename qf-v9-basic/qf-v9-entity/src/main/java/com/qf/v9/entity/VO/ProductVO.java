package com.qf.v9.entity.VO;

import com.qf.v9.entity.DO.TProductDO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductVO implements Serializable {

    private TProductDO product;
    private String desc;

}
