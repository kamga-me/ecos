package core;

/**
* Base class for providing support things.<br>
*
* @author Marc E. KAMGA
* @version 1.0
* @copyright Marc E. KAMGA
*/
public abstract class Thing implements java.io.Serializable, IEmptyPrimitiveArrays {
	
	/**
	* Empty array.<br>
	*/
	public static final Thing[] EMPTY_ARRAY = new Thing[0];

	/**
	* Constructor.
	*/
	protected Thing() {
		super();
	}

	/**
	* Tells if this <code>Thing</code> is an instance of {@link Value Value} class.
	*/
	public boolean isValue() {
		return false;
	}
	/**
	* @throws ClassCastException if this <code>Thing</code> is not an instance of {@link Value Value} class.
	*/
	public Value asValue() {
		return (Value)this;
	}
	/**
	* Tells if this <code>Thing</code> is an instance of {@link Value Value} class.
	*/
	public boolean isArray() {
		return false;
	}
	/**
	* @throws ClassCastException if this <code>Thing</code> is not an instance of {@link Value Value} class.
	*/
	public Array<?> asArray() {
		return (Array)this;
	}
	/**
	* Tells if this <code>Thing</code> is an instance of {@link core.Object Object} class.
	*/
	public boolean isObject() {
		return false;
	}
	/**
	* @throws ClassCastException if this <code>Thing</code> is not an instance of {@link core.Object Object} class.
	*/
	public core.Object asObject() {
		return (Object)this;
	}
	/**
	* Tells if this <code>Thing</code> is an instance of {@link string.String String} class.
	*/
	public boolean isString() {
		return false;
	}
	/**
	* @throws ClassCastException if this <code>Thing</code> is not an instance of {@link string.String String} class.
	*/
	public string.String asString() {
		return (string.String)this;
	}
	/**
	* Tells if this <code>Thing</code> is an instance of {@link number.Number Number} class.
	*/
	public boolean isNumber() {
		return false;
	}
	/**
	* @throws ClassCastException if this <code>Thing</code> is not an instance of {@link number.Number Number} class.
	*/
	public number.Number asNumber() {
		return (number.Number)this;
	}
	/**
	* Tells if this <code>Thing</code> is an instance of {@link time.Temporal Temporal} class.
	*/
	public boolean isTemporal() {
		return false;
	}
	/**
	* @throws ClassCastException if this <code>Thing</code> is not an instance of {@link time.Temporal Temporal} class.
	*/
	public time.Temporal asTemporal() {
		return (time.Temporal)this;
	}
	/**
	* Tells if this <code>Thing</code> is an instance of {@link expr.ExprItem ExprItem} class.
	*/
	public boolean isExprItem() {
		return false;
	}
	/**
	* @throws ClassCastException if this <code>Thing</code> is not an instance of {@link expr.ExprItem ExprItem} class.
	*/
	public expr.ExprItem asExprItem() {
		return (expr.ExprItem)this;
	}
	
	/**
	* Tells if this <code>Object</code> is an instance of {@link xml.IQName IQName} class.
	*/
	public boolean isIQName() {return false; }
	/**
	* @throws ClassCastException if this <code>Object</code> is not an instance of {@link xml.IQName IQName} class.
	*/
	public xml.IQName asIQName() {return (xml.IQName)this; }
	
	/**
	* Tells if this <code>Thing</code> is an instance of {@link core.data.type.IDataType IDataType} class.
	*/
	public boolean isIDataType() {return false; }
	/**
	* @throws ClassCastException if this <code>Thing</code> is not an instance of {@link core.data.type.IDataType IDataType} class.
	*/
	public core.data.type.IDataType asIDataType() {return (core.data.type.IDataType)this; }
	
	/**
	* Tells if this <code>Thing</code> is an instance of {@link OpaqueThing OpaqueThing} class.
	*/
	public boolean isOpaqueThing() {return true; }
	/**
	* @throws ClassCastException if this <code>Thing</code> is not an instance of {@link OpaqueThing OpaqueThing} class.
	*/
	public OpaqueThing asOpaqueThing() {return (OpaqueThing)this; }
	
	/**
	* Tells if this <code>Thing</code> is an instance of {@link core.Choice Choice} class.
	*/
	public boolean isChoice() {
		return false;
	}
	/**
	* @throws ClassCastException if this <code>Thing</code> is not an instance of {@link core.Choice Choice} class.
	*/
	public core.Choice<?> asChoice() {
		return (core.Choice)this;
	}
	
