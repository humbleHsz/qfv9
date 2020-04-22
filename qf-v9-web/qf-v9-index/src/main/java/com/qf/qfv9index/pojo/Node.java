package com.qf.qfv9index.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Node implements Serializable {

    String name;
    Long id;
    Long pid;
    List<Node> list = new ArrayList<>();

}
