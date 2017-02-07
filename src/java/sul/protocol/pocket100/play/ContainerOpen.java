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

public class ContainerOpen extends Packet {

	public static final byte ID = (byte)48;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	public byte window;
	public byte type;
	public int slotCount;
	public sul.protocol.pocket100.types.BlockPosition position;
	public long entityId;

	public ContainerOpen() {}

	public ContainerOpen(byte window, byte type, int slotCount, sul.protocol.pocket100.types.BlockPosition position, long entityId) {
		this.window = window;
		this.type = type;
		this.slotCount = slotCount;
		this.position = position;
		this.entityId = entityId;
	}

	@Override
	public int length() {
		return Buffer.varintLength(slotCount) + position.length() + Buffer.varlongLength(entityId) + 3;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeBigEndianByte(window);
		this.writeBigEndianByte(type);
		this.writeVarint(slotCount);
		this.writeBytes(position.encode());
		this.writeVarlong(entityId);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		window=readBigEndianByte();
		type=readBigEndianByte();
		slotCount=this.readVarint();
		position=new sul.protocol.pocket100.types.BlockPosition(); position._index=this._index; position.decode(this._buffer); this._index=position._index;
		entityId=this.readVarlong();
	}

	public static ContainerOpen fromBuffer(byte[] buffer) {
		ContainerOpen ret = new ContainerOpen();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "ContainerOpen(window: " + this.window + ", type: " + this.type + ", slotCount: " + this.slotCount + ", position: " + this.position.toString() + ", entityId: " + this.entityId + ")";
	}

}
