#
# Autogenerated by Thrift Compiler (0.11.0)
#
# DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
#
#  options string: py
#

from thrift.Thrift import TType, TMessageType, TFrozenDict, TException, TApplicationException
from thrift.protocol.TProtocol import TProtocolException
from thrift.TRecursive import fix_spec

import sys

from thrift.transport import TTransport
all_structs = []


class NovelChapterContext(object):
    """
    Attributes:
     - novelName
     - novelChapterName
     - type
     - context
     - lastChapter
     - nextChapter
    """


    def __init__(self, novelName=None, novelChapterName=None, type=None, context=None, lastChapter=None, nextChapter=None,):
        self.novelName = novelName
        self.novelChapterName = novelChapterName
        self.type = type
        self.context = context
        self.lastChapter = lastChapter
        self.nextChapter = nextChapter

    def read(self, iprot):
        if iprot._fast_decode is not None and isinstance(iprot.trans, TTransport.CReadableTransport) and self.thrift_spec is not None:
            iprot._fast_decode(self, iprot, [self.__class__, self.thrift_spec])
            return
        iprot.readStructBegin()
        while True:
            (fname, ftype, fid) = iprot.readFieldBegin()
            if ftype == TType.STOP:
                break
            if fid == 1:
                if ftype == TType.STRING:
                    self.novelName = iprot.readString().decode('utf-8') if sys.version_info[0] == 2 else iprot.readString()
                else:
                    iprot.skip(ftype)
            elif fid == 2:
                if ftype == TType.STRING:
                    self.novelChapterName = iprot.readString().decode('utf-8') if sys.version_info[0] == 2 else iprot.readString()
                else:
                    iprot.skip(ftype)
            elif fid == 3:
                if ftype == TType.STRING:
                    self.type = iprot.readString().decode('utf-8') if sys.version_info[0] == 2 else iprot.readString()
                else:
                    iprot.skip(ftype)
            elif fid == 4:
                if ftype == TType.STRING:
                    self.context = iprot.readString().decode('utf-8') if sys.version_info[0] == 2 else iprot.readString()
                else:
                    iprot.skip(ftype)
            elif fid == 5:
                if ftype == TType.STRING:
                    self.lastChapter = iprot.readString().decode('utf-8') if sys.version_info[0] == 2 else iprot.readString()
                else:
                    iprot.skip(ftype)
            elif fid == 6:
                if ftype == TType.STRING:
                    self.nextChapter = iprot.readString().decode('utf-8') if sys.version_info[0] == 2 else iprot.readString()
                else:
                    iprot.skip(ftype)
            else:
                iprot.skip(ftype)
            iprot.readFieldEnd()
        iprot.readStructEnd()

    def write(self, oprot):
        if oprot._fast_encode is not None and self.thrift_spec is not None:
            oprot.trans.write(oprot._fast_encode(self, [self.__class__, self.thrift_spec]))
            return
        oprot.writeStructBegin('NovelChapterContext')
        if self.novelName is not None:
            oprot.writeFieldBegin('novelName', TType.STRING, 1)
            oprot.writeString(self.novelName.encode('utf-8') if sys.version_info[0] == 2 else self.novelName)
            oprot.writeFieldEnd()
        if self.novelChapterName is not None:
            oprot.writeFieldBegin('novelChapterName', TType.STRING, 2)
            oprot.writeString(self.novelChapterName.encode('utf-8') if sys.version_info[0] == 2 else self.novelChapterName)
            oprot.writeFieldEnd()
        if self.type is not None:
            oprot.writeFieldBegin('type', TType.STRING, 3)
            oprot.writeString(self.type.encode('utf-8') if sys.version_info[0] == 2 else self.type)
            oprot.writeFieldEnd()
        if self.context is not None:
            oprot.writeFieldBegin('context', TType.STRING, 4)
            oprot.writeString(self.context.encode('utf-8') if sys.version_info[0] == 2 else self.context)
            oprot.writeFieldEnd()
        if self.lastChapter is not None:
            oprot.writeFieldBegin('lastChapter', TType.STRING, 5)
            oprot.writeString(self.lastChapter.encode('utf-8') if sys.version_info[0] == 2 else self.lastChapter)
            oprot.writeFieldEnd()
        if self.nextChapter is not None:
            oprot.writeFieldBegin('nextChapter', TType.STRING, 6)
            oprot.writeString(self.nextChapter.encode('utf-8') if sys.version_info[0] == 2 else self.nextChapter)
            oprot.writeFieldEnd()
        oprot.writeFieldStop()
        oprot.writeStructEnd()

    def validate(self):
        return

    def __repr__(self):
        L = ['%s=%r' % (key, value)
             for key, value in self.__dict__.items()]
        return '%s(%s)' % (self.__class__.__name__, ', '.join(L))

    def __eq__(self, other):
        return isinstance(other, self.__class__) and self.__dict__ == other.__dict__

    def __ne__(self, other):
        return not (self == other)


