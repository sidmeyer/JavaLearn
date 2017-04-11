package sidmeyer.classes.bank;

/**
 * Usage of inner classes.
 */
public class Account {

	private final String number;
	private double amount;
	private final String owner;


	public Account(final String number, final String owner) {
		this.number = number;
		this.owner = owner;
	}

	public String getNumber() {
		return number;
	}

	public double getAmount() {
		return amount;
	}

	public String getOwner() {
		return owner;
	}

	private double withdraw(final double amountToWithdraw) {
		if (amountToWithdraw < 0) {
			return 0;
		}
		if (amountToWithdraw > amount) {
			final double amountToReturn = amount;
			amount = 0;
			return amountToReturn;
		}
		amount -= amountToWithdraw;
		return amountToWithdraw;
	}

	public class Card {
		private final String number;

		public Card(final String number) {
			this.number = number;
		}

		public String getNumber() {
			return number;
		}

		public double withdraw(final double amountToWithdraw) {
			return Account.this.withdraw(amountToWithdraw);
		}
	}
}
