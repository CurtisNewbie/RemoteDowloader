package com.curtisnewbie.task;

/**
 * <p>
 * Handler of task
 * </p>
 *
 * @author zhuangyongj
 */
public interface TaskHandler {

    /**
     * Handle a task in a synchronous way
     *
     * @param task
     */
    void handle(Task task);

    /**
     * Handle a task in a asynchronous way
     *
     * @param task
     */
    void handleAsync(Task task);
}
