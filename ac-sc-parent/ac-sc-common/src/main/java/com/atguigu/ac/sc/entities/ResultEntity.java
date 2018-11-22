package com.atguigu.ac.sc.entities;

public class ResultEntity<T> {

	public static final String SUCCESS = "SUCCESS";
	public static final String FAILED = "FAILED";
    //结果状态   success  或者 failed  
	private String status;
	//返回的消息成功的话no message  ，失败需要有失败的消息
	private String resultMessage = "no message";
	//返回的数据
	private T   data;
	public ResultEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ResultEntity(String status, String resultMessage, T data) {
		super();
		this.status = status;
		this.resultMessage = resultMessage;
		this.data = data;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getResultMessage() {
		return resultMessage;
	}
	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public static String getSuccess() {
		return SUCCESS;
	}
	public static String getFailed() {
		return FAILED;
	}
	@Override
	public String toString() {
		return "ResultEntity [status=" + status + ", resultMessage=" + resultMessage + ", data=" + data + "]";
	}
	
	
	
	
}
