package com.example.demo.util;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.github.sarxos.webcam.WebcamUtils;
import com.github.sarxos.webcam.util.ImageUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
//使用并发方式照相
//                SwingUtilities.invokeLater(new Runnable() {
//
//                    @Override
//                    public void run() {
//                    }
//                });
//                //实现拍照保存-------end
public class SolvePicture {
    private static JFrame window;
    private static String fileName;


    public static String getPicture() {
        Webcam webcam = Webcam.getDefault();
        webcam.setViewSize(WebcamResolution.VGA.getSize());

        WebcamPanel panel = new WebcamPanel(webcam);
        panel.setFPSDisplayed(true);
        panel.setDisplayDebugInfo(true);
        panel.setImageSizeDisplayed(true);
        panel.setMirrored(true);


        JFrame window = new JFrame("Test webcam panel");
        window.add(panel);
        window.setResizable(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.pack();
        window.setVisible(true);


        final JButton button = new JButton("拍照");
        window.add(panel, BorderLayout.CENTER);
        window.add(button, BorderLayout.SOUTH);
        window.setResizable(true);
        window.pack();
        window.setVisible(true);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                button.setEnabled(false);  //设置按钮不可点击

                String tmp = "E:/" + System.currentTimeMillis();
                WebcamUtils.capture(webcam, tmp, ImageUtils.FORMAT_JPG);

                //使用阻塞的方式照相
                JOptionPane.showMessageDialog(null, "拍照成功");
                button.setEnabled(true);    //设置按可点击钮

                fileName = tmp;
            }
        });
        while(fileName == null);
        return fileName;
    }

    public static boolean deletePicture(String name){
        File file = new File(name);
        if(file.exists()){
            file.delete();
            System.out.println("文件删除成功");
            return true;
        }
        else {
            System.out.println("文件删除失败,文件不存在");
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(getPicture());
    }
}
