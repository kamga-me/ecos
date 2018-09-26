package core;

/**
* Interface with integer number constants declarations for the <code>system.j</code>'s value types.<br>
* The interface also inheritd all of integer number constants for <code>system.j</code>'s native object types, even if object types are not value types.<br>
* <p>
* The numbers are allocated as follows: br>
* &#9;1) the names of the native object types and those of the core native value types are put into a string list, <br>
* &#9;2) the list is sorted as per names natural order, <br>
* &#9;3) <code>1</code> is added to the index of each in the list to form the data type number (native object type number for a native object data type and value type number for a value data type).<br>
* </p>
* 
* @author Marc E. KAMGA
* @version 1.0
* @copyright Marc E. KAMGA
* 
* @see core.object.definition.IDataType
* @see core.data.type.DataType
* @see Value
* @see INativeObjectTypes
*/
public interface IValueTypes extends INativeObjectTypes {

	/**Constant for signalling <code>null</code> values. */public static final byte NULL_VALUE = -127; //changed from -128 by MKA on 2015-May-30
	
	/**Constant for <code>anyValue</code> value-type. */public static final byte ANY_VALUE = core.data.IValuespaceFlavours.ANYVALUE; //changed from static value 0 to a constant which is equal to 0 by MKA on 2015-May-30; 
	/**
	* Constant for signalling that <code>no</code> value is expected at all - same value that of constant {@link core.data.IValuespaceFlavours#VOID VOID}. 
	*/
	public static final byte NO_VALUE = core.data.IValuespaceFlavours.VOID; //changed again: from -127 to -126 in interface IValuespaceFlavours by MKA on 2015-May-30 //-127; //changed from -1
	
	/**Constant for <code>any</code> data type. */public static final byte ANY_DATA_TYPE = core.data.IValuespaceFlavours.ANY_DATATYPE; //value is -128 in interface IValuespaceFlavours

	/**Constant for <code>binary-data</code> value type. */public static final byte BINARY = 1; 
	/**Constant for <code>boolean</code> value type. */public static final byte BOOLEAN = 2; 
	/**Constant for <code>char</code> value type. */public static final byte CHAR = 3; 
	
	/**Constant for <code>complex</code> value type. */public static final byte COMPLEX = 4; 
	
	/**Constant for <code>date</code> value type. */public static final byte DATE = 5; 
	/**Constant for <code>datetime</code> value type. */public static final byte DATETIME = 6; 
	/**Constant for <code>decimal</code> value type. */public static final byte DECIMAL = 7; 
	/**Constant for <code>dfloat</code> value type. */public static final byte DFLOAT = 8; 
	/**Constant for <code>duration</code> value type. */public static final byte DURATION = 9; 
	///**Constant for <code>business-entity</code> value type. */public static final byte ENTITY = 10; //NOTE: DECLARED IN INTERFACE INativeObjectTypes
	/**Constant for <code>int</code> value type. */public static final byte INT = 11; 
	/**Constant for <code>integer</code> value type. */public static final byte INTEGER = 12; 
	///**Constant for <code>json</code> value type. */public static final byte JSON = 13;  //NOTE: DECLARED IN INTERFACE INativeObjectTypes
	/**Constant for <code>longdouble</code> value type - corresponds to <code>IEEE-quadruple-precision</code> floating point number data type. */
	public static final byte LONGDOUBLE = 14; 
	/**Constant for <code>longint</code> value type. */public static final byte LONGINT = 15; 
	
	///**Constant for <code>matrix</code> value type. */public static final byte MATRIX = 16; //NOTE: DECLARED IN INTERFACE INativeObjectTypes ON 2015-Apr-17 By MKA
	
	///**Constant for <code>object</code> value type. */public static final byte OBJECT = 17;  //NOTE: DECLARED IN INTERFACE INativeObjectTypes;  //NOTE: the constant was renamed (on 28-mar-2014) from OBJECT to avoid conflict with the constant OBJECT constant declared in DataObject class; The name of the data type remains "object".
	/**Constant for <code>point</code> value type. */public static final byte POINT = 18; 
	
	/**Constant for <code>sfloat</code> value type. */public static final byte SFLOAT = 19; 
	/**Constant for <code>shortint</code> value type. */public static final byte SHORTINT = 20; 
	/**Constant for <code>string</code> value type. */public static final byte STRING = 21; 
	/**Constant for <code>time</code> value type. */public static final byte TIME = 22; 
	/**Constant for <code>timeperiod</code> value type. */public static final byte TIMEPERIOD = 23; 
	/**Constant for <code>tinyint</code> value type. */public static final byte TINYINT = 24; 
	
	/**Constant for <code>trinary</code> value type. */public static final byte TRINARY = 25; 
	
	/**Constant for <code>ubyte</code> value type. */public static final byte UBYTE = 26; 
	/**Constant for <code>uint</code> value type. */public static final byte UINT = 27; 
	/**Constant for <code>ulong</code> value type. */public static final byte ULONG = 28; 
	
	/**Constant for <code>unitnumber</code> value type. */public static final byte UNITNUMBER = 29;
	
