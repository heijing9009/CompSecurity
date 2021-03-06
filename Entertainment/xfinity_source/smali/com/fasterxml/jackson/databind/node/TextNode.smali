.class public final Lcom/fasterxml/jackson/databind/node/TextNode;
.super Lcom/fasterxml/jackson/databind/node/ValueNode;
.source "TextNode.java"


# static fields
.field static final EMPTY_STRING_NODE:Lcom/fasterxml/jackson/databind/node/TextNode;

.field static final INT_SPACE:I = 0x20


# instance fields
.field final _value:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 20
    new-instance v0, Lcom/fasterxml/jackson/databind/node/TextNode;

    const-string v1, ""

    invoke-direct {v0, v1}, Lcom/fasterxml/jackson/databind/node/TextNode;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/fasterxml/jackson/databind/node/TextNode;->EMPTY_STRING_NODE:Lcom/fasterxml/jackson/databind/node/TextNode;

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "v"    # Ljava/lang/String;

    .prologue
    .line 24
    invoke-direct {p0}, Lcom/fasterxml/jackson/databind/node/ValueNode;-><init>()V

    iput-object p1, p0, Lcom/fasterxml/jackson/databind/node/TextNode;->_value:Ljava/lang/String;

    return-void
.end method

.method protected static appendQuoted(Ljava/lang/StringBuilder;Ljava/lang/String;)V
    .locals 1
    .param p0, "sb"    # Ljava/lang/StringBuilder;
    .param p1, "content"    # Ljava/lang/String;

    .prologue
    const/16 v0, 0x22

    .line 254
    invoke-virtual {p0, v0}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 255
    invoke-static {p0, p1}, Lcom/fasterxml/jackson/core/io/CharTypes;->appendQuoted(Ljava/lang/StringBuilder;Ljava/lang/String;)V

    .line 256
    invoke-virtual {p0, v0}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 257
    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/fasterxml/jackson/databind/node/TextNode;
    .locals 1
    .param p0, "v"    # Ljava/lang/String;

    .prologue
    .line 37
    if-nez p0, :cond_0

    .line 38
    const/4 v0, 0x0

    .line 43
    :goto_0
    return-object v0

    .line 40
    :cond_0
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v0

    if-nez v0, :cond_1

    .line 41
    sget-object v0, Lcom/fasterxml/jackson/databind/node/TextNode;->EMPTY_STRING_NODE:Lcom/fasterxml/jackson/databind/node/TextNode;

    goto :goto_0

    .line 43
    :cond_1
    new-instance v0, Lcom/fasterxml/jackson/databind/node/TextNode;

    invoke-direct {v0, p0}, Lcom/fasterxml/jackson/databind/node/TextNode;-><init>(Ljava/lang/String;)V

    goto :goto_0
.end method


# virtual methods
.method protected _reportBase64EOF()V
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/fasterxml/jackson/core/JsonParseException;
        }
    .end annotation

    .prologue
    .line 298
    new-instance v0, Lcom/fasterxml/jackson/core/JsonParseException;

    const-string v1, "Unexpected end-of-String when base64 content"

    sget-object v2, Lcom/fasterxml/jackson/core/JsonLocation;->NA:Lcom/fasterxml/jackson/core/JsonLocation;

    invoke-direct {v0, v1, v2}, Lcom/fasterxml/jackson/core/JsonParseException;-><init>(Ljava/lang/String;Lcom/fasterxml/jackson/core/JsonLocation;)V

    throw v0
.end method

.method protected _reportInvalidBase64(Lcom/fasterxml/jackson/core/Base64Variant;CI)V
    .locals 1
    .param p1, "b64variant"    # Lcom/fasterxml/jackson/core/Base64Variant;
    .param p2, "ch"    # C
    .param p3, "bindex"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/fasterxml/jackson/core/JsonParseException;
        }
    .end annotation

    .prologue
    .line 268
    const/4 v0, 0x0

    invoke-virtual {p0, p1, p2, p3, v0}, Lcom/fasterxml/jackson/databind/node/TextNode;->_reportInvalidBase64(Lcom/fasterxml/jackson/core/Base64Variant;CILjava/lang/String;)V

    .line 269
    return-void
.end method

