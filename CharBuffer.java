package string;

import static string.Constants.__true__;
import static string.Constants.__false__;
import static string.Constants.__yes__;
import static string.Constants.__no__;
import static string.Constants.__null__;

import static core.IEmptyPrimitiveArrays.empty_char_array;
import static core.IEmptyPrimitiveArrays.empty_byte_array;

import number.DFloat;
import number.SFloat;


/**
* Class for providing support for character buffers.<br>
*
* @author Marc E. KAMGA
* @version 1.0
* @copyright Marc E. KAMGA
*/
public class CharBuffer implements ICharSequence, text.unicode.ICharSurrogates, core.ITrinaryValues { //NOTE: implements core.ITrinaryValues since 2017-11-01

	/**The class's serial version UID. */
	public static final long serialVersionUID = 0x0206B89B61000000L;
	
	protected char[] data; //NOTE: made protected on 2017-04-16 for class URIEncodeBuffer to make use of it outside string package
	protected int limit; //NOTE: made protected on 2017-04-16 for class URIEncodeBuffer to make use of it outside string package
	protected boolean onlyCStringChars; //NOTE: made protected on 2017-04-16 for class URIEncodeBuffer to make use of it outside string package
	protected boolean onlyAsciiChars; //NOTE: made protected on 2017-04-16 for class URIEncodeBuffer to make use of it outside string package
	
	/**
	* Private constructor.<br>
	*/
	private CharBuffer(final char[] buffer) {
		this.data = buffer;
		this.limit = 0;
		this.onlyCStringChars = true;
		this.onlyAsciiChars = true;
	}
	/**
	* Default constructor.<br>
	*/
	public CharBuffer() {
		this(32); //new char[32]
	}
	/**
	* Constructor.<br>
	*/
	public CharBuffer(final int initialCapacity) {
		this(new char[initialCapacity]);
	}
	
	/**
	* Resets the limit of the buffer.<br>
	*/
	public void resetLimitOnly() {
		this.limit = 0;
		this.onlyCStringChars = true;
		this.onlyAsciiChars = true;
	}
	/**
	* Serves to set the limit back to a previous position.<br>
	*/
	public void setLimit(final int newLimit) {
		if (newLimit > limit || newLimit < 0) {
			throw new IndexOutOfBoundsException(
			"CharBuffer::setLimit-1: new limit out of bounds (newLimit=" + newLimit + ", limit=" + limit + ")"
			);
		}
		this.limit = newLimit;
	}
	
	/**
	* {@inheritDoc}
	*/
	public final boolean isEmpty() {
		return limit == 0;
	}
	/**
	* Returns the current limit of the buffer.
	*/
	public final int limit() {
		return limit;
	}
	/**
	* {@inheritDoc}
	*/
	public final int length() {
		return limit;
	}
	/**
	* {@inheritDoc}
	*/
	public final char getChar(int i) {
		return data[i];
	}
	/**
	* {@inheritDoc}
	*/
	public final char charAt(int i) {
		return data[i];
	}
	
