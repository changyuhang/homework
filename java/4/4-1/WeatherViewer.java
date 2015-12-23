package ntou.cs.java2015.yuhang;

import java.awt.*;
import java.awt.event.*;
import java.util.logging.*;
import javax.swing.*;
import java.io.IOException;

public class WeatherViewer {
    Frame frame;
    JLabel label1,label2,label3,label4;
    JComboBox comboBox1, comboBox2, comboBox3;
    JTextField textField1, textField2;
    TemperatureBundle temperatureBundle;
    String[] place = {"請選擇", "基隆市", "新北市", "台北市", "桃園市"};
    String[] date, dayTemps, nightTemps;

    public WeatherViewer() {
        label1=new JLabel("請選擇城市：");
        label2=new JLabel("請選擇日期：");
        label3=new JLabel("白天氣溫：");
        label4=new JLabel("晚上氣溫：");

        comboBox1 = new JComboBox(place);
        comboBox2 = new JComboBox();

        comboBox1.addActionListener(new ActionListenerImpl());
        comboBox2.addActionListener(new ActionListenerImpl());

        textField1 = new JTextField();
        textField2 = new JTextField();
        textField1.setEditable(false);
        textField2.setEditable(false);

        frame = new Frame("WeatherViewer");
        frame.setLayout(new GridLayout(4, 2));
        frame.add(label1);  frame.add(comboBox1);
        frame.add(label2);  frame.add(comboBox2);
        frame.add(label3);  frame.add(textField1);
        frame.add(label4);  frame.add(textField2);
        frame.pack();
        frame.setVisible(true);
        frame.addWindowListener(new ExitWindow());
    }

    public void itemChanged() {
        try {
            temperatureBundle = TemperatureFetcher.getTemperature((String) comboBox1.getSelectedItem());
        } catch (IOException | IndexOutOfBoundsException ex) {
            Logger.getLogger(WeatherViewer.class.getName()).log(Level.SEVERE, null, ex);
        }
        dayTemps = temperatureBundle.getDayTemps();
        nightTemps = temperatureBundle.getNightTemps();
    }

    private class ActionListenerImpl implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            itemChanged();
            if (date == null) {
                comboBox2.removeAllItems();
                date = temperatureBundle.getWeekDates();
                for (String day : date)
                    comboBox2.addItem(day);
            }
            if(comboBox1.getItemAt(0).toString().matches("請選擇")){
                comboBox1.removeAllItems();
                for (int i=1;i<5;i++)
                    comboBox1.addItem(place[i]);
            }
            textField1.setText(dayTemps[comboBox2.getSelectedIndex()]);
            textField2.setText(nightTemps[comboBox2.getSelectedIndex()]);
        }
    }

}
