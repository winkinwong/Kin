package com.kin.test.springboot.global.util;


import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @program: springboot0918
 * @description: 测试饼状图demo
 * @author: 黄永健
 * @create: 2019-10-08 14:17
 **/
public class PieChart_AWT
{
    public static void main( String[ ] args ) throws IOException {
        DefaultPieDataset dataset = new DefaultPieDataset( );
        dataset.setValue("IPhone 5s", new Double( 20 ) );
        dataset.setValue("SamSung Grand", new Double( 20 ) );
        dataset.setValue("MotoG", new Double( 40 ) );
        dataset.setValue("Nokia Lumia", new Double( 10 ) );

        JFreeChart chart = ChartFactory.createPieChart(
                "Mobile Sales", // chart title
                dataset, // data
                true, // include legend
                true,
                false);

        int width = 640; /* Width of the image */
        int height = 480; /* Height of the image */
        File pieChart = new File( "/Users/bd_mac/Desktop/patrolInspectSystemFiles/charts/DailyPie"+ UUID.randomUUID().toString().replace("-", "")+".png");
        ChartUtilities.saveChartAsJPEG( pieChart , chart , width , height );


    }
}

