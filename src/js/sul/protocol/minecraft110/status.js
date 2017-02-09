/*
 * This file was automatically generated by sel-utils and
 * released under the GNU General Public License version 3.
 *
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/minecraft110.xml
 */
/** @module sul/protocol/minecraft110/status */

//import Types from 'types';

const Status = {

	Handshake: class {

		static get ID(){ return 0; }

		static get CLIENTBOUND(){ return false; }
		static get SERVERBOUND(){ return true; }

		// next
		static get STATUS(){ return 1; }
		static get LOGIN(){ return 2; }

		constructor(protocol=0, serverAddress="", serverPort=0, next=0) {
			this.protocol = protocol;
			this.serverAddress = serverAddress;
			this.serverPort = serverPort;
			this.next = next;
		}

		/** @return {Uint8Array} */
		encode() {
			this.writeVaruint(this.ID);
			this.writeVaruint(protocol);
			this.writeString(serverAddress);
			this.writeBigEndianShort(serverPort);
			this.writeVaruint(next);
		}

		/** @param {Uint8Array} buffer */
		decode(buffer) {
			if(!(buffer instanceof Uint8Array)) throw new TypeError('buffer is not a Uint8Array');
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

	Request: class {

		static get ID(){ return 0; }

		static get CLIENTBOUND(){ return false; }
		static get SERVERBOUND(){ return true; }

		constructor() {
		}

		/** @return {Uint8Array} */
		encode() {
			this.writeVaruint(this.ID);
		}

		/** @param {Uint8Array} buffer */
		decode(buffer) {
			if(!(buffer instanceof Uint8Array)) throw new TypeError('buffer is not a Uint8Array');
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

	Response: class {

		static get ID(){ return 0; }

		static get CLIENTBOUND(){ return true; }
		static get SERVERBOUND(){ return false; }

		constructor(json="") {
			this.json = json;
		}

		/** @return {Uint8Array} */
		encode() {
			this.writeVaruint(this.ID);
			this.writeString(json);
		}

		/** @param {Uint8Array} buffer */
		decode(buffer) {
			if(!(buffer instanceof Uint8Array)) throw new TypeError('buffer is not a Uint8Array');
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

	Latency: class {

		static get ID(){ return 1; }

		static get CLIENTBOUND(){ return true; }
		static get SERVERBOUND(){ return true; }

		constructor(id=0) {
			this.id = id;
		}

		/** @return {Uint8Array} */
		encode() {
			this.writeVaruint(this.ID);
			this.writeBigEndianLong(id);
		}

		/** @param {Uint8Array} buffer */
		decode(buffer) {
			if(!(buffer instanceof Uint8Array)) throw new TypeError('buffer is not a Uint8Array');
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
