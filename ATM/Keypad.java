import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Keypad {
	private BufferedReader br;
	
	/* Constructor */
	public Keypad () {
		br = new BufferedReader(new InputStreamReader(System.in));
	}

	/* Get the user input with exception control, such as I/O Exception and Number Format Exception*/
	public int getInput() throws NumberFormatException {
		int checkInput = -1;
		try{
			checkInput = Integer.parseInt(br.readLine());
			if (checkInput < 0){
				throw new NumberFormatException();
			}
		} catch (IOException e) {
			System.out.println("Error: " + e);
		} catch(NumberFormatException e){
			checkInput = -1;
		}
		return checkInput;
	}
	
}
