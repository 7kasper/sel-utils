/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket100.xml
 */
package sul.protocol.pocket100.play;

import java.nio.charset.StandardCharsets;

import sul.utils.*;

public class AvailableCommands extends Packet {

	public static final byte ID = (byte)77;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	public String commands;

	public AvailableCommands() {}

	public AvailableCommands(String commands) {
		this.commands = commands;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(commands.getBytes(StandardCharsets.UTF_8).length) + commands.getBytes(StandardCharsets.UTF_8).length + 1;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		byte[] y29tbwfuzhm=commands.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)y29tbwfuzhm.length); this.writeBytes(y29tbwfuzhm);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		int bgvuy29tbwfuzhm=this.readVaruint(); commands=new String(this.readBytes(bgvuy29tbwfuzhm), StandardCharsets.UTF_8);
	}

	public static AvailableCommands fromBuffer(byte[] buffer) {
		AvailableCommands ret = new AvailableCommands();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "AvailableCommands(commands: " + this.commands + ")";
	}

}
