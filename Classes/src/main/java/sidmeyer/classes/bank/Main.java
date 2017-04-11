package sidmeyer.classes.bank;

public class Main {
	public static void main(String[] args) {
		Account account1 = new Account("12345", "Vasya");
		Account.Card card1 = account1.new Card("1111 2222 3333 4444");

		card1.withdraw(-1000);
		System.out.println(account1.getAmount());
	}
}
