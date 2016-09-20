package gussing.number.exception;

public class BigNumberException extends Exception{

	public BigNumberException(String message){
		super(message);
		}

	public BigNumberException(Throwable couse){
		super(couse);
		}

	public BigNumberException(String message, Throwable couse){
		super(message, couse);
		}

}
