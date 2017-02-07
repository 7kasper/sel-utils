/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft109.xml
 */
module sul.protocol.minecraft109.status;

import std.bitmanip : write, peek;
static import std.conv;
import std.system : Endian;
import std.typetuple : TypeTuple;
import std.typecons : Tuple;
import std.uuid : UUID;

import sul.utils.buffer;
import sul.utils.var;

static import sul.protocol.minecraft109.types;

alias Packets = TypeTuple!(Handshake, Request, Response, Latency);

class Handshake : Buffer {

	public enum uint ID = 0;

	public enum bool CLIENTBOUND = false;
	public enum bool SERVERBOUND = true;

	// next
	public enum uint STATUS = 1;
	public enum uint LOGIN = 2;

	public enum string[] FIELDS = ["protocol", "serverAddress", "serverPort", "next"];

	public uint protocol;
	public string serverAddress;
	public ushort serverPort;
	public uint next;

	public pure nothrow @safe @nogc this() {}

	public pure nothrow @safe @nogc this(uint protocol, string serverAddress=string.init, ushort serverPort=ushort.init, uint next=uint.init) {
		this.protocol = protocol;
		this.serverAddress = serverAddress;
		this.serverPort = serverPort;
		this.next = next;
	}

	public pure nothrow @safe ubyte[] encode(bool writeId=true)() {
		_buffer.length = 0;
		static if(writeId){ writeBytes(varuint.encode(ID)); }
		writeBytes(varuint.encode(protocol));
		writeBytes(varuint.encode(cast(uint)serverAddress.length)); writeString(serverAddress);
		writeBigEndianUshort(serverPort);
		writeBytes(varuint.encode(next));
		return _buffer;
	}

	public pure nothrow @safe void decode(bool readId=true)() {
		static if(readId){ uint _id; _id=varuint.decode(_buffer, &_index); }
		protocol=varuint.decode(_buffer, &_index);
		uint c2vydmvyqwrkcmvz=varuint.decode(_buffer, &_index); serverAddress=readString(c2vydmvyqwrkcmvz);
		serverPort=readBigEndianUshort();
		next=varuint.decode(_buffer, &_index);
	}

	public static pure nothrow @safe Handshake fromBuffer(bool readId=true)(ubyte[] buffer) {
		Handshake ret = new Handshake();
		ret._buffer = buffer;
		ret.decode!readId();
		return ret;
	}

	public override string toString() {
		return "Handshake(protocol: " ~ std.conv.to!string(this.protocol) ~ ", serverAddress: " ~ std.conv.to!string(this.serverAddress) ~ ", serverPort: " ~ std.conv.to!string(this.serverPort) ~ ", next: " ~ std.conv.to!string(this.next) ~ ")";
	}

}

class Request : Buffer {

	public enum uint ID = 0;

	public enum bool CLIENTBOUND = false;
	public enum bool SERVERBOUND = true;

	public enum string[] FIELDS = [];

	public pure nothrow @safe ubyte[] encode(bool writeId=true)() {
		_buffer.length = 0;
		static if(writeId){ writeBytes(varuint.encode(ID)); }
		return _buffer;
	}

	public pure nothrow @safe void decode(bool readId=true)() {
		static if(readId){ uint _id; _id=varuint.decode(_buffer, &_index); }
	}

	public static pure nothrow @safe Request fromBuffer(bool readId=true)(ubyte[] buffer) {
		Request ret = new Request();
		ret._buffer = buffer;
		ret.decode!readId();
		return ret;
	}

	public override string toString() {
		return "Request()";
	}

}

class Response : Buffer {

	public enum uint ID = 0;

	public enum bool CLIENTBOUND = true;
	public enum bool SERVERBOUND = false;

	public enum string[] FIELDS = ["json"];

	public string json;

	public pure nothrow @safe @nogc this() {}

	public pure nothrow @safe @nogc this(string json) {
		this.json = json;
	}

	public pure nothrow @safe ubyte[] encode(bool writeId=true)() {
		_buffer.length = 0;
		static if(writeId){ writeBytes(varuint.encode(ID)); }
		writeBytes(varuint.encode(cast(uint)json.length)); writeString(json);
		return _buffer;
	}

	public pure nothrow @safe void decode(bool readId=true)() {
		static if(readId){ uint _id; _id=varuint.decode(_buffer, &_index); }
		uint annvbg=varuint.decode(_buffer, &_index); json=readString(annvbg);
	}

	public static pure nothrow @safe Response fromBuffer(bool readId=true)(ubyte[] buffer) {
		Response ret = new Response();
		ret._buffer = buffer;
		ret.decode!readId();
		return ret;
	}

	public override string toString() {
		return "Response(json: " ~ std.conv.to!string(this.json) ~ ")";
	}

}

class Latency : Buffer {

	public enum uint ID = 1;

	public enum bool CLIENTBOUND = true;
	public enum bool SERVERBOUND = true;

	public enum string[] FIELDS = ["id"];

	public long id;

	public pure nothrow @safe @nogc this() {}

	public pure nothrow @safe @nogc this(long id) {
		this.id = id;
	}

	public pure nothrow @safe ubyte[] encode(bool writeId=true)() {
		_buffer.length = 0;
		static if(writeId){ writeBytes(varuint.encode(ID)); }
		writeBigEndianLong(id);
		return _buffer;
	}

	public pure nothrow @safe void decode(bool readId=true)() {
		static if(readId){ uint _id; _id=varuint.decode(_buffer, &_index); }
		id=readBigEndianLong();
	}

	public static pure nothrow @safe Latency fromBuffer(bool readId=true)(ubyte[] buffer) {
		Latency ret = new Latency();
		ret._buffer = buffer;
		ret.decode!readId();
		return ret;
	}

	public override string toString() {
		return "Latency(id: " ~ std.conv.to!string(this.id) ~ ")";
	}

}
