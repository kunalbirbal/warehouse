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
public class UomUtil {
	
	// Method to generate Pie Chart
	public void generatePie(String path, List<Object[]> data) {
		
		// 1. converting dataset
		DefaultPieDataset dataset = new DefaultPieDataset();
		for(Object[] d:data) {
			dataset.setValue(d[0].toString(), new Double(d[1].toString()));
		}
		
		// 2. convert dataset to Jfreechart
		JFreeChart chart = ChartFactory.createPieChart3D("Uom Pie Chart", dataset, true, true, false);
		
		// 3. save image
		try {
			ChartUtils.saveChartAsPNG(new File(path+"/resources/images/uompie.png"), chart, 300, 250);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	// Method to generate Bar Chart
	public void generateBar(String path, List<Object[]> data) {
		
		// 1. create Dataset
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for(Object[] d:data) {
			dataset.setValue(new Double(d[1].toString()), d[0].toString(), "");
		}
		
		// 2. convert dataset to JFreeChart
		JFreeChart chart = ChartFactory.createBarChart("Uom", "UOM TYPE", "COUNT", dataset);
		
		// 3. save image
		try {
			ChartUtils.saveChartAsPNG(new File(path+"/resources/images/uombar.png"), chart, 300, 250);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
