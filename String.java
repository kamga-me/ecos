package string;

import core.util.SysPropUtil;
import core.logging.Logger;

/**
* Class for providing support for strings.<br>
*
* <br><b>TODO - VERY VERY URGENT</b>: get rid, ASAP, of java.lang.Character.toUpperCase and java.lang.Character.toUpperCase in the equals, compare and match methods.<br>
*
* @author Marc E. KAMGA
* @version 1.0
* @copyright Marc E. KAMGA
*
* @see CharBuffer CharBuffer
* @see StringConcat StringConcat
* @see StringJoiner StringJoiner
* @ee StringPrefixCompareUtil StringPrefixCompareUtil
*/
public abstract class String extends core.Value implements ICharSequence, text.unicode.ICharSurrogates, IUString, core.ITrinaryValues, IStringClassTypeNumbers, Comparable<String>, core.stylesheet.css.ICSSValue {

	protected static Logger getLogger() {
		return null; 
	}
	
	protected static final boolean LENGTH_DEPENDENT_SLICE = !SysPropUtil.getBooleanSysProp("string.slice.arrayCopyNotDependentOnLength", false, getLogger());
	protected static final short SLICE_SUBSTR_UP_TO_LEN = SysPropUtil.getNonNegativeShortIntSysProp("string.slice.substringUpToLength", (short)64, getLogger());
	protected static final int SLICE_SUBSTR_UP_TO_LEN_IF_AT_LEAST_HALF = SysPropUtil.getUShortIntSysProp("string.slice.substringUpToLengthIfAtLeastHalf", 256, getLogger());

	/**
	* Constructor.
	*/
	protected String() {
		super();
	}

	/**
	* Gets the second character of the string.
	*/
	public char getSecondChar() {return getChar(1); }

	/**
	* Returns the sub-sequence starting at index <code>start</code> whose last character is at index <code>end - 1</code>
	*/
	public abstract String substring(int start, int end);
	/**
	* @return <code>subSequence(from, this.length())</code>
	*/
	public abstract String substring(int from);

	/**
	* {@inheritDoc}
	* @return <code>substring(start, end)</code>
	*/
	public final String subSequence(int start, int end) {
		return substring(start, end);
	}
	/**
	* {@inheritDoc}
	* @return <code>substring(from)</code>
	*/
	public final String subSequence(int from) {
		return substring(from);
	}
	/**
	* Computes the hash code of this <code>String</code>.
	*/
	public int hashCode() {
		return StringHashCodeUtil.hashCode(this, length());
	}
	/**
	* Computes the hash code of this <code>String</code>, ignoring case.
	*/
	public int hashCodeIgnoreCase() {
		return StringCIHashCodeUtil.hashCode(this, length());
	}
	/**
	* Computes the hash code of this <code>String</code>, ignoring ASCII case.
	*/
	public int hashCodeIgnoreAsciiCase() {
		return StringAsciiCIHashCodeUtil.hashCode(this, length());
	}
	/**
	* Compares this string and that supplied, for equality.<br>
	*/
	public boolean equals(core.Thing other) {return other.isString() && equals(other.asString()); }
	/**
	* Compares this string and that supplied, for equality.<br>
	*/
	public boolean equals(core.Value other) {return other.isString() && equals(other.asString()); }
	/**
	* Compares this string and that supplied, for equality.<br>
	*/
	public boolean equals(String other) {return StringCompareUtil.equals(this, other); }
	/**
	* Compares this string and that supplied, for equality.<br>
	*/
	public boolean equals(ICharSequence other) {return StringCompareUtil.equals(this, other); }
	/**
	* Compares this string and that supplied, for equality.<br>
	*/
	public boolean equals(CharSequence other) {return StringCompareUtil.equals(this, other); }
	/**
	* Compares this string and the supplied <code>java.lang.Object</code>, for equality.<br>
	*/
	public boolean equals(java.lang.Object other) {
		if (other == this) return true;
		else if (other instanceof ICharSequence) return equals((ICharSequence)other);
		return other instanceof CharSequence && equals((CharSequence)other);
	}
	/**
	* Compares this string and that specified, for equality.<br>
	*/
	public boolean equalsSubString(final ICharSequence other, int start, int end) {
		return StringCompareUtil.equals(this, other, start, end);
	}
	/**
	* Compares this string and that specified, for equality.<br>
	*/
	public boolean equalsSubString(final CharSequence other, int start, int end) {
		return StringCompareUtil.equals(this, other, start, end);
	}
	/**
	* Compares this string and that supplied, for order.<br>
	*/
	public byte compare(core.Value other) {
		if (other.isString()) {
			return compare(other.asString());
		}
		return super.compare(other);
	}
	/**
	* Compares this string and that supplied, for order.<br>
	*/
	public byte compare(String other) {return StringCompareUtil.compare(this, other); }
	/**
	* Compares this string and that supplied, for order.<br>
	*/
	public byte compare(ICharSequence other) {return StringCompareUtil.compare(this, other); }
	/**
	* Compares this string and that supplied, for order.<br>
	*/
	public byte compare(CharSequence other) {return StringCompareUtil.compare(this, other); }
	/**
	* Compares this string and that specified, for order.<br>
	*/
	public byte compare(final char[] other, final int otherOff, final int otherLen) {return StringCompareToCharArrayUtil.compare(this, other, otherOff, otherLen); }
	/**
	* Compares this string and that supplied, for order.<br>
	*/
	public final int compareTo(String other) {return compare(other); }
	/**
	* Compares this string and that specified, for order.<br>
	*/
	public byte compareToSubString(ICharSequence other, int start, int end) {
		return StringCompareUtil.compare(this, other, start, end);
	}
	/**
	* Compares this string and that specified, for order.<br>
	*/
	public byte compareToSubString(CharSequence other, int start, int end) {
		return StringCompareUtil.compare(this, other, start, end);
	}

