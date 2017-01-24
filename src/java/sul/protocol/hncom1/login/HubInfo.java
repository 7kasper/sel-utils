/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/hncom1.xml
 */
package sul.protocol.hncom1.login;

import java.nio.charset.StandardCharsets;

import sul.utils.*;

/**
 * Informations about the hub.
 */
public class HubInfo extends Packet {

	public static final byte ID = (byte)2;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	public long time;
	public long serverId;
	public long reservedUuids;
	public String displayName;
	public boolean onlineMode;
	public sul.protocol.hncom1.types.Game[] games;
	public int online;
	public int max;
	public String language;
	public String[] acceptedLanguages;
	public String[] nodes;
	public String socialJson;
	public String additionalJson;

	public HubInfo() {}

	public HubInfo(long time, long serverId, long reservedUuids, String displayName, boolean onlineMode, sul.protocol.hncom1.types.Game[] games, int online, int max, String language, String[] acceptedLanguages, String[] nodes, String socialJson, String additionalJson) {
		this.time = time;
		this.serverId = serverId;
		this.reservedUuids = reservedUuids;
		this.displayName = displayName;
		this.onlineMode = onlineMode;
		this.games = games;
		this.online = online;
		this.max = max;
		this.language = language;
		this.acceptedLanguages = acceptedLanguages;
		this.nodes = nodes;
		this.socialJson = socialJson;
		this.additionalJson = additionalJson;
	}

	@Override
	public int length() {
		int length=Buffer.varulongLength(time) + Buffer.varulongLength(serverId) + Buffer.varulongLength(reservedUuids) + Buffer.varuintLength(displayName.getBytes(StandardCharsets.UTF_8).length) + displayName.getBytes(StandardCharsets.UTF_8).length + Buffer.varuintLength(games.length) + Buffer.varuintLength(online) + Buffer.varuintLength(max) + Buffer.varuintLength(language.getBytes(StandardCharsets.UTF_8).length) + language.getBytes(StandardCharsets.UTF_8).length + Buffer.varuintLength(acceptedLanguages.length) + Buffer.varuintLength(nodes.length) + Buffer.varuintLength(socialJson.getBytes(StandardCharsets.UTF_8).length) + socialJson.getBytes(StandardCharsets.UTF_8).length + Buffer.varuintLength(additionalJson.getBytes(StandardCharsets.UTF_8).length) + additionalJson.getBytes(StandardCharsets.UTF_8).length + 2; for(sul.protocol.hncom1.types.Game z2ftzxm:games){ length+=z2ftzxm.length(); };for(String ywnjzxb0zwrmyw5n:acceptedLanguages){ length+=Buffer.varuintLength(ywnjzxb0zwrmyw5n.getBytes(StandardCharsets.UTF_8).length)+ywnjzxb0zwrmyw5n.getBytes(StandardCharsets.UTF_8).length; };for(String bm9kzxm:nodes){ length+=Buffer.varuintLength(bm9kzxm.getBytes(StandardCharsets.UTF_8).length)+bm9kzxm.getBytes(StandardCharsets.UTF_8).length; } return length;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeVarulong(time);
		this.writeVarulong(serverId);
		this.writeVarulong(reservedUuids);
		byte[] zglzcgxheu5hbwu=displayName.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)zglzcgxheu5hbwu.length); this.writeBytes(zglzcgxheu5hbwu);
		this._buffer[this._index++]=(byte)(onlineMode?1:0);
		this.writeVaruint((int)games.length); for(sul.protocol.hncom1.types.Game z2ftzxm:games){ this.writeBytes(z2ftzxm.encode()); }
		this.writeVaruint(online);
		this.writeVaruint(max);
		byte[] bgfuz3vhz2u=language.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)bgfuz3vhz2u.length); this.writeBytes(bgfuz3vhz2u);
		this.writeVaruint((int)acceptedLanguages.length); for(String ywnjzxb0zwrmyw5n:acceptedLanguages){ byte[] exduanp4yjb6d3jt=ywnjzxb0zwrmyw5n.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)exduanp4yjb6d3jt.length); this.writeBytes(exduanp4yjb6d3jt); }
		this.writeVaruint((int)nodes.length); for(String bm9kzxm:nodes){ byte[] ym05a3p4bq=bm9kzxm.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)ym05a3p4bq.length); this.writeBytes(ym05a3p4bq); }
		byte[] c29jawfssnnvbg=socialJson.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)c29jawfssnnvbg.length); this.writeBytes(c29jawfssnnvbg);
		byte[] ywrkaxrpb25hbepz=additionalJson.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)ywrkaxrpb25hbepz.length); this.writeBytes(ywrkaxrpb25hbepz);
		return this._buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		time=this.readVarulong();
		serverId=this.readVarulong();
		reservedUuids=this.readVarulong();
		int bgvuzglzcgxheu5h=this.readVaruint(); displayName=new String(this.readBytes(bgvuzglzcgxheu5h), StandardCharsets.UTF_8);
		onlineMode=this._index<this._buffer.length&&this._buffer[this._index++]!=0;
		int bgdhbwvz=this.readVaruint(); games=new sul.protocol.hncom1.types.Game[bgdhbwvz]; for(int z2ftzxm=0;z2ftzxm<games.length;z2ftzxm++){ games[z2ftzxm]=new sul.protocol.hncom1.types.Game(); games[z2ftzxm]._index=this._index; games[z2ftzxm].decode(this._buffer); this._index=games[z2ftzxm]._index; }
		online=this.readVaruint();
		max=this.readVaruint();
		int bgvubgfuz3vhz2u=this.readVaruint(); language=new String(this.readBytes(bgvubgfuz3vhz2u), StandardCharsets.UTF_8);
		int bgfjy2vwdgvktgfu=this.readVaruint(); acceptedLanguages=new String[bgfjy2vwdgvktgfu]; for(int ywnjzxb0zwrmyw5n=0;ywnjzxb0zwrmyw5n<acceptedLanguages.length;ywnjzxb0zwrmyw5n++){ int bgvuywnjzxb0zwrm=this.readVaruint(); acceptedLanguages[ywnjzxb0zwrmyw5n]=new String(this.readBytes(bgvuywnjzxb0zwrm), StandardCharsets.UTF_8); }
		int bg5vzgvz=this.readVaruint(); nodes=new String[bg5vzgvz]; for(int bm9kzxm=0;bm9kzxm<nodes.length;bm9kzxm++){ int bgvubm9kzxnbym05=this.readVaruint(); nodes[bm9kzxm]=new String(this.readBytes(bgvubm9kzxnbym05), StandardCharsets.UTF_8); }
		int bgvuc29jawfssnnv=this.readVaruint(); socialJson=new String(this.readBytes(bgvuc29jawfssnnv), StandardCharsets.UTF_8);
		int bgvuywrkaxrpb25h=this.readVaruint(); additionalJson=new String(this.readBytes(bgvuywrkaxrpb25h), StandardCharsets.UTF_8);
	}

	public static HubInfo fromBuffer(byte[] buffer) {
		HubInfo ret = new HubInfo();
		ret.decode(buffer);
		return ret;
	}

}
