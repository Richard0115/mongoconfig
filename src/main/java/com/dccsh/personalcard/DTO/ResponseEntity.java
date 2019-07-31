package com.dccsh.personalcard.DTO;

public class ResponseEntity {
	
	private String msg;
	private boolean success;
	private Object rst;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public Object getRst() {
		return rst;
	}
	public void setRst(Object rst) {
		this.rst = rst;
	}
	
	public static ResponseEntity success(String msg,Object rst) {
		ResponseEntity resp = new ResponseEntity();
		resp.setSuccess(true);
		resp.setMsg(msg);
		resp.setRst(rst);
		return resp;
	}
	
	public static ResponseEntity fail(String msg) {
		ResponseEntity resp = new ResponseEntity();
		resp.setMsg(msg);
		resp.setRst(null);
		resp.setSuccess(false);
		return resp;
	}

}