	/**
	* Compares this string and that supplied, for equality, with the case being ignored.<br>
	*/
	public boolean equalsIgnoreAsciiCase(String other) {return StringCompareUtil_ASCII_CI.equals(this, other); }
	/**
	* Compares this string and that supplied, for equality, with the case being ignored.<br>
	*/
	public boolean equalsIgnoreAsciiCase(ICharSequence other) {return StringCompareUtil_ASCII_CI.equals(this, other); }
	/**
	* Compares this string and that supplied, for equality, with the case being ignored.<br>
	*/
	public boolean equalsIgnoreAsciiCase(CharSequence other) {return StringCompareUtil_ASCII_CI.equals(this, other); }

	/**
	* Compares this string and that supplied, for equality, with the case being ignored.<br>
	*/
	public boolean equalsIgnoreCase(String other) {return StringCompareUtil_CI.equals(this, other); }
	/**
	* Compares this string and that supplied, for equality, with the case being ignored.<br>
	*/
	public boolean equalsIgnoreCase(ICharSequence other) {return StringCompareUtil_CI.equals(this, other); }
	/**
	* Compares this string and that supplied, for equality, with the case being ignored.<br>
	*/
	public boolean equalsIgnoreCase(CharSequence other) {return StringCompareUtil_CI.equals(this, other); }
	/**
	* Compares this string and the supplied <code>java.lang.Object</code>, for equality, with the case being ignored.<br>
	*/
	public boolean equalsIgnoreCase(java.lang.Object other) {
		if (other == this) return true;
		else if (other instanceof ICharSequence) return equalsIgnoreCase((ICharSequence)other);
		return other instanceof CharSequence && equalsIgnoreCase((CharSequence)other);
	}
	/**
	* Compares this string and that specified, for equality, with the case being ignored.<br>
	*/
	public boolean equalsSubStrIgnoreCase(ICharSequence other, int start, int end) {return StringCompareUtil_CI.equals(this, other, start, end); }
	/**
	* Compares this string and that specified, for equality, with the case being ignored.<br>
	*/
	public boolean equalsSubStrIgnoreCase(CharSequence other, int start, int end) {return StringCompareUtil_CI.equals(this, other, start, end); }

	/**
	* Compares this string and that specified, for equality, with the case being ignored.<br>
	*/
	public boolean equalsSubStrIgnoreAsciiCase(ICharSequence other, int start, int end) {return StringCompareUtil_ASCII_CI.equals(this, other, start, end); }
	/**
	* Compares this string and that specified, for equality, with the case being ignored.<br>
	*/
	public boolean equalsSubStrIgnoreAsciiCase(CharSequence other, int start, int end) {return StringCompareUtil_ASCII_CI.equals(this, other, start, end); }


	/**
	* Compares this string and that supplied, for order, with the case being ignored.<br>
	*/
	public byte compareIgnoreAsciiCase(String other) {return StringCompareUtil_ASCII_CI.compare(this, other); }
	/**
	* Compares this string and that supplied, for order, with the case being ignored.<br>
	*/
	public byte compareIgnoreAsciiCase(ICharSequence other) {return StringCompareUtil_ASCII_CI.compare(this, other); }
	/**
	* Compares this string and that supplied, for order, with the case being ignored.<br>
	*/
	public byte compareIgnoreAsciiCase(CharSequence other) {return StringCompareUtil_ASCII_CI.compare(this, other); }
	/**
	* Compares this string and that specified, for order, with the case being ignored.<br>
	*/
	public byte compareIgnoreAsciiCase(final char[] other, final int otherOff, final int otherLen) {return StringCompareToCharArrayUtil.compareIgnoreAsciiCase(this, other, otherOff, otherLen); }

	/**
	* Compares this string and that supplied, for order, with the case being ignored.<br>
	*/
	public byte compareIgnoreCase(String other) {return StringCompareUtil_CI.compare(this, other); }
	/**
	* Compares this string and that supplied, for order, with the case being ignored.<br>
	*/
	public byte compareIgnoreCase(ICharSequence other) {return StringCompareUtil_CI.compare(this, other); }
	/**
	* Compares this string and that supplied, for order, with the case being ignored.<br>
	*/
	public byte compareIgnoreCase(CharSequence other) {return StringCompareUtil_CI.compare(this, other); }
	/**
	* Compares this string and that supplied, for order, with the case being ignored.<br>
	*/
	public final int compareToIgnoreCase(String other) {return compareIgnoreCase(other); }
	/**
	* Compares this string and that specified, for order, with the case being ignored.<br>
	*/
	public byte compareToSubStrIgnoreCase(ICharSequence other, int start, int end) {return StringCompareUtil_CI.compare(this, other, start, end); }
	/**
	* Compares this string and that specified, for order, with the case being ignored.<br>
	*/
	public byte compareToSubStrIgnoreCase(CharSequence other, int start, int end) {return StringCompareUtil_CI.compare(this, other, start, end); }

	/**
	* Compares this string and that specified, for order, with the case being ignored.<br>
	*/
	public byte compareToSubStrIgnoreAsciiCase(ICharSequence other, int start, int end) {return StringCompareUtil_ASCII_CI.compare(this, other, start, end); }
	/**
	* Compares this string and that specified, for order, with the case being ignored.<br>
	*/
	public byte compareToSubStrIgnoreAsciiCase(CharSequence other, int start, int end) {return StringCompareUtil_ASCII_CI.compare(this, other, start, end); }

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
	* Returns the index of the first occurrence of character <code>ch</code>.<br>
	*/
	public int indexOf(final ICharSequence substr) {return indexOf(substr, 0); }
	/**
	* Returns the index of the first occurrence of character <code>ch</code>, starting from the indicated index position.<br>
	*/
	public int indexOf(final ICharSequence substr, final int from) {
		return StringIndexOfSubStrUtil.indexOf(substr, this, from);
	}

