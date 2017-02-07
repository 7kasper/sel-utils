/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/hncom1.xml
 */
/**
 * Node-related packets and updates.
 */
module sul.protocol.hncom1.status;

import std.bitmanip : write, peek;
static import std.conv;
import std.system : Endian;
import std.typetuple : TypeTuple;
import std.typecons : Tuple;
import std.uuid : UUID;

import sul.utils.buffer;
import sul.utils.var;

static import sul.protocol.hncom1.types;

alias Packets = TypeTuple!(AddNode, RemoveNode, MessageServerbound, MessageClientbound, Players, ResourcesUsage, Log, RemoteCommand, UpdateList, Reload);

/**
 * Notifies the node that another node (that is not itelf) has connected to the hub.
 */
class AddNode : Buffer {

	public enum ubyte ID = 4;

	public enum bool CLIENTBOUND = true;
	public enum bool SERVERBOUND = false;

	public enum string[] FIELDS = ["hubId", "name", "main", "acceptedGames"];

	/**
	 * Identifier given by the hub to uniquey identify the node.
	 */
	public uint hubId;

	/**
	 * Node's name used for displaying and identification purposes.
	 */
	public string name;

	/**
	 * Whether the node is a main node (see ConnectionRequest.main).
	 */
	public bool main;

	/**
	 * Indicates the game accepted by the node.
	 */
	public sul.protocol.hncom1.types.Game[] acceptedGames;

	public pure nothrow @safe @nogc this() {}

	public pure nothrow @safe @nogc this(uint hubId, string name=string.init, bool main=bool.init, sul.protocol.hncom1.types.Game[] acceptedGames=(sul.protocol.hncom1.types.Game[]).init) {
		this.hubId = hubId;
		this.name = name;
		this.main = main;
		this.acceptedGames = acceptedGames;
	}

	public pure nothrow @safe ubyte[] encode(bool writeId=true)() {
		_buffer.length = 0;
		static if(writeId){ writeBigEndianUbyte(ID); }
		writeBytes(varuint.encode(hubId));
		writeBytes(varuint.encode(cast(uint)name.length)); writeString(name);
		writeBigEndianBool(main);
		writeBytes(varuint.encode(cast(uint)acceptedGames.length)); foreach(ywnjzxb0zwrhyw1l;acceptedGames){ ywnjzxb0zwrhyw1l.encode(bufferInstance); }
		return _buffer;
	}

	public pure nothrow @safe void decode(bool readId=true)() {
		static if(readId){ ubyte _id; _id=readBigEndianUbyte(); }
		hubId=varuint.decode(_buffer, &_index);
		uint bmftzq=varuint.decode(_buffer, &_index); name=readString(bmftzq);
		main=readBigEndianBool();
		acceptedGames.length=varuint.decode(_buffer, &_index); foreach(ref ywnjzxb0zwrhyw1l;acceptedGames){ ywnjzxb0zwrhyw1l.decode(bufferInstance); }
	}

	public static pure nothrow @safe AddNode fromBuffer(bool readId=true)(ubyte[] buffer) {
		AddNode ret = new AddNode();
		ret._buffer = buffer;
		ret.decode!readId();
		return ret;
	}

	public override string toString() {
		return "AddNode(hubId: " ~ std.conv.to!string(this.hubId) ~ ", name: " ~ std.conv.to!string(this.name) ~ ", main: " ~ std.conv.to!string(this.main) ~ ", acceptedGames: " ~ std.conv.to!string(this.acceptedGames) ~ ")";
	}

}

/**
 * Notifies the node that another node, previously added with AddNode has disconnected
 * from the hub.
 */
class RemoveNode : Buffer {

	public enum ubyte ID = 5;

	public enum bool CLIENTBOUND = true;
	public enum bool SERVERBOUND = false;

	public enum string[] FIELDS = ["hubId"];

	/**
	 * Node's id given by the hub.
	 */
	public uint hubId;

	public pure nothrow @safe @nogc this() {}

