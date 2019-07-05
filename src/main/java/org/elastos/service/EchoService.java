package org.elastos.service;

import org.apache.commons.lang3.StringUtils;
import org.elastos.constants.Constants;
import org.elastos.constants.RetCode;
import org.elastos.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class EchoService {

    private static Logger logger = LoggerFactory.getLogger(EchoService.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Autowired
    RedisCacheUtil redisCacheUtil;

    public String echo(String did, String key) {
        if (StringUtils.isAnyBlank(did, key)) {
            return new ServerResponse().setStatus(RetCode.ERROR_PARAMETER).setMsg("Callback url should be: /api/1/ela_echo/did/{did}/{key}").toJsonString();
        }
        String token = did+key;
        String data = redisCacheUtil.getData(token);
        logger.info("[Get] did:"+did+" key"+key+" data:"+data+" time:"+dateFormat.format(new Date()));
        return new ServerResponse().setStatus(RetCode.SUCCESS).setData(data).toJsonString();
    }

    public String call(String did, String key, String data) {
        if (StringUtils.isAnyBlank(did, key, data)) {
            return new ServerResponse().setStatus(RetCode.ERROR_PARAMETER).setMsg("Callback url should be: /api/1/ela_echo/did/{did}/{key}").toJsonString();
        }
        String token = did+key;
        redisCacheUtil.saveData(token, data, Constants.TOKEN_EXPIRE_HOURS);
        logger.info("[Save] did:"+did+" key"+key+" data:"+data+" time:"+dateFormat.format(new Date()));
        return new ServerResponse().setStatus(RetCode.SUCCESS).toJsonString();
    }
}
