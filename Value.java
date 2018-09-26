package core;

/**
* Base class for providing support for values.<br>
*
* @author Marc E. KAMGA
* @version 1.0
* copyright Marc E. KAMGA
*/
public abstract class Value extends Thing implements IValueTypes, core.collation.ICompareForOrderResults, java.lang.Cloneable {
	
	/**
	* Empty array.
	*/
	public static final Value[] EMPTY_ARRAY = new Value[0];

	/**
	* Constructor.
	*/
	protected Value() {
		super();
	}
	
	/**
	* Gets the value-type of this <code>Value</code>
	*/
	public abstract byte getValueType();
	/**
	* Returns the value-type for compare-to.<br>
	*/
	public byte getCompareToValueType() {
		return getValueType(); 
	}
	
	/**
	* Returns the maximum number of characters that make up the string representation of this <code>Value</code>.<br>
	*/
	public abstract int length();
	/**
	* Copies the characters that make up the string representation of this <code>Value</code> into the supplied <code>char</code> array.<br>
	* @return the number characters copied into the supplied <code>char</code> array
	*/
	public abstract int/*void*/ getCharacters(char[] dest, int destOff); //renamed from getChars as the return type had to be int (to return the actual number of characters copied into the array) given that method length() only a returns a maximum length and getChars with void as return type is already used in/for class string.String
	/**
	* Copies the Latin/Ascii characters that make up the string representation of this <code>Value</code> into the supplied <code>byte</code> array.<br>
	* @return the number characters copied into the supplied <code>char</code> array
	* @throws core.io.encoding.EncodeException if at least one of the characters of this <code>Value</code>'s string representation is not a Latin/Ascii character.<br>
	*/
	public abstract int/*void*/ getCharacters8(byte[] dest, int destOff); //renamed from getChars as the return type had to be int (to return the actual number of characters copied into the array) given that method length() only a returns a maximum length and getChars with void as return type is already used in/for class string.String
	
	/**
	* {@inheritDoc}
	* @return <code>true</code>
	*/
	public final boolean isValue() {return true; }
	/**
	* {@inheritDoc}
	* @return <code>this</code>
	*/
	public final Value asValue() {return this; }
	
	/**
	* Tells if this <code>Value</code> is an instance of {@link Bool Bool}.<br>
	*/
	public boolean isBool() {return false; }
	/**
	* @throws ClassCastException if this <code>Value</code> is not an instance of {@link Bool Bool}.<br>
	*/
	public Bool asBool() {return (Bool)this; }
	
	/**
	* Tells if this <code>Value</code> is an instance of {@link Boolean Boolean}.<br>
	*/
	public boolean isBoolean() {return false; }
	/**
	* @throws ClassCastException if this <code>Value</code> is not an instance of {@link Boolean Boolean}.<br>
	*/
	public Boolean asBoolean() {return (Boolean)this; }
	
	/**
	* Tells if this <code>Value</code> is an instance of {@link core.version.VersionNumber VersionNumber}.<br>
	*/
	public boolean isVersionNumber() {return false; }
	/**
	* @throws ClassCastException if this <code>Value</code> is not an instance of {@link core.version.VersionNumber VersionNumber}.<br>
	*/
	public core.version.VersionNumber asVersionNumber() {return (core.version.VersionNumber)this; }
	
	/**
	* Tells if this <code>Value</code> is an instance of {@link time.Temporal Temporal}.<br>
	*/
	public boolean isTemporal() {return false; }
	/**
	* @throws ClassCastException if this <code>Value</code> is not an instance of {@link time.Temporal Temporal}.<br>
	*/
	public time.Temporal asTemporal() {return (time.Temporal)this; }
	/**
	* Tells if this <code>Value</code> is an instance of {@link time.Instant Instant}.<br>
	*/
	public boolean isInstant() {return false; }
	/**
	* @throws ClassCastException if this <code>Value</code> is not an instance of {@link time.Instant Instant}.<br>
	*/
	public time.Instant asInstant() {return (time.Instant)this; }
	
	/**
	* Tells if this <code>Value</code> is an instance of {@link core.complex.Complex Complex}.<br>
	*/
	public boolean isComplex() {return false; }
	/**
	* @throws ClassCastException if this <code>Value</code> is not an instance of {@link core.complex.Complex Complex}.<br>
	*/
	public core.complex.Complex asComplex() {return (core.complex.Complex)this; }
	