	/**
	* Tells if this <code>Thing</code> is an instance of {@link asn1.core.ASN1Object ASN1Object} class.
	*/
	public boolean isASN1Object() {
		return false;
	}
	/**
	* @throws ClassCastException if this <code>Thing</code> is not an instance of {@link asn1.core.ASN1Object ASN1Object} class.
	*/
	public asn1.core.ASN1Object asASN1Object() {
		return (asn1.core.ASN1Object)this;
	}
	/**
	* Tells if this <code>Thing</code> is an instance of {@link core.Boolean Boolean} class.
	*/
	public boolean isBoolean() {
		return false;
	}
	/**
	* @throws ClassCastException if this <code>Thing</code> is not an instance of {@link core.Boolean Boolean} class.
	*/
	public core.Boolean asBoolean() {
		return (core.Boolean)this;
	}
	/**
	* Convenient method for casting this <code>Thing</code> to {@link core.Bool Bool}.<br>
	* This method is especially useful/helpful when working with record-sets.<br>
	* @throws ClassCastException if this <code>Thing</code> is not an instance of {@link core.Bool Bool} class.
	*/
	public core.Bool asBool() { //since 2017-10-21
		return (core.Bool)this;
	}
	
	/**
	* Tells if this <code>Thing</code> is an instance of {@link dom.DOMNode DOMNode} class.
	*/
	public boolean isDOMNode() { //since 2017-10-19
		return false;
	}
	/**
	* @throws ClassCastException if this <code>Thing</code> is not an instance of {@link dom.DOMNode DOMNode} class.
	*/
	public dom.DOMNode asDOMNode() { //since 2017-10-19
		return (dom.DOMNode)this;
	}
	
	/**
	* Compares this <code>Thing</code> and that supplied, for order.
	*/
	@SuppressWarnings("unchecked")
	public byte compare(final Thing other) {
		if (this == other) return 0;
		else if (isValue()) {
			if (other.isValue()) {
				return asValue().compare(other.asValue());
			}
			else if (other.isObject() || other.isArray()) {
				return -1;
			}
		}
		else if (isObject() && (other.isValue() || other.isArray())) {
			if (other.isValue()) {
				return 1;
			}
			else if (other.isArray()) {
				return -1;
			}
		}
		else if (isArray() && (other.isValue() || other.isArray())) {
			return 1;
		}
		if (this instanceof Comparable && other instanceof Comparable) {
			int cmp = ((Comparable)this).compareTo((Comparable)other);
			return cmp < 0 ? (byte)-1 : cmp > 0 ? (byte)1 : (byte)0;
		}
		throw new ClassCastException(
		"Thing::compare-1: incomparable objects (class1=" + this.getClass().getName() + ", class2=" + other.getClass().getName() + ")"
		);
	}
	/**
	* Compares this <code>Thing</code> and that supplied, for equality.
	*/
	public boolean equals(final Thing other) { //since 2018-01-18
		if (this == other) return true;
		else if (isValue()) {
			return other.isValue() && asValue().equals(other.asValue());
		}
		else if (isObject()) {
			return other.isObject() && asObject().equals(other.asObject());
		}
		else if (isArray()) {
			return other.isArray() && asArray().equals(other.asArray());
		}
		return false;
	}
	/**
	* Compares this <code>Thing</code> and that supplied, for equality.<br>
	*/
	public boolean equals(final java.lang.Object other) { //since 2018-01-18
		return other instanceof Thing && equals((Thing)other);
	}
	/**
	* Tells if this <code>Thing</code> is the thing is an instance of {@link core.NullValue NullValue}.<br>
	*/
	public boolean isNullValue() {return false; }
	/**
	* Tells if this <code>Thing</code> is the thing that represents null value.<br>
	*/
	public boolean isNull() {return false; } //since 2017-10-21
	
	/**
	* Copies the characters that make up the debug key of this <code>Thing</code> into the supplied character buffer.<br>
	* <br><b>NOTE</b>: sub-classes may/must need to override this method, as default implementation always copies the string representation returned by <code>toString()</code> method.<br>
	*/
	public void getDebugKeyChars(final int tabIndentsIfObject, final boolean startWithLineTerminatorIfObject, final string.CharBuffer outputBuffer) {
		outputBuffer.appendChars(toString());
	}
	/**
	* Copies the characters that JSON representation of this <code>Thing</code> into the supplied character buffer.<br>
	* <b>IMPORTANT</b>: for things that are values, the method must not delimit the copied textual representation by quotes. This design decision was/is thought through and purposely made.<br>
	* <br><b>NOTE</b>: sub-classes must override this method, as default implementation always copies the string representation returned by <code>toString()</code> method.<br>
	*/
	public void getJSONChars(final int tabIndentsIfObject, final boolean startWithLineTerminatorIfObject, final string.CharBuffer outputBuffer) {
		outputBuffer.appendChars(toString());
	}
	/**
	* Gets the number of the general type of this <code>Thing</code>.<br>
	* @return the number of the value type of the <code>Thing</code> in case it is an instance of {@link core.Value Value}; the number of native object type of the <code>Thing</code> in case it is an object; 
	*/
	public byte getGeneralType() { //since 2017-10-21
		return 0;
	}

}