class Novel(object):
    """
    Attributes:
     - novelName
     - introduction
     - author
     - type
     - image
     - novelChaperList
    """


    def __init__(self, novelName=None, introduction=None, author=None, type=None, image=None, novelChaperList=None,):
        self.novelName = novelName
        self.introduction = introduction
        self.author = author
        self.type = type
        self.image = image
        self.novelChaperList = novelChaperList

    def read(self, iprot):
        if iprot._fast_decode is not None and isinstance(iprot.trans, TTransport.CReadableTransport) and self.thrift_spec is not None:
            iprot._fast_decode(self, iprot, [self.__class__, self.thrift_spec])
            return
        iprot.readStructBegin()
        while True:
            (fname, ftype, fid) = iprot.readFieldBegin()
            if ftype == TType.STOP:
                break
            if fid == 1:
                if ftype == TType.STRING:
                    self.novelName = iprot.readString().decode('utf-8') if sys.version_info[0] == 2 else iprot.readString()
                else:
                    iprot.skip(ftype)
            elif fid == 2:
                if ftype == TType.STRING:
                    self.introduction = iprot.readString().decode('utf-8') if sys.version_info[0] == 2 else iprot.readString()
                else:
                    iprot.skip(ftype)
            elif fid == 3:
                if ftype == TType.STRING:
                    self.author = iprot.readString().decode('utf-8') if sys.version_info[0] == 2 else iprot.readString()
                else:
                    iprot.skip(ftype)
            elif fid == 4:
                if ftype == TType.STRING:
                    self.type = iprot.readString().decode('utf-8') if sys.version_info[0] == 2 else iprot.readString()
                else:
                    iprot.skip(ftype)
            elif fid == 5:
                if ftype == TType.STRING:
                    self.image = iprot.readString().decode('utf-8') if sys.version_info[0] == 2 else iprot.readString()
                else:
                    iprot.skip(ftype)
            elif fid == 6:
                if ftype == TType.LIST:
                    self.novelChaperList = []
                    (_etype3, _size0) = iprot.readListBegin()
                    for _i4 in range(_size0):
                        _elem5 = NovelChapter()
                        _elem5.read(iprot)
                        self.novelChaperList.append(_elem5)
                    iprot.readListEnd()
                else:
                    iprot.skip(ftype)
            else:
                iprot.skip(ftype)
            iprot.readFieldEnd()
        iprot.readStructEnd()

    def write(self, oprot):
        if oprot._fast_encode is not None and self.thrift_spec is not None:
            oprot.trans.write(oprot._fast_encode(self, [self.__class__, self.thrift_spec]))
            return
        oprot.writeStructBegin('Novel')
        if self.novelName is not None:
            oprot.writeFieldBegin('novelName', TType.STRING, 1)
            oprot.writeString(self.novelName.encode('utf-8') if sys.version_info[0] == 2 else self.novelName)
            oprot.writeFieldEnd()
        if self.introduction is not None:
            oprot.writeFieldBegin('introduction', TType.STRING, 2)
            oprot.writeString(self.introduction.encode('utf-8') if sys.version_info[0] == 2 else self.introduction)
            oprot.writeFieldEnd()
        if self.author is not None:
            oprot.writeFieldBegin('author', TType.STRING, 3)
            oprot.writeString(self.author.encode('utf-8') if sys.version_info[0] == 2 else self.author)
            oprot.writeFieldEnd()
        if self.type is not None:
            oprot.writeFieldBegin('type', TType.STRING, 4)
            oprot.writeString(self.type.encode('utf-8') if sys.version_info[0] == 2 else self.type)
            oprot.writeFieldEnd()
        if self.image is not None:
            oprot.writeFieldBegin('image', TType.STRING, 5)
            oprot.writeString(self.image.encode('utf-8') if sys.version_info[0] == 2 else self.image)
            oprot.writeFieldEnd()
        if self.novelChaperList is not None:
            oprot.writeFieldBegin('novelChaperList', TType.LIST, 6)
            oprot.writeListBegin(TType.STRUCT, len(self.novelChaperList))
            for iter6 in self.novelChaperList:
                iter6.write(oprot)
            oprot.writeListEnd()
            oprot.writeFieldEnd()
        oprot.writeFieldStop()
        oprot.writeStructEnd()

    def validate(self):
        return

    def __repr__(self):
        L = ['%s=%r' % (key, value)
             for key, value in self.__dict__.items()]
        return '%s(%s)' % (self.__class__.__name__, ', '.join(L))

    def __eq__(self, other):
        return isinstance(other, self.__class__) and self.__dict__ == other.__dict__

    def __ne__(self, other):
        return not (self == other)


