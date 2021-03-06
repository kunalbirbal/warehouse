package com.app.util;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.stereotype.Component;

@Component
public class WhUserTypeUtil {
	
	// Pie Chart Method
	public void generatePie(String path, List<Object[]> data) {
		
		// 1. Create Dataset
		DefaultPieDataset dataset = new DefaultPieDataset();
		for(Object[] d:data) {
			dataset.setValue(d[0].toString(), new Double(d[1].toString()));
		}
		
		// 2. Convert Dataset to JFreeChart
		JFreeChart chart = ChartFactory.createPieChart3D("Wh User Type", dataset, true, true, false);
		
		// 3. save image
		try {
			ChartUtils.saveChartAsPNG(new File(path+"/resources/images/whuserpie.png"), chart, 300, 250);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	// Bar Chart Method
	public void generateBar(String path, List<Object[]> data) {
		
		// 1. Create DataSet
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for(Object[] d:data) {
			dataset.setValue(new Double(d[1].toString()), d[0].toString(), "");
		}
		
		// 2. convert dataset to JfreeChart
		JFreeChart chart = ChartFactory.createBarChart("WH User Type", "USER TYPE", "COUNT", dataset);
		
		// 3. save image
		try {
			ChartUtils.saveChartAsPNG(new File(path+"/resources/images/whuserbar.png"), chart, 300, 250);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
