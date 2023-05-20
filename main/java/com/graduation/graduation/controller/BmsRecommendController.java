package com.graduation.graduation.controller;
import com.graduation.graduation.common.api.ApiResult;
import com.graduation.graduation.model.dto.CreateTeamDTO;
import com.graduation.graduation.model.entity.BmsTeam;
import com.graduation.graduation.model.entity.UmsUser;
import com.graduation.graduation.model.vo.RecommendVO;
import org.springframework.web.bind.annotation.*;

import java.io.*;

import static com.graduation.graduation.jwt.JwtUtil.USER_NAME;

@RestController
public class BmsRecommendController {

    @RequestMapping(value = "/recommend", method = RequestMethod.POST)
    public ApiResult<String> getRecommendation(@RequestBody RecommendVO request) {
        // 在这里处理接收到的JSON数据
        String temperature = request.getTemperature();
        String weather = request.getWeather();
        String people = request.getPeople();
        String distance = request.getDistance();
        String isBalls = request.getIsBalls();
        // 调用处理数据的方法，获取advice
        String advice = processData(temperature, weather, people, distance, isBalls);
        System.out.println(advice);
        // 返回advice
        return ApiResult.success(advice);
    }

    // 封装数据处理方法
    private String processData(String temperature, String weather, String people, String distance, String isBalls) {
        Process proc;
        try {
            proc = Runtime.getRuntime().exec("python D:\\Graduation_project\\graduation_recommendation\\Machine_learning.py");

            // 获取Python脚本的标准输入流
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(proc.getOutputStream()));

            // 向Python脚本传输数据
            writer.write("'" + temperature + "', '" + weather + "', '" + people + "', '" + distance + "', '" + isBalls + "'");
            writer.flush();
            writer.close();

            // 用输入流来截取Python脚本的输出结果
            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            StringBuilder output = new StringBuilder();
            String line = null;
            while ((line = in.readLine()) != null) {
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
            // 等待Python脚本执行完成
            proc.waitFor();

            return advice;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 异常情况的默认返回值
        return "出错了";
    }


}

