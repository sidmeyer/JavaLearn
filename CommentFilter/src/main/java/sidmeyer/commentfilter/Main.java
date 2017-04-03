package sidmeyer.commentfilter;

public class Main {
	public static void main(String[] args) {
		String comment = "bullshi breaking bad (";
		String[] badWords = new String[]{"shit", "fuck"};
		int maxLength = 25;
		System.out.println(new SpamAnalyzer(badWords).processText(comment));
		System.out.println(new NegativeTextAnalyzer().processText(comment));
		System.out.println(new TooLongTextAnalyzer(maxLength).processText(comment));

		System.out.println(checkLabels(comment, new SpamAnalyzer(badWords), new NegativeTextAnalyzer(), new TooLongTextAnalyzer(maxLength)));
	}

	public static Label checkLabels(String text, TextAnalyzer ... analyzers) {
		for (TextAnalyzer analyzer : analyzers) {
			Label currentLabel = analyzer.processText(text);
			if(!currentLabel.equals(Label.OK)) {
				return currentLabel;
			}
		}
		return Label.OK;
	}
}
