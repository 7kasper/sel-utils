/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft110.xml
 */
package sul.protocol.minecraft110.login;

import java.util.Arrays;

import sul.utils.*;

public class EncryptionResponse extends Packet {

	public static final int ID = (int)1;

	public static final boolean CLIENTBOUND = false;
	public static final boolean SERVERBOUND = true;

	@Override
	public int getId() {
		return ID;
	}

	public byte[] sharedSecret;
	public byte[] verifyToken;

	public EncryptionResponse() {}

	public EncryptionResponse(byte[] sharedSecret, byte[] verifyToken) {
		this.sharedSecret = sharedSecret;
		this.verifyToken = verifyToken;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(ID) + Buffer.varuintLength(sharedSecret.length) + sharedSecret.length + Buffer.varuintLength(verifyToken.length) + verifyToken.length;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeVaruint((int)sharedSecret.length); this.writeBytes(sharedSecret);
		this.writeVaruint((int)verifyToken.length); this.writeBytes(verifyToken);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		int bhnoyxjlzfnly3jl=this.readVaruint(); sharedSecret=this.readBytes(bhnoyxjlzfnly3jl);
		int bhzlcmlmevrva2vu=this.readVaruint(); verifyToken=this.readBytes(bhzlcmlmevrva2vu);
	}

	public static EncryptionResponse fromBuffer(byte[] buffer) {
		EncryptionResponse ret = new EncryptionResponse();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "EncryptionResponse(sharedSecret: " + Arrays.toString(this.sharedSecret) + ", verifyToken: " + Arrays.toString(this.verifyToken) + ")";
	}

}
