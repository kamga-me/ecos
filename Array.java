package core;

import static core.IUsualTinyNumbers.*;
import static core.IntegerArrayCompUtil.*;
import static core.FloatArrayCompUtil.*;

import static yaml.om.INodeKinds.SEQUENCE;

import string.CharBuffer;
import number.util.SpecialNumbers;
import core.array.util.ValueArrayStringFormats;

/**
* Base class for providing support for arrays.<br>
*
* @author Marc E. KAMGA
* @version 1.0
* @copyright Marc E. KAMGA
*
* @see core.array.util.ValueArrayStringFormats ValueArrayStringFormats
* @see core.collection.util.ValueListStringUtil ValueListStringUtil
*/
public abstract class Array<T extends Thing> extends Thing implements core.IValueTypes, core.data.type.IValueTypesExt, yaml.om.ISequence<T> { //NOTE: implements yaml.om.ISequence since 2018-01-15

	/**
	* Constructor.
	*/
	protected Array() {
		super();
	}
	
	/**
	* Gets the value type for the items of this array.<br>
	*
	* @see core.IValueTypes IValueTypes
	* @see core.data.type.IValueTypesExt IValueTypesExt
	*/
	public byte itemsValueType() { //NOTE: renamed from getValuesType on 2018-01-15
		return ANY_DATA_TYPE;
	}
	/**
	* Returns the value-type of this <code>Array</code>.<br>
	*/
	public byte getValueType() {
		return ARRAY_TYPE;
	}
	/**
	* {@inheritDoc}
	* @return {@link yaml.om.INodeKinds#SEQUENCE SEQUENCE}
	*/
	public final byte getKind() {
		return SEQUENCE;
	}
	/**
	* Tells if the array is an empty array.<br>
	*/
	public abstract boolean isEmpty();
	/**
	* Returns the length of the array.<br>
	*/
	public abstract int length();
	/**
	* {@inheritDoc}
	* @return <code>this.length()</code>
	*/
	@Override
	public final int size() {return length(); } //since 2018-01-15
	
	/**
	* Gets the <code>(i + 1)<sup>th</sup></code> item of the array.<br>
	*/
	public abstract T get(int i);
	
	private final byte itm_cc_err(final int i, final int t) {
		throw new ClassCastException(
		"Array::get" + (t == 4 ? "Int" : t == 5 ? "Long" : t == 7 ? "Double" : t == 6 ? "Float" : t == 1 ? "Byte" : t == 2 ? "Short" : t == 3 ? "Char" : t == 8 ? "Boolean" : "") + "-1: not a " + (t == 4 ? "int" : t == 5 ? "long" : t == 7 ? "double" : t == 6 ? "float" : t == 1 ? "byte" : t == 2 ? "short" : t == 3 ? "char" : t == 8 ? "boolean" : "") + " item (index=" + i + ")"
		);
	}
			
	/**
	* {@inheritDoc}
	*/
	public int getInt(int i) {
		T val = get(i);
		if (val != null) {
			return val.asNumber().intValue();
		}
		return itm_cc_err(i, 4);
	}
	/**
	* {@inheritDoc}
	*/
	public long getLong(int i) {
		T val = get(i);
		if (val != null) {
			return val.asNumber().longValue();
		}
		return itm_cc_err(i, 5);
	}
	/**
	* {@inheritDoc}
	*/
	public short getShort(int i) {
		T val = get(i);
		if (val != null) {
			return val.asNumber().shortValue();
		}
		return itm_cc_err(i, 2);
	}
	/**
	* {@inheritDoc}
	*/
	public byte getByte(int i) {
		T val = get(i);
		if (val != null) {
			return val.asNumber().byteValue();
		}
		return itm_cc_err(i, 1);
	}
	/**
	* {@inheritDoc}
	*/
	public float getFloat(int i) {
		T val = get(i);
		if (val != null) {
			return val.asNumber().floatValue();
		}
		return itm_cc_err(i, 6);
	}
	/**
	* {@inheritDoc}
	*/
	public double getDouble(final int i) {
		T val = get(i);
		if (val != null) {
			return val.asNumber().doubleValue();
		}
		return itm_cc_err(i, 7);
	}
	/**
	* {@inheritDoc}
	*/
	public boolean getBoolean(final int i) {
		T val = get(i);
		if (val != null) {
			return val.asBoolean().booleanValue();
		}
		itm_cc_err(i, 8); return false; //dummy return
	}
	/**
	* {@inheritDoc}
	*/
	public char getChar(final int i) {
		T val = get(i);
		if (val != null) {
			if (val.isString()) {
				string.String s = val.asString();
				if (s.length() == 1) {
					return s.getFirstChar();
				}
			}
		}
		itm_cc_err(i, 3); return 0; //dummy return
	}
	
