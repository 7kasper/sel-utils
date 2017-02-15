/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/hncom1.xml
 */
package sul.protocol.hncom1.status;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

import sul.utils.*;

/**
 * Updates a list.
 */
public class UpdateList extends Packet {

	public static final byte ID = (byte)13;

	public static final boolean CLIENTBOUND = false;
	public static final boolean SERVERBOUND = true;

	@Override
	public int getId() {
		return ID;
	}

	// list
	public static final byte WHITELIST = 0;
	public static final byte BLACKLIST = 1;

	// action
	public static final byte ADD = 0;
	public static final byte REMOVE = 1;

	/**
	 * Type of the list to update.
	 */
	public byte list;

	/**
	 * Whether to add or removed the player from the list.
	 */
	public byte action;
	public byte type;

	public UpdateList() {}

	public UpdateList(byte list, byte action, byte type) {
		this.list = list;
		this.action = action;
		this.type = type;
	}

	@Override
	public int length() {
		return 4;
	}

	@Override
	public byte[] encode() {
		return this.encodeImpl();
	}

	private byte[] encodeImpl() {
		this._buffer = new byte[this.length()];
		this.writeBigEndianByte(ID);
		this.writeBigEndianByte(list);
		this.writeBigEndianByte(action);
		this.writeBigEndianByte(type);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		readBigEndianByte();
		list=readBigEndianByte();
		action=readBigEndianByte();
		type=readBigEndianByte();
	}

	private byte[] remainingBuffer() {
		return java.util.Arrays.copyOfRange(this._buffer, this._index, this._buffer.length);
	}

	public static UpdateList fromBuffer(byte[] buffer) {
		UpdateList ret = new UpdateList();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "UpdateList(list: " + this.list + ", action: " + this.action + ", type: " + this.type + ")";
	}

	public class ByHubId extends Packet {

		public static final byte TYPE = (byte)0;

	@Override
	public int getId() {
		return ID;
	}

		public int hubId;

		public ByHubId() {}

		public ByHubId(int hubId) {
			this.hubId = hubId;
		}

		@Override
		public int length() {
			return Buffer.varuintLength(hubId);
		}

		@Override
		public byte[] encode() {
			byte[] _encode = encodeImpl();
			this._buffer = new byte[_encode.length + this.length()];
			this.writeBytes(_encode);
			this.writeVaruint(hubId);
			return this.getBuffer();
		}

		@Override
		public void decode(byte[] buffer) {
			this._buffer = buffer;
			hubId=this.readVaruint();
		}

		public void decode() {
			this.decode(remainingBuffer());
		}

		@Override
		public String toString() {
			return "UpdateList.ByHubId(hubId: " + this.hubId + ")";
		}

	}

	public class ByName extends Packet {

		public static final byte TYPE = (byte)1;

	@Override
	public int getId() {
		return ID;
	}

		/**
		 * Case-insensitive player's username. Spaces may be replaced by dashes.
		 */
		public String username;

		public ByName() {}

		public ByName(String username) {
			this.username = username;
		}

		@Override
		public int length() {
			return Buffer.varuintLength(username.getBytes(StandardCharsets.UTF_8).length) + username.getBytes(StandardCharsets.UTF_8).length;
		}

		@Override
		public byte[] encode() {
			byte[] _encode = encodeImpl();
			this._buffer = new byte[_encode.length + this.length()];
			this.writeBytes(_encode);
			byte[] dxnlcm5hbwu=username.getBytes(StandardCharsets.UTF_8); this.writeVaruint((int)dxnlcm5hbwu.length); this.writeBytes(dxnlcm5hbwu);
			return this.getBuffer();
		}

		@Override
		public void decode(byte[] buffer) {
			this._buffer = buffer;
			int bgvudxnlcm5hbwu=this.readVaruint(); username=new String(this.readBytes(bgvudxnlcm5hbwu), StandardCharsets.UTF_8);
		}

		public void decode() {
			this.decode(remainingBuffer());
		}

		@Override
		public String toString() {
			return "UpdateList.ByName(username: " + this.username + ")";
		}

	}

	public class ByUuid extends Packet {

		public static final byte TYPE = (byte)2;

	@Override
	public int getId() {
		return ID;
	}

		// game
		public static final byte POCKET = 1;
		public static final byte MINECRAFT = 2;

		public byte game;
		public UUID uuid;

		public ByUuid() {}

		public ByUuid(byte game, UUID uuid) {
			this.game = game;
			this.uuid = uuid;
		}

		@Override
		public int length() {
			return 17;
		}

		@Override
		public byte[] encode() {
			byte[] _encode = encodeImpl();
			this._buffer = new byte[_encode.length + this.length()];
			this.writeBytes(_encode);
			this.writeBigEndianByte(game);
			this.writeBigEndianLong(uuid.getLeastSignificantBits()); this.writeBigEndianLong(uuid.getMostSignificantBits());
			return this.getBuffer();
		}

		@Override
		public void decode(byte[] buffer) {
			this._buffer = buffer;
			game=readBigEndianByte();
			long bxv1awq=readBigEndianLong(); long bhv1awq=readBigEndianLong(); uuid=new UUID(bxv1awq,bhv1awq);
		}

		public void decode() {
			this.decode(remainingBuffer());
		}

		@Override
		public String toString() {
			return "UpdateList.ByUuid(game: " + this.game + ", uuid: " + this.uuid.toString() + ")";
		}

	}

}
