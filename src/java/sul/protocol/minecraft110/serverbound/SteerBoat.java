/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft110.xml
 */
package sul.protocol.minecraft110.serverbound;

import sul.utils.*;

public class SteerBoat extends Packet {

	public static final int ID = (int)17;

	public static final boolean CLIENTBOUND = false;
	public static final boolean SERVERBOUND = true;

	public boolean rightPaddleTurning;
	public boolean leftPaddleTurning;

	public SteerBoat() {}

	public SteerBoat(boolean rightPaddleTurning, boolean leftPaddleTurning) {
		this.rightPaddleTurning = rightPaddleTurning;
		this.leftPaddleTurning = leftPaddleTurning;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(ID) + 2;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeBool(rightPaddleTurning);
		this.writeBool(leftPaddleTurning);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		rightPaddleTurning=this.readBool();
		leftPaddleTurning=this.readBool();
	}

	public static SteerBoat fromBuffer(byte[] buffer) {
		SteerBoat ret = new SteerBoat();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "SteerBoat(rightPaddleTurning: " + this.rightPaddleTurning + ", leftPaddleTurning: " + this.leftPaddleTurning + ")";
	}

}
