/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft210.xml
 */
package sul.protocol.minecraft210.clientbound;

import sul.utils.*;

public class EntityTeleport extends Packet {

	public static final int ID = (int)73;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	public int entityId;
	public Tuples.DoubleXYZ position;
	public byte yaw;
	public byte pitch;
	public boolean onGround;

	public EntityTeleport() {}

	public EntityTeleport(int entityId, Tuples.DoubleXYZ position, byte yaw, byte pitch, boolean onGround) {
		this.entityId = entityId;
		this.position = position;
		this.yaw = yaw;
		this.pitch = pitch;
		this.onGround = onGround;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(ID) + Buffer.varuintLength(entityId) + 27;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeVaruint(entityId);
		this.writeBigEndianDouble(position.x); this.writeBigEndianDouble(position.y); this.writeBigEndianDouble(position.z);
		this.writeBigEndianByte(yaw);
		this.writeBigEndianByte(pitch);
		this.writeBool(onGround);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		entityId=this.readVaruint();
		position=new Tuples.DoubleXYZ(); position.x=readBigEndianDouble(); position.y=readBigEndianDouble(); position.z=readBigEndianDouble();
		yaw=readBigEndianByte();
		pitch=readBigEndianByte();
		onGround=this.readBool();
	}

	public static EntityTeleport fromBuffer(byte[] buffer) {
		EntityTeleport ret = new EntityTeleport();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "EntityTeleport(entityId: " + this.entityId + ", position: " + this.position.toString() + ", yaw: " + this.yaw + ", pitch: " + this.pitch + ", onGround: " + this.onGround + ")";
	}

}