	/**
	* Returns the index of the firs occurrence of character <code>ch</code>.<br>
	*/
	public int lastIndexOf(final ICharSequence substr) {
		return lastIndexOf(substr, length() - 1);
	}
	/**
	* Returns the index of the firs occurrence of character <code>ch</code>, until the indicated last index position.<br>
	*/
	public int lastIndexOf(final ICharSequence substr, final int untilLastIndex) {
		return StringIndexOfSubStrUtil.lastIndexOf(substr, this, untilLastIndex);
	}

	/**
	* Returns the index of the first occurrence of character <code>ch</code>.<br>
	*/
	public int indexOf(final CharSequence substr) {return indexOf(substr, 0); }
	/**
	* Returns the index of the first occurrence of character <code>ch</code>, starting from the indicated index position.<br>
	*/
	public int indexOf(final CharSequence substr, final int from) {
		return StringIndexOfSubStrUtil.indexOf(substr, this, from);
	}

	/**
	* Returns the index of the firs occurrence of character <code>ch</code>.<br>
	*/
	public int lastIndexOf(final CharSequence substr) {
		return lastIndexOf(substr, length() - 1);
	}
	/**
	* Returns the index of the firs occurrence of character <code>ch</code>, until the indicated last index position.<br>
	*/
	public int lastIndexOf(final CharSequence substr, final int untilLastIndex) {
		return StringIndexOfSubStrUtil.lastIndexOf(substr, this, untilLastIndex);
	}

	/**
	* Tells if the character sequence starts with the indicated character.
	*/
	public final boolean startsWith(final ICharSequence prefix) {
		return regionMatches(0, prefix, false);
	}
	/**
	* Tells if the character sequence ends with the indicated character.
	*/
	public final boolean endsWith(final ICharSequence prefix) {
		int len = length();
		len -= prefix.length();
		if (len < 0) return false;
		return regionMatches(len, prefix, false);
	}
	/**
	* Tells if the character sequence starts with the indicated character.
	*/
	public final boolean startsWith(final CharSequence prefix) {
		return regionMatches(0, prefix, false);
	}
	/**
	* Tells if the character sequence ends with the indicated character.
	*/
	public final boolean endsWith(final CharSequence prefix) {
		int len = length();
		len -= prefix.length();
		if (len < 0) return false;
		return regionMatches(len, prefix, false);
	}

	/**
	* Tells if the character sequence starts with the indicated character.
	*/
	public final boolean startsWithCI(final ICharSequence prefix) {
		return regionMatches(0, prefix, false);
	}
	/**
	* Tells if the character sequence ends with the indicated character.
	*/
	public final boolean endsWithCI(final ICharSequence prefix) {
		int len = length();
		len -= prefix.length();
		if (len < 0) return false;
		return regionMatches(len, prefix, true);
	}
	/**
	* Tells if the character sequence starts with the indicated character.
	*/
	public final boolean startsWithCI(final CharSequence prefix) {
		return regionMatches(0, prefix, false);
	}
	/**
	* Tells if the character sequence ends with the indicated character.
	*/
	public final boolean endsWithCI(final CharSequence prefix) {
		int len = length();
		len -= prefix.length();
		if (len < 0) return false;
		return regionMatches(len, prefix, true);
	}

	/**
	* Tells if the character sequence starts with the indicated character.
	*/
	public boolean regionMatches(int regionStart, ICharSequence substr, int substrStart, int substrEnd, boolean ignoreCase) {
		return StringRegionMatchesUtil.regionMatches(this, regionStart, length(), substr, substrStart, substrEnd, ignoreCase);
	}

	public final boolean regionMatches(int regionStart, ICharSequence substr, boolean ignoreCase) {
		return regionMatches(regionStart, substr, 0, substr.length(), ignoreCase);
	}
	/**
	* Tells if the character sequence starts with the indicated character.
	*/
	public boolean regionMatches(int regionStart, CharSequence substr, int substrStart, int substrEnd, boolean ignoreCase) {
		return StringRegionMatchesUtil.regionMatches(this, regionStart, length(), substr, substrStart, substrEnd, ignoreCase);
	}

	public final boolean regionMatches(int regionStart, CharSequence substr, boolean ignoreCase) {
		return regionMatches(regionStart, substr, 0, substr.length(), ignoreCase);
	}

	/**
	* {@inheritDoc}
	*/
	public boolean startsWith(char ch) {
		return getFirstChar() == ch;
	}
	/**
	* {@inheritDoc}
	*/
	public boolean endsWith(char ch) {
		return getLastChar() == ch;
	}

	/**
	* {@inheritDoc}
	*/
	public char[] toCharArray() {
		char[] chars = new char[length()];
		getChars(chars, 0);
		return chars;
	}
	/**
	* {@inheritDoc}
	*/
	public java.lang.String toString() {return new java.lang.String(toCharArray()); }
	/**
	* {@inheritDoc}
	*/
	public String ToString() {return this; }

	/**
	* Returns the left sub-string of the given length.<br>
	*/
	public String left(int len) {
		return substring(0, len);
	}
	/**
	* Returns the right sub-string of the given length.<br>
	*/
	public String right(int len) {
		return substring(length() - len, length());
	}

