package com.kin.test.springboot.global.util;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

import java.awt.*;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class DailyInspectSummaryCreateXYLIineChartsUtil {
	/** 统计图的头标题的默认值 */
	public static final String HEAD_TITLE="日常点检情况汇总";
	/** 柱状图的x轴标题 */
	public static final String X_Title="若干个危险源地点";
	/** 柱状图的y轴标题 */
	public static final String Y_TITLE="次数";
	/** 默认的字体 */
	public static final String FONT="宋体";
	/** 默认的字号 */
	public static final Integer FONT_SIZE=12;
	/** 默认的生成图片的宽度 */
	public static final Integer WIDTH=2640;
	/** 默认的生成图片的高度 */
	public static final Integer HEIGHT=480;
	/** 默认的生成图片文件存放的文件夹路径 */
	public static final String FILE_PATH="D://";
	/** 默认的生成图片文件的后缀名 */
	public static final String FILE_SUFFIX=".jpg";
	
	public static String createXYLineCharts(List<Map<String, Object>> dataMaps,Map<String, Object> groupMap,String headTitle,String xTitle,String yTitle,
			Integer width,Integer height,String filePath) throws Exception{
		//参数值验证与调整
		if(dataMaps==null||dataMaps.size()==0) {
			System.err.println("生成折线图所需要的统计数据不能为空,图片文件生成失败..");
			return null;
		}
		if(groupMap==null||groupMap.isEmpty()) {
			System.err.println("生成折线图所需要的分组数据不能为空,图片文件生成失败..");
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
		
		
		final  DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		
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


		JFreeChart lineChart = ChartFactory.createLineChart(HEAD_TITLE, X_Title, Y_TITLE, dataset,
				PlotOrientation.VERTICAL, // 绘制方向
				true, // 显示图例
				true, // 采用标准生成器
				false // 是否生成超链接
		);
		/*JFreeChart barChart = ChartFactory.createBarChart(
			headTitle,//统计图的头标题
			xTitle,//柱状图的x轴标题
			yTitle,//柱状图的y轴标题
			dataset,PlotOrientation.VERTICAL, 
			true, true, false);*/
		
		//+++++++++++++处理中文显示乱码
		Font font1 = new Font(FONT,Font.BOLD,20);
		Font font2 = new Font(FONT,Font.BOLD,FONT_SIZE);
		//处理主标题乱码
		lineChart.getTitle().setFont(font1);
		//处理子标题乱码
		lineChart.getLegend().setItemFont(font2);
//		barChart.getLegend().setPosition(RectangleEdge.RIGHT);//右侧显示子菜单
		lineChart.setBackgroundPaint(Color.white);// 设置背景色
		//调出图表区域对象
		CategoryPlot categoryPlot =lineChart.getCategoryPlot();
		categoryPlot.setBackgroundPaint(Color.LIGHT_GRAY); // 设置绘图区背景色
		categoryPlot.setRangeGridlinePaint(Color.WHITE); // 设置水平方向背景线颜色
		categoryPlot.setRangeGridlinesVisible(true);// 设置是否显示水平方向背景线,默认值为true
		categoryPlot.setDomainGridlinePaint(Color.WHITE); // 设置垂直方向背景线颜色
		categoryPlot.setDomainGridlinesVisible(true); // 设置是否显示垂直方向背景线,默认值为false


		//获取到X轴
		CategoryAxis categoryAxis = (CategoryAxis) categoryPlot.getDomainAxis();

		//处理X轴外的乱码
		categoryAxis.setLabelFont(font2); // 设置横轴字体
		//处理X轴上的乱码
		categoryAxis.setTickLabelFont(font2);// 设置坐标轴标尺值字体
		categoryAxis.setLowerMargin(0.01);// 左边距 边框距离
		categoryAxis.setUpperMargin(0.06);// 右边距 边框距离,防止最后边的一个数据靠近了坐标轴。
		categoryAxis.setMaximumCategoryLabelLines(2);
		//获取到Y轴
		ValueAxis rangeAxis = categoryPlot.getRangeAxis();
		rangeAxis.setLabelFont(font2);
		rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());//Y轴显示整数
		rangeAxis.setAutoRangeMinimumSize(1);   //最小跨度
		rangeAxis.setUpperMargin(0.18);//上边距,防止最大的一个数据靠近了坐标轴。
		rangeAxis.setLowerBound(0);   //最小值显示0
		rangeAxis.setAutoRange(false);   //不自动分配Y轴数据
		rangeAxis.setTickMarkStroke(new BasicStroke(1.6f));     // 设置坐标标记大小
		rangeAxis.setTickMarkPaint(Color.BLACK);     // 设置坐标标记颜色

		//+++++++++++++
		
		//处理图形，先要获取绘图区域对象
		// 获取折线对象
		LineAndShapeRenderer renderer = (LineAndShapeRenderer) categoryPlot.getRenderer();
		BasicStroke realLine = new BasicStroke(1.8f); // 设置实线
		// 设置虚线
		float dashes[] = { 5.0f };
		BasicStroke brokenLine = new BasicStroke(2.2f, // 线条粗细
				BasicStroke.CAP_ROUND, // 端点风格
				BasicStroke.JOIN_ROUND, // 折点风格
				8f, dashes, 0.6f);
		for (int i = 0; i < dataset.getRowCount(); i++) {
			if (i % 2 == 0)
				renderer.setSeriesStroke(i, realLine); // 利用实线绘制
			else
				renderer.setSeriesStroke(i, brokenLine); // 利用虚线绘制
		}
		//设置图形的宽度
//				barRenderer.setMaximumBarWidth(0.1);
		
		/* Width of the image */
//		width = 2640;
		/* Height of the image */
//		height = 480;
		File lineChartFile=null;
		try {
			lineChartFile = new File(filePath);
		}catch (Exception e) {
			System.err.println("指定路径的文件不存在或是一个已经存在的文件夹,生成图片文件失败..");
			return null;
		}
		
		String fileSuffix=filePath.split("\\.")[1];
		if("jpg".equals(fileSuffix)||"jpeg".equals(fileSuffix)||"JPG".equals(fileSuffix)||"JPEG".equals(fileSuffix)) {
			ChartUtilities.saveChartAsJPEG( lineChartFile , lineChart , width , height );
		}else if("png".equals(fileSuffix)||"PNG".equals(fileSuffix)) {
			ChartUtilities.saveChartAsPNG(lineChartFile, lineChart, width, height);
		}else {
			System.err.println("文件后缀名错误,图片文件生成失败..");
			return null;
		}
		System.out.println("多组柱状统计图图片文件生成成功..");
		
		return filePath;
	}
	
}
