package pogaðanje.brojeva.iznimke;

public class PrevelikBrojException extends Exception{

	public PrevelikBrojException(String poruka){
		super(poruka);
		}

	public PrevelikBrojException(Throwable uzrok){
		super(uzrok);
		}

	public PrevelikBrojException(String poruka, Throwable uzrok){
		super(poruka, uzrok);
		}

}