	/**
	* Gets the supplied string visitor to perform a string-match with this <code>String</code>
	* @param visitor the string visitor
	*/
	public boolean match(final IStringVisitor visitor) {
		return visitor.match(this);
	}
	/**
	* Gets the supplied visitor to perform string-transform for this <code>String</code>.
	* @param visitor the string visitor
	*/
	public String transform(IStringVisitor visitor) {
		return visitor.transform(this);
	}
	/**
	* Gets the supplied string visitor to perform a string-find within this <code>String</code>.<br>
	* @param visitor the string visitor
	* @return <code>-1</code> in case of not found; <code>((&lt;find-start&gt; & 0xFFFFFFFFL) << 32) | ((&lt;find-end&gt; & 0xFFFFFFFFL), otherwise
	*/
	public long find(final IStringVisitor visitor, final int start) {
		return visitor.find(this, start);
	}
	/**
	* Gets the supplied string visitor to perform a string-compare with this <code>String</code>.
	* @param visitor the string visitor
	*/
	public byte compare(final IStringVisitor visitor) {
		return visitor.compare(this);
	}
	/**
	* Gets the supplied string visitor to perform a string-equality check with this <code>String</code>.
	* @param visitor the string visitor
	*/
	public boolean equals(final IStringVisitor visitor) {
		return visitor.equals(this);
	}
	/**
	* Returns the length, as per the supplied string visitor.<br>
	* @param visitor the string visitor
	*/
	public int length(final IStringVisitor visitor) {
		return visitor.length(this);
	}
	/**
	* Gets the supplied string visitor to compute the hash code of this <code>String</code>.
	* @param visitor the string visitor
	*/
	public int hashCode(final IStringVisitor visitor) {
		return visitor.hashCode(this);
	}

	/**
	* {@inheritDoc}
	*/
	public /*final */byte getValueType() {return STRING; }

	/**
	* Tells if this string is only comprised of ASCII characters.<br>
	* @return {@link #yes yes} if the String is known to be for sure an ASCII string; {@link #no no} is known to not be, for sure, an ASCII string; {@link #maybe maybe}, otherwise.
	*/
	public byte isAscii() {return maybe; }
	/**
	* Tells if this string is only comprised of latin characters.<br>
	* @return {@link #yes yes} if the String is known to be for sure a latin string; {@link #no no} is known to not be, for sure, a latin string; {@link #maybe maybe}, otherwise.
	*/
	public byte isLatin() {return isAscii(); }

	/**
	* Copies the characters that make up this string into the supplied <code>byte</code> array, as per the known natural single-byte encoding scheme for the string.<br>
	* If the characters of this string are all known to belong to the character-set of one of the single-byte encodings, the characters must be copied as per that single-byte encoding, else the characters must encoded as per ISO-8859-1 encoding scheme.<br>
	* @param core.io.encoding.EncodingException if at least one character of the string cannot be copied as per a single-byte encoding scheme.<br>
	*/
	public void getChars8(final byte[] dest, int destOff) {
		__getChars8(0, length(), dest, destOff);
	}
	/**
	* Copies the specified characters of this string into the specified <code>byte</code> array, as per the known natural single-byte encoding scheme for the string.<br>
	* If the specified characters of this string are all known to belong to the character-set of one of the single-byte encodings, the characters must be copied as per that single-byte encoding, else the characters must encoded as per ISO-8859-1 encoding scheme.<br>
	* @param core.io.encoding.EncodingException if at least one of the specified characters of the string cannot be copied as per a single-byte encoding scheme.<br>
	*/
	public void getChars8(final int start, final int end, final byte[] dest, final int destOff) {
		__getChars8(start, end, dest, destOff);
	}

	private final void __getChars8(int start, int end, final byte[] dest, int destOff) {
		for (;start<end;start++)
		{
			char ch = getChar(start);
			if (ch > '\u00FF') {
				throw new core.io.encoding.EncodingException(
				"String::__getChars8-1: cannot copied the string as per a single-byte encoding scheme"
				);
			}
			dest[destOff++] = (byte)ch;
		}
	}
	/**
	* {@inheritDoc}
	*/
	public int getCharacters(final char[] dest, final int destOff) {
		getChars(dest, destOff);
		return length();
	}
	/**
	* {@inheritDoc}
	*/
	public int getCharacters8(final byte[] dest, final int destOff) {
		getChars8(dest, destOff);
		return length();
	}
	/**
	* Tells if the length of this <code>String</code> is <b>1</b>.<br>
	*/
	public boolean isSingleCharString() {return length() == 1; } //since 2018-05-05

	/**
	* {@inheritDoc}
	* @return <code>true</code>
	*/
	public final boolean isString() {return true; }
	/**
	* {@inheritDoc}
	* @return <code>this</code>
	*/
	public final String asString() {return this; }
	
	/**
	* Tells if this <code>String</code> is an instance of {@link IXMLString IXMLString}.<br>
	*/
	public boolean isXMLString() {return false; }
	/**
	* @throws ClassCastException if this <code>String</code> is not an instance of {@link IXMLString IXMLString}.<br>
	*/
	protected/*public*/ xml.IXMLString asXMLString() {return (xml.IXMLString)this; } //NOTE: made protected (changed from package private) for the method to be inherited by class XMLString which is not in package string
	/**
	* Tells if this <code>String</code> is an instance of {@link core.io.FilePath FilePath}.<br>
	*/
	public boolean isFilePath() {return false; }
	/**
	* @throws ClassCastException if this <code>String</code> is not an instance of {@link core.io.FilePath FilePath}.<br>
	*/
	protected/*public*/ core.io.FilePath asFilePath() {return (core.io.FilePath)this; } //NOTE: made protected (changed from package private) for the method to be inherited by class FilePath which is not in package string

	/**
	* Creates a new {@link String String}, given the data.
	* @param trustworthyCharArray if the supplied <code>char</code> array can be trusted as content-immutable, meaning the array can be safely referenced with no risk that its content gets modified.
	*/
	public static String valueOf(final char[] data, boolean trustworthyCharArray) {
		if (!trustworthyCharArray) {
			char[] chars = new char[data.length];
			System.arraycopy(data, 0, chars, 0, data.length);
			return new FullSizeString(chars);
		}
		return new FullSizeString(data);
	}
	/**
	* Creates a new {@link String String}, given the data.
	* @param trustworthyCharArray if the supplied <code>char</code> array can be trusted as content-immutable, meaning the array can be safely referenced with no risk that its content gets modified.
	*/
	public static String valueOf(final char[] data, int offset, int length, boolean trustworthyCharArray) {
		if (!trustworthyCharArray) {
			char[] chars = new char[data.length];
			System.arraycopy(data, offset, chars, 0, length);
			return new FullSizeString(chars);
		}
		else if (offset == 0) {
			return new LSubString(length, data);
		}
		return new SubString(length, offset, data);
	}
	
