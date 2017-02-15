/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft47.xml
 */
package sul.protocol.minecraft47.types;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.UUID;

import sul.utils.*;

public class ListAddPlayer extends Stream {

	// gamemode
	public static final int SURVIVAL = 0;
	public static final int CREATIVE = 1;
	public static final int ADVENTURE = 2;
	public static final int SPECTATOR = 3;

	public UUID uuid;
	public String name;
	public sul.protocol.minecraft47.types.Property[] properties;
	public int gamemode;
	public int latency;
	public boolean hasDisplayName;
	public String displayName;

	public ListAddPlayer() {}

	public ListAddPlayer(UUID uuid, String name, sul.protocol.minecraft47.types.Property[] properties, int gamemode, int latency, boolean hasDisplayName, String displayName) {
		this.uuid = uuid;
		this.name = name;
		this.properties = properties;
		this.gamemode = gamemode;
		this.latency = latency;
		this.hasDisplayName = hasDisplayName;
		this.displayName = displayName;
	}

	@Override
	public int length() {
		int length=Buffer.varuintLength(name.getBytes(StandardCharsets.UTF_8).length) + name.getBytes(StandardCharsets.UTF_8).length + Buffer.varuintLength(properties.length) + Buffer.varuintLength(gamemode) + Buffer.varuintLength(latency) + Buffer.varuintLength(displayName.getBytes(StandardCharsets.UTF_8).length) + displayName.getBytes(StandardCharsets.UTF_8).length + 17; for(sul.protocol.minecraft47.types.Property chjvcgvydgllcw:properties){ length+=chjvcgvydgllcw.length(); } return length;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianLong(uuid.getLeastSignificantBits()); this.writeBigEndianLong(uuid.getMostSignificantBits());
		byte[] bmftzq=name.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)bmftzq.length); this.writeBytes(bmftzq);
		this.writeVaruint((int)properties.length); for(sul.protocol.minecraft47.types.Property chjvcgvydgllcw:properties){ this.writeBytes(chjvcgvydgllcw.encode()); }
		this.writeVaruint(gamemode);
		this.writeVaruint(latency);
		this.writeBool(hasDisplayName);
		if(hasDisplayName==true){ byte[] zglzcgxheu5hbwu=displayName.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)zglzcgxheu5hbwu.length); this.writeBytes(zglzcgxheu5hbwu); }
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		long bxv1awq=readBigEndianLong(); long bhv1awq=readBigEndianLong(); uuid=new UUID(bxv1awq,bhv1awq);
		int bgvubmftzq=this.readVaruint(); name=new String(this.readBytes(bgvubmftzq), StandardCharsets.UTF_8);
		int bhbyb3blcnrpzxm=this.readVaruint(); properties=new sul.protocol.minecraft47.types.Property[bhbyb3blcnrpzxm]; for(int chjvcgvydgllcw=0;chjvcgvydgllcw<properties.length;chjvcgvydgllcw++){ properties[chjvcgvydgllcw]=new sul.protocol.minecraft47.types.Property(); properties[chjvcgvydgllcw]._index=this._index; properties[chjvcgvydgllcw].decode(this._buffer); this._index=properties[chjvcgvydgllcw]._index; }
		gamemode=this.readVaruint();
		latency=this.readVaruint();
		hasDisplayName=this.readBool();
		if(hasDisplayName==true){ int bgvuzglzcgxheu5h=this.readVaruint(); displayName=new String(this.readBytes(bgvuzglzcgxheu5h), StandardCharsets.UTF_8); }
	}

	@Override
	public String toString() {
		return "ListAddPlayer(uuid: " + this.uuid.toString() + ", name: " + this.name + ", properties: " + Arrays.deepToString(this.properties) + ", gamemode: " + this.gamemode + ", latency: " + this.latency + ", hasDisplayName: " + this.hasDisplayName + ", displayName: " + this.displayName + ")";
	}


}