	/**
	* Gets the array to be trimmed to size.<br>
	*/
	public void trim() {
		
	}
	/**
	* Tells if this array is a resizeable array.<br>
	*/
	public boolean isResizeable() {return false; }
	
	/**
	* Copies the XML representation of the supplied string value, into the supplied character buffer.<br>
	*/
	private static final void __getXMLString(final string.ICharSequence item, final CharBuffer outputBuffer) {
		outputBuffer.ensureCanAddNMoreChars(item.length());
		int index = item.indexOf(' ');
		if (index < 0) {
			outputBuffer.appendChars(item);
			return ;
		}
		int start = 0;
		do 
		{
			outputBuffer.appendChars(item, start, index);
			outputBuffer.appendChars('&', '#', '3', '2', ';'); //space
			start = index + 1;
			index = item.indexOf(' ', start);
			if (index > -1) {
				continue ;
			}
			outputBuffer.appendChars(item, start, item.length());
			return ;
		} while (true);
	}
	/**
	* Copies the XML representation of the supplied string value, into the supplied character buffer.<br>
	* <b>NOTE</b>: if <code>item</code> contains space (' ') characters, all those space characters are escaped.<br>
	*/
	public static final void getXMLString(final string.ICharSequence item, final CharBuffer outputBuffer) {
		__getXMLString(item, outputBuffer);
	}
	/**
	* Copies the XML representation of the supplied string value, into the supplied character buffer.<br>
	* <b>NOTE</b>: if <code>item</code> contains space (' ') characters, all those space characters are escaped.<br>
	*/
	public static final void getXMLString(final string.String item, final CharBuffer outputBuffer) {
		__getXMLString(item, outputBuffer);
	}
	/**
	* Copies the XML representation of the specified value-array, into the supplied character buffer.<br>
	*/
	public static final void getXMLString(final Value[] array, final int arrayLen, final CharBuffer outputBuffer) {
		if (arrayLen == 0) return;
		outputBuffer.ensureCanAddNMoreChars((arrayLen << 3) + (arrayLen << 1));
		getXMLString(array[0], outputBuffer);
		for (int i=1;i<arrayLen;i++)
		{
			outputBuffer.appendChar(' ');
			getXMLString(array[i], outputBuffer);
		}
	}
	/**
	* Copies into the supplied character buffer the XML string representation of the array item whose itemue, as a {@core.Value Value}, is supplied.<br>
	* <b>NOTE</b>: if <code>item</code> is an instance of {@link string.String String} and contains space (' ') characters, all those space characters are escaped.<br>
	*/
	public static final void getXMLString(final core.Value item, final CharBuffer outputBuffer) {
		if (item.isString()) {
			getXMLString(item.asString(), outputBuffer);
		}
		else if (item.isNumber()) {
			number.Number num = item.asNumber();
			if (num.isDecimalNumber()) {
				number.DecimalNumber dec = num.asDecimalNumber();
				if (dec.isInfinity()) {
					outputBuffer.appendChars(SpecialNumbers.get_ShortLiteral(dec.isNegative() ? SpecialNumbers.NEGATIVE_INFINITY : SpecialNumbers.POSITIVE_INFINITY));
				}
				else if (dec.isNaN()) {
					outputBuffer.appendChars(SpecialNumbers.get_ShortLiteral(SpecialNumbers.NAN));
				}
				return ;
			}
			outputBuffer.appendValue(item);
		}
		else if (item.isDuration()) {
			item.asDuration().getCharacters(true/*xmlFmt*/, outputBuffer);
		}
		else {
			outputBuffer.appendValue(item);
		}
	}
	/**
	* Tells if the value-type whose number is supplied, is or is compatible with into a primitive floating point number value type.<br>
	*/
	protected static final boolean isPrimitiveFloatingPoint(final byte itemsValueType) { //since 2018-06-03
		switch(itemsValueType)
		{
		case IValueTypes.DFLOAT:
		case IValueTypes.SFLOAT:
		case IValueTypes.INT: 
		case IValueTypes.TINYINT: 
		case IValueTypes.SHORTINT: 
		case IValueTypes.UBYTE: 
		case IValueTypes.USHORT: 
		case IValueTypes.UINT: 
			return true;
		}
		return false;
	}
	/**
	* Tells if the value-type whose number is supplied, is or is compatible with into a primitive integer value type.<br>
	*/
	protected static final boolean isPrimitiveInteger(final byte itemsValueType) { //since 2018-06-03
		switch(itemsValueType)
		{
		case IValueTypes.INT: 
		case IValueTypes.LONGINT:
		case IValueTypes.TINYINT: 
		case IValueTypes.SHORTINT: 
		case IValueTypes.UBYTE: 
		case IValueTypes.USHORT: 
		case IValueTypes.UINT: 
			return true;
		}
		return false;
	}
	
