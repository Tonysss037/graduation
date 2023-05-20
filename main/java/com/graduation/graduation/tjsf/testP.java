package com.graduation.graduation.tjsf;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class testP {
    public static void main(String[] args) {

        // TODO Auto-generated method stub
        Process proc;
        try {
            proc = Runtime.getRuntime().exec("python D:\\Graduation_project\\graduation_recommendation\\Machine_learning.py");// 执行py文件

            // 获取Python脚本的标准输入流
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(proc.getOutputStream()));

            // 向Python脚本传输数据
            writer.write("'t1', 'w1', 'p1', 'd2', 'b1'");
            // 刷新缓冲区并关闭流
            writer.flush();
            writer.close();

            // 用输入流来截取Python脚本的输出结果
            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            StringBuilder output = new StringBuilder();
            String line = null;
            while ((line = in.readLine()) != null) {
//                System.out.println(line);
                output.append(line);
            }
            in.close();
            String pythonOutput = output.toString().trim();
            int intValue = Integer.parseInt(pythonOutput);
            String advice;
            switch (intValue) {
                case 0:
                    advice = "不建议运动";
                    break;
                case 1:
                    advice = "足球";
                    break;
                case 2:
                    advice = "篮球";
                    break;
                case 3:
                    advice = "排球";
                    break;
                case 4:
                    advice = "乒乓球";
                    break;
                case 5:
                    advice = "羽毛球";
                    break;
                case 6:
                    advice = "网球";
                    break;
                case 7:
                    advice = "跑步";
                    break;
                case 8:
                    advice = "游泳";
                    break;
                case 9:
                    advice = "滑板";
                    break;
                case 10:
                    advice = "瑜伽";
                    break;
                default:
                    advice = "出错了";
                    break;
            }
            System.out.println(advice);


            System.out.println(pythonOutput);  // 输出Python脚本的返回值
            // 等待Python脚本执行完成
            proc.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
