/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/raknet8.xml
 */
package sul.protocol.raknet8.control;

import sul.utils.*;

public class Encapsulated extends Packet {

	public static final byte ID = (byte)132;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = true;

	public int count;
	public sul.protocol.raknet8.types.Encapsulation encapsulation;

	public Encapsulated() {}

	public Encapsulated(int count, sul.protocol.raknet8.types.Encapsulation encapsulation) {
		this.count = count;
		this.encapsulation = encapsulation;
	}

	@Override
	public int length() {
		return encapsulation.length() + 4;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeLittleEndianTriad(count);
		this.writeBytes(encapsulation.encode());
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		count=readLittleEndianTriad();
		encapsulation=new sul.protocol.raknet8.types.Encapsulation(); encapsulation._index=this._index; encapsulation.decode(this._buffer); this._index=encapsulation._index;
	}

	public static Encapsulated fromBuffer(byte[] buffer) {
		Encapsulated ret = new Encapsulated();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "Encapsulated(count: " + this.count + ", encapsulation: " + this.encapsulation.toString() + ")";
	}

}
