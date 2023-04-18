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

@Api(value = "AFC")
@RestController
@RequestMapping("/api/getAFCData")
public class AFCController {
    @Value("${json.path.AFC.DDPG.RL}")
    public String AFC_DDPG_RL_PATH;

    @Value("${json.path.AFC.DDPG.hybrid}")
    public String AFC_DDPG_hybrid_PATH;

    @Value("${json.path.AFC.DDPG.hybrid_AI}")
    public String AFC_DDPG_hybrid_AI_PATH;

    @Value("${json.path.AFC.DDPG.NN_6_20}")
    public String AFC_DDPG_NN_6_20_PATH;

    @Value("${json.path.AFC.DDPG.NN_5_10}")
    public String AFC_DDPG_NN_5_10_PATH;

    @Value("${json.path.AFC.DDPG.NN_4_10}")
    public String AFC_DDPG_NN_4_10_PATH;

    @Value("${json.path.AFC.DDPG.NN_4_15_2}")
    public String AFC_DDPG_NN_4_15_2_PATH;

    @Value("${json.path.AFC.DDPG.NN_3_20}")
    public String AFC_DDPG_NN_3_20_PATH;

    @Value("${json.path.AFC.DDPG.NN_3_15_1}")
    public String AFC_DDPG_NN_3_15_1_PATH;

    @Value("${json.path.AFC.DDPG.hybrid_random}")
    public String AFC_DDPG_hybrid_random_PATH;

    @Value("${json.path.AFC.DDPG.hybrid_average}")
    public String AFC_DDPG_hybrid_average_PATH;

    @ApiOperation(value="Get AFC Data, with DDPG agent, RL model", notes="AFC+DDPG+RL")
    @GetMapping("/DDPG/RL")
    public JSONArray getAfcDdpgRlData() {
        String jsonStr = null;
        try {
            InputStream inputStream = this.getClass().getResourceAsStream(AFC_DDPG_RL_PATH);
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

    @ApiOperation(value="Get AFC Data, with DDPG agent, hybrid model", notes="AFC+DDPG+hybrid")
    @GetMapping("/DDPG/hybrid")
    public JSONArray getAfcDdpgHybridData() {
        String jsonStr = null;
        try {
            InputStream inputStream = this.getClass().getResourceAsStream(AFC_DDPG_hybrid_PATH);
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

    @ApiOperation(value="Get AFC Data, with DDPG agent, hybrid_AI model", notes="AFC+DDPG+hybrid_AI")
    @GetMapping("/DDPG/hybrid_AI")
    public JSONArray getAfcDdpgHybridAiData() {
        String jsonStr = null;
        try {
            InputStream inputStream = this.getClass().getResourceAsStream(AFC_DDPG_hybrid_AI_PATH);
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

    @ApiOperation(value="Get AFC Data, with DDPG agent, NN_6_20 model", notes="AFC+DDPG+NN_6_20")
    @GetMapping("/DDPG/NN_6_20")
    public JSONArray getAfcDdpgNN620Data() {
        String jsonStr = null;
        try {
            InputStream inputStream = this.getClass().getResourceAsStream(AFC_DDPG_NN_6_20_PATH);
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

    @ApiOperation(value="Get AFC Data, with DDPG agent, NN_5_10 model", notes="AFC+DDPG+NN_5_10")
    @GetMapping("/DDPG/NN_5_10")
    public JSONArray getAfcDdpgNN510Data() {
        String jsonStr = null;
        try {
            InputStream inputStream = this.getClass().getResourceAsStream(AFC_DDPG_NN_5_10_PATH);
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

    @ApiOperation(value="Get AFC Data, with DDPG agent, NN_4_10 model", notes="AFC+DDPG+NN_4_10")
    @GetMapping("/DDPG/NN_4_10")
    public JSONArray getAfcDdpgNN410Data() {
        String jsonStr = null;
        try {
            InputStream inputStream = this.getClass().getResourceAsStream(AFC_DDPG_NN_4_10_PATH);
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

    @ApiOperation(value="Get AFC Data, with DDPG agent, NN_4_15_2 model", notes="AFC+DDPG+NN_4_15_2")
    @GetMapping("/DDPG/NN_4_15_2")
    public JSONArray getAfcDdpgNN4152Data() {
        String jsonStr = null;
        try {
            InputStream inputStream = this.getClass().getResourceAsStream(AFC_DDPG_NN_4_15_2_PATH);
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

    @ApiOperation(value="Get AFC Data, with DDPG agent, NN_3_20 model", notes="AFC+DDPG+NN_3_20")
    @GetMapping("/DDPG/NN_3_20")
    public JSONArray getAfcDdpgNN320Data() {
        String jsonStr = null;
        try {
            InputStream inputStream = this.getClass().getResourceAsStream(AFC_DDPG_NN_3_20_PATH);
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

    @ApiOperation(value="Get AFC Data, with DDPG agent, NN_3_15_1 model", notes="AFC+DDPG+NN_3_15_1")
    @GetMapping("/DDPG/NN_3_15_1")
    public JSONArray getAfcDdpgNN315_1Data() {
        String jsonStr = null;
        try {
            InputStream inputStream = this.getClass().getResourceAsStream(AFC_DDPG_NN_3_15_1_PATH);
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

    @ApiOperation(value="Get AFC Data, with DDPG agent, hybrid_random model", notes="AFC+DDPG+hybrid_random")
    @GetMapping("/DDPG/hybrid_random")
    public JSONArray getAfcDdpgHybridRandomData() {
        String jsonStr = null;
        try {
            InputStream inputStream = this.getClass().getResourceAsStream(AFC_DDPG_hybrid_random_PATH);
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

    @ApiOperation(value="Get AFC Data, with DDPG agent, hybrid_average model", notes="AFC+DDPG+hybrid_average")
    @GetMapping("/DDPG/hybrid_average")
    public JSONArray getAfcDdpgHybridAverageData() {
        String jsonStr = null;
        try {
            InputStream inputStream = this.getClass().getResourceAsStream(AFC_DDPG_hybrid_average_PATH);
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
