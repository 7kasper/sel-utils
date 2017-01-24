/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft210.xml
 */
package sul.protocol.minecraft210.serverbound;

import sul.utils.*;

public class ConfirmTransaction extends Packet {

	public static final int ID = (int)5;

	public static final boolean CLIENTBOUND = false;
	public static final boolean SERVERBOUND = true;

	public byte window;
	public short action;
	public boolean accepted;

	public ConfirmTransaction() {}

	public ConfirmTransaction(byte window, short action, boolean accepted) {
		this.window = window;
		this.action = action;
		this.accepted = accepted;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(ID) + 4;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeBigEndianByte(window);
		this.writeBigEndianShort(action);
		this._buffer[this._index++]=(byte)(accepted?1:0);
		return this._buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		window=readBigEndianByte();
		action=readBigEndianShort();
		accepted=this._index<this._buffer.length&&this._buffer[this._index++]!=0;
	}

	public static ConfirmTransaction fromBuffer(byte[] buffer) {
		ConfirmTransaction ret = new ConfirmTransaction();
		ret.decode(buffer);
		return ret;
	}

}
