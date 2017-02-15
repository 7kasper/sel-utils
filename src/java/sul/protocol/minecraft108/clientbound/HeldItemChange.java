/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft108.xml
 */
package sul.protocol.minecraft108.clientbound;

import sul.utils.*;

public class HeldItemChange extends Packet {

	public static final int ID = (int)55;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	public byte slot;

	public HeldItemChange() {}

	public HeldItemChange(byte slot) {
		this.slot = slot;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(ID) + 1;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeBigEndianByte(slot);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		slot=readBigEndianByte();
	}

	public static HeldItemChange fromBuffer(byte[] buffer) {
		HeldItemChange ret = new HeldItemChange();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "HeldItemChange(slot: " + this.slot + ")";
	}

}
