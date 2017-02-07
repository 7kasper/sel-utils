/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft110.xml
 */
module sul.protocol.minecraft110.login;

import std.bitmanip : write, peek;
static import std.conv;
import std.system : Endian;
import std.typetuple : TypeTuple;
import std.typecons : Tuple;
import std.uuid : UUID;

import sul.utils.buffer;
import sul.utils.var;

static import sul.protocol.minecraft110.types;

alias Packets = TypeTuple!(Disconnect, LoginStart, EncryptionRequest, EncryptionResponse, LoginSuccess, SetCompression);

class Disconnect : Buffer {

	public enum uint ID = 0;

	public enum bool CLIENTBOUND = true;
	public enum bool SERVERBOUND = false;

	public enum string[] FIELDS = ["reason"];

	public string reason;

	public pure nothrow @safe @nogc this() {}

	public pure nothrow @safe @nogc this(string reason) {
		this.reason = reason;
	}

	public pure nothrow @safe ubyte[] encode(bool writeId=true)() {
		_buffer.length = 0;
		static if(writeId){ writeBytes(varuint.encode(ID)); }
		writeBytes(varuint.encode(cast(uint)reason.length)); writeString(reason);
		return _buffer;
	}

	public pure nothrow @safe void decode(bool readId=true)() {
		static if(readId){ uint _id; _id=varuint.decode(_buffer, &_index); }
		uint cmvhc29u=varuint.decode(_buffer, &_index); reason=readString(cmvhc29u);
	}

	public static pure nothrow @safe Disconnect fromBuffer(bool readId=true)(ubyte[] buffer) {
		Disconnect ret = new Disconnect();
		ret._buffer = buffer;
		ret.decode!readId();
		return ret;
	}

	public override string toString() {
		return "Disconnect(reason: " ~ std.conv.to!string(this.reason) ~ ")";
	}

}

class LoginStart : Buffer {

	public enum uint ID = 0;

	public enum bool CLIENTBOUND = false;
	public enum bool SERVERBOUND = true;

	public enum string[] FIELDS = ["username"];

	public string username;

	public pure nothrow @safe @nogc this() {}

	public pure nothrow @safe @nogc this(string username) {
		this.username = username;
	}

	public pure nothrow @safe ubyte[] encode(bool writeId=true)() {
		_buffer.length = 0;
		static if(writeId){ writeBytes(varuint.encode(ID)); }
		writeBytes(varuint.encode(cast(uint)username.length)); writeString(username);
		return _buffer;
	}

	public pure nothrow @safe void decode(bool readId=true)() {
		static if(readId){ uint _id; _id=varuint.decode(_buffer, &_index); }
		uint dxnlcm5hbwu=varuint.decode(_buffer, &_index); username=readString(dxnlcm5hbwu);
	}

	public static pure nothrow @safe LoginStart fromBuffer(bool readId=true)(ubyte[] buffer) {
		LoginStart ret = new LoginStart();
		ret._buffer = buffer;
		ret.decode!readId();
		return ret;
	}

	public override string toString() {
		return "LoginStart(username: " ~ std.conv.to!string(this.username) ~ ")";
	}

}

class EncryptionRequest : Buffer {

	public enum uint ID = 1;

	public enum bool CLIENTBOUND = true;
	public enum bool SERVERBOUND = false;

	public enum string[] FIELDS = ["serverId", "publicKey", "verifyToken"];

	public string serverId;
	public ubyte[] publicKey;
	public ubyte[] verifyToken;

	public pure nothrow @safe @nogc this() {}

	public pure nothrow @safe @nogc this(string serverId, ubyte[] publicKey=(ubyte[]).init, ubyte[] verifyToken=(ubyte[]).init) {
		this.serverId = serverId;
		this.publicKey = publicKey;
		this.verifyToken = verifyToken;
	}

	public pure nothrow @safe ubyte[] encode(bool writeId=true)() {
		_buffer.length = 0;
		static if(writeId){ writeBytes(varuint.encode(ID)); }
		writeBytes(varuint.encode(cast(uint)serverId.length)); writeString(serverId);
		writeBytes(varuint.encode(cast(uint)publicKey.length)); writeBytes(publicKey);
		writeBytes(varuint.encode(cast(uint)verifyToken.length)); writeBytes(verifyToken);
		return _buffer;
	}

	public pure nothrow @safe void decode(bool readId=true)() {
		static if(readId){ uint _id; _id=varuint.decode(_buffer, &_index); }
		uint c2vydmvyswq=varuint.decode(_buffer, &_index); serverId=readString(c2vydmvyswq);
		publicKey.length=varuint.decode(_buffer, &_index); if(_buffer.length>=_index+publicKey.length){ publicKey=_buffer[_index.._index+publicKey.length].dup; _index+=publicKey.length; }
		verifyToken.length=varuint.decode(_buffer, &_index); if(_buffer.length>=_index+verifyToken.length){ verifyToken=_buffer[_index.._index+verifyToken.length].dup; _index+=verifyToken.length; }
	}

	public static pure nothrow @safe EncryptionRequest fromBuffer(bool readId=true)(ubyte[] buffer) {
		EncryptionRequest ret = new EncryptionRequest();
		ret._buffer = buffer;
		ret.decode!readId();
		return ret;
	}