	/**
	* {@inheritDoc}
	*/
	public ICharSequence subSequence(int start, int end) {
		if (start >= end) {
			if (start == end) return String.EMPTY;
			throw new IndexOutOfBoundsException(
			"CharBuffer::subSequence-1: index out of bounds (start: " + start + ", end: " + end + ")"
			);
		}
		else if (start < 0 || end > limit) {
			throw new IndexOutOfBoundsException(
			"CharBuffer::subSequence-1: index out of bounds (start: " + start + ", end: " + end + ")"
			);
		}
		return new SubString(end - start, start, data);
	}
	/**
	* {@inheritDoc}
	*/
	public ICharSequence subSequence(int from) {
		if (from == 0) return this;
		if (from >= limit || from < 0) {
			throw new IndexOutOfBoundsException(
			"CharBuffer::subSequence-1: index out of bounds (" + from + ")"
			);
		}
		return new SubString(limit - from, from, data);
	}
	/**
	* {@inheritDoc}
	*/
	public final void getChars(char[] dest, int destOff) {
		System.arraycopy(data, 0, dest, destOff, limit);
	}
	/**
	* {@inheritDoc}
	*/
	public final void getChars(int start, int end, char[] dest, int destOff) {
		if (start >= end) {
			if (start == end) return;
			throw new IndexOutOfBoundsException(
			"CharBuffer::getChars-1: index out of bounds (start: " + start + ", end: " + end + ")"
			);
		}
		else if (start < 0 || end > limit) {
			throw new IndexOutOfBoundsException(
			"CharBuffer::getChars-2: index out of bounds (start: " + start + ", end: " + end + ")"
			);
		}
		System.arraycopy(data, start, dest, destOff, end - start);
	}
	/**
	* {@inheritDoc}
	*/
	public final void get_Chars(int start, int end, char[] dest, int destOff) {
		System.arraycopy(data, start, dest, destOff, end - start);
	}
	/**
	* Copies the <code>len</code> first character of the buffer into a new char array.
	*/
	public final char[] toCharArray(final int len) { //since 2017-11-09
		if (len == 0) return empty_char_array;
		char[] chars = new char[len];
		System.arraycopy(data, 0, chars, 0, len);
		return chars;
	}
	/**
	* Copies the characters that make up the specified character sub-sequence of the buffer into a new char array.
	*/
	public final char[] toCharArray(final int start, final int end) { //since 2018-01-08
		if (start == 0) return toCharArray(end);
		char[] chars = new char[end - start];
		System.arraycopy(data, start, chars, 0, chars.length);
		return chars;
	}
	/**
	* {@inheritDoc}
	*/
	public final char[] toCharArray() {
		return toCharArray(limit);
	}
	/**
	* {@inheritDoc}
	*/
	public java.lang.String toString() {return new java.lang.String(toCharArray()); }
	/**
	* {@inheritDoc}
	*/
	public final boolean startsWith(char ch) {return limit != 0 && data[0] == ch; }
	/**
	* {@inheritDoc}
	*/
	public final boolean endsWith(char ch) {return limit != 0 && data[limit - 1] == ch; }
	/**
	* {@inheritDoc}
	*/
	public int indexOf(char ch) {
		return StringIndexOfCharUtil.indexOf(ch, this, 0);
	}
	/**
	* {@inheritDoc}
	*/
	public int indexOf(char ch, int from) {
		return StringIndexOfCharUtil.indexOf(ch, this, from);
	}
	
	/**
	* {@inheritDoc}
	*/
	public int lastIndexOf(char ch) {
		return StringIndexOfCharUtil.lastIndexOf(ch, this, length() - 1);
	}
	/**
	* {@inheritDoc}
	*/
	public int lastIndexOf(char ch, int untilLastIndex) {
		return StringIndexOfCharUtil.lastIndexOf(ch, this, untilLastIndex);
	}
	/**
	* {@inheritDoc}
	*/
	public int indexOfAny(char ch1, char ch2) {
		return StringIndexOfCharUtil.indexOfAny(ch1, ch2, this, 0);
	}
	/**
	* {@inheritDoc}
	*/
	public int indexOfAny(char... ch) {
		return StringIndexOfCharUtil.indexOfAny(0, this, ch);
	}
	/**
	* {@inheritDoc}
	*/
	public int indexOfAny(char ch1, char ch2, int start) {
		return StringIndexOfCharUtil.indexOfAny(ch1, ch2, this, start);
	}
	/**
	* {@inheritDoc}
	*/
	public int indexOfAny(int start, char... ch) {
		return StringIndexOfCharUtil.indexOfAny(start, this, ch);
	}
	
