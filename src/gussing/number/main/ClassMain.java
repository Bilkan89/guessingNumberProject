package gussing.number.main;

import java.util.Random;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import gussing.number.exception.BigNumberException;
import gussing.number.exception.SmallNumberException;


public class ClassMain {

	public static final int MAX_number = 30;
	private static int mGeneratedNumber = 0;
	private static final Logger logger = LoggerFactory.getLogger(ClassMain.class);


	public static void main(String[] args){
		logger.info("User started app..");
		Random random = new Random();
		mGeneratedNumber = random.nextInt(MAX_number);
		logger.info("Generated number is: " + mGeneratedNumber);
		Scanner in = new Scanner(System.in);

		int UserInputNumber = 0;
		int i = 1;
		int NumbersOfTries = 0;
		do{
			System.out.println("PUT ONE POSITIVE INTEGER BETWEEN 0 - 30: ");
			UserInputNumber = in.nextInt();
			logger.info("Input number is: "+ UserInputNumber);

			try{
				checkNumber(UserInputNumber, mGeneratedNumber);
				i=4;

				}catch (SmallNumberException e) {

					logger.error(e.getMessage()); // ili ovako logger.error(e.getMessage(),e)
					System.out.println(e.getMessage());

				}catch (BigNumberException ex) {

					logger.error(ex.getMessage()); // ili ovako logger.error(ex.getMessage(),ex)
					System.out.println(ex.getMessage());

					}
			MDC.put("screen", "Gussing");// nastavak se sprema u novi u novi log file!
			NumbersOfTries++;
			}while(i==1);

		in.close();
			System.out.println("BRavo! You hit the number!!! You try it "+NumbersOfTries+". times!!!");
			logger.info("Number is hit in "+NumbersOfTries+" trys");
	}

	private static void checkNumber(int inNumber, int mGeneratedNumber) throws SmallNumberException, BigNumberException{

		if(inNumber < mGeneratedNumber){

			throw new SmallNumberException("You insert small number!! Try again!");

			}else if (inNumber > mGeneratedNumber){

				throw new BigNumberException("You insert big number!! Try again!");

				}
		}


}
