package com.kin.test.springboot.global.util;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

import java.awt.*;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class DailyInspectSummaryCreateChartsUtil {
	/** 统计图的头标题的默认值 */
	public static final String HEAD_TITLE="日常点检情况汇总";
	/** 柱状图的x轴标题 */
	public static final String X_Title="若干个危险源地点";
	/** 柱状图的y轴标题 */
	public static final String Y_TITLE="次数";
	/** 默认的字体 */
	public static final String FONT="宋体";
	/** 默认的字号 */
	public static final Integer FONT_SIZE=15;
	/** 默认的生成图片的宽度 */
	public static final Integer WIDTH=2640;
	/** 默认的生成图片的高度 */
	public static final Integer HEIGHT=480;
	/** 默认的生成图片文件存放的文件夹路径 */
	public static final String FILE_PATH="D://";
	/** 默认的生成图片文件的后缀名 */
	public static final String FILE_SUFFIX=".jpg";
	
	public static String createCharts(List<Map<String, Object>> dataMaps,Map<String, Object> groupMap,String headTitle,String xTitle,String yTitle,
			Integer width,Integer height,String filePath) throws Exception{
		//参数值验证与调整
		if(dataMaps==null||dataMaps.size()==0) {
			System.err.println("生成柱状图所需要的统计数据不能为空,图片文件生成失败..");
			return null;
		}
		if(groupMap==null||groupMap.isEmpty()) {
			System.err.println("生成柱状图所需要的分组数据不能为空,图片文件生成失败..");
			return null;
		}
		if(headTitle==null) {
			headTitle=HEAD_TITLE;
		}
		if(xTitle==null) {
			xTitle=X_Title;
		}
		if(yTitle==null) {
			yTitle=Y_TITLE;
		}
		if(width==null||width<=0) {
			width=WIDTH;
		}
		if(height==null||height<=0) {
			height=HEIGHT;
		}
		if(filePath==null||"".equals(filePath)) {
			filePath=FILE_PATH+UUID.randomUUID().toString().replace("-", "")+FILE_SUFFIX;
		}
		
		
		final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		
		for (int i = 0; i < dataMaps.size(); i++) {
			Map<String, Object> dataMap=dataMaps.get(i);
			String dangeroussourcePlaceName=(String) dataMap.get("dangeroussourcePlaceName");
			
			Set<String> keys=groupMap.keySet();
			for (String key : keys) {
				Integer value=(Integer)dataMap.get(key);
				String name=(String)groupMap.get(key);
				dataset.addValue( value , name , dangeroussourcePlaceName );
			}
			
		}
		
		
		JFreeChart barChart = ChartFactory.createBarChart(
			headTitle,//统计图的头标题
			xTitle,//柱状图的x轴标题
			yTitle,//柱状图的y轴标题
			dataset,PlotOrientation.VERTICAL, 
			true, true, false);
		
		//+++++++++++++处理中文显示乱码
		//处理主标题乱码
		barChart.getTitle().setFont(new Font(FONT,Font.BOLD,FONT_SIZE+3));
		//处理子标题乱码
		barChart.getLegend().setItemFont(new Font(FONT,Font.BOLD,FONT_SIZE));
//		barChart.getLegend().setPosition(RectangleEdge.RIGHT);//右侧显示子菜单
		
		//调出图表区域对象
		CategoryPlot categoryPlot = (CategoryPlot) barChart.getPlot();
		//获取到X轴
		CategoryAxis categoryAxis = (CategoryAxis) categoryPlot.getDomainAxis();
		//获取到Y轴
		NumberAxis numberAxis = (NumberAxis) categoryPlot.getRangeAxis();
		//处理X轴外的乱码
		categoryAxis.setLabelFont(new Font(FONT,Font.BOLD,FONT_SIZE));
		//处理X轴上的乱码
		categoryAxis.setTickLabelFont(new Font(FONT,Font.BOLD,FONT_SIZE));
		//处理Y轴外的乱码
		numberAxis.setLabelFont(new Font(FONT,Font.BOLD,FONT_SIZE));
		//处理Y轴上的乱码
		numberAxis.setTickLabelFont(new Font(FONT,Font.BOLD,FONT_SIZE));
		//+++++++++++++
		
		//处理图形，先要获取绘图区域对象
		BarRenderer barRenderer = (BarRenderer) categoryPlot.getRenderer();
		//设置图形的宽度
//				barRenderer.setMaximumBarWidth(0.1);
		
		//在图形上显示对应数值
		barRenderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
		barRenderer.setBaseItemLabelsVisible(true);
		barRenderer.setBaseItemLabelFont(new Font(FONT,Font.BOLD,FONT_SIZE));
		
		/* Width of the image */
//		width = 2640;
		/* Height of the image */
//		height = 480;
		File barChartFile=null;
		try {
			barChartFile = new File(filePath);
		}catch (Exception e) {
			System.err.println("指定路径的文件不存在或是一个已经存在的文件夹,生成图片文件失败..");
			return null;
		}
		
		String fileSuffix=filePath.split("\\.")[1];
		if("jpg".equals(fileSuffix)||"jpeg".equals(fileSuffix)||"JPG".equals(fileSuffix)||"JPEG".equals(fileSuffix)) {
			ChartUtilities.saveChartAsJPEG( barChartFile , barChart , width , height );
		}else if("png".equals(fileSuffix)||"PNG".equals(fileSuffix)) {
			ChartUtilities.saveChartAsPNG(barChartFile, barChart, width, height);
		}else {
			System.err.println("文件后缀名错误,图片文件生成失败..");
			return null;
		}
		System.out.println("多组柱状统计图图片文件生成成功..");
		
		return filePath;
	}
	
}
