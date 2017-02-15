/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket101.xml
 */
package sul.protocol.pocket101.play;

import sul.utils.*;

public class ReplaceSelectedItem extends Packet {

	public static final byte ID = (byte)71;

	public static final boolean CLIENTBOUND = false;
	public static final boolean SERVERBOUND = true;

	@Override
	public int getId() {
		return ID;
	}

	public sul.protocol.pocket101.types.Slot item;

	public ReplaceSelectedItem() {}

	public ReplaceSelectedItem(sul.protocol.pocket101.types.Slot item) {
		this.item = item;
	}

	@Override
	public int length() {
		return item.length() + 1;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeBytes(item.encode());
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		item=new sul.protocol.pocket101.types.Slot(); item._index=this._index; item.decode(this._buffer); this._index=item._index;
	}

	public static ReplaceSelectedItem fromBuffer(byte[] buffer) {
		ReplaceSelectedItem ret = new ReplaceSelectedItem();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "ReplaceSelectedItem(item: " + this.item.toString() + ")";
	}

}
