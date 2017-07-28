
/*
 * SimpleTokenizer
 * Eric McCreath 2017
 */

public class SimpleTokenizer extends Tokenizer {

	String text; // the text to be tokenizer
	int pos; // position the tokenizer is currently pointing at.
	Object current; // the current token that has just been tokenized, noting
					// the "pos" will point just after the text of this token

	public SimpleTokenizer(String text) {
		this.text = text;
		pos = 0;
		next();
	}

	@Override
	boolean hasNext() {
		return current != null;
	}

	@Override
	Object current() {
		return current;
	}

	@Override
	void next() {
		char c = 0;
		int textlen = text.length();

		
		if (pos < textlen)
			c = text.charAt(pos);

		
		// consume the white space
//		if (c == ' '){
//			pos++;
//			next();
//		}
		// by Leo while() will be good
		
		while(c == ' '){
			pos++;
			if (pos < textlen){
				c = text.charAt(pos);
			}
			else{
				c = 0;
				break;
			}
		}
		
		// modify this code
		if (c == '\n' ){
			pos++;
			current = "!";
			return;
		}
		

		if (pos >= textlen) {
			current = null;
			return;
		} else if (c == '(') {
			pos++;
			current = "(";
			return;
		} else if (c == '0') {
			pos++;
			current = new Integer(0);
			return;
		} else if (Character.isAlphabetic(c)) {
			String res = "" + c;
			pos++;
			c = text.charAt(pos);
			while (pos < textlen && Character.isAlphabetic(c)) {
				res += c;
				pos++;
				c = text.charAt(pos);
			}
			current = res;
			return;
		}
		// modification from here by Leo
		else if (c == ')'){
			pos++;
			current = ")";
			return;
		} else if (c == ':'){
			pos++;
			current = ":";
			return;
		}else if (c == '?'){
			pos++;
			current = "?";
			return;
		}else if (c == ','){
			pos++;
			current = ",";
			return;
		}else if (c == '='){
			pos++;
			current = "=";
			return;
		}



	}

}