	/**
	* {@inheritDoc}
	*/
	public final char getFirstChar() {return data[0]; }
	/**
	* {@inheritDoc}
	*/
	public final char getLastChar() {return data[limit - 1]; }
	
	
	/**
	* Ensures at least one more character can be appended to the buffer.<br>
	*/
	public /*final */void ensureCanAddOneMoreChar() { //NOTE: commented out final modifier on 2018-04-18 for class TmpltStringMarkAccumulator to override it to do nothing!!!
		if (limit >= data.length) {
			int newLen = data.length + (data.length >>> 1);
			char[] newarr = new char[newLen <= limit ? limit + 1 : newLen];
			System.arraycopy(data, 0, newarr, 0, limit);
			data = newarr;
		}
	}
	/**
	* Ensures the specified minimum capacity.<br>
	*/
	public final void ensureCapacity(final int n) {
		if (n > data.length) {
			int newLen = data.length + (data.length >>> 1);
			char[] newarr = new char[newLen < n ? n : newLen];
			System.arraycopy(data, 0, newarr, 0, limit);
			data = newarr;
		}
	}
	/**
	* Ensures at least <code>n</code> more characters can be appended to the buffer.<br>
	*/
	public final void ensureCanAddNMoreChars(int n) {
		ensureCapacity(n + limit);
	}
	
	/**
	* Appends the supplied character to the buffer.<br>
	*/
	public void appendChar(final char ch) {
		ensureCanAddOneMoreChar();
		data[limit++] = ch;
		if (onlyCStringChars) {
			if (ch > '\u0100') {
				onlyCStringChars = false;
				onlyAsciiChars = false;
			}
			else if (onlyAsciiChars && ch > '\u007F') {
				onlyAsciiChars = false;
			}
		}
	}
	/**
	* Appends the supplied character to the buffer.<br>
	* @return <code>this</code>
	*/
	public CharBuffer append(char ch) {
		appendChar(ch);
		return this;
	}
	
	/**
	* Appends the supplied characters to the buffer.<br>
	*/
	public void appendChars(char ch1, char ch2) {
		ensureCanAddNMoreChars(2);
		__appendChars(ch1, ch2);
	}
	
	private final void __appendChars(char ch1, char ch2) {
		data[limit++] = ch1;
		data[limit++] = ch2;
		if (onlyCStringChars) {
			if (ch1 > '\u0100' || ch2 > '\u0100') {
				onlyCStringChars = false;
				onlyAsciiChars = false;
			}
			else if (onlyAsciiChars && (ch1 > '\u007F' || ch2 > '\u007F')) {
				onlyAsciiChars = false;
			}
		}
	}
	/**
	* Appends the supplied characters to the buffer.<br>
	* @return <code>this</code>
	*/
	public CharBuffer append(char ch1, char ch2) {
		appendChars(ch1, ch2);
		return this;
	}
	/**
	* Appends the supplied characters to the buffer.<br>
	*/
	public void appendChars(char ch1, char ch2, char ch3) {
		ensureCanAddNMoreChars(3);
		__appendChars(ch1, ch2, ch3);
		
	}
	private final void __appendChars(char ch1, char ch2, char ch3) {
		data[limit++] = ch1;
		data[limit++] = ch2;
		data[limit++] = ch3;
		if (onlyCStringChars) {
			if (ch1 > '\u0100' || ch2 > '\u0100' || ch3 > '\u0100') {
				onlyCStringChars = false;
				onlyAsciiChars = false;
			}
			else if (onlyAsciiChars && (ch1 > '\u007F' || ch2 > '\u007F' || ch3 > '\u007F')) {
				onlyAsciiChars = false;
			}
		}
	}
	/**
	* Appends the supplied characters to the buffer.<br>
	* @return <code>this</code>
	*/
	public CharBuffer append(char ch1, char ch2, char ch3) {
		appendChars(ch1, ch2, ch3);
		return this;
	}
	/**
	* Appends the supplied characters to the buffer.<br>
	*/
	public void appendChars(char ch1, char ch2, char ch3, char ch4) {
		ensureCanAddNMoreChars(4);
		__appendChars(ch1, ch2, ch3, ch4);
	}
	private final void __appendChars(char ch1, char ch2, char ch3, char ch4) {
		data[limit++] = ch1;
		data[limit++] = ch2;
		data[limit++] = ch3;
		data[limit++] = ch4;
		if (onlyCStringChars) {
			if (ch1 > '\u0100' || ch2 > '\u0100' || ch3 > '\u0100' || ch4 > '\u0100') {
				onlyCStringChars = false;
				onlyAsciiChars = false;
			}
			else if (onlyAsciiChars && (ch1 > '\u007F' || ch2 > '\u007F' || ch3 > '\u007F' || ch4 > '\u007F')) {
				onlyAsciiChars = false;
			}
		}
	}
	/**
	* Appends the supplied characters to the buffer.<br>
	* @return <code>this</code>
	*/
	public CharBuffer append(char ch1, char ch2, char ch3, char ch4) {
		appendChars(ch1, ch2, ch3, ch4);
		return this;
	}
	
