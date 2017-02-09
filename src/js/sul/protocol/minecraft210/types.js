/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft210.xml
 */
/** @module sul/protocol/minecraft210/types */

const Types = {

	Statistic: class {

		constructor(name="", value=0) {
			this.name = name;
			this.value = value;
		}

		/** @return {Uint8Array} */
		encode() {
			this.writeString(name);
			this.writeVaruint(value);
		}

		/** @param {Uint8Array} buffer */
		decode(buffer) {
			if(!(buffer instanceof Uint8Array)) throw new TypeError('buffer is not a Uint8Array');
			return this;
		}

		/** @return {string} */
		toString() {
			return "Statistic(name: " + this.name + ", value: " + this.value + ")";
		}

	},

	BlockChange: class {

		constructor(xz=0, y=0, block=0) {
			this.xz = xz;
			this.y = y;
			this.block = block;
		}

		/** @return {Uint8Array} */
		encode() {
			this.writeByte(xz);
			this.writeByte(y);
			this.writeVaruint(block);
		}

		/** @param {Uint8Array} buffer */
		decode(buffer) {
			if(!(buffer instanceof Uint8Array)) throw new TypeError('buffer is not a Uint8Array');
			return this;
		}

		/** @return {string} */
		toString() {
			return "BlockChange(xz: " + this.xz + ", y: " + this.y + ", block: " + this.block + ")";
		}

	},

	Slot: class {

		constructor(id=0, count=0, damage=0, nbt=null) {
			this.id = id;
			this.count = count;
			this.damage = damage;
			this.nbt = nbt;
		}

		/** @return {Uint8Array} */
		encode() {
			this.writeBigEndianShort(id);
			this.writeByte(count);
			this.writeBigEndianShort(damage);
			this.writeBytes(nbt);
		}

		/** @param {Uint8Array} buffer */
		decode(buffer) {
			if(!(buffer instanceof Uint8Array)) throw new TypeError('buffer is not a Uint8Array');
			return this;
		}

		/** @return {string} */
		toString() {
			return "Slot(id: " + this.id + ", count: " + this.count + ", damage: " + this.damage + ", nbt: " + this.nbt + ")";
		}

	},

	Icon: class {

		// direction and type
		static get WHITE_ARROW(){ return 0; }
		static get GREEN_ARROW(){ return 1; }
		static get RED_ARROW(){ return 2; }
		static get BLUE_ARROW(){ return 3; }
		static get WHITE_CROSS(){ return 4; }
		static get RED_POINTER(){ return 5; }
		static get WHITE_CIRCLE(){ return 6; }

		constructor(directionAndType=0, position={x:0,z:0}) {
			this.directionAndType = directionAndType;
			this.position = position;
		}

		/** @return {Uint8Array} */
		encode() {
			this.writeByte(directionAndType);
			this.writeByte(position.x); this.writeByte(position.z);
		}

		/** @param {Uint8Array} buffer */
		decode(buffer) {
			if(!(buffer instanceof Uint8Array)) throw new TypeError('buffer is not a Uint8Array');
			return this;
		}

		/** @return {string} */
		toString() {
			return "Icon(directionAndType: " + this.directionAndType + ", position: " + this.position + ")";
		}

	},

	Property: class {

		constructor(name="", value="", signed=false, signature="") {
			this.name = name;
			this.value = value;
			this.signed = signed;
			this.signature = signature;
		}

		/** @return {Uint8Array} */
		encode() {
			this.writeString(name);
			this.writeString(value);
			this.writeBool(signed);
			this.writeString(signature);
		}

		/** @param {Uint8Array} buffer */
		decode(buffer) {
			if(!(buffer instanceof Uint8Array)) throw new TypeError('buffer is not a Uint8Array');
			return this;
		}

		/** @return {string} */
		toString() {
			return "Property(name: " + this.name + ", value: " + this.value + ", signed: " + this.signed + ", signature: " + this.signature + ")";
		}

	},

	ListAddPlayer: class {

		// gamemode
		static get SURVIVAL(){ return 0; }
		static get CREATIVE(){ return 1; }
		static get ADVENTURE(){ return 2; }
		static get SPECTATOR(){ return 3; }

		constructor(uuid=new Uint8Array(16), name="", properties=[], gamemode=0, latency=0, hasDisplayName=false, displayName="") {
			this.uuid = uuid;
			this.name = name;
			this.properties = properties;
			this.gamemode = gamemode;
			this.latency = latency;
			this.hasDisplayName = hasDisplayName;
			this.displayName = displayName;
		}

		/** @return {Uint8Array} */
		encode() {
			this.writeBigEndianLong(uuid.getLeastSignificantBits()); this.writeBigEndianLong(uuid.getMostSignificantBits());
			this.writeString(name);
			this.writeVaruint(properties.length); for(chjvcgvydgllcw in properties){ this.writeBytes(properties[chjvcgvydgllcw].encode()); }
			this.writeVaruint(gamemode);
			this.writeVaruint(latency);
			this.writeBool(hasDisplayName);
			this.writeString(displayName);
		}

		/** @param {Uint8Array} buffer */
		decode(buffer) {
			if(!(buffer instanceof Uint8Array)) throw new TypeError('buffer is not a Uint8Array');
			return this;
		}

		/** @return {string} */
		toString() {
			return "ListAddPlayer(uuid: " + this.uuid + ", name: " + this.name + ", properties: " + this.properties + ", gamemode: " + this.gamemode + ", latency: " + this.latency + ", hasDisplayName: " + this.hasDisplayName + ", displayName: " + this.displayName + ")";
		}

	},

	ListUpdateGamemode: class {

		// gamemode
		static get SURVIVAL(){ return 0; }
		static get CREATIVE(){ return 1; }
		static get ADVENTURE(){ return 2; }
		static get SPECTATOR(){ return 3; }

		constructor(uuid=new Uint8Array(16), gamemode=0) {
			this.uuid = uuid;
			this.gamemode = gamemode;
		}

		/** @return {Uint8Array} */
		encode() {
			this.writeBigEndianLong(uuid.getLeastSignificantBits()); this.writeBigEndianLong(uuid.getMostSignificantBits());
			this.writeVaruint(gamemode);
		}

		/** @param {Uint8Array} buffer */
		decode(buffer) {
			if(!(buffer instanceof Uint8Array)) throw new TypeError('buffer is not a Uint8Array');
			return this;
		}

		/** @return {string} */
		toString() {
			return "ListUpdateGamemode(uuid: " + this.uuid + ", gamemode: " + this.gamemode + ")";
		}

	},

	ListUpdateLatency: class {

		constructor(uuid=new Uint8Array(16), latency=0) {
			this.uuid = uuid;
			this.latency = latency;
		}

		/** @return {Uint8Array} */
		encode() {
			this.writeBigEndianLong(uuid.getLeastSignificantBits()); this.writeBigEndianLong(uuid.getMostSignificantBits());
			this.writeVaruint(latency);
		}

		/** @param {Uint8Array} buffer */
		decode(buffer) {
			if(!(buffer instanceof Uint8Array)) throw new TypeError('buffer is not a Uint8Array');
			return this;
		}

		/** @return {string} */
		toString() {
			return "ListUpdateLatency(uuid: " + this.uuid + ", latency: " + this.latency + ")";
		}

	},

	ListUpdateDisplayName: class {

		constructor(uuid=new Uint8Array(16), hasDisplayName=false, displayName="") {
			this.uuid = uuid;
			this.hasDisplayName = hasDisplayName;
			this.displayName = displayName;
		}

		/** @return {Uint8Array} */
		encode() {
			this.writeBigEndianLong(uuid.getLeastSignificantBits()); this.writeBigEndianLong(uuid.getMostSignificantBits());
			this.writeBool(hasDisplayName);
			this.writeString(displayName);
		}

		/** @param {Uint8Array} buffer */
		decode(buffer) {
			if(!(buffer instanceof Uint8Array)) throw new TypeError('buffer is not a Uint8Array');
			return this;
		}

		/** @return {string} */
		toString() {
			return "ListUpdateDisplayName(uuid: " + this.uuid + ", hasDisplayName: " + this.hasDisplayName + ", displayName: " + this.displayName + ")";
		}

	},

	Modifier: class {

		// operation
		static get ADD_SUBSTRACT_AMOUNT(){ return 0; }
		static get ADD_SUBSTRACT_AMOUNT_PERCENTAGE(){ return 1; }
		static get MULTIPLY_AMOUNT_PERCENTAGE(){ return 2; }

		constructor(uuid=new Uint8Array(16), amount=.0, operation=0) {
			this.uuid = uuid;
			this.amount = amount;
			this.operation = operation;
		}

		/** @return {Uint8Array} */
		encode() {
			this.writeBigEndianLong(uuid.getLeastSignificantBits()); this.writeBigEndianLong(uuid.getMostSignificantBits());
			this.writeBigEndianDouble(amount);
			this.writeByte(operation);
		}

		/** @param {Uint8Array} buffer */
		decode(buffer) {
			if(!(buffer instanceof Uint8Array)) throw new TypeError('buffer is not a Uint8Array');
			return this;
		}

		/** @return {string} */
		toString() {
			return "Modifier(uuid: " + this.uuid + ", amount: " + this.amount + ", operation: " + this.operation + ")";
		}

	},

	Attribute: class {

		constructor(key="", value=.0, modifiers=[]) {
			this.key = key;
			this.value = value;
			this.modifiers = modifiers;
		}

		/** @return {Uint8Array} */
		encode() {
			this.writeString(key);
			this.writeBigEndianDouble(value);
			this.writeVaruint(modifiers.length); for(bw9kawzpzxjz in modifiers){ this.writeBytes(modifiers[bw9kawzpzxjz].encode()); }
		}

		/** @param {Uint8Array} buffer */
		decode(buffer) {
			if(!(buffer instanceof Uint8Array)) throw new TypeError('buffer is not a Uint8Array');
			return this;
		}

		/** @return {string} */
		toString() {
			return "Attribute(key: " + this.key + ", value: " + this.value + ", modifiers: " + this.modifiers + ")";
		}

	},

	OptionalPosition: class {

		constructor(hasPosition=false, position=0) {
			this.hasPosition = hasPosition;
			this.position = position;
		}

		/** @return {Uint8Array} */
		encode() {
			this.writeBool(hasPosition);
			this.writeBigEndianLong(position);
		}

		/** @param {Uint8Array} buffer */
		decode(buffer) {
			if(!(buffer instanceof Uint8Array)) throw new TypeError('buffer is not a Uint8Array');
			return this;
		}

		/** @return {string} */
		toString() {
			return "OptionalPosition(hasPosition: " + this.hasPosition + ", position: " + this.position + ")";
		}

	},

	OptionalUuid: class {

		constructor(hasUuid=false, uuid=new Uint8Array(16)) {
			this.hasUuid = hasUuid;
			this.uuid = uuid;
		}

		/** @return {Uint8Array} */
		encode() {
			this.writeBool(hasUuid);
			this.writeBigEndianLong(uuid.getLeastSignificantBits()); this.writeBigEndianLong(uuid.getMostSignificantBits());
		}

		/** @param {Uint8Array} buffer */
		decode(buffer) {
			if(!(buffer instanceof Uint8Array)) throw new TypeError('buffer is not a Uint8Array');
			return this;
		}

		/** @return {string} */
		toString() {
			return "OptionalUuid(hasUuid: " + this.hasUuid + ", uuid: " + this.uuid + ")";
		}

	}

}

export { Types }