.method protected _reportInvalidBase64(Lcom/fasterxml/jackson/core/Base64Variant;CILjava/lang/String;)V
    .locals 3
    .param p1, "b64variant"    # Lcom/fasterxml/jackson/core/Base64Variant;
    .param p2, "ch"    # C
    .param p3, "bindex"    # I
    .param p4, "msg"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/fasterxml/jackson/core/JsonParseException;
        }
    .end annotation

    .prologue
    .line 279
    const/16 v1, 0x20

    if-gt p2, v1, :cond_1

    .line 280
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Illegal white space character (code 0x"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-static {p2}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ") as character #"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    add-int/lit8 v2, p3, 0x1

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " of 4-char base64 unit: can only used between units"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 289
    .local v0, "base":Ljava/lang/String;
    :goto_0
    if-eqz p4, :cond_0

    .line 290
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ": "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 292
    :cond_0
    new-instance v1, Lcom/fasterxml/jackson/core/JsonParseException;

    sget-object v2, Lcom/fasterxml/jackson/core/JsonLocation;->NA:Lcom/fasterxml/jackson/core/JsonLocation;

    invoke-direct {v1, v0, v2}, Lcom/fasterxml/jackson/core/JsonParseException;-><init>(Ljava/lang/String;Lcom/fasterxml/jackson/core/JsonLocation;)V

    throw v1

    .line 281
    .end local v0    # "base":Ljava/lang/String;
    :cond_1
    invoke-virtual {p1, p2}, Lcom/fasterxml/jackson/core/Base64Variant;->usesPaddingChar(C)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 282
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Unexpected padding character (\'"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/Base64Variant;->getPaddingChar()C

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\') as character #"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    add-int/lit8 v2, p3, 0x1

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " of 4-char base64 unit: padding only legal as 3rd or 4th character"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .restart local v0    # "base":Ljava/lang/String;
    goto :goto_0

    .line 283
    .end local v0    # "base":Ljava/lang/String;
    :cond_2
    invoke-static {p2}, Ljava/lang/Character;->isDefined(C)Z

    move-result v1

    if-eqz v1, :cond_3

    invoke-static {p2}, Ljava/lang/Character;->isISOControl(C)Z

    move-result v1

    if-eqz v1, :cond_4

    .line 285
    :cond_3
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Illegal character (code 0x"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-static {p2}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ") in base64 content"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .restart local v0    # "base":Ljava/lang/String;
    goto :goto_0

    .line 287
    .end local v0    # "base":Ljava/lang/String;
    :cond_4
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Illegal character \'"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\' (code 0x"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-static {p2}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ") in base64 content"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .restart local v0    # "base":Ljava/lang/String;
    goto/16 :goto_0
.end method

.method public asBoolean(Z)Z
    .locals 2
    .param p1, "defaultValue"    # Z

    .prologue
    .line 179
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/node/TextNode;->_value:Ljava/lang/String;

    if-eqz v0, :cond_0

    .line 180
    const-string v0, "true"

    iget-object v1, p0, Lcom/fasterxml/jackson/databind/node/TextNode;->_value:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 181
    const/4 p1, 0x1

    .line 184
    .end local p1    # "defaultValue":Z
    :cond_0
    return p1
.end method

.method public asDouble(D)D
    .locals 3
    .param p1, "defaultValue"    # D

    .prologue
    .line 199
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/node/TextNode;->_value:Ljava/lang/String;

    invoke-static {v0, p1, p2}, Lcom/fasterxml/jackson/core/io/NumberInput;->parseAsDouble(Ljava/lang/String;D)D

    move-result-wide v0

    return-wide v0
.end method

.method public asInt(I)I
    .locals 1
    .param p1, "defaultValue"    # I

    .prologue
    .line 189
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/node/TextNode;->_value:Ljava/lang/String;

    invoke-static {v0, p1}, Lcom/fasterxml/jackson/core/io/NumberInput;->parseAsInt(Ljava/lang/String;I)I

    move-result v0

    return v0
.end method

.method public asLong(J)J
    .locals 3
    .param p1, "defaultValue"    # J

    .prologue
    .line 194
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/node/TextNode;->_value:Ljava/lang/String;

    invoke-static {v0, p1, p2}, Lcom/fasterxml/jackson/core/io/NumberInput;->parseAsLong(Ljava/lang/String;J)J

    move-result-wide v0

    return-wide v0
.end method

.method public asText()Ljava/lang/String;
    .locals 1

    .prologue
    .line 172
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/node/TextNode;->_value:Ljava/lang/String;

    return-object v0
.end method

.method public asToken()Lcom/fasterxml/jackson/core/JsonToken;
    .locals 1

    .prologue
    .line 46
    sget-object v0, Lcom/fasterxml/jackson/core/JsonToken;->VALUE_STRING:Lcom/fasterxml/jackson/core/JsonToken;

    return-object v0
.end method

.method public binaryValue()[B
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 161
    invoke-static {}, Lcom/fasterxml/jackson/core/Base64Variants;->getDefaultVariant()Lcom/fasterxml/jackson/core/Base64Variant;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/fasterxml/jackson/databind/node/TextNode;->getBinaryValue(Lcom/fasterxml/jackson/core/Base64Variant;)[B

    move-result-object v0

    return-object v0
.end method

.method public equals(Ljava/lang/Object;)Z
    .locals 3
    .param p1, "o"    # Ljava/lang/Object;

    .prologue
    const/4 v0, 0x0

    .line 228
    if-ne p1, p0, :cond_1

    const/4 v0, 0x1

    .line 233
    .end local p1    # "o":Ljava/lang/Object;
    :cond_0
    :goto_0
    return v0

    .line 229
    .restart local p1    # "o":Ljava/lang/Object;
    :cond_1
    if-eqz p1, :cond_0

    .line 230
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    if-ne v1, v2, :cond_0

    .line 233
    check-cast p1, Lcom/fasterxml/jackson/databind/node/TextNode;

    .end local p1    # "o":Ljava/lang/Object;
    iget-object v0, p1, Lcom/fasterxml/jackson/databind/node/TextNode;->_value:Ljava/lang/String;

    iget-object v1, p0, Lcom/fasterxml/jackson/databind/node/TextNode;->_value:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    goto :goto_0
.end method

.method public getBinaryValue(Lcom/fasterxml/jackson/core/Base64Variant;)[B
    .locals 12
    .param p1, "b64variant"    # Lcom/fasterxml/jackson/core/Base64Variant;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v11, 0x3

    const/4 v10, -0x2

    .line 67
    new-instance v1, Lcom/fasterxml/jackson/core/util/ByteArrayBuilder;

    const/16 v8, 0x64

    invoke-direct {v1, v8}, Lcom/fasterxml/jackson/core/util/ByteArrayBuilder;-><init>(I)V

    .line 68
    .local v1, "builder":Lcom/fasterxml/jackson/core/util/ByteArrayBuilder;
    iget-object v7, p0, Lcom/fasterxml/jackson/databind/node/TextNode;->_value:Ljava/lang/String;

    .line 69
    .local v7, "str":Ljava/lang/String;
    const/4 v5, 0x0

    .line 70
    .local v5, "ptr":I
    invoke-virtual {v7}, Ljava/lang/String;->length()I

    move-result v4

    .line 73
    .local v4, "len":I
    :goto_0
    if-ge v5, v4, :cond_0

    .line 77
    :goto_1
    add-int/lit8 v6, v5, 0x1

    .end local v5    # "ptr":I
    .local v6, "ptr":I
    invoke-virtual {v7, v5}, Ljava/lang/String;->charAt(I)C

    move-result v2

    .line 78
    .local v2, "ch":C
    if-lt v6, v4, :cond_1

    move v5, v6

    .line 155
    .end local v2    # "ch":C
    .end local v6    # "ptr":I
    .restart local v5    # "ptr":I
    :cond_0
    :goto_2
    invoke-virtual {v1}, Lcom/fasterxml/jackson/core/util/ByteArrayBuilder;->toByteArray()[B

    move-result-object v8

    return-object v8

    .line 81
    .end local v5    # "ptr":I
    .restart local v2    # "ch":C
    .restart local v6    # "ptr":I
    :cond_1
    const/16 v8, 0x20

    if-le v2, v8, :cond_f

    .line 82
    invoke-virtual {p1, v2}, Lcom/fasterxml/jackson/core/Base64Variant;->decodeBase64Char(C)I

    move-result v0

    .line 83
    .local v0, "bits":I
    if-gez v0, :cond_2

    .line 84
    const/4 v8, 0x0

    invoke-virtual {p0, p1, v2, v8}, Lcom/fasterxml/jackson/databind/node/TextNode;->_reportInvalidBase64(Lcom/fasterxml/jackson/core/Base64Variant;CI)V

    .line 86
    :cond_2
    move v3, v0

    .line 88
    .local v3, "decodedData":I
    if-lt v6, v4, :cond_3

    .line 89
    invoke-virtual {p0}, Lcom/fasterxml/jackson/databind/node/TextNode;->_reportBase64EOF()V

    .line 91
    :cond_3
    add-int/lit8 v5, v6, 0x1

    .end local v6    # "ptr":I
    .restart local v5    # "ptr":I
    invoke-virtual {v7, v6}, Ljava/lang/String;->charAt(I)C

    move-result v2

    .line 92
    invoke-virtual {p1, v2}, Lcom/fasterxml/jackson/core/Base64Variant;->decodeBase64Char(C)I

    move-result v0

    .line 93
    if-gez v0, :cond_4

    .line 94
    const/4 v8, 0x1

    invoke-virtual {p0, p1, v2, v8}, Lcom/fasterxml/jackson/databind/node/TextNode;->_reportInvalidBase64(Lcom/fasterxml/jackson/core/Base64Variant;CI)V

    .line 96
    :cond_4
    shl-int/lit8 v8, v3, 0x6

    or-int v3, v8, v0

    .line 98
    if-lt v5, v4, :cond_6

    .line 100
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/Base64Variant;->usesPadding()Z

    move-result v8

    if-nez v8, :cond_5

    .line 102
    shr-int/lit8 v3, v3, 0x4

    .line 103
    invoke-virtual {v1, v3}, Lcom/fasterxml/jackson/core/util/ByteArrayBuilder;->append(I)V

    goto :goto_2

    .line 106
    :cond_5
    invoke-virtual {p0}, Lcom/fasterxml/jackson/databind/node/TextNode;->_reportBase64EOF()V

    .line 108
    :cond_6
    add-int/lit8 v6, v5, 0x1

    .end local v5    # "ptr":I
    .restart local v6    # "ptr":I
    invoke-virtual {v7, v5}, Ljava/lang/String;->charAt(I)C

    move-result v2

    .line 109
    invoke-virtual {p1, v2}, Lcom/fasterxml/jackson/core/Base64Variant;->decodeBase64Char(C)I

    move-result v0

    .line 112
    if-gez v0, :cond_a

    .line 113
    if-eq v0, v10, :cond_7

    .line 114
    const/4 v8, 0x2

    invoke-virtual {p0, p1, v2, v8}, Lcom/fasterxml/jackson/databind/node/TextNode;->_reportInvalidBase64(Lcom/fasterxml/jackson/core/Base64Variant;CI)V

    .line 117
    :cond_7
    if-lt v6, v4, :cond_8

    .line 118
    invoke-virtual {p0}, Lcom/fasterxml/jackson/databind/node/TextNode;->_reportBase64EOF()V

    .line 120
    :cond_8
    add-int/lit8 v5, v6, 0x1

    .end local v6    # "ptr":I
    .restart local v5    # "ptr":I
    invoke-virtual {v7, v6}, Ljava/lang/String;->charAt(I)C

    move-result v2

    .line 121
    invoke-virtual {p1, v2}, Lcom/fasterxml/jackson/core/Base64Variant;->usesPaddingChar(C)Z

    move-result v8

    if-nez v8, :cond_9

    .line 122
    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "expected padding character \'"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/Base64Variant;->getPaddingChar()C

    move-result v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string v9, "\'"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {p0, p1, v2, v11, v8}, Lcom/fasterxml/jackson/databind/node/TextNode;->_reportInvalidBase64(Lcom/fasterxml/jackson/core/Base64Variant;CILjava/lang/String;)V

    .line 125
    :cond_9
    shr-int/lit8 v3, v3, 0x4

    .line 126
    invoke-virtual {v1, v3}, Lcom/fasterxml/jackson/core/util/ByteArrayBuilder;->append(I)V

    goto/16 :goto_0

    .line 130
    .end local v5    # "ptr":I
    .restart local v6    # "ptr":I
    :cond_a
    shl-int/lit8 v8, v3, 0x6

    or-int v3, v8, v0

    .line 132
    if-lt v6, v4, :cond_c

    .line 134
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/Base64Variant;->usesPadding()Z

    move-result v8

    if-nez v8, :cond_b

    .line 135
    shr-int/lit8 v3, v3, 0x2

    .line 136
    invoke-virtual {v1, v3}, Lcom/fasterxml/jackson/core/util/ByteArrayBuilder;->appendTwoBytes(I)V

    move v5, v6

    .line 137
    .end local v6    # "ptr":I
    .restart local v5    # "ptr":I
    goto/16 :goto_2

    .line 139
    .end local v5    # "ptr":I
    .restart local v6    # "ptr":I
    :cond_b
    invoke-virtual {p0}, Lcom/fasterxml/jackson/databind/node/TextNode;->_reportBase64EOF()V

    .line 141
    :cond_c
    add-int/lit8 v5, v6, 0x1

    .end local v6    # "ptr":I
    .restart local v5    # "ptr":I
    invoke-virtual {v7, v6}, Ljava/lang/String;->charAt(I)C

    move-result v2

    .line 142
    invoke-virtual {p1, v2}, Lcom/fasterxml/jackson/core/Base64Variant;->decodeBase64Char(C)I

    move-result v0

    .line 143
    if-gez v0, :cond_e

    .line 144
    if-eq v0, v10, :cond_d

    .line 145
    invoke-virtual {p0, p1, v2, v11}, Lcom/fasterxml/jackson/databind/node/TextNode;->_reportInvalidBase64(Lcom/fasterxml/jackson/core/Base64Variant;CI)V

    .line 147
    :cond_d
    shr-int/lit8 v3, v3, 0x2

    .line 148
    invoke-virtual {v1, v3}, Lcom/fasterxml/jackson/core/util/ByteArrayBuilder;->appendTwoBytes(I)V

    goto/16 :goto_0

    .line 151
    :cond_e
    shl-int/lit8 v8, v3, 0x6

    or-int v3, v8, v0

    .line 152
    invoke-virtual {v1, v3}, Lcom/fasterxml/jackson/core/util/ByteArrayBuilder;->appendThreeBytes(I)V

    goto/16 :goto_0

    .end local v0    # "bits":I
    .end local v3    # "decodedData":I
    .end local v5    # "ptr":I
    .restart local v6    # "ptr":I
    :cond_f
    move v5, v6

    .end local v6    # "ptr":I
    .restart local v5    # "ptr":I
    goto/16 :goto_1
.end method

.method public hashCode()I
    .locals 1

    .prologue
    .line 237
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/node/TextNode;->_value:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    move-result v0

    return v0
.end method

.method public isTextual()Z
    .locals 1

    .prologue
    .line 52
    const/4 v0, 0x1

    return v0
.end method

.method public final serialize(Lcom/fasterxml/jackson/core/JsonGenerator;Lcom/fasterxml/jackson/databind/SerializerProvider;)V
    .locals 1
    .param p1, "jg"    # Lcom/fasterxml/jackson/core/JsonGenerator;
    .param p2, "provider"    # Lcom/fasterxml/jackson/databind/SerializerProvider;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/fasterxml/jackson/core/JsonProcessingException;
        }
    .end annotation

    .prologue
    .line 212
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/node/TextNode;->_value:Ljava/lang/String;

    if-nez v0, :cond_0

    .line 213
    invoke-virtual {p1}, Lcom/fasterxml/jackson/core/JsonGenerator;->writeNull()V

    .line 217
    :goto_0
    return-void

    .line 215
    :cond_0
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/node/TextNode;->_value:Ljava/lang/String;

    invoke-virtual {p1, v0}, Lcom/fasterxml/jackson/core/JsonGenerator;->writeString(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public textValue()Ljava/lang/String;
    .locals 1

    .prologue
    .line 56
    iget-object v0, p0, Lcom/fasterxml/jackson/databind/node/TextNode;->_value:Ljava/lang/String;

    return-object v0
.end method

.method public toString()Ljava/lang/String;
    .locals 4

    .prologue
    .line 245
    iget-object v2, p0, Lcom/fasterxml/jackson/databind/node/TextNode;->_value:Ljava/lang/String;

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v0

    .line 246
    .local v0, "len":I
    add-int/lit8 v2, v0, 0x2

    shr-int/lit8 v3, v0, 0x4

    add-int v0, v2, v3

    .line 247
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1, v0}, Ljava/lang/StringBuilder;-><init>(I)V

    .line 248
    .local v1, "sb":Ljava/lang/StringBuilder;
    iget-object v2, p0, Lcom/fasterxml/jackson/databind/node/TextNode;->_value:Ljava/lang/String;

    invoke-static {v1, v2}, Lcom/fasterxml/jackson/databind/node/TextNode;->appendQuoted(Ljava/lang/StringBuilder;Ljava/lang/String;)V

    .line 249
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    return-object v2
.end method
