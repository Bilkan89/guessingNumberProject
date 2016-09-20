package gussing.number.exception;

public class SmallNumberException extends Exception{

	public SmallNumberException(String message){
		super(message);
		}

	public SmallNumberException(Throwable couse){
		super(couse);
		}

	public SmallNumberException(String message, Throwable couse){
		super(message, couse);
		}

}