	/**Constant for <code>ushort</code> value type. */public static final byte USHORT = 30; 
	/**Constant for <code>version</code> value type. */public static final byte VERSION = 31; 
	///**Constant for <code>xml</code> value type. */public static final byte XML = 32;  //NOTE: DECLARED IN INTERFACE INativeObjectTypes
	///**Constant for <code>xton</code> (text object notation) data type. */public static final byte XTON = 33;  //NOTE: DECLARED IN INTERFACE INativeObjectTypes
	///**Constant for <code>yaml</code> (yaml object notation) data type. */public static final byte YAML = 34;  //NOTE: DECLARED IN INTERFACE INativeObjectTypes
	///**Constant for <code>yaml</code> (yxml object notation) data type. */public static final byte YXML = 35;  //NOTE: DECLARED IN INTERFACE INativeObjectTypes
	
	/**Constant for <code>zcoords</code> (for <code>zone-coordinates</code> (latitude and longitude)) data type. */public static final byte ZCOORDS = 36;
	
	//*******************************
	// NOTE: THERE Is ONLY ONE UNALLOCALED NUMBER FOR native extension value type numbers and xpath extension numbers to coexist in the non-negative tiny-int valuespace
	//***
	
	/**Constant for nullable <code>boolean</code> value type (<code>boolean?</code>). */public static final byte BOOLEAN_ = 37; 
	/**Constant for nullable <code>char</code> value type (<code>char?</code>). */public static final byte CHAR_ = 38; 
	/**Constant for nullable <code>dfloat</code> value type (<code>dfloat?</code>). */public static final byte DFLOAT_ = 39; 
	/**Constant for nullable <code>int</code> value type (<code>int?</code>). */public static final byte INT_ = 40; 
	/**Constant for nullable <code>longint</code> value type (<code>longint?</code>). */public static final byte LONGINT_ = 41; 
	/**Constant for nullable <code>sfloat</code> value type (<code>sfloat?</code>). */public static final byte SFLOAT_ = 42; 
	/**Constant for nullable <code>shortint</code> value type (<code>shortint?</code>). */public static final byte SHORTINT_ = 43; 
	/**Constant for nullable <code>tinyint</code> value type (<code>tinyint?</code>). */public static final byte TINYINT_ = 44; 
	/**Constant for nullable <code>ubyte</code> value type (<code>ubyte?</code>). */public static final byte UBYTE_ = 45; 
	/**Constant for nullable <code>uint</code> value type (<code>uint?</code>). */public static final byte UINT_ = 46; 
	/**Constant for nullable <code>ulong</code> value type (<code>ulong?</code>). */public static final byte ULONG_ = 47; 
	/**Constant for nullable <code>ushort</code> value type (<code>ushort?</code>). */public static final byte USHORT_ = 48; 
	
	//*******************************
	// NOTE: THERE Is ONLY ONE UNALLOCALED NUMBER FOR native extension value type numbers and xpath extension numbers to coexist in the non-negative tiny-int valuespace
	//***
	//******************************* - 2015-Apr-17; MKA
	// NOTE: THERE Is NO MORE UNALLOCALED NUMBERS FOR native extension value type numbers and xpath extension numbers to coexist in the non-negative tiny-int valuespace
	// THE LAST DATA TYPE WHICH GOt ALLOCATED A NUMBER IS MATRIX DATA TYPE
	//***
	
	public static final byte FIRST_NULLABLE_VALUE_TYPE = BOOLEAN_;
	public static final byte LAST_NULLABLE_VALUE_TYPE = USHORT_;
	
	public static final byte NUMBER_OF_NULLABLES = (LAST_NULLABLE_VALUE_TYPE - FIRST_NULLABLE_VALUE_TYPE + 1);
		
	public static final byte CUSTOM = 127/*0*/; //zero is reserved for null
	
	/**
	* Holds the number of <code>core</code> native data types (native object types + core value types).
	* @see core.xml.xpath.SpecialDataTypes
	*/
	public static final byte NUMBER_OF_NATIVE_DATA_TYPES = 48;
	/**
	* Holds the toal number of core value types, including nullable versions of primitive value types.
	*/
	public static final byte NUMBER_OF_VALUE_TYPES = (byte)(NUMBER_OF_NATIVE_DATA_TYPES - INativeObjectTypes.NUMBER_OF_NATIVE_OBJECT_TYPES);
	/**
	* Holds the number of value types, with nullable primitive value types excluded.
	*/
	public static final byte NUMBER_OF_BASE_VALUE_TYPES = NUMBER_OF_NATIVE_DATA_TYPES - INativeObjectTypes.NUMBER_OF_NATIVE_OBJECT_TYPES - NUMBER_OF_NULLABLES;
	/**
	* NUMBER_OF_NATIVE_DATA_TYPES - NUMBER_OF_NULLABLES
	*/
	public static final byte NUMBER_OF_NON_NULLABLES = NUMBER_OF_NATIVE_DATA_TYPES - NUMBER_OF_NULLABLES;
	
