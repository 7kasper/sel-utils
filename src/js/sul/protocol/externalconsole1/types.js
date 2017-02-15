/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/externalconsole1.xml
 */
/** @module sul/protocol/externalconsole1/types */

const Types = {

	Game: class extends Buffer {

		// type
		static get POCKET(){ return 1; }
		static get MINECRAFT(){ return 2; }

		/**
		 * @param type
		 *        Variant of the game.
		 * @param protocols
		 *        List of protocols supported by the server for the indicated game.
		 */
		constructor(type=0, protocols=[]) {
			super();
			this.type = type;
			this.protocols = protocols;
		}

		/** @return {Uint8Array} */
		encode() {
			this._buffer = [];
			this.writeBigEndianByte(this.type);
			this.writeBigEndianShort(this.protocols.length); for(var dghpcy5wcm90b2nv in this.protocols){ this.writeBigEndianInt(this.protocols[dghpcy5wcm90b2nv]); }
			return new Uint8Array(this._buffer);
		}

		/** @param {(Uint8Array|Array)} buffer */
		decode(_buffer) {
			this._buffer = Array.from(_buffer);
			this._index = 0;
			this.type=this.readBigEndianByte();
			var bhroaxmuchjvdg9j=this.readBigEndianShort(); this.protocols=[]; for(var dghpcy5wcm90b2nv in this.protocols){ this.protocols[dghpcy5wcm90b2nv]=this.readBigEndianInt(); }
			return this;
		}

		/** @param {(Uint8Array|Array)} buffer */
		static fromBuffer(buffer) {
			return new Types.Game().decode(buffer);
		}

		/** @return {string} */
		toString() {
			return "Game(type: " + this.type + ", protocols: " + this.protocols + ")";
		}

	},

	NodeStats: class extends Buffer {

		/**
		 * @param name
		 *        Name of the node. Should match one of the names given in {Welcome.Accepted.connectedNodes} or
		 *        one added using the {UpdateNodes} packet.
		 *        If the server isn't built on the hub-node layout the name is an empty string and the following values
		 *        are for the whole server and not for a node.
		 * @param tps
		 *        Ticks per second of the node in range 0 to 20. If the value is less than 20, the server is lagging.
		 * @param ram
		 *        RAM allocated by the node in bytes.
		 *        If the value is 0 the node couldn't retrieve the amount of memory allocated by its process.
		 * @param cpu
		 *        Percentage of CPU used by the node. The value can be higher than 100 when the machine where the node
		 *        is running has more than one CPU.
		 *        If the value is `not a number` the node couldn't retrieve the amount of CPU used by its process.
		 */
		constructor(name="", tps=.0, ram=0, cpu=.0) {
			super();
			this.name = name;
			this.tps = tps;
			this.ram = ram;
			this.cpu = cpu;
		}

		/** @return {Uint8Array} */
		encode() {
			this._buffer = [];
			var dghpcy5uyw1l=this.encodeString(this.name); this.writeBigEndianShort(dghpcy5uyw1l.length); this.writeBytes(dghpcy5uyw1l);
			this.writeBigEndianFloat(this.tps);
			this.writeBigEndianLong(this.ram);
			this.writeBigEndianFloat(this.cpu);
			return new Uint8Array(this._buffer);
		}

		/** @param {(Uint8Array|Array)} buffer */
		decode(_buffer) {
			this._buffer = Array.from(_buffer);
			this._index = 0;
			this.name=this.decodeString(this.readBytes(this.readBigEndianShort()));
			this.tps=this.readBigEndianFloat();
			this.ram=this.readBigEndianLong();
			this.cpu=this.readBigEndianFloat();
			return this;
		}

		/** @param {(Uint8Array|Array)} buffer */
		static fromBuffer(buffer) {
			return new Types.NodeStats().decode(buffer);
		}

		/** @return {string} */
		toString() {
			return "NodeStats(name: " + this.name + ", tps: " + this.tps + ", ram: " + this.ram + ", cpu: " + this.cpu + ")";
		}

	}

}

//export { Types }
