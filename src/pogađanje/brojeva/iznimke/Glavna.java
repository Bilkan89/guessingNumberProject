package pogaðanje.brojeva.iznimke;

import java.util.Random;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;


public class Glavna {

	public static final int MAX_BROJ = 30;
	private static int mGeneriraniBroj = 0;
	private static final Logger logger = LoggerFactory.getLogger(Glavna.class);


	public static void main(String[] args){
		logger.info("Korisnik je pokrenio aplikaciju!");
		Random random = new Random();
		mGeneriraniBroj = random.nextInt(MAX_BROJ);
		logger.info("Generiran je broj: " + mGeneriraniBroj);
		Scanner unos = new Scanner(System.in);

		int uneseniBroj = 0;
		int i = 1;
		int brojaPokusaja = 0;
		do{
			System.out.println("Unesi cijeli broj: ");
			uneseniBroj = unos.nextInt();
			logger.info("Uneseni broj je: "+ uneseniBroj);

			try{
				provjeraBroja(uneseniBroj, mGeneriraniBroj);
				i=4;

				}catch (PremaliBrojException e) {

					logger.error(e.getMessage()); // ili ovako logger.error(e.getMessage(),e)
					System.out.println(e.getMessage());

				}catch (PrevelikBrojException ex) {

					logger.error(ex.getMessage()); // ili ovako logger.error(ex.getMessage(),ex)
					System.out.println(ex.getMessage());

					}
			MDC.put("screen", "Pogaðanje");// nastavak se sprema u novi u novi log file!
			brojaPokusaja++;
			}while(i==1);

		unos.close();
			System.out.println("BRavo! Pogodio si iz "+brojaPokusaja+". pokušaja!!!");
			logger.info("Broj je pogoðen iz "+brojaPokusaja+" pokušaja");
	}

	private static void provjeraBroja(int uneseniBroj, int mGeneriraniBroj2) throws PremaliBrojException, PrevelikBrojException{

		if(uneseniBroj < mGeneriraniBroj2){

			throw new PremaliBrojException("Unijeli ste premali broj");

			}else if (uneseniBroj > mGeneriraniBroj2){

				throw new PrevelikBrojException("Unijeli ste preveliki broj");

				}
		}


}
