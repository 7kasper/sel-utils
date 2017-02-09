/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/pocket100.xml
 */
/** @module sul/protocol/pocket100/types */

const Types = {

	Pack: class {

		constructor(id="", version="", size=0) {
			this.id = id;
			this.version = version;
			this.size = size;
		}

		/** @return {Uint8Array} */
		encode() {
			this.writeString(id);
			this.writeString(version);
			this.writeBigEndianLong(size);
		}

		/** @param {Uint8Array} buffer */
		decode(buffer) {
			if(!(buffer instanceof Uint8Array)) throw new TypeError('buffer is not a Uint8Array');
			return this;
		}

		/** @return {string} */
		toString() {
			return "Pack(id: " + this.id + ", version: " + this.version + ", size: " + this.size + ")";
		}

	},

	BlockPosition: class {

		constructor(x=0, y=0, z=0) {
			this.x = x;
			this.y = y;
			this.z = z;
		}

		/** @return {Uint8Array} */
		encode() {
			this.writeVarint(x);
			this.writeVaruint(y);
			this.writeVarint(z);
		}

		/** @param {Uint8Array} buffer */
		decode(buffer) {
			if(!(buffer instanceof Uint8Array)) throw new TypeError('buffer is not a Uint8Array');
			return this;
		}

		/** @return {string} */
		toString() {
			return "BlockPosition(x: " + this.x + ", y: " + this.y + ", z: " + this.z + ")";
		}

	},

	Slot: class {

		constructor(id=0, metaAndCount=0, nbt=null) {
			this.id = id;
			this.metaAndCount = metaAndCount;
			this.nbt = nbt;
		}

		/** @return {Uint8Array} */
		encode() {
			this.writeVarint(id);
			this.writeVarint(metaAndCount);
			this.writeLittleEndianShort(nbt.length); for(bmj0 in nbt){ this.writeByte(nbt[bmj0]); }
		}

		/** @param {Uint8Array} buffer */
		decode(buffer) {
			if(!(buffer instanceof Uint8Array)) throw new TypeError('buffer is not a Uint8Array');
			return this;
		}

		/** @return {string} */
		toString() {
			return "Slot(id: " + this.id + ", metaAndCount: " + this.metaAndCount + ", nbt: " + this.nbt + ")";
		}

	},

	Attribute: class {

		constructor(min=.0, max=.0, value=.0, default=.0, name="") {
			this.min = min;
			this.max = max;
			this.value = value;
			this.default = default;
			this.name = name;
		}

		/** @return {Uint8Array} */
		encode() {
			this.writeLittleEndianFloat(min);
			this.writeLittleEndianFloat(max);
			this.writeLittleEndianFloat(value);
			this.writeLittleEndianFloat(default);
			this.writeString(name);
		}

		/** @param {Uint8Array} buffer */
		decode(buffer) {
			if(!(buffer instanceof Uint8Array)) throw new TypeError('buffer is not a Uint8Array');
			return this;
		}

		/** @return {string} */
		toString() {
			return "Attribute(min: " + this.min + ", max: " + this.max + ", value: " + this.value + ", default: " + this.default + ", name: " + this.name + ")";
		}

	},

	Skin: class {

		constructor(name="", data=[]) {
			this.name = name;
			this.data = data;
		}

		/** @return {Uint8Array} */
		encode() {
			this.writeString(name);
			this.writeVaruint(data.length); for(zgf0yq in data){ this.writeByte(data[zgf0yq]); }
		}

		/** @param {Uint8Array} buffer */
		decode(buffer) {
			if(!(buffer instanceof Uint8Array)) throw new TypeError('buffer is not a Uint8Array');
			return this;
		}

		/** @return {string} */
		toString() {
			return "Skin(name: " + this.name + ", data: " + this.data + ")";
		}

	},

	PlayerList: class {

		constructor(uuid=new Uint8Array(16), entityId=0, displayName="", skin=null) {
			this.uuid = uuid;
			this.entityId = entityId;
			this.displayName = displayName;
			this.skin = skin;
		}

		/** @return {Uint8Array} */
		encode() {
			this.writeBigEndianLong(uuid.getLeastSignificantBits()); this.writeBigEndianLong(uuid.getMostSignificantBits());
			this.writeVarlong(entityId);
			this.writeString(displayName);
			this.writeBytes(skin.encode());
		}

		/** @param {Uint8Array} buffer */
		decode(buffer) {
			if(!(buffer instanceof Uint8Array)) throw new TypeError('buffer is not a Uint8Array');
			return this;
		}

		/** @return {string} */
		toString() {
			return "PlayerList(uuid: " + this.uuid + ", entityId: " + this.entityId + ", displayName: " + this.displayName + ", skin: " + this.skin + ")";
		}

	},

	Recipe: class {

		// type
		static get SHAPELESS(){ return 0; }
		static get SHAPED(){ return 1; }
		static get FURNACE(){ return 2; }
		static get FURNACE_DATA(){ return 3; }
		static get MULTI(){ return 4; }

		constructor(type=0, data=null) {
			this.type = type;
			this.data = data;
		}

		/** @return {Uint8Array} */
		encode() {
			this.writeVarint(type);
			this.writeBytes(data);
		}

		/** @param {Uint8Array} buffer */
		decode(buffer) {
			if(!(buffer instanceof Uint8Array)) throw new TypeError('buffer is not a Uint8Array');
			return this;
		}

		/** @return {string} */
		toString() {
			return "Recipe(type: " + this.type + ", data: " + this.data + ")";
		}

	}

}

export { Types }