	/**
	* Tells if this <code>String</code> is an instance of {@link Char Char} class.<br>
	*/
	public boolean isChar() {return false; }
	/**
	* @throws ClassCastException if this <code>String/code> is not an instance of {@link Char Char} class.<br>
	*/
	public Char asChar() {return (Char)this; }
	
	/**
	* Tells if this <code>String</code> is an instance of {@link SupplementaryCodePoint SupplementaryCodePoint} class.<br>
	*/
	public boolean isSupplementaryCodePoint() {return false; }
	/**
	* @throws ClassCastException if this <code>String/code> is not an instance of {@link SupplementaryCodePoint SupplementaryCodePoint} class.<br>
	*/
	public SupplementaryCodePoint asSupplementaryCodePoint() {return (SupplementaryCodePoint)this; }

	/**
	* Tells if this <code>String</code> is an instance of {@link MultiPartString MultiPartString} class.<br>
	*/
	public boolean isMultiPartString() {return false; } //NOTE: restored public modifier on 2017-Apr-19
	/**
	* @throws ClassCastException if this <code>String/code> is not an instance of {@link MultiPartString MultiPartString} class.<br>
	*/
	/*public */MultiPartString<?> asMultiPartString() {return (MultiPartString)this; } //NOTE: return type is made parametrized since 2017-12-13

	/**
	* Tells if this <code>String</code> is an instance of {@link Code Code} class.<br>
	*/
	public boolean isCode() {return false; } //NOTE: restored public modifier on 2017-Apr-19
	/**
	* @throws ClassCastException if this <code>String/code> is not an instance of {@link Code Code} class.<br>
	*/
	/*public */Code asCode() {return (Code)this; }


	/**
	* Tells if this <code>String</code> is an instance of {@link CString CString} class.<br>
	*/
	public boolean isCString() {return false; } //NOTE: restored public modifier on 2017-Apr-19
	/**
	* @throws ClassCastException if this <code>String/code> is not an instance of {@link CString CString} class.<br>
	*/
	/*public */CString asCString() {return (CString)this; }
	/**
	* Tells if this <code>String</code> is an instance of {@link CEnumImpl CEnumImpl} class.<br>
	*/
	/*public */boolean isCEnumImpl() {return false; } //since 2017-08-02
	/**
	* @throws ClassCastException if this <code>String/code> is not an instance of {@link CString CString} class.<br>
	*/
	/*public */CEnumImpl asCEnumImpl() {return (CEnumImpl)this; } //since 2017-08-02
	/**
	* Tells if this <code>String</code> is an instance of {@link CEnumImpl2 CEnumImpl2} class.<br>
	*/
	/*public */boolean isCEnumImpl2() {return false; } //since 2017-08-02
	/**
	* @throws ClassCastException if this <code>String/code> is not an instance of {@link CString CString} class.<br>
	*/
	/*public */CEnumImpl2 asCEnumImpl2() {return (CEnumImpl2)this; } //since 2017-08-02
	/**
	* Tells if this <code>String</code> is an instance of {@link CEnumImpl3 CEnumImpl3} class.<br>
	*/
	/*public */boolean isCEnumImpl3() {return false; } //since 2017-08-02
	/**
	* @throws ClassCastException if this <code>String/code> is not an instance of {@link CString CString} class.<br>
	*/
	/*public */CEnumImpl3 asCEnumImpl3() {return (CEnumImpl3)this; } //since 2017-08-02

	/**
	* Tells if this <code>String</code> is an instance of {@link AsciiFullSizeString AsciiFullSizeString} class.<br>
	*/
	/*public */boolean isAsciiFullSizeString() {return false; }
	/**
	* @throws ClassCastException if this <code>String/code> is not an instance of {@link AsciiFullSizeString AsciiFullSizeString} class.<br>
	*/
	/*public */AsciiFullSizeString asAsciiFullSizeString() {return (AsciiFullSizeString)this; }
	/**
	* @throws ClassCastException if this <code>String/code> is not an instance of {@link FullSizeString FullSizeString} class.<br>
	*/
	/*public */FullSizeString asFullSizeString() {return (FullSizeString)this; } //since 2017-07-11

	/**
	* Tells if this <code>String</code> is an instance of {@link TimeUnit TimeUnit} class.<br>
	*/
	public boolean isTimeUnit() {return false; }
	/**
	* @throws ClassCastException if this <code>String/code> is not an instance of {@link time.TimeUnit time.TimeUnit} class.<br>
	*/
	public time.TimeUnit asTimeUnit() {return (time.TimeUnit)this; }


	/**
	* Tells if this <code>String</code> is an instance of {@link NSPrefix NSPrefix} class.<br>
	*/
	public boolean isNSPrefix() {return false; } //NOTE: restored public modifier on 2017-Apr-19
	/**
	* @throws ClassCastException if this <code>String/code> is not an instance of {@link NSPrefix NSPrefix} class.<br>
	*/
	protected/*public*/ xml.NSPrefix asNSPrefix() {return (xml.NSPrefix)this; } //NOTE: made protected (changed from package private) for the method to be inherited by class NSPrefix which is not in package string

	/**
	* Tells if this <code>String</code> is an instance of {@link core.text.StringPattern StringPattern} class.<br>
	*/
	public boolean isStringPattern() {return false; }
	/**
	* @throws ClassCastException if this <code>String/code> is not an instance of {@link core.text.StringPattern StringPattern} class.<br>
	*/
	public core.text.StringPattern asStringPattern() {return (core.text.StringPattern)this; }