	public pure nothrow @safe @nogc this(uint hubId) {
		this.hubId = hubId;
	}

	public pure nothrow @safe ubyte[] encode(bool writeId=true)() {
		_buffer.length = 0;
		static if(writeId){ writeBigEndianUbyte(ID); }
		writeBytes(varuint.encode(hubId));
		return _buffer;
	}

	public pure nothrow @safe void decode(bool readId=true)() {
		static if(readId){ ubyte _id; _id=readBigEndianUbyte(); }
		hubId=varuint.decode(_buffer, &_index);
	}

	public static pure nothrow @safe RemoveNode fromBuffer(bool readId=true)(ubyte[] buffer) {
		RemoveNode ret = new RemoveNode();
		ret._buffer = buffer;
		ret.decode!readId();
		return ret;
	}

	public override string toString() {
		return "RemoveNode(hubId: " ~ std.conv.to!string(this.hubId) ~ ")";
	}

}

/**
 * Sends a binary message to some selected nodes or broadcast it.
 */
class MessageServerbound : Buffer {

	public enum ubyte ID = 6;

	public enum bool CLIENTBOUND = false;
	public enum bool SERVERBOUND = true;

	public enum string[] FIELDS = ["addressees", "payload"];

	/**
	 * Addressees of the message. If the array is empty the message is broadcasted to every
	 * connected node.
	 */
	public uint[] addressees;

	/**
	 * Bytes to be sent/broadcasted. It may be a serialised packet of a plugin-defined
	 * protocol.
	 */
	public ubyte[] payload;

	public pure nothrow @safe @nogc this() {}

	public pure nothrow @safe @nogc this(uint[] addressees, ubyte[] payload=(ubyte[]).init) {
		this.addressees = addressees;
		this.payload = payload;
	}

	public pure nothrow @safe ubyte[] encode(bool writeId=true)() {
		_buffer.length = 0;
		static if(writeId){ writeBigEndianUbyte(ID); }
		writeBytes(varuint.encode(cast(uint)addressees.length)); foreach(ywrkcmvzc2vlcw;addressees){ writeBytes(varuint.encode(ywrkcmvzc2vlcw)); }
		writeBytes(varuint.encode(cast(uint)payload.length)); writeBytes(payload);
		return _buffer;
	}

	public pure nothrow @safe void decode(bool readId=true)() {
		static if(readId){ ubyte _id; _id=readBigEndianUbyte(); }
		addressees.length=varuint.decode(_buffer, &_index); foreach(ref ywrkcmvzc2vlcw;addressees){ ywrkcmvzc2vlcw=varuint.decode(_buffer, &_index); }
		payload.length=varuint.decode(_buffer, &_index); if(_buffer.length>=_index+payload.length){ payload=_buffer[_index.._index+payload.length].dup; _index+=payload.length; }
	}

	public static pure nothrow @safe MessageServerbound fromBuffer(bool readId=true)(ubyte[] buffer) {
		MessageServerbound ret = new MessageServerbound();
		ret._buffer = buffer;
		ret.decode!readId();
		return ret;
	}

	public override string toString() {
		return "MessageServerbound(addressees: " ~ std.conv.to!string(this.addressees) ~ ", payload: " ~ std.conv.to!string(this.payload) ~ ")";
	}

}

/**
 * Receives a binary message sent by another node using MessageServerbound.
 */
class MessageClientbound : Buffer {

	public enum ubyte ID = 7;

	public enum bool CLIENTBOUND = true;
	public enum bool SERVERBOUND = false;

	public enum string[] FIELDS = ["sender", "payload"];

	/**
	 * Id of the node that has sent the message.
	 */
	public uint sender;

	/**
	 * Bytes received. It could be a serialised packet of a plugin-defined packet.
	 */
	public ubyte[] payload;

	public pure nothrow @safe @nogc this() {}

	public pure nothrow @safe @nogc this(uint sender, ubyte[] payload=(ubyte[]).init) {
		this.sender = sender;
		this.payload = payload;
	}