	/**
	* Appends the supplied characters to the buffer.<br>
	*/
	public void appendChars(char ch1, char ch2, char ch3, char ch4, final char ch5) {
		ensureCanAddNMoreChars(5);
		__appendChars(ch1, ch2, ch3);
		__appendChars(ch4, ch5);
	}
	/**
	* Appends the supplied characters to the buffer.<br>
	* @return <code>this</code>
	*/
	public CharBuffer append(char ch1, char ch2, char ch3, char ch4, char ch5) {
		appendChars(ch1, ch2, ch3, ch4, ch5);
		return this;
	}
	
	/**
	* Appends the supplied characters to the buffer.<br>
	*/
	public void appendChars(char ch1, char ch2, char ch3, char ch4, final char ch5, final char ch6) {
		ensureCanAddNMoreChars(6);
		__appendChars(ch1, ch2, ch3);
		__appendChars(ch4, ch5, ch6);
	}
	/**
	* Appends the supplied characters to the buffer.<br>
	* @return <code>this</code>
	*/
	public CharBuffer append(char ch1, char ch2, char ch3, char ch4, char ch5, char ch6) {
		appendChars(ch1, ch2, ch3, ch4, ch5, ch6);
		return this;
	}
	
	/**
	* Appends supplied characters to the buffer.<br>
	*/
	public void appendChars(char... chars) { //since 2017-09-05
		if (chars.length == 0) return;
		ensureCanAddNMoreChars(chars.length);
		System.arraycopy(chars, 0, data, limit, chars.length);
		limit += chars.length;
	}
	/**
	* Appends supplied characters to the buffer.<br>
	* @return <code>this</code>
	*/
	public CharBuffer append(char... chars) { //since 2017-09-05
		appendChars(chars);
		return this;
	}
	
	/**
	* Appends the supplied characters of the specified string to the buffer.<br>
	*/
	public void appendChars(CharSequence str, int start, int end) {
		ensureCanAddNMoreChars(end - start);
		for (;start<end;start++)
		{
			char ch = str.charAt(start);
			data[limit++] = ch;
			if (onlyCStringChars) {
				if (ch > '\u0100') {
					onlyCStringChars = false;
					onlyAsciiChars = false;
				}
				else if (onlyAsciiChars && (ch > '\u007F')) {
					onlyAsciiChars = false;
				}
			}
		}
	}
	/**
	* Appends the supplied characters of the specified string to the buffer.<br>
	*/
	public final void appendChars(java.lang.CharSequence str) {
		appendChars(str, 0, str.length());
	}
	/**
	* Appends the supplied characters of the specified string to the buffer.<br>
	* @return <code>this</code>
	*/
	public CharBuffer append(CharSequence str, int start, int end) {
		appendChars(str, start, end);
		return this; 
	}
	/**
	* Appends the supplied characters of the specified string to the buffer.<br>
	* @return <code>this</code>
	*/
	public CharBuffer append(CharSequence str) {
		appendChars(str, 0, str.length());
		return this; 
	}
	/**
	* Appends the supplied characters of the specified string to the buffer.<br>
	*/
	public void appendChars(final ICharSequence str, final int start, final int end) {
		ensureCanAddNMoreChars((end - start)/*len*/);
		str.get_Chars(start, end, data, limit);
		limit += (end - start)/*len*/;
		if (!onlyCStringChars) {
			return ;
		}
		else if (str.isLatin() == no) { //since 2017-11-01
			onlyCStringChars = false;
			if (!onlyAsciiChars) {
				onlyAsciiChars = false;
			}
			return ;
		}
		else if (str.isLatin() == yes) { //since 2017-11-01
			if (onlyAsciiChars && str.isAscii() != yes) {
				onlyAsciiChars = false;
			}
			return ;
		}
		__checkForCStringFlags(str, start, end);
	}
	
