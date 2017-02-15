/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/externalconsole2.xml
 */
package sul.protocol.externalconsole2.login;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import sul.utils.*;

/**
 * First packet sent by the server when the connection is successfully established.
 * It contains informations about how the external console shall authenticate itself.
 */
public class AuthCredentials extends Packet {

	public static final byte ID = (byte)0;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	/**
	 * Protocol used by the server. If the client uses a different one it should close
	 * the connection without trying to perform authentication.
	 */
	public byte protocol;

	/**
	 * Whether to perform hashing on the password or not.
	 */
	public boolean hash;

	/**
	 * Algorithm used by the server to hash the concatenation of the password and the payload.
	 * The value should be sent in lower case without any separation symbol (for example
	 * `md5` instead of `MD5`, `sha256` instead of `SHA-256`).
	 * See Auth.hash for more details.
	 */
	public String hashAlgorithm;

	/**
	 * Payload to cancatenate to the password before hashing it, as described in the Auth.hash's
	 * field description.
	 */
	public byte[] payload;

	public AuthCredentials() {}

	public AuthCredentials(byte protocol, boolean hash, String hashAlgorithm, byte[] payload) {
		this.protocol = protocol;
		this.hash = hash;
		this.hashAlgorithm = hashAlgorithm;
		this.payload = payload;
	}

	@Override
	public int length() {
		return hashAlgorithm.getBytes(StandardCharsets.UTF_8).length + payload.length + 7;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeBigEndianByte(protocol);
		this.writeBool(hash);
		if(hash==true){ byte[] agfzaefsz29yaxro=hashAlgorithm.getBytes(StandardCharsets.UTF_8); this.writeBigEndianShort((short)agfzaefsz29yaxro.length); this.writeBytes(agfzaefsz29yaxro); }
		if(hash==true){ this.writeBigEndianShort((short)payload.length); this.writeBytes(payload); }
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		protocol=readBigEndianByte();
		hash=this.readBool();
		if(hash==true){ short bgvuagfzaefsz29y=readBigEndianShort(); hashAlgorithm=new String(this.readBytes(bgvuagfzaefsz29y), StandardCharsets.UTF_8); }
		if(hash==true){ int bhbhewxvywq=readBigEndianShort(); payload=this.readBytes(bhbhewxvywq); }
	}

	public static AuthCredentials fromBuffer(byte[] buffer) {
		AuthCredentials ret = new AuthCredentials();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "AuthCredentials(protocol: " + this.protocol + ", hash: " + this.hash + ", hashAlgorithm: " + this.hashAlgorithm + ", payload: " + Arrays.toString(this.payload) + ")";
	}

}
