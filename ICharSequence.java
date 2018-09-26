package string;

/**
* Interface that character sequences implement.<br>
*
* @author Marc E. KAMGA
* @version 1.0
* @copyright Marc E. KAMGA
*/
public interface ICharSequence extends CharSequence {
	
	/**
	* Tells if this <code>String</code> has a length of <code>0</code>.<br>
	*/
	public boolean isEmpty();

	/**
	* Gets the <code>(i + 1)<sup>th</sup></code> character.<br>
	* Unlike method {@link #charAt(int) charAt(int)}, this method does not attempt to check if the index is valid as it assumes the passed index is valid.<br>
	*/
	public char getChar(int i);
	/**
	* Copies the characters that make up this character sequence, into the supplied <code>char</code> array.<br>
	*/
	public void getChars(char[] dest, int destOff);
	/**
	* Copies the characters that make up indicated portion of this character sequence, into the supplied <code>char</code> array.<br>
	* @throws IndexOutOfBoundsException if one of the supplied indexes/offsets is out of bounds.<br>
	*/
	public void getChars(int start, int end, char[] dest, int destOff);
	/**
	* Copies the characters that make up indicated portion of this character sequence, into the supplied <code>char</code> array.<br>
	* This method is meant to assume without checking that none of the supplied indexes/offsets is out of bounds
	* @throws IndexOutOfBoundsException Ultimately fired by the syztem if one of the supplied indexes/offsets is out of bounds.<br>
	*/
	public void get_Chars(int start, int end, char[] dest, int destOff);
	
	/**
	* Gets the first character of the character-sequence
	*/
	public char getFirstChar();
	/**
	* Gets the last character of the character-sequence
	*/
	public char getLastChar();
	
	/**
	* Returns the index of the first occurrence of character <code>ch</code>.<br>
	*/
	public int indexOf(char ch);
	/**
	* Returns the index of the first occurrence of character <code>ch</code>, starting from the indicated index position.<br>
	*/
	public int indexOf(char ch, int from);
	
	/**
	* Returns the index of the firs occurrence of character <code>ch</code>.<br>
	*/
	public int lastIndexOf(char ch);
	/**
	* Returns the index of the firs occurrence of character <code>ch</code>, until the indicated last index position.<br>
	*/
	public int lastIndexOf(char ch, int untilLastIndex);
	/**
	* Searches for the first occurrence of any of the supplied characters. 
	*/
	public int indexOfAny(char ch1, char ch2);
	/**
	* Searches for the first occurrence of any of the supplied characters. 
	*/
	public int indexOfAny(char... ch);
	/**
	* Searches for the first occurrence of any of the supplied characters. 
	*/
	public int indexOfAny(char ch1, char ch2, int start);
	/**
	* Searches for the first occurrence of any of the supplied characters. 
	*/
	public int indexOfAny(int start, char... ch);
	
	/**
	* Tells if the character sequence starts with the indicated character.
	*/
	public boolean startsWith(char ch);
	/**
	* Tells if the character sequence ends with the indicated character.
	*/
	public boolean endsWith(char ch);
	
	/**
	* Returns the sub-sequence starting at index <code>start</code> whose last character is at index <code>end - 1</code>
	*/
	public abstract ICharSequence subSequence(int start, int end);
	/**
	* @return <code>subSequence(from, this.length())</code>
	*/
	public abstract ICharSequence subSequence(int from);
	
	/**
	* Converts this character sequence to a (new) <code>char</code> array.<br>
	*/
	public char[] toCharArray();
	/**
	* Tells if the character sequence is known to be comprehending only ASCII characters.<br>
	* @return {@link core.ITrinaryValues#no no} if the character sequence is known to be comprehending non ASCII characters; {@link core.ITrinaryValues#yes yes} if the character sequence is known to be comprehending only ASCII characters; {@link core.ITrinaryValues#maybe maybe}, otherwise.
	*/
	public byte isAscii(); //since 2017-11-01
	/**
	* Tells if the character sequence is known to be comprehending only <code>Latin-1</code> characters.<br>
	* @return {@link core.ITrinaryValues#no no} if the character sequence is known to be comprehending non <code>Latin-1</code> characters; {@link core.ITrinaryValues#yes yes} if the character sequence is known to be comprehending only <code>Latin-1</code> characters; {@link core.ITrinaryValues#maybe maybe}, otherwise.
	*/
	public byte isLatin(); //since 2017-11-01
	
	/**
	* Computes the hash code of this character sequence/string.<br>
	* @return same value as that returned by {@link string.String#hashCode()} for the {@link string.String} for this character sequence.
	*/
	public int hashCode(); //since 2017-11-16
	
}