/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket101.xml
 */
package sul.protocol.pocket101.play;

import sul.utils.*;

public class ContainerSetData extends Packet {

	public static final byte ID = (byte)51;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	public byte window;
	public int property;
	public int value;

	public ContainerSetData() {}

	public ContainerSetData(byte window, int property, int value) {
		this.window = window;
		this.property = property;
		this.value = value;
	}

	@Override
	public int length() {
		return Buffer.varintLength(property) + Buffer.varintLength(value) + 2;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeBigEndianByte(window);
		this.writeVarint(property);
		this.writeVarint(value);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		window=readBigEndianByte();
		property=this.readVarint();
		value=this.readVarint();
	}

	public static ContainerSetData fromBuffer(byte[] buffer) {
		ContainerSetData ret = new ContainerSetData();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "ContainerSetData(window: " + this.window + ", property: " + this.property + ", value: " + this.value + ")";
	}

}
