package com.qf.qfv9searchservice;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class QfV9SearchServiceApplicationTests {


	@Autowired
	private SolrClient solrClient;



	@Test
	public void addTest() throws IOException, SolrServerException {

		SolrInputDocument solrInputDocument=new SolrInputDocument();

		solrInputDocument.setField("id","101");
		solrInputDocument.setField("product_name","张学友香港红馆演唱会门票");
		solrInputDocument.setField("product_price","9999");
		solrInputDocument.setField("product_sale_point","歌神，张学友2019年仅此一次");

		solrClient.add(solrInputDocument);

		solrClient.commit();
	}

	@Test
	public void queryTest() throws IOException, SolrServerException {

		SolrQuery solrQuery=new SolrQuery();
		solrQuery.setQuery("product_name:张学友刘德华同台演出");
		QueryResponse query = solrClient.query(solrQuery);
		SolrDocumentList results = query.getResults();

		for (SolrDocument e:results) {
			System.out.println(e.get("id"));
			System.out.println(e.get("product_name"));
			System.out.println(e.get("product_sale_point"));
		}
	}

}