	/**
	* Copies the XML representation of the specified value-array, into the supplied character buffer.<br>
	*/
	public static final void getXMLString(final ValueArray<?> array, final CharBuffer outputBuffer) {
		if (array.isEmpty()) return;
		int arrayLen = array.length();
		outputBuffer.ensureCanAddNMoreChars((arrayLen << 3) + (arrayLen << 1));
		getXMLString(array.get(0), outputBuffer);
		for (int i=1;i<arrayLen;i++)
		{
			outputBuffer.appendChar(' ');
			getXMLString(array.get(i), outputBuffer);
		}
	}
	
	/**
	* {@inheritDoc}
	* @return <code>true</code>
	*/
	public final boolean isArray() {return true; }
	/**
	* {@inheritDoc}
	* @return <code>this</code>
	*/
	public final Array<T> asArray() {return this; }
	
	/**
	* Tells if this array is an instance of {@link ValueArray ValueArray} class.
	*/
	public boolean isValueArray() {return false; }
	/**
	* @throws ClassCastException if this array is not an instance of {@link ValueArray ValueArray} class.
	*/
	public ValueArray<?> asValueArray() {return (ValueArray)this; }
	
	/**
	* Abstract class for providing support for arrays of items of kind {@lnk core.Value Value}.<br>
	* 
	* @author Marc E. KAMGA
	* @version 1.0
	* @copyright Marc E. KAMGA
	*/
	public static abstract class ValueArray<T extends Value> extends Array<T> {
		
		/**
		* Constructor.<br>
		*/
		protected ValueArray() {
			super();
		}
		
		/**
		* {@inheritDoc}
		*/
		public byte itemsValueType() {return IValueTypes.ANY_VALUE; } //BUG-FIX - 2018-04-14 - was missing
		
		/**
		* {@inheritDoc}
		* @return <code>true</code>
		*/
		public final boolean isValueArray() {return true; }
		/**
		* {@inheritDoc}
		* @return <code>this</code>
		*/
		public final ValueArray<T> asValueArray() {return this; }
		
		/**
		* Copies the string representation of this <code>PrimitiveArray</code> into the supplied character buffer.<br>
		*/
		public void getString(final byte fmt, final CharBuffer outputBuffer) {
			if (fmt == ValueArrayStringFormats.XML_FORMAT) {
				getXMLString(outputBuffer);
				return ;
			}
			if (isEmpty()) return ;
			outputBuffer.appendValue(get(0));
			final int len = length();
			if (len == 1) return ;
			char separator;
			try 
			{
				separator = ValueArrayStringFormats.get_SeparatorChar(fmt);
			}
			catch(IndexOutOfBoundsException iobe)
			{
				throw new IllegalArgumentException(iobe.getMessage() + core.IOperatingSystemConstants.LINE_TERMINATOR + 
				"Array::ValueArray::getString-1: invalid/unknown number for a value-array format (" + fmt + ")"
				, iobe
				);
			}
			for (int i=1;i<len;i++)
			{
				outputBuffer.append(separator).appendValue(get(i));
			}
		}
		
		/**
		* {@inheritDoc}
		*/
		public void getXMLString(final CharBuffer outputBuffer) {
			getXMLString(this, outputBuffer);
		}
		
