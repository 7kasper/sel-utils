/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft109.xml
 */
/** @module sul/protocol/minecraft109/types */

const Types = {

	Statistic: class extends Buffer {

		constructor(name="", value=0) {
			super();
			this.name = name;
			this.value = value;
		}

		/** @return {Uint8Array} */
		encode() {
			this._buffer = [];
			var dghpcy5uyw1l=this.encodeString(this.name); this.writeVaruint(dghpcy5uyw1l.length); this.writeBytes(dghpcy5uyw1l);
			this.writeVaruint(this.value);
			return new Uint8Array(this._buffer);
		}

		/** @param {Uint8Array}|{Array} buffer */
		decode(_buffer) {
			this._buffer = Array.from(_buffer);
			this._index = 0;
			this.name=this.decodeString(this.readBytes(this.readVaruint()));
			this.value=this.readVaruint();
			return this;
		}

		static fromBuffer(buffer) {
			return new Types.Statistic().decode(buffer);
		}

		/** @return {string} */
		toString() {
			return "Statistic(name: " + this.name + ", value: " + this.value + ")";
		}

	},

	BlockChange: class extends Buffer {

		constructor(xz=0, y=0, block=0) {
			super();
			this.xz = xz;
			this.y = y;
			this.block = block;
		}

		/** @return {Uint8Array} */
		encode() {
			this._buffer = [];
			this.writeBigEndianByte(this.xz);
			this.writeBigEndianByte(this.y);
			this.writeVaruint(this.block);
			return new Uint8Array(this._buffer);
		}

		/** @param {Uint8Array}|{Array} buffer */
		decode(_buffer) {
			this._buffer = Array.from(_buffer);
			this._index = 0;
			this.xz=this.readBigEndianByte();
			this.y=this.readBigEndianByte();
			this.block=this.readVaruint();
			return this;
		}

		static fromBuffer(buffer) {
			return new Types.BlockChange().decode(buffer);
		}

		/** @return {string} */
		toString() {
			return "BlockChange(xz: " + this.xz + ", y: " + this.y + ", block: " + this.block + ")";
		}

	},

	Slot: class extends Buffer {

		constructor(id=0, count=0, damage=0, nbt=null) {
			super();
			this.id = id;
			this.count = count;
			this.damage = damage;
			this.nbt = nbt;
		}

		/** @return {Uint8Array} */
		encode() {
			this._buffer = [];
			this.writeBigEndianShort(this.id);
			if(id>0){ this.writeBigEndianByte(this.count); }
			if(id>0){ this.writeBigEndianShort(this.damage); }
			if(id>0){ this.writeBytes(this.nbt); }
			return new Uint8Array(this._buffer);
		}

		/** @param {Uint8Array}|{Array} buffer */
		decode(_buffer) {
			this._buffer = Array.from(_buffer);
			this._index = 0;
			this.id=this.readBigEndianShort();
			if(id>0){ this.count=this.readBigEndianByte(); }
			if(id>0){ this.damage=this.readBigEndianShort(); }
			if(id>0){ this.nbt=this.readBytes(this._buffer.length-this._index); }
			return this;
		}

		static fromBuffer(buffer) {
			return new Types.Slot().decode(buffer);
		}

		/** @return {string} */
		toString() {
			return "Slot(id: " + this.id + ", count: " + this.count + ", damage: " + this.damage + ", nbt: " + this.nbt + ")";
		}

	},

	Icon: class extends Buffer {

		// direction and type
		static get WHITE_ARROW(){ return 0; }
		static get GREEN_ARROW(){ return 1; }
		static get RED_ARROW(){ return 2; }
		static get BLUE_ARROW(){ return 3; }
		static get WHITE_CROSS(){ return 4; }
		static get RED_POINTER(){ return 5; }
		static get WHITE_CIRCLE(){ return 6; }

		constructor(directionAndType=0, position={x:0,z:0}) {
			super();
			this.directionAndType = directionAndType;
			this.position = position;
		}

		/** @return {Uint8Array} */
		encode() {
			this._buffer = [];
			this.writeBigEndianByte(this.directionAndType);
			this.writeBigEndianByte(this.position.x); this.writeBigEndianByte(this.position.z);
			return new Uint8Array(this._buffer);
		}

		/** @param {Uint8Array}|{Array} buffer */
		decode(_buffer) {
			this._buffer = Array.from(_buffer);
			this._index = 0;
			this.directionAndType=this.readBigEndianByte();
			this.position={} this.position.x=this.readBigEndianByte(); this.position.z=this.readBigEndianByte();
			return this;
		}

		static fromBuffer(buffer) {
			return new Types.Icon().decode(buffer);
		}

		/** @return {string} */
		toString() {
			return "Icon(directionAndType: " + this.directionAndType + ", position: " + this.position + ")";
		}

	},

	Property: class extends Buffer {

		constructor(name="", value="", signed=false, signature="") {
			super();
			this.name = name;
			this.value = value;
			this.signed = signed;
			this.signature = signature;
		}

		/** @return {Uint8Array} */
		encode() {
			this._buffer = [];
			var dghpcy5uyw1l=this.encodeString(this.name); this.writeVaruint(dghpcy5uyw1l.length); this.writeBytes(dghpcy5uyw1l);
			var dghpcy52ywx1zq=this.encodeString(this.value); this.writeVaruint(dghpcy52ywx1zq.length); this.writeBytes(dghpcy52ywx1zq);
			this.writeBigEndianByte(this.signed?1:0);
			if(signed==true){ var dghpcy5zawduyxr1=this.encodeString(this.signature); this.writeVaruint(dghpcy5zawduyxr1.length); this.writeBytes(dghpcy5zawduyxr1); }
			return new Uint8Array(this._buffer);
		}

		/** @param {Uint8Array}|{Array} buffer */
		decode(_buffer) {
			this._buffer = Array.from(_buffer);
			this._index = 0;
			this.name=this.decodeString(this.readBytes(this.readVaruint()));
			this.value=this.decodeString(this.readBytes(this.readVaruint()));
			this.signed=this.readBigEndianByte()!==0;
			if(signed==true){ this.signature=this.decodeString(this.readBytes(this.readVaruint())); }
			return this;
		}

		static fromBuffer(buffer) {
			return new Types.Property().decode(buffer);
		}

		/** @return {string} */
		toString() {
			return "Property(name: " + this.name + ", value: " + this.value + ", signed: " + this.signed + ", signature: " + this.signature + ")";
		}

	},

	ListAddPlayer: class extends Buffer {

		// gamemode
		static get SURVIVAL(){ return 0; }
		static get CREATIVE(){ return 1; }
		static get ADVENTURE(){ return 2; }
		static get SPECTATOR(){ return 3; }

		constructor(uuid=new Uint8Array(16), name="", properties=[], gamemode=0, latency=0, hasDisplayName=false, displayName="") {
			super();
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
			this._buffer = [];
			this.writeBytes(this.uuid);
			var dghpcy5uyw1l=this.encodeString(this.name); this.writeVaruint(dghpcy5uyw1l.length); this.writeBytes(dghpcy5uyw1l);
			this.writeVaruint(this.properties.length); for(var dghpcy5wcm9wzxj0 in this.properties){ this.writeBytes(this.properties[dghpcy5wcm9wzxj0].encode()); }
			this.writeVaruint(this.gamemode);
			this.writeVaruint(this.latency);
			this.writeBigEndianByte(this.hasDisplayName?1:0);
			if(hasDisplayName==true){ var dghpcy5kaxnwbgf5=this.encodeString(this.displayName); this.writeVaruint(dghpcy5kaxnwbgf5.length); this.writeBytes(dghpcy5kaxnwbgf5); }
			return new Uint8Array(this._buffer);
		}

		/** @param {Uint8Array}|{Array} buffer */
		decode(_buffer) {
			this._buffer = Array.from(_buffer);
			this._index = 0;
			this.uuid=this.readBytes(16);
			this.name=this.decodeString(this.readBytes(this.readVaruint()));
			var bhroaxmuchjvcgvy=this.readVaruint(); this.properties=[]; for(var dghpcy5wcm9wzxj0 in this.properties){ this.properties[dghpcy5wcm9wzxj0]=Types.Property.fromBuffer(this._buffer.slice(this._index)); this._index+=this.properties[dghpcy5wcm9wzxj0]._index; }
			this.gamemode=this.readVaruint();
			this.latency=this.readVaruint();
			this.hasDisplayName=this.readBigEndianByte()!==0;
			if(hasDisplayName==true){ this.displayName=this.decodeString(this.readBytes(this.readVaruint())); }
			return this;
		}

		static fromBuffer(buffer) {
			return new Types.ListAddPlayer().decode(buffer);
		}

		/** @return {string} */
		toString() {
			return "ListAddPlayer(uuid: " + this.uuid + ", name: " + this.name + ", properties: " + this.properties + ", gamemode: " + this.gamemode + ", latency: " + this.latency + ", hasDisplayName: " + this.hasDisplayName + ", displayName: " + this.displayName + ")";
		}

	},

	ListUpdateGamemode: class extends Buffer {

		// gamemode
		static get SURVIVAL(){ return 0; }
		static get CREATIVE(){ return 1; }
		static get ADVENTURE(){ return 2; }
		static get SPECTATOR(){ return 3; }

		constructor(uuid=new Uint8Array(16), gamemode=0) {
			super();
			this.uuid = uuid;
			this.gamemode = gamemode;
		}

		/** @return {Uint8Array} */
		encode() {
			this._buffer = [];
			this.writeBytes(this.uuid);
			this.writeVaruint(this.gamemode);
			return new Uint8Array(this._buffer);
		}

		/** @param {Uint8Array}|{Array} buffer */
		decode(_buffer) {
			this._buffer = Array.from(_buffer);
			this._index = 0;
			this.uuid=this.readBytes(16);
			this.gamemode=this.readVaruint();
			return this;
		}

		static fromBuffer(buffer) {
			return new Types.ListUpdateGamemode().decode(buffer);
		}

		/** @return {string} */
		toString() {
			return "ListUpdateGamemode(uuid: " + this.uuid + ", gamemode: " + this.gamemode + ")";
		}

	},

	ListUpdateLatency: class extends Buffer {

		constructor(uuid=new Uint8Array(16), latency=0) {
			super();
			this.uuid = uuid;
			this.latency = latency;
		}

		/** @return {Uint8Array} */
		encode() {
			this._buffer = [];
			this.writeBytes(this.uuid);
			this.writeVaruint(this.latency);
			return new Uint8Array(this._buffer);
		}

		/** @param {Uint8Array}|{Array} buffer */
		decode(_buffer) {
			this._buffer = Array.from(_buffer);
			this._index = 0;
			this.uuid=this.readBytes(16);
			this.latency=this.readVaruint();
			return this;
		}

		static fromBuffer(buffer) {
			return new Types.ListUpdateLatency().decode(buffer);
		}

		/** @return {string} */
		toString() {
			return "ListUpdateLatency(uuid: " + this.uuid + ", latency: " + this.latency + ")";
		}

	},

	ListUpdateDisplayName: class extends Buffer {

		constructor(uuid=new Uint8Array(16), hasDisplayName=false, displayName="") {
			super();
			this.uuid = uuid;
			this.hasDisplayName = hasDisplayName;
			this.displayName = displayName;
		}

		/** @return {Uint8Array} */
		encode() {
			this._buffer = [];
			this.writeBytes(this.uuid);
			this.writeBigEndianByte(this.hasDisplayName?1:0);
			if(hasDisplayName==true){ var dghpcy5kaxnwbgf5=this.encodeString(this.displayName); this.writeVaruint(dghpcy5kaxnwbgf5.length); this.writeBytes(dghpcy5kaxnwbgf5); }
			return new Uint8Array(this._buffer);
		}

		/** @param {Uint8Array}|{Array} buffer */
		decode(_buffer) {
			this._buffer = Array.from(_buffer);
			this._index = 0;
			this.uuid=this.readBytes(16);
			this.hasDisplayName=this.readBigEndianByte()!==0;
			if(hasDisplayName==true){ this.displayName=this.decodeString(this.readBytes(this.readVaruint())); }
			return this;
		}

		static fromBuffer(buffer) {
			return new Types.ListUpdateDisplayName().decode(buffer);
		}

		/** @return {string} */
		toString() {
			return "ListUpdateDisplayName(uuid: " + this.uuid + ", hasDisplayName: " + this.hasDisplayName + ", displayName: " + this.displayName + ")";
		}

	},

	Modifier: class extends Buffer {

		// operation
		static get ADD_SUBSTRACT_AMOUNT(){ return 0; }
		static get ADD_SUBSTRACT_AMOUNT_PERCENTAGE(){ return 1; }
		static get MULTIPLY_AMOUNT_PERCENTAGE(){ return 2; }

		constructor(uuid=new Uint8Array(16), amount=.0, operation=0) {
			super();
			this.uuid = uuid;
			this.amount = amount;
			this.operation = operation;
		}

		/** @return {Uint8Array} */
		encode() {
			this._buffer = [];
			this.writeBytes(this.uuid);
			this.writeBigEndianDouble(this.amount);
			this.writeBigEndianByte(this.operation);
			return new Uint8Array(this._buffer);
		}

		/** @param {Uint8Array}|{Array} buffer */
		decode(_buffer) {
			this._buffer = Array.from(_buffer);
			this._index = 0;
			this.uuid=this.readBytes(16);
			this.amount=this.readBigEndianDouble();
			this.operation=this.readBigEndianByte();
			return this;
		}

		static fromBuffer(buffer) {
			return new Types.Modifier().decode(buffer);
		}

		/** @return {string} */
		toString() {
			return "Modifier(uuid: " + this.uuid + ", amount: " + this.amount + ", operation: " + this.operation + ")";
		}

	},

	Attribute: class extends Buffer {

		constructor(key="", value=.0, modifiers=[]) {
			super();
			this.key = key;
			this.value = value;
			this.modifiers = modifiers;
		}

		/** @return {Uint8Array} */
		encode() {
			this._buffer = [];
			var dghpcy5rzxk=this.encodeString(this.key); this.writeVaruint(dghpcy5rzxk.length); this.writeBytes(dghpcy5rzxk);
			this.writeBigEndianDouble(this.value);
			this.writeVaruint(this.modifiers.length); for(var dghpcy5tb2rpzmll in this.modifiers){ this.writeBytes(this.modifiers[dghpcy5tb2rpzmll].encode()); }
			return new Uint8Array(this._buffer);
		}

		/** @param {Uint8Array}|{Array} buffer */
		decode(_buffer) {
			this._buffer = Array.from(_buffer);
			this._index = 0;
			this.key=this.decodeString(this.readBytes(this.readVaruint()));
			this.value=this.readBigEndianDouble();
			var bhroaxmubw9kawzp=this.readVaruint(); this.modifiers=[]; for(var dghpcy5tb2rpzmll in this.modifiers){ this.modifiers[dghpcy5tb2rpzmll]=Types.Modifier.fromBuffer(this._buffer.slice(this._index)); this._index+=this.modifiers[dghpcy5tb2rpzmll]._index; }
			return this;
		}

		static fromBuffer(buffer) {
			return new Types.Attribute().decode(buffer);
		}

		/** @return {string} */
		toString() {
			return "Attribute(key: " + this.key + ", value: " + this.value + ", modifiers: " + this.modifiers + ")";
		}

	},

	OptionalPosition: class extends Buffer {

		constructor(hasPosition=false, position=0) {
			super();
			this.hasPosition = hasPosition;
			this.position = position;
		}

		/** @return {Uint8Array} */
		encode() {
			this._buffer = [];
			this.writeBigEndianByte(this.hasPosition?1:0);
			if(hasPosition==true){ this.writeBigEndianLong(this.position); }
			return new Uint8Array(this._buffer);
		}

		/** @param {Uint8Array}|{Array} buffer */
		decode(_buffer) {
			this._buffer = Array.from(_buffer);
			this._index = 0;
			this.hasPosition=this.readBigEndianByte()!==0;
			if(hasPosition==true){ this.position=this.readBigEndianLong(); }
			return this;
		}

		static fromBuffer(buffer) {
			return new Types.OptionalPosition().decode(buffer);
		}

		/** @return {string} */
		toString() {
			return "OptionalPosition(hasPosition: " + this.hasPosition + ", position: " + this.position + ")";
		}

	},

	OptionalUuid: class extends Buffer {

		constructor(hasUuid=false, uuid=new Uint8Array(16)) {
			super();
			this.hasUuid = hasUuid;
			this.uuid = uuid;
		}

		/** @return {Uint8Array} */
		encode() {
			this._buffer = [];
			this.writeBigEndianByte(this.hasUuid?1:0);
			this.writeBytes(this.uuid);
			return new Uint8Array(this._buffer);
		}

		/** @param {Uint8Array}|{Array} buffer */
		decode(_buffer) {
			this._buffer = Array.from(_buffer);
			this._index = 0;
			this.hasUuid=this.readBigEndianByte()!==0;
			this.uuid=this.readBytes(16);
			return this;
		}

		static fromBuffer(buffer) {
			return new Types.OptionalUuid().decode(buffer);
		}

		/** @return {string} */
		toString() {
			return "OptionalUuid(hasUuid: " + this.hasUuid + ", uuid: " + this.uuid + ")";
		}

	}

}

//export { Types }
