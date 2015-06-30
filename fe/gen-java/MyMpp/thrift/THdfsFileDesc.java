/**
 * Autogenerated by Thrift Compiler (0.9.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package MyMpp.thrift;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class THdfsFileDesc implements org.apache.thrift.TBase<THdfsFileDesc, THdfsFileDesc._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("THdfsFileDesc");

  private static final org.apache.thrift.protocol.TField FILE_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("file_name", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField LENGTH_FIELD_DESC = new org.apache.thrift.protocol.TField("length", org.apache.thrift.protocol.TType.I64, (short)2);
  private static final org.apache.thrift.protocol.TField LAST_MODIFICATION_TIME_FIELD_DESC = new org.apache.thrift.protocol.TField("last_modification_time", org.apache.thrift.protocol.TType.I64, (short)3);
  private static final org.apache.thrift.protocol.TField FILE_BLOCKS_FIELD_DESC = new org.apache.thrift.protocol.TField("file_blocks", org.apache.thrift.protocol.TType.LIST, (short)4);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new THdfsFileDescStandardSchemeFactory());
    schemes.put(TupleScheme.class, new THdfsFileDescTupleSchemeFactory());
  }

  public String file_name; // required
  public long length; // required
  public long last_modification_time; // required
  public List<THdfsFileBlock> file_blocks; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    FILE_NAME((short)1, "file_name"),
    LENGTH((short)2, "length"),
    LAST_MODIFICATION_TIME((short)3, "last_modification_time"),
    FILE_BLOCKS((short)4, "file_blocks");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // FILE_NAME
          return FILE_NAME;
        case 2: // LENGTH
          return LENGTH;
        case 3: // LAST_MODIFICATION_TIME
          return LAST_MODIFICATION_TIME;
        case 4: // FILE_BLOCKS
          return FILE_BLOCKS;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __LENGTH_ISSET_ID = 0;
  private static final int __LAST_MODIFICATION_TIME_ISSET_ID = 1;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.FILE_NAME, new org.apache.thrift.meta_data.FieldMetaData("file_name", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.LENGTH, new org.apache.thrift.meta_data.FieldMetaData("length", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.LAST_MODIFICATION_TIME, new org.apache.thrift.meta_data.FieldMetaData("last_modification_time", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.FILE_BLOCKS, new org.apache.thrift.meta_data.FieldMetaData("file_blocks", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, THdfsFileBlock.class))));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(THdfsFileDesc.class, metaDataMap);
  }

  public THdfsFileDesc() {
  }

  public THdfsFileDesc(
    String file_name,
    long length,
    long last_modification_time,
    List<THdfsFileBlock> file_blocks)
  {
    this();
    this.file_name = file_name;
    this.length = length;
    setLengthIsSet(true);
    this.last_modification_time = last_modification_time;
    setLast_modification_timeIsSet(true);
    this.file_blocks = file_blocks;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public THdfsFileDesc(THdfsFileDesc other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetFile_name()) {
      this.file_name = other.file_name;
    }
    this.length = other.length;
    this.last_modification_time = other.last_modification_time;
    if (other.isSetFile_blocks()) {
      List<THdfsFileBlock> __this__file_blocks = new ArrayList<THdfsFileBlock>();
      for (THdfsFileBlock other_element : other.file_blocks) {
        __this__file_blocks.add(new THdfsFileBlock(other_element));
      }
      this.file_blocks = __this__file_blocks;
    }
  }

  public THdfsFileDesc deepCopy() {
    return new THdfsFileDesc(this);
  }

  @Override
  public void clear() {
    this.file_name = null;
    setLengthIsSet(false);
    this.length = 0;
    setLast_modification_timeIsSet(false);
    this.last_modification_time = 0;
    this.file_blocks = null;
  }

  public String getFile_name() {
    return this.file_name;
  }

  public THdfsFileDesc setFile_name(String file_name) {
    this.file_name = file_name;
    return this;
  }

  public void unsetFile_name() {
    this.file_name = null;
  }

  /** Returns true if field file_name is set (has been assigned a value) and false otherwise */
  public boolean isSetFile_name() {
    return this.file_name != null;
  }

  public void setFile_nameIsSet(boolean value) {
    if (!value) {
      this.file_name = null;
    }
  }

  public long getLength() {
    return this.length;
  }

  public THdfsFileDesc setLength(long length) {
    this.length = length;
    setLengthIsSet(true);
    return this;
  }

  public void unsetLength() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __LENGTH_ISSET_ID);
  }

  /** Returns true if field length is set (has been assigned a value) and false otherwise */
  public boolean isSetLength() {
    return EncodingUtils.testBit(__isset_bitfield, __LENGTH_ISSET_ID);
  }

  public void setLengthIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __LENGTH_ISSET_ID, value);
  }

  public long getLast_modification_time() {
    return this.last_modification_time;
  }

  public THdfsFileDesc setLast_modification_time(long last_modification_time) {
    this.last_modification_time = last_modification_time;
    setLast_modification_timeIsSet(true);
    return this;
  }

  public void unsetLast_modification_time() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __LAST_MODIFICATION_TIME_ISSET_ID);
  }

  /** Returns true if field last_modification_time is set (has been assigned a value) and false otherwise */
  public boolean isSetLast_modification_time() {
    return EncodingUtils.testBit(__isset_bitfield, __LAST_MODIFICATION_TIME_ISSET_ID);
  }

  public void setLast_modification_timeIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __LAST_MODIFICATION_TIME_ISSET_ID, value);
  }

  public int getFile_blocksSize() {
    return (this.file_blocks == null) ? 0 : this.file_blocks.size();
  }

  public java.util.Iterator<THdfsFileBlock> getFile_blocksIterator() {
    return (this.file_blocks == null) ? null : this.file_blocks.iterator();
  }

  public void addToFile_blocks(THdfsFileBlock elem) {
    if (this.file_blocks == null) {
      this.file_blocks = new ArrayList<THdfsFileBlock>();
    }
    this.file_blocks.add(elem);
  }

  public List<THdfsFileBlock> getFile_blocks() {
    return this.file_blocks;
  }

  public THdfsFileDesc setFile_blocks(List<THdfsFileBlock> file_blocks) {
    this.file_blocks = file_blocks;
    return this;
  }

  public void unsetFile_blocks() {
    this.file_blocks = null;
  }

  /** Returns true if field file_blocks is set (has been assigned a value) and false otherwise */
  public boolean isSetFile_blocks() {
    return this.file_blocks != null;
  }

  public void setFile_blocksIsSet(boolean value) {
    if (!value) {
      this.file_blocks = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case FILE_NAME:
      if (value == null) {
        unsetFile_name();
      } else {
        setFile_name((String)value);
      }
      break;

    case LENGTH:
      if (value == null) {
        unsetLength();
      } else {
        setLength((Long)value);
      }
      break;

    case LAST_MODIFICATION_TIME:
      if (value == null) {
        unsetLast_modification_time();
      } else {
        setLast_modification_time((Long)value);
      }
      break;

    case FILE_BLOCKS:
      if (value == null) {
        unsetFile_blocks();
      } else {
        setFile_blocks((List<THdfsFileBlock>)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case FILE_NAME:
      return getFile_name();

    case LENGTH:
      return Long.valueOf(getLength());

    case LAST_MODIFICATION_TIME:
      return Long.valueOf(getLast_modification_time());

    case FILE_BLOCKS:
      return getFile_blocks();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case FILE_NAME:
      return isSetFile_name();
    case LENGTH:
      return isSetLength();
    case LAST_MODIFICATION_TIME:
      return isSetLast_modification_time();
    case FILE_BLOCKS:
      return isSetFile_blocks();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof THdfsFileDesc)
      return this.equals((THdfsFileDesc)that);
    return false;
  }

  public boolean equals(THdfsFileDesc that) {
    if (that == null)
      return false;

    boolean this_present_file_name = true && this.isSetFile_name();
    boolean that_present_file_name = true && that.isSetFile_name();
    if (this_present_file_name || that_present_file_name) {
      if (!(this_present_file_name && that_present_file_name))
        return false;
      if (!this.file_name.equals(that.file_name))
        return false;
    }

    boolean this_present_length = true;
    boolean that_present_length = true;
    if (this_present_length || that_present_length) {
      if (!(this_present_length && that_present_length))
        return false;
      if (this.length != that.length)
        return false;
    }

    boolean this_present_last_modification_time = true;
    boolean that_present_last_modification_time = true;
    if (this_present_last_modification_time || that_present_last_modification_time) {
      if (!(this_present_last_modification_time && that_present_last_modification_time))
        return false;
      if (this.last_modification_time != that.last_modification_time)
        return false;
    }

    boolean this_present_file_blocks = true && this.isSetFile_blocks();
    boolean that_present_file_blocks = true && that.isSetFile_blocks();
    if (this_present_file_blocks || that_present_file_blocks) {
      if (!(this_present_file_blocks && that_present_file_blocks))
        return false;
      if (!this.file_blocks.equals(that.file_blocks))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  public int compareTo(THdfsFileDesc other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    THdfsFileDesc typedOther = (THdfsFileDesc)other;

    lastComparison = Boolean.valueOf(isSetFile_name()).compareTo(typedOther.isSetFile_name());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetFile_name()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.file_name, typedOther.file_name);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetLength()).compareTo(typedOther.isSetLength());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetLength()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.length, typedOther.length);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetLast_modification_time()).compareTo(typedOther.isSetLast_modification_time());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetLast_modification_time()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.last_modification_time, typedOther.last_modification_time);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetFile_blocks()).compareTo(typedOther.isSetFile_blocks());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetFile_blocks()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.file_blocks, typedOther.file_blocks);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("THdfsFileDesc(");
    boolean first = true;

    sb.append("file_name:");
    if (this.file_name == null) {
      sb.append("null");
    } else {
      sb.append(this.file_name);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("length:");
    sb.append(this.length);
    first = false;
    if (!first) sb.append(", ");
    sb.append("last_modification_time:");
    sb.append(this.last_modification_time);
    first = false;
    if (!first) sb.append(", ");
    sb.append("file_blocks:");
    if (this.file_blocks == null) {
      sb.append("null");
    } else {
      sb.append(this.file_blocks);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (file_name == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'file_name' was not present! Struct: " + toString());
    }
    // alas, we cannot check 'length' because it's a primitive and you chose the non-beans generator.
    // alas, we cannot check 'last_modification_time' because it's a primitive and you chose the non-beans generator.
    if (file_blocks == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'file_blocks' was not present! Struct: " + toString());
    }
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class THdfsFileDescStandardSchemeFactory implements SchemeFactory {
    public THdfsFileDescStandardScheme getScheme() {
      return new THdfsFileDescStandardScheme();
    }
  }

  private static class THdfsFileDescStandardScheme extends StandardScheme<THdfsFileDesc> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, THdfsFileDesc struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // FILE_NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.file_name = iprot.readString();
              struct.setFile_nameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // LENGTH
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.length = iprot.readI64();
              struct.setLengthIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // LAST_MODIFICATION_TIME
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.last_modification_time = iprot.readI64();
              struct.setLast_modification_timeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // FILE_BLOCKS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list16 = iprot.readListBegin();
                struct.file_blocks = new ArrayList<THdfsFileBlock>(_list16.size);
                for (int _i17 = 0; _i17 < _list16.size; ++_i17)
                {
                  THdfsFileBlock _elem18; // required
                  _elem18 = new THdfsFileBlock();
                  _elem18.read(iprot);
                  struct.file_blocks.add(_elem18);
                }
                iprot.readListEnd();
              }
              struct.setFile_blocksIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      if (!struct.isSetLength()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'length' was not found in serialized data! Struct: " + toString());
      }
      if (!struct.isSetLast_modification_time()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'last_modification_time' was not found in serialized data! Struct: " + toString());
      }
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, THdfsFileDesc struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.file_name != null) {
        oprot.writeFieldBegin(FILE_NAME_FIELD_DESC);
        oprot.writeString(struct.file_name);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(LENGTH_FIELD_DESC);
      oprot.writeI64(struct.length);
      oprot.writeFieldEnd();
      oprot.writeFieldBegin(LAST_MODIFICATION_TIME_FIELD_DESC);
      oprot.writeI64(struct.last_modification_time);
      oprot.writeFieldEnd();
      if (struct.file_blocks != null) {
        oprot.writeFieldBegin(FILE_BLOCKS_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.file_blocks.size()));
          for (THdfsFileBlock _iter19 : struct.file_blocks)
          {
            _iter19.write(oprot);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class THdfsFileDescTupleSchemeFactory implements SchemeFactory {
    public THdfsFileDescTupleScheme getScheme() {
      return new THdfsFileDescTupleScheme();
    }
  }

  private static class THdfsFileDescTupleScheme extends TupleScheme<THdfsFileDesc> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, THdfsFileDesc struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      oprot.writeString(struct.file_name);
      oprot.writeI64(struct.length);
      oprot.writeI64(struct.last_modification_time);
      {
        oprot.writeI32(struct.file_blocks.size());
        for (THdfsFileBlock _iter20 : struct.file_blocks)
        {
          _iter20.write(oprot);
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, THdfsFileDesc struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.file_name = iprot.readString();
      struct.setFile_nameIsSet(true);
      struct.length = iprot.readI64();
      struct.setLengthIsSet(true);
      struct.last_modification_time = iprot.readI64();
      struct.setLast_modification_timeIsSet(true);
      {
        org.apache.thrift.protocol.TList _list21 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
        struct.file_blocks = new ArrayList<THdfsFileBlock>(_list21.size);
        for (int _i22 = 0; _i22 < _list21.size; ++_i22)
        {
          THdfsFileBlock _elem23; // required
          _elem23 = new THdfsFileBlock();
          _elem23.read(iprot);
          struct.file_blocks.add(_elem23);
        }
      }
      struct.setFile_blocksIsSet(true);
    }
  }

}

