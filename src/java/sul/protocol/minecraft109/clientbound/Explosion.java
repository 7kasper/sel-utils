/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft109.xml
 */
package sul.protocol.minecraft109.clientbound;

import sul.utils.*;

public class Explosion extends Packet {

	public static final int ID = (int)28;

	public static final boolean CLIENTBOUND = true;
	public static final boolean SERVERBOUND = false;

	public Tuples.FloatXYZ position;
	public float radius;
	public Tuples.ByteXYZ[] records;
	public Tuples.FloatXYZ motion;

	public Explosion() {}

	public Explosion(Tuples.FloatXYZ position, float radius, Tuples.ByteXYZ[] records, Tuples.FloatXYZ motion) {
		this.position = position;
		this.radius = radius;
		this.records = records;
		this.motion = motion;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(ID) + records.length*3 + 32;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(ID);
		this.writeBigEndianFloat(position.x); this.writeBigEndianFloat(position.y); this.writeBigEndianFloat(position.z);
		this.writeBigEndianFloat(radius);
		this.writeBigEndianInt((int)records.length); for(Tuples.ByteXYZ cmvjb3jkcw:records){ this.writeBigEndianByte(cmvjb3jkcw.x); this.writeBigEndianByte(cmvjb3jkcw.y); this.writeBigEndianByte(cmvjb3jkcw.z); }
		this.writeBigEndianFloat(motion.x); this.writeBigEndianFloat(motion.y); this.writeBigEndianFloat(motion.z);
		return this._buffer;
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		this.readVaruint();
		position.x=readBigEndianFloat(); position.y=readBigEndianFloat(); position.z=readBigEndianFloat();
		radius=readBigEndianFloat();
		int bhjly29yzhm=readBigEndianInt(); records=new Tuples.ByteXYZ[bhjly29yzhm]; for(int cmvjb3jkcw=0;cmvjb3jkcw<records.length;cmvjb3jkcw++){ records[cmvjb3jkcw].x=readBigEndianByte(); records[cmvjb3jkcw].y=readBigEndianByte(); records[cmvjb3jkcw].z=readBigEndianByte(); }
		motion.x=readBigEndianFloat(); motion.y=readBigEndianFloat(); motion.z=readBigEndianFloat();
	}

	public static Explosion fromBuffer(byte[] buffer) {
		Explosion ret = new Explosion();
		ret.decode(buffer);
		return ret;
	}

}
