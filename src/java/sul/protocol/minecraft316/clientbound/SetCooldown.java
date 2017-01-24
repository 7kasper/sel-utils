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

public class SetCooldown extends Packet {

	public static final int ID = (int)23;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	public int item;
	public int cooldown;

	public SetCooldown() {}

	public SetCooldown(int item, int cooldown) {
		this.item = item;
		this.cooldown = cooldown;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(ID) + Buffer.varuintLength(item) + Buffer.varuintLength(cooldown);
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeVaruint(item);
		this.writeVaruint(cooldown);
		return this._buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		item=this.readVaruint();
		cooldown=this.readVaruint();
	}

	public static SetCooldown fromBuffer(byte[] buffer) {
		SetCooldown ret = new SetCooldown();
		ret.decode(buffer);
		return ret;
	}

}
