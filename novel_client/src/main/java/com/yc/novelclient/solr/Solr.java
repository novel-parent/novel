package com.yc.novelclient.solr;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;

/**
 * @author LX
 * @date 2019/5/6 - 21:03
 */
public class Solr {

    public static void main(String[] args) throws SolrServerException {

        long start = System.currentTimeMillis();

        System.out.println(start);

        SolrServer solrServer = new HttpSolrServer("http://39.107.116.158:8080/solr/collection1");

        SolrQuery solrQuery = new SolrQuery();

        System.out.println(System.currentTimeMillis()-start);

        System.out.println("----------------------------");

        solrQuery.set("q", "novel_name:斗罗大陆");

        // 过滤条件
//        solrQuery.set("fq","novel_name:斗罗");

        solrQuery.setStart(0);//设置起始位置

        solrQuery.setRows(10);//设置条数

        solrQuery.setSort("novel_updateTimes", SolrQuery.ORDER.desc);//设置排序

//        solrQuery.addSort("date", SolrQuery.ORDER.desc);
        // 默认域
//        solrQuery.set("df","novel_name");

        // 只查询 指定域
        solrQuery.set("fl","id,novel_name,novel_type,novel_author,novel_updateTimes");

        QueryResponse query = solrServer.query(solrQuery);

        SolrDocumentList documents = query.getResults();

        long numFound = documents.getNumFound();

        System.out.println(numFound);

        for(SolrDocument doc : documents){

            System.out.println(doc.get("id"));
            System.out.println(doc.get("novel_name"));
            System.out.println(doc.get("novel_author"));
            System.out.println(doc.get("novel_type"));
            System.out.println(doc.get("novel_updateTimes"));
            System.out.println("");
        }
        System.out.println(System.currentTimeMillis()-start);

    }
}