	/**
	* Tells if this <code>String</code> is an instance of {@link core.net.URI URI} class.<br>
	*/
	public boolean isURI() {return false; }
	/**
	* @throws ClassCastException if this <code>String/code> is not an instance of {@link core.net.URI URI} class.<br>
	*/
	public core.net.URI asURI() {return (core.net.URI)this; }
	
	/**
	* Tells if this <code>String</code> is an instance of {@link Enum Enum} class.<br>
	*/
	public boolean isEnum() {return false; }
	/**
	* @throws ClassCastException if this <code>String/code> is not an instance of {@link Enum Enum} class.<br>
	*/
	public Enum asEnum() {return (Enum)this; }
	
	/**
	* Tells if this <code>String</code> is an instance of {@link text.TextBlock TextBlock} class.<br>
	*/
	public boolean isTextBlock() {
		return false;
	}
	/**
	* @throws ClassCastException if this <code>String/code> is not an instance of {@link text.TextBlock TextBlock} class.<br>
	*/
	public text.TextBlock asTextBlock() { //NOTE: TextBlocks changed to TextBlock on 2018-01-14
		return (text.TextBlock)this;
	}

	/**
	* {@inheritDoc}
	* @return {@link core.stylesheet.css.ICSSValueTypes#STRING} or {@link core.stylesheet.css.ICSSValueTypes#URI}
	*/
	public /*final */byte getCssValueType() {return core.stylesheet.css.ICSSValueTypes.STRING; }

	/**
	* {@inheritDoc}
	* @return '"' + this.toString() + '"'
	*/
	public String toCssText() {
		if (isLatin() == yes) {
			byte[] ret = new byte[length() + 2];
			ret[0] = '"';
			getChars8(ret, 1);
			ret[ret.length - 1] = '"';
			return CString.valueOf(ret, true, isAscii() == yes);
		}
		char[] ret = new char[length() + 2];
		ret[0] = '"';
		getChars(ret, 1);
		ret[ret.length - 1] = '"';
		return String.valueOf(ret, true);
	}
	/**
	* Copies the css textual representation of this <code>CSSValue</code> into the supplied array, starting copying at index <code>offset</code>.
	*/
	public int getCssText(final char[] array, int offset) {
		array[offset++] = '"';
		getChars(array, offset);
		offset += length();
		array[offset] = '"';
		return length() + 2;
	}
	/**
	* {@inheritDoc}
	*/
	public void getCssText(final CharBuffer buf) {
		buf.append('"').append(this).appendChar('"');
	}
	/**
	* {@inheritDoc}
	* @return <code>false</code>
	*/
	public final boolean isCSSValue2() {return false; }
	/**
	* {@inheritDoc}
	* @throws ClassCastException <code>always</code>
	*/
	public final core.stylesheet.css.ICSSValue2 asCSSValue2() {
		throw new ClassCastException(
		"String::asCSSValue2-1: not an instance of core.stylesheet.css.ICSSValue2"
		);
	}

	/**
	* Tells if this <code>String</code> is an instance of {@link core.complex.unit.UnitSymbol UnitSymbol} class.<br>
	*/
	public boolean isUnitSymbol() {return false; } //NOTE: restored public modifier on 2017-Apr-19
	/**
	* @throws ClassCastException if this <code>String</code> is an instance of {@link core.complex.unit.UnitSymbol UnitSymbol} class.<br>
	*/
	protected/*public*/ core.complex.unit.UnitSymbol asUnitSymbol() { //NOTE: made protected (changed from package private) for the method to be inherited by class UnitSymbol which is not in package string
		return (core.complex.unit.UnitSymbol)this;
	}
	
	/**
	* Tells if this <code>String</code> is an instance of {@link core.net.dns.DNSName DNSName} class.<br>
	*/
	public boolean isDNSName() {return false; } 
	/**
	* @throws ClassCastException if this <code>String</code> is an instance of {@link core.net.dns.DNSName DNSName} class.<br>
	*/
	protected/*public*/ core.net.dns.DNSName asDNSName() { //NOTE: made protected (changed from package private) for the method to be inherited by class DNSName which is not in package string
		return (core.net.dns.DNSName)this;
	}
	
	/**
	* Tells if this <code>String</code> is an instance of {@link core.stylesheet.css.CSSClass CSSClass} class.<br>
	*/
	public boolean isCSSClass() {return false; } //NOTE: restored public modifier on 2017-Apr-19
	/**
	* @throws ClassCastException if this <code>String</code> is an instance of {@link core.stylesheet.css.CSSClass CSSClass} class.<br>
	*/
	protected/*public*/ core.stylesheet.css.CSSClass asCSSClass() { //NOTE: made protected (changed from package private) for the method to be inherited by class CSSClass which is not in package string
		return (core.stylesheet.css.CSSClass)this;
	}
	/**
	* Tells if this <code>String</code> is an instance of {@link core.stylesheet.css.CSSStyleText CSSStyleText} class.<br>
	*/
	public boolean isCSSStyleText() {return false; } //NOTE: restored public modifier on 2017-Apr-19
	/**
	* @throws ClassCastException if this <code>String</code> is an instance of {@link core.stylesheet.css.CSSStyleText CSSStyleText} class.<br>
	*/
	protected/*public*/ core.stylesheet.css.CSSStyleText asCSSStyleText() { //NOTE: made protected (changed from package private) for the method to be inherited by class CSSStyleText which is not in package string
		return (core.stylesheet.css.CSSStyleText)this;
	}
	
