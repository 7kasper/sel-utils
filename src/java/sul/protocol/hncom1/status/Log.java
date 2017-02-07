/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/hncom1.xml
 */
package sul.protocol.hncom1.status;

import java.nio.charset.StandardCharsets;

import sul.utils.*;

/**
 * Sends a log to the hub.
 */
public class Log extends Packet {

	public static final byte ID = (byte)10;

	public static final boolean CLIENTBOUND = false;
	public static final boolean SERVERBOUND = true;

	/**
	 * Unix time (in milliseconds) that indicates the exact creation time of the log.
	 */
	public long timestamp;

	/**
	 * Name of the logger (world, plugin or module/packet) thas has generated the log.
	 */
	public String logger;

	/**
	 * Logged message. It may contain Minecraft formatting codes.
	 */
	public String message;

	/**
	 * Identifier of the command that has generated the output or -1 if the log wasn't
	 * generated by a command.
	 */
	public int commandId;

	public Log() {}

	public Log(long timestamp, String logger, String message, int commandId) {
		this.timestamp = timestamp;
		this.logger = logger;
		this.message = message;
		this.commandId = commandId;
	}

	@Override
	public int length() {
		return Buffer.varulongLength(timestamp) + Buffer.varuintLength(logger.getBytes(StandardCharsets.UTF_8).length) + logger.getBytes(StandardCharsets.UTF_8).length + Buffer.varuintLength(message.getBytes(StandardCharsets.UTF_8).length) + message.getBytes(StandardCharsets.UTF_8).length + Buffer.varintLength(commandId) + 1;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeVarulong(timestamp);
		byte[] bg9nz2vy=logger.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)bg9nz2vy.length); this.writeBytes(bg9nz2vy);
		byte[] bwvzc2fnzq=message.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)bwvzc2fnzq.length); this.writeBytes(bwvzc2fnzq);
		this.writeVarint(commandId);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		timestamp=this.readVarulong();
		int bgvubg9nz2vy=this.readVaruint(); logger=new String(this.readBytes(bgvubg9nz2vy), StandardCharsets.UTF_8);
		int bgvubwvzc2fnzq=this.readVaruint(); message=new String(this.readBytes(bgvubwvzc2fnzq), StandardCharsets.UTF_8);
		commandId=this.readVarint();
	}

	public static Log fromBuffer(byte[] buffer) {
		Log ret = new Log();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "Log(timestamp: " + this.timestamp + ", logger: " + this.logger + ", message: " + this.message + ", commandId: " + this.commandId + ")";
	}

}
