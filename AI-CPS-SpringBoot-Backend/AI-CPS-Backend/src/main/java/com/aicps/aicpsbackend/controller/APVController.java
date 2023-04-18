package com.aicps.aicpsbackend.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * @author T-bk
 * @version 1.0
 * @date 2023/1/19 19:59
 */

@Api(value = "APV")
@RestController
@RequestMapping("/api/getAPVData")
public class APVController {
    @Value("${json.path.APV.DDPG}")
    public String APV_DDPG_PATH;

    @Value("${json.path.APV.TD3}")
    public String APV_TD3_PATH;

    @ApiOperation(value="Get APV Data, with DDPG agent", notes="APV+DDPG")
    @GetMapping("/DDPG")
    public JSONArray getApvDdpgData() {
        String jsonStr = null;
        try {
            InputStream inputStream = this.getClass().getResourceAsStream(APV_DDPG_PATH);
            InputStreamReader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            int ch = 0;
            StringBuilder sb = new StringBuilder();
            while ((ch = reader.read()) != -1) {
                sb.append((char) ch);
            }
            reader.close();
            jsonStr = sb.toString();
            return JSONObject.parseArray(jsonStr);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @ApiOperation(value="Get APV Data, with TD3 agent", notes="APV+TD3")
    @GetMapping("/TD3")
    public JSONArray getApvTd3Data() {
        String jsonStr = null;
        try {
            InputStream inputStream = this.getClass().getResourceAsStream(APV_TD3_PATH);
            InputStreamReader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            int ch = 0;
            StringBuilder sb = new StringBuilder();
            while ((ch = reader.read()) != -1) {
                sb.append((char) ch);
            }
            reader.close();
            jsonStr = sb.toString();
            return JSONObject.parseArray(jsonStr);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

}