	protected final void __checkForCStringFlags(final ICharSequence str, int start, final int end) {
		for (;start<end;start++)
		{
			char ch = str.getChar(start);
			if (onlyCStringChars) {
				if (ch > '\u0100') {
					onlyCStringChars = false;
					onlyAsciiChars = false;
					return ;
				}
				else if (onlyAsciiChars && (ch > '\u007F')) {
					onlyAsciiChars = false;
				}
			}
		}
	}
	/**
	* Appends the supplied characters of the specified string to the buffer.<br>
	*/
	public final void appendChars(ICharSequence str) {
		appendChars(str, 0, str.length());
	}
	/**
	* Appends the supplied characters of the specified string to the buffer.<br>
	* @return <code>this</code>
	*/
	public CharBuffer append(ICharSequence str, int start, int end) {
		appendChars(str, start, end);
		return this; 
	}
	/**
	* Appends the supplied characters of the specified string to the buffer.<br>
	* @return <code>this</code>
	*/
	public CharBuffer append(ICharSequence str) {
		appendChars(str);
		return this; 
	}
	/**
	* Appends the supplied characters of the specified string to the buffer.<br>
	*/
	public final void appendChars(final string.String str) {
		appendChars(str, 0, str.length());
	}
	/**
	* Appends the supplied characters of the specified string to the buffer.<br>
	* @return <code>this</code>
	*/
	public CharBuffer append(final string.String str) {
		appendChars(str);
		return this; 
	}
	/**
	* Appends the supplied characters of the specified string to the buffer.<br>
	*/
	public void appendChars(final java.lang.String str, int start, int end) {
		ensureCanAddNMoreChars((end - start)/*len*/);
		str.getChars(start, end, data, limit);
		limit += (end - start)/*len*/;
		if (!onlyCStringChars) {
			return ;
		}
		for (;start<end;start++)
		{
			char ch = str.charAt(start);
			if (onlyCStringChars) {
				if (ch > '\u0100') {
					onlyCStringChars = false;
					onlyAsciiChars = false;
					return ;
				}
				else if (onlyAsciiChars && (ch > '\u007F')) {
					onlyAsciiChars = false;
				}
			}
		}
	}
	/**
	* Appends the supplied characters of the specified string to the buffer.<br>
	*/
	public final void appendChars(java.lang.String str) {
		appendChars(str, 0, str.length());
	}
	/**
	* Appends the supplied characters of the specified string to the buffer.<br>
	* @return <code>this</code>
	*/
	public CharBuffer append(java.lang.String str, int start, int end) {
		appendChars(str, start, end);
		return this; 
	}
	/**
	* Appends the supplied characters of the specified string to the buffer.<br>
	* @return <code>this</code>
	*/
	public CharBuffer append(java.lang.String str) {
		appendChars(str);
		return this;
	}
	/**
	* Appends the decimal string representation of the supplied 32-bit integer number to the buffer.<br>
	*/
	public void appendInteger(final int value) {
		ensureCanAddNMoreChars(number.util.IntUtil.getNumOfDecimalDigits(value));
		limit += number.ConvertInt2StrUtil.getChars(value, data, limit);
	}
	/**
	* Appends the decimal string representation of the supplied 32-bit integer number to the buffer.<br>
	* @return <code>this</code>
	*/
	public CharBuffer append(final int value) {
		appendInteger(value);
		return this; 
	}
	/**
	* Appends the decimal string representation of the supplied 64-bit integer number to the buffer.<br>
	*/
	public void appendInteger(final long value) {
		ensureCanAddNMoreChars(number.util.LongUtil.getNumOfDecimalDigits(value));
		limit += number.ConvertLongInt2StrUtil.getChars(value, data, limit);
	}
	/**
	* Appends the decimal string representation of the supplied 64-bit integer number to the buffer.<br>
	* @return <code>this</code>
	*/
	public CharBuffer append(final long value) {
		appendInteger(value);
		return this; 
	}
	/**
	* Appends the decimal string representation of the supplied 16-bit integer number to the buffer.<br>
	*/
	public void appendInteger(final short value) {
		ensureCanAddNMoreChars(number.util.IntUtil.getNumOfDecimalDigits(value));
		limit += number.util.ConvertShortInt2StrUtil.getChars(value, data, limit);
	}
	/**
	* Appends the decimal string representation of the supplied 16-bit integer number to the buffer.<br>
	* @return <code>this</code>
	*/
	public CharBuffer append(final short value) {
		appendInteger(value);
		return this; 
	}
	/**
	* Appends the string representation of the supplied boolean value to the buffer.<br>
	*/
	public void appendBool(final boolean value) {
		ensureCanAddNMoreChars(5);
		if (value) {
			appendChars(__true__);
		}
		else {
			appendChars(__false__);
		}
	}
	/**
	* Appends the string representation of the supplied boolean value to the buffer.<br>
	* @return <code>this</code>
	*/
	public CharBuffer append(final boolean value) {
		appendBool(value);
		return this; 
	}
	
