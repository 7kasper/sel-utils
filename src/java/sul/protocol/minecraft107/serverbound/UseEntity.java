/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft107.xml
 */
package sul.protocol.minecraft107.serverbound;

import sul.utils.*;

public class UseEntity extends Packet {

	public static final int ID = (int)10;

	public static final boolean CLIENTBOUND = false;
	public static final boolean SERVERBOUND = true;

	// type
	public static final int INTERACT = 0;
	public static final int ATTACK = 1;
	public static final int INTERACT_AT = 2;

	// hand
	public static final int MAIN_HAND = 0;
	public static final int OFF_HAND = 1;

	public int target;
	public int type;
	public Tuples.FloatXYZ targetPosition;
	public int hand;

	public UseEntity() {}

	public UseEntity(int target, int type, Tuples.FloatXYZ targetPosition, int hand) {
		this.target = target;
		this.type = type;
		this.targetPosition = targetPosition;
		this.hand = hand;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(ID) + Buffer.varuintLength(target) + Buffer.varuintLength(type) + Buffer.varuintLength(hand) + 12;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeVaruint(target);
		this.writeVaruint(type);
		if(type==2){ this.writeBigEndianFloat(targetPosition.x); this.writeBigEndianFloat(targetPosition.y); this.writeBigEndianFloat(targetPosition.z); }
		if(type==2){ this.writeVaruint(hand); }
		return this._buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		target=this.readVaruint();
		type=this.readVaruint();
		if(type==2){ targetPosition.x=readBigEndianFloat(); targetPosition.y=readBigEndianFloat(); targetPosition.z=readBigEndianFloat(); }
		if(type==2){ hand=this.readVaruint(); }
	}

	public static UseEntity fromBuffer(byte[] buffer) {
		UseEntity ret = new UseEntity();
		ret.decode(buffer);
		return ret;
	}

}
