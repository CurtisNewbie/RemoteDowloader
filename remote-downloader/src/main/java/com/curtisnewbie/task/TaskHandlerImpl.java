package com.curtisnewbie.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author zhuangyongj
 */
@Component
public class TaskHandlerImpl implements TaskHandler {

    private static final Logger logger = LoggerFactory.getLogger(TaskHandlerImpl.class);

    @Override
    public void handle(Task task) {
        logger.info("Handle sync task in THREAD: {}", Thread.currentThread().getId());
        task.complete();
    }

    @Async
    @Override
    public void handleAsync(Task task) {
        logger.info("Handle async task in THREAD: {}", Thread.currentThread().getId());
        task.complete();
    }
}
