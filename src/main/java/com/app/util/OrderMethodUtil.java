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
public class OrderMethodUtil {
	
	// Method to generate Pie Chart
	public void generatePie(String path, List<Object[]> data) {
		
		// 1. converting dataset
		DefaultPieDataset dataset = new DefaultPieDataset();
		for(Object[] d:data) {
			dataset.setValue(d[0].toString(), new Double(d[1].toString()));
		}
		
		// 2. convert dataset to jfree chart
		JFreeChart chart = ChartFactory.createPieChart3D("Order Method", dataset, true, true, false);
		
		// 3. save as image
		try {
			ChartUtils.saveChartAsPNG(new File(path+"/resources/images/ompie.png"), chart, 300, 250);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	// Method to generate Bar Chart
	public void generateBar(String path, List<Object[]> data) {
		
		// 1. Create DataSet
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for(Object[] d:data) {
			dataset.setValue(new Double(d[1].toString()), d[0].toString(), "");
		}
		
		// 2. convert dataset to jfree chart
		JFreeChart chart = ChartFactory.createBarChart("Order Method", "ORDER MODE", "COUNT", dataset);
		
		// 3. save as image
		try {
			ChartUtils.saveChartAsPNG(new File(path+"/resources/images/ombar.png"), chart, 300, 250);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
