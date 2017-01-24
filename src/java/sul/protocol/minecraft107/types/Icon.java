/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft107.xml
 */
package sul.protocol.minecraft107.types;

import sul.utils.*;

public class Icon extends Packet {

	// direction and type
	public static final byte WHITE_ARROW = 0;
	public static final byte GREEN_ARROW = 1;
	public static final byte RED_ARROW = 2;
	public static final byte BLUE_ARROW = 3;
	public static final byte WHITE_CROSS = 4;
	public static final byte RED_POINTER = 5;
	public static final byte WHITE_CIRCLE = 6;

	public byte directionAndType;
	public Tuples.ByteXZ position;

	public Icon() {}

	public Icon(byte directionAndType, Tuples.ByteXZ position) {
		this.directionAndType = directionAndType;
		this.position = position;
	}

	@Override
	public int length() {
		return 3;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(directionAndType);
		this.writeBigEndianByte(position.x); this.writeBigEndianByte(position.z);
		return this._buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		directionAndType=readBigEndianByte();
		position.x=readBigEndianByte(); position.z=readBigEndianByte();
	}


}
