package common;

import java.util.List;
import java.util.Map;

public class OperationResult<T> {
	private boolean success;
	private Map<String, String> errors;
	private T data;

	public OperationResult() {
	}

	public OperationResult(boolean success, Map<String, String> errors, T data) {
		this.success = success;
		this.errors = errors;
		this.data = data;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Map<String, String> getErrors() {
		return errors;
	}

	public void setErrors(Map<String, String> errors) {
		this.errors = errors;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public static <T> OperationResult<T> success(T data) {
		return new OperationResult<>(true, null, data);
	}

	public static <T> OperationResult<T> failure(Map<String, String> errors) {
		return new OperationResult<>(false, errors, null);
	}
}
