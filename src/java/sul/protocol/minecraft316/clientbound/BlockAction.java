/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft316.xml
 */
package sul.protocol.minecraft316.clientbound;

import sul.utils.*;

public class BlockAction extends Packet {

	public static final int ID = (int)10;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	// action
	public static final byte NOTE_BLOCK_HARP = 0;
	public static final byte NOTE_BLOCK_BASS_DRUM = 1;
	public static final byte NOTE_BLOCK_SNARE_DRUM = 2;
	public static final byte NOTE_BLOCK_CLICKS = 3;
	public static final byte NOTE_BLOCK_STICKS = 3;
	public static final byte NOTE_BLOCK_BASS_GUITAR = 4;
	public static final byte PISTON_EXTEND = 0;
	public static final byte PISTON_RETRACT = 1;
	public static final byte CHEST_WATCHERS = 1;
	public static final byte BEACON_RECALCULATE = 1;
	public static final byte MOB_SPAWNER_RESET_DELAY = 1;
	public static final byte END_GATEWAY_YELLOW_BEAM = 1;

	// parameter
	public static final byte PISTON_DOWN = 0;
	public static final byte PISTON_UP = 1;
	public static final byte PISTON_SOUTH = 2;
	public static final byte PISTON_WEST = 3;
	public static final byte PISTON_NORTH = 4;
	public static final byte PISTON_EAST = 5;

	public long position;
	public byte action;
	public byte parameter;
	public int blockType;

	public BlockAction() {}

	public BlockAction(long position, byte action, byte parameter, int blockType) {
		this.position = position;
		this.action = action;
		this.parameter = parameter;
		this.blockType = blockType;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(ID) + Buffer.varuintLength(blockType) + 10;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeBigEndianLong(position);
		this.writeBigEndianByte(action);
		this.writeBigEndianByte(parameter);
		this.writeVaruint(blockType);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		position=readBigEndianLong();
		action=readBigEndianByte();
		parameter=readBigEndianByte();
		blockType=this.readVaruint();
	}

	public static BlockAction fromBuffer(byte[] buffer) {
		BlockAction ret = new BlockAction();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "BlockAction(position: " + this.position + ", action: " + this.action + ", parameter: " + this.parameter + ", blockType: " + this.blockType + ")";
	}

}
