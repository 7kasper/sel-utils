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

public class ItemFrameDropItem extends Packet {

	public static final byte ID = (byte)70;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	public sul.protocol.pocket101.types.BlockPosition position;
	public sul.protocol.pocket101.types.Slot item;

	public ItemFrameDropItem() {}

	public ItemFrameDropItem(sul.protocol.pocket101.types.BlockPosition position, sul.protocol.pocket101.types.Slot item) {
		this.position = position;
		this.item = item;
	}

	@Override
	public int length() {
		return position.length() + item.length() + 1;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeBytes(position.encode());
		this.writeBytes(item.encode());
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		position=new sul.protocol.pocket101.types.BlockPosition(); position._index=this._index; position.decode(this._buffer); this._index=position._index;
		item=new sul.protocol.pocket101.types.Slot(); item._index=this._index; item.decode(this._buffer); this._index=item._index;
	}

	public static ItemFrameDropItem fromBuffer(byte[] buffer) {
		ItemFrameDropItem ret = new ItemFrameDropItem();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "ItemFrameDropItem(position: " + this.position.toString() + ", item: " + this.item.toString() + ")";
	}

}
