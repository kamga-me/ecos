package core;

/**
* Interface with integer number constants declarations for the native object (data) types.<br>
* <p>
* The numbers are allocated as follows: br>
* &#9;1) the names of the native object types and those of the core native value types are put into a string list, <br>
* &#9;2) the list is sorted as per names natural order, <br>
* &#9;3) <code>1</code> is added to the index of each in the list to form the data type number (native object type number for a native object data type and value type number for a value data type).<br>
* </p>
* 
* @author Marc E. KAMGA
* @version 1.0
* 
* @see core.object.definition.IDataType
* @see Value
* @see core.data.type.DataType
* @see Object
* @see core.io.IDataSerializationTypes
*/
public interface INativeObjectTypes {

	
	/**Constant for <code>entity</code> data type. */public static final byte ENTITY = 10; 
	/**Constant for <code>json</code> data type. */public static final byte JSON = 13; 
	
	/**Constant for <code>matrix</code> data type. */public static final byte MATRIX = 16; //new as 2015-Apr-17
	
	/**
	* Constant for generic <code>object</code> data type. <br>
	* <b>NOTE</b>: the constant was renamed (on 28-mar-2014) from OBJECT to avoid conflict with the constant OBJECT constant declared in DataObject class; The name of the data type remains "object".<br>
	*/
	public static final byte SJOBJECT = 17; //NOTE: the constant was renamed (on 28-mar-2014) from OBJECT to avoid conflict with the constant OBJECT constant declared in DataObject class; The name of the data type remains "object".
	/**Constant for <code>xml</code> data type. */public static final byte XML = 32; 
	/**Constant for <code>xton</code> (text object notation) data type. */public static final byte XTON = 33; 
	/**Constant for <code>yaml</code> (yaml object notation) data type. */public static final byte YAML = 34; 
	
	
	/**
	* Constant for <code>yxml</code> (yaml for xml object notation or why xml) data type. <br>
	* YAML for XML object notation represents xml objects in YAML, with some YAML constructs (constructs based on pair of indicators ('{', '}'are examples of unsupported YAML constructs) not supported.<br>
	*/
	public static final byte YXML = 35; 
	
	/**
	* flags for all the object value types.
	*/
	public static final long ALL_OBJECT_VALUE_TYPES = (1L << ENTITY) | (1L << JSON) | (1L << MATRIX) | 
													(1L << SJOBJECT) | (1L << XML) | (1L << XTON) | 
																(1L << YAML) | (1L << YXML); 
	
	
	/**
	* Holds the number of <code>system.j</code> native object types types.
	*/
	public static final byte NUMBER_OF_NATIVE_OBJECT_TYPES = 8;


}