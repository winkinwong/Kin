package com.kin.test.springboot.global.util;


import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

import java.awt.*;
import java.io.File;
import java.util.UUID;

/**
 * @program: springboot0918
 * @description: 折线图demo
 * @author: 黄永健
 * @create: 2019-10-08 15:26
 **/
public class XYLineChart_image
{
    public static void main( String[ ] args )throws Exception
    {

        // 绘图数据集
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(212, "Classes", "JDK 1.0");
        dataset.addValue(504, "Classes", "JDK 1.1");
        dataset.addValue(1520, "Classes", "JDK 1.2");
        dataset.addValue(1842, "Classes", "JDK 1.3");
        dataset.addValue(2991, "Classes", "JDK 1.4");
        dataset.addValue(3500, "Classes", "JDK 1.5");

        JFreeChart chart = ChartFactory.createLineChart("图表标题", "X轴标题", "Y轴标题", dataset,
                PlotOrientation.VERTICAL, // 绘制方向
                true, // 显示图例
                true, // 采用标准生成器
                false // 是否生成超链接
        );

        Font font1 = new Font("黑体",Font.BOLD,20);
        Font font2 = new Font("黑体",Font.BOLD,12);
        chart.getTitle().setFont(font1); // 设置标题字体
        chart.getLegend().setItemFont(font2);// 设置图例类别字体
        chart.setBackgroundPaint(Color.GREEN);// 设置背景色
        //获取绘图区对象
        CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(Color.LIGHT_GRAY); // 设置绘图区背景色
        plot.setRangeGridlinePaint(Color.WHITE); // 设置水平方向背景线颜色
        plot.setRangeGridlinesVisible(true);// 设置是否显示水平方向背景线,默认值为true
        plot.setDomainGridlinePaint(Color.WHITE); // 设置垂直方向背景线颜色
        plot.setDomainGridlinesVisible(true); // 设置是否显示垂直方向背景线,默认值为false


        CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setLabelFont(font2); // 设置横轴字体
        domainAxis.setTickLabelFont(font2);// 设置坐标轴标尺值字体
        domainAxis.setLowerMargin(0.01);// 左边距 边框距离
        domainAxis.setUpperMargin(0.06);// 右边距 边框距离,防止最后边的一个数据靠近了坐标轴。
        domainAxis.setMaximumCategoryLabelLines(2);

        ValueAxis rangeAxis = plot.getRangeAxis();
        rangeAxis.setLabelFont(font2);
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());//Y轴显示整数
        rangeAxis.setAutoRangeMinimumSize(1);   //最小跨度
        rangeAxis.setUpperMargin(0.18);//上边距,防止最大的一个数据靠近了坐标轴。
        rangeAxis.setLowerBound(0);   //最小值显示0
        rangeAxis.setAutoRange(false);   //不自动分配Y轴数据
        rangeAxis.setTickMarkStroke(new BasicStroke(1.6f));     // 设置坐标标记大小
        rangeAxis.setTickMarkPaint(Color.BLACK);     // 设置坐标标记颜色



        // 获取折线对象
        LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot.getRenderer();
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

        plot.setNoDataMessage("无对应的数据，请重新查询。");
        plot.setNoDataMessageFont(font1);//字体的大小
        plot.setNoDataMessagePaint(Color.RED);//字体颜色
        File pieChart = new File( "xyLine"+ UUID.randomUUID().toString().replace("-", "")+".jpeg");
        int width = 640; /* Width of the image */
        int height = 480; /* Height of the image */
        ChartUtilities.saveChartAsJPEG(pieChart, chart , width , height );
    }
}

