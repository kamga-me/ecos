package core;

import string.ICharSequence;

/**
* Base class for providing support for objects.<br>
*
* @author Marc E. KAMGA
* @version 1.0
* @copyright Marc E. KAMGA
*/
public abstract class Object extends Thing implements INativeObjectTypes, IObjectTypes {

	/**
	* Constructor.
	*/
	protected Object() {
		super();
	}
	
	/**
	* Returns the native object type of this <code></code>.<br>
	*
	* @return {@link #JSON JSON} if this <code>Object</code> represents a JSON object; {@link #XML XML} if this <code>Object</code> represents an XML object; {@link #YAML YAML} if this <code>Object</code> represents a YAML object; {@link #YXML YXML} if this <code>Object</code> represents a YXML object; {@link #ENTITY ENTITY} if this <code>Object</code> represents an ENTITY object;  {@link #XTON XTON} if this <code>Object</code> represents an XTON object;  {@link #MATRIX MATRIX} if this <code>Object</code> represents a MATRIX object; {@link #SJOBJECT SJOBJECT}, otherwise.
	*
	* @see INativeObjectTypes INativeObjectTypes
	*/
	public byte getNativeObjectType() { //since 2018-04-22
		return SJOBJECT;
	}
	
	/**
	* Returns the number of the object-type of this <code>Object</code>.<br>
	*
	* @ee IObjectTypes IObjectTypes
	* @see #STRUCT STRUCT
	* @see #UNIT_TYPE UNIT_TYPE
	* @see #CONTENT_TYPE CONTENT_TYPE
	* @see #NAME_VALUE_PAIR NAME_VALUE_PAIR
	* @see #JSON_OBJECT JSON_OBJECT
	* @see #XML_TEXT_NODE XML_TEXT_NODE
	* @see #YAML_PROPERTY YAML_PROPERTY
	* @see #JSON_PROPERTY JSON_PROPERTY
	* @see #YAML_SEQUENCE YAML_SEQUENCE
	*/
	public byte getObjectType() {
		return UNSPECIFIED_OBJECT_TYPE; 
	}

	/**
	* Gets the value of the designated property using the supplied getter, and returns it as a {@link Thing Thing}.
	*/
	public Thing get(ICharSequence propertyName, IPropertyGetter propGetter) {return propGetter.get(propertyName, this); }
	
	public core.Object getObject(ICharSequence propertyName, IPropertyGetter propGetter) {return propGetter.getObject(propertyName, this); }
	/**
	* Gets the value of the designated property using the supplied getter, and returns it as a {@link Value Value}.
	*/
	public Value getValue(ICharSequence propertyName, IPropertyGetter propGetter) {return propGetter.getValue(propertyName, this); }
	/**
	* Gets the value of the designated property using the supplied getter, and returns it as an {@code int}.
	*@throws ClassCastException if the value is not castable to <code>int</code>
	*/
	public int getInt/*Value*/(ICharSequence propertyName, IPropertyGetter propGetter) {return propGetter.getInt/*Value*/(propertyName, this); }
	/**
	* Gets the value of the designated property using the supplied getter, and returns it as a {@code long}.
	*@throws ClassCastException if the value is not castable to <code>long</code>
	*/
	public long getLong/*Value*/(ICharSequence propertyName, IPropertyGetter propGetter) {return propGetter.getLong/*Value*/(propertyName, this); }
	/**
	* Gets the value of the designated property using the supplied getter, and returns it as a {@code float}.
	*@throws ClassCastException if the value is not castable to <code>float</code>
	*/
	public float getFloat/*Value*/(ICharSequence propertyName, IPropertyGetter propGetter) {return propGetter.getFloat/*Value*/(propertyName, this); }
	/**
	* Gets the value of the designated property using the supplied getter, and returns it as a {@code double}.
	*@throws ClassCastException if the value is not castable to <code>double</code>
	*/
	public double getDouble/*Value*/(ICharSequence propertyName, IPropertyGetter propGetter) {return propGetter.getDouble/*Value*/(propertyName, this); }
	/**
	* Gets the value of the designated property using the supplied getter, and returns it as a {@code boolean}.
	*@throws ClassCastException if the value is not castable to <code>boolean</code>
	*/
	public boolean getBoolean/*Value*/(ICharSequence propertyName, IPropertyGetter propGetter) {return propGetter.getBoolean/*Value*/(propertyName, this); }
	/**
	* Returns the value type of the designated property using the supplied getter.
	*/
	public byte getValueType(ICharSequence propertyName, IPropertyGetter propGetter) {return propGetter.getValueType(propertyName, this); }
	/**
	* Returns an iterator that iterates over the names of the properties of this <code>Object</code>.<br>
	*/
	public IIterable<? extends string.String> propertyNames(IPropertyGetter propGetter) {return propGetter.propertyNames(this); }
	
	/**
	* {@inheritDoc}
	* @return <code>true</code>
	*/
	public final boolean isObject() {return true; }
	/**
	* {@inheritDoc}
	* @return <code>this</code>
	*/
	public final Object asObject() {return this; }
	
	/**
	* Tells if this <code>Object</code> is an instance of {@link xml.Namespace Namespace} class.
	*/
	public boolean isNamespace() {return false; }
	/**
	* @throws ClassCastException if this <code>Object</code> is not an instance of {@link xml.Namespace Namespace} class.
	*/
	public xml.Namespace asNamespace() {return (xml.Namespace)this; }
	
	
	/**
	* Tells if this <code>Object</code> is an instance of {@link core.security.SecurityObject SecurityObject} class.
	*/
	public boolean isSecurityObject() {
		return false;
	}
	/**
	* @throws ClassCastException if this <code>Object</code> is not an instance of {@link core.security.SecurityObject SecurityObject} class.
	*/
	public core.security.SecurityObject asSecurityObject() {
		return (core.security.SecurityObject)this;
	}
	
	/**
	* Copies the textual representation of this <code>Object</code>, as per its native object type and its object type (secondarily), into the supplied character buffer.<br>
	* <b>IMPORTANT</b>: the concrete implementation of this class must override this method, as default implementation always fires <code>java.lang.UnsupportedOperationException</code>
	*/
	public void getText(int tabsIndent, final string.CharBuffer outputBuffer) { //since 2018-04-22
		throw new UnsupportedOperationException(
		getClass().getSimpleName() + "::getText-1: the class has yet to effectively implement this method"
		);
	}
	/**
	* Copies the binary representation of this <code>Object</code>, as per its native object type and its object type (secondarily), into the supplied appendable byte buffer.<br>
	* For objects of {@link #XML XML} native object type, it is XBDB binary data format that must be used in working out the binary representation.<br>
	* For objects of {@link #JSON JSON} native object type, it is JSONB binary data format that must be used in working out the binary representation.<br>
	* For objects of {@link #YAML YAML} or {@link #YXML YXML} native object type, it is YAMLB binary data format that must be used in working out the binary representation.<br>
	* <b>IMPORTANT</b>: the concrete implementation of this class must override this method, as default implementation always fires <code>java.lang.UnsupportedOperationException</code>
	*/
	public void getBinary(final core.io.AppendableByteBuffer outputBuffer) { //since 2018-04-22
		throw new UnsupportedOperationException(
		getClass().getSimpleName() + "::getBinary-1: the class has yet to effectively implement this method"
		);
	}


}