		/**
		* Returns a string representation of this <code>ValueArray</code>, given the value-array format.<br>
		*/
		public java.lang.String toString(final byte fmt) {
			CharBuffer buff = new CharBuffer(size() * 8);
			getString(fmt, buff);
			return buff.toString();
		}
		/**
		* Returns a string representation of this <code>ValueArray</code>, that is suitable for debugging.<br>
		*/
		public java.lang.String toString() {
			return toString(ValueArrayStringFormats.XML_FORMAT);
		}
		/**
		* Returns the XML representation of this <code>ValueArray</code>.<br>
		*/
		public string.String ToXMLString() {
			CharBuffer buff = new CharBuffer(size() * 8);
			getXMLString(buff);
			return buff.ToString(true/*createCStrIfPossible*/);
		}
		/**
		* Returns a string representation of this <code>ValueArray</code>, given the value-array format.<br>
		*/
		public string.String ToString(final byte fmt) {
			CharBuffer buff = new CharBuffer(size() * 8);
			getString(fmt, buff);
			return buff.ToString(true/*createCStrIfPossible*/);
		}
		/**
		* Returns a string representation of this <code>ValueArray</code>, that is suitable for debugging.<br>
		* @return <code>this.ToXMLString()</code>
		*/
		public final string.String ToString() {
			return ToXMLString();
		}
		/**
		* Compares this <code>ValueArray</code> and that supplied, for equality.<br>
		*/
		public boolean equals(final ValueArray<?> that) {
			if (isPrimitiveInteger(itemsValueType()) && isPrimitiveInteger(that.itemsValueType())) {
				return inegersEquals(this, that);
			}
			else if (isPrimitiveFloatingPoint(itemsValueType()) && isPrimitiveFloatingPoint(that.itemsValueType())) {
				return floatsEquals(this, that);
			}
			final int len = length();
			if (len != that.length()) return false;
			for (int i=0;i<len;i++)
			{
				if (!get(i).equals(that.get(i))) return false;
			}
			return true; 
		}
		/**
		* Compares this <code>ValueArray</code> and that supplied, for order.<br>
		*/
		public byte compare(final ValueArray<?> other) {
			if (isPrimitiveInteger(itemsValueType()) && isPrimitiveInteger(other.itemsValueType())) {
				return inegersCompare(this, other);
			}
			else if (isPrimitiveFloatingPoint(itemsValueType()) && isPrimitiveFloatingPoint(other.itemsValueType())) {
				return floatsCompare(this, other);
			}
			int len1 = length();
			final byte firstHasMoreItems = len1 > other.length() ? ONE : len1 == other.length() ? ZERO : MINUSONE;
			for (int i=0;i<len1;i++)
			{
				byte cmp = get(i).compare(other.get(i));
				if (cmp != ZERO) {
					return cmp;
				}
			}
			return firstHasMoreItems; 
		}
		/**
		* Compares this <code>ValueArray</code> and that supplied, for equality.<br>
		*/
		public boolean equals(Array<?> that) {
			return that.isValueArray() && equals(that.asValueArray());
		}
		/**
		* Compares this <code>ValueArray</code> and that supplied, for equality.<br>
		*/
		public boolean equals(core.Thing that) {
			return that.isArray() && equals(that.asArray());
		}
		/**
		* Compares this <code>ValueArray</code> and that supplied, for equality.<br>
		*/
		public boolean equals(core.Object that) {
			return false;
		}
		/**
		* Compares this <code>ValueArray</code> and that supplied, for order.<br>
		*/
		public byte compare(Array<?> other) {
			return other.isValueArray() ? compare(other.asValueArray()): MINUSONE;
		}
		/**
		* Compares this <code>ValueArray</code> and that supplied, for order.<br>
		*/
		public byte compare(core.Thing other) {
			return other.isArray() ? compare(other.asArray()): other.isValue() ? ONE : MINUSONE;
		}
			
	}
	
	/**
	* Tells if this array is an instance of {@link PrimitiveArray PrimitiveArray} class.<br>
	*/
	public boolean isPrimitiveArray() {return false; }
	/**
	* @throws ClassCastException if this array is not an instance of {@link PrimitiveArray PrimitiveArray} class.
	*/
	public PrimitiveArray<?> asPrimitiveArray() {return (PrimitiveArray)this; }
	
