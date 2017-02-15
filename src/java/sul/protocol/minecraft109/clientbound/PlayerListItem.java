/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft109.xml
 */
package sul.protocol.minecraft109.clientbound;

import java.util.Arrays;
import java.util.UUID;

import sul.utils.*;

public class PlayerListItem extends Packet {

	public static final int ID = (int)45;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	@Override
	public int getId() {
		return ID;
	}

	public int action;

	public PlayerListItem() {}

	public PlayerListItem(int action) {
		this.action = action;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(ID) + Buffer.varuintLength(action);
	}

	@Override
	public byte[] encode() {
		return this.encodeImpl();
	}

	private byte[] encodeImpl() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeVaruint(action);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		action=this.readVaruint();
	}

	private byte[] remainingBuffer() {
		return java.util.Arrays.copyOfRange(this._buffer, this._index, this._buffer.length);
	}

	public static PlayerListItem fromBuffer(byte[] buffer) {
		PlayerListItem ret = new PlayerListItem();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "PlayerListItem(action: " + this.action + ")";
	}

	public class AddPlayer extends Packet {

		public static final int ACTION = (int)0;

	@Override
	public int getId() {
		return ID;
	}

		public sul.protocol.minecraft109.types.ListAddPlayer[] players;

		public AddPlayer() {}

		public AddPlayer(sul.protocol.minecraft109.types.ListAddPlayer[] players) {
			this.players = players;
		}

		@Override
		public int length() {
			int length=Buffer.varuintLength(players.length) + 0; for(sul.protocol.minecraft109.types.ListAddPlayer cgxhewvycw:players){ length+=cgxhewvycw.length(); } return length;
		}

		@Override
		public byte[] encode() {
			byte[] _encode = encodeImpl();
			this._buffer = new byte[_encode.length + this.length()];
			this.writeBytes(_encode);
			this.writeVaruint((int)players.length); for(sul.protocol.minecraft109.types.ListAddPlayer cgxhewvycw:players){ this.writeBytes(cgxhewvycw.encode()); }
			return this.getBuffer();
		}

		@Override
		public void decode(byte[] buffer) {
			this._buffer = buffer;
			int bhbsyxllcnm=this.readVaruint(); players=new sul.protocol.minecraft109.types.ListAddPlayer[bhbsyxllcnm]; for(int cgxhewvycw=0;cgxhewvycw<players.length;cgxhewvycw++){ players[cgxhewvycw]=new sul.protocol.minecraft109.types.ListAddPlayer(); players[cgxhewvycw]._index=this._index; players[cgxhewvycw].decode(this._buffer); this._index=players[cgxhewvycw]._index; }
		}

		public void decode() {
			this.decode(remainingBuffer());
		}

		@Override
		public String toString() {
			return "PlayerListItem.AddPlayer(players: " + Arrays.deepToString(this.players) + ")";
		}

	}

	public class UpdateGamemode extends Packet {

		public static final int ACTION = (int)1;

	@Override
	public int getId() {
		return ID;
	}

		public sul.protocol.minecraft109.types.ListUpdateGamemode[] players;

		public UpdateGamemode() {}

		public UpdateGamemode(sul.protocol.minecraft109.types.ListUpdateGamemode[] players) {
			this.players = players;
		}

		@Override
		public int length() {
			int length=Buffer.varuintLength(players.length) + 0; for(sul.protocol.minecraft109.types.ListUpdateGamemode cgxhewvycw:players){ length+=cgxhewvycw.length(); } return length;
		}

		@Override
		public byte[] encode() {
			byte[] _encode = encodeImpl();
			this._buffer = new byte[_encode.length + this.length()];
			this.writeBytes(_encode);
			this.writeVaruint((int)players.length); for(sul.protocol.minecraft109.types.ListUpdateGamemode cgxhewvycw:players){ this.writeBytes(cgxhewvycw.encode()); }
			return this.getBuffer();
		}

		@Override
		public void decode(byte[] buffer) {
			this._buffer = buffer;
			int bhbsyxllcnm=this.readVaruint(); players=new sul.protocol.minecraft109.types.ListUpdateGamemode[bhbsyxllcnm]; for(int cgxhewvycw=0;cgxhewvycw<players.length;cgxhewvycw++){ players[cgxhewvycw]=new sul.protocol.minecraft109.types.ListUpdateGamemode(); players[cgxhewvycw]._index=this._index; players[cgxhewvycw].decode(this._buffer); this._index=players[cgxhewvycw]._index; }
		}

		public void decode() {
			this.decode(remainingBuffer());
		}

		@Override
		public String toString() {
			return "PlayerListItem.UpdateGamemode(players: " + Arrays.deepToString(this.players) + ")";
		}

	}

	public class UpdateLatency extends Packet {

		public static final int ACTION = (int)2;

	@Override
	public int getId() {
		return ID;
	}

		public sul.protocol.minecraft109.types.ListUpdateLatency[] players;

		public UpdateLatency() {}

		public UpdateLatency(sul.protocol.minecraft109.types.ListUpdateLatency[] players) {
			this.players = players;
		}

		@Override
		public int length() {
			int length=Buffer.varuintLength(players.length) + 0; for(sul.protocol.minecraft109.types.ListUpdateLatency cgxhewvycw:players){ length+=cgxhewvycw.length(); } return length;
		}

		@Override
		public byte[] encode() {
			byte[] _encode = encodeImpl();
			this._buffer = new byte[_encode.length + this.length()];
			this.writeBytes(_encode);
			this.writeVaruint((int)players.length); for(sul.protocol.minecraft109.types.ListUpdateLatency cgxhewvycw:players){ this.writeBytes(cgxhewvycw.encode()); }
			return this.getBuffer();
		}

		@Override
		public void decode(byte[] buffer) {
			this._buffer = buffer;
			int bhbsyxllcnm=this.readVaruint(); players=new sul.protocol.minecraft109.types.ListUpdateLatency[bhbsyxllcnm]; for(int cgxhewvycw=0;cgxhewvycw<players.length;cgxhewvycw++){ players[cgxhewvycw]=new sul.protocol.minecraft109.types.ListUpdateLatency(); players[cgxhewvycw]._index=this._index; players[cgxhewvycw].decode(this._buffer); this._index=players[cgxhewvycw]._index; }
		}

		public void decode() {
			this.decode(remainingBuffer());
		}

		@Override
		public String toString() {
			return "PlayerListItem.UpdateLatency(players: " + Arrays.deepToString(this.players) + ")";
		}

	}

	public class UpdateDisplayName extends Packet {

		public static final int ACTION = (int)3;

	@Override
	public int getId() {
		return ID;
	}

		public sul.protocol.minecraft109.types.ListUpdateDisplayName[] players;

		public UpdateDisplayName() {}

		public UpdateDisplayName(sul.protocol.minecraft109.types.ListUpdateDisplayName[] players) {
			this.players = players;
		}

		@Override
		public int length() {
			int length=Buffer.varuintLength(players.length) + 0; for(sul.protocol.minecraft109.types.ListUpdateDisplayName cgxhewvycw:players){ length+=cgxhewvycw.length(); } return length;
		}

		@Override
		public byte[] encode() {
			byte[] _encode = encodeImpl();
			this._buffer = new byte[_encode.length + this.length()];
			this.writeBytes(_encode);
			this.writeVaruint((int)players.length); for(sul.protocol.minecraft109.types.ListUpdateDisplayName cgxhewvycw:players){ this.writeBytes(cgxhewvycw.encode()); }
			return this.getBuffer();
		}

		@Override
		public void decode(byte[] buffer) {
			this._buffer = buffer;
			int bhbsyxllcnm=this.readVaruint(); players=new sul.protocol.minecraft109.types.ListUpdateDisplayName[bhbsyxllcnm]; for(int cgxhewvycw=0;cgxhewvycw<players.length;cgxhewvycw++){ players[cgxhewvycw]=new sul.protocol.minecraft109.types.ListUpdateDisplayName(); players[cgxhewvycw]._index=this._index; players[cgxhewvycw].decode(this._buffer); this._index=players[cgxhewvycw]._index; }
		}

		public void decode() {
			this.decode(remainingBuffer());
		}

		@Override
		public String toString() {
			return "PlayerListItem.UpdateDisplayName(players: " + Arrays.deepToString(this.players) + ")";
		}

	}

	public class RemovePlayer extends Packet {

		public static final int ACTION = (int)4;

	@Override
	public int getId() {
		return ID;
	}

		public UUID[] players;

		public RemovePlayer() {}

		public RemovePlayer(UUID[] players) {
			this.players = players;
		}

		@Override
		public int length() {
			return Buffer.varuintLength(players.length) + players.length*16;
		}

		@Override
		public byte[] encode() {
			byte[] _encode = encodeImpl();
			this._buffer = new byte[_encode.length + this.length()];
			this.writeBytes(_encode);
			this.writeVaruint((int)players.length); for(UUID cgxhewvycw:players){ this.writeBigEndianLong(cgxhewvycw.getLeastSignificantBits()); this.writeBigEndianLong(cgxhewvycw.getMostSignificantBits()); }
			return this.getBuffer();
		}

		@Override
		public void decode(byte[] buffer) {
			this._buffer = buffer;
			int bhbsyxllcnm=this.readVaruint(); players=new UUID[bhbsyxllcnm]; for(int cgxhewvycw=0;cgxhewvycw<players.length;cgxhewvycw++){ long bxbsyxllcnnby2d4=readBigEndianLong(); long bhbsyxllcnnby2d4=readBigEndianLong(); players[cgxhewvycw]=new UUID(bxbsyxllcnnby2d4,bhbsyxllcnnby2d4); }
		}

		public void decode() {
			this.decode(remainingBuffer());
		}

		@Override
		public String toString() {
			return "PlayerListItem.RemovePlayer(players: " + Arrays.deepToString(this.players) + ")";
		}

	}

}
