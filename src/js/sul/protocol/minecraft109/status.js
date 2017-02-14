/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft109.xml
 */
/** @module sul/protocol/minecraft109/status */

//import Types from 'types';

const Status = {

	Handshake: class extends Buffer {

		static get ID(){ return 0; }

		static get CLIENTBOUND(){ return false; }
		static get SERVERBOUND(){ return true; }

		// next
		static get STATUS(){ return 1; }
		static get LOGIN(){ return 2; }

		constructor(protocol=0, serverAddress="", serverPort=0, next=0) {
			super();
			this.protocol = protocol;
			this.serverAddress = serverAddress;
			this.serverPort = serverPort;
			this.next = next;
		}

		/** @return {Uint8Array} */
		encode() {
			this._buffer = [];
			this.writeVaruint(0);
			this.writeVaruint(this.protocol);
			var dghpcy5zzxj2zxjb=this.encodeString(this.serverAddress); this.writeVaruint(dghpcy5zzxj2zxjb.length); this.writeBytes(dghpcy5zzxj2zxjb);
			this.writeBigEndianShort(this.serverPort);
			this.writeVaruint(this.next);
			return new Uint8Array(this._buffer);
		}

		/** @param {Uint8Array}|{Array} buffer */
		decode(_buffer) {
			this._buffer = Array.from(_buffer);
			this._index = 0;
			var _id=this.readVaruint();
			this.protocol=this.readVaruint();
			this.serverAddress=this.decodeString(this.readBytes(this.readVaruint()));
			this.serverPort=this.readBigEndianShort();
			this.next=this.readVaruint();
			return this;
		}

		static fromBuffer(buffer) {
			return new Status.Handshake().decode(buffer);
		}

		/** @return {string} */
		toString() {
			return "Handshake(protocol: " + this.protocol + ", serverAddress: " + this.serverAddress + ", serverPort: " + this.serverPort + ", next: " + this.next + ")";
		}

	},

	Request: class extends Buffer {

		static get ID(){ return 0; }

		static get CLIENTBOUND(){ return false; }
		static get SERVERBOUND(){ return true; }

		constructor() {
			super();
		}

		/** @return {Uint8Array} */
		encode() {
			this._buffer = [];
			this.writeVaruint(0);
			return new Uint8Array(this._buffer);
		}

		/** @param {Uint8Array}|{Array} buffer */
		decode(_buffer) {
			this._buffer = Array.from(_buffer);
			this._index = 0;
			var _id=this.readVaruint();
			return this;
		}

		static fromBuffer(buffer) {
			return new Status.Request().decode(buffer);
		}

		/** @return {string} */
		toString() {
			return "Request()";
		}

	},

	Response: class extends Buffer {

		static get ID(){ return 0; }

		static get CLIENTBOUND(){ return true; }
		static get SERVERBOUND(){ return false; }

		constructor(json="") {
			super();
			this.json = json;
		}

		/** @return {Uint8Array} */
		encode() {
			this._buffer = [];
			this.writeVaruint(0);
			var dghpcy5qc29u=this.encodeString(this.json); this.writeVaruint(dghpcy5qc29u.length); this.writeBytes(dghpcy5qc29u);
			return new Uint8Array(this._buffer);
		}

		/** @param {Uint8Array}|{Array} buffer */
		decode(_buffer) {
			this._buffer = Array.from(_buffer);
			this._index = 0;
			var _id=this.readVaruint();
			this.json=this.decodeString(this.readBytes(this.readVaruint()));
			return this;
		}

		static fromBuffer(buffer) {
			return new Status.Response().decode(buffer);
		}

		/** @return {string} */
		toString() {
			return "Response(json: " + this.json + ")";
		}

	},

	Latency: class extends Buffer {

		static get ID(){ return 1; }

		static get CLIENTBOUND(){ return true; }
		static get SERVERBOUND(){ return true; }

		constructor(id=0) {
			super();
			this.id = id;
		}

		/** @return {Uint8Array} */
		encode() {
			this._buffer = [];
			this.writeVaruint(1);
			this.writeBigEndianLong(this.id);
			return new Uint8Array(this._buffer);
		}

		/** @param {Uint8Array}|{Array} buffer */
		decode(_buffer) {
			this._buffer = Array.from(_buffer);
			this._index = 0;
			var _id=this.readVaruint();
			this.id=this.readBigEndianLong();
			return this;
		}

		static fromBuffer(buffer) {
			return new Status.Latency().decode(buffer);
		}

		/** @return {string} */
		toString() {
			return "Latency(id: " + this.id + ")";
		}

	},

}

//export { Status };