	/**
	* Tells if this <code>String</code> is an instance of {@link scripting.ScriptText ScriptText} class.<br>
	*/
	public boolean isScriptText() {return false; } //NOTE: restored public modifier on 2017-Apr-19
	/**
	* @throws ClassCastException if this <code>String</code> is an instance of {@link scripting.ScriptText ScriptText} class.<br>
	*/
	protected/*public*/ scripting.ScriptText asScriptText() { //NOTE: made protected (changed from package private) for the method to be inherited by class ScriptText which is not in package string
		return (scripting.ScriptText)this;
	}
	
	/**
	* Tells if this <code>String</code> is an instance of {@link core.io.bdb.XBinaryDataHeader.AttributeName XAttributeName} class.<br>
	*/
	public boolean isXAttributeName() {return false; }
	
	/**
	* Tells if this <code>String</code> is an instance of {@link core.id.GUID GUID} class.<br>
	*/
	public boolean isGUID() {return false; }
	/**
	* @throws ClassCastException if this <code>String</code> is not an instance of {@link core.id.GUID GUID} class.<br>
	*/
	public core.id.GUID asGUID() {return (core.id.GUID)this; }
	
	/**
	* Tells if this <code>String</code> is an instance of {@link NumericString NumericString} class.<br>
	*/
	public boolean isNumericString() {return false; }
	/**
	* @throws ClassCastException if this <code>String</code> is not an instance of {@link NumericString NumericString} class.<br>
	*/
	public NumericString asNumericString() {return (NumericString)this; }
	
	/**
	* Tells if this <code>String</code> is an instance of {@link xml.QName QName} class.<br>
	*/
	public boolean isQName() {return false; } //since 2017-07-24
	/**
	* @throws ClassCastException if this <code>String</code> is an instance of {@link xml.QName QName} class.<br>
	*/
	public xml.QName asQName() { //since 2017-07-24
		return (xml.QName)this;
	}
	
	/**
	* Tells if this <code>String</code> is an instance of {@link mime.MimeType MimeType} class.<br>
	*/
	public boolean isMimeType() { //since 2018-04-17
		return false; 
	}
	/**
	* @throws ClassCastException if this <code>String</code> is not an instance of {@link mime.MimeType MimeType} class.<br>
	*/
	public mime.MimeType asMimeType() { //since 2018-04-17
		return (mime.MimeType)this;
	}
	
	/**
	* Returns the type of the enumeration to which this <code>String</code> belongs.<br>
	* It is worth noting that an enumeration type may just have a number allocated to it.<br>
	* @return empty string if the string is not an enumerated string value element of an enumeration or if the enumeration is anonymous; 
	*
	* @see #getEnumTypeNumber() getEnumTypeNumber()
	*/
	public String getEnumType() {return String.EMPTY; }
	/**
	* Returns the type of the enumeration to which this <code>String</code> belongs.<br>
	* It is worth noting that an enumeration type may additionally have a string name/code allocated to it.<br>
	* @return <code>-1</code> if the string is not an enumerated string value element of an enumeration or if the enumeration is anonymous; 
	*
	* @see string.EnumTypes EnumTypes
	*/
	public int getEnumTypeNumber() {return -1; } //since 2018-06-22
	/**
	* Returns the enumerated value number of this <code>String</code>.<br>
	* @return a negative number if the string is not an enumerated string value element of an enumeration.<br>
	*/
	public int getEnumNumber() {return -1; } //note: new as of 2017-Apr-19
	
	/**
	* Tells if this <code>String</code> is an instance of {@link core.security.ISimplePrivilegeName ISimplePrivilegeName} class.<br>
	*/
	public boolean isSimplePrivilegeName() {return false; }
	/**
	* @throws ClassCastException if this <code>String</code> is not an instance of {@link core.security.ISimplePrivilegeName ISimplePrivilegeName} class.<br>
	*/
	public core.security.ISimplePrivilegeName asSimplePrivilegeName() {return (core.security.ISimplePrivilegeName)this; } //since 2017-05-19
	
	/**
	* Tells if this <code>String</code> is an instance of {@link core.text.regexpr.RegExpr RegExpr} class.<br>
	*/
	public boolean isRegExpr() { //since 2017-07-02 - was in system.j.core's version but was not string.String
		return false;
	}
	/**
	* @throws ClassCastException if this <code>String</code> is not an instance of {@link core.text.regexpr.RegExpr RegExpr} class.<br>
	*/
	public core.text.regexpr.RegExpr asRegExpr() { //since 2017-07-02 - was in system.j.core's version but was not string.String
		return (core.text.regexpr.RegExpr)this;
	}
	
	/**
	* {@inheritDoc}
	*/
	public byte getValueSubType() {
		return text;
	}
	/**
	* {@inheritDoc}
	*/
	public String clone() {
		return this;
	}

	protected static final String __newFullSizeString(final char[] data) {
		return new FullSizeString(data);
	}
	protected static final String __newCFullSizeString(final byte[] data) {
		return new CFullSizeString(data);
	}
	protected static final String __newCFullSizeString(final byte[] data, final boolean forSureAsciiString) { //since 2017-11-29
		return forSureAsciiString ? new AsciiFullSizeString(data) : new CFullSizeString(data);
	}
	protected static final String __newLSubString(final char[] data, final int len) {
		return new LSubString(len, data);
	}
	protected static final String __newCLSubString(final byte[] data, final int len) {
		return new CLSubString(len, data);
	}
	protected static final String __newSubString(final char[] data, final int off, final int len) {
		return new SubString(len, off, data);
	}
	protected static final String __newCSubString(final byte[] data, final int off, final int len) {
		return new CSubString(len, off, data);
	}
	