	/**
	* Tells if this <code>Value</code> is an instance of {@link Choice Choice}.<br>
	*/
	public boolean isChoice() {return false; }
	/**
	* @throws ClassCastException if this <code>Value</code> is not an instance of {@link Choice Choice}.<br>
	*/
	@SuppressWarnings("rawtypes")
	public Choice<?> asChoice() {return (Choice)this; }
	/**
	* Tells if this <code>Value</code> is an instance of {@link StrOptions StrOptions}.<br>
	*/
	public boolean isStrOptions() {return false; } //since 2017-07-12
	/**
	* @throws ClassCastException if this <code>Value</code> is not an instance of {@link string.StrOptions StrOptions}.<br>
	*/
	@SuppressWarnings("rawtypes")
	public string.StrOptions<?> asStrOptions() {return (string.StrOptions)this; } //since 2017-07-12
	
	/**
	* Tells if this <code>Value</code> is an instance of {@link string.Path Path}.<br>
	*/
	public boolean isPath() {return false; } //since 2017-07-12
	/**
	* @throws ClassCastException if this <code>Value</code> is not an instance of {@link string.Path Path}.<br>
	*/
	public string.Path asPath() {return (string.Path)this; } //since 2017-07-12
	
	/**
	* Tells if this <code>Value</code> is an instance of {@link core.binary.Binary Binary}.<br>
	*/
	public boolean isBinary() {
		return false;
	}
	/**
	* @throws ClassCastException if this <code>Value</code> is not an instance of {@link core.binary.Binary Binary}.<br>
	*/
	public core.binary.Binary asBinary() {return (core.binary.Binary)this; }
	/**
	* Tells if this <code>Value</code> is an instance of {@link core.id.GUID GUID} class.<br>
	*/
	public boolean isGUID() {return false; }
	/**
	* Tells if this <code>Value</code> is an instance of {@link core.id.ObjectId ObjectId} class.<br>
	*/
	public boolean isObjectId() {return false; }
	
	/**
	* Tells if this <code>Value</code> is an instance of {@link xml.EQName EQName}.<br>
	*/
	public boolean isEQName() {return false; } //since 2017-07-19
	/**
	* @throws ClassCastException if this <code>Value</code> is not an instance of {@link xml.EQName EQName}.<br>
	*/
	public xml.EQName asEQName() {return (xml.EQName)this; } //since 2017-07-19
	
	/**
	* Tells if this <code>Value</code> is an instance of {@link time.Duration Duration} class.<br>
	*/
	public boolean isDuration() {return true; } //since 2017-10-24
	/**
	* @throws ClassCastException if this <code>Value</code> is not an instance of {@link time.Duration Duration} class.<br>
	*/
	public time.Duration asDuration() {return (time.Duration)this; } //since 2017-10-24
	/**
	* Tells if this <code>Value</code> is an instance of {@link time.Duration Duration} class.<br>
	*/
	public boolean isTimePeriod() {return true; } //since 2018-02-16
	/**
	* @throws ClassCastException if this <code>Value</code> is not an instance of {@link time.TimePeriod TimePeriod} class.<br>
	*/
	public time.TimePeriod asTimePeriod() {return (time.TimePeriod)this; } //since 2018-02-16
	
	/**
	* Clones this <code>Value</code> if the latter is not immutable, otherwise returns self.
	*/
	public Value clone() {
		return this;
	}
	/**
	* Compares the two supplied assumed not same value type numbers, for order.
	*/
	protected static final byte compareNotSameValueTypes(int vt1, int vt2) {
		return vt1 < vt2 ? INCOMPARABLE_LT : INCOMPARABLE_GT;
	}
	/**
	* Compares the two supplied assumed not same value type numbers, for order.
	*/
	protected static final byte compareNotSameValueTypes(byte vt1, byte vt2) {
		return vt1 < vt2 ? INCOMPARABLE_LT : INCOMPARABLE_GT;
	}
	
	protected final byte incompareValueTypeToThatOf(final Value other) {
		return compareNotSameValueTypes(this.getCompareToValueType(), other.getCompareToValueType());
	}
	
	/**
	* Compares this <code>Value</code> and that supplied for order.<br>
	*/
	public byte compare(final Value other) {
		if (this == other) return COMPARABLE_EQ;
		return incompareValueTypeToThatOf(other);
	}
	/**
	* Compares this <code>Value</code> and that supplied for order.<br>
	*/
	public byte compare(final Thing other) {
		if (other.isValue()) return compare(other.asValue());
		else if (other.isObject()) return -1;
		throw new ClassCastException(
		"Value::compare-1: incomparable objects (class1=" + this.getClass().getName() + ", class2=" + other.getClass().getName() + ")"
		);
	}
	