	public pure nothrow @safe ubyte[] encode(bool writeId=true)() {
		_buffer.length = 0;
		static if(writeId){ writeBigEndianUbyte(ID); }
		writeBytes(varuint.encode(sender));
		writeBytes(varuint.encode(cast(uint)payload.length)); writeBytes(payload);
		return _buffer;
	}

	public pure nothrow @safe void decode(bool readId=true)() {
		static if(readId){ ubyte _id; _id=readBigEndianUbyte(); }
		sender=varuint.decode(_buffer, &_index);
		payload.length=varuint.decode(_buffer, &_index); if(_buffer.length>=_index+payload.length){ payload=_buffer[_index.._index+payload.length].dup; _index+=payload.length; }
	}

	public static pure nothrow @safe MessageClientbound fromBuffer(bool readId=true)(ubyte[] buffer) {
		MessageClientbound ret = new MessageClientbound();
		ret._buffer = buffer;
		ret.decode!readId();
		return ret;
	}

	public override string toString() {
		return "MessageClientbound(sender: " ~ std.conv.to!string(this.sender) ~ ", payload: " ~ std.conv.to!string(this.payload) ~ ")";
	}

}

/**
 * Updates the number of players on the server.
 */
class Players : Buffer {

	public enum ubyte ID = 8;

	public enum bool CLIENTBOUND = true;
	public enum bool SERVERBOUND = false;

	// max
	public enum int UNLIMITED = -1;

	public enum string[] FIELDS = ["online", "max"];

	/**
	 * Players currently online in the whole server (connected to a node).
	 */
	public uint online;

	/**
	 * Maximum number of players that can connect to server.
	 */
	public int max;

	public pure nothrow @safe @nogc this() {}

	public pure nothrow @safe @nogc this(uint online, int max=int.init) {
		this.online = online;
		this.max = max;
	}

	public pure nothrow @safe ubyte[] encode(bool writeId=true)() {
		_buffer.length = 0;
		static if(writeId){ writeBigEndianUbyte(ID); }
		writeBytes(varuint.encode(online));
		writeBytes(varint.encode(max));
		return _buffer;
	}

	public pure nothrow @safe void decode(bool readId=true)() {
		static if(readId){ ubyte _id; _id=readBigEndianUbyte(); }
		online=varuint.decode(_buffer, &_index);
		max=varint.decode(_buffer, &_index);
	}

	public static pure nothrow @safe Players fromBuffer(bool readId=true)(ubyte[] buffer) {
		Players ret = new Players();
		ret._buffer = buffer;
		ret.decode!readId();
		return ret;
	}

	public override string toString() {
		return "Players(online: " ~ std.conv.to!string(this.online) ~ ", max: " ~ std.conv.to!string(this.max) ~ ")";
	}

}

/**
 * Updates the usage of the system's resources of the node.
 */
class ResourcesUsage : Buffer {

	public enum ubyte ID = 9;

	public enum bool CLIENTBOUND = false;
	public enum bool SERVERBOUND = true;

	public enum string[] FIELDS = ["tps", "ram", "cpu"];

	/**
	 * Ticks per second of the node, in the range 0 to 20, where a number lower than 20
	 * indicates lag.
	 */
	public float tps;

	/**
	 * RAM used by the node in bytes.
	 */
	public ulong ram;

	/**
	 * Percentage of CPU used by the node. It may be higher than 100 if the node has more
	 * than 1 CPU.
	 */
	public float cpu;

	public pure nothrow @safe @nogc this() {}

	public pure nothrow @safe @nogc this(float tps, ulong ram=ulong.init, float cpu=float.init) {
		this.tps = tps;
		this.ram = ram;
		this.cpu = cpu;
	}

	public pure nothrow @safe ubyte[] encode(bool writeId=true)() {
		_buffer.length = 0;
		static if(writeId){ writeBigEndianUbyte(ID); }
		writeBigEndianFloat(tps);
		writeBytes(varulong.encode(ram));
		writeBigEndianFloat(cpu);
		return _buffer;
	}

