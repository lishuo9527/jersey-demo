package me.lishuo.jersey.exception;

public final class ExceptionCode {

    private ExceptionCode() {
    }

    public static final String READ_FILE_FAILED = "read.file.failed";
    public static final String READ_CONFIG_FAILED = "read.config.failed";
    public static final String MUST_BE_LESS_THAN_10 = "must.be.less.than.10";
    public static final String COLSE_FILE_FAILED = "colse.file.failed";
    public static final String REQUEST_NOT_FOUND = "request.not.found";
    public static final String INTERNAL_SERVER_ERROR = "internal.server.error";
}
