package com.curtisnewbie.task;

/**
 * @author zhuangyongj
 */
@FunctionalInterface
public interface Task {

    /**
     * Operation that this {@code Task} should complete
     */
    void complete();
}