	public override string toString() {
		return "EncryptionRequest(serverId: " ~ std.conv.to!string(this.serverId) ~ ", publicKey: " ~ std.conv.to!string(this.publicKey) ~ ", verifyToken: " ~ std.conv.to!string(this.verifyToken) ~ ")";
	}

}

class EncryptionResponse : Buffer {

	public enum uint ID = 1;

	public enum bool CLIENTBOUND = false;
	public enum bool SERVERBOUND = true;

	public enum string[] FIELDS = ["sharedSecret", "verifyToken"];

	public ubyte[] sharedSecret;
	public ubyte[] verifyToken;

	public pure nothrow @safe @nogc this() {}

	public pure nothrow @safe @nogc this(ubyte[] sharedSecret, ubyte[] verifyToken=(ubyte[]).init) {
		this.sharedSecret = sharedSecret;
		this.verifyToken = verifyToken;
	}

	public pure nothrow @safe ubyte[] encode(bool writeId=true)() {
		_buffer.length = 0;
		static if(writeId){ writeBytes(varuint.encode(ID)); }
		writeBytes(varuint.encode(cast(uint)sharedSecret.length)); writeBytes(sharedSecret);
		writeBytes(varuint.encode(cast(uint)verifyToken.length)); writeBytes(verifyToken);
		return _buffer;
	}

	public pure nothrow @safe void decode(bool readId=true)() {
		static if(readId){ uint _id; _id=varuint.decode(_buffer, &_index); }
		sharedSecret.length=varuint.decode(_buffer, &_index); if(_buffer.length>=_index+sharedSecret.length){ sharedSecret=_buffer[_index.._index+sharedSecret.length].dup; _index+=sharedSecret.length; }
		verifyToken.length=varuint.decode(_buffer, &_index); if(_buffer.length>=_index+verifyToken.length){ verifyToken=_buffer[_index.._index+verifyToken.length].dup; _index+=verifyToken.length; }
	}

	public static pure nothrow @safe EncryptionResponse fromBuffer(bool readId=true)(ubyte[] buffer) {
		EncryptionResponse ret = new EncryptionResponse();
		ret._buffer = buffer;
		ret.decode!readId();
		return ret;
	}

	public override string toString() {
		return "EncryptionResponse(sharedSecret: " ~ std.conv.to!string(this.sharedSecret) ~ ", verifyToken: " ~ std.conv.to!string(this.verifyToken) ~ ")";
	}

}

class LoginSuccess : Buffer {

	public enum uint ID = 2;

	public enum bool CLIENTBOUND = true;
	public enum bool SERVERBOUND = false;

	public enum string[] FIELDS = ["uuid", "username"];

	public string uuid;
	public string username;

	public pure nothrow @safe @nogc this() {}

	public pure nothrow @safe @nogc this(string uuid, string username=string.init) {
		this.uuid = uuid;
		this.username = username;
	}

	public pure nothrow @safe ubyte[] encode(bool writeId=true)() {
		_buffer.length = 0;
		static if(writeId){ writeBytes(varuint.encode(ID)); }
		writeBytes(varuint.encode(cast(uint)uuid.length)); writeString(uuid);
		writeBytes(varuint.encode(cast(uint)username.length)); writeString(username);
		return _buffer;
	}

	public pure nothrow @safe void decode(bool readId=true)() {
		static if(readId){ uint _id; _id=varuint.decode(_buffer, &_index); }
		uint dxvpza=varuint.decode(_buffer, &_index); uuid=readString(dxvpza);
		uint dxnlcm5hbwu=varuint.decode(_buffer, &_index); username=readString(dxnlcm5hbwu);
	}

	public static pure nothrow @safe LoginSuccess fromBuffer(bool readId=true)(ubyte[] buffer) {
		LoginSuccess ret = new LoginSuccess();
		ret._buffer = buffer;
		ret.decode!readId();
		return ret;
	}

	public override string toString() {
		return "LoginSuccess(uuid: " ~ std.conv.to!string(this.uuid) ~ ", username: " ~ std.conv.to!string(this.username) ~ ")";
	}

}

class SetCompression : Buffer {

	public enum uint ID = 3;

	public enum bool CLIENTBOUND = true;
	public enum bool SERVERBOUND = false;

	public enum string[] FIELDS = ["thresold"];

	public uint thresold;

	public pure nothrow @safe @nogc this() {}

	public pure nothrow @safe @nogc this(uint thresold) {
		this.thresold = thresold;
	}

	public pure nothrow @safe ubyte[] encode(bool writeId=true)() {
		_buffer.length = 0;
		static if(writeId){ writeBytes(varuint.encode(ID)); }
		writeBytes(varuint.encode(thresold));
		return _buffer;
	}

	public pure nothrow @safe void decode(bool readId=true)() {
		static if(readId){ uint _id; _id=varuint.decode(_buffer, &_index); }
		thresold=varuint.decode(_buffer, &_index);
	}

	public static pure nothrow @safe SetCompression fromBuffer(bool readId=true)(ubyte[] buffer) {
		SetCompression ret = new SetCompression();
		ret._buffer = buffer;
		ret.decode!readId();
		return ret;
	}

	public override string toString() {
		return "SetCompression(thresold: " ~ std.conv.to!string(this.thresold) ~ ")";
	}

}
