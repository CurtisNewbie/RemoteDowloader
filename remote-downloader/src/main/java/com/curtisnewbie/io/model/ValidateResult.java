package com.curtisnewbie.io.model;

/**
 * <p>
 * Result of a validation
 * </p>
 *
 * @author zhuangyongj
 */
public class ValidateResult {

    /**
     * Indicate whether validation is success or not
     */
    private final boolean success;

    /**
     * Failure msg, it's null if the validation is successful
     */
    private final String errMsg;

    public ValidateResult(boolean success, String errMsg) {
        this.success = success;
        this.errMsg = errMsg;
    }

    public static ValidateResult success() {
        return new ValidateResult(true, null);
    }

    public static ValidateResult failure(String errMsg) {
        return new ValidateResult(false, errMsg);
    }

    public boolean isSuccess() {
        return success;
    }

    public String getErrMsg() {
        return errMsg;
    }
}