	/**
	* Appends <code>&quot;yes&quot;</code> to the buffer.<br>
	*/
	public void appendYes() {
		ensureCanAddNMoreChars(3);
		appendChars(__yes__);
	}
	/**
	* Appends <code>&quot;no&quot;</code> to the buffer.<br>
	*/
	public void appendNo() {
		ensureCanAddNMoreChars(2);
		appendChars(__no__);
	}
	/**
	* Appends <code>&quot;null&quot;</code> to the buffer.<br>
	*/
	public void appendNull() {
		ensureCanAddNMoreChars(4);
		appendChars(__null__);
	}
	/**
	* Appends <code>len</code> tab characters to the buffer.<br>
	*/
	public void appendTabs(final int len) {
		ensureCanAddNMoreChars(len);
		string.util.TabPaddingUtil.pad(len, data, limit);
		limit += len;
	}
	/**
	* Appends <code>len</code> tab characters to the buffer.<br>
	* @return <code>this</code>
	*/
	public CharBuffer AppendTabs(final int len) {
		appendTabs(len);
		return this; 
	}
	/**
	* Appends <code>len</code> space characters to the buffer.<br>
	*/
	public void appendSpaces(final int len) {
		ensureCanAddNMoreChars(len);
		string.util.SpacePaddingUtil.pad(len, data, limit);
		limit += len;
	}
	/**
	* Appends <code>len</code> space characters to the buffer.<br>
	* @return <code>this</code>
	*/
	public CharBuffer AppendSpaces(final int len) {
		appendSpaces(len);
		return this; 
	}
	/**
	* Appends <code>len</code> space characters to the buffer.<br>
	* @param tabSpaces flag telling if the desire space characters are actually tab characters
	*/
	public void appendSpaces(final int len, final boolean tabSpaces) {
		if (tabSpaces) {
			appendTabs(len);
		}
		else {
			appendSpaces(len);
		}
	}
	/**
	* Appends <code>len</code> space characters to the buffer.<br>
	* @param tabSpaces flag telling if the desire space characters are actually tab characters
	* @return <code>this</code>
	*/
	public CharBuffer AppendSpaces(final int len, final boolean tabSpaces) {
		appendSpaces(len, tabSpaces);
		return this; 
	}
	/**
	* Appends <code>len</code> '0' characters to the buffer.<br>
	*/
	public void appendZeroes(final int len) {
		ensureCanAddNMoreChars(len);
		number.util.ZeroPaddingUtil.pad(len, data, limit);
		limit += len;
	}
	/**
	* Appends <code>len</code> '0' characters to the buffer.<br>
	* @return <code>this</code>
	*/
	public CharBuffer AppendZeroes(final int len) {
		appendZeroes(len);
		return this; 
	}
	/**
	* Appends the textual value of the supplied {@link Value Value} to the buffer.<br>
	*/
	public void appendValue(final core.Value value) {
		if (value.isString() && !value.isGUID()) {
			appendChars(value.asString());
			return ;
		}
		ensureCanAddNMoreChars(value.length()/*maxCharLen*/);
		limit += value.getCharacters(data, limit);
	}
	/**
	* Appends the textual value of the supplied {@link Value Value} to the buffer.<br>
	* @return <code>this</code>
	*/
	public CharBuffer append(final core.Value value) {
		appendValue(value);
		return this;
	}
	