	public pure nothrow @safe void decode(bool readId=true)() {
		static if(readId){ ubyte _id; _id=readBigEndianUbyte(); }
		tps=readBigEndianFloat();
		ram=varulong.decode(_buffer, &_index);
		cpu=readBigEndianFloat();
	}

	public static pure nothrow @safe ResourcesUsage fromBuffer(bool readId=true)(ubyte[] buffer) {
		ResourcesUsage ret = new ResourcesUsage();
		ret._buffer = buffer;
		ret.decode!readId();
		return ret;
	}

	public override string toString() {
		return "ResourcesUsage(tps: " ~ std.conv.to!string(this.tps) ~ ", ram: " ~ std.conv.to!string(this.ram) ~ ", cpu: " ~ std.conv.to!string(this.cpu) ~ ")";
	}

}

/**
 * Sends a log to the hub.
 */
class Log : Buffer {

	public enum ubyte ID = 10;

	public enum bool CLIENTBOUND = false;
	public enum bool SERVERBOUND = true;

	public enum string[] FIELDS = ["timestamp", "logger", "message", "commandId"];

	/**
	 * Unix time (in milliseconds) that indicates the exact creation time of the log.
	 */
	public ulong timestamp;

	/**
	 * Name of the logger (world, plugin or module/packet) thas has generated the log.
	 */
	public string logger;

	/**
	 * Logged message. It may contain Minecraft formatting codes.
	 */
	public string message;

	/**
	 * Identifier of the command that has generated the output or -1 if the log wasn't
	 * generated by a command.
	 */
	public int commandId;

	public pure nothrow @safe @nogc this() {}

	public pure nothrow @safe @nogc this(ulong timestamp, string logger=string.init, string message=string.init, int commandId=int.init) {
		this.timestamp = timestamp;
		this.logger = logger;
		this.message = message;
		this.commandId = commandId;
	}

	public pure nothrow @safe ubyte[] encode(bool writeId=true)() {
		_buffer.length = 0;
		static if(writeId){ writeBigEndianUbyte(ID); }
		writeBytes(varulong.encode(timestamp));
		writeBytes(varuint.encode(cast(uint)logger.length)); writeString(logger);
		writeBytes(varuint.encode(cast(uint)message.length)); writeString(message);
		writeBytes(varint.encode(commandId));
		return _buffer;
	}

	public pure nothrow @safe void decode(bool readId=true)() {
		static if(readId){ ubyte _id; _id=readBigEndianUbyte(); }
		timestamp=varulong.decode(_buffer, &_index);
		uint bg9nz2vy=varuint.decode(_buffer, &_index); logger=readString(bg9nz2vy);
		uint bwvzc2fnzq=varuint.decode(_buffer, &_index); message=readString(bwvzc2fnzq);
		commandId=varint.decode(_buffer, &_index);
	}

	public static pure nothrow @safe Log fromBuffer(bool readId=true)(ubyte[] buffer) {
		Log ret = new Log();
		ret._buffer = buffer;
		ret.decode!readId();
		return ret;
	}

	public override string toString() {
		return "Log(timestamp: " ~ std.conv.to!string(this.timestamp) ~ ", logger: " ~ std.conv.to!string(this.logger) ~ ", message: " ~ std.conv.to!string(this.message) ~ ", commandId: " ~ std.conv.to!string(this.commandId) ~ ")";
	}

}

/**
 * Executes a command on the node.
 */
class RemoteCommand : Buffer {

	public enum ubyte ID = 11;

	public enum bool CLIENTBOUND = true;
	public enum bool SERVERBOUND = false;

	// origin
	public enum ubyte HUB = 0;
	public enum ubyte EXTERNAL_CONSOLE = 1;
	public enum ubyte RCON = 2;

	public enum string[] FIELDS = ["origin", "sender", "command", "commandId"];

	/**
	 * Origin of the command. It could be the hub itself or an external source.
	 */
	public ubyte origin;

