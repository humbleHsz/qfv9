package com.qf.v9.entity.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.List;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageInfo<T> implements Serializable {


    private Integer size;

    private Integer index;

    private Integer totalPages;

    private boolean hasPre;

    private boolean hasNext;

    private List<T> list;


}