	/**
	* Abstract class for providing support for arrays of primitive value items.<br>
	* 
	* @author Marc E. KAMGA
	* @version 1.0
	* @copyright Marc E. KAMGA
	*/
	public static abstract class PrimitiveArray<T extends Value> extends ValueArray<T> {
		
		/**
		* Constructor.<br>
		*/
		protected PrimitiveArray() {
			super();
		}
		
		/**
		* Tells if this <code>PrimitiveArray</code> is an array of integers.<br>
		*/
		public abstract boolean isIntegers(); //since 2018-01-15
		/**
		* Tells if this <code>PrimitiveArray</code> is an array of floating point numbers.<br>
		*/
		public abstract boolean isFloatingPoints(); //since 2018-01-15
		
		/**
		* {@inheritDoc}
		* @return <code>true</code>
		*/
		public final boolean isPrimitiveArray() {return true; }
		/**
		* {@inheritDoc}
		* @return <code>this</code>
		*/
		public final PrimitiveArray<T> asPrimitiveArray() {return this; }
		
		/**
		* Compares this <code>PrimitiveArray</code> and that supplied, for equality.<br>
		*/
		public boolean equals(final PrimitiveArray<?> other) {
			if (isIntegers() && other.isIntegers()) {
				return inegersEquals(this, other);
			}
			else if (isFloatingPoints() && other.isFloatingPoints()) {
				return floatsEquals(this, other);
			}
			return super.equals(other);
		}
		/**
		* Compares this <code>PrimitiveArray</code> and that supplied, for equality.<br>
		*/
		public boolean equals(final ValueArray<?> other) {
			if (isIntegers() && isPrimitiveInteger(other.itemsValueType())) {
				return inegersEquals(this, other);
			}
			else if (isFloatingPoints() && isPrimitiveFloatingPoint(other.itemsValueType())) {
				return floatsEquals(this, other);
			}
			return super.equals(other);
		}
		
		/**
		* {@inheritDoc}
		*/
		public boolean equals(final Array<?> other) {
			return other.isPrimitiveArray() ? equals(other.asPrimitiveArray()) : other.isValueArray() ? equals(other.asValueArray()) : super.equals(other);
		}
		/**
		* {@inheritDoc}
		*/
		public byte compare(final ValueArray<?> other) {
			if (isIntegers() && isPrimitiveInteger(other.itemsValueType())) {
				return inegersCompare(this, other);
			}
			else if (isFloatingPoints() && isPrimitiveFloatingPoint(other.itemsValueType())) {
				return floatsCompare(this, other);
			}
			return super.compare(other);
		}
		/**
		* Compares this <code>PrimitiveArray</code> and that supplied, for order.<br>
		*/
		public byte compare(final PrimitiveArray<?> other) {
			if (isIntegers() && other.isIntegers()) {
				return inegersCompare(this, other);
			}
			else if (isFloatingPoints() && other.isFloatingPoints()) {
				return floatsCompare(this, other);
			}
			return super.compare(other);
		}
		/**
		* {@inheritDoc}
		*/
		public byte compare(final Array<?> other) {
			return other.isPrimitiveArray() ? compare(other.asPrimitiveArray()) : other.isValueArray() ? compare(other.asValueArray()) : super.compare(other);
		}
		
		/*private */final void __getChars(final int index, final byte itemsValueType, final CharBuffer outputBuffer) {
			switch(itemsValueType)
			{
			case IValueTypes.INT:
			case IValueTypes.TINYINT:
			case IValueTypes.SHORTINT:
				outputBuffer.appendInteger(getInt(index)); return ;
			case IValueTypes.LONGINT:
				outputBuffer.appendInteger(getLong(index)); return ;
			case IValueTypes.DFLOAT:
				outputBuffer.appendDouble(getDouble(index)); return ;
			case IValueTypes.SFLOAT:
				outputBuffer.appendSingle(getFloat(index)); return ;
			case IValueTypes.BOOLEAN:
				outputBuffer.appendBool(getBoolean(index)); return ;
			case IValueTypes.CHAR:
				outputBuffer.appendChar(getChar(index)); return ;
			default:
				//should never get here...
				throw new RuntimeException(
				"Array::PrimitiveArray::__getChars-1: surprisingly not the value type for a primitive value (itemsValueType=" + itemsValueType + ")"
				);
			}
		}
		/**
		* Copies the string representation of this <code>PrimitiveArray</code> into the supplied character buffer.<br>
		*/
		public void getString(final byte fmt, final CharBuffer outputBuffer) {
			if (isEmpty()) return ;
			final byte itemsValueType = itemsValueType();
			__getChars(0, itemsValueType, outputBuffer);
			final int len = length();
			if (len == 1) return ;
			char separator;
			try 
			{
				separator = ValueArrayStringFormats.get_SeparatorChar(fmt);
			}
			catch(IndexOutOfBoundsException iobe)
			{
				throw new IllegalArgumentException(iobe.getMessage() + core.IOperatingSystemConstants.LINE_TERMINATOR + 
				"Array::PrimitiveArray::getString-1: invalid/unknown number for a value-array format (" + fmt + ")"
				, iobe
				);
			}
			for (int i=1;i<len;i++)
			{
				outputBuffer.appendChar(separator);
				__getChars(i, itemsValueType, outputBuffer);
			}
		}
		/**
		* {@inheritDoc}
		*/
		@Override
		public void getXMLString(final CharBuffer outputBuffer) {
			getString(ValueArrayStringFormats.XML_FORMAT, outputBuffer);
		}
	}
	
