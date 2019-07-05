/**
 * Copyright (c) 2017-2018 The Elastos Developers
 * <p>
 * Distributed under the MIT software license, see the accompanying file
 * LICENSE or https://opensource.org/licenses/mit-license.php
 */
package org.elastos.controller;

import org.elastos.service.EchoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/1/ela_echo")
public class EchoController {
    private static Logger logger = LoggerFactory.getLogger(EchoController.class);

    @Autowired
    private EchoService echoService;

    @RequestMapping(value = "{appid}/{key}", method = RequestMethod.GET)
    @ResponseBody
    public String echo(@PathVariable("appid") String appid, @PathVariable("key") String key) {
        return echoService.echo(appid, key);
    }

    @RequestMapping(value = "{appid}/{key}", method = RequestMethod.POST)
    @ResponseBody
    public String call(@PathVariable("appid") String appid, @PathVariable("key") String key, @RequestAttribute String reqBody) {
        System.out.print(reqBody);
        return echoService.call(appid, key, reqBody);
    }
}
