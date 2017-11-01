/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.twiceagain.myrestheart.mylogic.myhandlers;

import com.twiceagain.myrestheart.utils.MyUtils;
import io.undertow.server.HttpServerExchange;
import java.util.Map;
import org.restheart.handlers.PipedHttpHandler;
import org.restheart.handlers.RequestContext;
import org.restheart.handlers.applicationlogic.ApplicationLogicHandler;
import org.restheart.utils.HttpStatus;

/**
 * (For debugging) GET this to return the mongo uri used in this restheart
 * instance.
 *
 * @author xavier
 */
public class MongoUriHandler extends ApplicationLogicHandler {

    

    public MongoUriHandler(PipedHttpHandler next, Map<String, Object> args) {
        super(next, args);
    }

    @Override
    public void handleRequest(HttpServerExchange exchange, RequestContext context) throws Exception {
        if (context.getMethod() == RequestContext.METHOD.GET) {
            exchange.setStatusCode(HttpStatus.SC_OK);
            exchange.getResponseSender().send(MyUtils.getMongoUri());
            exchange.endExchange();
        } else {
            exchange.setStatusCode(HttpStatus.SC_OK);
            if (context.getContent() != null) {
                exchange.getResponseSender().send(context.getContent().toString());
            }
            exchange.endExchange();
        }
    }

}
