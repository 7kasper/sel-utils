/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket100.xml
 */
package sul.protocol.pocket100.play;

import sul.utils.*;

public class SetEntityLink extends Packet {

	public static final byte ID = (byte)41;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	// action
	public static final byte ADD = 0;
	public static final byte RIDE = 1;
	public static final byte REMOVE = 2;

	public long from;
	public long to;
	public byte action;

	public SetEntityLink() {}

	public SetEntityLink(long from, long to, byte action) {
		this.from = from;
		this.to = to;
		this.action = action;
	}

	@Override
	public int length() {
		return Buffer.varlongLength(from) + Buffer.varlongLength(to) + 2;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeVarlong(from);
		this.writeVarlong(to);
		this.writeBigEndianByte(action);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		from=this.readVarlong();
		to=this.readVarlong();
		action=readBigEndianByte();
	}

	public static SetEntityLink fromBuffer(byte[] buffer) {
		SetEntityLink ret = new SetEntityLink();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "SetEntityLink(from: " + this.from + ", to: " + this.to + ", action: " + this.action + ")";
	}

}
