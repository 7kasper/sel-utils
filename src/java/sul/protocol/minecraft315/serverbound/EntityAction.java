/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft315.xml
 */
package sul.protocol.minecraft315.serverbound;

import sul.utils.*;

public class EntityAction extends Packet {

	public static final int ID = (int)20;

	public static final boolean CLIENTBOUND = false;
	public static final boolean SERVERBOUND = true;

	@Override
	public int getId() {
		return ID;
	}

	// action
	public static final int START_SNEAKING = 0;
	public static final int STOP_SNEAKING = 1;
	public static final int LEAVE_BED = 2;
	public static final int START_SPRINTING = 3;
	public static final int STOP_SPRINTING = 4;
	public static final int START_HORSE_JUMP = 5;
	public static final int STOP_HORSE_JUMP = 6;
	public static final int OPEN_HORSE_INVENTORY = 7;
	public static final int START_ELYTRA_FLYING = 8;

	public int entityId;
	public int action;
	public int jumpBoost;

	public EntityAction() {}

	public EntityAction(int entityId, int action, int jumpBoost) {
		this.entityId = entityId;
		this.action = action;
		this.jumpBoost = jumpBoost;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(ID) + Buffer.varuintLength(entityId) + Buffer.varuintLength(action) + Buffer.varuintLength(jumpBoost);
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeVaruint(entityId);
		this.writeVaruint(action);
		if(action==5){ this.writeVaruint(jumpBoost); }
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		entityId=this.readVaruint();
		action=this.readVaruint();
		if(action==5){ jumpBoost=this.readVaruint(); }
	}

	public static EntityAction fromBuffer(byte[] buffer) {
		EntityAction ret = new EntityAction();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "EntityAction(entityId: " + this.entityId + ", action: " + this.action + ", jumpBoost: " + this.jumpBoost + ")";
	}

}
