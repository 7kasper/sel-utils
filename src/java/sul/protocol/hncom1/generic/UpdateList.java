/*
 * This file has been automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generator: https://github.com/sel-project/sel-utils/blob/master/xml/protocol/hncom1.xml
 */
package sul.protocol.hncom1.generic;

import java.util.UUID;

import sul.protocol.hncom1.types.*;
import sul.utils.*;

class UpdateList extends Packet {

	public final static byte ID = (byte)9;

	public final static boolean CLIENTBOUND = false;
	public final static boolean SERVERBOUND = true;

	// list
	public static immutable byte WHITELIST = 0;
	public static immutable byte BLACKLIST = 1;

	// action
	public static immutable byte ADD = 0;
	public static immutable byte REMOVE = 1;

	public byte list;
	public byte action;
	public byte type;

	@Override
	public int length() {
	}

	@Override
	public byte[] encode() {
		this.buffer = new byte[this.length()];
		this.index = 0;
		this.writeByteB(ID);
		this.writeByteB(list);
		this.writeByteB(action);
		this.writeByteB(type);
		return this.buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this.buffer = buffer;
		this.index = 0;
	}

	public static class ByHubId extends UpdateList {

	}

	public static class ByName extends UpdateList {

	}

	public static class ByUuid extends UpdateList {

	}

}
