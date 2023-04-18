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
 * @date 2023/1/19 15:40
 */

@Api(value = "ACC")
@RestController
@RequestMapping("/api/getACCData")
public class ACCController {

    @Value("${json.path.ACC.DDPG.norm}")
    private String ACC_DDPG_NORM_PATH;

    @Value("${json.path.ACC.DDPG.hybrid.norm}")
    private String ACC_DDPG_HYBRID_NORM_PATH;

    @Value("${json.path.ACC.DDPG.hybrid.average}")
    private String ACC_DDPG_HYBRID_AVERAGE_PATH;

    @Value("${json.path.ACC.DDPG.hybrid.random}")
    private String ACC_DDPG_HYBRID_RANDOM_PATH;

    @ApiOperation(value="Get ACC Data, with DDPG agent, normal model", notes="ACC+DDPG")
    @GetMapping("/DDPG/norm")
    public JSONArray getAccDdpgNormData() {
        String jsonStr = null;
        try {
            InputStream inputStream = this.getClass().getResourceAsStream(ACC_DDPG_NORM_PATH);
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

    @ApiOperation(value="Get ACC Data, with DDPG agent, hybrid model", notes="ACC+DDPG+hybrid")
    @GetMapping("/DDPG/hybrid/norm")
    public JSONArray getAccDdpgHybridNormData() {
        String jsonStr = null;
        try {
            InputStream inputStream = this.getClass().getResourceAsStream(ACC_DDPG_HYBRID_NORM_PATH);
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

    @ApiOperation(value="Get ACC Data, with DDPG agent, hybrid average model", notes="ACC+DDPG+hybrid+average")
    @GetMapping("/DDPG/hybrid/average")
    public JSONArray getAccDdpgHybridAverageData() {
        String jsonStr = null;
        try {
            InputStream inputStream = this.getClass().getResourceAsStream(ACC_DDPG_HYBRID_AVERAGE_PATH);
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

    @ApiOperation(value="Get ACC Data, with DDPG agent, hybrid random model", notes="ACC+DDPG+hybrid+random")
    @GetMapping("/DDPG/hybrid/random")
    public JSONArray getAccDdpgHybridRandomData() {
        String jsonStr = null;
        try {
            InputStream inputStream = this.getClass().getResourceAsStream(ACC_DDPG_HYBRID_RANDOM_PATH);
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
