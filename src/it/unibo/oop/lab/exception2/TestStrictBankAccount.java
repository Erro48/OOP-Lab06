package it.unibo.oop.lab.exception2;

import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test to test
 * {@link StrictBankAccount}.
 * 
 */
public final class TestStrictBankAccount {

    /**
     * Used to test Exceptions on {@link StrictBankAccount}.
     */
    @Test
    public void testBankOperations() {
        /*
         * 1) Creare due StrictBankAccountImpl assegnati a due AccountHolder a
         * scelta, con ammontare iniziale pari a 10000 e nMaxATMTransactions=10
         * 
         * 2) Effetture un numero di operazioni a piacere per verificare che le
         * eccezioni create vengano lanciate soltanto quando opportuno, cioè in
         * presenza di un id utente errato, oppure al superamento del numero di
         * operazioni ATM gratuite.
         */

    	AccountHolder user1 = new AccountHolder("Mario", "Rossi", 1);
    	AccountHolder user2 = new AccountHolder("Luigi", "Verdi", 2);

    	StrictBankAccount bankAccount1 = new StrictBankAccount(user1.getUserID(), 10_000, 10);
    	StrictBankAccount bankAccount2 = new StrictBankAccount(user2.getUserID(), 10_000, 10);
    	
    	try {    		
    		bankAccount1.deposit(user2.getUserID(), 3000);
    		Assert.fail("User2 accessed user1's bank account");
    	} catch (WrongAccountHolderException e) {
    		System.out.println(e.getMessage());
    	}
    	
    	try {    		
    		bankAccount1.withdraw(user1.getUserID(), 50_000);
    		Assert.fail("User1 withdrawed more than the total amount");
    	} catch (NotEnoughFoundException e) {
    		System.out.println(e.getMessage());
    	}
    	
    	try {
    		for (var i = 0; i < 10; i++) {
    			bankAccount1.depositFromATM(user1.getUserID(), 100);
    		}
    		Assert.fail("Done more transactions than allowed");
    	} catch (TransactionsOverQuotaException e) {
    		System.out.println(e.getMessage());
    	}

    }
}