	/**
	 * Address of the sender if the command has been sent from an external source and not
	 * the hub.
	 */
	public sul.protocol.hncom1.types.Address sender;

	/**
	 * Commands and arguments that should be executed on the node. For example `say hello
	 * world` or `transfer steve lobby12`.
	 */
	public string command;

	/**
	 * Identifier of the command. It's sent in Log.commandId if the command generates an
	 * output.
	 */
	public int commandId;

	public pure nothrow @safe @nogc this() {}

	public pure nothrow @safe @nogc this(ubyte origin, sul.protocol.hncom1.types.Address sender=sul.protocol.hncom1.types.Address.init, string command=string.init, int commandId=int.init) {
		this.origin = origin;
		this.sender = sender;
		this.command = command;
		this.commandId = commandId;
	}

	public pure nothrow @safe ubyte[] encode(bool writeId=true)() {
		_buffer.length = 0;
		static if(writeId){ writeBigEndianUbyte(ID); }
		writeBigEndianUbyte(origin);
		if(origin!=0){ sender.encode(bufferInstance); }
		writeBytes(varuint.encode(cast(uint)command.length)); writeString(command);
		writeBytes(varint.encode(commandId));
		return _buffer;
	}

	public pure nothrow @safe void decode(bool readId=true)() {
		static if(readId){ ubyte _id; _id=readBigEndianUbyte(); }
		origin=readBigEndianUbyte();
		if(origin!=0){ sender.decode(bufferInstance); }
		uint y29tbwfuza=varuint.decode(_buffer, &_index); command=readString(y29tbwfuza);
		commandId=varint.decode(_buffer, &_index);
	}

	public static pure nothrow @safe RemoteCommand fromBuffer(bool readId=true)(ubyte[] buffer) {
		RemoteCommand ret = new RemoteCommand();
		ret._buffer = buffer;
		ret.decode!readId();
		return ret;
	}

	public override string toString() {
		return "RemoteCommand(origin: " ~ std.conv.to!string(this.origin) ~ ", sender: " ~ std.conv.to!string(this.sender) ~ ", command: " ~ std.conv.to!string(this.command) ~ ", commandId: " ~ std.conv.to!string(this.commandId) ~ ")";
	}

}

/**
 * Updates a list.
 */
class UpdateList : Buffer {

	public enum ubyte ID = 12;

	public enum bool CLIENTBOUND = false;
	public enum bool SERVERBOUND = true;

	// list
	public enum ubyte WHITELIST = 0;
	public enum ubyte BLACKLIST = 1;

	// action
	public enum ubyte ADD = 0;
	public enum ubyte REMOVE = 1;

	public enum string[] FIELDS = ["list", "action", "type"];

	/**
	 * Type of the list to update.
	 */
	public ubyte list;
	public ubyte action;
	public ubyte type;

	public pure nothrow @safe @nogc this() {}

	public pure nothrow @safe @nogc this(ubyte list, ubyte action=ubyte.init, ubyte type=ubyte.init) {
		this.list = list;
		this.action = action;
		this.type = type;
	}

	public pure nothrow @safe ubyte[] encode(bool writeId=true)() {
		_buffer.length = 0;
		static if(writeId){ writeBigEndianUbyte(ID); }
		writeBigEndianUbyte(list);
		writeBigEndianUbyte(action);
		writeBigEndianUbyte(type);
		return _buffer;
	}

	public pure nothrow @safe void decode(bool readId=true)() {
		static if(readId){ ubyte _id; _id=readBigEndianUbyte(); }
		list=readBigEndianUbyte();
		action=readBigEndianUbyte();
		type=readBigEndianUbyte();
	}

	public static pure nothrow @safe UpdateList fromBuffer(bool readId=true)(ubyte[] buffer) {
		UpdateList ret = new UpdateList();
		ret._buffer = buffer;
		ret.decode!readId();
		return ret;
	}

