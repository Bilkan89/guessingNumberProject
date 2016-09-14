package pogaðanje.brojeva.iznimke;

public class PremaliBrojException extends Exception{

	public PremaliBrojException(String poruka){
		super(poruka);
		}

	public PremaliBrojException(Throwable uzrok){
		super(uzrok);
		}

	public PremaliBrojException(String poruka, Throwable uzrok){
		super(poruka, uzrok);
		}

}
