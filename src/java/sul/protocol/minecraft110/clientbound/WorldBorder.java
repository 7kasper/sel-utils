/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft110.xml
 */
package sul.protocol.minecraft110.clientbound;

import sul.utils.*;

public class WorldBorder extends Packet {

	public static final int ID = (int)53;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	public int action;

	public WorldBorder() {}

	public WorldBorder(int action) {
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

	public static WorldBorder fromBuffer(byte[] buffer) {
		WorldBorder ret = new WorldBorder();
		ret.decode(buffer);
		return ret;
	}

	@Override
	public String toString() {
		return "WorldBorder(action: " + this.action + ")";
	}

	public class SetSize extends Packet {

		public static final int ACTION = (int)0;

		public double diameter;

		public SetSize() {}

		public SetSize(double diameter) {
			this.diameter = diameter;
		}

		@Override
		public int length() {
			return 8;
		}

		@Override
		public byte[] encode() {
			byte[] _encode = encodeImpl();
			this._buffer = new byte[_encode.length + this.length()];
			this.writeBytes(_encode);
			this.writeBigEndianDouble(diameter);
			return this.getBuffer();
		}

		@Override
		public void decode(byte[] buffer) {
			this._buffer = buffer;
			diameter=readBigEndianDouble();
		}

		public void decode() {
			this.decode(remainingBuffer());
		}

		@Override
		public String toString() {
			return "WorldBorder.SetSize(diameter: " + this.diameter + ")";
		}

	}

	public class LerpSize extends Packet {

		public static final int ACTION = (int)1;

		public double oldDiameter;
		public double newDiameter;
		public long speed;

		public LerpSize() {}

		public LerpSize(double oldDiameter, double newDiameter, long speed) {
			this.oldDiameter = oldDiameter;
			this.newDiameter = newDiameter;
			this.speed = speed;
		}

		@Override
		public int length() {
			return Buffer.varulongLength(speed) + 16;
		}

		@Override
		public byte[] encode() {
			byte[] _encode = encodeImpl();
			this._buffer = new byte[_encode.length + this.length()];
			this.writeBytes(_encode);
			this.writeBigEndianDouble(oldDiameter);
			this.writeBigEndianDouble(newDiameter);
			this.writeVarulong(speed);
			return this.getBuffer();
		}

		@Override
		public void decode(byte[] buffer) {
			this._buffer = buffer;
			oldDiameter=readBigEndianDouble();
			newDiameter=readBigEndianDouble();
			speed=this.readVarulong();
		}

		public void decode() {
			this.decode(remainingBuffer());
		}

		@Override
		public String toString() {
			return "WorldBorder.LerpSize(oldDiameter: " + this.oldDiameter + ", newDiameter: " + this.newDiameter + ", speed: " + this.speed + ")";
		}

	}

	public class SetCenter extends Packet {

		public static final int ACTION = (int)2;

		public Tuples.DoubleXYZ center;

		public SetCenter() {}

		public SetCenter(Tuples.DoubleXYZ center) {
			this.center = center;
		}

		@Override
		public int length() {
			return 24;
		}

		@Override
		public byte[] encode() {
			byte[] _encode = encodeImpl();
			this._buffer = new byte[_encode.length + this.length()];
			this.writeBytes(_encode);
			this.writeBigEndianDouble(center.x); this.writeBigEndianDouble(center.y); this.writeBigEndianDouble(center.z);
			return this.getBuffer();
		}

		@Override
		public void decode(byte[] buffer) {
			this._buffer = buffer;
			center.x=readBigEndianDouble(); center.y=readBigEndianDouble(); center.z=readBigEndianDouble();
		}

		public void decode() {
			this.decode(remainingBuffer());
		}

		@Override
		public String toString() {
			return "WorldBorder.SetCenter(center: " + this.center.toString() + ")";
		}

	}

	public class Initialize extends Packet {

		public static final int ACTION = (int)3;

		public Tuples.DoubleXYZ center;
		public double oldDiameter;
		public double newDiameter;
		public long speed;
		public int portalTeleportBoundary;
		public int warningTime;
		public int warningBlocks;

		public Initialize() {}

		public Initialize(Tuples.DoubleXYZ center, double oldDiameter, double newDiameter, long speed, int portalTeleportBoundary, int warningTime, int warningBlocks) {
			this.center = center;
			this.oldDiameter = oldDiameter;
			this.newDiameter = newDiameter;
			this.speed = speed;
			this.portalTeleportBoundary = portalTeleportBoundary;
			this.warningTime = warningTime;
			this.warningBlocks = warningBlocks;
		}

		@Override
		public int length() {
			return Buffer.varulongLength(speed) + Buffer.varuintLength(portalTeleportBoundary) + Buffer.varuintLength(warningTime) + Buffer.varuintLength(warningBlocks) + 40;
		}

		@Override
		public byte[] encode() {
			byte[] _encode = encodeImpl();
			this._buffer = new byte[_encode.length + this.length()];
			this.writeBytes(_encode);
			this.writeBigEndianDouble(center.x); this.writeBigEndianDouble(center.y); this.writeBigEndianDouble(center.z);
			this.writeBigEndianDouble(oldDiameter);
			this.writeBigEndianDouble(newDiameter);
			this.writeVarulong(speed);
			this.writeVaruint(portalTeleportBoundary);
			this.writeVaruint(warningTime);
			this.writeVaruint(warningBlocks);
			return this.getBuffer();
		}

		@Override
		public void decode(byte[] buffer) {
			this._buffer = buffer;
			center.x=readBigEndianDouble(); center.y=readBigEndianDouble(); center.z=readBigEndianDouble();
			oldDiameter=readBigEndianDouble();
			newDiameter=readBigEndianDouble();
			speed=this.readVarulong();
			portalTeleportBoundary=this.readVaruint();
			warningTime=this.readVaruint();
			warningBlocks=this.readVaruint();
		}

		public void decode() {
			this.decode(remainingBuffer());
		}

		@Override
		public String toString() {
			return "WorldBorder.Initialize(center: " + this.center.toString() + ", oldDiameter: " + this.oldDiameter + ", newDiameter: " + this.newDiameter + ", speed: " + this.speed + ", portalTeleportBoundary: " + this.portalTeleportBoundary + ", warningTime: " + this.warningTime + ", warningBlocks: " + this.warningBlocks + ")";
		}

	}

	public class SetWarningTime extends Packet {

		public static final int ACTION = (int)4;

		public int warningTime;

		public SetWarningTime() {}

		public SetWarningTime(int warningTime) {
			this.warningTime = warningTime;
		}

		@Override
		public int length() {
			return Buffer.varuintLength(warningTime);
		}

		@Override
		public byte[] encode() {
			byte[] _encode = encodeImpl();
			this._buffer = new byte[_encode.length + this.length()];
			this.writeBytes(_encode);
			this.writeVaruint(warningTime);
			return this.getBuffer();
		}

		@Override
		public void decode(byte[] buffer) {
			this._buffer = buffer;
			warningTime=this.readVaruint();
		}

		public void decode() {
			this.decode(remainingBuffer());
		}

		@Override
		public String toString() {
			return "WorldBorder.SetWarningTime(warningTime: " + this.warningTime + ")";
		}

	}

	public class SetWarningBlocks extends Packet {

		public static final int ACTION = (int)5;

		public int warningBlocks;

		public SetWarningBlocks() {}

		public SetWarningBlocks(int warningBlocks) {
			this.warningBlocks = warningBlocks;
		}

		@Override
		public int length() {
			return Buffer.varuintLength(warningBlocks);
		}

		@Override
		public byte[] encode() {
			byte[] _encode = encodeImpl();
			this._buffer = new byte[_encode.length + this.length()];
			this.writeBytes(_encode);
			this.writeVaruint(warningBlocks);
			return this.getBuffer();
		}

		@Override
		public void decode(byte[] buffer) {
			this._buffer = buffer;
			warningBlocks=this.readVaruint();
		}

		public void decode() {
			this.decode(remainingBuffer());
		}

		@Override
		public String toString() {
			return "WorldBorder.SetWarningBlocks(warningBlocks: " + this.warningBlocks + ")";
		}

	}

}
