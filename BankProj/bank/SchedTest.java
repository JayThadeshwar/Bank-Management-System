package bank;

import java.util.TimerTask;

import crud.AccountCrud;

public class SchedTest extends TimerTask {

	@Override
	public void run() {
		AccountCrud ac = new AccountCrud();
		boolean res = ac.updateSavingsAccountBalance();		
		if(res) {
			System.out.println("Update complete");
		} else {
			System.out.println("Failed");
		}
	}

}