	protected final void unsafe_append_unicode_suppl_cp(int supplCp) {
		supplCp -= 0x10000;
		data[limit++] = (char)((supplCp >>> 10) + MIN_HIGH_SURROGATE);
		data[limit++] = (char)((supplCp & 0x3FF) + MIN_LOW_SURROGATE);
		if (onlyAsciiChars || onlyCStringChars) {
			onlyAsciiChars = false;
			onlyCStringChars = false;
		}
	}
	/**
	* Appends the hexadecimal data (comprised of 4 hexadecimal digits) of the supplied character to the buffer.<br>
	*/
	public void appendHexData(final char ch) { //since 2017-07-31
		ensureCanAddNMoreChars(4);
		core.util.HexUtil.getHexData(ch, data, limit);
		limit += 4;
	}
	/**
	* Appends the decimal representation of the supplied double-precision floating point number to the buffer.<br>
	*/
	public void appendDouble(final double value) {
		ensureCanAddNMoreChars(DFloat.length(value));
		limit += DFloat.getCharacters(value, data, limit);
	}
	/**
	* Appends the decimal representation of the supplied double-precision floating point number to the buffer.<br>
	* @return <code>this</code>
	*/
	public CharBuffer append(final double value) {
		appendDouble(value); return this; 
	}
	/**
	* Appends the decimal representation of the supplied single-precision floating point number to the buffer.<br>
	*/
	public void appendSingle(final float value) {
		ensureCanAddNMoreChars(SFloat.length(value));
		limit += SFloat.getCharacters(value, data, limit);
	}
	/**
	* Appends the decimal representation of the supplied single-precision floating point number to the buffer.<br>
	* @return <code>this</code>
	*/
	public CharBuffer append(final float value) {
		appendDouble(value); return this; 
	}
	/**
	* Sets the supplied character at the indicated index.<br>
	* @throws IndexOutOfBoundsException if <code>atIndex</code> is out of bounds
	*/
	public void setChar(final char ch, int atIndex) { //since 2018-05-11
		CharBufferUpdUtil.setChar(ch, atIndex, this);
	}
	/**
	* Sets the supplied character at the indicated index.<br>
	* @throws IndexOutOfBoundsException if <code>atIndex</code> is out of bounds
	* @return <code>this</code>
	*/
	public CharBuffer set(final char ch, final int atIndex) { //since 2018-05-11
		setChar(ch, atIndex); return this; 
	}
	/**
	* Inserts a (sub-)string into the character buffer at the indicated index position.<br>
	*/
	public void insertChars(final ICharSequence str, final int start, final int end, int atIndex) { //since 2018-05-11
		CharBufferUpdUtil.insertChars(str, start, end, atIndex, this);
	}
	/**
	* Inserts a string into the character buffer at the indicated index position.<br>
	*/
	public void insertChars(final ICharSequence str, final int atIndex) { //since 2018-05-11
		insertChars(str, 0, str.length(), atIndex);
	}
	/**
	* Inserts a (sub-)string into the character buffer at the indicated index position.<br>
	*/
	public void insertChars(final java.lang.String str, final int start, final int end, final int atIndex) { //since 2018-05-11
		CharBufferUpdUtil.insertChars(str, start, end, atIndex, this);
	}
	/**
	* Inserts a string into the character buffer at the indicated index position.<br>
	*/
	public void insertChars(final java.lang.String str, final int atIndex) { //since 2018-05-11
		insertChars(str, 0, str.length(), atIndex);
	}
	
	/**
	* Tells if the buffer content is only made up of ASCII characters.<br>
	*/
	public final boolean onlyHasAsciiChars() {
		return onlyAsciiChars;
	}
	/**
	* Tells if the buffer content is only made up of Latin/ASCII characters.<br>
	*/
	public final boolean onlyHasCStringChars() {
		return onlyCStringChars;
	}
	
