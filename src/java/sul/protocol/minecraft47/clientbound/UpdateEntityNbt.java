/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft47.xml
 */
package sul.protocol.minecraft47.clientbound;

import java.util.Arrays;

import sul.utils.*;

public class UpdateEntityNbt extends Packet {

	public static final int ID = (int)73;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	public int entityId;
	public byte[] nbt;

	public UpdateEntityNbt() {}

	public UpdateEntityNbt(int entityId, byte[] nbt) {
		this.entityId = entityId;
		this.nbt = nbt;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(ID) + Buffer.varuintLength(entityId) + nbt.length;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeVaruint(entityId);
		this.writeBytes(nbt);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		entityId=this.readVaruint();
		nbt=this.readBytes(this._buffer.length-this._index);
	}

	public static UpdateEntityNbt fromBuffer(byte[] buffer) {
		UpdateEntityNbt ret = new UpdateEntityNbt();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "UpdateEntityNbt(entityId: " + this.entityId + ", nbt: " + Arrays.toString(this.nbt) + ")";
	}

}
