package core;

/**
* Interface with integer number constants for for the object types.<br>
*
* @author Marc E. KAMGA
* @version 1.0
* @copyright Marc E. KAMGA
*/
public interface IObjectTypes {

	/**
	* Constant for <code>unspecified</code> object type.
	*/
	public static final byte UNSPECIFIED_OBJECT_TYPE = 0;
	/**
	* Constant for <code>struct</code> object type.
	*/
	public static final byte STRUCT = 1;
	/**
	* Constant for <code>unit-type</code> object type.
	*/
	public static final byte UNIT_TYPE = 2;
	/**
	* Constant for <code>unit-value</code> object type.
	*/
	public static final byte UNIT_VALUE = 3;
	/**
	* Constant for <code>name-value</code> object type.
	*/
	public static final byte NAME_VALUE_PAIR = 4;
	/**
	* Constant for <code>content-type</code> object type.
	*/
	public static final byte CONTENT_TYPE = 5;
	/**
	* Constant for <code>record</code> object type.
	*/
	public static final byte RECORD = 6;
	/**
	* Constant for <code>record-set</code> object type.
	*/
	public static final byte RECORD_SET = 7;
	/**
	* Constant for <code>list-of-items</code> object type.
	*/
	public static final byte LIST_OF_ITEMS = 8;
	/**
	* Constant for <code>null-object</code> object type.
	*/
	public static final byte NULL_OBJECT = 10;
	/**
	* Constant for <code>xml</code> object type.
	*/
	public static final byte XML_OBJECT = 11;
	/**
	* Constant for <code>json</code> object type.
	*/
	public static final byte JSON_OBJECT = 12;
	/**
	* Constant for <code>yaml</code> object type.
	*/
	public static final byte YAML_OBJECT = 13;
	/**
	* Constant for <code>yxml</code> object type.
	*/
	public static final byte YXML_OBJECT = 14;
	/**
	* Constant for <code>xton</code> object type.
	*/
	public static final byte XTON_OBJECT = 15;
	/**
	* Constant for <code>matrix</code> object type.
	*/
	public static final byte MATRIX_OBJECT = 16;
	/**
	* Constant for <code>vector</code> object type.
	*/
	public static final byte VECTOR_OBJECT = 17;
	/**
	* Constant for <code>file-system-info</code> object type.
	*/
	public static final byte FILE_SYSTEM_ITEM_INFO = 18;
	/**
	* Constant for <code>namespace</code> object type.
	*/
	public static final byte NAMESPACE = 19;
	/**
	* Constant for <code>namepace-context</code> object type.
	*/
	public static final byte NAMESPACE_CONTEXT = 20;
	/**
	* Constant for <code>evaluation-context</code> object type.
	*/
	public static final byte EVALUATION_CONTEXT = 21;
	/**
	* Constant for <code>asn.1</code> object type - HAS YET TO BE EFFECTIVELY HANDLED
	*/
	public static final byte ASN1_OBJECT = 22;
	/**
	* Constant for <code>timezone</code> object type - HAS YET TO BE EFFECTIVELY HANDLED
	*/
	public static final byte TIMEZONE_OBJECT = 23;
	/**
	* Constant for <code>locale</code> object type - HAS YET TO BE EFFECTIVELY HANDLED
	*/
	public static final byte LOCALE_OBJECT = 24;
	/**
	* Constant for <code>decimal-format-symbols</code> object type.
	*/
	public static final byte DECIMAL_FORMAT_SYMBOLS = 25;
	/**
	* Constant for <code>datetime-format-symbols</code> object type.
	*/
	public static final byte DATETIME_FORMAT_SYMBOLS = 26;
	/**
	* Constant for <code>boolean-format-symbols</code> object type.
	*/
	public static final byte BOOLEAN_FORMAT_SYMBOLS = 27;
	/**
	* Constant for <code>function-signature</code> object type.
	*/
	public static final byte FUNCTION_SIGNATURE = 28;
	/**
	* Constant for <code>business-entity</code> object type.
	*/
	public static final byte BUSINESS_ENTITY = 29;
	/**
	* Constant for <code>business-object</code> object type.
	*/
	public static final byte BUSINESS_OBJECT = 30;
	/**
	* Constant for <code>color</code> object type.
	*/
	public static final byte COLOR_OBJECT = 31;
	/**
	* Constant for <code>map</code> object type.
	*/
	public static final byte MAP_OBJECT = 32;
	/**
	* Constant for <code>release-info</code> object type.
	*/
	public static final byte RELEASE_INFO_OBJECT = 33;
	/**
	* Constant for <code>css-unit-value</code> object type.
	*/
	public static final byte CSS_UNIT_VALUE = 34;
	/**
	* Constant for <code>css-attr</code> object type.
	*/
	public static final byte CSS_ATTR = 35;
	/**
	* Constant for <code>css-rect</code> object type.
	*/
	public static final byte CSS_RECT = 36;
	/**
	* Constant for <code>css-counter</code> object type.
	*/
	public static final byte CSS_COUNTER = 37;
	/**
	* Constant for <code>css-counters</code> object type.
	*/
	public static final byte CSS_COUNTERS = 38;
	/**
	* Constant for <code>css-value-toggle</code> object type.
	*/
	public static final byte CSS_VALUE_TOGGLE = 39;
	/**
	* Constant for <code>css-property</code> object type.
	*/
	public static final byte CSS_PROPERTY = 40;
	/**
	* Constant for <code>css-rule</code> object type.
	*/
	public static final byte CSS_RULE = 41;
	/**
	* Constant for <code>tuple</code> object type.
	*/
	public static final byte TUPLE = 42;
	/**
	* Constant for <code>repeated-value</code> object type.
	*/
	public static final byte REPEATED_VALUE = 43;
	/**
	* Constant for <code>gpb-struct</code> object type.
	*/
	public static final byte GPB_STRUCT = 44;
	/**
	* Constant for <code>gpb-message</code> object type.
	*/
	public static final byte GPB_MESSAGE = 45;
	/**
	* Constant for <code>json-property</code> object type.
	*/
	public static final byte JSON_PROPERTY = 46; //since 2018-04-22
	/**
	* Constant for <code>json-array</code> object type.
	*/
	public static final byte JSON_ARRAY = 47; //since 2018-04-22
	/**
	* Constant for <code>xml-text-node</code> object type.
	*/
	public static final byte XML_TEXT_NODE = 48; //since 2018-04-22
	/**
	* Constant for <code>yaml-property</code> object type.
	*/
	public static final byte YAML_PROPERTY = 49; //since 2018-04-22
	/**
	* Constant for <code>yaml-sequence</code> object type.
	*/
	public static final byte YAML_SEQUENCE = 50; //since 2018-04-22
	/**
	* Constant for <code>yaml-array</code> object type.
	*/
	public static final byte YAML_ARRAY = 51; //since 2018-04-22
	/**
	* Constant for <code>xml-document</code> object type.
	*/
	public static final byte XML_DOCUMENT = 52; //since 2018-04-22
	/**
	* Constant for <code>json-document</code> object type.
	*/
	public static final byte JSON_DOCUMENT = 53; //since 2018-04-22
	/**
	* Constant for <code>yaml-document</code> object type.
	*/
	public static final byte YAML_DOCUMENT = 54; //since 2018-04-22

	/**
	* Constant for <code>class-object</code> object type.
	*/
	public static final byte CLASS_OBJECT = 127;
	/**
	* The number of object types.
	*/
	public static final byte NUMBER_OF_OBJECT_TYPES = 55; //CLASS_OBJECT is included
	/**
	* <code>({@link #NUMBER_OF_OBJECT_TYPES NUMBER_OF_OBJECT_TYPES} - 1)
	*/
	public static final byte NUMBER_OF_OBJECT_TYPES_M1 = NUMBER_OF_OBJECT_TYPES - 1;


}