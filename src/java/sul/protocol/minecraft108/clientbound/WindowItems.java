/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft108.xml
 */
package sul.protocol.minecraft108.clientbound;

import java.util.Arrays;

import sul.utils.*;

public class WindowItems extends Packet {

	public static final int ID = (int)20;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	public byte window;
	public sul.protocol.minecraft108.types.Slot[] slots;

	public WindowItems() {}

	public WindowItems(byte window, sul.protocol.minecraft108.types.Slot[] slots) {
		this.window = window;
		this.slots = slots;
	}

	@Override
	public int length() {
		int length=Buffer.varuintLength(ID) + 3; for(sul.protocol.minecraft108.types.Slot c2xvdhm:slots){ length+=c2xvdhm.length(); } return length;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeBigEndianByte(window);
		this.writeBigEndianShort((short)slots.length); for(sul.protocol.minecraft108.types.Slot c2xvdhm:slots){ this.writeBytes(c2xvdhm.encode()); }
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		window=readBigEndianByte();
		int bhnsb3rz=readBigEndianShort(); slots=new sul.protocol.minecraft108.types.Slot[bhnsb3rz]; for(int c2xvdhm=0;c2xvdhm<slots.length;c2xvdhm++){ slots[c2xvdhm]=new sul.protocol.minecraft108.types.Slot(); slots[c2xvdhm]._index=this._index; slots[c2xvdhm].decode(this._buffer); this._index=slots[c2xvdhm]._index; }
	}

	public static WindowItems fromBuffer(byte[] buffer) {
		WindowItems ret = new WindowItems();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "WindowItems(window: " + this.window + ", slots: " + Arrays.deepToString(this.slots) + ")";
	}

}
