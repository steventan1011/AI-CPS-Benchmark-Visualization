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

@Api(value = "WT")
@RestController
@RequestMapping("/api")
public class WTController {
    @Value("${json.path.WT}")
    public String WT_PATH;

    @ApiOperation(value="Get WT Data", notes="")
    @GetMapping("/getWTData")
    public JSONArray getWTData() {
        String jsonStr = null;
        try {
            InputStream inputStream = this.getClass().getResourceAsStream(WT_PATH);
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
