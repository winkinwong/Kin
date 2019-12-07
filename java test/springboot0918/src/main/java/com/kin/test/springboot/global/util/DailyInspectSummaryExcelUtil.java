package com.kin.test.springboot.global.util;

import com.kin.test.springboot.global.basic.ConstantConfiguration;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.DecimalFormat;

public class DailyInspectSummaryExcelUtil {
	
	/**
	 * 柱状图,折线图 数据集
	 * @param data 每个柱子的具体的数值/第一维表示有多少个分组,第二维表示每个分组的每个柱子的数值
	 * @param rowKeys 每组柱子的统一名称
	 * @param columnKeys 每根柱子的名称
	 * @return
	 */
	public static CategoryDataset getBarData(double[][] data, String[] rowKeys, String[] columnKeys) {
		//data:每个柱子的具体的数值/第一维表示有多少个分组,第二维表示每个分组的每个柱子的数值
		//rowKeys:
		//columnKeys:柱子的名称
		return DatasetUtilities.createCategoryDataset(rowKeys, columnKeys, data);

	}
	
	
	/**
	 * 横向图
	 * 
	 * @param dataset    数据集
	 * @param xName      x轴的说明（如种类，时间等）
	 * @param yName      y轴的说明（如速度，时间等）
	 * @param chartTitle 图标题
	 * @param charName   生成图片的名字
	 * @return
	 */
	public static String createHorizontalBarChart(CategoryDataset dataset, String xName, String yName, String chartTitle,
			String charName) {
		JFreeChart chart = ChartFactory.createBarChart(chartTitle, // 图表标题
				xName, // 目录轴的显示标签
				yName, // 数值轴的显示标签
				dataset, // 数据集
				PlotOrientation.VERTICAL, // 图表方向：水平、垂直
				true, // 是否显示图例(对于简单的柱状图必须是false)
				false, // 是否生成工具
				false // 是否生成URL链接
		);

		CategoryPlot plot = chart.getCategoryPlot();
		// 数据轴精度
		NumberAxis vn = (NumberAxis) plot.getRangeAxis();
		// 设置刻度必须从0开始
		// vn.setAutoRangeIncludesZero(true);
		DecimalFormat df = new DecimalFormat("#0.00");
		vn.setNumberFormatOverride(df); // 数据轴数据标签的显示格式

		CategoryAxis domainAxis = plot.getDomainAxis();

		domainAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45); // 横轴上的
		// Lable
		Font labelFont = new Font("黑体", Font.TRUETYPE_FONT, 12);

		domainAxis.setLabelFont(labelFont);// 轴标题
		domainAxis.setTickLabelFont(labelFont);// 轴数值
		
		
		
		//设置字体,否则会出现中文变成方框乱码的情况
		chart.getTitle().setFont(labelFont);
		Font titleFont = new Font("黑体", Font.BOLD, 20);
		TextTitle textTitle = chart.getTitle();
		textTitle.setFont(titleFont);// 为标题设置上字体
		 
		Font LegendFont = new Font("黑体", Font.PLAIN, 18);
		LegendTitle legend = chart.getLegend(0);
		legend.setItemFont(LegendFont);// 为图例说明设置字体
		
		
		

		domainAxis.setMaximumCategoryLabelWidthRatio(0.8f);// 横轴上的 Lable 是否完整显示
		// domainAxis.setVerticalCategoryLabels(false);
		plot.setDomainAxis(domainAxis);

		ValueAxis rangeAxis = plot.getRangeAxis();
		// 设置最高的一个 Item 与图片顶端的距离
		rangeAxis.setUpperMargin(0.15);
		// 设置最低的一个 Item 与图片底端的距离
		rangeAxis.setLowerMargin(0.15);
		plot.setRangeAxis(rangeAxis);
		BarRenderer renderer = new BarRenderer();
		// 设置柱子宽度
		renderer.setMaximumBarWidth(0.03);
		// 设置柱子高度
		renderer.setMinimumBarLength(30);

		renderer.setBaseOutlinePaint(Color.BLACK);

		// 设置柱的颜色
		renderer.setSeriesPaint(0, Color.GREEN);
		renderer.setSeriesPaint(1, new Color(0, 0, 255));
		// 设置每个地区所包含的平行柱的之间距离
		renderer.setItemMargin(0.5);
		// 显示每个柱的数值，并修改该数值的字体属性
		renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
		// 设置柱的数值可见
		renderer.setBaseItemLabelsVisible(true);

		plot.setRenderer(renderer);
		// 设置柱的透明度
		plot.setForegroundAlpha(0.6f);

