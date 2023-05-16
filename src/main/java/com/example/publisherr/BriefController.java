package com.example.publisherr;

import com.example.publisherr.dto.request.RequestModel;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.*;


@EnableBinding(Source.class)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@RestController
public class BriefController {

    Source mysource;

    @PostMapping("publisher")
    public void publishMessage(@RequestBody RequestModel model) {
        mysource.output().send(MessageBuilder.withPayload(model).build());
    }
}