	/**
	* (1L << INT) | (1L << LONGINT) | (1L << SHORTINT) | (1L << TINYINT)
	*/
	public static final long PRIMITIVE_INTEGERS = (1L << INT) | (1L << LONGINT) | (1L << SHORTINT) | (1L << TINYINT);
	/**
	* (1L << UINT) | (1L << ULONG) | (1L << UBYTE) | (1L << USHORT)
	*/
	public static final long UNSIGNED_INTEGERS = (1L << UINT) | (1L << ULONG) | (1L << UBYTE) | (1L << USHORT) ;
	/**
	* {@link #INTEGER} | {@link #PRIMITIVE_INTEGERS} | {@link #UNSIGNED_INTEGERS}
	*/
	public static final long INTEGERS = (1L << INTEGER) | PRIMITIVE_INTEGERS | UNSIGNED_INTEGERS;
	/**
	* {@link #DFLOAT} | {@link #SFLOAT} | {@link #LONGDOUBLE}
	*/
	public static final long FLOATS = (1L << DFLOAT) | (1L << SFLOAT) | (1L << LONGDOUBLE);
	/**
	* {@link #DFLOAT_} | {@link #SFLOAT_} | {@link #LONGDOUBLE_}
	*/
	public static final long FLOATS_ = (1L << DFLOAT_) | (1L << SFLOAT_);
	/**
	* (1L << INT_) | (1L << LONGINT_) | (1L << SHORTINT_) | (1L << TINYINT_)
	*/
	public static final long PRIMITIVE_INTEGERS_ = (1L << INT_) | (1L << LONGINT_) | (1L << SHORTINT_) | (1L << TINYINT_);
	/**
	* (1L << UINT_) | (1L << ULONG_) | (1L << UBYTE_) | (1L << USHORT_)
	*/
	public static final long UNSIGNED_INTEGERS_ = (1L << UINT_) | (1L << ULONG_) | (1L << UBYTE_) | (1L << USHORT_) ;
	/**
	* {@link #PRIMITIVE_INTEGERS_} | {@link #UNSIGNED_INTEGERS_}
	*/
	public static final long INTEGERS_ = PRIMITIVE_INTEGERS_ | UNSIGNED_INTEGERS_;
	
	/**
	* {@link #INTEGERS} | {@link #INTEGERS_}
	*/
	public static final long ALL_INTEGERS = INTEGERS | INTEGERS_;
	
	
	/**
	* {@link #FLOATS} | (1L << {@link #DECIMAL})
	*/
	public static final long DECIMALS = FLOATS | (1L << DECIMAL);
	/**
	* - (1L << SHORTINT) | (1L << TINYINT) | (1L << UBYTE)
	*/
	public static final long SHORTINTS = (1L << SHORTINT) | (1L << TINYINT) | (1L << UBYTE);
	/**
	* - (1L << INT) | SHORTINTS | (1L << USHORT)
	*/
	public static final long INTS = (1L << INT) | SHORTINTS | (1L << USHORT) ;
	/**
	* - (PRIMITIVE_INTEGERS | (1L << UINT) | (1L << UBYTE) | (1L << USHORT))
	*/
	public static final long LONGINTS = (PRIMITIVE_INTEGERS | (1L << UINT) | (1L << UBYTE) | (1L << USHORT)); 
	
	/**
	* - (1L << SFLOAT) | PRIMITIVE_INTEGERS | UNSIGNED_INTEGERS
	*/
	public static final long SFLOATS = (1L << SFLOAT) | PRIMITIVE_INTEGERS | UNSIGNED_INTEGERS;
	
	/**
	* - (1L << DFLOAT) | SFLOATS
	*/
	public static final long DFLOATS = (1L << DFLOAT) | SFLOATS; 
	
	/**
	* {@link #ALL_INTEGERS ALL_INTEGERS} | {@link #DECIMALS DECIMALS} | {@link #FLOATS_ FLOATS_}
	*/
	public static final long ALL_NUMBER_VALUE_TYPES = ALL_INTEGERS | DECIMALS | FLOATS_;
	
	/**
	* Constant for signalling that the data type is an array data type.<br>
	* <b>NOTE</b>: <code><i>array</i></code> and <code><i>list-of-items</i></code> are two different types of objects for representing the same data concept of container.<br>
	* @see #ITEM_LIST ITEM_LIST
	*/
	public static final byte ARRAY_TYPE = -1;
	/**
	* Constant for signalling that the data type is a list-of-items type - has same value as that of {@link #ARRAY_TYPE ARRAY_TYPE}.<br>
	* <b>NOTE</b>: <code><i>list-of-items</i></code> and <code><i>array</i></code> are two different types of objects for representing the same data concept of container.<br>
	*/
	public static final byte ITEM_LIST = ARRAY_TYPE;
	
	/**
	* Constant for signalling that a function's <code>argument</code>'s value type is a function type - same value that of constant {@link core.data.IValuespaceFlavours#FUNCTION_ARG_TYPE FUNCTION_ARG_TYPE}. 
	*/
	public static final byte FUNCTION_ARG_VALUE_TYPE = core.data.IValuespaceFlavours.FUNCTION_ARG_TYPE; 
	
	
	

}