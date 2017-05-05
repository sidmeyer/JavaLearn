package sidmeyer.stepikfinal;

import java.util.*;
import java.util.function.*;

public class Main {

	public static void main(String[] args) {
		// Random variables
		String randomFrom = "..."; // Некоторая случайная строка. Можете выбрать ее самостоятельно.
		String randomTo = "...";  // Некоторая случайная строка. Можете выбрать ее самостоятельно.
		int randomSalary = 100;  // Некоторое случайное целое положительное число. Можете выбрать его самостоятельно.

		// Создание списка из трех почтовых сообщений.
		MailMessage firstMessage = new MailMessage(
				"Robert Howard",
				"H.P. Lovecraft",
				"This \"The Shadow over Innsmouth\" story is real masterpiece, Howard!"
		);

		assert firstMessage.getFrom().

				equals("Robert Howard") : "Wrong firstMessage from address";
		assert firstMessage.getTo().

				equals("H.P. Lovecraft") : "Wrong firstMessage to address";
		assert firstMessage.getContent().

				endsWith("Howard!") : "Wrong firstMessage content ending";

		MailMessage secondMessage = new MailMessage(
				"Jonathan Nolan",
				"Christopher Nolan",
				"Брат, почему все так хвалят только тебя, когда практически все сценарии написал я. Так не честно!"
		);

		MailMessage thirdMessage = new MailMessage(
				"Stephen Hawking",
				"Christopher Nolan",
				"Я так и не понял Интерстеллар."
		);

		List<MailMessage> messages = Arrays.asList(
				firstMessage, secondMessage, thirdMessage
		);

		// Создание почтового сервиса.
		MailService<String> mailService = new MailService<>();

// Обработка списка писем почтовым сервисом
		messages.stream().

				forEachOrdered(mailService);

		// Получение и проверка словаря "почтового ящика",
//   где по получателю можно получить список сообщений, которые были ему отправлены
		Map<String, List<String>> mailBox = mailService.getMailBox();

		assert mailBox.get("H.P. Lovecraft").

				equals(
						Arrays.asList(
								"This \"The Shadow over Innsmouth\" story is real masterpiece, Howard!"
						)
				) : "wrong mailService mailbox content (1)" + mailBox.get("H.P. Lovecraft");

		assert mailBox.get("Christopher Nolan").

				equals(
						Arrays.asList(
								"Брат, почему все так хвалят только тебя, когда практически все сценарии написал я. Так не честно!",
								"Я так и не понял Интерстеллар."
						)
				) : "wrong mailService mailbox content (2)";

		assert mailBox.get(randomTo).

				equals(Collections.<String>emptyList()) : "wrong mailService mailbox content (3)";


		// Создание списка из трех зарплат.
		Salary salary1 = new Salary("Facebook", "Mark Zuckerberg", 1);
		Salary salary2 = new Salary("FC Barcelona", "Lionel Messi", Integer.MAX_VALUE);
		Salary salary3 = new Salary(randomFrom, randomTo, randomSalary);

		// Создание почтового сервиса, обрабатывающего зарплаты.
		MailService<Integer> salaryService = new MailService<>();

// Обработка списка зарплат почтовым сервисом
		Arrays.asList(salary1, salary2, salary3).

				forEach(salaryService);

		// Получение и проверка словаря "почтового ящика",
//   где по получателю можно получить список зарплат, которые были ему отправлены.
		Map<String, List<Integer>> salaries = salaryService.getMailBox();
		assert salaries.get(salary1.getTo()).

				equals(Arrays.asList(1)) : "wrong salaries mailbox content (1)";
		assert salaries.get(salary2.getTo()).

				equals(Arrays.asList(Integer.MAX_VALUE)) : "wrong salaries mailbox content (2)";
		assert salaries.get(randomTo).

				equals(Arrays.asList(randomSalary)) : "wrong salaries mailbox content (3)";
	}

	public static interface Sendable<T> {
		String getFrom();
		String getTo();
		T getContent();
	}

	public static class SimpleSendable<T> implements Sendable<T> {
		final String from;
		final String to;
		final T content;

		public SimpleSendable(String from, String to, T content) {
			this.from = from;
			this.to = to;
			this.content = content;
		}

		@Override
		public String getFrom() {
			return from;
		}

		@Override
		public String getTo() {
			return to;
		}

		@Override
		public T getContent() {
			return content;
		}
	}

	public static class MailMessage extends SimpleSendable<String> {

		public MailMessage(String from, String to, String content) {
			super(from, to, content);
		}
	}

	public static class Salary extends SimpleSendable<Integer> {

		public Salary(String from, String to, Integer content) {
			super(from, to, content);
		}
	}

	public static class MailService<T> implements Consumer<Sendable<T>> {

		private Map<String, List<T>> mailBox = new HashMap<String, List<T>>() {
			@Override
			public List<T> get(Object key) {
				return super.get(key) == null ? Collections.emptyList() : super.get(key);
			}
		};

		@Override
		public void accept(Sendable<T> element) {
			if (!mailBox.containsKey(element.getTo())) {
				mailBox.put(element.getTo(), new ArrayList<T>());
			}

			mailBox.get(element.getTo()).add(element.getContent());
		}

		public Map<String, List<T>> getMailBox() {
			return mailBox;
		}
	}
}