	/**
	* Gets the shared cached/reference char array which is equal to that supplied separator-indexes.<br>
	* If none of the available cached/reference char arrays has its content equal to that supplied and the container of cached/reference separator-indexes is full, the method returns the passed char array.<br>
	* <br><b>IMPORTANT</b>: any sub-classes of this class using this method must never modified the content of the returned array, any modification would be a breach to the contract set by this method.<br>
	*/
	protected static final char[] get_small_sep_Indexes(final char[] sepIndexes) {
		return Path.get_shared_small_sep_Indexes(sepIndexes);
	}
	/**
	* Gets the shared cached/reference int array which is equal to that supplied separator-indexes.<br>
	* If none of the available cached/reference int arrays has its content equal to that supplied and the container of cached/reference separator-indexes is full, the method returns the passed int array.<br>
	* <br><b>IMPORTANT</b>: any sub-classes of this class using this method must never modified the content of the returned array, any modification would be a breach to the contract set by this method.<br>
	*/
	protected static final int[] get_big_sep_Indexes(final int[] sepIndexes) {
		return Path.get_shared_big_sep_Indexes(sepIndexes);
	}
	
	/**
	* {@inheritDoc}
	*/
	public byte isBMPString() {return maybe; } //since 2017-09-23
	/**
	* {@inheritDoc}
	* @return <code>true</code>
	*/
	public final boolean isUTF16String() {return true; } //since 2017-09-22
	
	/**
	* {@inheritDoc}
	*/
	public int ulength() { //since 2017-09-22
		return UStrUtils.unicharsCount(this, 0, this.length());
	}
	/**
	* {@inheritDoc}
	*/
	public int getUniChar(final int i) { //since 2017-09-22
		return UStrUtils.getUniChar(this, i, this.length());
	}
	/**
	* {@inheritDoc}
	*/
	public int getUniChars(final int[] dest, final int destOff) {
		return UStrUtils.getUniChars(this, 0, this.length(), dest, destOff);
	}
	/**
	* Returns the slice of this string, starting at index position <code>start</code> and ending at index position <code>end</code> (character at index position <code>end</code> is excluded).<br>
	* From functional standpoint, this method does exactly the same as method {@link #substring(int,int)}, but from a memory handling viewpoint the two methods differ.<br>
	* This method almost always makes new copies of arrays for the arrays backing the strings resulting from the slice operation, whereas method {@link #substring(int,int)} always reuses the array of the source strings through references.<br>
	* The creation of new arrays can be controlled by means of system properties if need be.<br>
	* <br><b>NOTE</b>: the implementations may smartly reuse references to backing arrays if the source strings themselves reuse the backing arrays of original strings.<br> 
	*/
	public String slice(final int start, final int end) {return substring(start, end); } //since 2017-11-29
	
	/**
	* Converts this <code>String</code> to <code>int</code>.<br>
	* @throws NumberFormatException if this string is not a valid string value for an <code>int</code>
	*/
	public int toInt() {return number.Int.parseInt(this); } //since 2017-12-06
	/**
	* Converts this <code>String</code> to <code>long</code>.<br>
	* @throws NumberFormatException if this string is not a valid string value for a <code>long</code>
	*/
	public long toLong() {return number.LongInt.parseLong(this); } //since 2017-12-06
	/**
	* Converts this <code>String</code> to <code>single-precision</code> floating point number.<br>
	* @throws NumberFormatException if this string is not a valid string value for a <code>single-precision</code> floating point number
	*/
	public float toSingle() {return number.SFloat.parseFloat(this); } //since 2017-12-06
	/**
	* Converts this <code>String</code> to <code>double-precision</code> floating point number.<br>
	* @throws NumberFormatException if this string is not a valid string value for a <code>double-precision</code> floating point number
	*/
	public double toDouble() {return number.DFloat.parseDouble(this); } //since 2017-12-06
	
	protected static final SmallSepIndexesCache new_SmallSepIndexesCache(final int maxCacheSize, final char btreeWidth) { //since 2017-12-03
		return new SmallSepIndexesCache(maxCacheSize, btreeWidth);
	}
	protected static final SmallSepIndexesCache new_SmallSepIndexesCache(int maxCacheSize) { //since 2017-12-03
		return new SmallSepIndexesCache(maxCacheSize);
	}
	protected static final char[] getSepIndexesFrom(final char[] sepIndexes, final SmallSepIndexesCache cache) {
		return cache.getSeparatorIndexes(sepIndexes);
	}
	
	protected final void checkSubStrLimits(final int start, final int end) { //since 2018-05-22
		if (start == end) return;
		else if (start < 0 || start > end || end > length()) {
			throw new IndexOutOfBoundsException(
			"String::checkSubStrLimits-1: index out of bounds (start-index" + start + ", end-index=" + end + ")"
			);
		}
	}
	protected final void checkIndex(final int index) { //since 2018-05-22
		if (index < 0 || index >= length()) {
			throw new IndexOutOfBoundsException(
			"String::checkSubStrLimits-1: index out of bounds (index" + index + ")"
			);
		}
	}
	
	/**
	* Empty string.
	*/
	public static final String EMPTY = new FullSizeString(new char[0]);

	/**
	* Empty array of strings.
	*/
	public static final String[] EMPTY_ARRAY = new String[0];
	
	/**
	* The single instance of {@link EmptyIterator EmptyIterator} class.<br>
	*/
	public static final EmptyIterator EMPTY_ITERATOR = new EmptyIterator(); //since 2018-04-12
	
	
	/**
	* @author Marc E. KAMGA
	* @version 1.0 
	* @copyright Marc E. KAMGA
	*/
	public static final class EmptyIterator implements core.IIterable<String> { //since 2018-04-12
		
		private EmptyIterator() {}
		
		/**
		* {@inheritDoc}
		* @return <code>false</code>
		*/
		public final boolean next() {return false; }
		/**
		* {@inheritDoc}
		* @return <code>null</code>
		*/
		public final String get() {
			return null;
		}
		/**
		* {@inheritDoc}
		* @return <code>null</code>
		*/
		public final String Get() {
			return null;
		}
		/**
		* {@inheritDoc}
		* @return <code>0</code>
		*/
		public final int size() {
			return 0;
		}
		
		
	}
	
	

}