	/**
	*
	* @author Marc E. KAMGA
	* @version 1.0
	* @copyright Marc E. KAMGA
	*/
	public static abstract class PrimitiveIntegerArray<T extends number.IntegerNumber> extends PrimitiveArray<T> {
		
		protected PrimitiveIntegerArray() {
			super();
		}

		/**
		* {@inheritDoc}
		* @return <code>true</code>
		*/
		public final boolean isIntegers() {return true; }
		/**
		* {@inheritDoc}
		* @return <code>false</code>
		*/
		public final boolean isFloatingPoints() {
			return false;
		}
		
	}
	/**
	*
	* @author Marc E. KAMGA
	* @version 1.0
	* @copyright Marc E. KAMGA
	*/
	public static abstract class FloatingPointArray<T extends number.PrimitiveDecimalNumber> extends PrimitiveArray<T> {
		
		protected FloatingPointArray() {
			super();
		}

		/**
		* {@inheritDoc}
		* @return <code>false</code>
		*/
		public final boolean isIntegers() {return false; }
		/**
		* {@inheritDoc}
		* @return <code>true</code>
		*/
		public final boolean isFloatingPoints() {
			return true;
		}
		
	}
	
	/**
	* Tells if this <code>Array</code> is an instance of {@link expr.sql.schema.TableKey.PartitionColumns PartitionColumns} class.<br>
	*/
	public boolean isPartitionColumns() {return false; }
	/**
	* @throws ClassCastException if this <code>Array</code> is not an instance of {@link expr.sql.schema.TableKey.PartitionColumns PartitionColumns} class.<br>
	*/
	public expr.sql.schema.TableKey.PartitionColumns asPartitionColumns() {return (expr.sql.schema.TableKey.PartitionColumns)this; }

	/**
	* {@inheritDoc}
	* @return <code>false</code>
	*/
	public final boolean isTextBlock() {return false; }
	/**
	* {@inheritDoc}
	* @throws ClassCastException <code>always</code>
	*/
	public final yaml.TextBlock asTextBlock() {
		throw new ClassCastException(
		"Array::asTextBlock-1: not a TextBlock"
		);
	}
	/**
	* Compares this <code>Array</code> and that supplied, for order.<br>
	*/
	public byte compare(final Array<?> other) { //since 2018-01-18
		int len = length();
		final byte firstHasMore = len > other.length() ? ONE : len == other.length() ? ZERO : MINUSONE;
		if (firstHasMore == ONE) {
			len = other.length();
		}
		for (int i=0;i<len;i++)
		{
			byte cmp = get(i).compare(other.get(i));
			if (cmp != ZERO) return cmp;
		}
		return firstHasMore;
	}
	/**
	* Compares this <code>Array</code> and that supplied, for equality.<br>
	*/
	public boolean equals(final Array<?> other) { //since 2018-01-18
		final int len = length();
		if (len != other.length()) return false;
		for (int i=0;i<len;i++)
		{
			if (!get(i).equals(other.get(i))) return false;
		}
		return true;
	}
	/**
	* Compares this <code>Array</code> and that supplied, for equality.<br>
	*/
	public boolean equals(final core.Thing other) {
		return other.isArray() && equals(other.isArray());
	}
	
}