	/**
	* {@inheritDoc}
	*/
	@Override
	public final byte isAscii() { //since 2017-11-01
		return onlyAsciiChars ? yes : no;
	}
	/**
	* {@inheritDoc}
	*/
	@Override
	public final byte isLatin() { //since 2017-11-01
		return onlyCStringChars ? yes : no;
	}
	
	/**
	* Converts the content of this buffer to a {@link String String}.<br>
	* @param createAsCStringIfPossible flag telling to create the string as an Ascii/latin string if the data of the buffer permits
	*/
	public final String ToString(boolean createAsCStringIfPossible) {
		return ToString(limit, createAsCStringIfPossible);
	}
	/**
	* Converts the content of this buffer to a {@link String String}.<br>
	*/
	public final String ToString() {
		return ToString(false);
	}
	/**
	* Copies the characters that make up the specified character sub-sequence of the buffer into a new char array, assuming without checking that the content of the buffer is comprised only of ASCII/Latin characters.<br>
	*/
	public final byte[] to_Char8Array(int start, final int end) { //since 2018-01-08
		if (start == 0) return to_Char8Array(end);
		if (start == end) return empty_byte_array;
		byte[] arr = new byte[end - start];
		for (int i=0;start<end;start++, i++)
		{
			arr[i] = (byte)data[start];
		}
		return arr;
	}
	/**
	* Converts he content of this to a <code>byte</code>, assuming without checking that the content of the buffer is comprised only of ASCII/Latin characters.<br>
	* @param len the number of first characters to copy
	*/
	public final byte[] to_Char8Array(final int len) {
		if (len == 0) return empty_byte_array;
		byte[] arr = new byte[len];
		for (int i=0;i<len;i++)
		{
			arr[i] = (byte)data[i];
		}
		return arr;
	}
	/**
	* Converts he content of this to a <code>byte</code>, assuming without checking that the content of the buffer is comprised only of ASCII/Latin characters.<br>
	*/
	public final byte[] to_Char8Array() {
		return to_Char8Array(limit);
	}
	
	/**
	* Converts the content of this buffer to a {@link String String}.<br>
	* @param createAsCStringIfPossible flag telling to create the string as an Ascii/latin string if the data of the buffer permits
	*/
	public final String ToString(final int len, boolean createAsCStringIfPossible) { //since 2017-11-09
		if (len == 0) return String.EMPTY;
		if (createAsCStringIfPossible && onlyCStringChars) {
			byte[] chars = to_Char8Array(len);
			return onlyAsciiChars ? new AsciiFullSizeString(chars) : new CFullSizeString(chars);
		}
		return new FullSizeString(toCharArray(len));
	}
	
	/**
	* Normalizes the trailing line terminator characters of the buffer to a single line feed character.<br>
	*/
	public void normalizeTrailingLineTermintaor() {
		if (limit == 0) return ;
		int j = limit - 1;
		char ch = data[j];
		if (ch != '\r' && ch != '\n') return ;
		do
		{
			ch = data[j];
			if (ch == '\n') {
				do 
				{
					j--;
					if (j < 0) {
						limit = 0;
						return ;
					}
					ch = data[j];
					if (ch == '\n') {
						j--;
						if (j == 0) {
							limit = 0;
							return ;
						}
						continue ;
					}
					limit = j + 1;
					return ;
				} while (true);
			}
			else if (ch == '\r') {
				data[j] = '\n';
			}
			limit = j + 1;
			return ;
		} while (true);
	}
	/**
	* Computes the hash code of this <code>CharBuffer</code>'s content.
	*/
	@Override
	public int hashCode() { //since 2017-11-16
		return StringHashCodeUtil.hashCode(this, length());
	}
	/**
	* Tells if this <code>CharBuffer</code> is an instance of {@link TemplateStringBuffer TemplateStringBuffer} class.<br>
	*/
	public boolean isTemplateStringBuffer() {return false; } //since 2018-04-13
	/**
	* @throws ClassCastException if this <code>CharBuffer</code> is not an instance of {@link TemplateStringBuffer TemplateStringBuffer} class.<br>
	*/
	public TemplateStringBuffer asTemplateStringBuffer() {return (TemplateStringBuffer)this; } //since 2018-04-13

}