import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.LogarithmicAxis;
import org.jfree.chart.plot.FastScatterPlot;
import org.jfree.data.time.Millisecond;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PingForm {
    private JPanel panel1;
    private JButton closeButton;
    private ChartPanel chartPanel1;
    private JFreeChart chart;
    private FastScatterPlot plot;
    private XYDataset dataSet;
    private TimeSeries data;

    public PingForm start() {
        JFrame frame = new JFrame("PingForm");
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        return this;
    }

    public PingForm() {
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    private void createUIComponents() {
        data = new TimeSeries("Ping");
        dataSet = new TimeSeriesCollection(data);

        chart = ChartFactory.createTimeSeriesChart("", "", "", dataSet);
        chart.getXYPlot().setRangeAxis(new LogarithmicAxis("Ping"));
        chartPanel1 = new ChartPanel(chart);
    }

    public void plotData(double newData) {
        data.add(new Millisecond(), newData);
    }
}
