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
 * @date 2023/1/19 20:00
 */

@Api(value = "LKA")
@RestController
@RequestMapping("/api/getLKAData")
public class LKAController {
    @Value("${json.path.LKA.DDPG}")
    public String LKA_DDPG_PATH;

    @Value("${json.path.LKA.PPO}")
    public String LKA_PPO_PATH;

    @Value("${json.path.LKA.A2C}")
    public String LKA_A2C_PATH;

    @Value("${json.path.LKA.SAC}")
    public String LKA_SAC_PATH;

    @ApiOperation(value="Get LKA Data, with DDPG agent", notes="LKA+DDPG")
    @GetMapping("/DDPG")
    public JSONArray getLkaDdpgData() {
        String jsonStr = null;
        try {
            InputStream inputStream = this.getClass().getResourceAsStream(LKA_DDPG_PATH);
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

    @ApiOperation(value="Get LKA Data, with PPO agent", notes="LKA+PPO")
    @GetMapping("/PPO")
    public JSONArray getLkaPpoData() {
        String jsonStr = null;
        try {
            InputStream inputStream = this.getClass().getResourceAsStream(LKA_PPO_PATH);
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

    @ApiOperation(value="Get LKA Data, with A2C agent", notes="LKA+A2C")
    @GetMapping("/A2C")
    public JSONArray getLkaA2cData() {
        String jsonStr = null;
        try {
            InputStream inputStream = this.getClass().getResourceAsStream(LKA_A2C_PATH);
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

    @ApiOperation(value="Get LKA Data, with SAC agent", notes="LKA+SAC")
    @GetMapping("/SAC")
    public JSONArray getLkaSacData() {
        String jsonStr = null;
        try {
            InputStream inputStream = this.getClass().getResourceAsStream(LKA_SAC_PATH);
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
