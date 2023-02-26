package Model;

import java.sql.Timestamp;

public class Bank_Transaction {
	
	private int transId;
	private long accountNo;
	private long deposit;
	private long withdraw;
	private Timestamp timeOfTrans;
	public Bank_Transaction() {
		super();
	}
	public Bank_Transaction(int transId, long accountNo, long deposit, long withdraw, Timestamp timeOfTrans) {
		super();
		this.transId = transId;
		this.accountNo = accountNo;
		this.deposit = deposit;
		this.withdraw = withdraw;
		this.timeOfTrans = timeOfTrans;
	}
	public int getTransId() {
		return transId;
	}
	public void setTransId(int transId) {
		this.transId = transId;
	}
	public long getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}
	public long getDeposit() {
		return deposit;
	}
	public void setDeposit(long deposit) {
		this.deposit = deposit;
	}
	public long getWithdraw() {
		return withdraw;
	}
	public void setWithdraw(long withdraw) {
		this.withdraw = withdraw;
	}
	public Timestamp getTimeOfTrans() {
		return timeOfTrans;
	}
	public void setTimeOfTrans(Timestamp timeOfTrans) {
		this.timeOfTrans = timeOfTrans;
	}
	@Override
	public String toString() {
		return "Bank_Transaction [transId=" + transId + ", accountNo=" + accountNo + ", deposit=" + deposit
				+ ", withdraw=" + withdraw + ", timeOfTrans=" + timeOfTrans + "]";
	}
	
	

}
