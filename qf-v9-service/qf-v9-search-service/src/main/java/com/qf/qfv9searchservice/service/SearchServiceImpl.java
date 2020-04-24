package com.qf.qfv9searchservice.service;

import Util.ResultBean;
import com.alibaba.dubbo.config.annotation.Service;
import com.google.common.collect.Lists;
import com.qf.api.search.ISearchService;
import com.qf.jpa.repository.ProductRepository;
import com.qf.v9.entity.DO.TProductDO;
import com.sun.tools.javac.main.Main;
import org.apache.commons.lang3.StringUtils;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@Component
@Service
public class SearchServiceImpl implements ISearchService {

    @Resource
    private ProductRepository productRepository;

    @Autowired
    private SolrClient solrClient;

    @Override
    public ResultBean initAllData() {

        //获取到数据库的数据
        List<TProductDO> list = productRepository.listAllProduct();
        //将数据转化documnet ，保存到solr中

        for (TProductDO p : list) {

            //p->documnet
            SolrInputDocument document = new SolrInputDocument();
            document.setField("id", p.getId());
            document.setField("product_name", p.getName());
            document.setField("product_sale_point", p.getSalePoint());
            document.setField("product_price", p.getPrice());

            try {
                solrClient.add(document);

            } catch (SolrServerException | IOException e) {
                e.printStackTrace();
                return ResultBean.error("添加到索引库失败");
            }
        }
        try {
            solrClient.commit();
        } catch (SolrServerException | IOException e) {
            e.printStackTrace();
            return ResultBean.error("添加到索引库失败");
        }

        return ResultBean.success("数据同步成功");
    }

    @Override
    public List<TProductDO> searchByKeyWord(String keyWord) {

        //组装查询条件
        SolrQuery solrQuery = new SolrQuery();

        //判断条件为空
        if (!StringUtils.isAllEmpty(keyWord)) {
            solrQuery.setQuery("product_keywords:" + keyWord);
        } else {
            solrQuery.setQuery("product_keywords:华为");
        }

        //添加高亮
        solrQuery.setHighlight(true);
        solrQuery.addHighlightField("product_sale_point");
        solrQuery.setHighlightSimplePre("<font color='red'>");
        solrQuery.setHighlightSimplePost("</font>");

        List<TProductDO> results = Lists.newArrayList();
        try {
            QueryResponse response = solrClient.query(solrQuery);
            SolrDocumentList list = response.getResults();

            Map<String, Map<String, List<String>>> highlighting = response.getHighlighting();
            list.forEach(item -> {
                TProductDO p = new TProductDO();
                p.setId(Long.parseLong(item.get("id").toString()));
                p.setName(item.get("product_name").toString());
                p.setSalePoint(highlighting.get(item.get("id")).get("product_sale_point").get(0));
                p.setPrice(Long.parseLong(item.get("product_price").toString()));
                results.add(p);
            });
        } catch (SolrServerException | IOException e) {
            e.printStackTrace();
        }

        return results;
    }

    @Override
    public ResultBean updateById(Long id) {

        Optional<TProductDO> byId = productRepository.findById(id);
        TProductDO p = byId.get();


        SolrInputDocument document = new SolrInputDocument();
        document.setField("id", p.getId());
        document.setField("product_name", p.getName());
        document.setField("product_sale_point", p.getSalePoint());
        document.setField("product_price", p.getPrice());

        try {
            solrClient.add(document);

        } catch (SolrServerException | IOException e) {
            e.printStackTrace();
            return ResultBean.error("添加索引失败");
        }

        try {
            solrClient.commit();

        } catch (SolrServerException | IOException e) {
            e.printStackTrace();
            return ResultBean.error("添加索引失败");
        }

        return ResultBean.success("添加索引成功");
    }
}