class NovelChapter(object):
    """
    Attributes:
     - novelChapterName
     - novelChapterUrl
    """


    def __init__(self, novelChapterName=None, novelChapterUrl=None,):
        self.novelChapterName = novelChapterName
        self.novelChapterUrl = novelChapterUrl

    def read(self, iprot):
        if iprot._fast_decode is not None and isinstance(iprot.trans, TTransport.CReadableTransport) and self.thrift_spec is not None:
            iprot._fast_decode(self, iprot, [self.__class__, self.thrift_spec])
            return
        iprot.readStructBegin()
        while True:
            (fname, ftype, fid) = iprot.readFieldBegin()
            if ftype == TType.STOP:
                break
            if fid == 1:
                if ftype == TType.STRING:
                    self.novelChapterName = iprot.readString().decode('utf-8') if sys.version_info[0] == 2 else iprot.readString()
                else:
                    iprot.skip(ftype)
            elif fid == 2:
                if ftype == TType.STRING:
                    self.novelChapterUrl = iprot.readString().decode('utf-8') if sys.version_info[0] == 2 else iprot.readString()
                else:
                    iprot.skip(ftype)
            else:
                iprot.skip(ftype)
            iprot.readFieldEnd()
        iprot.readStructEnd()

    def write(self, oprot):
        if oprot._fast_encode is not None and self.thrift_spec is not None:
            oprot.trans.write(oprot._fast_encode(self, [self.__class__, self.thrift_spec]))
            return
        oprot.writeStructBegin('NovelChapter')
        if self.novelChapterName is not None:
            oprot.writeFieldBegin('novelChapterName', TType.STRING, 1)
            oprot.writeString(self.novelChapterName.encode('utf-8') if sys.version_info[0] == 2 else self.novelChapterName)
            oprot.writeFieldEnd()
        if self.novelChapterUrl is not None:
            oprot.writeFieldBegin('novelChapterUrl', TType.STRING, 2)
            oprot.writeString(self.novelChapterUrl.encode('utf-8') if sys.version_info[0] == 2 else self.novelChapterUrl)
            oprot.writeFieldEnd()
        oprot.writeFieldStop()
        oprot.writeStructEnd()

    def validate(self):
        return

    def __repr__(self):
        L = ['%s=%r' % (key, value)
             for key, value in self.__dict__.items()]
        return '%s(%s)' % (self.__class__.__name__, ', '.join(L))

    def __eq__(self, other):
        return isinstance(other, self.__class__) and self.__dict__ == other.__dict__

    def __ne__(self, other):
        return not (self == other)
all_structs.append(NovelChapterContext)
NovelChapterContext.thrift_spec = (
    None,  # 0
    (1, TType.STRING, 'novelName', 'UTF8', None, ),  # 1
    (2, TType.STRING, 'novelChapterName', 'UTF8', None, ),  # 2
    (3, TType.STRING, 'type', 'UTF8', None, ),  # 3
    (4, TType.STRING, 'context', 'UTF8', None, ),  # 4
    (5, TType.STRING, 'lastChapter', 'UTF8', None, ),  # 5
    (6, TType.STRING, 'nextChapter', 'UTF8', None, ),  # 6
)
all_structs.append(Novel)
Novel.thrift_spec = (
    None,  # 0
    (1, TType.STRING, 'novelName', 'UTF8', None, ),  # 1
    (2, TType.STRING, 'introduction', 'UTF8', None, ),  # 2
    (3, TType.STRING, 'author', 'UTF8', None, ),  # 3
    (4, TType.STRING, 'type', 'UTF8', None, ),  # 4
    (5, TType.STRING, 'image', 'UTF8', None, ),  # 5
    (6, TType.LIST, 'novelChaperList', (TType.STRUCT, [NovelChapter, None], False), None, ),  # 6
)
all_structs.append(NovelChapter)
NovelChapter.thrift_spec = (
    None,  # 0
    (1, TType.STRING, 'novelChapterName', 'UTF8', None, ),  # 1
    (2, TType.STRING, 'novelChapterUrl', 'UTF8', None, ),  # 2
)
fix_spec(all_structs)
del all_structs
