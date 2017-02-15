/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/externalconsole1.xml
 */
package sul.protocol.externalconsole1.connected;

import sul.utils.*;

/**
 * Bodyless packet only sent in response to Command when the server doesn't allow the
 * execution of remote commands through the external console. A good implementation
 * of the external console client should never receive this packet avoiding the use
 * of the Command packet when the remoteCommands field is false.
 */
public class PermissionDenied extends Packet {

	public static final byte ID = (byte)6;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	@Override
	public int length() {
		return 1;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
	}

	public static PermissionDenied fromBuffer(byte[] buffer) {
		PermissionDenied ret = new PermissionDenied();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "PermissionDenied()";
	}

}
