/**
 * Autogenerated by Thrift Compiler (0.11.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package thrift.generated;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.11.0)", date = "2019-05-02")
public class Novel implements org.apache.thrift.TBase<Novel, Novel._Fields>, java.io.Serializable, Cloneable, Comparable<Novel> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("Novel");

  private static final org.apache.thrift.protocol.TField NOVEL_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("novelName", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField INTRODUCTION_FIELD_DESC = new org.apache.thrift.protocol.TField("introduction", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField AUTHOR_FIELD_DESC = new org.apache.thrift.protocol.TField("author", org.apache.thrift.protocol.TType.STRING, (short)3);
  private static final org.apache.thrift.protocol.TField TYPE_FIELD_DESC = new org.apache.thrift.protocol.TField("type", org.apache.thrift.protocol.TType.STRING, (short)4);
  private static final org.apache.thrift.protocol.TField IMAGE_FIELD_DESC = new org.apache.thrift.protocol.TField("image", org.apache.thrift.protocol.TType.STRING, (short)5);
  private static final org.apache.thrift.protocol.TField NOVEL_CHAPER_LIST_FIELD_DESC = new org.apache.thrift.protocol.TField("novelChaperList", org.apache.thrift.protocol.TType.LIST, (short)6);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new NovelStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new NovelTupleSchemeFactory();

  public java.lang.String novelName; // optional
  public java.lang.String introduction; // optional
  public java.lang.String author; // optional
  public java.lang.String type; // optional
  public java.lang.String image; // optional
  public java.util.List<NovelChapter> novelChaperList; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    NOVEL_NAME((short)1, "novelName"),
    INTRODUCTION((short)2, "introduction"),
    AUTHOR((short)3, "author"),
    TYPE((short)4, "type"),
    IMAGE((short)5, "image"),
    NOVEL_CHAPER_LIST((short)6, "novelChaperList");

    private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();

    static {
      for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // NOVEL_NAME
          return NOVEL_NAME;
        case 2: // INTRODUCTION
          return INTRODUCTION;
        case 3: // AUTHOR
          return AUTHOR;
        case 4: // TYPE
          return TYPE;
        case 5: // IMAGE
          return IMAGE;
        case 6: // NOVEL_CHAPER_LIST
          return NOVEL_CHAPER_LIST;
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
      if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(java.lang.String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final java.lang.String _fieldName;

    _Fields(short thriftId, java.lang.String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public java.lang.String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final _Fields optionals[] = {_Fields.NOVEL_NAME,_Fields.INTRODUCTION,_Fields.AUTHOR,_Fields.TYPE,_Fields.IMAGE,_Fields.NOVEL_CHAPER_LIST};
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.NOVEL_NAME, new org.apache.thrift.meta_data.FieldMetaData("novelName", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING        , "String")));
    tmpMap.put(_Fields.INTRODUCTION, new org.apache.thrift.meta_data.FieldMetaData("introduction", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING        , "String")));
    tmpMap.put(_Fields.AUTHOR, new org.apache.thrift.meta_data.FieldMetaData("author", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING        , "String")));
    tmpMap.put(_Fields.TYPE, new org.apache.thrift.meta_data.FieldMetaData("type", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING        , "String")));
    tmpMap.put(_Fields.IMAGE, new org.apache.thrift.meta_data.FieldMetaData("image", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING        , "String")));
    tmpMap.put(_Fields.NOVEL_CHAPER_LIST, new org.apache.thrift.meta_data.FieldMetaData("novelChaperList", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRUCT            , "NovelChapter"))));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(Novel.class, metaDataMap);
  }

  public Novel() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public Novel(Novel other) {
    if (other.isSetNovelName()) {
      this.novelName = other.novelName;
    }
    if (other.isSetIntroduction()) {
      this.introduction = other.introduction;
    }
    if (other.isSetAuthor()) {
      this.author = other.author;
    }
    if (other.isSetType()) {
      this.type = other.type;
    }
    if (other.isSetImage()) {
      this.image = other.image;
    }
    if (other.isSetNovelChaperList()) {
      java.util.List<NovelChapter> __this__novelChaperList = new java.util.ArrayList<NovelChapter>(other.novelChaperList.size());
      for (NovelChapter other_element : other.novelChaperList) {
        __this__novelChaperList.add(new NovelChapter(other_element));
      }
      this.novelChaperList = __this__novelChaperList;
    }
  }

  public Novel deepCopy() {
    return new Novel(this);
  }

  @Override
  public void clear() {
    this.novelName = null;
    this.introduction = null;
    this.author = null;
    this.type = null;
    this.image = null;
    this.novelChaperList = null;
  }

  public java.lang.String getNovelName() {
    return this.novelName;
  }

  public Novel setNovelName(java.lang.String novelName) {
    this.novelName = novelName;
    return this;
  }

  public void unsetNovelName() {
    this.novelName = null;
  }

  /** Returns true if field novelName is set (has been assigned a value) and false otherwise */
  public boolean isSetNovelName() {
    return this.novelName != null;
  }

  public void setNovelNameIsSet(boolean value) {
    if (!value) {
      this.novelName = null;
    }
  }

  public java.lang.String getIntroduction() {
    return this.introduction;
  }

  public Novel setIntroduction(java.lang.String introduction) {
    this.introduction = introduction;
    return this;
  }

  public void unsetIntroduction() {
    this.introduction = null;
  }

  /** Returns true if field introduction is set (has been assigned a value) and false otherwise */
  public boolean isSetIntroduction() {
    return this.introduction != null;
  }

  public void setIntroductionIsSet(boolean value) {
    if (!value) {
      this.introduction = null;
    }
  }

  public java.lang.String getAuthor() {
    return this.author;
  }

  public Novel setAuthor(java.lang.String author) {
    this.author = author;
    return this;
  }

  public void unsetAuthor() {
    this.author = null;
  }

  /** Returns true if field author is set (has been assigned a value) and false otherwise */
  public boolean isSetAuthor() {
    return this.author != null;
  }

  public void setAuthorIsSet(boolean value) {
    if (!value) {
      this.author = null;
    }
  }

  public java.lang.String getType() {
    return this.type;
  }

  public Novel setType(java.lang.String type) {
    this.type = type;
    return this;
  }

  public void unsetType() {
    this.type = null;
  }

  /** Returns true if field type is set (has been assigned a value) and false otherwise */
  public boolean isSetType() {
    return this.type != null;
  }

  public void setTypeIsSet(boolean value) {
    if (!value) {
      this.type = null;
    }
  }

  public java.lang.String getImage() {
    return this.image;
  }

  public Novel setImage(java.lang.String image) {
    this.image = image;
    return this;
  }

  public void unsetImage() {
    this.image = null;
  }

  /** Returns true if field image is set (has been assigned a value) and false otherwise */
  public boolean isSetImage() {
    return this.image != null;
  }

  public void setImageIsSet(boolean value) {
    if (!value) {
      this.image = null;
    }
  }

  public int getNovelChaperListSize() {
    return (this.novelChaperList == null) ? 0 : this.novelChaperList.size();
  }

  public java.util.Iterator<NovelChapter> getNovelChaperListIterator() {
    return (this.novelChaperList == null) ? null : this.novelChaperList.iterator();
  }

  public void addToNovelChaperList(NovelChapter elem) {
    if (this.novelChaperList == null) {
      this.novelChaperList = new java.util.ArrayList<NovelChapter>();
    }
    this.novelChaperList.add(elem);
  }

  public java.util.List<NovelChapter> getNovelChaperList() {
    return this.novelChaperList;
  }

  public Novel setNovelChaperList(java.util.List<NovelChapter> novelChaperList) {
    this.novelChaperList = novelChaperList;
    return this;
  }

  public void unsetNovelChaperList() {
    this.novelChaperList = null;
  }

  /** Returns true if field novelChaperList is set (has been assigned a value) and false otherwise */
  public boolean isSetNovelChaperList() {
    return this.novelChaperList != null;
  }

  public void setNovelChaperListIsSet(boolean value) {
    if (!value) {
      this.novelChaperList = null;
    }
  }

  public void setFieldValue(_Fields field, java.lang.Object value) {
    switch (field) {
    case NOVEL_NAME:
      if (value == null) {
        unsetNovelName();
      } else {
        setNovelName((java.lang.String)value);
      }
      break;

    case INTRODUCTION:
      if (value == null) {
        unsetIntroduction();
      } else {
        setIntroduction((java.lang.String)value);
      }
      break;

    case AUTHOR:
      if (value == null) {
        unsetAuthor();
      } else {
        setAuthor((java.lang.String)value);
      }
      break;

    case TYPE:
      if (value == null) {
        unsetType();
      } else {
        setType((java.lang.String)value);
      }
      break;

    case IMAGE:
      if (value == null) {
        unsetImage();
      } else {
        setImage((java.lang.String)value);
      }
      break;

    case NOVEL_CHAPER_LIST:
      if (value == null) {
        unsetNovelChaperList();
      } else {
        setNovelChaperList((java.util.List<NovelChapter>)value);
      }
      break;

    }
  }

  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case NOVEL_NAME:
      return getNovelName();

    case INTRODUCTION:
      return getIntroduction();

    case AUTHOR:
      return getAuthor();

    case TYPE:
      return getType();

    case IMAGE:
      return getImage();

    case NOVEL_CHAPER_LIST:
      return getNovelChaperList();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case NOVEL_NAME:
      return isSetNovelName();
    case INTRODUCTION:
      return isSetIntroduction();
    case AUTHOR:
      return isSetAuthor();
    case TYPE:
      return isSetType();
    case IMAGE:
      return isSetImage();
    case NOVEL_CHAPER_LIST:
      return isSetNovelChaperList();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that == null)
      return false;
    if (that instanceof Novel)
      return this.equals((Novel)that);
    return false;
  }

  public boolean equals(Novel that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_novelName = true && this.isSetNovelName();
    boolean that_present_novelName = true && that.isSetNovelName();
    if (this_present_novelName || that_present_novelName) {
      if (!(this_present_novelName && that_present_novelName))
        return false;
      if (!this.novelName.equals(that.novelName))
        return false;
    }

    boolean this_present_introduction = true && this.isSetIntroduction();
    boolean that_present_introduction = true && that.isSetIntroduction();
    if (this_present_introduction || that_present_introduction) {
      if (!(this_present_introduction && that_present_introduction))
        return false;
      if (!this.introduction.equals(that.introduction))
        return false;
    }

    boolean this_present_author = true && this.isSetAuthor();
    boolean that_present_author = true && that.isSetAuthor();
    if (this_present_author || that_present_author) {
      if (!(this_present_author && that_present_author))
        return false;
      if (!this.author.equals(that.author))
        return false;
    }

    boolean this_present_type = true && this.isSetType();
    boolean that_present_type = true && that.isSetType();
    if (this_present_type || that_present_type) {
      if (!(this_present_type && that_present_type))
        return false;
      if (!this.type.equals(that.type))
        return false;
    }

    boolean this_present_image = true && this.isSetImage();
    boolean that_present_image = true && that.isSetImage();
    if (this_present_image || that_present_image) {
      if (!(this_present_image && that_present_image))
        return false;
      if (!this.image.equals(that.image))
        return false;
    }

    boolean this_present_novelChaperList = true && this.isSetNovelChaperList();
    boolean that_present_novelChaperList = true && that.isSetNovelChaperList();
    if (this_present_novelChaperList || that_present_novelChaperList) {
      if (!(this_present_novelChaperList && that_present_novelChaperList))
        return false;
      if (!this.novelChaperList.equals(that.novelChaperList))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetNovelName()) ? 131071 : 524287);
    if (isSetNovelName())
      hashCode = hashCode * 8191 + novelName.hashCode();

    hashCode = hashCode * 8191 + ((isSetIntroduction()) ? 131071 : 524287);
    if (isSetIntroduction())
      hashCode = hashCode * 8191 + introduction.hashCode();

    hashCode = hashCode * 8191 + ((isSetAuthor()) ? 131071 : 524287);
    if (isSetAuthor())
      hashCode = hashCode * 8191 + author.hashCode();

    hashCode = hashCode * 8191 + ((isSetType()) ? 131071 : 524287);
    if (isSetType())
      hashCode = hashCode * 8191 + type.hashCode();

    hashCode = hashCode * 8191 + ((isSetImage()) ? 131071 : 524287);
    if (isSetImage())
      hashCode = hashCode * 8191 + image.hashCode();

    hashCode = hashCode * 8191 + ((isSetNovelChaperList()) ? 131071 : 524287);
    if (isSetNovelChaperList())
      hashCode = hashCode * 8191 + novelChaperList.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(Novel other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.valueOf(isSetNovelName()).compareTo(other.isSetNovelName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetNovelName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.novelName, other.novelName);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetIntroduction()).compareTo(other.isSetIntroduction());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetIntroduction()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.introduction, other.introduction);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetAuthor()).compareTo(other.isSetAuthor());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetAuthor()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.author, other.author);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetType()).compareTo(other.isSetType());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetType()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.type, other.type);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetImage()).compareTo(other.isSetImage());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetImage()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.image, other.image);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetNovelChaperList()).compareTo(other.isSetNovelChaperList());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetNovelChaperList()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.novelChaperList, other.novelChaperList);
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
    scheme(iprot).read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    scheme(oprot).write(oprot, this);
  }

  @Override
  public java.lang.String toString() {
    java.lang.StringBuilder sb = new java.lang.StringBuilder("Novel(");
    boolean first = true;

    if (isSetNovelName()) {
      sb.append("novelName:");
      if (this.novelName == null) {
        sb.append("null");
      } else {
        sb.append(this.novelName);
      }
      first = false;
    }
    if (isSetIntroduction()) {
      if (!first) sb.append(", ");
      sb.append("introduction:");
      if (this.introduction == null) {
        sb.append("null");
      } else {
        sb.append(this.introduction);
      }
      first = false;
    }
    if (isSetAuthor()) {
      if (!first) sb.append(", ");
      sb.append("author:");
      if (this.author == null) {
        sb.append("null");
      } else {
        sb.append(this.author);
      }
      first = false;
    }
    if (isSetType()) {
      if (!first) sb.append(", ");
      sb.append("type:");
      if (this.type == null) {
        sb.append("null");
      } else {
        sb.append(this.type);
      }
      first = false;
    }
    if (isSetImage()) {
      if (!first) sb.append(", ");
      sb.append("image:");
      if (this.image == null) {
        sb.append("null");
      } else {
        sb.append(this.image);
      }
      first = false;
    }
    if (isSetNovelChaperList()) {
      if (!first) sb.append(", ");
      sb.append("novelChaperList:");
      if (this.novelChaperList == null) {
        sb.append("null");
      } else {
        sb.append(this.novelChaperList);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class NovelStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public NovelStandardScheme getScheme() {
      return new NovelStandardScheme();
    }
  }

  private static class NovelStandardScheme extends org.apache.thrift.scheme.StandardScheme<Novel> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, Novel struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // NOVEL_NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.novelName = iprot.readString();
              struct.setNovelNameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // INTRODUCTION
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.introduction = iprot.readString();
              struct.setIntroductionIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // AUTHOR
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.author = iprot.readString();
              struct.setAuthorIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // TYPE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.type = iprot.readString();
              struct.setTypeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // IMAGE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.image = iprot.readString();
              struct.setImageIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 6: // NOVEL_CHAPER_LIST
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list0 = iprot.readListBegin();
                struct.novelChaperList = new java.util.ArrayList<NovelChapter>(_list0.size);
                NovelChapter _elem1;
                for (int _i2 = 0; _i2 < _list0.size; ++_i2)
                {
                  _elem1 = new NovelChapter();
                  _elem1.read(iprot);
                  struct.novelChaperList.add(_elem1);
                }
                iprot.readListEnd();
              }
              struct.setNovelChaperListIsSet(true);
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
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, Novel struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.novelName != null) {
        if (struct.isSetNovelName()) {
          oprot.writeFieldBegin(NOVEL_NAME_FIELD_DESC);
          oprot.writeString(struct.novelName);
          oprot.writeFieldEnd();
        }
      }
      if (struct.introduction != null) {
        if (struct.isSetIntroduction()) {
          oprot.writeFieldBegin(INTRODUCTION_FIELD_DESC);
          oprot.writeString(struct.introduction);
          oprot.writeFieldEnd();
        }
      }
      if (struct.author != null) {
        if (struct.isSetAuthor()) {
          oprot.writeFieldBegin(AUTHOR_FIELD_DESC);
          oprot.writeString(struct.author);
          oprot.writeFieldEnd();
        }
      }
      if (struct.type != null) {
        if (struct.isSetType()) {
          oprot.writeFieldBegin(TYPE_FIELD_DESC);
          oprot.writeString(struct.type);
          oprot.writeFieldEnd();
        }
      }
      if (struct.image != null) {
        if (struct.isSetImage()) {
          oprot.writeFieldBegin(IMAGE_FIELD_DESC);
          oprot.writeString(struct.image);
          oprot.writeFieldEnd();
        }
      }
      if (struct.novelChaperList != null) {
        if (struct.isSetNovelChaperList()) {
          oprot.writeFieldBegin(NOVEL_CHAPER_LIST_FIELD_DESC);
          {
            oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.novelChaperList.size()));
            for (NovelChapter _iter3 : struct.novelChaperList)
            {
              _iter3.write(oprot);
            }
            oprot.writeListEnd();
          }
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class NovelTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public NovelTupleScheme getScheme() {
      return new NovelTupleScheme();
    }
  }

  private static class NovelTupleScheme extends org.apache.thrift.scheme.TupleScheme<Novel> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, Novel struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetNovelName()) {
        optionals.set(0);
      }
      if (struct.isSetIntroduction()) {
        optionals.set(1);
      }
      if (struct.isSetAuthor()) {
        optionals.set(2);
      }
      if (struct.isSetType()) {
        optionals.set(3);
      }
      if (struct.isSetImage()) {
        optionals.set(4);
      }
      if (struct.isSetNovelChaperList()) {
        optionals.set(5);
      }
      oprot.writeBitSet(optionals, 6);
      if (struct.isSetNovelName()) {
        oprot.writeString(struct.novelName);
      }
      if (struct.isSetIntroduction()) {
        oprot.writeString(struct.introduction);
      }
      if (struct.isSetAuthor()) {
        oprot.writeString(struct.author);
      }
      if (struct.isSetType()) {
        oprot.writeString(struct.type);
      }
      if (struct.isSetImage()) {
        oprot.writeString(struct.image);
      }
      if (struct.isSetNovelChaperList()) {
        {
          oprot.writeI32(struct.novelChaperList.size());
          for (NovelChapter _iter4 : struct.novelChaperList)
          {
            _iter4.write(oprot);
          }
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, Novel struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(6);
      if (incoming.get(0)) {
        struct.novelName = iprot.readString();
        struct.setNovelNameIsSet(true);
      }
      if (incoming.get(1)) {
        struct.introduction = iprot.readString();
        struct.setIntroductionIsSet(true);
      }
      if (incoming.get(2)) {
        struct.author = iprot.readString();
        struct.setAuthorIsSet(true);
      }
      if (incoming.get(3)) {
        struct.type = iprot.readString();
        struct.setTypeIsSet(true);
      }
      if (incoming.get(4)) {
        struct.image = iprot.readString();
        struct.setImageIsSet(true);
      }
      if (incoming.get(5)) {
        {
          org.apache.thrift.protocol.TList _list5 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
          struct.novelChaperList = new java.util.ArrayList<NovelChapter>(_list5.size);
          NovelChapter _elem6;
          for (int _i7 = 0; _i7 < _list5.size; ++_i7)
          {
            _elem6 = new NovelChapter();
            _elem6.read(iprot);
            struct.novelChaperList.add(_elem6);
          }
        }
        struct.setNovelChaperListIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

