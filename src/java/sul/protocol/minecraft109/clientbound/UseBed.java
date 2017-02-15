/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft109.xml
 */
package sul.protocol.minecraft109.clientbound;

import sul.utils.*;

public class UseBed extends Packet {

	public static final int ID = (int)47;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	public int entityId;
	public long position;

	public UseBed() {}

	public UseBed(int entityId, long position) {
		this.entityId = entityId;
		this.position = position;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(ID) + Buffer.varuintLength(entityId) + 8;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeVaruint(entityId);
		this.writeBigEndianLong(position);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		entityId=this.readVaruint();
		position=readBigEndianLong();
	}

	public static UseBed fromBuffer(byte[] buffer) {
		UseBed ret = new UseBed();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "UseBed(entityId: " + this.entityId + ", position: " + this.position + ")";
	}

}