	/**
	* Returns the canonical textual representation of this <code>Value</code>, as a {@link String String}.<br>
	*/
	public abstract string.String ToString();
	/**
	* Returns the canonical textual representation of this <code>Value</code>, as a {@code java.lang.String}.<br>
	*/
	public abstract java.lang.String toString();
	
	/**
	* Tells if the (canonical) textual representation of this <code>Value</code> is known to be an ASCII string.
	* @return {@link core.ITrinaryValues#yes yes}, {@link core.ITrinaryValues#no no} or {@link core.ITrinaryValues#maybe maybe}
	*/
	public byte isAscii() {
		return core.ITrinaryValues.yes; //NOTE: set to yes as virtually all the values have ASCII safe string representations - note that class String overrides this to return the appropriate value
	}
	
	/**
	* Gets the number of the value sub-type, if any.<br>
	*
	* @since 2015-May-01
	*
	* @see string.IStringClassTypeNumbers
	* @see time.ITimePeriodTypes
	* @see time.ITimeDurationTypes
	* @see time.IInstantKinds
	* @see core.INumberSubTypes INumberSubTypes
	*/
	public byte getValueSubType() {
		return 0;
	}
	/**
	* Copies the characters that make up the debug key of this <code>Thing</code> into the supplied character buffer.<br>
	* <br><b>NOTE</b>: sub-classes may need to override this method, as default implementation always copies the canonical textual representation of the value.<br>
	*/
	public void getDebugKeyChars(final string.CharBuffer outputBuffer) {
		outputBuffer.appendValue(this);
	}
	
	/**
	* Tells if this <code>Value</code> is an instance of {@link number.LongDecimal LongDecimal} class.<br>
	*/
	public boolean isLongDecimal() {return false; } //since 2017-11-14 - made it available from here because class LongDecimal is the ecosystem class that will suitable for most of the decimal related stuff requiring big precision
	/**
	* @throws ClassCastException if this <code>Value</code> is not an instance of {@link number.LongDecimal LongDecimal} class.<br>
	*/
	public number.LongDecimal asLongDecimal() {return (number.LongDecimal)this; } //since 2017-11-14 - made it available from here because class LongDecimal is the ecosystem class that will suitable for most of the decimal related stuff requiring big precision
	
	/**
	* Tells if this <code>Value</code> is an instance of {@link measurement.Quantity Quantity} class.<br>
	*/
	public boolean isQuantity() {return false; } //since 2017-11-15 - made it available from here because class Quantity is the ecosystem root measurement class
	/**
	* @throws ClassCastException if this <code>Value</code> is not an instance of {@link measurement.Quantity Quantity} class.<br>
	*/
	public measurement.Quantity<?,?> asQuantity() {return (measurement.Quantity)this; } //since 2017-11-15 - made it available from here because class Quantity is the ecosystem root measurement class
	
	/**
	* Tells if this <code>Value</code> is an instance of {@link NullValue NullValue} class.<br>
	*/
	public boolean isNullValue() {return false; }
	/**
	* Tells if this <code>Value</code> represents <code>null</code> value.<br>
	*/
	public boolean isNull() {return isNullValue(); } //since 2017-07-21
	
	/**
	* {@inheritDoc}
	*/
	@Override
	public final byte getGeneralType() { //since 2017-07-21
		return getValueType();
	}
	
	/**
	* Constant for <code>null</code> value.
	*/
	public static final Value NULL = new NullValue();
	
	static class NullValue extends Value {

		/**The class's serial version UID. */
		public static final long serialVersionUID = 0x02092DFB91B6928AL;
	
		/**
		* Constructor.<br>
		*/
		/*protected */NullValue() {
			super();
		}
		
		/**
		* {@inheritDoc}
		*/
		public final int length() {return 4; }
		
		/**
		* {@inheritDoc}
		*/
		public /*final */byte getValueType() {return IValueTypes.NULL_VALUE; }
		/**
		* {@inheritDoc}
		*/
		public java.lang.String toString() {return "null"; }
		/**
		* {@inheritDoc}
		*/
		public string.String ToString() {return string.Constants.__null__; }
		/**
		* {@inheritDoc}
		*/
		public final int/*void*/ getCharacters/*getChars*/(final char[] dest, int destOff) {
			string.Constants.__null__.getChars(dest, destOff);
			return 4;
		}
		/**
		* {@inheritDoc}
		*/
		public final int/*void*/ getCharacters8(final byte[] dest, int destOff) {
			dest[destOff] = 'n'; dest[++destOff] = 'u'; dest[++destOff] = 'l'; dest[++destOff] = 'l'; 
			return 4;
		}
		/**
		* {@inheritDoc}
		* @return <code>true</code>
		*/
		public final boolean isNullValue() {return true; }
		
	}

}