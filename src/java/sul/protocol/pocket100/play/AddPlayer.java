/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket100.xml
 */
package sul.protocol.pocket100.play;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

import sul.utils.*;

public class AddPlayer extends Packet {

	public static final byte ID = (byte)13;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	public UUID uuid;
	public String username;
	public long entityId;
	public long runtimeId;
	public Tuples.FloatXYZ position;
	public Tuples.FloatXYZ motion;
	public float pitch;
	public float headYaw;
	public float yaw;
	public sul.protocol.pocket100.types.Slot heldItem;
	public sul.metadata.Pocket100 metadata;

	public AddPlayer() {}

	public AddPlayer(UUID uuid, String username, long entityId, long runtimeId, Tuples.FloatXYZ position, Tuples.FloatXYZ motion, float pitch, float headYaw, float yaw, sul.protocol.pocket100.types.Slot heldItem, sul.metadata.Pocket100 metadata) {
		this.uuid = uuid;
		this.username = username;
		this.entityId = entityId;
		this.runtimeId = runtimeId;
		this.position = position;
		this.motion = motion;
		this.pitch = pitch;
		this.headYaw = headYaw;
		this.yaw = yaw;
		this.heldItem = heldItem;
		this.metadata = metadata;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(username.getBytes(StandardCharsets.UTF_8).length) + username.getBytes(StandardCharsets.UTF_8).length + Buffer.varlongLength(entityId) + Buffer.varlongLength(runtimeId) + heldItem.length() + metadata.length() + 53;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeBigEndianLong(uuid.getLeastSignificantBits()); this.writeBigEndianLong(uuid.getMostSignificantBits());
		byte[] dxnlcm5hbwu=username.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)dxnlcm5hbwu.length); this.writeBytes(dxnlcm5hbwu);
		this.writeVarlong(entityId);
		this.writeVarlong(runtimeId);
		this.writeLittleEndianFloat(position.x); this.writeLittleEndianFloat(position.y); this.writeLittleEndianFloat(position.z);
		this.writeLittleEndianFloat(motion.x); this.writeLittleEndianFloat(motion.y); this.writeLittleEndianFloat(motion.z);
		this.writeLittleEndianFloat(pitch);
		this.writeLittleEndianFloat(headYaw);
		this.writeLittleEndianFloat(yaw);
		this.writeBytes(heldItem.encode());
		this.writeBytes(metadata.encode());
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		long bxv1awq=readBigEndianLong(); long bhv1awq=readBigEndianLong(); uuid=new UUID(bxv1awq,bhv1awq);
		int bgvudxnlcm5hbwu=this.readVaruint(); username=new String(this.readBytes(bgvudxnlcm5hbwu), StandardCharsets.UTF_8);
		entityId=this.readVarlong();
		runtimeId=this.readVarlong();
		position.x=readLittleEndianFloat(); position.y=readLittleEndianFloat(); position.z=readLittleEndianFloat();
		motion.x=readLittleEndianFloat(); motion.y=readLittleEndianFloat(); motion.z=readLittleEndianFloat();
		pitch=readLittleEndianFloat();
		headYaw=readLittleEndianFloat();
		yaw=readLittleEndianFloat();
		heldItem=new sul.protocol.pocket100.types.Slot(); heldItem._index=this._index; heldItem.decode(this._buffer); this._index=heldItem._index;
		metadata=new sul.metadata.Pocket100(); metadata._index=this._index; metadata.decode(this._buffer); this._index=metadata._index;
	}

	public static AddPlayer fromBuffer(byte[] buffer) {
		AddPlayer ret = new AddPlayer();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "AddPlayer(uuid: " + this.uuid.toString() + ", username: " + this.username + ", entityId: " + this.entityId + ", runtimeId: " + this.runtimeId + ", position: " + this.position.toString() + ", motion: " + this.motion.toString() + ", pitch: " + this.pitch + ", headYaw: " + this.headYaw + ", yaw: " + this.yaw + ", heldItem: " + this.heldItem.toString() + ", metadata: " + this.metadata.toString() + ")";
	}

}
