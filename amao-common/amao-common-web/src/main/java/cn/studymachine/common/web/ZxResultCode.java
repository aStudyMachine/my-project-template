package cn.studymachine.common.web;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.servlet.http.HttpServletResponse;

/**
 * <pre>
 * Result 对象 错误码定义. 除了请求成功为0外, 其他均表示错误.
 * 基础错误使用 http 通用 响应状态码.
 * 需要自定义业务状态码与前端进行流程交互的可以自定义 , 否则业务异常直接使用通用错误码 1 即可.
 * 业务错误码禁止使用 0-1000, 避免与 http协议状态码冲突产生歧义
 * 业务编码从 100000 开始编号. 不同业务模块预占不同范围.
 * </pre>
 *
 * @author wukun
 * @since 2023/12/25
 */
@AllArgsConstructor
@Getter
public enum ZxResultCode implements IResultCode {


    /**
     * 操作成功
     */
    SUCCESS(0, "操作成功"),

    /**
     * 通用异常
     */
    FAILURE(1, "操作失败"),

    /**
     * 请求未授权
     */
    UN_AUTHORIZED(HttpServletResponse.SC_UNAUTHORIZED, "请求未授权"),

    /**
     * 404 没找到请求
     */
    NOT_FOUND(HttpServletResponse.SC_NOT_FOUND, "404 没找到请求"),

    /**
     * 不支持当前请求方法
     */
    METHOD_NOT_SUPPORTED(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "不支持当前请求方法"),

    /**
     * 不支持当前媒体类型
     */
    MEDIA_TYPE_NOT_SUPPORTED(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE, "不支持当前媒体类型"),

    /**
     * 请求被拒绝
     */
    REQ_REJECT(HttpServletResponse.SC_FORBIDDEN, "请求被拒绝"),

    /**
     * 服务器异常
     */
    INTERNAL_SERVER_ERROR(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "服务器异常"),

    /**
     * 缺少必要的请求参数
     */
    PARAM_MISS(HttpServletResponse.SC_BAD_REQUEST, "缺少必要的请求参数"),

    /**
     * 请求参数类型错误
     */
    PARAM_TYPE_ERROR(HttpServletResponse.SC_BAD_REQUEST, "请求参数类型错误"),

    /**
     * 请求参数绑定错误
     */
    PARAM_BIND_ERROR(HttpServletResponse.SC_BAD_REQUEST, "请求参数绑定错误"),

    /**
     * 参数校验失败
     */
    PARAM_VALID_ERROR(HttpServletResponse.SC_BAD_REQUEST, "参数校验失败"),
    ;


    private final int code;
    private final String message;

}
