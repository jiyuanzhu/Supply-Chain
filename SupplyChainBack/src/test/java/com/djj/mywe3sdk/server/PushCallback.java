package com.djj.mywe3sdk.server;

import lombok.extern.slf4j.Slf4j;
import org.fisco.bcos.channel.client.ChannelPushCallback;
import org.fisco.bcos.channel.dto.ChannelPush;
import org.fisco.bcos.channel.dto.ChannelResponse;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
class PushCallback extends ChannelPushCallback {

    @Override
    public void onPush(ChannelPush push) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        log.debug("push:" + push.getContent());

        System.out.println(df.format(LocalDateTime.now()) + "server:push:" + push.getContent());
        ChannelResponse response = new ChannelResponse();
        response.setContent("receive request seq:" + String.valueOf(push.getMessageID()));
        response.setErrorCode(0);

        push.sendResponse(response);
    }
}
