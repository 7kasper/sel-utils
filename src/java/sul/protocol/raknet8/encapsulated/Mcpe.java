/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/raknet8.xml
 */
package sul.protocol.raknet8.encapsulated;

import java.util.Arrays;

import sul.utils.*;

public class Mcpe extends Packet {

	public static final byte ID = (byte)254;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = true;

	@Override
	public int getId() {
		return ID;
	}

	public byte[] packet;

	public Mcpe() {}

	public Mcpe(byte[] packet) {
		this.packet = packet;
	}

	@Override
	public int length() {
		return packet.length + 1;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeBytes(packet);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		packet=this.readBytes(this._buffer.length-this._index);
	}

	public static Mcpe fromBuffer(byte[] buffer) {
		Mcpe ret = new Mcpe();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "Mcpe(packet: " + Arrays.toString(this.packet) + ")";
	}

}
