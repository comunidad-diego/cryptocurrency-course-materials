package test;

import org.junit.Test;

import com.co.coursera.Transaction;
import com.co.coursera.TxHandler;

/**
 * Unit tests for {@link TxHandler#isValidTx(Transaction)}
 * <p>
 * Test Strategy:
 * Test 1: test isValidTx() with valid transactions
 * Test 2: test isValidTx() with transactions containing signatures of incorrect data
 * Test 3: test isValidTx() with transactions containing signatures using incorrect private keys
 * Test 4: test isValidTx() with transactions whose total output value exceeds total input value
 * Test 5: test isValidTx() with transactions that claim outputs not in the current utxoPool
 * Test 6: test isValidTx() with transactions that claim the same UTXO multiple times
 * Test 7: test isValidTx() with transactions that contain a negative output value
 * 
 * @author Diego Babativa
 * @since 12/10/2017
 *
 */
public class TestingScroogeCoin {

	
	private static void assertTestSetIsValid(final UtxoTestSet utxoTestSet) {
		final ValidationLists<Transaction> trxsValidation = utxoTestSet.getValidationLists();
		
		// Instantiate student solution
		final TxHandler txHandler = new TxHandler(utxoTestSet.getUtxoPool());
		
		// Check validation of all the transactions in the set
		for (Transaction tx: trxsValidation.allElements()) {
			assertEquals(txHandler.isValidTx(tx), trxsValidation.isValid(tx) );
		}
	}
	
	
	 //* Test 1: test isValidTx() with valid transactions
	@Test
	public void isValidTx(){
		TxHandler txHlr = new TxHandler(null);
		
		Transaction tx = new Transaction();
		
		
		txHlr.isValidTx(tx);
		
		final UtxoTestSet utxoTestSet = UtxoTestSet.builder()
				.setPeopleSize(10)
				.setUtxoTxNumber(10)
				.setMaxUtxoTxOutput(10)
				.setMaxValue(200)
				.setTxPerTest(10)
				.setMaxInput(10)
				.setMaxOutput(10)
				.setCorruptedPercentage(0) // All valid transactions
				.build();
		// check against student solution
		assertTestSetIsValid(utxoTestSet);
	}
	
}
