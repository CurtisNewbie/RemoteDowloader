package com.curtisnewbie.io;

import com.curtisnewbie.io.model.ValidateResult;

import java.io.File;

/**
 * <p>
 * Class that provides util methods to validate a path
 * </p>
 *
 * @author zhuangyongj
 */
public class PathValidator {

    private PathValidator() {

    }

    /**
     * Validate the given path
     *
     * @param path
     * @return
     */
    public static ValidateResult validate(String path) {
        if (path.startsWith("..")) {
            return ValidateResult.failure(String.format("Path ('%s') starts with '..' for parent directory, not " +
                    "permitted operation", path));
        }
        if (new File(path).isAbsolute()) {
            return ValidateResult.failure(String.format("Absolute path: '%s' is not allowed, not permitted operation"
                    , path));
        }
        return ValidateResult.success();
    }
}