	public override string toString() {
		return "UpdateList(list: " ~ std.conv.to!string(this.list) ~ ", action: " ~ std.conv.to!string(this.action) ~ ", type: " ~ std.conv.to!string(this.type) ~ ")";
	}

	alias _encode = encode;

	enum string variantField = "type";

	alias Variants = TypeTuple!(ByHubId, ByName, ByUuid);

	public class ByHubId {

		public enum typeof(type) TYPE = 0;

		public enum string[] FIELDS = ["hubId"];

		public uint hubId;

		public pure nothrow @safe @nogc this() {}

		public pure nothrow @safe @nogc this(uint hubId) {
			this.hubId = hubId;
		}

		public pure nothrow @safe ubyte[] encode(bool writeId=true)() {
			type = 0;
			_encode!writeId();
			writeBytes(varuint.encode(hubId));
			return _buffer;
		}

		public pure nothrow @safe void decode() {
			hubId=varuint.decode(_buffer, &_index);
		}

		public override string toString() {
			return "UpdateList.ByHubId(hubId: " ~ std.conv.to!string(this.hubId) ~ ")";
		}

	}

	public class ByName {

		public enum typeof(type) TYPE = 1;

		public enum string[] FIELDS = ["username"];

		public string username;

		public pure nothrow @safe @nogc this() {}

		public pure nothrow @safe @nogc this(string username) {
			this.username = username;
		}

		public pure nothrow @safe ubyte[] encode(bool writeId=true)() {
			type = 1;
			_encode!writeId();
			writeBytes(varuint.encode(cast(uint)username.length)); writeString(username);
			return _buffer;
		}

		public pure nothrow @safe void decode() {
			uint dxnlcm5hbwu=varuint.decode(_buffer, &_index); username=readString(dxnlcm5hbwu);
		}

		public override string toString() {
			return "UpdateList.ByName(username: " ~ std.conv.to!string(this.username) ~ ")";
		}

	}

	public class ByUuid {

		public enum typeof(type) TYPE = 2;

		// game
		public enum ubyte POCKET = 1;
		public enum ubyte MINECRAFT = 2;

		public enum string[] FIELDS = ["game", "uuid"];

		public ubyte game;
		public UUID uuid;

		public pure nothrow @safe @nogc this() {}

		public pure nothrow @safe @nogc this(ubyte game, UUID uuid=UUID.init) {
			this.game = game;
			this.uuid = uuid;
		}

		public pure nothrow @safe ubyte[] encode(bool writeId=true)() {
			type = 2;
			_encode!writeId();
			writeBigEndianUbyte(game);
			writeBytes(uuid.data);
			return _buffer;
		}

		public pure nothrow @safe void decode() {
			game=readBigEndianUbyte();
			if(_buffer.length>=_index+16){ ubyte[16] dxvpza=_buffer[_index.._index+16].dup; _index+=16; uuid=UUID(dxvpza); }
		}

		public override string toString() {
			return "UpdateList.ByUuid(game: " ~ std.conv.to!string(this.game) ~ ", uuid: " ~ std.conv.to!string(this.uuid) ~ ")";
		}

	}

}

/**
 * Notifies the node that the hub's reloadeable settings have been reloaded and that
 * the node should also reload its resources (for example plugin's settings).
 */
class Reload : Buffer {

	public enum ubyte ID = 13;

	public enum bool CLIENTBOUND = true;
	public enum bool SERVERBOUND = false;

	public enum string[] FIELDS = [];

	public pure nothrow @safe ubyte[] encode(bool writeId=true)() {
		_buffer.length = 0;
		static if(writeId){ writeBigEndianUbyte(ID); }
		return _buffer;
	}

	public pure nothrow @safe void decode(bool readId=true)() {
		static if(readId){ ubyte _id; _id=readBigEndianUbyte(); }
	}

	public static pure nothrow @safe Reload fromBuffer(bool readId=true)(ubyte[] buffer) {
		Reload ret = new Reload();
		ret._buffer = buffer;
		ret.decode!readId();
		return ret;
	}

	public override string toString() {
		return "Reload()";
	}

}