		FileOutputStream fos_jpg = null;
		try {
			isChartPathExist(ConstantConfiguration.FILE_PATH);
			String chartName = ConstantConfiguration.FILE_PATH + charName;
			fos_jpg = new FileOutputStream(chartName);
			ChartUtilities.writeChartAsPNG(fos_jpg, chart, 500, 500, true, 10);
			return chartName;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				fos_jpg.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	

	/**
	 * 判断文件夹是否存在，如果不存在则新建
	 * 
	 * @param chartPath
	 */
	private static void isChartPathExist(String chartPath) {
		File file = new File(chartPath);
		if (!file.exists()) {
			file.mkdirs();
			// log.info("CHART_PATH="+CHART_PATH+"create.");
		}
	}
	
	
	public static void setPicture(String pictureFilename,HSSFWorkbook hssfw) {
		FileOutputStream fileOut = null;
		BufferedImage bufferImg = null;
		// 先把读进来的图片放到一个ByteArrayOutputStream中，以便产生ByteArray
		try {
//			ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();
//			
//			bufferImg = ImageIO.read(new File(pictureFilename));
//			ImageIO.write(bufferImg, "png", byteArrayOut);

//			HSSFWorkbook wb = new HSSFWorkbook
//			HSSFSheet sheet1 = wb.createSheet("test picture");
//			// 画图的顶级管理器，一个sheet只能获取一个（一定要注意这点）
//			HSSFPatriarch patriarch = sheet1.createDrawingPatriarch();
//			// anchor主要用于设置图片的属性
//			HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0, 255, 255, (short) 1, 1, (short) 5, 8);
//			anchor.setAnchorType(3);
//			// 插入图片
//			patriarch.createPicture(anchor, wb.addPicture(byteArrayOut.toByteArray(), HSSFWorkbook.PICTURE_TYPE_JPEG));
//			fileOut = new FileOutputStream("D:/测试Excel.xls");
//			// 写入excel文件
//			wb.write(fileOut);
//			System.out.println("----Excle文件已生成------");
//			
//			
			ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();
			
//			pictureFilename=URLDecoder.decode(pictureFilename,"utf-8");//这样就能解决掉那个空格的问题了
			
			bufferImg = ImageIO.read(new File(pictureFilename));
			ImageIO.write(bufferImg, "png", byteArrayOut);
			
			/*
			 * anchor主要用于设置图片的相关位置属性:可以通过构造器来进行具体的设置
			 * 1)第一个参数:图片左上起点在指定单元格中的横坐标位置:0~1023(1023是一个单元格宽度的最大值,表示刚好占满单元格的宽度)
			 * 2)第二个参数:图片左上起点在指定单元格中的纵坐标位置:0~255(255是一个单元格的高度,表示刚好占满单元格的高度)
			 * 3)第三个参数:图片右下终点在指定单元格中的横坐标位置:0~1023(1023是一个单元格宽度的最大值,表示刚好占满单元格的宽度)
			 * 4)第四个参数:图片右下终点在指定单元格中的纵坐标位置:0~255(255是一个单元格的高度,表示刚好占满单元格的高度)
			 * 5)第五个参数:图片的起点所在的指定单元格的横向序号(从0开始计)
			 * 6)第六个参数:图片的起点所在的指定单元格的纵向序号(从0开始计)
			 * 7)第七个参数:图片的终点所在的指定单元格的横向序号(从0开始计)
			 * 8)第八个参数:图片的终点所在的指定单元格的纵向序号(从0开始计)
			 */
			HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0, 255, 255,(short) 1, 1, (short) 5, 8);
			//设置在Excel中生成的图片随单元格移动但不调整大小
			anchor.setAnchorType(2);
			
			//获取当前excel文件中的第一页
			HSSFSheet sheet=hssfw.getSheetAt(0);
			
			//画图的顶级管理器:一个Excel页中(HSSFSheet)只能获取一个HSSFPatriarch对象(一定要注意这点)
			HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
			
			patriarch.createPicture(anchor, hssfw.addPicture(byteArrayOut.toByteArray(), HSSFWorkbook.PICTURE_TYPE_PNG));
//			patriarch.createPicture(anchor, hssfw.addPicture(byteArrayOut.toByteArray(), HSSFWorkbook.PICTURE_TYPE_JPEG));
			
//			if(fileSuffix.equals("png")){
//				//如果当前图片文件的后缀是png
//				patriarch.createPicture(anchor, hssfw.addPicture(byteArrayOut.toByteArray(), HSSFWorkbook.PICTURE_TYPE_PNG));
//			}else if(fileSuffix.equals("jpg")){
//				//如果当前图片文件的后缀是jpg
//				patriarch.createPicture(anchor, hssfw.addPicture(byteArrayOut.toByteArray(), HSSFWorkbook.PICTURE_TYPE_JPEG));
//			}else{
//				//如果当前图片文件的后缀既不是png也不是jpg,则属性录入失败
//				System.err.println("当前图片文件的后缀既不是png也不是jpg,该属性录入失败:按空值处理..");
//				//这里编译器有bug,需要这样写才能通过编译(如果换用其他的编译器可能不需要这样写)
//				bodyRow.createCell(j).setCellValue("".equals("")?null:"");
//			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fileOut != null) {
				try {
					fileOut.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * 导出指定的Excel文件
	 * @param excelFileName 导出的Excel文件的文件名
	 * @param hssfw 需要导出的Excel文件的对象
	 * @param res 当前请求对应的响应对象
	 */
	public static void exportExcel(String excelFileName,HSSFWorkbook hssfw,HttpServletResponse res){
		try {
            try {
            	excelFileName = new String(excelFileName.getBytes(),"ISO8859-1");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            res.setContentType("application/octet-stream;charset=ISO8859-1");
            res.setCharacterEncoding("UTF-8");
            res.setHeader("Content-Disposition", "attachment;filename="+ excelFileName);
            res.addHeader("Pargam", "no-cache");
            res.addHeader("Cache-Control", "no-cache");
            
            OutputStream out=res.getOutputStream();//获取当前响应对象的输出流
			hssfw.write(out);//将当前的Eccel文件放入当前相应对象的输出流对象中
			out.flush();//将当前输出流中存放的内容输出到指定的位置上
			out.close();//关闭当前输出流对象
        } catch (Exception ex) {
            ex.printStackTrace();
        }
	}
	
}
