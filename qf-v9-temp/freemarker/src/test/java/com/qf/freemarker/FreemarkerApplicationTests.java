package com.qf.freemarker;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class FreemarkerApplicationTests {


	@Autowired
	private Configuration configuration;


	@Test
	void contextLoads() throws TemplateException {

		try {

			//模版➕数据=输出
			//1.获取到模版对象
			Template template = configuration.getTemplate("freemarker.html");

			//数据
			Map<String ,Object> data= new HashMap<>();
			data.put("name","java1809");

			//两者结合
			FileWriter fw=new FileWriter("/Users/gh_23/Desktop/qfv9/qf-v9-temp/freemarker/src/main/resources/templates/freemarker.ftl");

			template.process(data,fw);


		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
