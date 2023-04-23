package jp.co.axa.apidemo.common;

public enum MsgEnum {
	/**
     * successed
     */
	SUCCESS(200, "successed"),
	/**
     * failed
     */
	ERROR(400, "failed"),
	/**
     * Unauthenticated
     */
	AUTH_ERROR(401, "not authenticated"),
	/**
     * The token parameter does not exist
     */
	NO_TOKEN(40101, "The token parameter does not exist, no access rights"),
	/**
     * token verification failed
     */
	CHECK_TOKEN(40102, "The token parameter does not exist, no access rights"),
	/**
	 * The accessKeyId parameter does not exist
	 */
	NO_SECRET_ID(40151, "The accessKeyId parameter does not exist"),
	/**
	 * sign signature parameter does not exist
	 */
	NO_SECRET_SIGN(40152, "sign signature does not exist"),
	/**
	 * Request verification failed
	 */
	CHECK_SECRET(40153, "Request verification failed"),
	/**
     * resource does not exist
     */
	NOT_FOUND(404, "Employee resource does not exist"),
	/**
     * The server is abnormal, please try again later
     */
	SYSTEM_ERROR(500, "The server is abnormal, please try again later"),
	/**
     * User information analysis
     */
	USERPRINCIPAL_RESOLVER_ERROR(50001, "User information parsing exception, please try again later"),
	/**
     * RPC or other project communication call exceptions, external service exceptions
     */
	RPC_ERROR(503, "External service exception"),
	;

	private final int code;
	private String msg;

	private MsgEnum(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}


}
